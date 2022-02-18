package exercicio3e4;

import org.apache.commons.lang3.StringUtils;

import lombok.Getter;


public class Cliente {
	@Getter
	private String nome;

	public Cliente(String nome) {
		this.nome = nome;
	}
	
	public static void main(String[] args) {
		Cliente client = new Cliente("Antonio Da Silva");
		
		System.out.println(StringUtils.abbreviate(client.getNome(), 15));
	}
}
