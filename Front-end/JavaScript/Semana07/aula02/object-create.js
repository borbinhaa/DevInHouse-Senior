const alunoModelo = {
    nome: '',
    idade: null,
    turma: '',
    alunoToString: function () {
        console.log(`Nome: ${this.nome}; Turma: ${this.turma}; Idade: ${this.idade}`);
    }
};

const alunoLuis = Object.create(alunoModelo, {
    nome: {
        value: 'Luis',
        writable: true,
        configurable: true,
        enumerable: true
    },
    idade: {
        value: 44,
    },
    turma: {
        value: 'Senior',
    }
});

alunoLuis.alunoToString();

console.log(alunoLuis);

alunoLuis.nome = 'Luiz';
alunoLuis.idade = 30;

alunoLuis.alunoToString();

console.log();
console.log('--------------------------------');
console.log();

const alunoModeloExercicio = {
    nome: '',
    idade: null,

    toString: function () {
        console.log(`Nome: ${this.nome}; Idade: ${this.idade}`);
    },
};

const meuAluno = Object.create(alunoModeloExercicio, {
    nome: {
        value: 'Maria',
        writable: true,
        configurable: false,
        enumerable: false
    },
    idade: {
        value: 10,
        writable: true,
        configurable: false,
        enumerable: false
    }
});

meuAluno.toString();

meuAluno.nome = 'Zeca Pagodinho';
meuAluno.idade = 30;

meuAluno.toString();