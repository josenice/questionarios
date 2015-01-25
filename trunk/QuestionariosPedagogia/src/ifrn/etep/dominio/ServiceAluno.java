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
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
@Transactional(propagation=Propagation.REQUIRED)
public class ServiceAluno implements Serializable{

	private static final long serialVersionUID = 1L;
	@Autowired
	private RepositorioAluno repositorio;
	
	public Aluno getPorId(Integer idAluno) {
		return repositorio.getPorId(idAluno);
	}
	
	/**
	 * Retornas os alunos associados a um professor no semestre corrente e que ainda não foram 
	 * avaliados.
	 * @param idProfessor
	 * @return
	 */
	public List<Aluno> getAlunosNaoAvaliadoPorProfessor(
			Integer idProfessor) {
		return repositorio.getAlunosNaoAvaliadosPorProfessor(idProfessor);
	}

}
