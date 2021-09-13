package br.com.webintercambio.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.webintercambio.model.Vaga;

/**
*
* @author João Paulo
*/

public class VagasDAO {
	
	private EntityManager manager ;

	public VagasDAO(EntityManager manager) {
		this.manager = manager;
	}
	
	public boolean cadastrarVaga(Vaga vaga) {
		try {
			this.manager.persist(vaga);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public List<Vaga> listarVagas(){
		Query query = this.manager.createQuery("Select v From Vagas v");
		return query.getResultList();
	}
	
	public int qtdMyVagas(int idAgencia) {
		Query query = this.manager.createQuery("Select count(*) AS QTD From Vagas vg where vg.idAgencia = :idAgencia");
		query.setParameter("idAgencia", idAgencia);
		return ((Long)query.getSingleResult()).intValue();
	}	
	
	public int qtdVagas() {
		Query query = this.manager.createQuery("Select count(*) AS QTD from Vagas");
		return ((Long)query.getSingleResult()).intValue();
	}
}
