// Escreva uma função que recebe um valor por parâmetro e verifique se o valor é classificado como booleano primitivo. Retorne true ou false.

// Os booleanos primitivos são true e false.


function isBoolean(value) {
    return value === true || value === false;
};


console.log(isBoolean(true));
console.log(isBoolean(false));
console.log(isBoolean('oi'));
console.log(isBoolean('true'));
console.log(isBoolean('false'));
console.log(isBoolean(1));
