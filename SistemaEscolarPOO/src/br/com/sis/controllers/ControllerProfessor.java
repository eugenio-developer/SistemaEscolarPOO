package br.com.sis.controllers;



import javax.swing.JOptionPane;


import br.com.sis.services.ProfessorServiceImpl;

public class ControllerProfessor {
	
	public static void menu(ProfessorServiceImpl pService) {
		
		boolean control = true;
		while(control) {
			String menuMensagem = "::Menu Professor::\n\nProfessores Cadastrados: " + pService.getTotalItens()
									+ "\n\n\n\n\nDigite sua opção:";
			String[] menuOpcao = {"Cadastrar" , "Remover" , "Listar" , "Pesquisar" ,"Voltar"};
			int op = JOptionPane.showOptionDialog(null, menuMensagem, "Sistema POO", 1, 1, null, menuOpcao,
					menuOpcao[0]);
			switch(op) {
			case 0:
				pService.add();
				break;
			case 1:
				pService.remove();
				break;
			case 2:
				String listaProfessor = "";
				for(int i =0; i < pService.getALLProfessor().size(); i++) {
					listaProfessor += pService.getALLProfessor().get(i).toString();
				}
				JOptionPane.showMessageDialog(null, listaProfessor);
				break;
			case 3:
				int cpf = Integer.parseInt(JOptionPane.showInputDialog("Digite o cpf do professor:"));
				JOptionPane.showMessageDialog(null, pService.getProfessor(cpf).toString());
				break;
			case 4:
				control = false;
				break;
				
			}
			
		}
	}
	
	
}
