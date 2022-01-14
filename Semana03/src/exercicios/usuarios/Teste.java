package exercicios.usuarios;

import exercicios.filmes.Comentario;
import exercicios.filmes.Episodio;
import exercicios.filmes.Filme;
import exercicios.filmes.Generos;
import exercicios.filmes.Serie;
import exercicios.recomendacoes.Plataforma;

public class Teste {

	public static void main(String[] args) {

		Plataforma DevInFlix = new Plataforma("DevInFlix");

		Moderador moderador = new Moderador("Rodrigues", DevInFlix);

		Serie serie = new Serie("Breaking Bad", "Professor de Quimica decide fazer droga", Generos.SUSPENSE,
				"http://www", 18);
		Episodio ep1 = new Episodio("Episodio 1", "Sinopse", "20/02/1999", "http://", serie);
		Episodio ep2 = new Episodio("Episodio 2", "Sinopse", "27/02/1999", "http://", serie);
		Episodio ep3 = new Episodio("Episodio 3", "Sinopse", "04/03/1999", "http://", serie);
		Episodio ep4 = new Episodio("Episodio 4", "Sinopse", "06/03/1999", "http://", serie);
		Episodio ep5 = new Episodio("Episodio 5", "Sinopse", "07/03/1999", "http://", serie);
		Episodio ep6 = new Episodio("Episodio 6", "Sinopse", "08/03/1999", "http://", serie);

		Filme filme1 = new Filme("Até que a Sorte Nos Separe", "Filme de comedia", Generos.COMEDIA, "htttp://", 14);
		Filme filme2 = new Filme("Projeto X", "Filme de uma festa mto louca", Generos.COMEDIA, "htttp://", 16);
		Filme filme3 = new Filme("Patrulha Canina", "Filme de cachorros que são detetives", Generos.INFANTIL,
				"htttp://", 0);
		Filme filme4 = new Filme("Barraca do beijo", "Filme de romance", Generos.ROMANCE, "htttp://", 12);
		Filme filme5 = new Filme("Velozes e furiosos", "Filme de carro", Generos.ACAO, "htttp://", 14);
		Filme filme6 = new Filme("It a coisa", "Filme de um palhaço maluco", Generos.TERROR, "htttp://", 16);

		DevInFlix.addConteudo(filme1);
		DevInFlix.addConteudo(filme2);
		DevInFlix.addConteudo(filme3);
		DevInFlix.addConteudo(filme4);
		DevInFlix.addConteudo(filme5);
		DevInFlix.addConteudo(filme6);
		DevInFlix.addConteudo(serie);

		Conta conta = new Conta("Login", "Senha", "email");
		Conta conta2 = new Conta("Login2", "Senha2", "email2");
		Conta conta3 = new Conta("Login3", "Senha3", "email3");

		Usuario usuario1 = new Usuario("Gabriel", "Rua x, 123", "13/01/2004");
		Usuario usuario2 = new Usuario("Pedro", "Rua y, 321", "03/12/2010");
		Usuario usuario3 = new Usuario("Maria", "Rua z, 789", "22/07/2002");
		Usuario usuario4 = new Usuario("Giovanna", "Rua b, 000", "15/09/2003");
		Usuario usuario5 = new Usuario("Leonardo", "Rua a, 777", "12/12/2008");

		Comentario comentario = new Comentario("Filme muito bom", usuario2, filme4);
		Comentario comentario2 = new Comentario("Filme ótimo para assistir em família", usuario5, filme4);

		conta.registrarUsuario(usuario1);
		conta.registrarUsuario(usuario2);
		conta.registrarUsuario(usuario3);
		conta.registrarUsuario(usuario4);
		conta.removerUsuario(usuario2);
		conta.registrarUsuario(usuario5);
		conta.registrarUsuario(usuario5);
		conta2.registrarUsuario(usuario2);
		conta3.registrarUsuario(usuario2);
		conta3.registrarUsuario(usuario2);
		conta3.registrarUsuario(usuario2);

		System.out.println(conta.getUsuarios().size());
		System.out.println("Preço conta 1: " + conta.getPrecoPagamento());
		System.out.println("Preço conta 2: " + conta2.getPrecoPagamento());
		System.out.println("Preço conta 3: " + conta3.getPrecoPagamento());

		DevInFlix.curtirDescurtirFilme(usuario1, filme1, true);
		DevInFlix.curtirDescurtirFilme(usuario2, filme2, false);
		DevInFlix.curtirDescurtirFilme(usuario3, filme3, true);
		DevInFlix.curtirDescurtirFilme(usuario4, filme2, false);
		DevInFlix.curtirDescurtirFilme(usuario5, filme4, true);
		DevInFlix.curtirDescurtirFilme(usuario5, filme1, true);
		DevInFlix.curtirDescurtirFilme(usuario5, filme1, true);

		System.out.println("\n---------------------------");

		usuario1.recomendarFilme(usuario5, filme3, "Filme muito bom para criancas");
		usuario5.recomendarFilme(usuario2, filme6, "Filme me deu mto medo e me prendeu muito");
		usuario3.recomendarFilme(usuario5, filme5, "Toretto é bala");

		System.out.println("\n---------------------------");

		usuario2.sugerirFilme(DevInFlix, "Venom");
		usuario5.sugerirFilme(DevInFlix, "007");
		usuario5.sugerirFilme(DevInFlix, "007");
		usuario3.sugerirFilme(DevInFlix, "Sonic");

		System.out.println("\n---------------------------");

		DevInFlix.selecionarFilme(usuario1, filme4);
		DevInFlix.selecionarFilme(usuario3, filme4);
		DevInFlix.selecionarFilme(usuario4, filme4);
		DevInFlix.selecionarFilme(usuario1, filme1);
		DevInFlix.selecionarFilme(usuario2, filme4);
		DevInFlix.selecionarFilme(usuario1, filme3);
		DevInFlix.selecionarFilme(usuario1, filme3);
		DevInFlix.selecionarFilme(usuario2, filme6);
		DevInFlix.selecionarFilme(usuario2, filme5);
		DevInFlix.selecionarFilme(usuario2, filme4);

		System.out.println("\n---------------------------");

		System.out.println(DevInFlix.getFilmesCurtidosUser(usuario1));
		System.out.println(DevInFlix.getFilmesNaoCurtidosUser(usuario1));
		System.out.println(DevInFlix.getFilmesCurtidosUser(usuario3));
		System.out.println(DevInFlix.getFilmesNaoCurtidosUser(usuario4));

		System.out.println("\n---------------------------");

		System.out.println(filme4.getVezesAssistidas());
		System.out.println(filme3.getVezesAssistidas());
		System.out.println(Generos.ROMANCE.getVezesAssistidas());
		System.out.println(Generos.INFANTIL.getVezesAssistidas());

		System.out.println(DevInFlix.getGeneroMaisAssistido());

		System.out.println("\n---------------------------");

		DevInFlix.comentar(comentario);
		DevInFlix.comentar(comentario2);
		System.out.println(filme4.getComentarios());
		moderador.setConteudoImproprio(comentario2);
		System.out.println(filme4.getComentarios());

		System.out.println(DevInFlix.getConteudos());
		moderador.setConteudoImproprio(filme6);
		System.out.println(DevInFlix.getConteudos());

		DevInFlix.selecionarFilme(usuario5, filme6);
		DevInFlix.selecionarFilme(usuario3, filme6);
		System.out.println(DevInFlix.getConteudosImproprios());

		System.out.println("\n---------------------------");

		serie.addEpisodio(ep1);
		serie.addEpisodio(ep2);
		serie.addEpisodio(ep6);
		serie.addEpisodio(ep4);
		serie.addEpisodio(ep3);
		serie.addEpisodio(ep5);

		System.out.println(serie.getEpisodios());
		serie.organizarEpisodios();
		System.out.println(serie.getEpisodios());

		for (Episodio ep : serie.getEpisodios()) {
			System.out.println(ep.getDataLancamento());
		}

	}
}
