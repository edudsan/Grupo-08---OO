package gerenciadores;

import java.util.Date;

import pessoas.Pessoa;
import veiculos.Veiculo;

public class Reserva {
	private int numReserva, diarias;
	private Pessoa cliente;
	private Veiculo automovel;
	private Date dataInicio, dataFim;
	private double seguroTerceiros, seguroVeiculo, impostoLocacao;
	
	public int getNumReserva() {
		return numReserva;
	}
	public void setNumReserva(int numReserva) {
		this.numReserva = numReserva;
	}
	public int getDiarias() {
		return diarias;
	}
	public void setDiarias(int diarias) {
		this.diarias = diarias;
	}
	public Pessoa getCliente() {
		return cliente;
	}
	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}
	public Veiculo getAutomovel() {
		return automovel;
	}
	public void setAutomovel(Veiculo automovel) {
		this.automovel = automovel;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	public Date getDataFim() {
		return dataFim;
	}
	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}
	public double getSeguroTerceiros() {
		return seguroTerceiros;
	}
	public void setSeguroTerceiros(double seguroTerceiros) {
		this.seguroTerceiros = seguroTerceiros;
	}
	public double getSeguroVeiculo() {
		return seguroVeiculo;
	}
	public void setSeguroVeiculo(double seguroVeiculo) {
		this.seguroVeiculo = seguroVeiculo;
	}
	public double getImpostoLocacao() {
		return impostoLocacao;
	}
	public void setImpostoLocacao(double impostoLocacao) {
		this.impostoLocacao = impostoLocacao;
	}
	
	
}
