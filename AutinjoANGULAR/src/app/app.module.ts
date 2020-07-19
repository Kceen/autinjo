import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { HeaderComponent } from './comps/header/header.component';
import { SimpleSearchComponent } from './comps/simple-search/simple-search.component';
import { CarsGridComponent } from './comps/cars-grid/cars-grid.component';
import { AutoDetailViewComponent } from './comps/auto-detail-view/auto-detail-view.component';
import { HomeComponent } from './comps/home/home.component';
import { FooterComponent } from './comps/footer/footer.component';
import { PaginationComponent } from './comps/pagination/pagination.component';
import { UserComponent } from './comps/user/user.component';
import { LoginComponent } from './comps/login/login.component';
import { RegisterComponent } from './comps/register/register.component';
import { DetailSearchComponent } from './comps/detail-search/detail-search.component';
import { HomeDetailSearchComponent } from './comps/home-detail-search/home-detail-search.component';
import { ApiService } from './services/api.service';
import { AuthService } from './services/auth.service';
import { AuthTokenInterceptor } from './services/auth-token.interceptor';
import { AddAutoComponent } from './comps/add-auto/add-auto.component';
import { AddImagesComponent } from './comps/add-images/add-images.component';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    SimpleSearchComponent,
    CarsGridComponent,
    AutoDetailViewComponent,
    HomeComponent,
    FooterComponent,
    PaginationComponent,
    UserComponent,
    LoginComponent,
    RegisterComponent,
    DetailSearchComponent,
    HomeDetailSearchComponent,
    AddAutoComponent,
    AddImagesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    ApiService,
    AuthService,
    {
      provide: HTTP_INTERCEPTORS,
      useClass: AuthTokenInterceptor,
      multi: true,
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
