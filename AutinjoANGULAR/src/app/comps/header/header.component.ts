import { Component, OnInit } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';
import { Korisnik } from 'src/app/model/korisnik';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  public loggedIn: boolean;
  public loggedInUser: Korisnik = this.authService.loggedInUser;

  constructor(private authService: AuthService) { }

  ngOnInit(): void {
    this.loggedIn = this.authService.loggedIn;
  }

  logout() {
    this.authService.logout();
    this.loggedIn = this.authService.loggedIn;
  }

}
