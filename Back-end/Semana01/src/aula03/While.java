package aula03;

import java.util.Random;
import java.util.Scanner;

public class While {
	
// Vamos gerar um número aleatório entre 5 e 10 d pedir ao usuário que adivinhe esse número.
	
	public static void main(String[] args) {
//		Random random = new Random();
//		int numeroSecreto = random.nextInt(6) + 5;
		
		int numeroSecreto = new Random().nextInt(6) + 5;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Tente adivinhar o número.");
		int tentativaUsuario = scanner.nextInt();
		
		while (numeroSecreto != tentativaUsuario) {
			System.out.println("Numero incorreto, tente novamente.");
			tentativaUsuario = scanner.nextInt();
		}
		
		System.out.println("MuitoBem!");
		
		scanner.close();
	}
}