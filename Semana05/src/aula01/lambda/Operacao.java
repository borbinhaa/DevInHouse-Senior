package aula01.lambda;

public interface Operacao {

	double operaValores(double a, double b);
	default int operaValores(int a, int b) {
		return a + b;
	}
}
