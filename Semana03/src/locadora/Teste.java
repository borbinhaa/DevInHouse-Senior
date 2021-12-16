package locadora;

import clientes.Cliente;
import clientes.TipoPessoa;

public class Teste {

	public static void main(String[] args) {

		Carro carro1 = new Carro();
		carro1.setCategoriaPreco(CategoriaCarro.BASICO);
		Carro carro2 = new Carro();
		carro2.setCategoriaPreco(CategoriaCarro.LUXO);
		
		carro1.getCategoriaPreco().getPrecoDiaria();

		Cliente cliente1 = new Cliente();
		Cliente cliente2 = new Cliente();

		cliente1.setCnpj("11111111111");
		cliente1.setTipo(TipoPessoa.FISICA);
		cliente2.setCpf("111111111");
		cliente2.setTipo(TipoPessoa.JURIDICA);

		if (TipoPessoa.FISICA.equals(cliente1.getTipo())) {
			System.out.println("Pessoa física");
		} else {
			System.out.println("Pessoa jurídica");
		}
		
	}
}
