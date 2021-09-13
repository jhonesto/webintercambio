package br.com.webintercambio.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import br.com.webintercambio.dao.LoginDAO;
import br.com.webintercambio.model.User;
import br.com.webintercambio.utils.ContextUtil;

/**
*
* @author João Paulo
*/

@ManagedBean
public class AcessoBean {

	private User user;
	
	public AcessoBean() {
		iniciar();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String autentica() {

		LoginDAO login = new LoginDAO(ContextUtil.obterEntityManager());

		if (login.validar(user.getLogin(), user.getSenha())) {

			ContextUtil.createSessionAttribute("usuario", user.getLogin());
			ContextUtil.addMessage(FacesMessage.SEVERITY_INFO, "Bem Vindo!", "Login: " + user.getLogin());
			
			if (login.obterJob(user.getLogin()).equals("Agencia")) {
				return "agencia";
			} else if (login.obterJob(user.getLogin()).equals("Estudante")) {
				return "home";
			}
		}

		// exceção
		removeUser();
		ContextUtil.addMessage(FacesMessage.SEVERITY_ERROR, "Erro", "Usuário ou Senha inválidos.");
		return "index";
	}
	
	public String registraSaida() {
		removeUser();
		return "index";
	}

	public String registraLogoff() {
		removeUser();
		return "login";
	}

	public String visualizaNews() {
		removeUser();
		return "noticias";
	}

	public String visualizaSobre() {
		removeUser();
		return "sobre";
	}
	
	private void iniciar() {
		setUser(new User());
		removeUser();
	}
	
	private void removeUser() {
		ContextUtil.removeSessionAttribute("usuario");
	}

}
