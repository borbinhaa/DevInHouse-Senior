package exercicios.filmes;

import exercicios.recomendacoes.Plataforma;
import exercicios.usuarios.Usuario;
import lombok.Getter;

public class Comentario implements Moderavel {

	@Getter
	private String texto;
	@Getter
	private Usuario user;
	@Getter
	private Conteudo conteudo;
	@Getter
	private boolean improprio = false;

	public Comentario(String texto, Usuario user, Conteudo conteudo) {
		this.conteudo = conteudo;
		this.texto = texto;
		this.user = user;
	}

	@Override
	public void setImproprio(boolean improprio) {
		this.improprio = improprio;
	}

	@Override
	public void remove(Plataforma app) {
		this.conteudo.getComentarios().remove(this);
	}
}
