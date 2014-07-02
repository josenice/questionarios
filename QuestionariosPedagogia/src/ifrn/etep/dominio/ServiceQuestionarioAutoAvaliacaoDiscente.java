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
public class ServiceQuestionarioAutoAvaliacaoDiscente implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private RepositorioQuestionarioAutoAvaliacaoDiscente repositorio;

	public void setRepositorio(RepositorioQuestionarioAutoAvaliacaoDiscente repositorio) {
		this.repositorio = repositorio;
	}
	public QuestionarioAutoAvaliacaoDiscente getDoBimestreCorrente() {
		return repositorio.getDoBimestreCorrente();
	}
	public RepositorioQuestionarioAutoAvaliacaoDiscente getRepositorio() {
		return repositorio;
	}
	public QuestionarioAutoAvaliacaoDiscente getPorId(Integer idQuestionario){
		return repositorio.getPorId(idQuestionario);
		
	}
	public void cadastrarQuestionario(QuestionarioAutoAvaliacaoDiscente questionario){
		this.repositorio.insert(questionario);
		
	}
	public void atualizarQuestionario(QuestionarioAutoAvaliacaoDiscente questionario){
		this.repositorio.update(questionario);
	}
	public void excluirQuestionario(Integer questionario){
		this.repositorio.delete(questionario);
	}
	
	public void salvarRespostas(List<RespostaAutoAvaliacaoDiscente> respostas, Aluno interrogado){
		for(RespostaAutoAvaliacaoDiscente r : respostas){
			r.setInterrogado(interrogado);
		}
		repositorio.salvarRespostas(respostas);
	}
	
	public boolean isAutoAvaliacaoRespondida(Integer idUsuario){
		return repositorio.isAutoAvaliacaoRespondida(idUsuario);
	}

}
