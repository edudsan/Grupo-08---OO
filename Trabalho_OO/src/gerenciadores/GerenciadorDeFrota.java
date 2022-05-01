package gerenciadores;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import veiculos.Carga;
import veiculos.Motocicleta;
import veiculos.Passageiro;
import veiculos.Passeio;
import veiculos.Veiculo;

public class GerenciadorDeFrota extends Gerenciador{
	
	LinkedList<Veiculo> veiculos = new LinkedList<Veiculo>();
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
	Date data;
	String strOpcao, strDate;
	int opcao, simNao; 
	boolean verdadeiroFalso;
	
	public boolean cadastraVeiculo() throws ParseException {
		do {
			strOpcao = JOptionPane.showInputDialog ("Que tipo de veículo você deseja cadastrar: 			\n"
												  + "1- Veículo de Passeio 		\n"
												  + "2- Veículo Utilitário 		\n"
												  + "3- Motocicleta     		\n");
			opcao = Integer.parseInt (strOpcao);
		}while(opcao != 1 && opcao != 2 && opcao != 3);
		if(opcao == 1) {
			JOptionPane.showMessageDialog (null, "Você agora vai cadastrar um veículo de passeio");
			Passeio passeio = new Passeio();
			String strDate = new String();
			try {
				passeio.setMarca(JOptionPane.showInputDialog ("Marca:"));
				passeio.setModelo(JOptionPane.showInputDialog ("Modelo:"));
				passeio.setRenavam(JOptionPane.showInputDialog ("Renavam:"));
				if(		passeio.getMarca().trim().isEmpty() == true 
					 || passeio.getModelo().trim().isEmpty() == true
					 || passeio.getRenavam().trim().isEmpty() == true ) 
				{
					throw new Exception();
				}
			}catch(Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog (null, "Preencha todos os campos obrigatórios!		\n"
					       						   + "Campos Obrigarótios: Marca, Modelo e RENAVAM	\n");
				return false;
			}
			strDate = JOptionPane.showInputDialog ("Ano de Fabricação:");
			data = dateFormat.parse(strDate);
			passeio.setAnoDeFabricacao(data);
			strDate = JOptionPane.showInputDialog ("Ano de Fabricação:");
			data = dateFormat.parse(strDate);
			passeio.setAnoDeModelo(data);
			passeio.setCapacidadeTanque(Double.parseDouble(JOptionPane.showInputDialog("Capacidade do Tanque:")));
			passeio.setDiariaPF(Double.parseDouble(JOptionPane.showInputDialog ("Diária Pessoa Física:")));
			passeio.setDiariaPJ(Double.parseDouble(JOptionPane.showInputDialog ("Diária Pessoa Jurídica:")));
			passeio.setDiariaReduzidaPF(passeio.getDiariaPF()*0.9);
			passeio.setValorMensal(Double.parseDouble(JOptionPane.showInputDialog ("Valor Mensal:")));
			
			simNao = JOptionPane.showConfirmDialog(null, "Possui Ar Condicionado?", "", JOptionPane.YES_NO_OPTION);
			if(simNao == 0)
				verdadeiroFalso = true;
			else
				verdadeiroFalso = false;
			passeio.setArCondicionado(verdadeiroFalso);
			simNao = JOptionPane.showConfirmDialog(null, "Possui Câmbio Automático?", "", JOptionPane.YES_NO_OPTION);
			if(simNao == 0)
				verdadeiroFalso = true;
			else
				verdadeiroFalso = false;
			passeio.setCambioAutomatico(verdadeiroFalso);
			simNao = JOptionPane.showConfirmDialog(null, "Possui Direção Hidráulica?", "", JOptionPane.YES_NO_OPTION);
			if(simNao == 0)
				verdadeiroFalso = true;
			else
				verdadeiroFalso = false;
			passeio.setDirecaoHidraulica(verdadeiroFalso);
			
			veiculos.add(passeio);
			JOptionPane.showMessageDialog (null, "Cadastro realizado com sucesso!\n");
			return true;
		}else if(opcao == 2) {
			do {
				strOpcao = JOptionPane.showInputDialog ("Que tipo de veículo utilitário você deseja cadastrar: 	\n"
													  + "1- Carga 												\n"
													  + "2- Passageiro 											\n");
				opcao = Integer.parseInt (strOpcao);
			}while(opcao != 1 && opcao != 2);
			if(opcao == 1) {
				Carga carga = new Carga();
				try {
					carga.setMarca(JOptionPane.showInputDialog ("Marca:"));
					carga.setModelo(JOptionPane.showInputDialog ("Modelo:"));
					carga.setRenavam(JOptionPane.showInputDialog ("Renavam:"));
					if		(carga.getMarca().trim().isEmpty() == true 
						  || carga.getModelo().trim().isEmpty() == true
						  || carga.getRenavam().trim().isEmpty() == true ) 
					{
						throw new Exception();
					}
				}catch(Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog (null, "Preencha todos os campos obrigatórios!		\n"
    						   						   + "Campos Obrigarótios: Marca, Modelo e RENAVAM	\n");
					return false;
				}
				strDate = JOptionPane.showInputDialog ("Ano de Fabricação:");
				data = dateFormat.parse(strDate);
				carga.setAnoDeFabricacao(data);
				strDate = JOptionPane.showInputDialog ("Ano de Fabricação:");
				data = dateFormat.parse(strDate);
				carga.setAnoDeModelo(data);
				carga.setCapacidadeTanque(Double.parseDouble(JOptionPane.showInputDialog("Capacidade do Tanque:")));
				carga.setDiariaPF(Double.parseDouble(JOptionPane.showInputDialog ("Diária Pessoa Física:")));
				carga.setDiariaPJ(Double.parseDouble(JOptionPane.showInputDialog ("Diária Pessoa Jurídica:")));
				carga.setDiariaReduzidaPF(carga.getDiariaPF()*0.9);
				carga.setValorMensal(Double.parseDouble(JOptionPane.showInputDialog ("Valor Mensal:")));
				carga.setCargaMaxima(Double.parseDouble(JOptionPane.showInputDialog("Carga Máxima:")));
				carga.setTara(Double.parseDouble(JOptionPane.showInputDialog("Tara:")));
				carga.setVolCompartimentoCarga(Double.parseDouble(JOptionPane.showInputDialog("Volume Compartimento de Carga:")));
				
				veiculos.add(carga);
				JOptionPane.showMessageDialog (null, "Cadastro realizado com sucesso!\n");
				return true;
			}else if(opcao == 2) {
				Passageiro passageiro = new Passageiro();
				dateFormat = new SimpleDateFormat("dd/mm/yyyy");
				
				try {
					passageiro.setMarca(JOptionPane.showInputDialog ("Marca:"));
					passageiro.setModelo(JOptionPane.showInputDialog ("Modelo:"));
					passageiro.setRenavam(JOptionPane.showInputDialog ("Renavam:"));
					if		(passageiro.getMarca().trim().isEmpty() == true 
						  || passageiro.getModelo().trim().isEmpty() == true
						  || passageiro.getRenavam().trim().isEmpty() == true ) 
					{
						throw new Exception();
					}
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog (null, "Preencha todos os campos obrigatórios!		\n"
	   						   						   + "Campos Obrigarótios: Marca, Modelo e RENAVAM	\n");
					return false;
				}
				strDate = JOptionPane.showInputDialog ("Ano de Fabricação:");
				data = dateFormat.parse(strDate);
				passageiro.setAnoDeFabricacao(data);
				strDate = JOptionPane.showInputDialog ("Ano de Fabricação:");
				data = dateFormat.parse(strDate);
				passageiro.setAnoDeModelo(data);
				passageiro.setCapacidadeTanque(Double.parseDouble(JOptionPane.showInputDialog("Capacidade do Tanque:")));
				passageiro.setDiariaPF(Double.parseDouble(JOptionPane.showInputDialog ("Diária Pessoa Física:")));
				passageiro.setDiariaPJ(Double.parseDouble(JOptionPane.showInputDialog ("Diária Pessoa Jurídica:")));
				passageiro.setDiariaReduzidaPF(passageiro.getDiariaPF()*0.9);
				passageiro.setValorMensal(Double.parseDouble(JOptionPane.showInputDialog ("Valor Mensal:")));
				passageiro.setNumOcupantes(Integer.parseInt(JOptionPane.showInputDialog ("Número de Ocupantes:")));
	
				simNao = JOptionPane.showConfirmDialog(null, "Possui Ar Condicionado?", "", JOptionPane.YES_NO_OPTION);
				if(simNao == 0)
					verdadeiroFalso = true;
				else
					verdadeiroFalso = false;
				passageiro.setArCondicionado(verdadeiroFalso);
				simNao = JOptionPane.showConfirmDialog(null, "Possui Câmbio Automático?", "", JOptionPane.YES_NO_OPTION);
				if(simNao == 0)
					verdadeiroFalso = true;
				else
					verdadeiroFalso = false;
				passageiro.setTvBordo(verdadeiroFalso);
				simNao = JOptionPane.showConfirmDialog(null, "Possui Direção Hidráulica?", "", JOptionPane.YES_NO_OPTION);
				if(simNao == 0)
					verdadeiroFalso = true;
				else
					verdadeiroFalso = false;
				passageiro.setDirecaoHidraulica(verdadeiroFalso);
				
				veiculos.add(passageiro);
				JOptionPane.showMessageDialog (null, "Cadastro realizado com sucesso!\n");
				return true;
			}
		}else if(opcao == 3) {
			JOptionPane.showMessageDialog (null, "Você agora vai cadastrar uma motocicleta");
			Motocicleta motocicleta = new Motocicleta();
			dateFormat = new SimpleDateFormat("dd/mm/yyyy");
			
			try {
				motocicleta.setMarca(JOptionPane.showInputDialog ("Marca:"));
				motocicleta.setModelo(JOptionPane.showInputDialog ("Modelo:"));
				motocicleta.setRenavam(JOptionPane.showInputDialog ("Renavam:"));
				if		(motocicleta.getMarca().trim().isEmpty() == true 
					  || motocicleta.getModelo().trim().isEmpty() == true
					  || motocicleta.getRenavam().trim().isEmpty() == true ) 
				{
					throw new Exception();
				}
			} catch (Exception e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog (null, "Preencha todos os campos obrigatórios!		\n"
   						   + "Campos Obrigarótios: Marca, Modelo e RENAVAM	\n");
				return false;
			}
			strDate = JOptionPane.showInputDialog ("Ano de Fabricação:");
			data = dateFormat.parse(strDate);
			motocicleta.setAnoDeFabricacao(data);
			strDate = JOptionPane.showInputDialog ("Ano de Fabricação:");
			data = dateFormat.parse(strDate);
			motocicleta.setAnoDeModelo(data);
			motocicleta.setCapacidadeTanque(Double.parseDouble(JOptionPane.showInputDialog("Capacidade do Tanque:")));
			motocicleta.setDiariaPF(Double.parseDouble(JOptionPane.showInputDialog ("Diária Pessoa Física:")));
			motocicleta.setDiariaPJ(Double.parseDouble(JOptionPane.showInputDialog ("Diária Pessoa Jurídica:")));
			motocicleta.setDiariaReduzidaPF(motocicleta.getDiariaPF()*0.9);
			motocicleta.setValorMensal(Double.parseDouble(JOptionPane.showInputDialog ("Valor Mensal:")));
			
			veiculos.add(motocicleta);
			JOptionPane.showMessageDialog (null, "Cadastro realizado com sucesso!\n");
			return true;
		}
		return false;
	}
	
	public boolean buscaVeiculo() {
		
		return false;
	}
	public boolean editaVeiculo() {
		return false;
		
	}
	public boolean excluiVeiculo() {
		return false;
	}
}
