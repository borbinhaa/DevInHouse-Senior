// Crie um programa em Java que, utilizando a classe Scanner, pe�a ao usu�rio para inserir as notas
// do semestre, e deve retornar a m�dia final. O programa deve pedir 3 notas, que devem ser n�meros
// reais, e retornar um n�mero real com 2 casas depois da v�rgula, com o texto �Sua m�dia final �:�
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