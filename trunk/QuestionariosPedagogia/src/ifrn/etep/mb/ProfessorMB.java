package ifrn.etep.mb;

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
	
	@ManagedProperty("#{serviceTurma}")
	private ServiceTurma serviceTurma;
	public void setServiceTurma(ServiceTurma serviceTurma) {
		this.serviceTurma = serviceTurma;
	}
	
	public boolean responderAutoAvaliacao(){
		return false;
	}

	@PostConstruct
	public void init(){
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		Integer idProfessor = Integer.valueOf(request.getParameter("idProfessor"));
		turmasParaAvaliar = serviceTurma.getTurmasNaoAvaliadasPorProfessor(idProfessor);
	}
	
	public List<TurmaSeriada> getTurmasParaAvaliar(){
		return turmasParaAvaliar;
	}
}
