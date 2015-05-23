package br.com.sistemaacademico.modelo;

public class Professor {
	
	private int matricula;
	private String nome;
	
	public Professor(int matricula, String nome) {
		super();
		this.matricula = matricula;
		this.nome = nome;
	}
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		return "Professor [matricula=" + matricula + ", nome=" + nome + "]";
	}
	
}
