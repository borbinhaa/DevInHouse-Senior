package exercicios.filmes;

import java.util.HashSet;

import exercicios.recomendacoes.Plataforma;
import lombok.Getter;
import lombok.Setter;

public abstract class Conteudo implements Moderavel {

	@Getter
	protected String nome;
	@Getter
	@Setter
	protected String sinopse;
	@Getter
	@Setter
	protected Generos genero;
	@Getter
	@Setter
	protected String link;
	@Getter
	protected long vezesAssistidas;
	@Getter
	@Setter
	protected long curtidas, descurtidas;
	@Getter
	protected HashSet<Comentario> comentarios = new HashSet<>();
	@Getter
	protected boolean improprio = false;
	@Getter
	protected long faixaEtaria;

	public Conteudo(String nome, String sinopse, Generos genero, String link, long faixaEtaria) {
		this.nome = nome;
		this.sinopse = sinopse;
		this.genero = genero;
		this.link = link;
		this.faixaEtaria = faixaEtaria;
	}

	public void addComentario(Comentario comentario) {
		comentarios.add(comentario);
	}

	public void addVezAssistidas() {
		this.vezesAssistidas++;
	}

	@Override
	public void remove(Plataforma app) {
		app.getConteudos().remove(this);
	}

	@Override
	public void setImproprio(boolean improprio) {
		this.improprio = improprio;
	}

}
