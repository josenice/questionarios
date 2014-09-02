package ifrn.etep.dominio;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
@DiscriminatorValue("AVALIACAO_DOCENTE")
public class QuestionarioAvaliacaoDocente extends Questionario{

	private static final long serialVersionUID = 1L;
	
	public List<RespostaAvaliacaoDocente> gerarItensResposta (
			Professor professorEmAvaliacao, Diario diario){
		ArrayList<RespostaAvaliacaoDocente> respostas = new ArrayList<>();
		for (ItemAvaliacao item: getItens()){
			RespostaAvaliacaoDocente respostaAvaliacaoDocente = new RespostaAvaliacaoDocente();
			respostaAvaliacaoDocente.setItem(item);
			respostaAvaliacaoDocente.setDiario(diario);
			respostaAvaliacaoDocente.setDocenteAvaliado(professorEmAvaliacao);
			respostas.add(respostaAvaliacaoDocente);
			
			for(CampoTextual campoTxt : item.getCamposTextuais()){
				RespostaCampoTextual respostaCampoTxt = new RespostaCampoTextual();
				respostaCampoTxt.setRespostaItemAvaliacao(respostaAvaliacaoDocente);
				respostaCampoTxt.setCampoTextual(campoTxt);
				respostaAvaliacaoDocente.getRespostasCampoTextual().add(respostaCampoTxt);
			}
		}
		return respostas;
		
	}
	
}
