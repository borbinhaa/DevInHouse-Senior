//  * Crie uma constante com o nome meuArray;
//  * Inicialize como um array;
//  * Adicione três objetos ao seu array;
//  * Cada objeto deve conter, pelo menos, uma informação do tipo boolean, uma string e um number.



let meuArray = [];

casaDisponivel1 = {
    rua: 'Rua 1',
    isDisponivel: true,
    diaria: 157.50
}

casaDisponivel2 = {
    rua: 'Rua 2',
    isDisponivel: false,
    diaria: 59
}

casaDisponivel3 = {
    rua: 'Rua 1',
    isDisponivel: true,
    diaria: 200
}

meuArray.push(casaDisponivel3, casaDisponivel1, casaDisponivel2);

console.log(meuArray)