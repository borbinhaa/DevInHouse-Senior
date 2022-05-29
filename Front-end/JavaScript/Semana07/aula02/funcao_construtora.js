function Aluno(nome, turma) {
    this.nome = nome;
    this.turma = turma;
    const idade = 15;

    this.toString = function () {
        console.log(`Nome: ${this.nome}; Turma: ${this.turma}; Idade: ${this.idade}`);
    }
}

const aluno = new Aluno("Pedro", "7C");

console.log(aluno);
aluno.toString();