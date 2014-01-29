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
public class ServiceQuestionarioAutoAvaliacao implements Serializable{

	/**
	 * Josenice
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private RepositorioQuestionarioAutoAvaliacao repositorio;

	public RepositorioQuestionarioAutoAvaliacao getRepositorio() {
		return repositorio;
	}

	public void setRepositorio(RepositorioQuestionarioAutoAvaliacao repositorio) {
		this.repositorio = repositorio;
	}
	public QuestionarioDeAutoAvaliacao getDoSemestreCorrente() {
		return repositorio.getDoSemestreCorrente();
	}
	public QuestionarioDeAutoAvaliacao getPorId(Integer idQuestionario){
		return repositorio.getPorId(idQuestionario);
		
	}
	public void cadastrarQuestionario(QuestionarioDeAutoAvaliacao questionario){
		this.repositorio.insert(questionario);
		
	}
	public void atualizarQuestionario(QuestionarioDeAutoAvaliacao questionario){
		this.repositorio.update(questionario);
	}
	public void excluirQuestionario(Integer questionario){
		this.repositorio.delete(questionario);
	}
	
	public void salvarRespostas(List<RespostaUsuarioAutoAvaliacao> respostas, Usuario interrogado){
		for(RespostaUsuarioAutoAvaliacao r : respostas){
			r.setInterrogador(interrogado);
		}
		repositorio.salvarRespostas(respostas);
	}
	

}
