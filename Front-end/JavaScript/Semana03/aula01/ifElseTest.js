var button = document.querySelector("button");
var otherButton = document.getElementsByClassName("btn");
var otherButton2 = document.getElementsByClassName("setLi");

console.log(otherButton[0]);

var text = document.querySelector("p");
var li = document.querySelector("li")

console.log(li)

otherButton[0].addEventListener('click', updateBtn)
// button.addEventListener('click', updateBtn)

otherButton2[0].addEventListener('click', setLi)

function updateBtn() {

    if (otherButton[0].textContent === "Iniciar maquina") {
        otherButton[0].textContent = 'Parar maquina';
        text.textContent = 'A maquina iniciou';
    } else {
        otherButton[0].textContent = 'Iniciar maquina';
        text.textContent = 'A maquina está parada';
    }

}

function setLi() {

    if (otherButton2[0].textContent === 'Set LI') {
        otherButton2[0].textContent = 'Voltar Li';
        li.textContent = 'Setado';
    } else {
        otherButton2[0].textContent = 'Set LI'
        li.textContent = 'Nao Setado'
        console.log(otherButton2[0].textContent)
    }

}

