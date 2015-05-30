package br.com.sistemaacademico.principal;

import java.sql.SQLException;
import java.util.Scanner;

import br.com.sistemaacademico.modelo.Professor;
import br.com.sistemaacademico.persistencia.DisciplinaDAO;
import br.com.sistemaacademico.persistencia.ProfessorDAO;

public class Principal {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		ProfessorDAO professorDao = new ProfessorDAO();
		DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
		int op;

		do {
			System.out.println("0 - Sair");
			System.out.println("1 - Inserir Professor");
			System.out.println("2 - Listar professores simples");
			System.out.println("3 - Listar professores");
			System.out.println("4 - Listar disciplinas");
			System.out.println("5 - Listar disciplinas (Letra inicial)");
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
					professorDao.inserir(professor);
				} catch (Exception e) {
					System.out.println("Errooo: " + e.getMessage());
				}
			case 2:
				try {
					System.out.println(professorDao.obterListaSimples());
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				try {
					System.out.println(professorDao.obterLista());
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 4:
				try {
					System.out.println(disciplinaDAO.obterLista());
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 5:
				try {
					System.out.println("Informe uma letra inicial");
					String inicial = s.next();
					System.out.println(disciplinaDAO.obter(inicial));
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			}
		} while (op != 0);
		
		s.close();
	}

}
