package gerenciadores;

import javax.swing.JOptionPane;

import pessoas.PessoaFisica;
import pessoas.PessoaJuridica;

public class GerenciadorDeLocatarios extends Gerenciador{
	
	private String strOpcao, busca;
	private int opcao, i;
	
	public boolean cadastraLocatarioPF() {
		PessoaFisica locatarioPF = new PessoaFisica();
		try {
			locatarioPF.setNome	(JOptionPane.showInputDialog ("Nome Completo:"));
			locatarioPF.setEMail(JOptionPane.showInputDialog ("Email:"));
			locatarioPF.setCpf	(JOptionPane.showInputDialog ("CPF:"));
			if(locatarioPF.getNome().trim().isEmpty() == true 
			|| locatarioPF.getEMail().trim().isEmpty() == true
			|| locatarioPF.getCpf().trim().isEmpty() == true ) 
			{
				throw new Exception();
			}
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog (null, "Preencha todos os campos obrigatórios!\n"
											   + "Campos Obrigarótios: Nome, Email e CPF");
			return false;
		}
		locatarioPF.setTelefone				(JOptionPane.showInputDialog ("Telefone:"));
		locatarioPF.setEstadoCivil			(JOptionPane.showInputDialog ("Estado Civil:"));
		locatarioPF.getEndereco().setEstado	(JOptionPane.showInputDialog ("Estado:"));
		locatarioPF.getEndereco().setCidade	(JOptionPane.showInputDialog ("Cidade:"));
		locatarioPF.getEndereco().setBairro	(JOptionPane.showInputDialog ("Bairro:"));
		locatarioPF.getEndereco().setRua	(JOptionPane.showInputDialog ("Rua:"));
		locatarioPF.getEndereco().setNumero	(JOptionPane.showInputDialog ("Numero:"));
		
		pessoa.add(locatarioPF);
		JOptionPane.showMessageDialog (null, "Cadastro realizado com sucesso!\n");
		return true;
	}
	
	public boolean cadastraLocatarioPJ() {
		PessoaJuridica locatarioPJ = new PessoaJuridica();
		try {
			locatarioPJ.setNome	(JOptionPane.showInputDialog ("Nome:"));
			locatarioPJ.setEMail(JOptionPane.showInputDialog ("Email:"));
			locatarioPJ.setCnpj	(JOptionPane.showInputDialog ("CNPJ:"));
			if(locatarioPJ.getNome().trim().isEmpty() == true 
			|| locatarioPJ.getEMail().trim().isEmpty() == true
			|| locatarioPJ.getCnpj().trim().isEmpty() == true ) 
			{
				throw new Exception();
			}
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog (null, "Preencha todos os campos obrigatórios!\n"
										       + "Campos Obrigarótios: Nome, Email e CNPJ");
			return false;
		}
		locatarioPJ.setTelefone				(JOptionPane.showInputDialog ("Telefone:"));
		locatarioPJ.getEndereco().setEstado	(JOptionPane.showInputDialog ("Estado:"));
		locatarioPJ.getEndereco().setCidade	(JOptionPane.showInputDialog ("Cidade:"));
		locatarioPJ.getEndereco().setBairro	(JOptionPane.showInputDialog ("Bairro:"));
		locatarioPJ.getEndereco().setRua	(JOptionPane.showInputDialog ("Rua:"));
		locatarioPJ.getEndereco().setNumero	(JOptionPane.showInputDialog ("Numero:"));
		
//		do {
//			String strNumFuncionarios = JOptionPane.showInputDialog("Quantos Funcionários você deseja cadastrar?");
//			numFuncionarios = Integer.parseInt(strNumFuncionarios);
//		}while(numFuncionarios < 0);
//		for(int i = numFuncionarios;i > 0;i--) {
//			locatarioPJ.getFuncionarios().set(i, );
//		}
		
		//tentando achar uma forma de adicionar os funcionarios ao cadastro de pessoa jurídica
		
		pessoa.add(locatarioPJ);
		JOptionPane.showMessageDialog (null, "Cadastro realizado com sucesso!\n");
		return true;
	}
	
