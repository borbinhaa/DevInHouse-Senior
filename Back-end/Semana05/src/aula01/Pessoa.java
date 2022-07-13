package aula01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import lombok.Getter;

public class Pessoa implements Comparable<Pessoa> {
	
	@Getter 
	private String nome;
	@Getter 
	private String cpf;

	Pessoa(String nome, String cpf){
		this.nome = nome;
		this.cpf = cpf;
	}
	
	@Override
	public int compareTo(Pessoa o) {
		return this.getNome().compareTo(o.getNome());
	}
	
	public static void main(String[] args) {
		
		List<Pessoa> pessoas = new ArrayList<Pessoa>();
		
		Pessoa pessoa1 = new Pessoa("Pedro", "111111"); 
		Pessoa pessoa2 = new Pessoa("Antonio", "222222");
		Pessoa pessoa3 = new Pessoa("Antonio", "333333");
		Pessoa pessoa4 = new Pessoa("Antonio", "444444");
		Pessoa pessoa5 = new Pessoa("Antonio", "555555");
		
		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		pessoas.add(pessoa3);
		pessoas.add(pessoa4);
		pessoas.add(pessoa5);
		
		Comparator<Pessoa> comparacaoNomeCpf = Comparator.comparing(Pessoa::getNome).thenComparing(Pessoa::getCpf);
		
//		Collections.sort(pessoas, comparacaoNomeCpf); // desse está usando o metodo que a gnt criou
//		Collections.sort(pessoas); // desse jeito ele esta usando o compareTo da classe Pessoa
		
		
		Collections.sort(pessoas, new Comparator<Pessoa>() {

			@Override
			public int compare(Pessoa o1, Pessoa o2) {
				return o1.getNome().compareTo(o2.getNome());
			}
			
		}); // desse usa o metodo Comparator que eu criei agr
		
		for (Pessoa pessoa : pessoas) {
			System.out.println(pessoa.getNome() + pessoa.getCpf());
		}
	}



	
}
