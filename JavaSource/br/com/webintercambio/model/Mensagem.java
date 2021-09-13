package br.com.webintercambio.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author João Paulo
 */

@Entity(name = "Mensagens")
public class Mensagem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6635191510750854135L;
	@Id
	@GeneratedValue
	private int idMensagem;
	private int idVaga;
	private String loginFrom;
	private String loginTo;
	private String assunto;
	private String corpoMensagem;
	private boolean msg_naolida;

	public int getIdMensagem() {
		return idMensagem;
	}

	public void setIdMensagem(int idMensagem) {
		this.idMensagem = idMensagem;
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

	public String getCorpoMensagem() {
		return corpoMensagem;
	}

	public void setCorpoMensagem(String corpoMensagem) {
		this.corpoMensagem = corpoMensagem;
	}

	public boolean isMsg_naolida() {
		return msg_naolida;
	}

	public void setMsg_naolida(boolean msg_naolida) {
		this.msg_naolida = msg_naolida;
	}
}
