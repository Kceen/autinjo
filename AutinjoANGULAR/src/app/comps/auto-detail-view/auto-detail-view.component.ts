import { Component, OnInit } from '@angular/core';
import { Auto } from 'src/app/model/auto';
import { ActivatedRoute } from '@angular/router';
import { ApiService } from 'src/app/services/api.service';

@Component({
  selector: 'app-auto-detail-view',
  templateUrl: './auto-detail-view.component.html',
  styleUrls: ['./auto-detail-view.component.css']
})
export class AutoDetailViewComponent implements OnInit {
  autos: Auto[] = [];
  idAuto: number;
  karakteristikeArray: string[] = [];
  

  constructor(private activatedroute: ActivatedRoute, private apiService: ApiService) { 
    this.activatedroute.params.subscribe(idAuto => { this.idAuto = idAuto.id });
    this.apiService.getSingleAuto(this.idAuto).subscribe(auto => { 
      this.autos.push(auto[0])
      this.karakteristikeArray = auto[0].karakteristike.split(",")
    })
  }

  ngOnInit(): void {
    
  }

}
