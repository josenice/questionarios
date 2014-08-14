package ifrn.etep.dominio;

import ifrn.etep.dao.DAOBimesteLetivo;

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
public class ServiceQuestionarioAvaliacaoTurma implements Serializable {

	/**
	 * Maria Josenice Severino de Pinho
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private RepositorioQuestionarioAvaliacaoTurma repositorio;
	
	@Autowired
	private DAOBimesteLetivo daoBimestre;

	public void setRepositorio(															
			RepositorioQuestionarioAvaliacaoTurma repositorio) {
		this.repositorio = repositorio;
	}
	
	public QuestionarioAvaliacaoTurma getDoBimestreCorrente(){
		return repositorio.getDoBimestreCorente();
	}

	public QuestionarioAvaliacaoTurma getPorId(Integer idQuestionario) {
		return repositorio.getPorId(idQuestionario);
	}

	public void cadastrarQuestionario(QuestionarioAvaliacaoTurma questionario) {
		this.repositorio.insert(questionario);
	}

	public void atualizarQuestionario(QuestionarioAvaliacaoTurma questionario) {
		this.repositorio.update(questionario);
	}

	public void excluirQuestionario(Integer questionario) {
		this.repositorio.delete(questionario);
	}


	public void salvarRespostas(List<RespostaAvaliacaoTurma> respostas, Professor interrogado) {
		//TODO usar Professor ao invés de usuário
		BimestreLetivo bimestreCorrente = daoBimestre.getBimestreCorrente();
		for(RespostaAvaliacaoTurma r : respostas){
			r.setInterrogado(interrogado);
			r.setBimestre(bimestreCorrente);
		}
		repositorio.salvarRespostas(respostas);
	}

			
}
	

