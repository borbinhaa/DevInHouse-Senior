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

const totalGeralDeGols = jogadores.reduce((totalDeGols, jogador) => totalDeGols += jogador.gols, 0);

console.log(getGoalsByPosition());

function getGoalsByPosition() {
    const posicoes = getAllPositions();

    const newArray = posicoes.map(position => {
        return {
            posicao: position,
            gols: getPlayersByPosition(position)
        };
    });

    return reduceGols(newArray);
}

function getAllPositions() {
    const posicoes = [];

    jogadores.map(player => {
        const playerPosition = player.posicao;

        if (!posicoes.includes(playerPosition)) {
            posicoes.push(playerPosition);
        }
    });

    return posicoes;
}

function getPlayersByPosition(position) {
    return jogadores.filter(obj => obj.posicao === position).map(jogador => jogador.gols);
};

function reduceGols(array) {
    return array.map(position => {
        return {
            posicao: position.posicao,
            goals: sumArray(position.gols)
        }
    });

};

function sumArray(array) {
    return array.reduce((total, element) => element += total, 0);
}