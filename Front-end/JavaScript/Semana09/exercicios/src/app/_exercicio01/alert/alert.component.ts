import { Component, OnInit, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-alert',
  templateUrl: './alert.component.html',
  styleUrls: ['./alert.component.css']
})
export class AlertComponent implements OnInit {

  value1!: number;
  value2!: number;
  resultado!: number;

  constructor() { }

  ngOnInit(): void {
  }

  calculaSoma() {
    this.resultado = this.value1 + this.value2;
  }

  limpa() {
    this.value1 = 0;
    this.value2 = 0;
    this.resultado = 0;
  }

}
