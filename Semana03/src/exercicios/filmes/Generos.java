package exercicios.filmes;

import lombok.Getter;

public enum Generos {

	INFANTIL, COMEDIA, TERROR, SUSPENSE, ROMANCE, ACAO;

	@Getter
	long vezesAssistidas = 0;

	public void addVezAssistidas() {
		vezesAssistidas++;
	}
}
