package br.com.webintercambio.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.webintercambio.model.User;

/**
*
* @author João Paulo
*/

public class UserDAO {

	private EntityManager manager ;

	public UserDAO(EntityManager manager) {
		this.manager = manager;
	}
	
	public boolean cadastrarUser(User user) {
		try {
			
			if (usuarioValido(user)) {
				this.manager.persist(user);
				return true;
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	private boolean usuarioValido(User user) {
		
		if(user == null) return false;
		
		String login = user.getLogin();
		String senha = user.getSenha();
		String job = user.getJob();
		
		if (login == null || login.trim().equalsIgnoreCase("") 
				|| senha == null || senha.trim().equalsIgnoreCase("")
				|| job == null || job.trim().equalsIgnoreCase("")) {
			return false;
		}
		return true;
	}

	public String obterJobByUser(String login) {
		Query query = this.manager.createQuery("from Usuarios us Where us.login = :login");
		query.setParameter("login", login);
		User us = (User)query.getSingleResult();
		return us.getJob();
	}
	
	public User obterUserByLogin(String login) {
		Query query = this.manager.createQuery("from Usuarios us Where us.login = :login");
		query.setParameter("login", login);
		User us = (User)query.getSingleResult();
		return us;
	}

}
