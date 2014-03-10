package ifrn.etep.dominio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table
@DiscriminatorValue("AVALIACAO_TURMA")
public class QuestionarioAvaliacaoTurma extends Questionario{
	
	private static final long serialVersionUID = 1L;

	public List<RespostaAvaliacaoTurma> gerarItensResposta(TurmaSeriada turmaEmAvaliacao){
		ArrayList<RespostaAvaliacaoTurma> respostas = new ArrayList<>();
		/*for(ItemAvaliacaoDaTurma item : getItens()){
			RespostaAvaliacaoTurma r = new RespostaAvaliacaoTurma();
			r.setItemAvaliacao(item);
			r.setTurmaAvaliada(turmaEmAvaliacao);
			respostas.add(r);
		}*/
		//TODO
		
		return respostas;
	}

}