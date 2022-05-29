document.body.onload = addElement;

// Seletores
const div = document.querySelector('div.classe');
const button = document.querySelector('button');

// Eventos
button.addEventListener('mouseover', mouseOver)
button.addEventListener('mouseout', mouseOver)

// Funcoes
function mouseOver() {

    div.classList.toggle('novo-estilo');
    div.classList.toggle('classe');
}

function addElement() {
    // cria um elemento e add conteudo
    var divNova = document.createElement('div');
    var conteudoNovo = document.createTextNode('Salve salve');
    divNova.appendChild(conteudoNovo);

    // console.log(divNova)
    // console.log(conteudoNovo)

    // adiciona o novo elemento ao dom
    var divAtual = document.getElementById('meu-elemento');

    console.log(divAtual);
    // divAtual.appendChild(divNova); // funciona
    // document.body.appendChild(divNova); // funciona

    document.body.insertBefore(divNova, divAtual);
}