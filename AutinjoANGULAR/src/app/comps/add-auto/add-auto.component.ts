import { Component, OnInit } from '@angular/core';
import { ApiService } from 'src/app/services/api.service';
import { Auto } from 'src/app/model/auto';
import { AuthService } from 'src/app/services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-auto',
  templateUrl: './add-auto.component.html',
  styleUrls: ['./add-auto.component.css']
})
export class AddAutoComponent implements OnInit {
  allBrands: string[];
  tooManyImagesMessage: string;
  
  constructor(private apiService: ApiService, private authService: AuthService, private router: Router) { }

  ngOnInit(): void {
    this.apiService.getAllBrands().subscribe(allBrands => this.allBrands = allBrands);
  }

  onSubmit(form) {
    let marka = form.value.marka;
    let model = form.value.model;
    let cena = form.value.cena;
    let godiste = form.value.godiste;
    let gorivo = form.value.gorivo;
    let stanje = form.value.stanje;
    let karoserija = form.value.karoserija;
    let zamena = form.value.zamena;
    let kilometraza = form.value.kilometraza;
    let kubikaza = form.value.kubikaza;
    let ks = form.value.ks;
    let fiksnaCena = form.value.fiksnaCena;
    let opis = form.value.opis;
    
    let sigurnost = "";
    // SIGURNOST CHECKBOXES
    let airbagVozac = form.value.airbagVozac;
    if(airbagVozac) {
      sigurnost = sigurnost + "Airbag za vozaca,"
    }

    let airbagSuvozac = form.value.airbagSuvozac;
    if(airbagSuvozac) {
      sigurnost = sigurnost + "Airbag za suvozaca,"
    }

    let bocniAirbag = form.value.bocniAirbag;
    if(bocniAirbag) {
      sigurnost = sigurnost + "Bocni airbag,"
    }
    
    let childLock = form.value.childLock;
    if(childLock) {
      sigurnost = sigurnost + "Child lock,"
    }

    let oprema = "";
    // OPREMA CHECKBOXES
    let navigacija = form.value.navigacija;
    if(navigacija) {
      oprema = oprema + "Navigacija,"
    }

    let bluetooth = form.value.bluetooth;
    if(bluetooth) {
      oprema = oprema + "Bluetooth,"
    }

    let elektricniProzori = form.value.elektricniProzori;
    if(elektricniProzori) {
      oprema = oprema + "Elektricni prozori,"
    }

    let naslonZaRuku = form.value.naslonZaRuku;
    if(naslonZaRuku) {
      oprema = oprema + "Naslon za ruku,"
    }

    let stanjeLista = "";
    // STANJE CHECKBOXES
    let prviVlasnik = form.value.prviVlasnik;
    if(prviVlasnik) {
      stanjeLista = stanjeLista + "Prvi vlasnik,"
    }

    let garaziran = form.value.garaziran;
    if(garaziran) {
      stanjeLista = stanjeLista + "Garaziran,"
    }

    let kupljenNovUSrbiji = form.value.kupljenNovUSrbiji;
    if(kupljenNovUSrbiji) {
      stanjeLista = stanjeLista + "Kupljen nov u Srbiji,"
    }

    let rezervniKljuc = form.value.rezervniKljuc;
    if(rezervniKljuc) {
      stanjeLista = stanjeLista + "Rezervni kljuc,"
    }
    
    console.log(form.value);
  
    let korisnik = this.authService.loggedInUser;

    let auto = new Auto(null, cena, new Date(), fiksnaCena, godiste, gorivo, null, karoserija, kilometraza, ks, kubikaza, marka, model, opis, oprema, sigurnost, stanje, stanjeLista, null, zamena, korisnik, null);
    this.apiService.addAuto(auto).subscribe(response => { console.log(response.text);
     })

     this.router.navigateByUrl("/add-images");
  }

}
