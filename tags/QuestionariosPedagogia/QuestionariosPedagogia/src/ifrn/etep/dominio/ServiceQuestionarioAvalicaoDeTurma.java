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
public class ServiceQuestionarioAvalicaoDeTurma implements Serializable {

	/**
	 * Maria Josenice Severino de Pinho
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private RepositorioQuestionarioAvaliacaoDeTurma repositorio;
	
	@Autowired
	private DAOBimesteLetivo daoBimestre;

	public void setRepositorio(															
			RepositorioQuestionarioAvaliacaoDeTurma repositorio) {
		this.repositorio = repositorio;
	}
	
	public QuestionarioAvaliacaoDeTurma getDoBimestreCorrente(){
		return repositorio.getDoBimestreCorente();
	}

	public QuestionarioAvaliacaoDeTurma getPorId(Integer idQuestionario) {
		return repositorio.getPorId(idQuestionario);
	}

	public void cadastrarQuestionario(QuestionarioAvaliacaoDeTurma questionario) {
		this.repositorio.insert(questionario);
	}

	public void atualizarQuestionario(QuestionarioAvaliacaoDeTurma questionario) {
		this.repositorio.update(questionario);
	}

	public void excluirQuestionario(Integer questionario) {
		this.repositorio.delete(questionario);
	}


	public void salvarRespostas(List<RespostaUsuarioDaTurma> respostas, Usuario interrogado) {
		//TODO usar Professor ao invés de usuário
		BimestreLetivo bimestreCorrente = daoBimestre.getBimestreCorente();
		for(RespostaUsuarioDaTurma r : respostas){
			r.setInterrogado(interrogado);
			r.setBimestreAvaliado(bimestreCorrente);
		}
		repositorio.salvarRespostas(respostas);
	}

			
}
	

