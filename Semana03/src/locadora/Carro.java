package locadora;

import servicos.CategoriaHabilitacao;

public class Carro {
	
	String fabricante;
	String cor;
	String modelo;
	String placa;
	CategoriaCarro categoriaPreco;
	CategoriaHabilitacao categoriaHabilitacao;
	
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
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
	public CategoriaCarro getCategoriaPreco() {
		return categoriaPreco;
	}
	public void setCategoriaPreco(CategoriaCarro categoriaPreco) {
		this.categoriaPreco = categoriaPreco;
	}
	
	public CategoriaHabilitacao getCategoriaHabilitacao() {
		return categoriaHabilitacao;
	}
	public void setCategoriaHabilitacao(CategoriaHabilitacao categoriaHabilitacao) {
		this.categoriaHabilitacao = categoriaHabilitacao;
	}
	 

	
}
