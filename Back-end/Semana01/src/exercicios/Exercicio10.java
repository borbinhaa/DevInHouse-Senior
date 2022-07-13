// Crie um software que verifica se um número inserido pelo usuário é primo

package exercicios;

import java.util.Scanner;

public class Exercicio10 {
	public static void main(String[] args) {
		int numDivisiveis = 0;
		Scanner scanner = new Scanner(System.in);

		System.out.print("Digite um número: ");
		int num = scanner.nextInt();

		for (int i = 1; i <= num; i++) {
			if (num % i == 0) {
				numDivisiveis++;
			}
		}

		if (numDivisiveis == 2) {
			System.out.println("O número é primo.");
		} else {
			System.out.println("O número não é primo.");
		}

		scanner.close();
	}
}