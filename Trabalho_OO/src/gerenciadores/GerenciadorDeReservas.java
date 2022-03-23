package gerenciadores;

import java.util.Date;

import pessoas.Pessoa;
import veiculos.Veiculo;

public class GerenciadorDeReservas extends Gerenciador{
	private int numReserva, diarias;
	private Pessoa cliente;
	private Veiculo automovel;
	private Date dataInicio, dataFim;
	private double seguroTerceiros, seguroVeiculo, impostoLocacao;
	
	public int getNumReserva() {
		return numReserva;
	}
	public int getDiarias() {
		return diarias;
	}
	public Pessoa getCliente() {
		return cliente;
	}
	public Veiculo getAutomovel() {
		return automovel;
	}
	public Date getDataInicio() {
		return dataInicio;
	}
	public Date getDataFim() {
		return dataFim;
	}
	public double getSeguroTerceiros() {
		return seguroTerceiros;
	}
	public double getSeguroVeiculo() {
		return seguroVeiculo;
	}
	public double getImpostoLocacao() {
		return impostoLocacao;
	}
	
	public String emitirRelatorio() {
		String relatorio = null;
		return relatorio;
	}
	
	public String emitirRelatorioConsolidado() {
		String relatorioConsolidado = null;
		return relatorioConsolidado;
	}
}
