package br.com.webintercambio.controller;

import javax.faces.bean.ManagedBean;

import br.com.webintercambio.dao.AgenciaDAO;
import br.com.webintercambio.dao.MensagemDAO;
import br.com.webintercambio.dao.VagasDAO;
import br.com.webintercambio.utils.ContextUtil;

/**
*
* @author João Paulo
*/

@ManagedBean(name = "homeAgenciaBean")
public class HomeAgenciaBean {

	private int qtdVagas;
    private int qtdMsgs;
    private int qtdMyVagas;
    
	private AgenciaDAO agenciaDAO;
	private MensagemDAO mensagemDAO;
	private VagasDAO vagasDAO;
    
	public HomeAgenciaBean() {
		iniciar();
	}
	
	public int getQtdVagas() {
		return qtdVagas;
	}
	public void setQtdVagas(int qtdVagas) {
		this.qtdVagas = qtdVagas;
	}
	public int getQtdMsgs() {
		return qtdMsgs;
	}
	public void setQtdMsgs(int qtdMsgs) {
		this.qtdMsgs = qtdMsgs;
	}
	public int getQtdMyVagas() {
		return qtdMyVagas;
	}
	public void setQtdMyVagas(int qtdMyVagas) {
		this.qtdMyVagas = qtdMyVagas;
	}
	
	private void iniciar() {
		this.qtdVagas = 0;
		this.qtdMyVagas = 0;
		this.qtdMsgs = 0;

		this.agenciaDAO = new AgenciaDAO(ContextUtil.obterEntityManager());
		this.mensagemDAO = new MensagemDAO(ContextUtil.obterEntityManager());
		this.vagasDAO = new VagasDAO(ContextUtil.obterEntityManager());
	}
	
	public String cadastrarVagas() {
		return "cadastroVagas";
	}
	
	public void updateVagas() {
		setQtdVagas(vagasDAO.qtdVagas());
	}
	
	public void updateMensagens(String LoginTo) {
		setQtdMsgs(mensagemDAO.qtdMyMensagens(LoginTo));
	}
	
	public void updateMyVagas(String login) {
		setQtdMyVagas(vagasDAO.qtdMyVagas(agenciaDAO.obterIdByUser(login)));
	}
    
}
