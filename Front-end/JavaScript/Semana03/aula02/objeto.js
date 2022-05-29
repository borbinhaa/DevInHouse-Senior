var hotel = {
    nome: 'Meu Hotel',
    quartos: 40,
    reservados: 25,
    gym: true,
    tiposDeQuarto: ['duplo', 'single'],

    checkDisponibilidade: function () {
        return this.quartos - this.reservados;
    }
}