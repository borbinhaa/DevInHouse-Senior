package aula03;

import java.util.Scanner;

public class TestePalindromo {
	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		String leitura = leitor.nextLine();
		String leituraAoContrario = "";
		
		System.out.println(leitura.length());
		for (int i = leitura.length()-1; i >= 0; i--) { // as string comecam no index 0, ,então precisa diminuir 1	
			leituraAoContrario += leitura.charAt(i);
		}
		System.out.println(leituraAoContrario);
		System.out.println(leitura);
		
		System.out.println(leitura.equals(leituraAoContrario));
		

		leitor.close();
	}
}