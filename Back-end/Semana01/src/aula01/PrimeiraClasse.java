package aula01;
import java.util.Scanner;

public class PrimeiraClasse {
	
	public int soma (int x, int y) {
		return x + y;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int valor1, valor2;
		
		System.out.print("Digite um valor: ");
		valor1 = scanner.nextInt();
		System.out.print("Digite outro valor: ");
		valor2 = scanner.nextInt();
	
		System.out.printf("O valor da soma é %d.", (valor1+valor2));
		
		scanner.close();
	}
}