// Crie um programa em Java que, utilizando a classe Scanner, peça ao usuário para inserir as notas
// do semestre, e deve retornar a média final. O programa deve pedir 3 notas, que devem ser números
// reais, e retornar um número real com 2 casas depois da vírgula, com o texto “Sua média final é:”
// seguido do valor.

package exercicios;

import java.util.Scanner;
import java.util.Locale;


public class Exercicio06 {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
	
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Digite a nota do seu primeiro trimestre: ");
		double nota1 = scanner.nextDouble();
		System.out.print("Digite a nota do seu segundo trimestre: ");
		double nota2 = scanner.nextDouble();		
		System.out.print("Digite a nota do seu terceiro trimestre: ");
		double nota3 = scanner.nextDouble();
		
		double notaFinal = (nota1 + nota2 + nota3) / 3;
				
		System.out.println(String.format("%.2f",notaFinal));
		
		scanner.close();
	}
}