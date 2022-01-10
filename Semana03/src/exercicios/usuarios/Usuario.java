package exercicios.usuarios;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
//import java.util.Scanner;

import exercicios.filmes.Filme;
import exercicios.recomendacoes.Plataforma;

public class Usuario {

	private String nomeCompleto;
	private String endereco;
	private String dataAniversario;
	private ArrayList<Filme> filmesCurtidos = new ArrayList<>();
	private ArrayList<Filme> filmesNaoCurtidos = new ArrayList<>();
	private ArrayList<String> filmesRecomendados = new ArrayList<>();
	private int idade;
	private LocalDate ultimaRecomendacao = LocalDate.of(1900, 1, 1), ultimoPagamento;
	

	public Usuario(String nomeCompleto, String endereco, String dataAniversario) {
		this.nomeCompleto = nomeCompleto;
		this.endereco = endereco;
		this.dataAniversario = dataAniversario;
		this.idade = CalcularIdade();
		this.ultimoPagamento = LocalDate.now();
	}

	public void assistirFilme(Filme filme) {
//		Scanner scanner = new Scanner(System.in);
		if (!this.verificacaoPagamento()) {
			System.out.println("Você precisa pagar sua assinatura.");
		} else {
			System.out.println("Obrigado por assistir o filme " + filme.getNome() + ".");
//			System.out.println("Você gostou do filme?\n(1)Curtir\n(2)Descurtir o filme\n(3)Nao curtir nem discurtir\n");
//			int gostouOuNao = scanner.nextInt();
//			
//			if (gostouOuNao == 1) {
//				this.CurtirFilme(filme);
//			} else if (gostouOuNao == 2) {
//				this.DescurtirFilme(filme);
//			}

			filme.addVezAssistidas();
			filme.getGenero().addVezAssistidas();
		}
	}

	public void SugerirFilme(Plataforma app, String filme) {
		long diffEntreSugestoes = ChronoUnit.MONTHS.between(ultimaRecomendacao, LocalDate.now());

		if (diffEntreSugestoes >= 1) {
			app.getFilmesRecomendados().add(filme);
			System.out.println("Filme " + filme + " sugerido com sucesso por " + this.getNomeCompleto() + ".");
			this.ultimaRecomendacao = LocalDate.now();
		} else {
			long diasEntreSugestoes = 30 - ChronoUnit.DAYS.between(ultimaRecomendacao, LocalDate.now());
			System.out.println("Você só pode fazer uma sugestão espere " + diasEntreSugestoes
					+ " dias pra fazer a proxima recomendação.");
		}
	}

	public void RecomendarFilme(Usuario user, Filme filme, String porqueRecomendou) {
		user.getFilmesRecomendados().add("User: " + this.getNomeCompleto() + " | Recomendou o filme: " + filme.getNome()
				+ " | Motivo: " + porqueRecomendou);
		System.out.println(
				this.getNomeCompleto() + " recomendou " + filme.getNome() + " para " + user.getNomeCompleto() + ".");
	}

	public void CurtirFilme(Filme filme) {
		this.filmesCurtidos.add(filme);
		System.out.println(this.getNomeCompleto() + " curtiu o filme: " + filme.getNome() + ".");
	}

	public void DescurtirFilme(Filme filme) {
		this.filmesNaoCurtidos.add(filme);
		System.out.println(this.getNomeCompleto() + " não curtiu o filme: " + filme.getNome() + ".");
	}

	private int CalcularIdade() {
		return (int) ChronoUnit.YEARS.between(this.FatorarAniversario(), LocalDate.now());
	}

	public void pagar() {
		this.ultimoPagamento = LocalDate.now();
	}

	private boolean verificacaoPagamento() {
		if (ChronoUnit.MONTHS.between(ultimoPagamento, LocalDate.now()) >= 1) {
			return false;
		}

		return true;
	}

	private LocalDate FatorarAniversario() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return LocalDate.parse(this.dataAniversario, formatter);
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getDataAniversario() {
		return dataAniversario;
	}

	public ArrayList<Filme> getFilmesCurtidos() {
		return filmesCurtidos;
	}

	public int getIdade() {
		return idade;
	}

	public ArrayList<String> getFilmesRecomendados() {
		return filmesRecomendados;
	}

	public LocalDate getUltimaRecomendacao() {
		return ultimaRecomendacao;
	}


	@Override
	public String toString() {
		return "Usuario [nomeCompleto=" + nomeCompleto + ", endereco=" + endereco + ", dataAniversario="
				+ dataAniversario + "]";
	}

}
