// Promises intro:

// console.log('Pedir Uber');

// let aceitar = false;

// const promessa = new Promise( (resolve, reject) => {

//     if(aceitar){

//         return resolve('Carro chegou')

//     }

//     return reject('Pedido negado');
// })

// console.log('Aguardando ...');

// promessa
//     .then(result => {console.log(result)})
//     .catch(erro => console.log(erro))
//     .finally(() => console.log('Promessa finalizada'))



// Utilizando promises com fetch:

fetch('https://api.github.com/users/omayconmendes')
    .then(response => response.json())
    .then(data => fetch(data.repos_url))
    .then(res => res.json())
    .then(d => console.log(d))
    .catch(erro => console.log(erro))
    .finally(() => console.log('Promessa finalizada'))