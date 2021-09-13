package br.com.webintercambio.controller;

import javax.faces.bean.ManagedBean;

import br.com.webintercambio.dao.MensagemDAO;
import br.com.webintercambio.dao.VagasDAO;
import br.com.webintercambio.utils.ContextUtil;

/**
*
* @author João Paulo
*/

@ManagedBean(name = "homeBean")
public class HomeEstudanteBean {

	private int qtdVagas;
    private int qtdMsgs;
    private int qtdMyVagas;
    
	private MensagemDAO mensagemDAO;
	private VagasDAO vagasDAO;
	
    
	public HomeEstudanteBean() {
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
		
		this.mensagemDAO = new MensagemDAO(ContextUtil.obterEntityManager());
		this.vagasDAO = new VagasDAO(ContextUtil.obterEntityManager());
		
	}
	
	public void updateVagas() {
		setQtdVagas(vagasDAO.qtdVagas());
	}
	
	public void updateMensagens(String LoginTo) {
		setQtdMsgs(mensagemDAO.qtdMyMensagens(LoginTo));
	}
    
}
