package gerenciadores;

import java.util.LinkedList;

import pessoas.Pessoa;
import veiculos.Veiculo;

public class Gerenciador {
	protected LinkedList<Pessoa> pessoa = new LinkedList<Pessoa>();
	protected LinkedList<Veiculo> veiculo = new LinkedList<Veiculo>();
	
	public LinkedList<Pessoa> getPessoa() {
		return pessoa;
	}
	public void setPessoa(LinkedList<Pessoa> pessoa) {
		this.pessoa = pessoa;
	}
	public LinkedList<Veiculo> getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(LinkedList<Veiculo> veiculo) {
		this.veiculo = veiculo;
	}
	

}
