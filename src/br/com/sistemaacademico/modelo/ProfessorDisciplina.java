package br.com.sistemaacademico.modelo;

public class ProfessorDisciplina {
	
	private String periodo;
	private Professor professor;
	private Disciplina disciplina;
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	@Override
	public String toString() {
		return "ProfessorDisciplina [periodo=" + periodo + ", disciplina="
				+ disciplina + "]";
	}
	
}
