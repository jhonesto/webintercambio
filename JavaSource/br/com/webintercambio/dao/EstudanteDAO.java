package br.com.webintercambio.dao;

import javax.persistence.EntityManager;

import br.com.webintercambio.model.Estudante;

/**
*
* @author João Paulo
*/

public class EstudanteDAO {
	
	EntityManager manager;
	
	public EstudanteDAO(EntityManager manager) {
		this.manager = manager;
	}

	public boolean cadastrarEstudante(Estudante estudante) {
		try {
			this.manager.persist(estudante);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public Estudante obterEstudanteByID(int id) {
		return null;
	}
	
}
