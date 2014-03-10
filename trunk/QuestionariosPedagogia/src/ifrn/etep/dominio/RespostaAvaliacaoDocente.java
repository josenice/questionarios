package ifrn.etep.dominio;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table
@PrimaryKeyJoinColumn(name="ID_RESPOSTA_ITEM_AVALIACAO")
public class RespostaAvaliacaoDocente extends RespostaItemAvaliacao{

	private static final long serialVersionUID = 1L;
	
	private Aluno interrogado;
	
	private Professor avaliado;

	public Aluno getInterrogado() {
		return interrogado;
	}

	public void setInterrogado(Aluno interrogado) {
		this.interrogado = interrogado;
	}

	public Professor getAvaliado() {
		return avaliado;
	}

	public void setAvaliado(Professor avaliado) {
		this.avaliado = avaliado;
	}
	
	

}
