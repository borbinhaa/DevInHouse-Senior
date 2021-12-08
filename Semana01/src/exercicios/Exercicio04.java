// Crie um programa em Java que, utilizando a classe Scanner, peça ao usuário que digite um número
// com 2 ou mais casas depois da vírgula, converta esse número para um inteiro e escreva o resultado
// na tela.

package exercicios;

import java.util.Scanner;

public class Exercicio04 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Digite um número com 2 ou mais casas decimais: ");
		double number = scanner.nextDouble();

		int numberInt = (int) number;

		System.out.println(numberInt);

		scanner.close();
	}
}