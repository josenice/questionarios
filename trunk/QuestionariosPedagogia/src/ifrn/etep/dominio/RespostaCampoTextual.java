package ifrn.etep.dominio;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="RESPOSTACAMPOTEXTUAL")
public class RespostaCampoTextual implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String respostas;
	
	@ManyToOne
	private CampoTextual campoTextual;
	
	@ManyToOne()
	private RespostaItemAvaliacao respostaItemAvaliacao;

	public RespostaItemAvaliacao getRespostaItemAvaliacao() {
		return respostaItemAvaliacao;
	}

	public void setRespostaItemAvaliacao(RespostaItemAvaliacao resposta) {
		this.respostaItemAvaliacao = resposta;
	}

	public CampoTextual getCampoTextual() {
		return campoTextual;
	}

	public void setCampoTextual(CampoTextual texto) {
		this.campoTextual = texto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRespostas() {
		return respostas;
	}

	public void setRespostas(String respostas) {
		this.respostas = respostas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		RespostaCampoTextual other = (RespostaCampoTextual) obj;
		if (id != other.id)
			return false;
		return true;
	}
	

}
