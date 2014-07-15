package ifrn.etep.dominio;

import java.util.List;

public interface RepositorioProfessor {
	void insert (Professor professor);
	void delete (Integer idProfessor);
	void update (Professor professor);
	Professor getPorId(Integer idProfessor);
	List<Professor> getAll();
	List<Professor> getProfessoresNaoAvaliadosPorAluno(Integer idAluno);
	
}
