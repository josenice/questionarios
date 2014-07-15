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
@Table(name="BIMESTRELETIVO")
public class BimestreLetivo implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable=false)
	private Integer bimestre;
	
	@ManyToOne
	private AnoLetivo ano;
	
	@ManyToOne
	private QuestionarioAvaliacaoTurma questionarioAvaliacaoDeTurma; //unidirecional
	
	@ManyToOne
	private QuestionarioAutoAvaliacaoDocente questionarioAutoAvaliacaoDocente;
	
	@ManyToOne
	private QuestionarioAutoAvaliacaoDiscente questionarioAutoAvaliacaoDiscente;
	
	@ManyToOne
	private QuestionarioAvaliacaoDocente questionarioAvaliacaoDocente;
	
	public AnoLetivo getAno() {
		return ano;
	}
	public void setAno(AnoLetivo ano) {
		this.ano = ano;
	}	
	public QuestionarioAutoAvaliacaoDocente getModeloAutoAvaliacaoDocente() {
		return questionarioAutoAvaliacaoDocente;
	}
	public void setModeloAutoAvaliacaoDocente(
			QuestionarioAutoAvaliacaoDocente modeloAutoAvaliacao) {
		this.questionarioAutoAvaliacaoDocente = modeloAutoAvaliacao;
	}
	public QuestionarioAutoAvaliacaoDiscente getModeloAutoAvaliacaoDiscente(){
		return questionarioAutoAvaliacaoDiscente;
	}
	public void setModeloAutoAvaliacaoDiscente(
		QuestionarioAutoAvaliacaoDiscente modeloAutoAvaliacao){
		this.questionarioAutoAvaliacaoDiscente = modeloAutoAvaliacao;
	}
	public Integer getId() {
		return id;
	} 
	public void setId(Integer id) {
		this.id = id;
	}
	public QuestionarioAvaliacaoTurma getQuestionarioAvaliacaoDeTurma() {
		return questionarioAvaliacaoDeTurma;
	}
	public void setQuestionarioAvaliacaoDeTurma(
			QuestionarioAvaliacaoTurma modeloAvaliacaoDeTurma) {
		this.questionarioAvaliacaoDeTurma = modeloAvaliacaoDeTurma;
	}
	public QuestionarioAvaliacaoDocente getQuestionarioAvaliacaoDocente() {
		return questionarioAvaliacaoDocente;
	}
	public void setQuestionarioAvaliacaoDocente(
			QuestionarioAvaliacaoDocente questionarioAvaliacaoDocente) {
		this.questionarioAvaliacaoDocente = questionarioAvaliacaoDocente;
	}
	public Integer getBimestre() {
		return bimestre;
	}
	public void setBimestre(Integer bimestre) {
		this.bimestre = bimestre;
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
		BimestreLetivo other = (BimestreLetivo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

}
