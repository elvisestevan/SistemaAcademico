package br.com.sistemaacademico.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sistemaacademico.modelo.Professor;

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
	
	public List<Professor> obterLista() throws SQLException {
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

}
