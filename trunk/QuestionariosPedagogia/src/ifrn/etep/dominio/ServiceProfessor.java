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
public class ServiceProfessor implements Serializable{
	
	/**
	 * Josenice
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private RepositorioProfessor repositorio;
	
	public Professor getPorId(Integer idProfessor) {
		return repositorio.getPorId(idProfessor);
	}
	
	/**
	 * Retornas os docentes associados a um aluno no semestre corrente e que ainda não foram 
	 * avaliados.
	 * @param idAluno
	 * @return
	 */
	public List<Professor> getProfessoresNaoAvaliadoPorAluno(
			Integer idAluno) {
		return repositorio.getProfessoresNaoAvaliadosPorAluno(idAluno);
	}

}
