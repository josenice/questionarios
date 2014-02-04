package ifrn.etep.dominio;

import java.util.List;

public interface RepositorioQuestionarioAutoAvaliacao {
	
	void insert(QuestionarioDeAutoAvaliacao questionario);
	void delete(Integer idQuestionario);
	void update(QuestionarioDeAutoAvaliacao questionario);
	QuestionarioDeAutoAvaliacao getPorId(Integer idQuestionario);
	List<QuestionarioDeAutoAvaliacao> getAll();
	void salvarRespostas(List<RespostaUsuarioAutoAvaliacao> respostas);
	QuestionarioDeAutoAvaliacao getDoSemestreCorrente();
	boolean isAutoAvaliacaoRespondida(Integer idUsuario);

}
