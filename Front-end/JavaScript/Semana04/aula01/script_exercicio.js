const div1 = document.querySelector('.div1');
const div2 = document.querySelector('.div2');
const button1 = document.querySelector('#button1');
const button2 = document.querySelector('#button2');


button1.addEventListener('click', addFilmes)
button2.addEventListener('click', addFilmes2)


function addFilmes() {
    div1.classList.toggle('none');
};

function addFilmes2() {
    div2.innerText = '';

    const h1 = document.createElement('h1');
    h1.innerText = 'Filmes Preferidos';
    div2.appendChild(h1);

    const ol = document.createElement('ol');

    for (let i = 0; i < 3; i++) {
        let li = document.createElement('li');
        li.innerText = 'Filme ' + i;
        ol.appendChild(li);
    }

    div2.appendChild(ol);
};