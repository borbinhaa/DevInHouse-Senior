package exercicio.devingame.personagens;

import lombok.Getter;

public enum Arma {

	MACHADO(15), ESPADA(10), LANCAS(20), ESPADA_LONGA(30), MACA(30), ARCO_E_FLECHA(35), MAGIA_FOGO(40), MAGIA_AGUA(40);

	@Getter
	private double dano;

	Arma(double dano) {
		this.dano = dano;
	}

}
