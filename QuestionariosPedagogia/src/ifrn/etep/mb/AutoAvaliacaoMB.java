package ifrn.etep.mb;

import ifrn.etep.dominio.QuestionarioDeAutoAvaliacao;
import ifrn.etep.dominio.RespostaUsuarioAutoAvaliacao;
import ifrn.etep.dominio.ServiceQuestionarioAutoAvaliacao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
@ManagedBean
@ViewScoped
public class AutoAvaliacaoMB implements Serializable{
	
	/**
	 * Josenice
	 */
	
	private static final long serialVersionUID = 1L;
	
	private QuestionarioDeAutoAvaliacao questionario;
	
	private List<RespostaUsuarioAutoAvaliacao> respostas = new ArrayList<>();
	
	private ServiceQuestionarioAutoAvaliacao serviceQuestionario;

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
	
	
	

}
