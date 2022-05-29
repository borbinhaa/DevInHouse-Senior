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

console.log(reduceArray());

function reduceArray() {
    const posicoes = getAllPositions();

    return posicoes.map(position => {
        return {
            posicao: position,
            jogadores: getPlayersByPosition(position)
        };
    });
}

function getAllPositions() {
    const posicoes = [];

    jogadoresSelecao94.map(player => {
        const playerPosition = player.posicao;

        if (!posicoes.includes(playerPosition)) {
            posicoes.push(playerPosition);
        }
    });

    return posicoes;
}

function getPlayersByPosition(position) {
    return jogadoresSelecao94.filter(obj => obj.posicao === position).map(player => player.nome);
}