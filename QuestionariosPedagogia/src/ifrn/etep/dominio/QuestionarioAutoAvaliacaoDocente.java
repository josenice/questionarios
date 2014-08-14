package ifrn.etep.dominio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;
@Entity
@Table
@DiscriminatorValue("AUTO_AVALIACAO_DOCENTE")
public class QuestionarioAutoAvaliacaoDocente extends Questionario {

	private static final long serialVersionUID = 1L;

	public List<RespostaAutoAvaliacaoDocente> gerarItensResposta(Professor interrogado){
		ArrayList<RespostaAutoAvaliacaoDocente> respostas = new ArrayList<>();
		for(ItemAvaliacao item : getItens()){
			RespostaAutoAvaliacaoDocente r = new RespostaAutoAvaliacaoDocente();
			r.setItem(item);
			r.setInterrogado(interrogado);
			respostas.add(r);
			
			for(CampoTextual campoTxt : item.getCamposTextuais()){
				RespostaCampoTextual respostaCampoTxt = new RespostaCampoTextual();
				respostaCampoTxt.setRespostaItemAvaliacao(r);
				respostaCampoTxt.setCampoTextual(campoTxt);
				r.getRespostasCampoTextual().add(respostaCampoTxt);
			}
		}
		
		return respostas;
	}

}
