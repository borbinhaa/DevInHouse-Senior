package aula02.classeabstrata;

public class CartaoDebito extends PagamentoCartao {

	@Override
	public boolean devolucao() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean pagou() {
		// TODO Auto-generated method stub
		return false;
	}

}
