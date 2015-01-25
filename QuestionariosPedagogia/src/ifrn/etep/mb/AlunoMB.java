package ifrn.etep.mb;

import ifrn.etep.dominio.Professor;
import ifrn.etep.dominio.ServiceProfessor;
import ifrn.etep.dominio.ServiceQuestionarioAutoAvaliacaoDiscente;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
@ManagedBean
@ViewScoped
public class AlunoMB implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private List<Professor> professoresParaAvaliar;
	
	private Integer idAluno;
	@ManagedProperty("#{serviceProfessor}")
	private ServiceProfessor serviceProfessor;
	public void setServiceProfessor (ServiceProfessor serviceProfessor){
		this.serviceProfessor = serviceProfessor;
	}
	
	@ManagedProperty("#{serviceQuestionarioAutoAvaliacao}")
	private ServiceQuestionarioAutoAvaliacaoDiscente serviceAutoAvaliacao;
	public void setServiceAutoAvaliacao(
			ServiceQuestionarioAutoAvaliacaoDiscente serviceAutoAvaliacao) {
		this.serviceAutoAvaliacao = serviceAutoAvaliacao;
	}

	public boolean responderAutoAvaliacao(){
		//return !serviceAutoAvaliacao.isAutoAvaliacaoRespondida(idAluno);
		return false; //TODO
	}

	@PostConstruct
	public void init(){
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		idAluno = Integer.valueOf(request.getParameter("idAluno"));
		professoresParaAvaliar = serviceProfessor.getProfessoresNaoAvaliadoPorAluno(idAluno);
		System.out.println("----->"+professoresParaAvaliar);
	}
	
	public List<Professor> getProfessorParaAvaliar(){
		return professoresParaAvaliar;
	}
	

}
