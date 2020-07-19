import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Auto } from 'src/app/model/auto';
import { ApiService } from 'src/app/services/api.service';

@Component({
  selector: 'app-cars-grid',
  templateUrl: './cars-grid.component.html',
  styleUrls: ['./cars-grid.component.css']
})
export class CarsGridComponent implements OnInit {
  autos: Observable<Auto[]>

  constructor(private apiService: ApiService) { }

  
  ngOnInit(): void {
    this.autos = this.apiService.getAutosWithLimitAndPage(12, 0);
  }

  getAutos($event) {
    this.autos = this.apiService.getAutosWithLimitAndPage(12, $event);
  }

  search($event) {
    let marka = $event.value.marka;
    let model = $event.value.model;
    let cenaOd = $event.value.cenaOd;
    let cenaDo = $event.value.cenaDo;
    let godisteOd = $event.value.godisteOd;
    let godisteDo = $event.value.godisteDo;
    let gorivo = $event.value.gorivo;
    let stanje = $event.value.stanje;
    let karoserija = $event.value.karoserija;
    let zamena = $event.value.zamena;
    let kilometrazaOd = $event.value.kilometrazaOd;
    let kilometrazaDo = $event.value.kilometrazaDo;
    let kubikazaOd = $event.value.kubikazaOd;
    let kubikazaDo = $event.value.kubikazaDo;
    let ksOd = $event.value.ksOd;
    let ksDo = $event.value.ksDo;
    let fiksnaCena = $event.value.fiksnaCena;


    this.autos = this.apiService.searchSimple(marka, model, cenaOd, cenaDo, godisteOd, godisteDo, gorivo, stanje, karoserija, zamena, kilometrazaOd, kilometrazaDo, kubikazaOd, kubikazaDo, ksOd, ksDo, fiksnaCena);
  }

}
