package aula02.classeabstrata;

public class Teste {
	public static void main(String[] args) {
		
		FormaPagamento pagamentoBoleto = new PagamentoBoleto();
		FormaPagamento pagamentoCartao = new CartaoCredito();
		PagamentoCartao visa = new CartaoCredito();
	}
}
