const jogadores = [
    {
        nome: 'Taffarel',
        posicao: 'Goleiro',
        gols: 0,
    },
    {
        nome: 'Jorginho',
        posicao: 'Lateral Direito',
        gols: 2,
    },
    {
        nome: 'Ricardo Rocha',
        posicao: 'Zagueiro',
        gols: 0,
    },
    {
        nome: 'Mauro Silva',
        posicao: 'Volante',
        gols: 1,
    },
    {
        nome: 'Bebeto',
        posicao: 'Atacante',
        gols: 5,
    },
    {
        nome: 'Romário',
        posicao: 'Atacante',
        gols: 8,
    },
    {
        nome: 'Dunga',
        posicao: 'Volante',
        gols: 2,
    },
];

console.log(todosVolantesFizeramGol());
console.log(algumAtacanteFezMaisDeSeteGols());


function todosVolantesFizeramGol() {
    return jogadores.filter(player => player.posicao === 'Volante').every(player => player.gols > 0);
}

function algumAtacanteFezMaisDeSeteGols() {
    return jogadores.filter(player => player.posicao === 'Atacante').some(player => player.gols > 7);
}