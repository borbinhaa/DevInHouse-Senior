package aula02.excecoes;

import java.util.Scanner;

import aula02.exception.EntradaIncorretaException;

public class Teste {

	public void realizaDivisao() throws EntradaIncorretaException  {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite 1 n�mero: ");
		int x = scanner.nextInt();
		System.out.println("Digite outro n�mero: ");
		int y = scanner.nextInt();
		if (y == 0) {
			throw new EntradaIncorretaException("O numero est� incorreto");
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
