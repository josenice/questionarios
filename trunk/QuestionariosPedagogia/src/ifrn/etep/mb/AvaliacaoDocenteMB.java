package ifrn.etep.mb;

import ifrn.etep.dominio.Aluno;
import ifrn.etep.dominio.Diario;
import ifrn.etep.dominio.Professor;
import ifrn.etep.dominio.QuestionarioAvaliacaoDocente;
import ifrn.etep.dominio.RespostaAvaliacaoDocente;
import ifrn.etep.dominio.ServiceProfessor;
import ifrn.etep.dominio.ServiceQuestionarioAvaliacaoDocente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;


@ManagedBean
@ViewScoped
public class AvaliacaoDocenteMB implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private QuestionarioAvaliacaoDocente questionario;
	private Professor professorEmAvaliacao;
	private List<RespostaAvaliacaoDocente> respostas = new ArrayList<>();
	@ManagedProperty("#{serviceQuestionarioAvaliacaoDocente}")
	private ServiceQuestionarioAvaliacaoDocente serviceQuestionario;
	@ManagedProperty("#{serviceProfessor}")
	private ServiceProfessor serviceProfessor;
	//Retornar uma lista do grupo de respostas
	private List<GrupoResposta> gruposRespostas = new ArrayList<>();

	public List<GrupoResposta> getGruposRespostas() {
		return gruposRespostas;
	}

	@PostConstruct
	public void init(){
		try{
			HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
			Integer idProfessor = new Integer(request.getParameter("idprofessor"));
			Integer idDiario = new Integer(request.getParameter("idDiario"));
			questionario = serviceQuestionario.getDoBimestreCorrente();
			professorEmAvaliacao = serviceProfessor.getPorId(idProfessor);
			Diario diario = serviceQuestionario.getDiarioPorId(idDiario);
			respostas = questionario.gerarItensResposta(professorEmAvaliacao, diario);
			
			gruposRespostas = GrupoResposta.gerarGruposResposta(respostas);
			
		}catch(Exception ex){
			ex.printStackTrace();
			throw ex;
		}
	}
	
	public void setQuestionario(QuestionarioAvaliacaoDocente questionario) {
		this.questionario = questionario;
	}

	public Professor getprofessorEmAvaliacao() {
		return professorEmAvaliacao;
	}


	public String salvarRespostas(){
		FacesContext ctx = FacesContext.getCurrentInstance();
		try{
			//TODO obter usuário logado
			Aluno usuario = new Aluno();
			usuario.setId(2);
			serviceQuestionario.salvarRespostas(respostas, usuario);
			ctx.addMessage(null, new FacesMessage("Respostas salvas com sucesso", ""));
			return "diretorias";
		}
		catch(Exception ex){
			ctx.addMessage(null, new FacesMessage("Ocorreu um erro", ""));
			ex.printStackTrace();
			return null;
		}
	}

	public List<RespostaAvaliacaoDocente> getRespostas() {
		return respostas;
	}

	public QuestionarioAvaliacaoDocente getQuestionario() {
		return questionario;
	}

	
	public Professor getProfessorEmAvaliacao() {
		return professorEmAvaliacao;
	}

	public void setProfessorEmAvaliacao(Professor professorEmAvaliacao) {
		this.professorEmAvaliacao = professorEmAvaliacao;
	}

	public void setServiceQuestionario(ServiceQuestionarioAvaliacaoDocente serviceQuestionario) {
		this.serviceQuestionario = serviceQuestionario;
	}

	public void setServiceProfessor(ServiceProfessor serviceProfessor) {
		this.serviceProfessor = serviceProfessor;
	}
	
}
