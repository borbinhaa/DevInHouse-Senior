import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-exercicio05',
  templateUrl: './exercicio05.component.html',
  styleUrls: ['./exercicio05.component.css']
})
export class Exercicio05Component implements OnInit {

  nome: string = '';
  email: string = '';

  constructor(private activateRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.nome = this.activateRoute.snapshot.params['nome'];
    this.email = this.activateRoute.snapshot.params['email'];
  }

}
