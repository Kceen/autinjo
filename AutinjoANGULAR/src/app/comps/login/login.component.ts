import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AuthService } from 'src/app/services/auth.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  public form;
  public loggedIn = true;
  subscription: Subscription;

  constructor(private authService: AuthService) {
    this.subscription = authService.loginSource$.subscribe(
      loginStatus => {
        this.loggedIn = loginStatus;
    });
  }


  ngOnInit(): void {
  }

  onSubmit(form: NgForm) {
    console.log("Username = " + form.value.username);
    console.log("Password = " + form.value.password);
    
    this.authService.login(form.value.username, form.value.password);
    //this.loginAttempt = this.authService.loginAttempt;
    //console.log("LOGIN COMP ATTEMPT = " + this.loginAttempt);
    
  }

}
