const button = document.querySelector('button');

button.addEventListener('click', showResult)

function getRate() {
    const rate = document.querySelector('.rate');
    return rate.value;
};

function getFilmeWithRateOverThan(rate) {
    const films = [
        {
            name: 'A Fera',
            rate: 8
        },
        {
            name: 'Eu sou a lenda',
            rate: 10
        },
        {
            name: 'Filme do Pelé',
            rate: 7
        }
    ]
    return films.filter(function (film) {
        return film.rate >= rate;
    })
};

function cleanFilmArea() {
    const filmArea = document.querySelector('.areaDosFilmes');
    filmArea.innerText = '';
}

function createFilmContainer(film) {
    const container = document.createElement('div');
    const filmName = document.createElement('h1');
    filmName.innerText = `Titulo: ${film.name}`;

    const filmRate = document.createElement('h2');
    filmRate.innerText = `Nota: ${film.rate}`;

    container.appendChild(filmName);
    container.appendChild(filmRate);

    return container;
};

function showResult() {
    cleanFilmArea()
    const rate = getRate();
    const films = getFilmeWithRateOverThan(rate);

    const filmsArea = document.querySelector('.areaDosFilmes');

    films.forEach(film => {
        filmContainer = createFilmContainer(film)
        filmsArea.appendChild(filmContainer)
    })
}

