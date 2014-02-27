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
public class ItemDeAutoAvaliacao implements Serializable{

	/**
	 * Josenice
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable=false, length=150)
	private String texto;
	
	@ManyToOne(optional=false)
	private QuestionarioDeAutoAvaliacao modeloQuestionario; // bidirecional
	
	@ManyToOne(optional=true)
	private GrupoItemAvaliacao grupo;
	
	public GrupoItemAvaliacao getGrupo() {
		return grupo;
	}
	public void setGrupo(GrupoItemAvaliacao grupo) {
		this.grupo = grupo;
	}
	public QuestionarioDeAutoAvaliacao getModeloQuestionario() {
		return modeloQuestionario;
	}
	public void setModeloQuestionario(QuestionarioDeAutoAvaliacao modeloQuestionario) {
		this.modeloQuestionario = modeloQuestionario;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	
	
	
	

}
