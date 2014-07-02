package ifrn.etep.dominio;

import java.util.List;

public interface RepositorioQuestionarioAutoAvaliacaoDiscente {
	
	void insert(QuestionarioAutoAvaliacaoDiscente questionario);
	void delete(Integer idQuestionario);
	void update(QuestionarioAutoAvaliacaoDiscente questionario);
	QuestionarioAutoAvaliacaoDiscente getPorId(Integer idQuestionario);
	List<QuestionarioAutoAvaliacaoDiscente> getAll();
	void salvarRespostas(List<RespostaAutoAvaliacaoDiscente> respostas);
	QuestionarioAutoAvaliacaoDiscente getDoBimestreCorrente();
	boolean isAutoAvaliacaoRespondida(Integer idUsuario);

}
