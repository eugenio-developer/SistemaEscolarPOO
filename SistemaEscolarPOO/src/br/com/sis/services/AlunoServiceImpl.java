package br.com.sis.services;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.com.sis.intefaces.IService;
import br.com.sis.models.Aluno;
import br.com.sis.repositorys.RepositoryAlunoImpl;

public class AlunoServiceImpl implements IService{
	RepositoryAlunoImpl repositoryA = new RepositoryAlunoImpl();
	
	public void add() {
		JTextField nome = new JTextField();
		JTextField cpf = new JTextField();
		JTextField nota = new JTextField();
		Object[] objAluno = { "Nome: ", nome, "CPF: ", cpf, "Nota: ", nota };
		JOptionPane.showConfirmDialog(null, objAluno, "Cadastra Aluno", JOptionPane.YES_NO_OPTION);
		if(repositoryA.getAluno(Integer.parseInt(cpf.getText())) == null && Integer.parseInt(nota.getText()) >= 0) {
			Aluno aluno = new Aluno(repositoryA.getIDSequencial(), Integer.parseInt(cpf.getText()), nome.getText(), Double.parseDouble(nota.getText()));
			repositoryA.addAluno(aluno);
			JOptionPane.showConfirmDialog(null, "Aluno cadastrado com sucesso!");
		}
		else {
			JOptionPane.showConfirmDialog(null, "CPF Informado já existente!");
		}
		
	}
	public void remove() {
		int cpf = Integer.parseInt(JOptionPane.showInputDialog("Digite o CPF do aluno para remove-lo: "));
		if(repositoryA.getAluno(cpf) == null) {
			JOptionPane.showConfirmDialog(null, "CPF digitado inexistente! ");
		}
		else {
			Aluno aluno = new Aluno();
			aluno = repositoryA.getAluno(cpf);
			repositoryA.removeAluno(aluno);
			JOptionPane.showConfirmDialog(null, "Removido com sucesso!");
		}	
	}
	public int getTotalItens() {
		return repositoryA.getTotalItens();
	}
	public Aluno getAluno(int cpf) {
		return repositoryA.getAluno(cpf);
	}
	public ArrayList<Aluno> getALLAlunos(){
		return repositoryA.listALL();
	}
	public void getResultadoAluno() {
		int cpf =Integer.parseInt(JOptionPane.showInputDialog("Digite o cpf do aluno: ")) ;
		if(repositoryA.getAluno(cpf)== null) {
			JOptionPane.showConfirmDialog(null, "CPF digitado invalido!");
		}
		else {
			String situacao;
			if(repositoryA.getAluno(cpf).getNota() < 40) {
				situacao = "Reprovado";
			}
			else if (repositoryA.getAluno(cpf).getNota() < 60) {
				situacao = "Exame Especial";
			}
			else {
				situacao = "Aprovado";
			}
			
			String resultado = "Nota= " +repositoryA.getAluno(cpf).getNota() + " ,Situação= " + situacao;
			
			JOptionPane.showMessageDialog(null, resultado);
		}
		
		
		
	}
	
}
