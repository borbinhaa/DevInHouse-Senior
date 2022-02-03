package exercicio.devingame.personagens;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.Getter;

public enum Classe {

	MAGO(5, 10, Arrays.asList(Arma.MAGIA_FOGO, Arma.MAGIA_AGUA)),
	ARQUEIRO(7, 8, Arrays.asList(Arma.ARCO_E_FLECHA)),
	BARBARO(10, 6, Arrays.asList(Arma.ESPADA_LONGA, Arma.MACA)),
	PALADINO(15, 4, Arrays.asList(Arma.MACHADO, Arma.LANCAS)),
	GUERREIRO(20, 3, Arrays.asList(Arma.MACHADO, Arma.ESPADA));

	@Getter
	private double armadura;
	@Getter
	private double dano;
	@Getter
	private List<Arma> armasClasse = new ArrayList<Arma>();

	Classe(double armadura, double dano, List<Arma> armasClasse) {
		this.armadura = armadura;
		this.dano = dano;
		this.armasClasse = armasClasse;
	}
}
