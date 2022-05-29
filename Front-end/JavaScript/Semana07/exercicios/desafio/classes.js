class Animal {
    constructor(nome) {
        this.nome = nome;
    }

    dizerNome() {
        console.log(`Nome: ${this.nome}`);
    }
}

class Mamifero extends Animal {
    constructor(nome, alimentacao) {
        super(nome);
        this.alimentacao = alimentacao;
    }

    seAlimentaDe() {
        console.log(`${this.nome} se alimenta de ${this.alimentacao}`);
    }
}

class Reptil extends Animal {
    constructor(nome, habitat) {
        super(nome);
        this.habitat = habitat;
    }

    viveEm() {
        console.log(`${this.nome} vive em ${this.habitat}`);
    }

    dizerNome() {
        console.log(`Esse réptil é chamado de ${this.nome}`);
    }
}

class Cachorro extends Mamifero {
    constructor(nome, alimentacao, som) {
        super(nome, alimentacao);
        this.som = som;
    }

    emitirSom() {
        console.log(this.som);
    }

    seAlimentaDe() {
        console.log('Se alimenta de carne e vegetais');
    }
}

class Leao extends Mamifero {
    constructor(nome, alimentacao, sexo) {
        super(nome, alimentacao);
        this.sexo = sexo;
    }

    dizerNome() {
        if (this.sexo.toUpperCase() === 'F' || this.sexo.toUpperCase() === 'FEMEA') {
            console.log(`Nome: ${this.nome} leoa`);
        } else {
            console.log(`Nome: ${this.nome}`);
        }
    }
}

class Cobra extends Reptil {
    constructor(nome, habitat, venenosa) {
        super(nome, habitat);
        this.venenosa = venenosa;
    }

    dizerSeEVenenosa() {
        console.log(this.venenosa);
    }
}


let animal = new Animal('animal');
animal.dizerNome();
console.log();

let mamifero = new Mamifero('mamifero', 'leite');
mamifero.dizerNome();
mamifero.seAlimentaDe();
console.log();

let reptil = new Reptil('Reptil', 'lagoa');
reptil.dizerNome();
reptil.viveEm();
console.log();

let cachorro = new Cachorro('cachorro', 'ração', 'AUAU');
cachorro.dizerNome();
cachorro.emitirSom();
cachorro.seAlimentaDe();
console.log();

let leao = new Leao('Leao', 'carne', 'Macho');
leao.dizerNome();
leao.seAlimentaDe();
console.log();

let leoa = new Leao('Leoa', 'carne', 'Femea');
leoa.dizerNome();
leoa.seAlimentaDe();
console.log();

let cobra = new Cobra('Cobra', 'mato', true);
cobra.dizerNome();
cobra.viveEm();
cobra.dizerSeEVenenosa();