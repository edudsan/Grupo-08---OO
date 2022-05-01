package veiculos;

public class Carga extends Utilitario{
	private Double cargaMaxima, tara, volCompartimentoCarga;

	public Double getCargaMaxima() {
		return cargaMaxima;
	}

	public Double getTara() {
		return tara;
	}

	public Double getVolCompartimentoCarga() {
		return volCompartimentoCarga;
	}

	public void setCargaMaxima(Double cargaMaxima) {
		this.cargaMaxima = cargaMaxima;
	}

	public void setTara(Double tara) {
		this.tara = tara;
	}

	public void setVolCompartimentoCarga(Double volCompartimentoCarga) {
		this.volCompartimentoCarga = volCompartimentoCarga;
	}
	
	
}
