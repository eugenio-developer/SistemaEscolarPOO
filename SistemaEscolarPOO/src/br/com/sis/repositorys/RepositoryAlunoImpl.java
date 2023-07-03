package br.com.sis.repositorys;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.com.sis.intefaces.IRepository;
import br.com.sis.models.Aluno;

public class RepositoryAlunoImpl implements IRepository {
	ArrayList<Aluno>alunos = new ArrayList<Aluno>();
	
	public int getIDSequencial() {
		return alunos.size() + 1;
	}
	public int getTotalItens() {
		return alunos.size();
	}
	public Aluno getAluno(int cpf) {
		for (Aluno aluno : alunos) {
			if(aluno.getCpf() == cpf) {
				return aluno;
			}
		}
		return null;
	}
	public void addAluno(Aluno aluno) {
		alunos.add(aluno);
	}
	public void removeAluno(Aluno aluno) {
		alunos.remove(aluno);
	}
	public ArrayList<Aluno> listALL() {
		return alunos;
	}

	
}
