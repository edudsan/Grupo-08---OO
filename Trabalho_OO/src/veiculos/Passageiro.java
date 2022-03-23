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
}
