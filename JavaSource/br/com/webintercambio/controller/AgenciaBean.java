package br.com.webintercambio.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import br.com.webintercambio.dao.AgenciaDAO;
import br.com.webintercambio.dao.UserDAO;
import br.com.webintercambio.model.Agencia;
import br.com.webintercambio.model.User;
import br.com.webintercambio.utils.ContextUtil;
import br.com.webintercambio.utils.HashUtil;

/**
*
* @author João Paulo
*/

@ManagedBean
public class AgenciaBean {

	private Agencia agencia;

	private UserDAO userDao;
	private AgenciaDAO agenciaDAO;
	

	public AgenciaBean() {
		iniciar();
	}

	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	public String cadastrarAgencia() {

		User us = new User();
		us.setLogin(agencia.getLogin());
		us.setSenha(HashUtil.gerarHash(agencia.getSenha()));
		us.setJob("Agencia");

		if (userDao.cadastrarUser(us)) {
			getAgencia().setLogin(us.getLogin());
			if (agenciaDAO.cadastrarAgencia(getAgencia())) {
				ContextUtil.addMessage(FacesMessage.SEVERITY_INFO, "Usuário Cadastrado.", null);
				return "index";
			}
		}

		ContextUtil.addMessage(FacesMessage.SEVERITY_ERROR, "Erro no Cadastro.", null);
		return "index";
	}
	
	private void iniciar() {
		iniciarModel();
		iniciarDAO();
	}

	private void iniciarDAO() {
		this.userDao = new UserDAO(ContextUtil.obterEntityManager());
		this.agenciaDAO = new AgenciaDAO(ContextUtil.obterEntityManager());
	}

	private void iniciarModel() {
		this.agencia = new Agencia();
	}

}
