const smurfs = ['Papai Smurf', 'Smurfette', 'Gênio', 'Ranzinza'];
const div = document.querySelector('.container');

div.appendChild(createTable('Nome', smurfs));

function createTable(title, elementsArray) {
    const table = document.createElement('table');
    table.className = 'container-table';

    const tableTitle = createTableTitle(title);
    const tbody = createBody(elementsArray);

    table.appendChild(tableTitle);
    table.appendChild(tbody);
    return table;
};

function createTableTitle(title) {
    const thead = document.createElement('thead');

    const tr = createTableRow();
    const th = document.createElement('th');
    th.innerText = title;
    th.className = 'block grey-bg';

    tr.appendChild(th);
    thead.appendChild(tr);
    return thead;
};

function createTableRow() {
    return document.createElement('tr');
}

function createElementAndAddText(tag, text) {
    element = document.createElement(tag);
    element.innerText = text
    return element;
}

function createBody(elementsArray) {
    const tbody = document.createElement('tbody');

    for (let i = 0; i < elementsArray.length; i++) {
        const tr = createTableRow();
        const td = createElementAndAddText('td', elementsArray[i])

        td.className = 'block';

        tr.appendChild(td);
        tbody.appendChild(tr)
    }
    return tbody;
}