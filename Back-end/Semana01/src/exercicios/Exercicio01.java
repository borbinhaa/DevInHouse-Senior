// Crie um programa em Java que, ao executar, escreve na tela um número aleatório entre 0 e 1

package exercicios;

import java.util.Random;

public class Exercicio01 {
	public static void main(String[] args) {
		Random random = new Random();

		for (int i = 0; i <= 10; i++) {
			System.out.println(random.nextDouble());
		}
	}
}