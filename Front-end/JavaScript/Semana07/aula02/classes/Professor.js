class Professor extends Pessoa {
    constructor(nome, idade, disciplina) {
        super(nome, idade);
        this.disciplina = disciplina;
    }

    toString() {
        console.log(`Nome: ${this.nome}; Idade: ${this.idade};` +
            ` Disciplina: ${this.disciplina}`);
    }
}