	public boolean buscaLocatario() {
		do {
			strOpcao = JOptionPane.showInputDialog("Busca Locatarios:	\n"
											   	 + "1 - Pessoa Física	\n"
											     + "2 - Pessoa Jurídica	\n");
			opcao = Integer.parseInt(strOpcao);
		}while(opcao > 2 || opcao < 1);
		if(opcao == 1) {
			do {
				strOpcao = JOptionPane.showInputDialog("Busca Pessoa Física:	\n"
												   	 + "1 - Nome				\n"
												     + "2 - Email				\n"
												     + "3 - CPF					\n");
				opcao = Integer.parseInt(strOpcao);
			}while(opcao > 3 || opcao < 1);
			switch(opcao) {
			case 1:
				busca = JOptionPane.showInputDialog("Nome do locatário que deseja buscar: \n");
				for(i = 0;i < pessoa.size(); i++) {
					if(pessoa.get(i).getNome().equals(busca) == true) {
						JOptionPane.showMessageDialog(null, "Locatário encontrado!								       \n"
														  + "Nome: " 	+ pessoa.get(i).getNome() 					+ "\n"
														  + "Email: " 	+ pessoa.get(i).getEMail() 					+ "\n"
														  + "CPF: " 	+ ((PessoaFisica) pessoa.get(i)).getCpf()   + "\n"
														  + "Telefone: "+ pessoa.get(i).getTelefone() 				+ "\n");
						return true;
					}
				}
				break;
			case 2:
				busca = JOptionPane.showInputDialog("Email do locatário que deseja buscar: \n");
				for(i = 0;i < pessoa.size(); i++) {
					if(pessoa.get(i).getEMail().equals(busca) == true) {
						JOptionPane.showMessageDialog(null, "Locatário encontrado!								  	   \n"
														  + "Nome: " 	+ pessoa.get(i).getNome() 					+ "\n"
														  + "Email: " 	+ pessoa.get(i).getEMail() 					+ "\n"
														  + "CPF: " 	+ ((PessoaFisica) pessoa.get(i)).getCpf() 	+ "\n"
														  + "Telefone: "+ pessoa.get(i).getTelefone() 				+ "\n");
						return true;
					}
				}
				break;
			case 3:
				busca = JOptionPane.showInputDialog("CPF do locatário que deseja buscar: \n");
				for(i = 0;i < pessoa.size(); i++) {
					if(((PessoaFisica) pessoa.get(i)).getCpf().equals(busca) == true) {
						JOptionPane.showMessageDialog(null, "Locatário encontrado!								       \n"
														  + "Nome: " 	+ pessoa.get(i).getNome() 					+ "\n"
														  + "Email: " 	+ pessoa.get(i).getEMail() 					+ "\n"
														  + "CPF: " 	+ ((PessoaFisica) pessoa.get(i)).getCpf() 	+ "\n"
														  + "Telefone: "+ pessoa.get(i).getTelefone() 				+ "\n");
						return true;
					}
				}
				break;
			}
		}else {
			do {
				strOpcao = JOptionPane.showInputDialog("Busca Pessoa Física:	\n"
												   	 + "1 - Nome				\n"
												     + "2 - Email				\n"
												     + "3 - CNPJ				\n");
				opcao = Integer.parseInt(strOpcao);
			}while(opcao > 3 || opcao < 1);
			switch(opcao) {
			case 1:
				busca = JOptionPane.showInputDialog("Nome do locatário que deseja buscar: \n");
				for(i = 0;i < pessoa.size(); i++) {
					if(pessoa.get(i).getNome().equals(busca) == true) {
						JOptionPane.showMessageDialog(null, "Locatário encontrado!								       \n"
														  + "Nome: " 	+ pessoa.get(i).getNome()					+ "\n"
														  + "Email: " 	+ pessoa.get(i).getEMail()					+ "\n"
														  + "CNPJ: " 	+ ((PessoaJuridica) pessoa.get(i)).getCnpj()+ "\n"
														  + "Telefone: "+ pessoa.get(i).getTelefone() 				+ "\n");
						return true;
					}
				}
				break;
			case 2:
				busca = JOptionPane.showInputDialog("Email do locatário que deseja buscar: \n");
				for(i = 0;i < pessoa.size(); i++) {
					if(pessoa.get(i).getEMail().equals(busca) == true) {
						JOptionPane.showMessageDialog(null, "Locatário encontrado!								   	   \n"
														  + "Nome: " 	+ pessoa.get(i).getNome()					+ "\n"
														  + "Email: " 	+ pessoa.get(i).getEMail() 					+ "\n"
														  + "CNPJ: " 	+ ((PessoaJuridica) pessoa.get(i)).getCnpj()+ "\n"
														  + "Telefone: "+ pessoa.get(i).getTelefone() 				+ "\n");
						return true;
					}
				}
				break;
			case 3:
				busca = JOptionPane.showInputDialog("CNPJ do locatário que deseja buscar: \n");
				for(i = 0;i < pessoa.size(); i++) {
					if(((PessoaJuridica) pessoa.get(i)).getCnpj().equals(busca) == true) {
						JOptionPane.showMessageDialog(null, "Locatário encontrado!								   	   \n"
														  + "Nome: " 	+ pessoa.get(i).getNome()					+ "\n"
														  + "Email: " 	+ pessoa.get(i).getEMail() 					+ "\n"
														  + "CNPJ: " 	+ ((PessoaJuridica) pessoa.get(i)).getCnpj()+ "\n"
														  + "Telefone: "+ pessoa.get(i).getTelefone() 				+ "\n");
						return true;
					}
				}
				break;
			}
		}
		return false;
	}

