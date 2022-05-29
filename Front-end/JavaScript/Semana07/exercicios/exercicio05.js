class Aluno {
    constructor(nome, turma, idade, sexo) {
        this.nome = nome;
        this.turma = turma;
        this.idade = idade;
        this.sexo = sexo;
    }

    imprimeAluno() {

        let paragraph = document.createElement('p');
        paragraph.innerHTML = `Nome: ${this.nome}; Idade: ${this.idade}`;
        document.body.appendChild(paragraph);

    }
}

const aluno1 = new Aluno('Maaris', 13, '7C', 'M');
aluno1.imprimeAluno();
const aluno2 = new Aluno('Anthony', 13, '7C', 'M');
aluno2.imprimeAluno();
const aluno3 = new Aluno('Maria', 13, '7C', 'F');
aluno3.imprimeAluno();