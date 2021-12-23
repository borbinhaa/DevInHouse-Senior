package exercicios.usuarios;

import exercicios.filmes.Filme;
import exercicios.filmes.Generos;
import exercicios.recomendacoes.Plataforma;

public class Teste {

	public static void main(String[] args) {

		Plataforma DevInFlix = new Plataforma("DevInFlix");

		Filme filme1 = new Filme("Até que a Sorte Nos Separe", "Filme de comedia", Generos.COMEDIA, "htttp://");
		Filme filme2 = new Filme("Projeto X", "Filme de uma festa mto louca", Generos.COMEDIA, "htttp://");
		Filme filme3 = new Filme("Patrulha Canina", "Filme de cachorros que são detetives", Generos.INFANTIL, "htttp://");
		Filme filme4 = new Filme("Barraca do beijo", "Filme de romance", Generos.ROMANCE, "htttp://");
		Filme filme5 = new Filme("Velozes e furiosos", "Filme de carro", Generos.ACAO, "htttp://");
		Filme filme6 = new Filme("It a coisa", "Filme de um palhaço maluco", Generos.TERROR, "htttp://");

		Usuario usuario1 = new Usuario("Gabriel", "Rua x, 123", "09/01/2004");
		Usuario usuario2 = new Usuario("Pedro", "Rua y, 321", "03/12/2010");
		Usuario usuario3 = new Usuario("Maria", "Rua z, 789", "22/07/2002");
		Usuario usuario4 = new Usuario("Giovanna", "Rua b, 000", "15/09/2003");
		Usuario usuario5 = new Usuario("Leonardo", "Rua a, 777", "12/12/2008");

		usuario1.CurtirFilme(filme1);
		usuario2.DescurtirFilme(filme2);
		usuario3.DescurtirFilme(filme5);
		usuario4.CurtirFilme(filme6);
		usuario5.CurtirFilme(filme2);
		
		System.out.println("\n---------------------------");
		
		usuario1.RecomendarFilme(usuario5, filme3, "Filme muito bom para criancas");
		usuario5.RecomendarFilme(usuario2, filme6, "Filme me deu mto medo e me prendeu muito");
		usuario3.RecomendarFilme(usuario5, filme5, "Toretto é bala");
		
		System.out.println("\n---------------------------");
		
		usuario2.SugerirFilme(DevInFlix, "Venom");
		usuario5.SugerirFilme(DevInFlix, "007");
		usuario5.SugerirFilme(DevInFlix, "007");
		usuario3.SugerirFilme(DevInFlix, "Sonic");
		
		System.out.println("\n---------------------------");
		
		usuario1.assistirFilme(filme4);
		usuario3.assistirFilme(filme4);
		usuario4.assistirFilme(filme4);
		usuario1.assistirFilme(filme1);
		usuario2.assistirFilme(filme4);
		usuario1.assistirFilme(filme3);
		usuario1.assistirFilme(filme3);
		usuario2.assistirFilme(filme6);
		usuario2.assistirFilme(filme6);
		usuario2.assistirFilme(filme6);
		
		
		System.out.println("\n---------------------------");
		
		System.out.println(filme4.getVezesAssistidas());
		System.out.println(filme3.getVezesAssistidas());
		System.out.println(usuario1.getFilmesCurtidos());
		System.out.println(Generos.ROMANCE.getVezesAssistidas());
		System.out.println(Generos.INFANTIL.getVezesAssistidas());
		
		System.out.println(DevInFlix.getGeneroMaisAssistido());
		
	}
}
