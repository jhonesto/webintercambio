package br.com.webintercambio.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.webintercambio.model.Agencia;

/**
*
* @author João Paulo
*/

public class AgenciaDAO {

	EntityManager manager;

	public AgenciaDAO(EntityManager manager) {
		this.manager = manager;
	}

	public boolean cadastrarAgencia(Agencia agencia) {
		try {
			this.manager.persist(agencia);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	public Agencia obterAgenciaByID(int id) {
		Query query = this.manager.createQuery("From Agencias a WHERE a.idAgencia = :id");
		query.setParameter("id", id);
		return (Agencia) query.getSingleResult();
	}

	public int obterIdByUser(String login) {
		Query query = this.manager.createQuery("From Agencias WHERE login = :login");
		query.setParameter("login", login);
		Agencia ag = (Agencia) query.getSingleResult();
		return ag.getIdAgencia();
	}
}
