// Crie um programa em Java que, utilizando a classe Scanner, pergunte ao usu�rio seu sobrenome, 
// depois seu nome, e ent�o escreva na tela, em uma �nica �string�, o nome completo do usu�rio.

package exercicios;

import java.util.Scanner;

public class Exercicio03 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.print("Escreva seu nome: ");
		String nome = scanner.nextLine();
		System.out.print("Escreva seu sobrenome: ");
		String sobrenome = scanner.nextLine();

		String nomeCompleto = nome + " " + sobrenome;

		char firstLetter = nomeCompleto.charAt(0);

		String nomeCompletoTitle = nomeCompleto.replace(firstLetter, Character.toUpperCase(firstLetter));

		System.out.println(nomeCompletoTitle);

		scanner.close();
	}
}
