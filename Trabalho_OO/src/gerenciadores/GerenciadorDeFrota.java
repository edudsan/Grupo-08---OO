package gerenciadores;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

import veiculos.Carga;
import veiculos.Motocicleta;
import veiculos.Passageiro;
import veiculos.Passeio;

public class GerenciadorDeFrota extends Gerenciador{
	
	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
	private Date data;
	private String strOpcao, strDate;
	private int opcao, simNao, i; 
	private boolean verdadeiroFalso;
	
	public boolean cadastraVeiculo() throws ParseException {
		do {
			strOpcao = JOptionPane.showInputDialog ("Que tipo de veículo você deseja cadastrar: \n"
												  + "1- Veículo de Passeio 						\n"
												  + "2- Veículo Utilitário 						\n"
												  + "3- Motocicleta     						\n");
			opcao = Integer.parseInt (strOpcao);
		}while(opcao != 1 && opcao != 2 && opcao != 3);
		if(opcao == 1) {
			JOptionPane.showMessageDialog (null, "Você agora vai cadastrar um veículo de passeio");
			Passeio passeio = new Passeio();
			String strDate = new String();
			try {
				passeio.setMarca	(JOptionPane.showInputDialog ("Marca:"));
				passeio.setModelo	(JOptionPane.showInputDialog ("Modelo:"));
				passeio.setRenavam	(JOptionPane.showInputDialog ("Renavam:"));
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
			strDate = JOptionPane.showInputDialog ("Ano do Modelo:");
			data = dateFormat.parse(strDate);
			passeio.setAnoDeModelo(data);
			
			simNao = JOptionPane.showConfirmDialog(null, "Possui Ar Condicionado?", "", JOptionPane.YES_NO_OPTION);
			if(simNao == JOptionPane.YES_OPTION)
				verdadeiroFalso = true;
			else
				verdadeiroFalso = false;
			passeio.setArCondicionado(verdadeiroFalso);
			simNao = JOptionPane.showConfirmDialog(null, "Possui Câmbio Automático?", "", JOptionPane.YES_NO_OPTION);
			if(simNao == JOptionPane.YES_OPTION)
				verdadeiroFalso = true;
			else
				verdadeiroFalso = false;
			passeio.setCambioAutomatico(verdadeiroFalso);
			simNao = JOptionPane.showConfirmDialog(null, "Possui Direção Hidráulica?", "", JOptionPane.YES_NO_OPTION);
			if(simNao == JOptionPane.YES_OPTION)
				verdadeiroFalso = true;
			else
				verdadeiroFalso = false;
			passeio.setDirecaoHidraulica(verdadeiroFalso);
			
			passeio.setCapacidadeTanque	(Double.parseDouble(JOptionPane.showInputDialog	("Capacidade do Tanque:")));
			passeio.setDiariaPF			(Double.parseDouble(JOptionPane.showInputDialog ("Diária Pessoa Física:")));
			passeio.setDiariaPJ			(Double.parseDouble(JOptionPane.showInputDialog ("Diária Pessoa Jurídica:")));
			passeio.setDiariaReduzidaPF	(passeio.getDiariaPF()*0.9);
			passeio.setValorMensal		(Double.parseDouble(JOptionPane.showInputDialog ("Valor Mensal:")));
			
			veiculo.add(passeio);
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
					carga.setMarca	(JOptionPane.showInputDialog ("Marca:"));
					carga.setModelo	(JOptionPane.showInputDialog ("Modelo:"));
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
				strDate = JOptionPane.showInputDialog ("Ano do Modelo:");
				data = dateFormat.parse(strDate);
				carga.setAnoDeModelo(data);
				carga.setCapacidadeTanque		(Double.parseDouble(JOptionPane.showInputDialog	("Capacidade do Tanque:")));
				carga.setCargaMaxima			(Double.parseDouble(JOptionPane.showInputDialog	("Carga Máxima:")));
				carga.setTara					(Double.parseDouble(JOptionPane.showInputDialog	("Tara:")));
				carga.setVolCompartimentoCarga	(Double.parseDouble(JOptionPane.showInputDialog	("Volume Compartimento de Carga:")));
				carga.setDiariaPF				(Double.parseDouble(JOptionPane.showInputDialog ("Diária Pessoa Física:")));
				carga.setDiariaPJ				(Double.parseDouble(JOptionPane.showInputDialog ("Diária Pessoa Jurídica:")));
				carga.setDiariaReduzidaPF		(carga.getDiariaPF()*0.9);
				carga.setValorMensal			(Double.parseDouble(JOptionPane.showInputDialog ("Valor Mensal:")));
				
				veiculo.add(carga);
				JOptionPane.showMessageDialog (null, "Cadastro realizado com sucesso!\n");
				return true;
			}else if(opcao == 2) {
				Passageiro passageiro = new Passageiro();
				dateFormat = new SimpleDateFormat("dd/mm/yyyy");
				
				try {
					passageiro.setMarca		(JOptionPane.showInputDialog ("Marca:"));
					passageiro.setModelo	(JOptionPane.showInputDialog ("Modelo:"));
					passageiro.setRenavam	(JOptionPane.showInputDialog ("Renavam:"));
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
				strDate = JOptionPane.showInputDialog ("Ano do Modelo:");
				data = dateFormat.parse(strDate);
				passageiro.setAnoDeModelo(data);
	
				simNao = JOptionPane.showConfirmDialog(null, "Possui Ar Condicionado?", "", JOptionPane.YES_NO_OPTION);
				if(simNao == JOptionPane.YES_OPTION)
					verdadeiroFalso = true;
				else
					verdadeiroFalso = false;
				passageiro.setArCondicionado(verdadeiroFalso);
				simNao = JOptionPane.showConfirmDialog(null, "Possui Câmbio Automático?", "", JOptionPane.YES_NO_OPTION);
				if(simNao == JOptionPane.YES_OPTION)
					verdadeiroFalso = true;
				else
					verdadeiroFalso = false;
				passageiro.setTvBordo(verdadeiroFalso);
				simNao = JOptionPane.showConfirmDialog(null, "Possui Direção Hidráulica?", "", JOptionPane.YES_NO_OPTION);
				if(simNao == JOptionPane.YES_OPTION)
					verdadeiroFalso = true;
				else
					verdadeiroFalso = false;
				passageiro.setDirecaoHidraulica(verdadeiroFalso);
				
				passageiro.setCapacidadeTanque	(Double.parseDouble(JOptionPane.showInputDialog("Capacidade do Tanque:")));
				passageiro.setDiariaPF			(Double.parseDouble(JOptionPane.showInputDialog ("Diária Pessoa Física:")));
				passageiro.setDiariaPJ			(Double.parseDouble(JOptionPane.showInputDialog ("Diária Pessoa Jurídica:")));
				passageiro.setDiariaReduzidaPF	(passageiro.getDiariaPF()*0.9);
				passageiro.setValorMensal		(Double.parseDouble(JOptionPane.showInputDialog ("Valor Mensal:")));
				passageiro.setNumOcupantes		(Integer.parseInt(JOptionPane.showInputDialog ("Número de Ocupantes:")));
				
				veiculo.add(passageiro);
				JOptionPane.showMessageDialog (null, "Cadastro realizado com sucesso!\n");
				return true;
			}
		}else if(opcao == 3) {
			JOptionPane.showMessageDialog (null, "Você agora vai cadastrar uma motocicleta");
			Motocicleta motocicleta = new Motocicleta();
			dateFormat = new SimpleDateFormat("dd/mm/yyyy");
			
			try {
				motocicleta.setMarca	(JOptionPane.showInputDialog ("Marca:"));
				motocicleta.setModelo	(JOptionPane.showInputDialog ("Modelo:"));
				motocicleta.setRenavam	(JOptionPane.showInputDialog ("Renavam:"));
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
			strDate = JOptionPane.showInputDialog ("Ano do Modelo:");
			data = dateFormat.parse(strDate);
			motocicleta.setAnoDeModelo(data);
			motocicleta.setCapacidadeTanque	(Double.parseDouble(JOptionPane.showInputDialog("Capacidade do Tanque:")));
			motocicleta.setDiariaPF			(Double.parseDouble(JOptionPane.showInputDialog ("Diária Pessoa Física:")));
			motocicleta.setDiariaPJ			(Double.parseDouble(JOptionPane.showInputDialog ("Diária Pessoa Jurídica:")));
			motocicleta.setDiariaReduzidaPF	(motocicleta.getDiariaPF()*0.9);
			motocicleta.setValorMensal		(Double.parseDouble(JOptionPane.showInputDialog ("Valor Mensal:")));
			
			veiculo.add(motocicleta);
			JOptionPane.showMessageDialog (null, "Cadastro realizado com sucesso!\n");
			return true;
		}
		return false;
	}
	
	public boolean buscaVeiculo() {
		String busca = JOptionPane.showInputDialog("Informe o valor do RENAVAM que deseja buscar:	\n");
		for(i = 0;i < veiculo.size(); i++) {
			if(veiculo.get(i).getRenavam().equals(busca) == true){
				JOptionPane.showMessageDialog(null, "Veículo encontrado!		   \n"
						  + "Marca: " 	+ veiculo.get(i).getMarca() 	        + "\n"
						  + "Modelo: " 	+ veiculo.get(i).getModelo() 			+ "\n"
						  + "RENAVAM: " + veiculo.get(i).getRenavam()   		+ "\n");
				return true;
			}
		}
		return false;
	}
	public boolean editaVeiculo(int i) throws ParseException {
		if(veiculo.get(i) instanceof Passeio) {
			Passeio passeioEditada = new Passeio(); 
			try {
				passeioEditada.setMarca	(JOptionPane.showInputDialog ("Marca:"));
				passeioEditada.setModelo	(JOptionPane.showInputDialog ("Modelo:"));
				passeioEditada.setRenavam	(JOptionPane.showInputDialog ("Renavam:"));
				if(		passeioEditada.getMarca().trim().isEmpty() == true 
					 || passeioEditada.getModelo().trim().isEmpty() == true
					 || passeioEditada.getRenavam().trim().isEmpty() == true ) 
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
			passeioEditada.setAnoDeFabricacao(data);
			strDate = JOptionPane.showInputDialog ("Ano do Modelo:");
			data = dateFormat.parse(strDate);
			passeioEditada.setAnoDeModelo(data);
			
			simNao = JOptionPane.showConfirmDialog(null, "Possui Ar Condicionado?", "", JOptionPane.YES_NO_OPTION);
			if(simNao == JOptionPane.YES_OPTION)
				verdadeiroFalso = true;
			else
				verdadeiroFalso = false;
			passeioEditada.setArCondicionado(verdadeiroFalso);
			simNao = JOptionPane.showConfirmDialog(null, "Possui Câmbio Automático?", "", JOptionPane.YES_NO_OPTION);
			if(simNao == JOptionPane.YES_OPTION)
				verdadeiroFalso = true;
			else
				verdadeiroFalso = false;
			passeioEditada.setCambioAutomatico(verdadeiroFalso);
			simNao = JOptionPane.showConfirmDialog(null, "Possui Direção Hidráulica?", "", JOptionPane.YES_NO_OPTION);
			if(simNao == JOptionPane.YES_OPTION)
				verdadeiroFalso = true;
			else
				verdadeiroFalso = false;
			passeioEditada.setDirecaoHidraulica(verdadeiroFalso);
			
			passeioEditada.setCapacidadeTanque	(Double.parseDouble(JOptionPane.showInputDialog	("Capacidade do Tanque:")));
			passeioEditada.setDiariaPF			(Double.parseDouble(JOptionPane.showInputDialog ("Diária Pessoa Física:")));
			passeioEditada.setDiariaPJ			(Double.parseDouble(JOptionPane.showInputDialog ("Diária Pessoa Jurídica:")));
			passeioEditada.setDiariaReduzidaPF	(passeioEditada.getDiariaPF()*0.9);
			passeioEditada.setValorMensal		(Double.parseDouble(JOptionPane.showInputDialog ("Valor Mensal:")));
			
			veiculo.set(i, passeioEditada);
			JOptionPane.showMessageDialog (null, "Cadastro realizado com sucesso!\n");
			return true;
			
		}else if(veiculo.get(i) instanceof Carga) {
			Carga cargaEditada = new Carga(); 
			try {
				cargaEditada.setMarca	(JOptionPane.showInputDialog ("Marca:"));
				cargaEditada.setModelo	(JOptionPane.showInputDialog ("Modelo:"));
				cargaEditada.setRenavam	(JOptionPane.showInputDialog ("Renavam:"));
				if		(cargaEditada.getMarca().trim().isEmpty() == true 
					  || cargaEditada.getModelo().trim().isEmpty() == true
					  || cargaEditada.getRenavam().trim().isEmpty() == true ) 
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
			cargaEditada.setAnoDeFabricacao(data);
			strDate = JOptionPane.showInputDialog ("Ano do Modelo:");
			data = dateFormat.parse(strDate);
			cargaEditada.setAnoDeModelo(data);
			cargaEditada.setCapacidadeTanque		(Double.parseDouble(JOptionPane.showInputDialog	("Capacidade do Tanque:")));
			cargaEditada.setCargaMaxima				(Double.parseDouble(JOptionPane.showInputDialog	("Carga Máxima:")));
			cargaEditada.setTara					(Double.parseDouble(JOptionPane.showInputDialog	("Tara:")));
			cargaEditada.setVolCompartimentoCarga	(Double.parseDouble(JOptionPane.showInputDialog	("Volume Compartimento de carga:")));
			cargaEditada.setDiariaPF				(Double.parseDouble(JOptionPane.showInputDialog ("Diária Pessoa Física:")));
			cargaEditada.setDiariaPJ				(Double.parseDouble(JOptionPane.showInputDialog ("Diária Pessoa Jurídica:")));
			cargaEditada.setDiariaReduzidaPF		(cargaEditada.getDiariaPF()*0.9);
			cargaEditada.setValorMensal				(Double.parseDouble(JOptionPane.showInputDialog ("Valor Mensal:")));
			
			veiculo.set(i, cargaEditada);
			JOptionPane.showMessageDialog (null, "Cadastro realizado com sucesso!\n");
			return true;
		}
		
		else if(veiculo.get(i) instanceof Passageiro) {
			Passageiro passageiroEditada = new Passageiro(); 
			dateFormat = new SimpleDateFormat("dd/mm/yyyy");
			
			try {
				passageiroEditada.setMarca		(JOptionPane.showInputDialog ("Marca:"));
				passageiroEditada.setModelo		(JOptionPane.showInputDialog ("Modelo:"));
				passageiroEditada.setRenavam	(JOptionPane.showInputDialog ("Renavam:"));
				if		(passageiroEditada.getMarca().trim().isEmpty() == true 
					  || passageiroEditada.getModelo().trim().isEmpty() == true
					  || passageiroEditada.getRenavam().trim().isEmpty() == true ) 
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
			passageiroEditada.setAnoDeFabricacao(data);
			strDate = JOptionPane.showInputDialog ("Ano do Modelo:");
			data = dateFormat.parse(strDate);
			passageiroEditada.setAnoDeModelo(data);

			simNao = JOptionPane.showConfirmDialog(null, "Possui Ar Condicionado?", "", JOptionPane.YES_NO_OPTION);
			if(simNao == JOptionPane.YES_OPTION)
				verdadeiroFalso = true;
			else
				verdadeiroFalso = false;
			passageiroEditada.setArCondicionado(verdadeiroFalso);
			simNao = JOptionPane.showConfirmDialog(null, "Possui Câmbio Automático?", "", JOptionPane.YES_NO_OPTION);
			if(simNao == JOptionPane.YES_OPTION)
				verdadeiroFalso = true;
			else
				verdadeiroFalso = false;
			passageiroEditada.setTvBordo(verdadeiroFalso);
			simNao = JOptionPane.showConfirmDialog(null, "Possui Direção Hidráulica?", "", JOptionPane.YES_NO_OPTION);
			if(simNao == JOptionPane.YES_OPTION)
				verdadeiroFalso = true;
			else
				verdadeiroFalso = false;
			passageiroEditada.setDirecaoHidraulica(verdadeiroFalso);
			
			passageiroEditada.setCapacidadeTanque	(Double.parseDouble(JOptionPane.showInputDialog("Capacidade do Tanque:")));
			passageiroEditada.setDiariaPF			(Double.parseDouble(JOptionPane.showInputDialog ("Diária Pessoa Física:")));
			passageiroEditada.setDiariaPJ			(Double.parseDouble(JOptionPane.showInputDialog ("Diária Pessoa Jurídica:")));
			passageiroEditada.setDiariaReduzidaPF	(passageiroEditada.getDiariaPF()*0.9);
			passageiroEditada.setValorMensal		(Double.parseDouble(JOptionPane.showInputDialog ("Valor Mensal:")));
			passageiroEditada.setNumOcupantes		(Integer.parseInt(JOptionPane.showInputDialog ("Número de Ocupantes:")));
			
			veiculo.set(i, passageiroEditada);
			JOptionPane.showMessageDialog (null, "Informações do veiculo atualizadas!\n");
			return true;
			
		}else if(veiculo.get(i) instanceof Motocicleta) {
			Motocicleta motocicletaEditada = new Motocicleta(); 
			dateFormat = new SimpleDateFormat("dd/mm/yyyy");
			try {
				motocicletaEditada.setMarca		(JOptionPane.showInputDialog ("Marca:"));
				motocicletaEditada.setModelo	(JOptionPane.showInputDialog ("Modelo:"));
				motocicletaEditada.setRenavam	(JOptionPane.showInputDialog ("Renavam:"));
				if		(motocicletaEditada.getMarca().trim().isEmpty() == true 
					  || motocicletaEditada.getModelo().trim().isEmpty() == true
					  || motocicletaEditada.getRenavam().trim().isEmpty() == true ) 
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
			motocicletaEditada.setAnoDeFabricacao(data);
			strDate = JOptionPane.showInputDialog ("Ano do Modelo:");
			data = dateFormat.parse(strDate);
			motocicletaEditada.setAnoDeModelo(data);
			motocicletaEditada.setCapacidadeTanque	(Double.parseDouble(JOptionPane.showInputDialog("Capacidade do Tanque:")));
			motocicletaEditada.setDiariaPF			(Double.parseDouble(JOptionPane.showInputDialog ("Diária Pessoa Física:")));
			motocicletaEditada.setDiariaPJ			(Double.parseDouble(JOptionPane.showInputDialog ("Diária Pessoa Jurídica:")));
			motocicletaEditada.setDiariaReduzidaPF	(motocicletaEditada.getDiariaPF()*0.9);
			motocicletaEditada.setValorMensal		(Double.parseDouble(JOptionPane.showInputDialog ("Valor Mensal:")));
				
			veiculo.set(i, motocicletaEditada);
			JOptionPane.showMessageDialog (null, "Informações do veiculo atualizadas!\n");
			return true;
		}
		return false;
		
	}
	public void excluiVeiculo(int i) {
		veiculo.remove(i);
		JOptionPane.showMessageDialog(null, "Veiculo deletado com sucesso! \n");
	}

	public String listaVeiculos() {
		int i;
		String lista = "";
		for(i = 0;i < veiculo.size(); i++) {
			if(veiculo.get(i) instanceof Passeio) {
				lista =	lista + "Índice: " 	  + i 					     				+ "\n"
							  + "Marca: " 	  + veiculo.get(i).getMarca()  				+ "\n"
							  + "Modelo: "    + veiculo.get(i).getModelo() 				+ "\n"
							  + "RENAVAM: "   + veiculo.get(i).getRenavam()				+ "\n"
							  + "Tipo: Carro de Passeio									   \n"
							  + "──────────────────────────────────────────────────────────\n";
			}else if(veiculo.get(i) instanceof Passageiro){
				lista =	lista + "Índice: " 	  + i 					     				+ "\n"
							  + "Marca: " 	  + veiculo.get(i).getMarca()  				+ "\n"
							  + "Modelo: "    + veiculo.get(i).getModelo() 				+ "\n"
							  + "RENAVAM: "   + veiculo.get(i).getRenavam()				+ "\n"
							  + "Tipo: Carro de Passageiro								   \n"
							  + "──────────────────────────────────────────────────────────\n";
			}else if(veiculo.get(i) instanceof Carga){
				lista =	lista + "Índice: " 	  + i 					     				+ "\n"
							  + "Marca: " 	  + veiculo.get(i).getMarca()  				+ "\n"
							  + "Modelo: "    + veiculo.get(i).getModelo() 				+ "\n"
							  + "RENAVAM: "   + veiculo.get(i).getRenavam()				+ "\n"
							  + "Tipo: Carro de Carga								   	   \n"
							  + "──────────────────────────────────────────────────────────\n";
			}else if(veiculo.get(i) instanceof Motocicleta){
				lista =	lista + "Índice: " 	  + i 					     				+ "\n"
							  + "Marca: " 	  + veiculo.get(i).getMarca()  				+ "\n"
							  + "Modelo: "    + veiculo.get(i).getModelo() 				+ "\n"
							  + "RENAVAM: "   + veiculo.get(i).getRenavam()				+ "\n"
							  + "Tipo: Motocicleta										   \n"
							  + "──────────────────────────────────────────────────────────\n";
			}
			
		}
		return lista;
	}
}
