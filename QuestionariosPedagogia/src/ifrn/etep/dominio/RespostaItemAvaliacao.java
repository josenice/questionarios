package ifrn.etep.dominio;	

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class RespostaItemAvaliacao implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable=true)
	private String frequencia;
	
	@ManyToOne
	private ItemAvaliacao item;
	
	@OneToMany(orphanRemoval=true, mappedBy="respostaItemAvaliacao", cascade=CascadeType.ALL)
	private List<RespostaCampoTextual> respostasCampoTextual = new ArrayList<RespostaCampoTextual>();
	
	@ManyToOne
	private BimestreLetivo bimestre;

	public BimestreLetivo getBimestre() {
		return bimestre;
	}

	public void setBimestre(BimestreLetivo bimestre) {
		this.bimestre = bimestre;
	}

	public ItemAvaliacao getItem() {
		return item;
	}

	public void setItem(ItemAvaliacao iten) {
		this.item = iten;
	}

	public List<RespostaCampoTextual> getRespostasCampoTextual() {
		return respostasCampoTextual;
	}

	public void setRespostasCampoTextual(
			List<RespostaCampoTextual> repostasCampoTextual) {
		this.respostasCampoTextual = repostasCampoTextual;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(String frequencia) {
		this.frequencia = frequencia;
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
		RespostaItemAvaliacao other = (RespostaItemAvaliacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
