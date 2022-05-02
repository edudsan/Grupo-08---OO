import javax.swing.JOptionPane;

import gerenciadores.*;
import java.text.ParseException;

public class menu {

	public static void main(String args[]) throws ParseException {
		
		String strOpcao;
		int opcao;
		GerenciadorDeLocatarios gerenciadorDeLocatarios = new GerenciadorDeLocatarios();
		GerenciadorDeFrota gerenciadorDeFrota = new GerenciadorDeFrota();
		GerenciadorDeReservas gerenciadorDeReservas = new GerenciadorDeReservas();
		

		do {
			strOpcao = JOptionPane.showInputDialog ("Menu Principal          \n"
					                              + "1- Gerenciar Locatários \n"
					                              + "2- Gerenciar Frota      \n"
					                              + "3- Gerenciar Reservas   \n"
					                              + "0- Sair do Programa     \n"
					                              + "Selecione uma opção:");
			opcao = Integer.parseInt (strOpcao);
			
			if (opcao < 0 || opcao > 3) {
				JOptionPane.showMessageDialog (null, "Opção inválida!");
			} else {
				switch (opcao) {
					case 1:
						strOpcao = JOptionPane.showInputDialog ("Menu Gerência de Locatários: 	\n"
							                                  + "1 - Cadastrar Locatário     	\n"
							                                  + "2 - Buscar Locatário        	\n"
							                                  + "Selecione uma opção:");
						opcao = Integer.parseInt (strOpcao);
						if (opcao < 1 || opcao > 2) {
							JOptionPane.showMessageDialog (null, "Opção inv�lida!");
						}else {
							switch (opcao) {
								case 1:
									do {
										strOpcao = JOptionPane.showInputDialog ("Menu Cadastro Locatários: \n"
																			  + "1 - Pessoa Física         \n"
																			  + "2 - Pessoa Jurídica       \n");
										opcao = Integer.parseInt (strOpcao);
									}while(opcao != 1 && opcao != 2);
									if(opcao == 1) {
										gerenciadorDeLocatarios.cadastraLocatarioPF();
									}else {
										gerenciadorDeLocatarios.cadastraLocatarioPJ();
									}
									break;
								
								case 2:
									try {
										if(gerenciadorDeLocatarios.buscaLocatario() == false) {
											throw new Exception();
										}
									}catch(Exception e) {
										e.printStackTrace();
										JOptionPane.showMessageDialog (null, "Objeto não encontrado		\n");
									}
									break;
							}
						}
					break;
					
					case 2:
						strOpcao = JOptionPane.showInputDialog ("Menu Gerência de Frotas: \n"
															  + "1- Cadastrar veículos    \n"
															  + "2- Pesquisar veículo     \n"
															  + "Selecione uma opção:");
						opcao = Integer.parseInt (strOpcao);
						
						if (opcao < 1 || opcao > 2) {
							JOptionPane.showMessageDialog (null, "Opção inválida!");
						} else {
							switch (opcao) {
								case 1:
									gerenciadorDeFrota.cadastraVeiculo();
									break;
			
								case 2:
									strOpcao = JOptionPane.showInputDialog ("Menu de Pesquisa de veículos:                   \n"
									                                      + "1- Pesquisar veículo 							 \n"
									                                      + "2- Editar dados de um veículo 				 	 \n"
									                                      + "3- Remover veículo da frota 					 \n"
									                                      + "Selecione uma opção:");
									opcao = Integer.parseInt (strOpcao);
									
									if (opcao < 1 || opcao > 3) {
										JOptionPane.showMessageDialog (null, "opção inválida!");
									} else {
										switch (opcao) {
											case 1:
												JOptionPane.showMessageDialog (null, "Você vai agora pesquisar veículo pelo Renavam");
											break;	
											
											case 2:
												JOptionPane.showMessageDialog (null, "Você vai agora atualizar dados de um veículo");
											break;
											
											case 3:
												JOptionPane.showMessageDialog (null, "Você vai agora remover veículo da frota");
											break;
										}
									}
								break;
							}
						}
						break;
					
					case 3:
						if(gerenciadorDeLocatarios.getPessoa().size() == 0 || gerenciadorDeFrota.getVeiculo().size() == 0) {
							JOptionPane.showMessageDialog(null, "Cadastre pelo menos um locatário "
															  + "e veículo antes de fazer uma reserva\n");
							break;
						}
						do {
							strOpcao = JOptionPane.showInputDialog("Que tipo de reserva você deseja fazer: 	\n"
															     + "1 - Normal								\n"
															     + "2 - Empresarial							\n"
															     + "3 - Mensal								\n");
							opcao = Integer.parseInt(strOpcao);
						}while(opcao < 1 || opcao > 3);
						if(opcao == 1) {
							gerenciadorDeReservas.reservaNormal();
						}else if(opcao == 2) {
							gerenciadorDeReservas.reservaEmpresarial();
						}else if(opcao == 3) {
							gerenciadorDeReservas.reservaMensal();
						}
						
						break;
					
					case 0:
						JOptionPane.showMessageDialog (null, "Obrigado por usar o Programa!");
						break;
				}
			}
		} while (opcao != 0);
	}

}
