package br.com.webintercambio.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 *
 * @author João Paulo
 */

@Entity(name = "Agencias")
public class Agencia implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1756382696324714197L;
	@Id
	@GeneratedValue
	@Column(name = "idAgencia")
	private int idAgencia;
	@Column(name = "NomeAgencia")
	private String nome;
	@Column(name = "NomeRespAgencia")
	private String nomeResponsavel;
	@Column(name = "SobrenomeRespAgencia")
	private String sobrenome;
	@Column(name = "SexoRespAgencia")
	private String sexo;
	@Column(name = "EnderecoAgencia")
	private String endereco;
	@Column(name = "BairroAgencia")
	private String bairro;
	@Column(name = "CidadeAgencia")
	private String cidade;
	@Column(name = "Estado")
	private String estado;
	@Column(name = "CEP")
	private String cep;
	@Column(name = "Telefone")
	private String telefone;
	@Column(name = "Ramal")
	private String ramal;
	@Column(name = "Fax")
	private String fax;
	@Column(name = "Pais")
	private String pais;
	@Column(name = "login")
	private String login;
	@Transient
	private String senha;

	public int getIdAgencia() {
		return idAgencia;
	}

	public void setIdAgencia(int idAgencia) {
		this.idAgencia = idAgencia;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeResponsavel() {
		return nomeResponsavel;
	}

	public void setNomeResponsavel(String nomeResponsavel) {
		this.nomeResponsavel = nomeResponsavel;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getRamal() {
		return ramal;
	}

	public void setRamal(String ramal) {
		this.ramal = ramal;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

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
}
