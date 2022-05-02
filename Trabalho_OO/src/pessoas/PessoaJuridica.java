package pessoas;

import java.util.LinkedList;

public class PessoaJuridica extends Pessoa{
	private String cnpj;
	private LinkedList<PessoaFisica> funcionarios = new LinkedList<PessoaFisica>();

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public LinkedList<PessoaFisica> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(LinkedList<PessoaFisica> funcionarios) {
		this.funcionarios = funcionarios;
	}

}
