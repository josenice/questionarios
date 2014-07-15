package ifrn.etep.mb;

import ifrn.etep.dominio.Aluno;
import ifrn.etep.dominio.Professor;
import ifrn.etep.dominio.QuestionarioAvaliacaoDocente;
import ifrn.etep.dominio.RespostaAvaliacaoDocente;
import ifrn.etep.dominio.ServiceProfessor;
import ifrn.etep.dominio.ServiceQuestionarioAvalicaoDocente;

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
	private Professor professorEmAvalicao;
	private List<RespostaAvaliacaoDocente> respostas = new ArrayList<>();
	@ManagedProperty("#{serviceQuestionarioAvalicaoDocente}")
	private ServiceQuestionarioAvalicaoDocente serviceQuestionario;
	@ManagedProperty("#{serviceProfessor}")
	private ServiceProfessor serviceProfessor;

	@PostConstruct
	public void init(){
		try{
			HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
			Integer idProfessor = new Integer(request.getParameter("idprofessor"));
			questionario = serviceQuestionario.getDoBimestreCorrente();
			professorEmAvalicao = serviceProfessor.getPorId(idProfessor);
			respostas = questionario.gerarItensResposta(professorEmAvalicao);
		}catch(Exception ex){
			ex.printStackTrace();
			throw ex;
		}
	}
	
	public void setQuestionario(QuestionarioAvaliacaoDocente questionario) {
		this.questionario = questionario;
	}

	public Professor getProfessorEmAvalicao() {
		return professorEmAvalicao;
	}


	public String salvarRespostas(){
		FacesContext ctx = FacesContext.getCurrentInstance();
		try{
			//TODO obter usuário logado
			Aluno usuario = new Aluno();
			usuario.setId(1);
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

	public Professor getprofessorEmAvalicao() {
		return professorEmAvalicao;
	}

	public void setServiceQuestionario(ServiceQuestionarioAvalicaoDocente serviceQuestionario) {
		this.serviceQuestionario = serviceQuestionario;
	}

	public void setServiceProfessor(ServiceProfessor serviceProfessor) {
		this.serviceProfessor = serviceProfessor;
	}
	
	
}
