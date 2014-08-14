package ifrn.etep.mb;

import ifrn.etep.dominio.GrupoItemAvaliacao;
import ifrn.etep.dominio.Professor;
import ifrn.etep.dominio.QuestionarioAutoAvaliacaoDocente;
import ifrn.etep.dominio.RespostaAutoAvaliacaoDocente;
import ifrn.etep.dominio.ServiceQuestionarioAutoAvaliacaoDocente;
import ifrn.etep.dominio.ServiceUsuario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
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
public class AutoAvaliacaoDocenteMB implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private QuestionarioAutoAvaliacaoDocente questionario;
	
	private Professor usuario;
	//private Usuario usuarioInterrogado; inserir o getProfessor
	
	private List<RespostaAutoAvaliacaoDocente> respostas = new ArrayList<>();
	
	private List<GrupoResposta> gruposRespostas = new ArrayList<>();
	
	@ManagedProperty("#{serviceQuestionarioAutoAvaliacaoDocente}")
	private ServiceQuestionarioAutoAvaliacaoDocente serviceQuestionario;
	
	@ManagedProperty("#{serviceUsuario}")
	private ServiceUsuario serviceUsuario;
	
	public List<GrupoResposta> getGruposRespostas() {
		return gruposRespostas;
	}
	public void setGruposRespostas(List<GrupoResposta> gruposRespostas) {
		this.gruposRespostas = gruposRespostas;
	}
	
	public Professor getUsuario() {
		return usuario;
	}
	public void setUsuario(Professor usuario) {
		this.usuario = usuario;
	}

	public ServiceUsuario getServiceUsuario() {
		return serviceUsuario;
	}
	public void setServiceUsuario(ServiceUsuario serviceUsuario) {
		this.serviceUsuario = serviceUsuario;
	}
	
	@PostConstruct
	public void init(){
		try{
			HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
			Integer idUsuario = new Integer(request.getParameter("idUsuario"));
			questionario = serviceQuestionario.getDoBimestreCorrente();
			//TODO obter o usuário logado
			Professor usuario = new Professor();
			usuario.setId(idUsuario);
			respostas = questionario.gerarItensResposta(usuario);
			
			HashMap<GrupoItemAvaliacao, GrupoResposta> mapaGrupos = new HashMap<>();
			for(RespostaAutoAvaliacaoDocente resposta : respostas){
				GrupoItemAvaliacao grupoItem = resposta.getItem().getGrupo();
				GrupoResposta grupoResposta = mapaGrupos.get(grupoItem);
				if(grupoResposta == null){
					grupoResposta = new GrupoResposta(grupoItem);
					mapaGrupos.put(grupoItem, grupoResposta);
					gruposRespostas.add(grupoResposta);
				}
				grupoResposta.getRespostas().add(resposta);
			}
		}catch(Exception ex){
			ex.printStackTrace();
			throw ex;
		}
	}
	public String salvarRespostas(){
		FacesContext ctx = FacesContext.getCurrentInstance();
		try{
			//TODO obter usuário logado
			Professor usuario = new Professor();
			usuario.setId(1);
			serviceQuestionario.salvarRespostas(respostas, usuario);
			ctx.addMessage(null, new FacesMessage("Respostas salvas com sucesso", ""));
			return "professor";
		}
		catch(Exception ex){
			ctx.addMessage(null, new FacesMessage("Ocorreu um erro", ""));
			ex.printStackTrace();
			return null;
		}
	}

	public QuestionarioAutoAvaliacaoDocente getQuestionario() {
		return questionario;
	}

	public void setQuestionario(QuestionarioAutoAvaliacaoDocente questionario) {
		this.questionario = questionario;
	}

	public List<RespostaAutoAvaliacaoDocente> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<RespostaAutoAvaliacaoDocente> respostas) {
		this.respostas = respostas;
	}

	public ServiceQuestionarioAutoAvaliacaoDocente getServiceQuestionario() {
		return serviceQuestionario;
	}

	public void setServiceQuestionario(
			ServiceQuestionarioAutoAvaliacaoDocente serviceQuestionario) {
		this.serviceQuestionario = serviceQuestionario;
	}
}