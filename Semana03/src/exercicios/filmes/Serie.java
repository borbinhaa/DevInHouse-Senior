package exercicios.filmes;

import java.util.ArrayList;
import java.util.Collections;

import lombok.Getter;

public class Serie extends Conteudo {

	@Getter
	private ArrayList<Episodio> episodios = new ArrayList<>();

	public Serie(String nome, String sinopse, Generos genero, String link, long faixaEtaria) {
		super(nome, sinopse, genero, link, faixaEtaria);
	}

	public void addEpisodio(Episodio episodio) {
		episodios.add(episodio);
	}

	public void organizarEpisodios() {
		Collections.sort(episodios);
	}

	@Override
	public String toString() {
		return "Serie [episodios=" + episodios + "]";
	}

}
