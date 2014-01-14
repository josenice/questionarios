package ifrn.etep.dominio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="DIARIO")
public class Diario implements Serializable{

	/**
	 * Josenice
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String codigoSistemaAcademico;
	
	@ManyToOne
	private TurmaSeriada turma;
	
	@ManyToOne
	private SemestreLetivo semestre;
	
	@ManyToMany
	private List<Professor> professor;

	public List<Professor> getProfessor() {
		return professor;
	}

	public void setProfessor(List<Professor> professor) {
		this.professor = professor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigoSistemaAcademico() {
		return codigoSistemaAcademico;
	}

	public void setCodigoSistemaAcademico(String codigoSistemaAcademico) {
		this.codigoSistemaAcademico = codigoSistemaAcademico;
	}

	public TurmaSeriada getTurma() {
		return turma;
	}

	public void setTurma(TurmaSeriada turma) {
		this.turma = turma;
	}

	public SemestreLetivo getSemestre() {
		return semestre;
	}

	public void setSemestre(SemestreLetivo semestre) {
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
		Diario other = (Diario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
