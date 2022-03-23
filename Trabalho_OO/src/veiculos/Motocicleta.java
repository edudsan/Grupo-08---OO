package veiculos;

public class Motocicleta extends Veiculo{
	private boolean controleTracao, freioABS, pilotoAutomatico, modoCidade, modoEstrada, modoSport, modoOffRoad;

	public boolean isControleTracao() {
		return controleTracao;
	}

	public boolean isFreioABS() {
		return freioABS;
	}

	public boolean isPilotoAutomatico() {
		return pilotoAutomatico;
	}

	public boolean isModoCidade() {
		return modoCidade;
	}

	public boolean isModoEstrada() {
		return modoEstrada;
	}

	public boolean isModoSport() {
		return modoSport;
	}

	public boolean isModoOffRoad() {
		return modoOffRoad;
	}
}
