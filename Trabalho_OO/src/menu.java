import javax.swing.JOptionPane;

import gerenciadores.*;
import java.text.ParseException;

public class menu {

	public static void main(String args[]) throws ParseException {
		
		String strOpcao;
		int opcao;
		GerenciadorDeFrota gerenciadorDeFrota = new GerenciadorDeFrota();
		GerenciadorDeLocatarios gerenciadorDeLocatarios = new GerenciadorDeLocatarios();
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
						strOpcao = JOptionPane.showInputDialog ("Menu Gerência de Locatários: \n"
							                                  + "1- Cadastrar Locatário       \n"
							                                  + "2- Editar Locatários         \n"
							                                  + "3- Pesquisar Locatário       \n"
							                                  + "4- Excluir Locatário         \n"
							                                  + "Selecione uma opção:");
						opcao = Integer.parseInt (strOpcao);
						if (opcao < 1 || opcao > 4) {
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
									do {
										strOpcao = JOptionPane.showInputDialog ("Menu Edita Locatários:    \n"
																			  + "1 - Pessoas Físicas       \n"
																			  + "2 - Pessoas Jurídicas     \n");
										opcao = Integer.parseInt (strOpcao);
									}while(opcao != 1 && opcao != 2);
									
									break;
								
								case 3:
									JOptionPane.showMessageDialog (null, "Voc� vai agora pesquisar locatário");
									break;
								
								case 4:
									JOptionPane.showMessageDialog (null, "Voc� vai agora excluir locatário");
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
									                                      + "1- Pesquisar veículo pelo Renavam 				 \n"
									                                      + "2- Pesquisar veículo por marca, modelo, Renavam \n"
									                                      + "3- Atualizar dados de um veículo 				 \n"
									                                      + "4- Remover veículo da frota 					 \n"
									                                      + "Selecione uma opção:");
									opcao = Integer.parseInt (strOpcao);
									
									if (opcao < 1 || opcao > 4) {
										JOptionPane.showMessageDialog (null, "opção inválida!");
									} else {
										switch (opcao) {
											case 1:
												JOptionPane.showMessageDialog (null, "Você vai agora pesquisar veículo pelo Renavam");
											break;
											
											case 2:
												JOptionPane.showMessageDialog (null, "Você vai agora pesquisar veículo por marca, modelo, Renavam");
											break;
											
											case 3:
												JOptionPane.showMessageDialog (null, "Você vai agora atualizar dados de um veículo");
											break;
											
											case 4:
												JOptionPane.showMessageDialog (null, "Você vai agora remover veículo da frota");
											break;
										}
									}
								break;
							}
						}
					break;
					
					case 3:
						JOptionPane.showMessageDialog (null, "Você vai agora gerenciar reservas");
					break;
					
					case 0:
						JOptionPane.showMessageDialog (null, "Obrigado por usar o Programa!");
					break;
				}
			}
		} while (opcao != 0);
	}

}
