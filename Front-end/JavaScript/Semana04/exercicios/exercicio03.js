const jogadoresSelecao94 = [
    {
        nome: 'Taffarel',
        posicao: 'Goleiro',
    },
    {
        nome: 'Jorginho',
        posicao: 'Lateral Direito',
    },
    {
        nome: 'Ricardo Rocha',
        posicao: 'Zagueiro',
    },
    {
        nome: 'Mauro Silva',
        posicao: 'Volante',
    },
    {
        nome: 'Bebeto',
        posicao: 'Atacante',
    },
    {
        nome: 'Romário',
        posicao: 'Atacante',
    },
    {
        nome: 'Dunga',
        posicao: 'Volante',
    },
];
const div = document.querySelector('.principal-div');
const title = createTableTitle();
const body = createTableBody();

div.appendChild(createTable(title, body))

function createTable(title, body) {
    const table = document.createElement('table');
    table.appendChild(createElementAndAddText('caption', 'Selecao de 94'))
    const thead = document.createElement('thead');
    const tbody = document.createElement('tbody');

    thead.appendChild(title);
    body.forEach(tr => tbody.appendChild(tr));

    table.appendChild(thead);
    table.appendChild(tbody);
    return table;
};

function createTableTitle() {
    const row = document.createElement('tr');
    const th1 = createElementAndAddText('th', 'Jogador');
    const th2 = createElementAndAddText('th', 'Posicao');

    row.appendChild(th1);
    row.appendChild(th2);
    return row;
}

function createTableBody() {
    const rows = [];
    jogadoresSelecao94.forEach(playerObj => {
        const row = document.createElement('tr');

        for (const key in playerObj) {
            const td = createElementAndAddText('td', playerObj[key]);
            row.appendChild(td);

            rows.push(row);
        }

    });

    return rows;
}

function createElementAndAddText(tag, text) {
    element = document.createElement(tag);
    element.innerText = text;
    return element;
}

