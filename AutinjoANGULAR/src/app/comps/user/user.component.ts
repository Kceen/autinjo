import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ApiService } from 'src/app/services/api.service';
import { Korisnik } from 'src/app/model/korisnik';
import { Observable, Subscription } from 'rxjs';
import { Auto } from 'src/app/model/auto';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {
  idKorisnik: number;
  korisnik$: Korisnik[] = [];
  korisnikAutos: Observable<Auto[]>;
  
  public loggedIn: boolean = false;
  public subscription: Subscription;

  constructor(private activatedroute: ActivatedRoute, private apiService: ApiService, private authService: AuthService) {
    this.activatedroute.params.subscribe(idKorisnik => { this.idKorisnik = idKorisnik.id})
    this.apiService.getKorisnik(this.idKorisnik).subscribe(korisnik => { this.korisnik$.push(korisnik[0]) });
    this.korisnikAutos = this.apiService.getAutosFromKorisnik(this.idKorisnik);
    /*this.subscription = authService.loginSource$.subscribe(
      loginStatus => {
        this.loggedIn = loginStatus;
    });*/
    this.loggedIn = this.authService.loggedIn;
  }

  ngOnInit(): void {
  }

}
