package aula01;

public class VariavelInstancia {
	static int value;
	// com o static vira uma variavel de classe, logo será compartilhada com todas as instâncias da classe
	
	
	int instanceValue;
	// assim é uma variável de instância
	
	
	public static void main(String[] args) {
		System.out.println(value);
		value = 10;
		System.out.println(value);
		
	}
}