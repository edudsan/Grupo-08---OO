package veiculos;

import java.util.Date;

public class Veiculo {
	private String marca, modelo, renavam;
	private Date anoDeModelo, anoDeFabricacao;
	private double capacidadeTanque, diariaPF, diariaReduzidaPF, valorMensal;
	
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
}
