package ifrn.etep.dominio;

import java.util.List;

public interface RepositorioQuestionarioAutoAvaliacaoDocente {
	
	void insert(QuestionarioAutoAvaliacaoDocente questionario);
	void delete(Integer idQuestionario);
	void update(QuestionarioAutoAvaliacaoDocente questionario);
	QuestionarioAutoAvaliacaoDocente getPorId(Integer idQuestionario);
	List<QuestionarioAutoAvaliacaoDocente> getAll();
	void salvarRespostas(List<RespostaAutoAvaliacaoDocente> respostas);
	QuestionarioAutoAvaliacaoDocente getDoBimestreCorrente();
	boolean isAutoAvaliacaoRespondida(Integer idUsuario);

}
