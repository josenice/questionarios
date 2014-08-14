package ifrn.etep.mb;

import ifrn.etep.dominio.Professor;
import ifrn.etep.dominio.QuestionarioAvaliacaoTurma;
import ifrn.etep.dominio.RespostaAvaliacaoTurma;
import ifrn.etep.dominio.ServiceQuestionarioAvaliacaoTurma;
import ifrn.etep.dominio.ServiceTurma;
import ifrn.etep.dominio.TurmaSeriada;

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
public class AvaliacaoTurmaMB implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private QuestionarioAvaliacaoTurma questionario;
	private TurmaSeriada turmaEmAvaliacao;
	private List<RespostaAvaliacaoTurma> respostas = new ArrayList<>();
	@ManagedProperty("#{serviceQuestionarioAvaliacaoTurma}")
	private ServiceQuestionarioAvaliacaoTurma serviceQuestionario;
	@ManagedProperty("#{serviceTurma}")
	private ServiceTurma serviceTurma;
	private List<GrupoResposta> gruposRespostas;

	@PostConstruct
	public void init(){
		try{
			HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
			Integer idTurma = new Integer(request.getParameter("idturma"));
			questionario = serviceQuestionario.getDoBimestreCorrente();
			turmaEmAvaliacao = serviceTurma.getPorId(idTurma);
			respostas = questionario.gerarItensResposta(turmaEmAvaliacao);
			
			gruposRespostas = GrupoResposta.gerarGruposResposta(respostas);
		}catch(Exception ex){
			ex.printStackTrace();
			throw ex;
		}
	}
	
	public List<GrupoResposta> getGruposRespostas() {
		return gruposRespostas;
	}
	
	public String salvarRespostas(){
		FacesContext ctx = FacesContext.getCurrentInstance();
		try{
			//TODO obter usuário logado
			Professor usuario = new Professor();
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

	public List<RespostaAvaliacaoTurma> getRespostas() {
		return respostas;
	}

	public QuestionarioAvaliacaoTurma getQuestionario() {
		return questionario;
	}

	public TurmaSeriada getTurmaEmAvaliacao() {
		return turmaEmAvaliacao;
	}

	public void setServiceQuestionario(ServiceQuestionarioAvaliacaoTurma serviceQuestionario) {
		this.serviceQuestionario = serviceQuestionario;
	}

	public void setServiceTurma(ServiceTurma serviceTurma) {
		this.serviceTurma = serviceTurma;
	}
	
	
}
