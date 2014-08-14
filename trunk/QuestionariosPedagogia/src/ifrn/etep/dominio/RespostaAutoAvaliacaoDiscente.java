package ifrn.etep.dominio;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table
@PrimaryKeyJoinColumn(name="ID_RESPOSTA_ITEM_AVALIACAO")
public class RespostaAutoAvaliacaoDiscente extends RespostaItemAvaliacao {

	private static final long serialVersionUID = 1L;
	@ManyToOne(optional=false)//serve para quando eu chamar um aluno, seja um aluno interrogado.
	private Aluno interrogado;

	
	public Aluno setInterrogado() {
		return interrogado;
	}
	public void setInterrogado(Aluno interrogado) {
		this.interrogado = interrogado;
	}

}
