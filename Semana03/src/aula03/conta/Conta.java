package aula03.conta;

public class Conta {

	private String ag;
	private String cc;
	private double saldo;
	private double chequeEspecial;

	public boolean transferencia(Conta contaDestino, double valor) {
		if (verificaContaDestino(contaDestino.ag, contaDestino.cc)) {
			if (verificaSaldo(valor) || verificaChequeEspecial(valor)) {
				contaDestino.saldo += valor;
				this.saldo -= valor;
			}
		}
		return false;
	}

	private boolean verificaContaDestino(String ag, String cc) {
		boolean existe = true;

		if (existe) {
			return true;
		}

		return false;
	}

	private boolean verificaSaldo(double valor) {
		if (this.saldo > valor) {
			return true;
		}

		return false;
	}

	private boolean verificaChequeEspecial(double valor) {
		if (this.saldo + this.chequeEspecial > valor) {
			return true;
		}

		return false;
	}

	public String getAg() {
		return ag;
	}

	public void setAg(String ag) {
		this.ag = ag;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public double getSaldo() {
		return saldo;
	}

	public double getChequeEspecial() {
		return chequeEspecial;
	}

	public void setChequeEspecial(double chequeEspecial) {
		this.chequeEspecial = chequeEspecial;
	}

}
