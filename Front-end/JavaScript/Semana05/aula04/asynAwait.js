// Async & Await

// Syntactic Sugar

const promessa = new Promise(function (resolve, reject) {

    return resolve('Ok');

})


// O objeto Promise terá o 'then', o 'catch' e o 'finally'

// async function start() {

//     const result = await promessa;

//     // promessa é um objeto, que está sendo executado.
//     console.log(result);

// }

// start()


// Como podemos utilizar o 'then', o 'catch' e o 'finally' na função async ?

async function start() {

    try {

        const result = await promessa;

        // promessa é um objeto, que está sendo executado.
        console.log(`O resultado é: ${result}`);

    } catch (erro) {

        console.log(`O erro é: ${erro}`);

    } finally {

        console.log('Chegamos ao final');

    }

    // O finally é opcional.

}

start()