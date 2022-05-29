import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-card-noticia',
  templateUrl: './card-noticia.component.html',
  styleUrls: ['./card-noticia.component.scss']
})
export class CardNoticiaComponent implements OnInit {

  @Input() titulo: string = '';
  // @Input('Alias') titulo: string = '';

  constructor() { }

  ngOnInit(): void {
  }

}
