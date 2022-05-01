package veiculos;

public class Passageiro extends Utilitario{
	private int numOcupantes;
	private boolean arCondicionado, direcaoHidraulica, tvBordo;
	
	public int getNumOcupantes() {
		return numOcupantes;
	}
	public boolean isArCondicionado() {
		return arCondicionado;
	}
	public boolean isDirecaoHidraulica() {
		return direcaoHidraulica;
	}
	public boolean isTvBordo() {
		return tvBordo;
	}
	public void setNumOcupantes(int numOcupantes) {
		this.numOcupantes = numOcupantes;
	}
	public void setArCondicionado(boolean arCondicionado) {
		this.arCondicionado = arCondicionado;
	}
	public void setDirecaoHidraulica(boolean direcaoHidraulica) {
		this.direcaoHidraulica = direcaoHidraulica;
	}
	public void setTvBordo(boolean tvBordo) {
		this.tvBordo = tvBordo;
	}
}
