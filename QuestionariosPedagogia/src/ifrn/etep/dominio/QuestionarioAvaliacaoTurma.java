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
		for(ItemAvaliacao item : getItens()){
			RespostaAvaliacaoTurma respostaAvaliacaoTurma = new RespostaAvaliacaoTurma();
			respostaAvaliacaoTurma.setItem(item);
			respostaAvaliacaoTurma.setTurmaAvaliada(turmaEmAvaliacao);
			respostas.add(respostaAvaliacaoTurma);
			
			for(CampoTextual campoTxt : item.getCamposTextuais()){
				RespostaCampoTextual respostaCampoTxt = new RespostaCampoTextual();
				respostaCampoTxt.setRespostaItemAvaliacao(respostaAvaliacaoTurma);
				respostaCampoTxt.setCampoTextual(campoTxt);
				respostaAvaliacaoTurma.getRespostasCampoTextual().add(respostaCampoTxt);
			}
		}
		
		return respostas;
	}

}