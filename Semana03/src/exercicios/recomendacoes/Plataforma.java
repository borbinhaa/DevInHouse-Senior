package exercicios.recomendacoes;

import java.util.ArrayList;
import exercicios.filmes.Generos;

public class Plataforma {

	private String app;
	private ArrayList<String> filmesRecomendados = new ArrayList<>();
	private Generos maisAssistido;
	private long maior = 0;

	public Plataforma(String app) {
		this.app = app;
	}

	public String getApp() {
		return app;
	}

	public ArrayList<String> getFilmesRecomendados() {
		return filmesRecomendados;
	}

	public Generos getGeneroMaisAssistido() {
		if (Generos.INFANTIL.getVezesAssistidas() > maior) {
			maisAssistido = Generos.INFANTIL;
			maior = Generos.INFANTIL.getVezesAssistidas();
		}

		if (Generos.COMEDIA.getVezesAssistidas() > maior) {
			maisAssistido = Generos.COMEDIA;
			maior = Generos.COMEDIA.getVezesAssistidas();
		}

		if (Generos.TERROR.getVezesAssistidas() > maior) {
			maisAssistido = Generos.TERROR;
			maior = Generos.TERROR.getVezesAssistidas();
		}

		if (Generos.SUSPENSE.getVezesAssistidas() > maior) {
			maisAssistido = Generos.SUSPENSE;
			maior = Generos.SUSPENSE.getVezesAssistidas();
		}

		if (Generos.ROMANCE.getVezesAssistidas() > maior) {
			maisAssistido = Generos.ROMANCE;
			maior = Generos.ROMANCE.getVezesAssistidas();
		}

		if (Generos.ACAO.getVezesAssistidas() > maior) {
			maisAssistido = Generos.ACAO;
			maior = Generos.ACAO.getVezesAssistidas();
		}

		return maisAssistido;
	}

}
