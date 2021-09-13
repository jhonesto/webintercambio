package br.com.webintercambio.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.webintercambio.model.Mensagem;

/**
*
* @author João Paulo
*/

public class MensagemDAO {
	
	private EntityManager manager;
	
	public MensagemDAO(EntityManager manager) {
		this.manager = manager;
	}

	public boolean criarMensagem(Mensagem mensagem) {
		try {
			this.manager.persist(mensagem);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public Mensagem obterMensagemByID(int id) {
		Query query = this.manager.createQuery("from Mensagens msg Where msg.id = :id");
		query.setParameter("id", id);
		return (Mensagem)query.getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Mensagem> obterMensagens(String loginTo){
		Query query = this.manager.createQuery("from Mensagens msg Where msg.loginTo = :loginTo");
		query.setParameter("loginTo", loginTo);
		return query.getResultList();
	}
	
	public int qtdMyMensagens(String loginTo) {
		Query query = this.manager.createQuery(
				"Select count(*) AS QTD from Mensagens msg Where msg.loginTo = :loginTo");
		query.setParameter("loginTo", loginTo);
		return ((Long)query.getSingleResult()).intValue();
	}
	
}
