package aula03;

import java.util.Random;
import java.util.Scanner;

public class DoWhile {
	
	public static void main(String[] args) {
		int numeroSecreto = new Random().nextInt(6) + 5;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Tente adivinhar o número.");
		int tentativaUsuario = scanner.nextInt();
		
		do {
			System.out.println("Numero incorreto, tente novamente.");
			tentativaUsuario = scanner.nextInt();
		} while (numeroSecreto != tentativaUsuario);
		
		System.out.println("MuitoBem!");
		
		scanner.close();
	}
}