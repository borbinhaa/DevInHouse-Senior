// Crie um programa em Java que, utilizando a classe Scanner, calcule o fatorial de um n�mero
// inteiro de 0 a 10. O programa deve pedir para o usu�rio inserir um n�mero inteiro, mas s� deve
// aceitar valores de 0 a 10, e ent�o deve calcular o fatorial desse n�mero e escrever o resultado
// na tela.

package exercicios;

import java.util.Scanner;

public class Exercicio07 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Digite um numero inteiro entre 0 e 10: ");
		int num = scanner.nextInt();
		int fatorial = 1;
		
		while (num > 10 || num < 0) {
			System.out.print("Numero precisa estar entre 0 e 10.\nDigite outro: ");
			num = scanner.nextInt();
		}

		for (int i = 1; i <= num; i++) {
			fatorial = fatorial * i;
		}
		System.out.println("O fatorial do numero " + num + " �: " + fatorial);
		
		scanner.close();
	}
}