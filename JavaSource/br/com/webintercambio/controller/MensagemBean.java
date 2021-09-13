package br.com.webintercambio.controller;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.webintercambio.dao.MensagemDAO;
import br.com.webintercambio.model.Mensagem;
import br.com.webintercambio.utils.ContextUtil;

/**
*
* @author João Paulo
*/

@ManagedBean
public class MensagemBean {
	
    private Mensagem mensagem;
	private MensagemDAO mensagemDAO;
	private Mensagem msgSelecionada;
    
    public MensagemBean() {
    	iniciar();
    }
    
	public Mensagem getMensagem() {
		return mensagem;
	}

	public void setMensagem(Mensagem mensagem) {
		this.mensagem = mensagem;
	}
    
	private void iniciar() {
		iniciarModel();
		iniciarDAO();
	}

	private void iniciarModel() {
		this.mensagem = new Mensagem();
		this.msgSelecionada = new Mensagem();
	}

	private void iniciarDAO() {
		this.mensagemDAO = new MensagemDAO(ContextUtil.obterEntityManager());
	}
    
	public Mensagem getMsgSelecionada() {
		return msgSelecionada;
	}

	public void setMsgSelecionada(Mensagem msgSelecionada) {
		this.msgSelecionada = msgSelecionada;
	}
	
	public List<Mensagem> obterMensagens(String loginTo){
		return mensagemDAO.obterMensagens(loginTo);
	}
	
    public String responderMsg(Mensagem msg){
        return "respondeMensagem";
    }
    
    public String finalizaConsulta() {
    	return "home";
    }
    
}
