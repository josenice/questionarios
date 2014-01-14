package ifrn.etep.dominio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="QUESTIONARIOAVALIACAODETURMA")
public class QuestionarioAvaliacaoDeTurma implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable=false, length=40)
	private String descricao;
	
	@OneToMany(orphanRemoval=true, cascade=CascadeType.ALL, mappedBy="modeloAvaliacao", 
			fetch=FetchType.EAGER)
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public List<RespostaUsuarioDaTurma> gerarItensResposta(TurmaSeriada turmaEmAvaliacao){
		ArrayList<RespostaUsuarioDaTurma> respostas = new ArrayList<>();
		for(ItemAvaliacaoDaTurma item : getItens()){
			RespostaUsuarioDaTurma r = new RespostaUsuarioDaTurma();
			r.setItemAvaliacao(item);
			r.setTurmaAvalida(turmaEmAvaliacao);
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
		QuestionarioAvaliacaoDeTurma other = (QuestionarioAvaliacaoDeTurma) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}