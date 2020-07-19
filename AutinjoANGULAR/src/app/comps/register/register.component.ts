import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { Korisnik } from 'src/app/model/korisnik';
import { AuthService } from 'src/app/services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  public form;

  constructor(private authService: AuthService, private router: Router) { }

  ngOnInit(): void {
  }

  onSubmit(form: NgForm) {
    let username = form.value.username;
    let password = form.value.password;
    let ime = form.value.ime;
    let brojTelefona = form.value.brojTelefona;
    let email = form.value.email;
    let lokacija = form.value.lokacija;
    
    let korisnik = new Korisnik(null, brojTelefona, email, ime, lokacija, username, password);

    this.authService.register(korisnik).subscribe(resp => { console.log(resp) })
    this.router.navigateByUrl("login");
    
    //this.authService.login(username, password);
    
  }

}
