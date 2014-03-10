package ifrn.etep.dominio;

import java.util.List;

public interface RepositorioQuestionarioAvaliacaoTurma {
	
	void insert (QuestionarioAvaliacaoTurma questionario);
	void delete (Integer idQuestionario);
	void update (QuestionarioAvaliacaoTurma questionario);
	List<QuestionarioAvaliacaoTurma> getAll();
	QuestionarioAvaliacaoTurma getPorId(Integer idQuestionario);
	void salvarRespostas(List<RespostaAvaliacaoTurma> respostas);
	QuestionarioAvaliacaoTurma getDoBimestreCorente();

}
