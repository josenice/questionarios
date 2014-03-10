package ifrn.etep.dominio;

import java.util.List;

public interface RepositorioTurma {
	void insert (TurmaSeriada turma);
	void delete (Integer idTurma);
	void update (TurmaSeriada turma);
	TurmaSeriada getPorId(Integer idTurma);
	List<TurmaSeriada> getAll();
	List<TurmaSeriada> getTurmasNaoAvaliadasPorProfessor(Integer idProfessor);
	
}
