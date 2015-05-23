package br.com.sistemaacademico.persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public static Connection getConnection() throws SQLException {
		Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/sistemaacademico", "root", "310890");
		return c;
	}

}
