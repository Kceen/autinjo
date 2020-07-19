import { Component, OnInit, EventEmitter, Output } from '@angular/core';
import { ApiService } from 'src/app/services/api.service';

@Component({
  selector: 'app-detail-search',
  templateUrl: './detail-search.component.html',
  styleUrls: ['./detail-search.component.css']
})
export class DetailSearchComponent implements OnInit {
  allBrands: string[];
  @Output() searchEmitter = new EventEmitter<any>();

  constructor(private apiService: ApiService) { }

  ngOnInit(): void {
    this.apiService.getAllBrands().subscribe(allBrands => this.allBrands = allBrands);
  }

  onSubmit(form) {
    console.log(form.value);

    this.searchEmitter.emit(form)
  }

}
