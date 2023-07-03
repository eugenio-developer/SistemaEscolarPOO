package br.com.sis.services;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.com.sis.intefaces.IService;
import br.com.sis.models.Professor;
import br.com.sis.repositorys.RepositoryProfessorImpl;

public class ProfessorServiceImpl implements IService {
	RepositoryProfessorImpl repositoryP = new RepositoryProfessorImpl ();
	
	public void add() {
		JTextField nome = new JTextField();
		JTextField cpf = new JTextField();
		Object[] objProfessor = { "Nome: ", nome, "CPF: ", cpf };
		JOptionPane.showConfirmDialog(null, objProfessor, "Cadastra Professor", JOptionPane.YES_NO_OPTION);
		if(repositoryP.getProfessor(Integer.parseInt(cpf.getText())) == null) {
			Professor professor = new Professor(repositoryP.getIDSequencial(), Integer.parseInt(cpf.getText()), nome.getText());
			professor.setSalario(2380.00);
			repositoryP.addProfessor(professor);
			JOptionPane.showConfirmDialog(null, "Professor cadastrado com sucesso!");
		}
		else {
			JOptionPane.showConfirmDialog(null, "CPF informado já existente!");
		}
		
	}
	
	public void remove() {
		int cpf = Integer.parseInt(JOptionPane.showInputDialog("Digite o cpf do professor para removelo: "));
		if(repositoryP.getProfessor(cpf) == null) {
			JOptionPane.showConfirmDialog(null, "CPF digitado inexistente! ");
		}
		else {
			
			Professor professor = new Professor();
			professor = repositoryP.getProfessor(cpf);
			repositoryP.removeProfessor(professor);
			JOptionPane.showConfirmDialog(null, "Removido com sucesso!");
		}
		
	}
	
	public int getTotalItens() {
		return repositoryP.getTotalItens();
	}
	
	public Professor getProfessor(int cpf) {
		return repositoryP.getProfessor(cpf);
		
	}
	public ArrayList<Professor> getALLProfessor(){
		return repositoryP.listALL();
	}
}
