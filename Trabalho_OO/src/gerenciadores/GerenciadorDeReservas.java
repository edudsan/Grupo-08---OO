package gerenciadores;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import pessoas.PessoaFisica;

public class GerenciadorDeReservas extends Gerenciador{
	
	final double impostoLocacao = 0.05, seguroTerceiro = 0.12, seguroAutomovel = 0.08;
	private LinkedList<Reserva> reserva = new LinkedList<Reserva>();
	GerenciadorDeLocatarios gerenciadorDeLocatarios = new GerenciadorDeLocatarios();
	GerenciadorDeFrota gerenciadorDeFrota = new GerenciadorDeFrota();
	String str;
	int i, simNao;
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
	Date data;
	
	public boolean reservaNormal() throws ParseException {
		Normal reservaNormal = new Normal();
		// Define o locatario responsável pela reserva
		reservaNormal.setNumReserva(reserva.size()+1);
		do {
			str = JOptionPane.showInputDialog(gerenciadorDeLocatarios.listaLocatarios() 
					 							+ "Selecione o Locatario dessa reserva: ");
			i = Integer.parseInt(str);
		}while(i < 0 || i > pessoa.size());
		str = pessoa.get(i).getNome();
		reservaNormal.getCliente().setNome(str);
		//Define o número de diarias da reserva
		str = JOptionPane.showInputDialog("Data do início da reserva: ");
		data = dateFormat.parse(str);
		reservaNormal.setDataInicio(data);
		str = JOptionPane.showInputDialog("Data do início da reserva: ");
		data = dateFormat.parse(str);
		reservaNormal.setDataFim(data);
		reservaNormal.setDiarias((int) (reservaNormal.getDataFim().getTime() - reservaNormal.getDataInicio().getTime()));
		//Define o veiculo reservado
		do {
			str = JOptionPane.showInputDialog(gerenciadorDeFrota.listaVeiculos() 
					 							+ "Selecione o Automóvel a ser reservado: ");
			i = Integer.parseInt(str);
		}while(i < 0 || i > veiculo.size());
		//Define o Valor Total da Reserva
		reservaNormal.getAutomovel().setMarca	(veiculo.get(i).getMarca());
		reservaNormal.getAutomovel().setModelo	(veiculo.get(i).getModelo());
		reservaNormal.getAutomovel().setRenavam	(veiculo.get(i).getRenavam());
		reservaNormal.getAutomovel().setDiariaPF(veiculo.get(i).getDiariaPF());
		reservaNormal.getAutomovel().setDiariaPJ(veiculo.get(i).getDiariaPJ());
		if(pessoa.get(i) instanceof PessoaFisica) {
			reservaNormal.setImpostoLocacao	(impostoLocacao	*(reservaNormal.getAutomovel().getDiariaPF()* reservaNormal.getDiarias()));
			reservaNormal.setSeguroVeiculo	(seguroAutomovel*(reservaNormal.getAutomovel().getDiariaPF()* reservaNormal.getDiarias()));
			simNao = JOptionPane.showConfirmDialog(null, "Reserva inclui seguro automovel", "Reservas", JOptionPane.YES_NO_OPTION);
			if(simNao == JOptionPane.YES_OPTION) {
				reservaNormal.setSeguroTerceiros(seguroTerceiro *(reservaNormal.getAutomovel().getDiariaPF()* reservaNormal.getDiarias()));
				reservaNormal.setValorTotal((reservaNormal.getAutomovel().getDiariaPF() * reservaNormal.getDiarias())
											- impostoLocacao - seguroAutomovel - seguroTerceiro );
				reserva.add(reservaNormal);
				JOptionPane.showMessageDialog(null, "Reserva realizada com sucesso!");
				return true;
			}else {
				reservaNormal.setSeguroTerceiros(seguroTerceiro *(reservaNormal.getAutomovel().getDiariaPF()* reservaNormal.getDiarias()));
				reservaNormal.setValorTotal((reservaNormal.getAutomovel().getDiariaPF() * reservaNormal.getDiarias())
											- impostoLocacao - seguroTerceiro );
				reserva.add(reservaNormal);
				JOptionPane.showMessageDialog(null, "Reserva realizada com sucesso!");
				return true;
			}
		}else {
			reservaNormal.setImpostoLocacao	(impostoLocacao	*(reservaNormal.getAutomovel().getDiariaPJ()* reservaNormal.getDiarias()));
			reservaNormal.setSeguroVeiculo	(seguroAutomovel*(reservaNormal.getAutomovel().getDiariaPJ()* reservaNormal.getDiarias()));
			simNao = JOptionPane.showConfirmDialog(null, "Reserva inclui seguro automovel", "Reservas", JOptionPane.YES_NO_OPTION);
			if(simNao == JOptionPane.YES_OPTION) {
				reservaNormal.setSeguroTerceiros(seguroTerceiro *(reservaNormal.getAutomovel().getDiariaPJ()* reservaNormal.getDiarias()));
				reservaNormal.setValorTotal((reservaNormal.getAutomovel().getDiariaPJ() * reservaNormal.getDiarias())
											- impostoLocacao - seguroAutomovel - seguroTerceiro );
				reserva.add(reservaNormal);
				JOptionPane.showMessageDialog(null, "Reserva realizada com sucesso!");
				return true;
			}else {
				reservaNormal.setSeguroTerceiros(seguroTerceiro *(reservaNormal.getAutomovel().getDiariaPJ()* reservaNormal.getDiarias()));
				reservaNormal.setValorTotal((reservaNormal.getAutomovel().getDiariaPJ() * reservaNormal.getDiarias())
											- impostoLocacao - seguroTerceiro );
				reserva.add(reservaNormal);
				JOptionPane.showMessageDialog(null, "Reserva realizada com sucesso!");
				return true;
			}
		}
	}
	