	public boolean editaLocatarioPF(int i) {
		PessoaFisica pessoaFisicaEditada = new PessoaFisica();
		try {
			pessoaFisicaEditada.setNome	(JOptionPane.showInputDialog ("Nome Completo:"));
			pessoaFisicaEditada.setEMail(JOptionPane.showInputDialog ("Email:"));
			pessoaFisicaEditada.setCpf	(JOptionPane.showInputDialog ("CPF:"));
			if(pessoaFisicaEditada.getNome().trim().isEmpty() == true 
			|| pessoaFisicaEditada.getEMail().trim().isEmpty() == true
			|| pessoaFisicaEditada.getCpf().trim().isEmpty() == true ) 
			{
				throw new Exception();
			}
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog (null, "Preencha todos os campos obrigatórios!\n"
											   + "Campos Obrigarótios: Nome, Email e CPF");
			return false;
		}
		pessoaFisicaEditada.setTelefone				(JOptionPane.showInputDialog ("Telefone:"));
		pessoaFisicaEditada.setEstadoCivil			(JOptionPane.showInputDialog ("Estado Civil:"));
		pessoaFisicaEditada.getEndereco().setEstado	(JOptionPane.showInputDialog ("Estado:"));
		pessoaFisicaEditada.getEndereco().setCidade	(JOptionPane.showInputDialog ("Cidade:"));
		pessoaFisicaEditada.getEndereco().setBairro	(JOptionPane.showInputDialog ("Bairro:"));
		pessoaFisicaEditada.getEndereco().setRua	(JOptionPane.showInputDialog ("Rua:"));
		pessoaFisicaEditada.getEndereco().setNumero	(JOptionPane.showInputDialog ("Numero:"));
		
		pessoa.set(i, pessoaFisicaEditada);
		JOptionPane.showMessageDialog(null, "Dados Do Locatário Atualizados! \n");
		return true;
	}
	
	public boolean editaLocatarioPJ(int i) {
		PessoaJuridica pessoaJuridicaEditada = new PessoaJuridica();
		try {
			pessoaJuridicaEditada.setNome	(JOptionPane.showInputDialog ("Nome:"));
			pessoaJuridicaEditada.setEMail	(JOptionPane.showInputDialog ("Email:"));
			pessoaJuridicaEditada.setCnpj	(JOptionPane.showInputDialog ("CNPJ:"));
			if(pessoaJuridicaEditada.getNome().trim().isEmpty() == true 
			|| pessoaJuridicaEditada.getEMail().trim().isEmpty() == true
			|| pessoaJuridicaEditada.getCnpj().trim().isEmpty() == true ) 
			{
				throw new Exception();
			}
		}catch(Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog (null, "Preencha todos os campos obrigatórios!\n"
										       + "Campos Obrigarótios: Nome, Email e CNPJ");
			return false;
		}
		pessoaJuridicaEditada.setTelefone				(JOptionPane.showInputDialog ("Telefone:"));
		pessoaJuridicaEditada.getEndereco().setEstado	(JOptionPane.showInputDialog ("Estado:"));
		pessoaJuridicaEditada.getEndereco().setCidade	(JOptionPane.showInputDialog ("Cidade:"));
		pessoaJuridicaEditada.getEndereco().setBairro	(JOptionPane.showInputDialog ("Bairro:"));
		pessoaJuridicaEditada.getEndereco().setRua		(JOptionPane.showInputDialog ("Rua:"));
		pessoaJuridicaEditada.getEndereco().setNumero	(JOptionPane.showInputDialog ("Numero:"));
		
		pessoa.set(i, pessoaJuridicaEditada);
		JOptionPane.showMessageDialog(null, "Dados Do Locatário Atualizados! \n");
		return true;
	}
	
	public void excluiLocatario(int i) {
		pessoa.remove(i);
		JOptionPane.showMessageDialog(null, "Locatário deletado com sucesso! \n");
	}
	
	public String listaLocatarios() {
		int i;
		String lista = "";
		for(i = 0;i < pessoa.size(); i++) {
			if(pessoa.get(i) instanceof PessoaFisica) {
				lista =	lista + "Índice: " 	  + i 					     				+ "\n"
							  + "Nome: " 	  + pessoa.get(i).getNome()  				+ "\n"
							  + "CPF: "  	  + ((PessoaFisica) pessoa.get(i)).getCpf() + "\n"
							  + "──────────────────────────────────────────────────────────\n";
			}else {
				lista =	lista + "Índice: " 	  + i 					     					+ "\n"
							  + "Nome: " 	  + pessoa.get(i).getNome()  					+ "\n"
							  + "CNPJ: "  	  + ((PessoaJuridica) pessoa.get(i)).getCnpj() 	+ "\n"
							  + "──────────────────────────────────────────────────────────────\n";
			}
			
		}
		return lista;
	}
}
