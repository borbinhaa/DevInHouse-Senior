import { NotFoundComponent } from './_view/not-found/not-found.component';
import { SignupComponent } from './_view/signup/signup.component';
import { SigninComponent } from './_view/signin/signin.component';
import { HomeComponent } from './_view/home/home.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'home', component: HomeComponent },
  { path: 'signin', component: SigninComponent },
  { path: 'signup/:id', component: SignupComponent },
  { path: '**', component: NotFoundComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
