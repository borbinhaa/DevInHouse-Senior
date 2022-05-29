// Baseado no Array de livros por categoria abaixo, faça os seguintes desafios:

// Contar o número de categorias e o número de livros em cada categoria.
// Contar o número de autores.
// Mostrar livros do autor Augusto Cury
// Transformar a função acima em uma função que irá receber o nome do autor
// e devolver os livros desse autor.

const categoriaDeLivros = [
    {
        categoria: "Riqueza",
        livros: [
            {
                titulo: "Os segredos da mente milionária",
                autor: "T. Harv Eker",
            },
            {
                titulo: "O homem mais rico da babilônia",
                autor: "George S. Clason",
            },
            {
                titulo: "Pai rico, pai pobre",
                autor: "Robert T. Kiyosaki e Sharon L. Lechter",
            },
        ],
    },
    {
        categoria: "Inteligência Emocional",
        livros: [
            {
                titulo: "Você é insubstituível",
                autor: "Augusto Cury",
            },
            {
                titulo: "Ansiedade - Como enfrentar o mal do século",
                autor: "Augusto Cury",
            },
            {
                titulo: "Os 7 hábitos das pessoas altamente eficazes",
                autor: "Stephen R. Covey",
            },
        ],
    },
];

function getCategoriesLength(array) {
    let categories = [];
    array.forEach(obj => {
        categories.push(obj.categoria)
    });
    return categories.length;
};

function getAuthorsLength() {
    let authors = [];

    for (let obj of categoriaDeLivros) {
        obj.livros.forEach(value => {
            let author = value.autor;

            if (!authors.includes(author)) {
                authors.push(author)
            }

        });
    };

    console.log(authors.length);
    return authors.length;
}

function getBooksFromAnAuthor(author) {
    let books = [];

    for (let obj of categoriaDeLivros) {

        obj.livros.forEach(value => {

            if (author === value.autor) {
                books.push(value.titulo);
            };

        });
    };

    return books;
}

console.log(getCategoriesLength(categoriaDeLivros));
getAuthorsLength();
console.log(getBooksFromAnAuthor('Augusto Cury'));
console.log(getBooksFromAnAuthor('Robert T. Kiyosaki e Sharon L. Lechter'));