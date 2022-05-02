package pessoas;

public class PessoaFisica extends Pessoa{
	private String cpf, estadoCivil;

	public String getCpf() {
		return cpf;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
