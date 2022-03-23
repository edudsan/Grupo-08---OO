import javax.swing.JOptionPane;

public class Menu_Principal2 {

	public static void main(String[] args) {
		
		String stropcao, stropcao1, stropcao2, stropcao2_2, stropcao2_2_2;
		int opcao, opcao1, opcao2, opcao2_2, opcao2_2_2;
		
		do {
			stropcao = JOptionPane.showInputDialog ("Menu Principal \n"
					                               + "1- Gerenciar Locatários \n"
					                               + "2- Gerenciar Frota \n"
					                               + "3- Gerenciar Reservas \n"
					                               + "4- Sair do Programa \n"
					                               + "Selecione uma opção:");
			opcao = Integer.parseInt (stropcao);
			
			if (opcao < 1 || opcao > 4) {
				JOptionPane.showMessageDialog (null, "Opção inválida!");
			} else {
				switch (opcao) {
					case 1:
						stropcao1 = JOptionPane.showInputDialog ("Menu Gerência de Locatários: \n"
								                                + "1- Cadastrar Locatário \n"
								                                + "2- Buscar Locatário \n"
								                                + "3- Pesquisar Locatário \n"
								                                + "4- Excluir Locatário \n"
								                                + "Selecione uma opção:");
						opcao1 = Integer.parseInt (stropcao1);
						
						if (opcao1 < 1 || opcao1 > 4) {
							JOptionPane.showMessageDialog (null, "Opção inválida!");
						} else {
							switch (opcao1) {
								case 1:
									JOptionPane.showMessageDialog (null, "Você vai agora cadastrar locatário");
								break;
								
								case 2:
									JOptionPane.showMessageDialog (null, "Você vai agora buscar locatário");
								break;
								
								case 3:
									JOptionPane.showMessageDialog (null, "Você vai agora pesquisar locatário");
								break;
								
								case 4:
									JOptionPane.showMessageDialog (null, "Você vai agora excluir locatário");
								break;
							}
						}
					break;
					
					case 2:
						stropcao2 = JOptionPane.showInputDialog ("Menu Gerência de Frotas: \n"
								                                + "1- Cadastrar veículos \n"
								                                + "2- Pesquisar veículo \n"
								                                + "Selecione uma opção:");
						opcao2 = Integer.parseInt (stropcao2);
						
						if (opcao2 < 1 || opcao2 > 2) {
							JOptionPane.showMessageDialog (null, "Opção inválida!");
						} else {
							switch (opcao2) {
								case 1:
									stropcao2_2 = JOptionPane.showInputDialog ("Menu de Cadastro de Veículos: \n"
											                                  + "1- Cadastrar veículo de passeio \n"
											                                  + "2- Cadastrar veículo utilitário \n"
											                                  + "3- Cadastrar motocicleta \n"
											                                  + "Selecione uma opção:");
									opcao2_2 = Integer.parseInt (stropcao2_2);
									
									if (opcao2_2 < 1 || opcao2_2 > 3) {
										JOptionPane.showMessageDialog (null, "Opção inválida!");
									} else {
										switch (opcao2_2) {
											case 1:
												JOptionPane.showMessageDialog (null, "Você vai agora cadastrar veículo de passeio");
											break;
											
											case 2:
												JOptionPane.showMessageDialog (null, "Você vai agora cadastrar veículo utilitário");
											break;
											
											case 3:
												JOptionPane.showMessageDialog (null, "Você vai agora cadastrar motocicleta");
											break;
										}
									}
								break;
								
								case 2:
									stropcao2_2_2 = JOptionPane.showInputDialog ("Menu de Pesquisa de Veículos: \n"
											                                    + "1- Pesquisar veículo pelo Renavam \n"
											                                    + "2- Pesquisar veículo por marca, modelo, Renavam \n"
											                                    + "3- Atualizar dados de um veículo \n"
											                                    + "4- Remover veículo da frota \n"
											                                    + "Selecione uma opção:");
									opcao2_2_2 = Integer.parseInt (stropcao2_2_2);
									
									if (opcao2_2_2 < 1 || opcao2_2_2 > 4) {
										JOptionPane.showMessageDialog (null, "Opção inválida!");
									} else {
										switch (opcao2_2_2) {
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
					
					case 4:
						JOptionPane.showMessageDialog (null, "Obrigado por usar o Programa!");
					break;
				}
			}
		} while (opcao != 4);
	}

}
