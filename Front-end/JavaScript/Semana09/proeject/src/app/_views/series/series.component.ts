import { Component, OnInit } from '@angular/core';
import { MathService } from 'src/app/_services/math.service';

@Component({
  selector: 'app-series',
  templateUrl: './series.component.html',
  styleUrls: ['./series.component.scss']
})
export class SeriesComponent implements OnInit {

  constructor(private math: MathService) { }

  ngOnInit(): void {
  }

  cliqueEmLista(event: any) {
    console.log('Escutando o filho');

  }

}
