// Crie um programa em Java que, utilizando a classe Scanner, pe�a ao usu�rio que digite um n�mero
// com 2 ou mais casas depois da v�rgula, converta esse n�mero para um inteiro e escreva o resultado
// na tela.

package exercicios;

import java.util.Scanner;

public class Exercicio04 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Digite um n�mero com 2 ou mais casas decimais: ");
		double number = scanner.nextDouble();

		int numberInt = (int) number;

		System.out.println(numberInt);

		scanner.close();
	}
}