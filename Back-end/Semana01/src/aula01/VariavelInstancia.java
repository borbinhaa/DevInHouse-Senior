package aula01;

public class VariavelInstancia {
	static int value;
	// com o static vira uma variavel de classe, logo ser� compartilhada com todas as inst�ncias da classe
	
	
	int instanceValue;
	// assim � uma vari�vel de inst�ncia
	
	
	public static void main(String[] args) {
		System.out.println(value);
		value = 10;
		System.out.println(value);
		
	}
}