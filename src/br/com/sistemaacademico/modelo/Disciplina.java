package br.com.sistemaacademico.modelo;

import java.util.ArrayList;
import java.util.List;

public class Disciplina {
	
	private int codigo;
	private String descricao;
	private List<ProfessorDisciplina> professores;
	
	public Disciplina(int codigo, String descricao) {
		super();
		this.codigo = codigo;
		this.descricao = descricao;
		this.professores = new ArrayList<ProfessorDisciplina>();				
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public List<ProfessorDisciplina> getProfessores() {
		return professores;
	}
	public void setProfessores(List<ProfessorDisciplina> professores) {
		this.professores = professores;
	}
	@Override
	public String toString() {
		return "Disciplina [descricao=" + descricao + "]";
	}
	
	

}
