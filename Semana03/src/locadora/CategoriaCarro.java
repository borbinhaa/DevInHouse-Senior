package locadora;

public enum CategoriaCarro {

	// ("precoDiaria", "precoPorKm")
	LUXO(230.0, 10.0), BASICO(120.0, 7.0), INTERMEDIARIO(180.0, 8.50), PROMO(49.90, 5.0);

	double precoDiaria;
	double precoPorKm;

	CategoriaCarro(double precoDiaria, double precoPorKm) {
		this.precoDiaria = precoDiaria;
		this.precoPorKm = precoPorKm;
	}
	
	public double getPrecoDiaria() {
		return precoDiaria;
	}

	public void setPrecoDiaria(double precoDiaria) {
		this.precoDiaria = precoDiaria;
	}

	public double getPrecoPorKm() {
		return precoPorKm;
	}

	public void setPrecoPorKm(double precoPorKm) {
		this.precoPorKm = precoPorKm;
	}
}
