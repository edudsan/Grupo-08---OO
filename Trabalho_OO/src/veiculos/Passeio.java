package veiculos;

public class Passeio extends Veiculo{
	private boolean arCondicionado, direcaoHidraulica, cambioAutomatico;

	public boolean isArCondicionado() {
		return arCondicionado;
	}

	public boolean isDirecaoHidraulica() {
		return direcaoHidraulica;
	}

	public boolean isCambioAutomatico() {
		return cambioAutomatico;
	}

	public void setArCondicionado(boolean arCondicionado) {
		this.arCondicionado = arCondicionado;
	}

	public void setDirecaoHidraulica(boolean direcaoHidraulica) {
		this.direcaoHidraulica = direcaoHidraulica;
	}

	public void setCambioAutomatico(boolean cambioAutomatico) {
		this.cambioAutomatico = cambioAutomatico;
	}

}
