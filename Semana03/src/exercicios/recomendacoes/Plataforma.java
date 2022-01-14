package exercicios.recomendacoes;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import exercicios.filmes.Comentario;
import exercicios.filmes.Conteudo;
import exercicios.filmes.Filme;
import exercicios.filmes.Generos;
import exercicios.filmes.Moderavel;
import exercicios.usuarios.Conta;
import exercicios.usuarios.Usuario;
import lombok.Getter;

public class Plataforma {

	@Getter
	private String app;
	@Getter
	private HashSet<String> filmesSugeridos = new HashSet<>();
	@Getter
	private HashSet<Conteudo> conteudos = new HashSet<>();
	@Getter
	private HashSet<Moderavel> conteudosImproprios = new HashSet<>();
	private HashMap<String, ArrayList<Filme>> filmesCurtidosENaoCurtidos = new HashMap<>();
	private Generos maisAssistido;
	private long maior = 0;

	public Plataforma(String app) {
		this.app = app;
	}

	public void selecionarFilme(Usuario user, Filme filme) {
//		Scanner scanner = new Scanner(System.in);

		if (!this.verificacaoPagamento(user.getConta())) {
			System.out.println("Você precisa pagar sua assinatura.");
		} else if (user.getIdade() < filme.getFaixaEtaria()) {
			System.out.println("Você não tem idade suficiente para assistir esse filme.");
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

	public void curtirDescurtirFilme(Usuario user, Filme filme, boolean curtir) {
		if (curtir) {
			filme.setCurtidas(filme.getCurtidas() + 1);
			user.getFilmesCurtidos().add(filme);
		} else {
			filme.setDescurtidas(filme.getDescurtidas() + 1);
			user.getFilmesNaoCurtidos().add(filme);
		}
	}

	public void comentar(Comentario comentario) {
		if (comentario.isImproprio()) {
			System.out.println("Comentario Improprio");
		} else {
			comentario.getConteudo().addComentario(comentario);
		}
	}

	public void addConteudo(Conteudo conteudo) {
		conteudos.add(conteudo);
	}

	public ArrayList<Filme> getFilmesCurtidosUser(Usuario user) {
		return user.getFilmesCurtidos();
	}

	public ArrayList<Filme> getFilmesNaoCurtidosUser(Usuario user) {
		return user.getFilmesNaoCurtidos();
	}

	public HashMap<String, ArrayList<Filme>> getFilmesCurtidosENaoCurtidosUser(Usuario user) {
		filmesCurtidosENaoCurtidos.put("Curtidos", user.getFilmesCurtidos());
		filmesCurtidosENaoCurtidos.put("Não Curtidos", user.getFilmesNaoCurtidos());
		return filmesCurtidosENaoCurtidos;
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

	private boolean verificacaoPagamento(Conta conta) {
		if (ChronoUnit.MONTHS.between(conta.getUltimoPagamento(), LocalDate.now()) >= 1) {
			return false;
		}

		return true;
	}
}
