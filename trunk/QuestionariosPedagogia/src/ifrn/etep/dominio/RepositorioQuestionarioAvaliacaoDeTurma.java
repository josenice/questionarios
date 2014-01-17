package ifrn.etep.dominio;

import java.util.List;

public interface RepositorioQuestionarioAvaliacaoDeTurma {
	
	void insert (QuestionarioAvaliacaoDeTurma questionario);
	void delete (Integer idQuestionario);
	void update (QuestionarioAvaliacaoDeTurma questionario);
	List<QuestionarioAvaliacaoDeTurma> getAll();
	QuestionarioAvaliacaoDeTurma getPorId(Integer idQuestionario);
	void salvarRespostas(List<RespostaUsuarioDaTurma> respostas);
	QuestionarioAvaliacaoDeTurma getDoSemestreCorente();

}
