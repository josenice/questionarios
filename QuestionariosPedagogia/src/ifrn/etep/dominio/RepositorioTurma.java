package ifrn.etep.dominio;

import java.util.List;

public interface RepositorioTurma {
	void insert (TurmaSeriada turma);
	void delete (Integer idTurma);
	void update (TurmaSeriada turma);
	List<TurmaSeriada> getAll();
	List<TurmaSeriada> getTurmasNaoAvaliadasPorProfessor(Integer idProfessor);
}
