package br.com.webintercambio.controller;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import br.com.webintercambio.dao.MensagemDAO;
import br.com.webintercambio.dao.UserDAO;
import br.com.webintercambio.model.Mensagem;
import br.com.webintercambio.utils.ContextUtil;

/**
*
* @author João Paulo
*/

@ManagedBean
public class ConsultaMensagensBean {

	private MensagemDAO mensagemDAO;
	private Mensagem msgSelecionada;
	private Mensagem respMsgSelecionada;
	private UserDAO userDao;
	
	private int idVaga;
	private String loginFrom;
	private String loginTo;
	private String assunto;

	public ConsultaMensagensBean() {
		this.mensagemDAO = new MensagemDAO(ContextUtil.obterEntityManager());
		this.userDao = new UserDAO(ContextUtil.obterEntityManager());
		this.respMsgSelecionada = new Mensagem();
	}

	public Mensagem getMsgSelecionada() {
		return msgSelecionada;
	}

	public void setMsgSelecionada(Mensagem msgSelecionada) {
		this.msgSelecionada = msgSelecionada;
	}

	public List<Mensagem> obterListaMensagens(String login) {
		return mensagemDAO.obterMensagens(login);
	}
	
	public Mensagem getRespMsgSelecionada() {
		return respMsgSelecionada;
	}

	public void setRespMsgSelecionada(Mensagem respMsgSelecionada) {
		this.respMsgSelecionada = respMsgSelecionada;
	}
	
	public String responderMsg() {
		
		setIdVaga(msgSelecionada.getIdVaga());
		setLoginFrom(msgSelecionada.getLoginFrom());
		setLoginTo(msgSelecionada.getLoginTo());
		setAssunto(msgSelecionada.getAssunto());
		
		
		this.respMsgSelecionada.setIdMensagem(msgSelecionada.getIdMensagem());
		this.respMsgSelecionada.setIdVaga(msgSelecionada.getIdVaga());
		this.respMsgSelecionada.setLoginFrom(msgSelecionada.getLoginTo());
		this.respMsgSelecionada.setLoginTo(msgSelecionada.getLoginFrom());
		this.respMsgSelecionada.setAssunto("RE: " + msgSelecionada.getAssunto());
		this.respMsgSelecionada.setCorpoMensagem("\n\n _ _ _ _ _ _ _ _ _ _ \n\n" + msgSelecionada.getCorpoMensagem());
		this.respMsgSelecionada.setMsg_naolida(true);
		
		return "respondeMensagem";
	}
	
	public String enviarResposta() {
		
		this.respMsgSelecionada.setIdVaga(getIdVaga());
		this.respMsgSelecionada.setLoginFrom(getLoginTo());
		this.respMsgSelecionada.setLoginTo(getLoginFrom());
		this.respMsgSelecionada.setAssunto("RE: " + getAssunto());
		
		
		if(mensagemDAO.criarMensagem(respMsgSelecionada)) {
			ContextUtil.addMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "Mensagem Enviada.");
			return "mensagens";
		}
		
		ContextUtil.addMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Mensagem Não Enviada.");
		return "respondeMensagem";
	}
	
	public String voltarRespondeMensagens() {
		return "mensagens";
	}	
	
	public String finalizaConsulta(String login) {
		
		String job = userDao.obterJobByUser(login);
		
		if (job.equals("Agencia")) {
			return "agencia";
		} else if (job.equals("Estudante")) {
			return "home";
		}
		
		return "mensagens"; //alterar rota de acordo com o perfil do usuario
	}

	public int getIdVaga() {
		return idVaga;
	}

	public void setIdVaga(int idVaga) {
		this.idVaga = idVaga;
	}

	public String getLoginFrom() {
		return loginFrom;
	}

	public void setLoginFrom(String loginFrom) {
		this.loginFrom = loginFrom;
	}

	public String getLoginTo() {
		return loginTo;
	}

	public void setLoginTo(String loginTo) {
		this.loginTo = loginTo;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}
}
