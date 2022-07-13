package exercicio.devingame.personagens;

import lombok.Getter;
import lombok.Setter;

public abstract class Personagem {

	@Setter @Getter
	protected String nome;
	@Getter
	@Setter
	protected double dano;
	@Setter
	@Getter
	protected double vida;
	@Getter @Setter
	protected double armadura;

	public void atacar(Personagem p, double dano) {
		if (dano == 0) {
			System.out.println(this.getNome() + " errou o ataque.");			
		} 

		System.out.println(this.getNome() + " acertou o ataque.");
		p.setVida(p.getVida() - dano);
		System.out.println("Dano total = " + dano);
		System.out.println("Vida de " + p.getNome() +" = " + p.getVida());	
		System.out.println();
	}
	
	public boolean isDead() {
		return this.getVida() < 0;
	}
}
