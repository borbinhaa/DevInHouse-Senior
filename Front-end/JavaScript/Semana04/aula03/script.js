const array = ['Oi', 'Hello', 'Hi', 'Hello'];


// array.forEach(function (elemento, indice) {
//     console.log(elemento, indice);
// });

const arrayDiferente = array.filter(function (elemento) {
    if (elemento === 'Hello') {
        return true;
    } else {
        return false;
    }
});

const arrayDiferente2 = array.filter(elemento => elemento === 'Hello');

console.log(arrayDiferente);
console.log(arrayDiferente2);