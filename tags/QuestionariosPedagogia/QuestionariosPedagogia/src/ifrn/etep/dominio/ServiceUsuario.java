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
public class ServiceUsuario implements Serializable{
	
	/**
	 * Josenice
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	private RepositorioUsuario repositorio;
	
	public Usuario getPorId(Integer idUsuario) {
		return repositorio.getPorId(idUsuario);
	}
	
	/**
	 * Retornas as turmas associadas a um professor no semestre corrente e que ainda não foram 
	 * avaliadas.
	 * @param idProfessor
	 * @return
	 */
	/*public List<TurmaSeriada> getTurmasNaoAvaliadasPorProfessor(
			Integer idProfessor) {
		return repositorio.getTurmasNaoAvaliadasPorProfessor(idProfessor);
	}*/

}
