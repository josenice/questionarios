package ifrn.etep.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table
public class QuestionarioDeAutoAvaliacao implements Serializable {

	/**
	 * Josenice
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String descricao;
	
	@OneToMany(orphanRemoval=true, cascade=CascadeType.ALL, mappedBy="modeloQuestionario", 
			fetch=FetchType.LAZY)
	private List<ItemDeAutoAvaliacao> itens = new ArrayList<>();

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
	
	public List<ItemDeAutoAvaliacao> getItens() {
		return itens;
	}

	public void setItens(List<ItemDeAutoAvaliacao> itens) {
		this.itens = itens;
	}

	public List<RespostaUsuarioAutoAvaliacao> gerarItensResposta(Usuario interrogado){
		ArrayList<RespostaUsuarioAutoAvaliacao> respostas = new ArrayList<>();
		for(ItemDeAutoAvaliacao item : itens){
			RespostaUsuarioAutoAvaliacao r = new RespostaUsuarioAutoAvaliacao();
			r.setItemAvaliacao(item);
			r.setInterrogador(interrogado);
			respostas.add(r);
		}
		
		return respostas;
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
		QuestionarioDeAutoAvaliacao other = (QuestionarioDeAutoAvaliacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
