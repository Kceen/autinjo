import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Router } from '@angular/router';
import { Korisnik } from '../model/korisnik';
import { ApiService } from './api.service';
import { Subject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  public loginSource = new Subject<any>();
  loginSource$ = this.loginSource.asObservable();

  public authToken: string;
  public loginAttempt: boolean = false;
  public loggedIn: boolean = false;
  public loggedInUser: Korisnik;

  constructor(private http: HttpClient, private router: Router, private apiService: ApiService) { }

  announceLoginStatus(loginStatus: any) {
    this.loginSource.next(loginStatus);
  }

  register(korisnik: Korisnik): any {
    return this.http.post("/autinjo/restAuto/register", korisnik);
  }

  login(username, password) {
    const opts = {
      headers: new HttpHeaders({
        "Username": username,
        "Password": password
      })
    }
    console.log("LOGIN REQUEST SENT");
    
    this.http.get<any>("/autinjo/restAuto/auth", opts).subscribe(loginStatus => {
      if (loginStatus.token != 0) {
        this.announceLoginStatus(loginStatus.success)
        this.authToken = loginStatus.token;
        this.apiService.getKorisnik(loginStatus.idKorisnik).subscribe(loggedInUser => { this.loggedInUser = loggedInUser[0] });
        this.loggedIn = true;
        localStorage.setItem("loggedIn", "true");
        this.router.navigate(['']);
      }
      else {
        this.announceLoginStatus(loginStatus.success);
      }
    })
    
    /*return this.http.get<any>("/autinjo/restAuto/auth", opts).subscribe(resp => {
      if (resp.token != 0) {
        this.authToken = resp.token;
        this.loginAttempt = false;
        this.loggedIn = true;
        this.apiService.getKorisnik(resp.idKorisnik).subscribe(loggedInUser => { this.loggedInUser = loggedInUser[0] });
        this.router.navigate(['']);
      }
      else {
        this.loginAttempt = true;
        
      }
      console.log(this.authToken);
     
      
    });*/
  }

logout() {
  this.announceLoginStatus(false)

  this.authToken = null;
  this.loggedIn = false;
  this.loggedInUser = null;
  localStorage.removeItem("loggedIn");
  this.router.navigate(['']);
}

}
