package exercicios.filmes;

public enum Generos {
	
	INFANTIL, COMEDIA, TERROR, SUSPENSE, ROMANCE, ACAO;

	long vezesAssistidas = 0;
	

	public void addVezAssistidas() {
		vezesAssistidas++;
	}
	
	public long getVezesAssistidas() {
		return vezesAssistidas;
	}
	
}
