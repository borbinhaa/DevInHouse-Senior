package exercicios.filmes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Episodio implements Comparable<Episodio> {

	@Getter
	private String nome;
	@Getter
	private String sinopse;
	@Getter
	private String dataLancamento;
	private String url;
	private Serie serie;

	public LocalDate getDataLancamentoFatorada() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return LocalDate.parse(this.dataLancamento, formatter);
	}
	
	public int comparable(Episodio episodio1, Episodio episodio2) {
		return episodio1.getDataLancamentoFatorada().compareTo(episodio2.getDataLancamentoFatorada());
	}

	@Override
	public int compareTo(Episodio episodio) {
		return this.getDataLancamentoFatorada().compareTo(episodio.getDataLancamentoFatorada());
	}

}
