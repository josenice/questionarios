package ifrn.etep.dominio;

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
public class ServiceTurma {
	
	@Autowired
	private RepositorioTurma repositorio;
	
	public TurmaSeriada getPorId(Integer idTurma) {
		// TODO
		TurmaSeriada t = new TurmaSeriada();
		t.setId(1);
		t.setCodigoSistemaAcademico("20132.4404");
		return t;
	}
	
	/**
	 * Retornas as turmas associadas a um professor no semestre corrente e que ainda não foram 
	 * avaliadas.
	 * @param idProfessor
	 * @return
	 */
	public List<TurmaSeriada> getTurmasNaoAvaliadasPorProfessor(
			Integer idProfessor) {
		return repositorio.getTurmasNaoAvaliadasPorProfessor(idProfessor);
	}

}
