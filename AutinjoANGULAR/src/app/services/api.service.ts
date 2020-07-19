import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Auto } from '../model/auto';
import { Korisnik } from '../model/korisnik';
import { ActivatedRoute } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class ApiService {
  pageNumber: number;

  constructor(private http: HttpClient, private activatedroute: ActivatedRoute) {
    this.activatedroute.params.subscribe(pageNumber => { this.pageNumber = pageNumber.page
      console.log("API SERVICE = " + pageNumber.page);  
    }); 
    
  }

  getAutos(numberOfAutos): Observable<Auto[]> {
    return this.http.get<Auto[]>("/autinjo/restAuto/get?limit=" + numberOfAutos);
  }

  getSingleAuto(idAuto): Observable<Auto> {
    return this.http.get<Auto>("autinjo/restAuto/get?id=" + idAuto);
  }

  getRandom(): Observable<Auto> {
    return this.http.get<Auto>("autinjo/restAuto/get?random");
  }

  getAllBrands(): Observable<string[]> {
    return this.http.get<string[]>("autinjo/restAuto/getAllBrands");
  }

  getAutosWithLimitAndPage(limit, page): Observable<Auto[]> {
    //this.http.get<Auto[]>("/autinjo/restAuto/get?limit=" + limit + "&page=" + page, {observe:"response"})
    //.subscribe(resp => { localStorage.setItem("isLastPage", resp.headers.get("isLastPage")) });

    this.pageNumber = page;
    console.log("API SERVICE = " + this.pageNumber);
    
    return this.http.get<Auto[]>("/autinjo/restAuto/get?limit=" + limit + "&page=" + page);
  }

  getKorisnik(idKorisnik): Observable<Korisnik[]> {
    return this.http.get<Korisnik[]>("/autinjo/restAuto/getKorisnik?id=" + idKorisnik);
  }

  getAutosFromKorisnik(idKorisnik): Observable<Auto[]> {
    return this.http.get<Auto[]>("/autinjo/restAuto/getAutosFromKorisnik?id=" + idKorisnik);
  }

  searchSimple(marka, model, cenaOd, cenaDo, godisteOd, godisteDo, gorivo, stanje, karoserija, zamena, kilometrazaOd, kilometrazaDo, kubikazaOd, kubikazaDo, ksOd, ksDo, fiksnaCena): Observable<Auto[]> {
    return this.http.get<Auto[]>("/autinjo/restAuto/searchSimple?marka=" + marka + "&model=" + model + "&cenaOd=" + cenaOd + "&cenaDo=" + cenaDo + "&godisteOd=" + godisteOd + "&godisteDo=" + godisteDo + "&gorivo=" + gorivo + "&stanje=" + stanje + "&karoserija=" + karoserija + "&zamena=" + zamena + "&kilometrazaOd=" + kilometrazaOd + "&kilometrazaDo=" + kilometrazaDo + "&kubikazaOd=" + kubikazaOd + "&kubikazaDo=" + kubikazaDo + "&ksOd=" + ksOd + "&ksDo=" + ksDo + "&fiksnaCena=" + fiksnaCena);
  }

  addAuto(auto: Auto): any {
    console.log(auto);
    
    return this.http.post("/autinjo/restAuto/addAuto", auto);
  }

  uploadImage(image) {
    return this.http.post("/autinjo/restAuto/uploadImage", image);
  }

  uploadThumbnail(image) {
    const headers = new HttpHeaders()
            .set("thumbnail", "thumbnail");

    return this.http.post("/autinjo/restAuto/uploadImage", image, {headers});
  }

}
