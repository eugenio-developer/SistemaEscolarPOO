package br.com.sis.models;

public class Aluno extends Pessoa {
	private double nota;

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public Aluno(int codigo, int cpf, String nome,double nota) {
		super();
		super.setCodigo(codigo);
		super.setCpf(cpf);
		super.setNome(nome);
		this.nota = nota;
	}
	

	public Aluno() {
		super();
	}

	@Override
	public String toString() {
		return "Aluno [Nome= " + super.getNome()+ ", CPF= " + super.getCpf() + ", codigo= " +super.getCodigo() + ", nota= " + this.nota + "]\n";
	}
	
	
	
	
}
