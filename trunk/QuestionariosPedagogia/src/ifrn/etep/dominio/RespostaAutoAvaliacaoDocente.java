package ifrn.etep.dominio;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
@Entity
@Table
@PrimaryKeyJoinColumn(name="ID_RESPOSTA_ITEM_AVALIACAO")
public class RespostaAutoAvaliacaoDocente extends RespostaItemAvaliacao{

	private static final long serialVersionUID = 1L;
		
	@ManyToOne(optional=false)
	private Professor interrogado;
	
	@ManyToOne(optional=false)
	private Usuario usuario;
	
	@ManyToOne(optional=false)
	private Diario diario;
					
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Diario getDiario() {
		return diario;
	}

	public void setDiario(Diario diario) {
		this.diario = diario;
	}

	public Professor getInterrogado() {
		return interrogado;
	}

	public void setInterrogado(Professor interrogado) {
		this.interrogado = interrogado;
	}

}
