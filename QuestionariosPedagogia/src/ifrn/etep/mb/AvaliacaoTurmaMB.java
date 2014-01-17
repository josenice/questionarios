package ifrn.etep.mb;

import ifrn.etep.dominio.QuestionarioAvaliacaoDeTurma;
import ifrn.etep.dominio.RespostaUsuarioDaTurma;
import ifrn.etep.dominio.ServiceQuestionarioAvalicaoDeTurma;
import ifrn.etep.dominio.ServiceTurma;
import ifrn.etep.dominio.TurmaSeriada;
import ifrn.etep.dominio.Usuario;

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
	
	private QuestionarioAvaliacaoDeTurma questionario;
	private TurmaSeriada turmaEmAvalicao;
	private List<RespostaUsuarioDaTurma> respostas = new ArrayList<>();
	@ManagedProperty("#{serviceQuestionarioAvalicaoDeTurma}")
	private ServiceQuestionarioAvalicaoDeTurma serviceQuestionario;
	@ManagedProperty("#{serviceTurma}")
	private ServiceTurma serviceTurma;

	@PostConstruct
	public void init(){
		try{
			HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
			Integer idTurma = new Integer(request.getParameter("idturma"));
			questionario = serviceQuestionario.getDoSemestreCorrente();
			turmaEmAvalicao = serviceTurma.getPorId(idTurma);
			respostas = questionario.gerarItensResposta(turmaEmAvalicao);
		}catch(Exception ex){
			ex.printStackTrace();
			throw ex;
		}
	}
	
	public String salvarRespostas(){
		FacesContext ctx = FacesContext.getCurrentInstance();
		try{
			//TODO obter usuário logado
			Usuario usuario = new Usuario();
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

	public List<RespostaUsuarioDaTurma> getRespostas() {
		return respostas;
	}

	public QuestionarioAvaliacaoDeTurma getQuestionario() {
		return questionario;
	}

	public TurmaSeriada getTurmaEmAvalicao() {
		return turmaEmAvalicao;
	}

	public void setServiceQuestionario(ServiceQuestionarioAvalicaoDeTurma serviceQuestionario) {
		this.serviceQuestionario = serviceQuestionario;
	}

	public void setServiceTurma(ServiceTurma serviceTurma) {
		this.serviceTurma = serviceTurma;
	}
	
	
}
