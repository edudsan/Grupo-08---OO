package gerenciadores;

import java.util.LinkedList;

import pessoas.Pessoa;
import veiculos.Veiculo;

public class Gerenciador {
	public static LinkedList<Pessoa> pessoa = new LinkedList<Pessoa>();
	public static LinkedList<Veiculo> veiculo = new LinkedList<Veiculo>();
	
	public LinkedList<Pessoa> getPessoa() {
		return pessoa;
	}
	public LinkedList<Veiculo> getVeiculo() {
		return veiculo;
	}
	public void setPessoa(LinkedList<Pessoa> pessoa) {
		Gerenciador.pessoa = pessoa;
	}
	public void setVeiculo(LinkedList<Veiculo> veiculo) {
		Gerenciador.veiculo = veiculo;
	}
}
