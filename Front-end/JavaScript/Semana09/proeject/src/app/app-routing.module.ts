import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './_views/home/home.component';
import { SeriesComponent } from './_views/series/series.component';

const routes: Routes = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'series',
    component: SeriesComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
