package veiculos;

import java.util.Date;

public class Veiculo {
	private String marca, modelo, renavam;
	private Date anoDeModelo, anoDeFabricacao;
	private double capacidadeTanque, diariaPF, diariaPJ, diariaReduzidaPF, valorMensal;
	
	public String getMarca() {
		return marca;
	}
	public String getModelo() {
		return modelo;
	}
	public String getRenavam() {
		return renavam;
	}
	public Date getAnoDeModelo() {
		return anoDeModelo;
	}
	public Date getAnoDeFabricacao() {
		return anoDeFabricacao;
	}
	public double getCapacidadeTanque() {
		return capacidadeTanque;
	}
	public double getDiariaPF() {
		return diariaPF;
	}
	public double getDiariaReduzidaPF() {
		return diariaReduzidaPF;
	}
	public double getValorMensal() {
		return valorMensal;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}
	public void setAnoDeModelo(Date anoDeModelo) {
		this.anoDeModelo = anoDeModelo;
	}
	public void setAnoDeFabricacao(Date anoDeFabricacao) {
		this.anoDeFabricacao = anoDeFabricacao;
	}
	public void setCapacidadeTanque(double capacidadeTanque) {
		this.capacidadeTanque = capacidadeTanque;
	}
	public void setDiariaPF(double diariaPF) {
		this.diariaPF = diariaPF;
	}
	public void setDiariaReduzidaPF(double diariaReduzidaPF) {
		this.diariaReduzidaPF = diariaReduzidaPF;
	}
	public void setValorMensal(double valorMensal) {
		this.valorMensal = valorMensal;
	}
	public double getDiariaPJ() {
		return diariaPJ;
	}
	public void setDiariaPJ(double diariaPJ) {
		this.diariaPJ = diariaPJ;
	}
}
