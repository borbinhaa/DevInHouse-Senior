package exercicios.usuarios;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
//import java.util.Scanner;

import exercicios.filmes.Filme;
import exercicios.recomendacoes.Plataforma;
import lombok.Getter;
import lombok.Setter;

public class Usuario {

	@Getter
	@Setter
	private String nomeCompleto;
	@Getter
	@Setter
	private String endereco;
	@Getter
	private String dataAniversario;
	@Getter
	private ArrayList<Filme> filmesCurtidos = new ArrayList<>();
	@Getter
	private ArrayList<Filme> filmesNaoCurtidos = new ArrayList<>();
	@Getter
	private ArrayList<String> filmesRecomendados = new ArrayList<>();
	@Getter
	private long idade;
	@Getter
	private LocalDate ultimaRecomendacao = LocalDate.of(1900, 1, 1);
	@Getter
	@Setter
	private Conta conta;

	public Usuario(String nomeCompleto, String endereco, String dataAniversario) {
		this.nomeCompleto = nomeCompleto;
		this.endereco = endereco;
		this.dataAniversario = dataAniversario;
		this.idade = calcularIdade();
	}

	public void sugerirFilme(Plataforma app, String filme) {
		long diffEntreSugestoes = ChronoUnit.MONTHS.between(ultimaRecomendacao, LocalDate.now());

		if (diffEntreSugestoes >= 1) {
			app.getFilmesSugeridos().add(filme);
			System.out.println("Filme " + filme + " sugerido com sucesso por " + this.getNomeCompleto() + ".");
			this.ultimaRecomendacao = LocalDate.now();
		} else {
			long diasEntreSugestoes = 30 - ChronoUnit.DAYS.between(ultimaRecomendacao, LocalDate.now());
			System.out.println("Você só pode fazer uma sugestão espere " + diasEntreSugestoes
					+ " dias pra fazer a proxima recomendação.");
		}
	}

	public void recomendarFilme(Usuario user, Filme filme, String porqueRecomendou) {
		user.getFilmesRecomendados().add("User: " + this.getNomeCompleto() + " | Recomendou o filme: " + filme.getNome()
				+ " | Motivo: " + porqueRecomendou);
		System.out.println(
				this.getNomeCompleto() + " recomendou " + filme.getNome() + " para " + user.getNomeCompleto() + ".");
	}

	private int calcularIdade() {
		return (int) ChronoUnit.YEARS.between(this.fatorarAniversario(), LocalDate.now());
	}

	private LocalDate fatorarAniversario() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return LocalDate.parse(this.dataAniversario, formatter);
	}

	@Override
	public String toString() {
		return nomeCompleto;
	}

}
