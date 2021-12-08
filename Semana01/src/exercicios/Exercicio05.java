// Crie um programa em Java que, utilizando a classe Scanner, peça ao usuário que digite um nome
// qualquer, e em seguida escreva na tela o tamanho de letras que o nome possui.

package exercicios;

import java.util.Scanner;

public class Exercicio05 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Digite um nome: ");
		String nome = scanner.nextLine();
		
		String nomeSemEspaco = nome.replaceAll(" ", "");
		
		System.out.println(nomeSemEspaco.length());
		
		scanner.close();
	}
}