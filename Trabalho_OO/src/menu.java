import javax.swing.JOptionPane;

public class menu {

	public static void main(String[] args) {
		
		String strOpcao, strOpcao1, strOpcao2, strOpcao2_2, strOpcao2_2_2;
		int opcao, opcao1, opcao2, opcao2_2, opcao2_2_2;
		
		do {
			strOpcao = JOptionPane.showInputDialog ("Menu Principal \n"
					                               + "1- Gerenciar Locat�rios \n"
					                               + "2- Gerenciar Frota \n"
					                               + "3- Gerenciar Reservas \n"
					                               + "0- Sair do Programa \n"
					                               + "Selecione uma op��o:");
			opcao = Integer.parseInt (strOpcao);
			
			if (opcao < 0 || opcao > 3) {
				JOptionPane.showMessageDialog (null, "Op��o inv�lida!");
			} else {
				switch (opcao) {
					case 1:
						strOpcao1 = JOptionPane.showInputDialog ("Menu Ger�ncia de Locat�rios: \n"
								                                + "1- Cadastrar Locat�rio \n"
								                                + "2- Buscar Locat�rio \n"
								                                + "3- Pesquisar Locat�rio \n"
								                                + "4- Excluir Locat�rio \n"
								                                + "Selecione uma op��o:");
						opcao1 = Integer.parseInt (strOpcao1);
						
						if (opcao1 < 1 || opcao1 > 4) {
							JOptionPane.showMessageDialog (null, "Op��o inv�lida!");
						} else {
							switch (opcao1) {
								case 1:
									JOptionPane.showMessageDialog (null, "Voc� vai agora cadastrar locat�rio");
								break;
								
								case 2:
									JOptionPane.showMessageDialog (null, "Voc� vai agora buscar locat�rio");
								break;
								
								case 3:
									JOptionPane.showMessageDialog (null, "Voc� vai agora pesquisar locat�rio");
								break;
								
								case 4:
									JOptionPane.showMessageDialog (null, "Voc� vai agora excluir locat�rio");
								break;
							}
						}
					break;
					
					case 2:
						strOpcao2 = JOptionPane.showInputDialog ("Menu Ger�ncia de Frotas: \n"
								                                + "1- Cadastrar ve�culos \n"
								                                + "2- Pesquisar ve�culo \n"
								                                + "Selecione uma op��o:");
						opcao2 = Integer.parseInt (strOpcao2);
						
						if (opcao2 < 1 || opcao2 > 2) {
							JOptionPane.showMessageDialog (null, "Op��o inv�lida!");
						} else {
							switch (opcao2) {
								case 1:
									strOpcao2_2 = JOptionPane.showInputDialog ("Menu de Cadastro de Ve�culos: \n"
											                                  + "1- Cadastrar ve�culo de passeio \n"
											                                  + "2- Cadastrar ve�culo utilit�rio \n"
											                                  + "3- Cadastrar motocicleta \n"
											                                  + "Selecione uma op��o:");
									opcao2_2 = Integer.parseInt (strOpcao2_2);
									
									if (opcao2_2 < 1 || opcao2_2 > 3) {
										JOptionPane.showMessageDialog (null, "Op��o inv�lida!");
									} else {
										switch (opcao2_2) {
											case 1:
												JOptionPane.showMessageDialog (null, "Voc� vai agora cadastrar ve�culo de passeio");
											break;
											
											case 2:
												JOptionPane.showMessageDialog (null, "Voc� vai agora cadastrar ve�culo utilit�rio");
											break;
											
											case 3:
												JOptionPane.showMessageDialog (null, "Voc� vai agora cadastrar motocicleta");
											break;
										}
									}
								break;
								
								case 2:
									strOpcao2_2_2 = JOptionPane.showInputDialog ("Menu de Pesquisa de Ve�culos: \n"
											                                    + "1- Pesquisar ve�culo pelo Renavam \n"
											                                    + "2- Pesquisar ve�culo por marca, modelo, Renavam \n"
											                                    + "3- Atualizar dados de um ve�culo \n"
											                                    + "4- Remover ve�culo da frota \n"
											                                    + "Selecione uma op��o:");
									opcao2_2_2 = Integer.parseInt (strOpcao2_2_2);
									
									if (opcao2_2_2 < 1 || opcao2_2_2 > 4) {
										JOptionPane.showMessageDialog (null, "Op��o inv�lida!");
									} else {
										switch (opcao2_2_2) {
											case 1:
												JOptionPane.showMessageDialog (null, "Voc� vai agora pesquisar ve�culo pelo Renavam");
											break;
											
											case 2:
												JOptionPane.showMessageDialog (null, "Voc� vai agora pesquisar ve�culo por marca, modelo, Renavam");
											break;
											
											case 3:
												JOptionPane.showMessageDialog (null, "Voc� vai agora atualizar dados de um ve�culo");
											break;
											
											case 4:
												JOptionPane.showMessageDialog (null, "Voc� vai agora remover ve�culo da frota");
											break;
										}
									}
								break;
							}
						}
					break;
					
					case 3:
						JOptionPane.showMessageDialog (null, "Voc� vai agora gerenciar reservas");
					break;
					
					case 0:
						JOptionPane.showMessageDialog (null, "Obrigado por usar o Programa!");
					break;
				}
			}
		} while (opcao != 0);
	}

}
