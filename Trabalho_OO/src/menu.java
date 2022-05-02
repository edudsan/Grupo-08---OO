import javax.swing.JOptionPane;

import gerenciadores.*;
import pessoas.PessoaFisica;

import java.text.ParseException;

public class menu extends Gerenciador{

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
							                                  + "3 - Edita Locatário			\n"
							                                  + "4 - Exclui Locatário			\n"
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
									try {
										if(gerenciadorDeLocatarios.buscaLocatario() == false) {
											throw new Exception();
										}
									}catch(Exception e) {
										e.printStackTrace();
										JOptionPane.showMessageDialog (null, "Objeto não encontrado		\n");
									}
									break;
								case 3:
									if(pessoa.size() == 0) {
										JOptionPane.showMessageDialog(null, "Não há locatários cadastrados!!");
										opcao++; 
										break;
									}
									do {
										strOpcao = JOptionPane.showInputDialog(gerenciadorDeLocatarios.listaLocatarios()
												+ "Selecione um dos locatarios para editar: \n");
										opcao = Integer.parseInt(strOpcao);
									}while (opcao < 0 || opcao > pessoa.size()-1);
									if(pessoa.get(opcao) instanceof PessoaFisica) 
										gerenciadorDeLocatarios.editaLocatarioPF(opcao);
									else 
										gerenciadorDeLocatarios.editaLocatarioPJ(opcao);
									opcao++;
									break;
								case 4:
									if(pessoa.size() == 0) {
										JOptionPane.showMessageDialog(null, "Não há locatários cadastrados!!");
										opcao++; 
										break;
									}
									do {
										strOpcao = JOptionPane.showInputDialog(gerenciadorDeLocatarios.listaLocatarios()
												 + "Selecione um dos locatarios para excluir: \n");
										opcao = Integer.parseInt(strOpcao);
									}while(opcao < 0 || opcao > pessoa.size()-1);
									gerenciadorDeLocatarios.excluiLocatario(opcao);							
									opcao++;
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
												try {
													if(gerenciadorDeFrota.buscaVeiculo() == false) {
														throw new Exception();
													}
												}catch(Exception e) {
													e.printStackTrace();
													JOptionPane.showMessageDialog (null, "Objeto não encontrado		\n");
												}											
												break;	
											
											case 2:
												if(veiculo.size() == 0) {
													JOptionPane.showMessageDialog(null, "Não há veiculos cadastrados!!");
													opcao++; 
													break;
												}
												do {
													strOpcao = JOptionPane.showInputDialog(gerenciadorDeFrota.listaVeiculos()
															 + "Selecione um dos veículos para editar: \n");
													opcao = Integer.parseInt(strOpcao);
												}while(opcao < 0 || opcao > veiculo.size()-1);
												gerenciadorDeFrota.editaVeiculo(opcao);							
												opcao++;											
												break;
											
											case 3:
												if(veiculo.size() == 0) {
													JOptionPane.showMessageDialog(null, "Não há veiculos cadastrados!!");
													opcao++; 
													break;
												}
												do {
													strOpcao = JOptionPane.showInputDialog(gerenciadorDeFrota.listaVeiculos()
															 + "Selecione um dos veículos para excluir: \n");
													opcao = Integer.parseInt(strOpcao);
												}while(opcao < 0 || opcao > veiculo.size()-1);
												gerenciadorDeFrota.excluiVeiculo(opcao);							
												opcao++;											
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
							strOpcao = JOptionPane.showInputDialog("Gerenciador De Reservas: 			\n"
															     + "1 - Cadastra Reserva				\n"
															     + "2 - Emite Relatorio					\n"
															     + "3 - Relatorio Consolidado			\n");
							opcao = Integer.parseInt(strOpcao);
						}while(opcao < 1 || opcao > 3);
						if(opcao == 1) {
							do {
								strOpcao = JOptionPane.showInputDialog("Que tipo de reserva você deseja fazer: 	\n"
																     + "1 - Normal								\n"
																     + "2 - Empresarial							\n"
																     + "3 - Mensal								\n");
								opcao = Integer.parseInt(strOpcao);
							}while(opcao < 1 || opcao > 3);
							if(opcao == 1) {
								gerenciadorDeReservas.reservaNormal();
								break;
							}else if(opcao == 2) {
								gerenciadorDeReservas.reservaEmpresarial();
								break;
							}else if(opcao == 3) {
								gerenciadorDeReservas.reservaMensal();
								break;
							}
						}else if(opcao == 2) {
							JOptionPane.showMessageDialog(null, gerenciadorDeReservas.emitirRelatorio());
						}else if(opcao == 3) {
							
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
