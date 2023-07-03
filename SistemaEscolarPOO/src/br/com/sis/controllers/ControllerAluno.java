package br.com.sis.controllers;

import javax.swing.JOptionPane;

import br.com.sis.services.AlunoServiceImpl;

public class ControllerAluno {
	
	public static void menu(AlunoServiceImpl aService) {
		
		boolean control = true;
		while(control) {
			String menuMensagem = "::Menu Aluno::\n\nAlunos Cadastrados: " + aService.getTotalItens()
			+ "\n\n\n\n\nDigite sua opção:";
			String[] menuOpcao = {"Cadastrar" , "Remover" , "Listar" , "Pesquisar" ,"Voltar"};
			int op = JOptionPane.showOptionDialog(null, menuMensagem, "Sistema POO", 1, 1, null, menuOpcao,
					menuOpcao[0]);
			switch(op) {
			case 0:
				aService.add();
				break;
			case 1 :
				aService.remove();
				break;
			case 2:
				String listaAluno = "";
				for(int i = 0; i < aService.getALLAlunos().size(); i++) {
					listaAluno += aService.getALLAlunos().get(i).toString();
				}
				JOptionPane.showMessageDialog(null, listaAluno);
				break;
			case 3:
				int cpf = Integer.parseInt(JOptionPane.showInputDialog("Digite o cpf do aluno:"));
				JOptionPane.showMessageDialog(null, aService.getAluno(cpf).toString());
				break;
			case 4:
				control = false;
				break;
				
			}
		}
	}
}
