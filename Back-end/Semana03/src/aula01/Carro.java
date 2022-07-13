package aula01;

import java.util.Objects;

public class Carro {

	String cor;
	String modelo;
	String placa;
	boolean airbag;

	Carro(String placa, String cor, String modelo) {
		this.modelo = modelo;
		this.cor = cor;
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}


	@Override
	public boolean equals(Object carro2) {
		if (this == carro2)
			return true;
		if (carro2 == null)
			return false;
		if (getClass() != carro2.getClass())
			return false;
		Carro other = (Carro) carro2;
		return Objects.equals(placa, other.placa);
	}

	@Override
	public String toString() {
		return "Carro [cor=" + this.cor + ", modelo=" + this.modelo + ", placa=" + this.placa + "]";
	}

}
