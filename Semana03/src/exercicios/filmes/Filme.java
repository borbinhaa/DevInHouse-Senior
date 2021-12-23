package exercicios.filmes;

public class Filme {

	private String nome;
	private String sinopse;
	private Generos genero;
	private String linkFilme;
	private long vezesAssistidas = 0;
	

	public Filme(String nome, String sinopse, Generos genero, String linkFilme) {
		this.nome = nome;
		this.sinopse = sinopse;
		this.genero = genero;
		this.linkFilme = linkFilme;
	}
	
	public void addVezAssistidas() {
		this.vezesAssistidas++;
	}

	public String getNome() {
		return nome;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public Generos getGenero() {
		return genero;
	}

	public void setGenero(Generos genero) {
		this.genero = genero;
	}

	public String getLinkFilme() {
		return linkFilme;
	}

	public void setLinkFilme(String linkFilme) {
		this.linkFilme = linkFilme;
	}

	public long getVezesAssistidas() {
		return vezesAssistidas;
	}

}
