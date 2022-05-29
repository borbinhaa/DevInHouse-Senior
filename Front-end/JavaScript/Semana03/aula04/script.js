function countdown() {
    const countDate = new Date('Dec 31, 2022 00:00:00').getTime();

    const now = new Date().getTime();

    const gap = countDate - now;


    const segundo = 1000;
    const minuto = segundo * 60;
    const hora = minuto * 60;
    const dia = hora * 24;

    const textDia = Math.floor(gap / dia);
    const textHora = Math.floor((gap % dia) / hora)
    const textMinuto = Math.floor((gap % hora) / minuto)
    const textSegundo = Math.floor((gap % minuto) / segundo)

    document.querySelector('.dia').innerText = textDia;
    document.querySelector('.hora').innerText = textHora;
    document.querySelector('.minuto').innerText = textMinuto;
    document.querySelector('.segundo').innerText = textSegundo;
}

setInterval(countdown, 1000);

// setTimeout(countdown, 5000)

