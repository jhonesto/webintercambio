package br.com.webintercambio.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;

import br.com.webintercambio.dao.EstudanteDAO;
import br.com.webintercambio.dao.UserDAO;
import br.com.webintercambio.model.Estudante;
import br.com.webintercambio.model.User;
import br.com.webintercambio.utils.ContextUtil;
import br.com.webintercambio.utils.HashUtil;

/**
*
* @author João Paulo
*/

@ManagedBean
public class EstudanteBean {

	private Estudante estudante;
	
	private UserDAO userDao;
	private EstudanteDAO estudanteDAO;
	
	private EntityManager manager;
	
	public EstudanteBean() {
		iniciar();
	}

	public Estudante getEstudante() {
		return estudante;
	}

	public void setEstudante(Estudante estudante) {
		this.estudante = estudante;
	}
	
	public String cadastrarEstudante() {

		User us = new User();
		us.setLogin(estudante.getLogin());
		us.setSenha(HashUtil.gerarHash(estudante.getSenha()));
		us.setJob("Estudante");
		
		if (userDao.cadastrarUser(us)) {
			if (estudanteDAO.cadastrarEstudante(getEstudante())) {
				ContextUtil.addMessage(FacesMessage.SEVERITY_INFO, "Usuário Cadastrado.", null);
				return "index";
			}
		}

		ContextUtil.addMessage(FacesMessage.SEVERITY_ERROR, "Erro no Cadastro.", null);
		return "index";
	}
	
	private void iniciar() {
		iniciarModel();
		iniciarManager();
		iniciarDAO();
	}
	
	private void iniciarDAO() {
		this.userDao = new UserDAO(manager);
		this.estudanteDAO = new EstudanteDAO(manager);
	}

	private void iniciarManager() {
		this.manager = ContextUtil.obterEntityManager();
	}

	private void iniciarModel() {
		this.estudante = new Estudante();
	}
	
}
