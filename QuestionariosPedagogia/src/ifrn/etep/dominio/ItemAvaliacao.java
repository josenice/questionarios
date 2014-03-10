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
public class ItemAvaliacao implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable=false, length=150)
	private String texto;
	
	@Column(nullable=false)
	private boolean usarFrequencia;
	
	@ManyToOne(optional=false)
	private Questionario questionario; // bidirecional
	
	@ManyToOne(optional=true)
	private GrupoItemAvaliacao grupo;
	
	@ManyToOne
	private RespostaItemAvaliacao respostas;
	
	@ManyToOne
	private CampoTextual campo;
		
	public CampoTextual getCampo() {
		return campo;
	}
	public void setCampo(CampoTextual campo) {
		this.campo = campo;
	}
	public Questionario getQuestionario() {
		return questionario;
	}
	public void setQuestionarios(Questionario questionario) {
		this.questionario = questionario;
	}
	public boolean isUsarFrequencia() {
		return usarFrequencia;
	}
	public void setUsarFrequencia(boolean usarFrequencia) {
		this.usarFrequencia = usarFrequencia;
	}
	public RespostaItemAvaliacao getRespostas() {
		return respostas;
	}
	public void setRespostas(RespostaItemAvaliacao respostas) {
		this.respostas = respostas;
	}
	public GrupoItemAvaliacao getGrupo() {
		return grupo;
	}
	public void setGrupo(GrupoItemAvaliacao grupo) {
		this.grupo = grupo;
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
