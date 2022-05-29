import { EditComponent } from './_component/edit/edit.component';
import { AuthGuard } from './auth.guard';
import { Exercicio05Component } from './_component/exercicio05/exercicio05.component';
import { ContatoComponent } from './_views/contato/contato.component';
import { InformacoesComponent } from './_views/informacoes/informacoes.component';
import { HomeComponent } from './_views/home/home.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'informacoes', component: InformacoesComponent },
  { path: 'contato', component: ContatoComponent },
  {
    path: 'perfil/:nome/:email', component: Exercicio05Component, canActivate: [AuthGuard],
    children: [
      { path: 'edit', component: EditComponent }
    ],
    canActivateChild: [AuthGuard]
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
