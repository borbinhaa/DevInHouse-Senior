import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { CardComponent } from './_component/card/card.component';
import { HomeComponent } from './_views/home/home.component';
import { ButtonComponent } from './_component/button/button.component';
import { InformacoesComponent } from './_views/informacoes/informacoes.component';
import { ContatoComponent } from './_views/contato/contato.component';
import { NavbarComponent } from './_component/navbar/navbar.component';
import { Exercicio05Component } from './_component/exercicio05/exercicio05.component';
import { EditComponent } from './_component/edit/edit.component';

@NgModule({
  declarations: [
    AppComponent,
    CardComponent,
    HomeComponent,
    ButtonComponent,
    InformacoesComponent,
    ContatoComponent,
    NavbarComponent,
    Exercicio05Component,
    EditComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
