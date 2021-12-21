package aula03.conta;

public class TesteConta {

	public static void main(String[] args) {
		
		Conta conta1 = new Conta();
		conta1.setAg("10");
		conta1.getAg();
		conta1.setCc("355679");
		
		
		
		Conta conta2 = new Conta();
		conta2.setAg("10");
		conta2.getAg();
		conta2.setCc("355679");
		
		
		conta1.transferencia(conta2, 100);
		System.out.println(conta1.getSaldo());
		System.out.println(conta2.getSaldo());
	}

}
