package br.com.webintercambio.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author João Paulo
 */

@Entity(name = "Usuarios")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1011571449544664969L;
	@Id
	@Column(name = "login", nullable = false)
	private String login;
	@Column(name = "senha", nullable = false)
	private String senha;
	@Column(name = "job", nullable = false)
	private String job;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
}
