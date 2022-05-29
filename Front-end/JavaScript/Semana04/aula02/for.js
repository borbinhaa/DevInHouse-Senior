const personagens = [
    {
        nome: 'Blanka',
        pais: 'Brasil'
    },
    {
        nome: 'Ryu',
        pais: 'Japão'
    },
    {
        nome: 'Ken',
        pais: 'USA'
    },
]

personagens.forEach(object => {
    for (const key in object) {
        console.log(object[key])
    }
})