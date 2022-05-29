class Pessoa {
    #nome;
    #idade;
    #sexo;

    constructor(nome, idade, sexo) {
        this.#nome = nome;
        this.#idade = idade;
        this.#sexo = sexo;
    }

    imprimeAluno() {
        let paragraph = document.createElement('p');
        paragraph.innerHTML = `Nome: ${this.nome}; Idade: ${this.idade}; Sexo: ${this.sexo}`;
        document.body.appendChild(paragraph);
    }

    get nome() {
        return this.#nome;
    }

    get idade() {
        return this.#idade;
    }

    get sexo() {
        return this.#sexo;
    }

    set nome(nome) {
        this.#nome = nome;
    }

    set idade(idade) {
        this.#idade = idade;
    }

    set sexo(sexo) {
        this.#sexo = sexo;
    }
}

class Aluno extends Pessoa {
    #nome;
    #idade;
    #sexo;
    #turma;

    constructor(nome, turma, idade, sexo) {
        super(nome, idade, sexo);
        this.#turma = turma;
    }

    imprimeAluno() {
        let paragraph = document.createElement('p');
        paragraph.innerHTML = `ALUNO: <br>Nome: ${this.nome}; Idade: ${this.idade}; ` +
            `Sexo: ${this.sexo}; Turma: ${this.turma}`;
        document.body.appendChild(paragraph);
    }

    get turma() {
        return this.#turma;
    }

    set turma(turma) {
        this.#turma = turma;
    }
}

class Professor extends Pessoa {
    #nome;
    #idade;
    #sexo;
    #disciplina;

    constructor(nome, disciplina, idade, sexo) {
        super(nome, idade, sexo);
        this.#disciplina = disciplina;
    }

    imprimeAluno() {
        let paragraph = document.createElement('p');
        paragraph.innerHTML = `PROFERSSOR: <br>Nome: ${this.nome}; Idade: ${this.idade}; ` +
            `Sexo: ${this.sexo}; Disciplina: ${this.disciplina}`;
        document.body.appendChild(paragraph);
    }

    get disciplina() {
        return this.#disciplina;
    }

    set disciplina(disciplina) {
        this.#disciplina = disciplina;
    }
}

let aluno = new Aluno('Maria', '7C', 12, 'F');
aluno.imprimeAluno();

let professor = new Professor('Joana', 'Matematica', 30, 'F');
professor.imprimeAluno();


