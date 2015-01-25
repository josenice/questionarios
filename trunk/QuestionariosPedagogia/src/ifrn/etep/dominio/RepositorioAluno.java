package ifrn.etep.dominio;

import java.util.List;

public interface RepositorioAluno {
	
	void insert (Aluno aluno);
	void delete (Integer idAluno);
	void update (Aluno aluno);
	Aluno getPorId(Integer idAluno);
	List<Aluno> getAll();
	List<Aluno> getAlunosNaoAvaliadosPorProfessor(Integer idProfessor);

}
