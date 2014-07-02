package ifrn.etep.mb;

import ifrn.etep.dominio.Aluno;
import ifrn.etep.dominio.GrupoItemAvaliacao;
import ifrn.etep.dominio.Professor;
import ifrn.etep.dominio.QuestionarioAutoAvaliacaoDiscente;
import ifrn.etep.dominio.QuestionarioAutoAvaliacaoDocente;
import ifrn.etep.dominio.RespostaAutoAvaliacaoDiscente;
import ifrn.etep.dominio.RespostaAutoAvaliacaoDocente;
import ifrn.etep.dominio.ServiceQuestionarioAutoAvaliacaoDiscente;
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
public class AutoAvaliacaoDiscenteMB implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private QuestionarioAutoAvaliacaoDiscente questionario;
	
	private Aluno usuario;
	//private Usuario usuarioInterrogado; 
	
	private List<RespostaAutoAvaliacaoDiscente> respostas = new ArrayList<>();
	
	private List<GrupoResposta> gruposRespostas = new ArrayList<>();
	
	@ManagedProperty("#{serviceQuestionarioAutoAvaliacaoDiscente}")
	private ServiceQuestionarioAutoAvaliacaoDiscente serviceQuestionario;
	
	@ManagedProperty("#{serviceUsuario}")
	private ServiceUsuario serviceUsuario;
	
	public List<GrupoResposta> getGruposRespostas() {
		return gruposRespostas;
	}
	public void setGruposRespostas(List<GrupoResposta> gruposRespostas) {
		this.gruposRespostas = gruposRespostas;
	}
	
	public Aluno getUsuario() {
		return usuario;
	}
	public void setUsuario(Aluno usuario) {
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
			Aluno usuario = new Aluno();
			usuario.setId(idUsuario);
			respostas = questionario.gerarItensResposta(usuario);
			
			HashMap<GrupoItemAvaliacao, GrupoResposta> mapaGrupos = new HashMap<>();
			for(RespostaAutoAvaliacaoDiscente resposta : respostas){
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
			Aluno usuario = new Aluno();
			usuario.setId(2);
			serviceQuestionario.salvarRespostas(respostas, usuario);
			ctx.addMessage(null, new FacesMessage("Respostas salvas com sucesso", ""));
			return "aluno";
		}
		catch(Exception ex){
			ctx.addMessage(null, new FacesMessage("Ocorreu um erro", ""));
			ex.printStackTrace();
			return null;
		}
	}

	public QuestionarioAutoAvaliacaoDiscente getQuestionario() {
		return questionario;
	}

	public void setQuestionario(QuestionarioAutoAvaliacaoDiscente questionario) {
		this.questionario = questionario;
	}

	public List<RespostaAutoAvaliacaoDiscente> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<RespostaAutoAvaliacaoDiscente> respostas) {
		this.respostas = respostas;
	}

	public ServiceQuestionarioAutoAvaliacaoDiscente getServiceQuestionario() {
		return serviceQuestionario;
	}

	public void setServiceQuestionario(
			ServiceQuestionarioAutoAvaliacaoDiscente serviceQuestionario) {
		this.serviceQuestionario = serviceQuestionario;
	}
	
	public class GrupoResposta implements Serializable{
	
		private static final long serialVersionUID = 1L;
		private List<RespostaAutoAvaliacaoDiscente> respostas = new ArrayList<>();
		private GrupoItemAvaliacao grupo;
		
		public GrupoResposta(GrupoItemAvaliacao grupo) {
			this.grupo = grupo;
		}

		public GrupoItemAvaliacao getGrupoItemAvaliacao() {
			return grupo;  
		}

		public List<RespostaAutoAvaliacaoDiscente> getRespostas() {
			return respostas;
		}
		/*public class Editor implements Serializable{
			
			private static final long serialVersionUID = 1L;
			private String value;
			public String getValue() {
				return value;
			}
			public void setValue(String value) {
				this.value = value;
			}
			
		}*/
	}
}