package ifrn.etep.mb;

import ifrn.etep.dominio.GrupoItemAvaliacao;
import ifrn.etep.dominio.QuestionarioDeAutoAvaliacao;
import ifrn.etep.dominio.RespostaUsuarioAutoAvaliacao;
import ifrn.etep.dominio.ServiceQuestionarioAutoAvaliacao;
import ifrn.etep.dominio.ServiceUsuario;
import ifrn.etep.dominio.Usuario;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
@ManagedBean
@ViewScoped
public class AutoAvaliacaoMB implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private QuestionarioDeAutoAvaliacao questionario;
	
	//private Usuario usuarioInterrogado;
	
	private List<RespostaUsuarioAutoAvaliacao> respostas = new ArrayList<>();
	
	private List<GrupoResposta> gruposRespostas = new ArrayList<>();
	
	@ManagedProperty("#{serviceQuestionarioAutoAvaliacao}")
	private ServiceQuestionarioAutoAvaliacao serviceQuestionario;
	
	@ManagedProperty("#{serviceUsuario}")
	private ServiceUsuario serviceUsuario;
	
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
			//TODOobter o usuário logado
			Usuario usuario = new Usuario();
			usuario.setId(idUsuario);
			respostas = questionario.gerarItensResposta(usuario);
			
			HashMap<GrupoItemAvaliacao, GrupoResposta> mapaGrupos = new HashMap<>();
			for(RespostaUsuarioAutoAvaliacao resposta : respostas){
				GrupoItemAvaliacao grupoItem = resposta.getItemAvaliacao().getGrupo();
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
			Usuario usuario = new Usuario();
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

	public QuestionarioDeAutoAvaliacao getQuestionario() {
		return questionario;
	}

	public void setQuestionario(QuestionarioDeAutoAvaliacao questionario) {
		this.questionario = questionario;
	}

	public List<RespostaUsuarioAutoAvaliacao> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<RespostaUsuarioAutoAvaliacao> respostas) {
		this.respostas = respostas;
	}

	public ServiceQuestionarioAutoAvaliacao getServiceQuestionario() {
		return serviceQuestionario;
	}

	public void setServiceQuestionario(
			ServiceQuestionarioAutoAvaliacao serviceQuestionario) {
		this.serviceQuestionario = serviceQuestionario;
	}
	
	public List<GrupoResposta> getGrupos(){
		return gruposRespostas;
	}
	
	public class GrupoResposta implements Serializable{
		private List<RespostaUsuarioAutoAvaliacao> respostas = new ArrayList<>();
		private GrupoItemAvaliacao grupo;
		
		public GrupoResposta(GrupoItemAvaliacao grupo) {
			this.grupo = grupo;
		}

		public GrupoItemAvaliacao getGrupoItemAvaliacao() {
			return grupo;
		}

		public List<RespostaUsuarioAutoAvaliacao> getRespostas() {
			return respostas;
		}
	}
}