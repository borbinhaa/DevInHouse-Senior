package aula01.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Teste {

	public static void main(String[] args) {
		
		List<Integer> inteiros = Arrays.asList(1, 5, 6, 7, 8, 8, 9, 10, 3);
		List<Conteudo> conteudos = new ArrayList<Conteudo>();

		Filme filme1 = new Filme("Anaconda");
		Filme filme2 = new Filme("bee Movie");
		Filme filme3 = new Filme("Velozes e Furiosos");
		Filme filme4 = new Filme("Harry Potter");
		Filme filme5 = new Filme("Spider Man");

		Serie serie1 = new Serie("Friends");
		Serie serie2 = new Serie("B99");
		Serie serie3 = new Serie("Demolidor");
		Serie serie4 = new Serie("Arrow");
		Serie serie6 = new Serie("Arrow");
		Serie serie5 = new Serie("Flash");

		conteudos.add(serie1);
		conteudos.add(serie3);
		conteudos.add(serie2);
		conteudos.add(serie4);
		conteudos.add(serie5);
		conteudos.add(serie6);
		conteudos.add(filme1);
		conteudos.add(filme1);
		conteudos.add(filme2);
		conteudos.add(filme3);
		conteudos.add(filme4);
		conteudos.add(filme5);
		
		
		// OPERADORES INTERMEDIARIOS
		
		// FILTER E COLLECT
		List<Conteudo> filmes = conteudos.stream().filter(conteudo -> conteudo.getTipo().equals(TipoConteudo.FILME))
				.collect(Collectors.toList());

		Set<Conteudo> serieArrow = conteudos.stream()
				.filter(conteudo -> conteudo.getNome().equals("Arrow") && conteudo.getTipo().equals(TipoConteudo.SERIE))
				.collect(Collectors.toSet());
		
		Map<TipoConteudo, List<Conteudo>> map = conteudos.stream()
				.collect(Collectors.groupingBy(conteudo -> conteudo.getTipo())); 
		// retornou um map {SERIE = [serie1, serie2, ...], FILME = [filme1, filme2, ...]}
		
		String collect = inteiros.stream()
				.map(e -> Integer.toString(e)) // joining só funciona com strings
				.collect(Collectors.joining(";"));
		
		System.out.println(collect);
		
		// MAP
		inteiros.stream()
			.map(inteiro -> inteiro * 2) // não altera a lista original
			.forEach(inteiro -> System.out.println(inteiro));
		
		System.out.println("\n-----------NORMAL-----------\n");

		filmes.stream().forEach(conteudo -> System.out.println(conteudo.getNome() + conteudo.getTipo()));

		System.out.println("\n-----------SKIP-----------\n");

		filmes.stream().skip(2)// pulou os 2 primeiros
				.forEach(conteudo -> System.out.println(conteudo.getNome() + conteudo.getTipo()));

		System.out.println("\n-----------LIMIT-----------\n");

		serieArrow.stream().limit(1) // so mostrou 1
				.forEach(conteudo -> System.out.println(conteudo.getNome() + conteudo.getTipo()));

		System.out.println("\n-----------DISTINCT-----------\n");

		filmes.stream().distinct()// elimita os iguais
				.forEach(conteudo -> System.out.println(conteudo.getNome()));
		
		// OPERADORES FINAIS
		
		System.out.println("\n-----------COUNT, MIN e MAX -----------\n");
		
		Optional<Integer> max = inteiros.stream().distinct().max(Comparator.naturalOrder()); // Usa o compareTo da classe
		Optional<Integer> min = inteiros.stream().limit(5).min(Comparator.naturalOrder()); // Usa o compareTo da classe
		
		System.out.println(inteiros.stream().filter(i -> i % 2 == 0).count()); // parece .size()
		System.out.println(min.get()); 
		System.out.println(max.get()); 
	}
}
