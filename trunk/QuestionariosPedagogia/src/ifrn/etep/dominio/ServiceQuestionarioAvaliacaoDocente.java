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
public class ServiceQuestionarioAvaliacaoDocente implements Serializable {

	/**
	 * Maria Josenice Severino de Pinho
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private RepositorioQuestionarioAvaliacaoDocente repositorio;
	
	@Autowired
	private DAOBimesteLetivo daoBimestre;

	public void setRepositorio(															
			RepositorioQuestionarioAvaliacaoDocente repositorio) {
		this.repositorio = repositorio;
	}
	
	public QuestionarioAvaliacaoDocente getDoBimestreCorrente(){
		return repositorio.getDoBimestreCorente();
	}

	public QuestionarioAvaliacaoDocente getPorId(Integer idQuestionario) {
		return repositorio.getPorId(idQuestionario);
	}

	public void cadastrarQuestionario(QuestionarioAvaliacaoDocente questionario) {
		this.repositorio.insert(questionario);
	}

	public void atualizarQuestionario(QuestionarioAvaliacaoDocente questionario) {
		this.repositorio.update(questionario);
	}

	public void excluirQuestionario(Integer questionario) {
		this.repositorio.delete(questionario);
	}


	public void salvarRespostas(List<RespostaAvaliacaoDocente> respostas, Aluno interrogado) {
		//TODO usar Aluno ao invés de usuário
		BimestreLetivo bimestreCorrente = daoBimestre.getBimestreCorrente();
		for(RespostaAvaliacaoDocente r : respostas){
			r.setInterrogado(interrogado);
			r.setBimestre(bimestreCorrente);
		}
		repositorio.salvarRespostas(respostas);
	}

			
}
	

