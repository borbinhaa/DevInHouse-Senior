// Crie um objeto que possuirá 2 propriedades, ambas do tipo Array:

// receitas: [ ]
// despesas: [ ]
// Agora crie uma função que irá calcular o total de receitas e despesas e
// irá mostrar uma mensagem se a família está com saldo positivo ou negativo,
// segundo o valor do saldo.

let obj = {
    receitas: [1000],
    despesas: [300, 200, 65.50, 700]
}

let obj2 = {
    receitas: [1400, 300],
    despesas: [300, 200, 65.50, 700]
}

let obj3 = {
    receitas: [300, 200],
    despesas: [300, 200]
}

function calculateBalance(object) {
    receitas = sumArray(object.receitas)
    despesas = sumArray(object.despesas)

    let balance = receitas - despesas;

    if (balance > 0) {
        console.log('Você tem um saldo positivo de ' + balance);
    } else if (balance === 0) {
        console.log("Você está com um saldo zerado, gastou o mesmo que recebeu.");
    } else {
        console.log('Você está com um saldo negativo de ' + balance);
    }
}

function sumArray(array) {
    let totalSum = 0;
    array.forEach(value => {
        totalSum += value;
    });
    return totalSum;
}

calculateBalance(obj);
calculateBalance(obj2);
calculateBalance(obj3);