package aula01.lambda;

public class Calculadora {

	public double opera(double a, double b, Operacao operacao) {
		return operacao.operaValores(a, b);
	}
	
	public static void main(String[] args) {
		Operacao adicao = (double a, double b) -> a + b ;
		Operacao subtracao = (double a, double b) -> a - b;
		Operacao multiplicacao = (double a, double b) -> a * b;
	
		System.out.println(adicao.operaValores(15, 20));
		System.out.println(subtracao.operaValores(15, 20));
		System.out.println(multiplicacao.operaValores(15, 20));
	}
}
