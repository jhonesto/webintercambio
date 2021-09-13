package br.com.webintercambio.controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import br.com.webintercambio.dao.AgenciaDAO;
import br.com.webintercambio.dao.VagasDAO;
import br.com.webintercambio.model.Vaga;
import br.com.webintercambio.utils.ContextUtil;

/**
*
* @author João Paulo
*/

@ManagedBean
public class CadastroVagasBean {

	private AgenciaDAO agenciaDAO;
	private VagasDAO vagasDAO;
	private Vaga vaga;

	public CadastroVagasBean() {
		iniciar();
	}

	public Vaga getVaga() {
		return vaga;
	}

	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}

	private void iniciar() {
		this.vaga = new Vaga();
		this.vagasDAO = new VagasDAO(ContextUtil.obterEntityManager());
		this.agenciaDAO = new AgenciaDAO(ContextUtil.obterEntityManager());
	}

	public String voltar() {
		return "agencia";
	}

	public String cadastrarVaga(String user) {
		
		// obter id da agencia e setar o id
		getVaga().setIdAgencia(agenciaDAO.obterIdByUser(user));

		if (vagasDAO.cadastrarVaga(getVaga())) {
			ContextUtil.addMessage(FacesMessage.SEVERITY_INFO, "Vaga Cadastrada!",
					"Vaga: " + getVaga().getTituloVaga());
			return "agencia";
		}
		
		ContextUtil.addMessage(FacesMessage.SEVERITY_INFO, "Vaga Não Cadastrada!",
				"Vaga: " + getVaga().getTituloVaga());
		return "cadastroVagas";
	}

}
