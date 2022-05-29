var aquiFunciona = 'oi'

function somaComVar() {
    var a = 1;
    if (true) {
        var b = 2;
    }
    var c = a + b

    console.log("O valor da soma á " + c)
}

// aqui não da de chamar a variavel c, o escopo dela não permite
// console.log(c)
console.log(aquiFunciona)

somaComVar()

function somaComLet() {
    let a2 = 1;
    if (true) {
        let b2 = 2;
    }
    let c2 = 1
    //    let c2 = a2 + b2 // da erro pois o b2 não consegue ser acessado aqui

    console.log("O valor da soma á " + c2)
}
/*  Aqui tbm não funciona
console.log(c2) */

somaComLet()

function somaComConst() {
    const a3 = 1;
    if (true) {
        const b3 = 2;
    }

    const c3 = 45;
    //    const c3 = a3 + b3 // da erro pois não da de acessar o b3

    console.log("O valor da soma á " + c3)
}

/*  Aqui tbm não funciona
console.log(c3) */

somaComConst()
