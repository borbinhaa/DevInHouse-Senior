// Crie uma função que receba dois parâmetros: arrayOriginal e segundoArray.
// Utilize concat para adicionar segundoArray no arrayOriginal.

// Explique a diferença entre os métodos push e concat.

let arrayOriginal = ['Oi', 'Ola'];
let segundoArray = ['Hello', 'Hi'];


function addArray(array1, array2) {
    return array1.concat(array2);
}

console.log(addArray(arrayOriginal, segundoArray))

// A funcao push adiciona o segundoArray direto no arrayOriginal,
// já o concat ele adicionar apenas os valores, como se fizesse um for each no segundoArray
// e fosse adicionando um por um