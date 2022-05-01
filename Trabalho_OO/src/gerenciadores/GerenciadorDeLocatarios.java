package gerenciadores;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import pessoas.PessoaFisica;
import pessoas.PessoaJuridica;

public class GerenciadorDeLocatarios extends Gerenciador{

	LinkedList<PessoaFisica> locatariosPF = new LinkedList<PessoaFisica>();
	LinkedList<PessoaJuridica> locatariosPJ = new LinkedList<PessoaJuridica>();
	String strOpcao;
	int opcao;
	
	public boolean cadastraLocatarioPF() {
		PessoaFisica locatarioPF = new PessoaFisica();
		try {
			locatarioPF.setNome(JOptionPane.showInputDialog ("Nome Completo:"));
			locatarioPF.setEMail(JOptionPane.showInputDialog ("Email:"));
			locatarioPF.setCpf(JOptionPane.showInputDialog ("CPF:"));
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
		locatarioPF.setTelefone(JOptionPane.showInputDialog ("Telefone:"));
		locatarioPF.setEstadoCivil(JOptionPane.showInputDialog ("Estado Civil:"));
		locatarioPF.getEndereco().setEstado(JOptionPane.showInputDialog ("Estado:"));
		locatarioPF.getEndereco().setCidade(JOptionPane.showInputDialog ("Cidade:"));
		locatarioPF.getEndereco().setBairro(JOptionPane.showInputDialog ("Bairro:"));
		locatarioPF.getEndereco().setRua(JOptionPane.showInputDialog ("Rua:"));
		locatarioPF.getEndereco().setNumero(JOptionPane.showInputDialog ("Numero:"));
		
		locatariosPF.add(locatarioPF);
		JOptionPane.showMessageDialog (null, "Cadastro realizado com sucesso!\n");
		return true;
	}
	
	public boolean cadastraLocatarioPJ() {
		PessoaJuridica locatarioPJ = new PessoaJuridica();
		try {
			locatarioPJ.setNome(JOptionPane.showInputDialog ("Nome:"));
			locatarioPJ.setEMail(JOptionPane.showInputDialog ("Email:"));
			locatarioPJ.setCnpj(JOptionPane.showInputDialog ("CNPJ:"));
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
		locatarioPJ.setTelefone(JOptionPane.showInputDialog ("Telefone:"));
		locatarioPJ.getEndereco().setEstado(JOptionPane.showInputDialog ("Estado:"));
		locatarioPJ.getEndereco().setCidade(JOptionPane.showInputDialog ("Cidade:"));
		locatarioPJ.getEndereco().setBairro(JOptionPane.showInputDialog ("Bairro:"));
		locatarioPJ.getEndereco().setRua(JOptionPane.showInputDialog ("Rua:"));
		locatarioPJ.getEndereco().setNumero(JOptionPane.showInputDialog ("Numero:"));
					
		locatariosPJ.add(locatarioPJ);
		JOptionPane.showMessageDialog (null, "Cadastro realizado com sucesso!\n");
		return true;
	}
	
	public boolean buscaLocatario() {
		return false;	
	}
	
	public boolean editaLocatario() {
		return false;
	}
	
	public boolean excluiLocatario() {
		return false;
	}
}
