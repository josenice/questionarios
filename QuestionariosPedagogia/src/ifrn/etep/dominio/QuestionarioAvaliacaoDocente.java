package ifrn.etep.dominio;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
@DiscriminatorValue("AVALIACAO_DOCENTE")
public class QuestionarioAvaliacaoDocente extends Questionario{

	private static final long serialVersionUID = 1L;
	
}
