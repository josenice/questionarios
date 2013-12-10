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
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="MODELODEAVALIACAODETURMA")
public class ModeloAvaliacaoDeTurma implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable=false, length=40)
	private String questionario;
	
	@OneToMany(orphanRemoval=true, cascade=CascadeType.ALL)
	private List<ItemAvaliacaoDaTurma> itens = new ArrayList<>();//bidirecional
	
	public List<ItemAvaliacaoDaTurma> getItens() {
		return itens;
	}

	public void setItens(List<ItemAvaliacaoDaTurma> itens) {
		this.itens = itens;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQuestionario() {
		return questionario;
	}

	public void setQuestionario(String questionario) {
		this.questionario = questionario;
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
		ModeloAvaliacaoDeTurma other = (ModeloAvaliacaoDeTurma) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}