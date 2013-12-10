package ifrn.etep.dominio;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="ITEMAVALIACAODATURMA")
public class ItemAvaliacaoDaTurma implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable=false, length=150)
	private String texto;
	
	@ManyToOne(optional=false)
	private ModeloAvaliacaoDeTurma modeloAvaliacao;// bidirecional

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ModeloAvaliacaoDeTurma getModeloAvaliacao() {
		return modeloAvaliacao;
	}

	public void setModeloAvaliacao(ModeloAvaliacaoDeTurma modeloAvaliacao) {
		this.modeloAvaliacao = modeloAvaliacao;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemAvaliacaoDaTurma other = (ItemAvaliacaoDaTurma) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	

}
