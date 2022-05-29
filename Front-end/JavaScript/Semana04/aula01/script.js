const buscarId = document.getElementById("id5");
buscarId.innerHTML = '<span> um teste bacana </span>';

const porClasse = document.getElementsByClassName('classe4');
console.log(porClasse);
porClasse[0].innerText = 'Ola';

const div3 = document.getElementsByName('nome3');
div3[0].innerText = 'DIV 3';

const h1 = document.createElement('h5');
h1.innerText = 'subsubtitulo';

const divs = document.getElementsByTagName('div');
console.log(divs);