	public boolean reservaNormalReduzida() {
		return false;
		
	}

	public boolean reservaEmpresarial() {
	
	return false;
	}

	public boolean reservaMensal() {
	
		return false;
	}
	
	public String emitirRelatorio() {
		String relatorio = ""; 
		for(int i = 0; i < reserva.size(); i++) {
			if(pessoa.get(i) instanceof PessoaFisica) {
				relatorio = relatorio 	+ "Reserva: " 						+ reserva.get(i).getNumReserva() 				+ "\n"
										+ "Locatário: " 					+ reserva.get(i).getCliente().getNome() 		+ "\n"
										+ "Inicio: "	 					+ reserva.get(i).getDataInicio()				+ "\n"
										+ "Fim: " 							+ reserva.get(i).getDataFim()					+ "\n"
										+ "Número de Diarias: "				+ reserva.get(i).getDiarias()					+ "\n"
										+ "Veiculo: "						+ reserva.get(i).getAutomovel().getMarca() 
																			+ reserva.get(i).getAutomovel().getModelo() 	+ "\n"
										+ "Valor da Diaria: "				+ reserva.get(i).getAutomovel().getDiariaPF()	+ "\n"
										+ "Valor do Seguro de Terceiros:"	+ reserva.get(i).getSeguroTerceiros()			+ "\n"
										+ "Valor do Seguro próprio"			+ reserva.get(i).getSeguroVeiculo()				+ "\n"
										+ "Valor dos Impostos: "			+ reserva.get(i).getImpostoLocacao()			+ "\n"
										+ "Valor Total da locação: "		+ ((Normal) reserva.get(i)).getValorTotal()		+ "\n";
				}else {
					relatorio = relatorio 	+ "Reserva: " 						+ reserva.get(i).getNumReserva() 				+ "\n"
							+ "Locatário: " 					+ reserva.get(i).getCliente().getNome() 		+ "\n"
							+ "Inicio: "	 					+ reserva.get(i).getDataInicio()				+ "\n"
							+ "Fim: " 							+ reserva.get(i).getDataFim()					+ "\n"
							+ "Número de Diarias: "				+ reserva.get(i).getDiarias()					+ "\n"
							+ "Veiculo: "						+ reserva.get(i).getAutomovel().getMarca() 
																+ reserva.get(i).getAutomovel().getModelo() 	+ "\n"
							+ "Valor da Diaria: "				+ reserva.get(i).getAutomovel().getDiariaPJ()	+ "\n"
							+ "Valor do Seguro de Terceiros:"	+ reserva.get(i).getSeguroTerceiros()			+ "\n"
							+ "Valor do Seguro próprio"			+ reserva.get(i).getSeguroVeiculo()				+ "\n"
							+ "Valor dos Impostos: "			+ reserva.get(i).getImpostoLocacao()			+ "\n"
							+ "Valor Total da locação: "		+ ((Normal) reserva.get(i)).getValorTotal()		+ "\n";
				}
		}
		return relatorio;
	}
	
	public String emitirRelatorioConsolidado() {
		String relatorioConsolidado = null;
		return relatorioConsolidado;
	}

}
