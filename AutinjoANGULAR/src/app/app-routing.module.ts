import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AutoDetailViewComponent } from './comps/auto-detail-view/auto-detail-view.component';
import { HomeComponent } from './comps/home/home.component';
import { UserComponent } from './comps/user/user.component';
import { LoginComponent } from './comps/login/login.component';
import { RegisterComponent } from './comps/register/register.component';
import { HomeDetailSearchComponent } from './comps/home-detail-search/home-detail-search.component';
import { AddAutoComponent } from './comps/add-auto/add-auto.component';
import { AddImagesComponent } from './comps/add-images/add-images.component';


const routes: Routes = [
  { path: 'autoDetail/:id', component: AutoDetailViewComponent},
  { path: 'user/:id', component: UserComponent},
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'home-detail', component: HomeDetailSearchComponent },
  { path: 'add-auto', component: AddAutoComponent },
  { path: 'add-images', component: AddImagesComponent },
  { path: '', component: HomeComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
