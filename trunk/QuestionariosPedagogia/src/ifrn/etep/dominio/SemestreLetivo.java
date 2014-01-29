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
@Table(name="SEMESTRELETIVO")
public class SemestreLetivo implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable=false)
	private Integer ano;
	
	@Column(nullable=false)
	private Integer semestre;
	
	@ManyToOne
	private QuestionarioAvaliacaoDeTurma modeloAvaliacaoDeTurma; //unidirecional
	
	@ManyToOne
	private QuestionarioDeAutoAvaliacao modeloAutoAvaliacao;
	
	public QuestionarioDeAutoAvaliacao getModeloAutoAvaliacao() {
		return modeloAutoAvaliacao;
	}
	public void setModeloAutoAvaliacao(
			QuestionarioDeAutoAvaliacao modeloAutoAvaliacao) {
		this.modeloAutoAvaliacao = modeloAutoAvaliacao;
	}
	public Integer getId() {
		return id;
	} 
	public void setId(Integer id) {
		this.id = id;
	}
	public QuestionarioAvaliacaoDeTurma getModeloAvaliacaoDeTurma() {
		return modeloAvaliacaoDeTurma;
	}
	public void setModeloAvaliacaoDeTurma(
			QuestionarioAvaliacaoDeTurma modeloAvaliacaoDeTurma) {
		this.modeloAvaliacaoDeTurma = modeloAvaliacaoDeTurma;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	public Integer getSemestre() {
		return semestre;
	}
	public void setSemestre(Integer semestre) {
		this.semestre = semestre;
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
		SemestreLetivo other = (SemestreLetivo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

}
