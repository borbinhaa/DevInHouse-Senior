package aula03;

public class TypeCasting {
	public static void main(String[] args) {

		int x = 10;
		long y = x;
		System.out.println(y);

		long x2 = 10;
		int y2 = (int) x2;
		System.out.println(y2);

		double x3 = 5.3;
		int y3 = (int) x3;
		System.out.println(y3);

		double x4 = 5.5;
		float y4 = (float) x4;
		System.out.println(y4);

		float x5 = 5.5f;
		double y5 = x5;
		System.out.println(y5);

		String numero = "25.53";
		double numeroInteiro = Double.parseDouble(numero); // transforma em double
		System.out.println(numeroInteiro);

		int numeroInteiro2 = 10;
		String numero2 = "" + numeroInteiro2; // transforma em String
		System.out.println(numero2);
	}
}