import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-exercise-card',
  templateUrl: './exercise-card.component.html',
  styleUrls: ['./exercise-card.component.scss']
})
export class ExerciseCardComponent implements OnInit {

  @Input() name: string = '';
  @Input() description: string = '';
  @Input() type: string = '';
  @Input() gender: string = '';
  @Input() height: string = '';
  @Input() imgPath: string = '';

  constructor() { }

  ngOnInit(): void {
  }

}
