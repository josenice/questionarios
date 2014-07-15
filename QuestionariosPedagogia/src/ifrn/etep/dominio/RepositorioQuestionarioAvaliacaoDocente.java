package ifrn.etep.dominio;

import java.util.List;

public interface RepositorioQuestionarioAvaliacaoDocente {
	
	void insert (QuestionarioAvaliacaoDocente questionario);
	void delete (Integer idQuestionario);
	void update (QuestionarioAvaliacaoDocente questionario);
	List<QuestionarioAvaliacaoDocente> getAll();
	QuestionarioAvaliacaoDocente getPorId(Integer idQuestionario);
	void salvarRespostas(List<RespostaAvaliacaoDocente> respostas);
	QuestionarioAvaliacaoDocente getDoBimestreCorente();

}
