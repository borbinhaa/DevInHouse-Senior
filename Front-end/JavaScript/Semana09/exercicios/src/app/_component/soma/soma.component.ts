import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-soma',
  templateUrl: './soma.component.html',
  styleUrls: ['./soma.component.css']
})
export class SomaComponent implements OnInit {

  @Input() valor1!: number;
  @Input() valor2!: number;
  @Input() resultado!: number;
  constructor() { }

  ngOnInit(): void {
  }

}
