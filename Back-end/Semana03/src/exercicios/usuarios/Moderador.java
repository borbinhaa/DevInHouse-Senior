package exercicios.usuarios;

import exercicios.filmes.Moderavel;
import exercicios.recomendacoes.Plataforma;
import lombok.Getter;

public class Moderador {

	@Getter
	private String nome;
	private Plataforma app;

	Moderador(String nome, Plataforma app) {
		this.nome = nome;
		this.app = app;
	}

	public void setConteudoImproprio(Moderavel moderavel) {
		moderavel.setImproprio(true);
		moderavel.remove(this.app);
		app.getConteudosImproprios().add(moderavel);
	}
}
