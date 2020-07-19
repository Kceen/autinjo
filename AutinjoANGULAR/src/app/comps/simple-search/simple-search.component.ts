import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { ApiService } from 'src/app/services/api.service';

@Component({
  selector: 'app-simple-search',
  templateUrl: './simple-search.component.html',
  styleUrls: ['./simple-search.component.css']
})
export class SimpleSearchComponent implements OnInit {
  allBrands: string[];
  allModelOptions: any;
  @Output() searchEmitter = new EventEmitter<any>();

  constructor(private apiService: ApiService) { }

  ngOnInit(): void {
    this.apiService.getAllBrands().subscribe(allBrands => this.allBrands = allBrands);
  }

  onChange(select) {
    if(select.value == "Audi") {
      this.allModelOptions = document.getElementById("model").children;
      
      for(let model in this.allModelOptions) {
        console.log(model); 
      }
    }
  }

  onSubmit(form) {
    console.log(form.value);

    this.searchEmitter.emit(form)
  }


}
