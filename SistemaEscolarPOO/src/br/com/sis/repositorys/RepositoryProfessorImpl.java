package br.com.sis.repositorys;

import java.util.ArrayList;

import br.com.sis.intefaces.IRepository;
import br.com.sis.models.Professor;

public class RepositoryProfessorImpl implements IRepository {
	ArrayList<Professor> professores = new ArrayList<Professor>();
	
	public void addProfessor(Professor professor) {
		professores.add(professor);
	}
	public void removeProfessor(Professor professor) {
		professores.remove(professor);
	}
	public int getIDSequencial() {
		return professores.size() + 1;
	}
	public int getTotalItens() {
		return professores.size();
	}
	public Professor getProfessor(int cpf) {
		for (Professor professor : professores) {
			if(professor.getCpf() == cpf) {
				return professor;
			}
		}
		return null;
	}
	public ArrayList<Professor> listALL(){
		return professores;
	}
	
	
	
	
}
