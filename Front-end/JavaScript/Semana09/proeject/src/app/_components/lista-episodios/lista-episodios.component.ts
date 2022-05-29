import { Component, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-lista-episodios',
  templateUrl: './lista-episodios.component.html',
  styleUrls: ['./lista-episodios.component.scss']
})
export class ListaEpisodiosComponent implements OnInit {

  @Output() cliqueLink: EventEmitter<any> = new EventEmitter<any>();

  constructor() { }

  ngOnInit(): void {
  }

  gerarEvento(str: string) {
    console.log(str);
    this.cliqueLink.emit(str);
  }
}
