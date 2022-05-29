import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './_components/header/header.component';
import { HomeComponent } from './_views/home/home.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { FooterComponent } from './_components/footer/footer.component';
import { FormsModule } from '@angular/forms';
import { CardNoticiaComponent } from './_components/card-noticia/card-noticia.component';
import { ExerciseCardComponent } from './_components/exercise-card/exercise-card.component';
import { SeriesComponent } from './_views/series/series.component';
import { ListaEpisodiosComponent } from './_components/lista-episodios/lista-episodios.component';
import { MathService } from './_services/math.service';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    HomeComponent,
    FooterComponent,
    CardNoticiaComponent,
    ExerciseCardComponent,
    SeriesComponent,
    ListaEpisodiosComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    FormsModule
  ],
  providers: [
    MathService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
