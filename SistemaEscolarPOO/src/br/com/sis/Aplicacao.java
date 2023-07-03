package br.com.sis;

import javax.swing.JOptionPane;

import br.com.sis.controllers.ControllerAluno;
import br.com.sis.controllers.ControllerProfessor;
import br.com.sis.services.AlunoServiceImpl;
import br.com.sis.services.ProfessorServiceImpl;



public class Aplicacao {
	// MAIN
	public static void main(String[] args) {
		ProfessorServiceImpl pService = new ProfessorServiceImpl();
		AlunoServiceImpl aService = new AlunoServiceImpl();
		boolean control = true;
		
		while(control) {
			switch(menuPrincipal()) {
			case 0:
				ControllerAluno.menu(aService);
				break;
			case 1:
				ControllerProfessor.menu(pService);
				break;
			case 2:
				aService.getResultadoAluno();
				break;
			case 3:
				int cpf = Integer.parseInt(JOptionPane.showInputDialog("Didite o cpf do professor: "));
				
				double salario;
				salario = pService.getProfessor(cpf).getSalario();
				salario = salario + (salario * 0.03) * aService.getTotalItens();
				
				JOptionPane.showConfirmDialog(null,  pService.getProfessor(cpf).toString()+"\nSalario: " + salario);
				break;
			case 4:
				control = false;
				break;
			}
			
			

		}		
	}
	
	//MENU PRINCIPAL
	public static int menuPrincipal() {

		String menuMensagem = "-------------------------------------------- Sistema Escolar POO -----------------------------------------------\n\n";
				

		String[] menuPrincipal = { "Alunos", "Professores", "Situação do aluno", "Salario Professor", "Sair"};
		int op = JOptionPane.showOptionDialog(null, menuMensagem, "Sistema POO", 1, 1, null, menuPrincipal,
				menuPrincipal[0]);
		return op;

	}
}
