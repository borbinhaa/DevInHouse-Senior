package aula01;

public class Main {

	public static void main(String[] args) {

		Carro gol = new Carro("SJX2500", "Branco", "gol");
		Carro ka = new Carro("SJX2500", "Vermelho", "Ka");

		System.out.println(gol.equals(ka));
		System.out.println(ka);
		System.out.println(ka.toString());

		gol.setCor("Verde");
		System.out.println(gol.getCor());
	}
}
