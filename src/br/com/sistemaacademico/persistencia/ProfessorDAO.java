package br.com.sistemaacademico.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sistemaacademico.modelo.Disciplina;
import br.com.sistemaacademico.modelo.Professor;
import br.com.sistemaacademico.modelo.ProfessorDisciplina;

public class ProfessorDAO {

	public void inserir(Professor professor) throws SQLException {
		Connection c = ConnectionFactory.getConnection();
		String sql = "INSERT INTO professores VALUES (?, ?)";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setInt(1, professor.getMatricula());
		ps.setString(2, professor.getNome());
		ps.execute();
		ps.close();
		c.close();
	}
	
	public List<Professor> obterListaSimples() throws SQLException {
		List<Professor> professores = new ArrayList<Professor>();
		
		Connection c = ConnectionFactory.getConnection();
		String sql = "Select matricula, nome from professores";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery(sql);
		
		while (rs.next()) {
			Professor p = new Professor(rs.getInt(1), rs.getString(2));
			professores.add(p);
		}
		
		ps.close();
		rs.close();
		c.close();
		
		return professores;
	}

	public List<Professor> obterLista() throws SQLException {
		List<Professor> professores = new ArrayList<Professor>();
		
		Connection c = ConnectionFactory.getConnection();
		String sql = "select p.matricula, p.nome, d.codigo, d.descricao, m.periodoletivo from professores p "
				+ "left join ministra m on m.matricula = p.matricula "
				+ "left join disciplinas d on d.codigo = m.codigo ";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery(sql);
		
		while (rs.next()) {
			int matricula = rs.getInt(1);
			String nome = rs.getString(2);
			Professor p = new Professor(matricula, nome);
			if (professores.contains(p)) {
				p = professores.get(professores.indexOf(p));
			} else {
				professores.add(p);
			}
			ProfessorDisciplina pd = new ProfessorDisciplina();
			pd.setProfessor(p);
			p.getDisciplinas().add(pd);
			pd.setPeriodo(rs.getString(5));
			Disciplina d = new Disciplina(rs.getInt(3), rs.getString(4));
			pd.setDisciplina(d);
			d.getProfessores().add(pd);
		}
		
		ps.close();
		rs.close();
		c.close();
		
		return professores;
	}
}
