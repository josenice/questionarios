package ifrn.etep.dominio;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table
public class Questionario implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	private String questionario;
	
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
		result = prime * result
				+ ((questionario == null) ? 0 : questionario.hashCode());
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
		if (questionario == null) {
			if (other.questionario != null)
				return false;
		} else if (!questionario.equals(other.questionario))
			return false;
		return true;
	}
	

	
}
