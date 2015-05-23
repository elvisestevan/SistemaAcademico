package br.com.sistemaacademico.principal;

import java.sql.SQLException;
import java.util.Scanner;

import br.com.sistemaacademico.modelo.Professor;
import br.com.sistemaacademico.persistencia.ProfessorDAO;

public class Principal {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ProfessorDAO dao = new ProfessorDAO();
		int op;

		do {
			System.out.println("0 - Sair");
			System.out.println("1 - Inserir Professor");
			System.out.println("2 - Listar professores");
			op = s.nextInt();

			switch (op) {
			case 0:
				System.out.println("Até logo");
				break;
			case 1:
				try {
					System.out.println("Digite a matricula");
					int matricula = s.nextInt();
					s.nextLine();
					System.out.println("Digite o nome");
					String nome = s.nextLine();
					Professor professor = new Professor(matricula, nome);					
					dao.inserir(professor);
				} catch (Exception e) {
					System.out.println("Errooo: " + e.getMessage());
				}
			case 2:
				try {
					System.out.println(dao.obterLista());
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} while (op != 0);
		
		s.close();
	}

}
