package ifrn.etep.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TIPOQUESTIONARIO", discriminatorType=DiscriminatorType.STRING)
public abstract class Questionario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length=255)
	private String descricao;
	
	@OneToMany(orphanRemoval=true, cascade=CascadeType.ALL, mappedBy="questionario", 
			fetch=FetchType.LAZY)
	private List<ItemAvaliacao> itens = new ArrayList<>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<ItemAvaliacao> getItens() {
		return itens;
	}

	public void setItens(List<ItemAvaliacao> itens) {
		this.itens = itens;
	}
	
	public Set<GrupoItemAvaliacao> getGruposDosItensDeAvaliacao(){
		Set<GrupoItemAvaliacao> gruposEncontrados = new LinkedHashSet<GrupoItemAvaliacao>();
		for(ItemAvaliacao itemAvaliacao : itens){
			GrupoItemAvaliacao grupoItem = itemAvaliacao.getGrupo();
			if(grupoItem != null){
				gruposEncontrados.add(grupoItem);
			}
		}
		return gruposEncontrados;
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
		Questionario other = (Questionario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
