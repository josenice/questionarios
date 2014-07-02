package ifrn.etep.dominio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
@DiscriminatorValue("AUTO_AVALIACAO_DISCENTE")

public class QuestionarioAutoAvaliacaoDiscente extends Questionario {

	private static final long serialVersionUID = 1L;
	public List<RespostaAutoAvaliacaoDiscente> gerarItensResposta(Aluno interrogado){
		ArrayList<RespostaAutoAvaliacaoDiscente> respostas = new ArrayList<>();
		for(ItemAvaliacao item : getItens()){
			RespostaAutoAvaliacaoDiscente r = new RespostaAutoAvaliacaoDiscente();
			r.setItem(item);
			r.setInterrogado(interrogado);
			respostas.add(r);
		}
		
		return respostas;
	}


}
