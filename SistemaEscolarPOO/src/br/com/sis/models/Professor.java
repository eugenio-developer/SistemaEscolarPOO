package br.com.sis.models;

public class Professor extends Pessoa {
	private double salario;

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Professor(int codigo, int cpf, String nome) {
		super();
		super.setCpf(cpf);
		super.setNome(nome);
		super.setCodigo(codigo);
	}
	public Professor() {
		
	}
	
	@Override
	public String toString() {
		return "Professor [ Nome= " + super.getNome() + ", CPF= " + super.getCpf() + ", Codigo= " + super.getCodigo() + "]\n";
	}
	
	
	
	
}
