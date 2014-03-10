package ifrn.etep.dominio;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Component
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Transactional(propagation = Propagation.REQUIRED)
public class ServiceQuestionarioAutoAvaliacaoDocente implements Serializable{

	/**
	 * Josenice
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private RepositorioQuestionarioAutoAvaliacaoDocente repositorio;

	public void setRepositorio(RepositorioQuestionarioAutoAvaliacaoDocente repositorio) {
		this.repositorio = repositorio;
	}
	public QuestionarioAutoAvaliacaoDocente getDoBimestreCorrente() {
		return repositorio.getDoBimestreCorrente();
	}
	public QuestionarioAutoAvaliacaoDocente getPorId(Integer idQuestionario){
		return repositorio.getPorId(idQuestionario);
		
	}
	public void cadastrarQuestionario(QuestionarioAutoAvaliacaoDocente questionario){
		this.repositorio.insert(questionario);
		
	}
	public void atualizarQuestionario(QuestionarioAutoAvaliacaoDocente questionario){
		this.repositorio.update(questionario);
	}
	public void excluirQuestionario(Integer questionario){
		this.repositorio.delete(questionario);
	}
	
	public void salvarRespostas(List<RespostaAutoAvaliacaoDocente> respostas, Professor interrogado){
		for(RespostaAutoAvaliacaoDocente r : respostas){
			r.setInterrogado(interrogado);
		}
		repositorio.salvarRespostas(respostas);
	}
	
	public boolean isAutoAvaliacaoRespondida(Integer idUsuario){
		return repositorio.isAutoAvaliacaoRespondida(idUsuario);
	}
}
