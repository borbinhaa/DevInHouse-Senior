
function criaAluno(nome, idade, turma) {
    this.nome = nome;
    this.idade = idade;
    this.turma = turma;

    return {
        exibeAluno: function () {
            console.log(`Meu nome é ${nome}, minha idade é ${idade} e sou da turma ${turma}`);
        },
    };
};

const aluno1 = criaAluno('Pedro', 22, '7C');
aluno1.exibeAluno();
const aluno2 = criaAluno('Maria', 22, '7B');
aluno2.exibeAluno();
const aluno3 = criaAluno('João', 34, '9C');
aluno3.exibeAluno();