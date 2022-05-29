import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  cardObject: any = {
    title: 'Titulo',
    subtitle: 'Subtitulo',
    text: 'Lorem ipsum dolor'
  }

  constructor() { }

  ngOnInit(): void {
  }

  trocaCor() {
    document.getElementsByClassName("card")[0].classList.toggle('dark-mode')
  }

  gerarAlerta(msg: string) {
    alert(msg);
  }

}
