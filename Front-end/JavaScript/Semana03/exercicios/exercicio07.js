// Crie um algoritmo que transforme as notas do sistema numérico
// para sistema de notas em caracteres tipo A, B e C:

// De 90 para cima - A
// Entre 80 e 89 - B
// Entre 70 e 79 - C
// Entre 60 e 69 - D
// menor que 60 - E


function getNota(nota) {

    let notaA = nota >= 90 && nota < 100;
    let notaB = nota >= 80 && nota <= 89;
    let notaC = nota >= 70 && nota <= 79;
    let notaD = nota >= 60 && nota <= 69;
    let notaE = nota < 60;

    let notaFinal;

    if (notaA) {
        notaFinal = 'A';
    } else if (notaB) {
        notaFinal = 'B';
    } else if (notaC) {
        notaFinal = 'C';
    } else if (notaD) {
        notaFinal = 'D';
    } else if (notaE) {
        notaFinal = 'E';
    }

    console.log(notaFinal)
}

getNota(95);
getNota(85);
getNota(75);
getNota(65);
getNota(55);
