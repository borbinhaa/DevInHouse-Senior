import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  email: string = "oi@email.com"
  formValid: boolean = true;
  nomePessoa: string = "";
  titulo: string = "titulo de noticia";


  leia = {
    name: "Star Wars - Leia",
    description: "Leia Organa Solo (nascida Leia Amidala Skywalker) foi em vários estágios da vida uma política, revolucionária e Cavaleira Jedi da Nova Ordem Jedi. A filha do Jedi Anakin Skywalker e da Senadora Padmé Amidala de Naboo, Leia era a irmã gêmea mais nova de Luke Skywalker e pouco após seu nascimento foi adotada por Bail Organa e a Rainha Breha de Alderaan, fazendo dela a Princesa de Alderaan. Uma Senadora bem-sucedida, Leia ficou famosa por sua liderança forte durante a Guerra Civil Galáctica e outros conflitos subsequentes, fazendo dela parte dos maiores heróis da Galáxia. Posteriormente ela casou-se com Han Solo e tornou-se mãe de Jaina, Jacen e Anakin Solo. No começo da Guerra Swarm, Leia se tornou avó através da filha de Jacen, Allana, embora não soubesse de seu parentesco com a criança na época.",
    type: "Humano",
    gender: 'Feminino',
    height: '1.5',
    imgPath: '../../../assets/img/leia.webp'
  }

  luke = {
    name: "Luke SkyWalker",
    description: "Luke Skywalker foi um lendário Cavaleiro Jedi que ajudou a derrotar o Império Galáctico e a formar a Nova República, assim como a Nova Ordem Jedi. Nascido em 19 ABY em Polis Massa, filho do Cavaleiro Jedi caído Anakin Skywalker, que mais tarde se tornou seu inimigo, Darth Vader, o Lorde Negro dos Sith, e da Senadora de Naboo, Padmé Amidala, irmão de Leia Organa Solo. Luke Skywalker foi um revolucionário, foi o maior herói que a Galáxia já conheceu. Foi criado em Tatooine escondido do Imperador Palpatine, e seu pai, Darth Vader. Em 0 ABY, a vida de Skywalker iria mudar para sempre. A compra de dois droides, R2-D2 e C-3PO, o levou a encontrar Han Solo, a Princesa Leia Organa, e receber treinamento do antigo Mestre Jedi Obi-Wan Kenobi. Skywalker, então destruiu a Primeira Estrela da Morte e se juntou à Aliança Rebelde.",
    type: "Humano",
    gender: 'Masculino',
    height: '1.72',
    imgPath: '../../../assets/img/luke-star-wars.webp'
  }

  constructor() { }

  ngOnInit(): void {
  }

  mostrarEmail() {
    alert(this.email)
  }

  mostrarAlerta() {
    alert("Alerta")
  }

  mudarCor() {
    this.formValid = !this.formValid;
  }

  mostrarNome() {
    alert(this.nomePessoa)
  }

}
