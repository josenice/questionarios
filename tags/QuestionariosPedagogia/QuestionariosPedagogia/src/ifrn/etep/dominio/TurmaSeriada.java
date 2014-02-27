package ifrn.etep.dominio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="TURMASERIADA")
public class TurmaSeriada implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String codigoSistemaAcademico;
	
	@OneToMany(mappedBy="turma", fetch=FetchType.LAZY)
	private List<Diario> diarios;
	
	public List<Diario> getDiarios() {
		return diarios;
	}
	public void setDiarios(List<Diario> diarios) {
		this.diarios = diarios;
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
		TurmaSeriada other = (TurmaSeriada) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
