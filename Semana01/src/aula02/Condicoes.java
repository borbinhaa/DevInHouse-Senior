package aula02;

import java.util.Scanner;

public class Condicoes {
	
	public static void main(String[] args) {
		Scanner scanner;
		scanner = new Scanner(System.in);
		int idade = scanner.nextInt();
		
//		String x = estoque ? disponivel : indisponivel;		
//      o nome disso é if ternario
		
		String status = idade > 60
				? "Idoso" // se true
				: idade > 18 // se false
					? "Maior de idade"
					: "Menor de idade";

//		if (idade > 17) {
//			System.out.println("Maior de idade");
//		} else {
//			System.out.println("Menor de idade");
//		}
	
		System.out.println(status);
		
		scanner.close();
	}
}
