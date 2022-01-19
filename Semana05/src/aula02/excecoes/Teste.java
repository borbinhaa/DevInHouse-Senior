package aula02.excecoes;

import java.util.Scanner;

import aula02.exception.EntradaIncorretaException;

public class Teste {

	public void realizaDivisao() throws EntradaIncorretaException  {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite 1 número: ");
		int x = scanner.nextInt();
		System.out.println("Digite outro número: ");
		int y = scanner.nextInt();
		if (y == 0) {
			throw new EntradaIncorretaException("O numero está incorreto");
		}
	
		System.out.println(x/y);
	}
	
	public static void main(String[] args) {
		Teste teste = new Teste();
		try {
			teste.realizaDivisao();
		} catch (EntradaIncorretaException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
