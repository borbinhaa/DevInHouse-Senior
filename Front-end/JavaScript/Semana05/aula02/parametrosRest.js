function soma(a, b) {
    console.log(a + b);
}


soma(2, 3);

function somaTodos(...numeros) {
    let soma = 0;

    for (let numero of numeros) {
        soma += numero;
    }

    return soma;
}

console.log(somaTodos(1, 2, 3));