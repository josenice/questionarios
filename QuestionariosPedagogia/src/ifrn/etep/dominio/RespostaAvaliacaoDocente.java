package ifrn.etep.dominio;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table
@PrimaryKeyJoinColumn(name="ID_RESPOSTA_ITEM_AVALIACAO")
public class RespostaAvaliacaoDocente extends RespostaItemAvaliacao{

	private static final long serialVersionUID = 1L;
	@ManyToOne(optional=false)
	private Aluno interrogado; //unidirecional
	
	@ManyToOne(optional=false)
	private Professor docenteAvaliado; //unidirecional
	
	@ManyToOne(optional=false)
	private Diario diario;
	
	/*@ManyToOne(optional=false)
	private Usuario usuario;
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}*/

	public Aluno getInterrogado() {
		return interrogado;
	}

	public void setInterrogado(Aluno interrogado) {
		this.interrogado = interrogado;
	}

	public Professor getDocenteAvaliado() {
		return docenteAvaliado;
	}

	public void setDocenteAvaliado(Professor docenteAvaliado) {
		this.docenteAvaliado = docenteAvaliado;
	}

	public Diario getDiario() {
		return diario;
	}

	public void setDiario(Diario diario) {
		this.diario = diario;
	}

}
