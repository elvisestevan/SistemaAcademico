package br.com.sistemaacademico.modelo;

import java.util.ArrayList;
import java.util.List;

public class Professor {
	
	private int matricula;
	private String nome;
	private List<ProfessorDisciplina> disciplinas;
	
	public Professor(int matricula, String nome) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.disciplinas = new ArrayList<ProfessorDisciplina>();
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
		return "Professor [matricula=" + matricula + ", nome=" + nome
				+ ", disciplinas=" + disciplinas + "]\n";
	}
	public List<ProfessorDisciplina> getDisciplinas() {
		return disciplinas;
	}
	public void setDisciplinas(List<ProfessorDisciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + matricula;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Professor other = (Professor) obj;
		if (matricula != other.matricula)
			return false;
		return true;
	}
	
	
}
