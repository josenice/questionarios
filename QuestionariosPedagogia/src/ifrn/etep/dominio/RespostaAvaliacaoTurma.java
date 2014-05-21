package ifrn.etep.dominio;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table
@PrimaryKeyJoinColumn(name="ID_RESPOSTA_ITEM_AVALIACAO")
public class RespostaAvaliacaoTurma extends RespostaItemAvaliacao {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne(optional=false)
	private Professor interrogado; //unidirecional
	
	@ManyToOne(optional=false)
	private TurmaSeriada turmaAvaliada; //unidirecional
	
	public Professor getInterrogado() {
		return interrogado;
	}

	public void setInterrogado(Professor interrogado) {
		this.interrogado = interrogado;
	}

	public TurmaSeriada getTurmaAvaliada() {
		return turmaAvaliada;
	}

	public void setTurmaAvaliada(TurmaSeriada turmaAvaliada) {
		this.turmaAvaliada = turmaAvaliada;
	}	

}
