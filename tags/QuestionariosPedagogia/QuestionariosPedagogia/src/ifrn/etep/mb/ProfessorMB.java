package ifrn.etep.mb;

import ifrn.etep.dominio.ServiceQuestionarioAutoAvaliacao;
import ifrn.etep.dominio.ServiceTurma;
import ifrn.etep.dominio.TurmaSeriada;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;


@ManagedBean
@ViewScoped
public class ProfessorMB implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<TurmaSeriada> turmasParaAvaliar;
	private Integer idProfessor;
	
	@ManagedProperty("#{serviceTurma}")
	private ServiceTurma serviceTurma;
	public void setServiceTurma(ServiceTurma serviceTurma) {
		this.serviceTurma = serviceTurma;
	}
	
	@ManagedProperty("#{serviceQuestionarioAutoAvaliacao}")
	private ServiceQuestionarioAutoAvaliacao serviceAutoAvaliacao;
	public void setServiceAutoAvaliacao(
			ServiceQuestionarioAutoAvaliacao serviceAutoAvaliacao) {
		this.serviceAutoAvaliacao = serviceAutoAvaliacao;
	}

	public boolean responderAutoAvaliacao(){
		return !serviceAutoAvaliacao.isAutoAvaliacaoRespondida(idProfessor);
	}

	@PostConstruct
	public void init(){
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		idProfessor = Integer.valueOf(request.getParameter("idProfessor"));
		turmasParaAvaliar = serviceTurma.getTurmasNaoAvaliadasPorProfessor(idProfessor);
	}
	
	public List<TurmaSeriada> getTurmasParaAvaliar(){
		return turmasParaAvaliar;
	}
}
