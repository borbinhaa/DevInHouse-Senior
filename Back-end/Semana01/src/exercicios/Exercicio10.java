// Crie um software que verifica se um n�mero inserido pelo usu�rio � primo

package exercicios;

import java.util.Scanner;

public class Exercicio10 {
	public static void main(String[] args) {
		int numDivisiveis = 0;
		Scanner scanner = new Scanner(System.in);

		System.out.print("Digite um n�mero: ");
		int num = scanner.nextInt();

		for (int i = 1; i <= num; i++) {
			if (num % i == 0) {
				numDivisiveis++;
			}
		}

		if (numDivisiveis == 2) {
			System.out.println("O n�mero � primo.");
		} else {
			System.out.println("O n�mero n�o � primo.");
		}

		scanner.close();
	}
}