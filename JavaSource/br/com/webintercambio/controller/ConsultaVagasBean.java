package br.com.webintercambio.controller;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;

import br.com.webintercambio.dao.AgenciaDAO;
import br.com.webintercambio.dao.MensagemDAO;
import br.com.webintercambio.dao.VagasDAO;
import br.com.webintercambio.model.Agencia;
import br.com.webintercambio.model.Mensagem;
import br.com.webintercambio.model.Vaga;
import br.com.webintercambio.utils.ContextUtil;

/**
*
* @author João Paulo
*/

@ManagedBean
public class ConsultaVagasBean {
	
	private AgenciaDAO agenciaDAO;
	private VagasDAO vagasDAO;
	private MensagemDAO mensagemDAO;
	private Vaga vagaSelecionada;
	private List<Vaga> listaVagas = new ArrayList<Vaga>();
	
	public ConsultaVagasBean() {
		this.vagasDAO = new VagasDAO(ContextUtil.obterEntityManager());
		this.agenciaDAO = new AgenciaDAO(ContextUtil.obterEntityManager());
		this.mensagemDAO = new MensagemDAO(ContextUtil.obterEntityManager());
		setVagaSelecionada(new Vaga());
		setListaVagas(vagasDAO.listarVagas());
	}

	public Vaga getVagaSelecionada() {
		return vagaSelecionada;
	}

	public List<Vaga> getListaVagas() {
		return listaVagas;
	}

	public void setListaVagas(List<Vaga> listaVagas) {
		this.listaVagas = listaVagas;
	}
	
	public void setVagaSelecionada(Vaga vagaSelecionada) {
		this.vagaSelecionada = vagaSelecionada;
	}
	
	public String candidatarVaga(String user) {

		Mensagem msg = new Mensagem();
		Agencia ag = agenciaDAO.obterAgenciaByID(vagaSelecionada.getIdAgencia());

		msg.setIdVaga(vagaSelecionada.getIdVaga());
		msg.setLoginFrom(user);
		msg.setLoginTo(ag.getLogin());
		msg.setAssunto("Candidatura Vaga:" + vagaSelecionada.getIdVaga());
		msg.setCorpoMensagem("Me candidato a vaga: " + vagaSelecionada.getIdVaga());
		msg.setMsg_naolida(false);

		if (mensagemDAO.criarMensagem(msg)) {
			ContextUtil.addMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "A mensagem foi enviada.");
			return voltarVaga();
		}

		ContextUtil.addMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "A mensagem não foi enviada.");

		return visualizaVaga();
	}

	public String voltarVaga() {
		return "vagas";
	}

	public String finalizaConsulta() {
		return "home";
	}

	public String visualizaVaga() {
		return "visualizaVaga";
	}
	
}
