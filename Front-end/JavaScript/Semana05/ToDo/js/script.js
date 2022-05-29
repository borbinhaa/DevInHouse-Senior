const button = document.querySelector(".todo-button");
const input = document.querySelector('.todo-input');
const ul = document.querySelector('.todo-list');

// localStorage.clear()
button.addEventListener('click', addToList);
ul.addEventListener('click', deleteCheck)

onload = function () {

    if (localStorage.hasOwnProperty('items')) {
        items = JSON.parse(this.localStorage.getItem('items'));
        console.log(typeof items);
        console.log(items);

        for (const item of items) {
            createLi(item)
        }
    }
}


function addToList(event) {

    event.preventDefault();

    const valor = document.querySelector('.todo-input').value;
    let items = new Array();

    if (localStorage.hasOwnProperty('items')) {
        items = JSON.parse(localStorage.getItem("items"))
    }

    items.push(valor);

    localStorage.setItem('items', JSON.stringify(items));

    createLi(valor);
}

function deleteCheck(event) {

    item = event.target;
    console.log(item);

    if (item.classList[0] == 'trash-btn') {
        items = JSON.parse(localStorage.getItem('items'));

        const todo = item.parentElement;
        removeLocalTodo(todo);
        console.log(todo);


        todo.remove();
    }

    if (item.classList[0] == 'complete-btn') {
        const todo = item.parentElement;
        console.log(todo);
        todo.classList.toggle('completed');
    }

}

function createLi(item) {
    const div = document.createElement('div');
    div.classList.add('todo');

    const newTodo = document.createElement('li');
    newTodo.innerText = item;
    newTodo.classList.add('todo-item');

    div.appendChild(newTodo);

    const completeButton = document.createElement('button');
    completeButton.innerHTML = '<i class="fas fa-check"></i>';
    completeButton.classList.add('complete-btn');
    div.appendChild(completeButton)

    const trashButton = document.createElement('button');
    trashButton.innerHTML = '<i class="fas fa-trash"></i>';
    trashButton.classList.add('trash-btn');
    div.appendChild(trashButton)

    ul.appendChild(div);

    input.value = '';
}

function removeLocalTodo(todo) {
    items = JSON.parse(localStorage.getItem("items"))


    const todoIndex = todo.children[0].innerText;
    console.log(todoIndex);
    console.log(todo.children);

    items.splice(items.indexOf(todoIndex), 1);

    localStorage.setItem('items', JSON.stringify(items));

}