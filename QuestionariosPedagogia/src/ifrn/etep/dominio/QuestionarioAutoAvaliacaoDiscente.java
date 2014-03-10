package ifrn.etep.dominio;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
@DiscriminatorValue("AUTO_AVALIACAO_DISCENTE")

public class QuestionarioAutoAvaliacaoDiscente extends Questionario {

	private static final long serialVersionUID = 1L;

}
