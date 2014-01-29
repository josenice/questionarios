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
@Table
public class RespostaUsuarioAutoAvaliacao implements Serializable{

	/**
	 * Josenice
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable=false)
	private Integer frequencia;
	
	@ManyToOne(optional=false)
	private ItemDeAutoAvaliacao itemAvaliacao;
	
	@ManyToOne(optional=false)
	private Usuario interrogador;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(Integer frequencia) {
		this.frequencia = frequencia;
	}

	public ItemDeAutoAvaliacao getItemAvaliacao() {
		return itemAvaliacao;
	}

	public void setItemAvaliacao(ItemDeAutoAvaliacao itemAvaliacao) {
		this.itemAvaliacao = itemAvaliacao;
	}

	public Usuario getInterrogador() {
		return interrogador;
	}

	public void setInterrogador(Usuario interrogador) {
		this.interrogador = interrogador;
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
		RespostaUsuarioAutoAvaliacao other = (RespostaUsuarioAutoAvaliacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

	

}
