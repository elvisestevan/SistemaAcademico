package br.com.sistemaacademico.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.sistemaacademico.modelo.Disciplina;

public class DisciplinaDAO {
	
	public List<Disciplina> obter(String inicial) throws SQLException {
		List<Disciplina> disciplinas = new ArrayList<Disciplina>();
		
		Connection c = ConnectionFactory.getConnection();
		String sql = "select codigo, descricao from disciplinas where descricao like ?";
		PreparedStatement ps = c.prepareStatement(sql);
		ps.setString(1, inicial + "%");
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			Disciplina d = new Disciplina(rs.getInt(1), rs.getString(2));
			disciplinas.add(d);
		}
		
		ps.close();
		rs.close();
		c.close();
		
		return disciplinas;
	}
	
	public List<Disciplina> obterLista() throws SQLException {
		List<Disciplina> disciplinas = new ArrayList<Disciplina>();
		
		Connection c = ConnectionFactory.getConnection();
		String sql = "Select codigo, descricao from disciplinas";
		PreparedStatement ps = c.prepareStatement(sql);
		ResultSet rs = ps.executeQuery(sql);
		
		while (rs.next()) {
			Disciplina d = new Disciplina(rs.getInt(1), rs.getString(2));
			disciplinas.add(d);
		}
		
		ps.close();
		rs.close();
		c.close();
		
		return disciplinas;
	}

}
