package br.com.webintercambio.dao;

import javax.persistence.EntityManager;

import br.com.webintercambio.model.User;
import br.com.webintercambio.utils.HashUtil;

/**
*
* @author João Paulo
*/

public class LoginDAO {
	
	@SuppressWarnings("unused")
	private EntityManager manager;
	private UserDAO userDAO;
	private User user;
	
	public LoginDAO( EntityManager manager) {
		this.manager = manager;
		this.userDAO = new UserDAO(manager);
	}

	public boolean validar(String login, String pass) {
		
		try {
			user = userDAO.obterUserByLogin(login);
			// tratar hash
			return user.getLogin().equalsIgnoreCase(login) 
					&& HashUtil.gerarHash(pass).equalsIgnoreCase(user.getSenha());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public String obterJob(String login) {
		return userDAO.obterJobByUser(login);
	}
	
}
