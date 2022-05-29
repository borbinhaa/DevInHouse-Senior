class Aluno extends Pessoa {
    constructor(nome, idade, turma) {
        super(nome, idade);
        this.turma = turma;
    }

    toString() {
        console.log(`Nome: ${this.nome}; Idade: ${this.idade}; Turma: ${this.turma}`);
    }
}

