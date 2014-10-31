package ifrn.etep.dao;

import ifrn.etep.dominio.BimestreLetivo;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class DAOConsultasRelatorios {

	@Autowired
	private SessionFactory sessionFactory;

	@Transactional(readOnly = true)
	public List<Object[]> getRegistros(BimestreLetivo bimestre) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("select r.docenteAvaliado.usuario.matricula, "
						+ "r.docenteAvaliado.usuario.nome, r.item.grupo.id, r.item.grupo.descricao, "
						+ "r.item.id, r.item.texto, r.frequencia, "
						+ "count(r.frequencia) "
						+ "from RespostaAvaliacaoDocente r "
						+ "where r.bimestre = :bimestre and r.item.usarFrequencia=true "
						+ "group by r.docenteAvaliado.usuario.matricula, "
						+ "r.docenteAvaliado.usuario.nome, r.item.grupo.id, r.item.grupo.descricao, "
						+ "r.item.id, r.item.texto, r.frequencia "
						+ "order by r.docenteAvaliado.usuario.matricula, r.item.grupo.id, "
						+ "r.item.id ");
		query.setParameter("bimestre", bimestre);

		return query.list();

	}
		@Transactional(readOnly = true)
		public List<Object[]> getRegistros1(BimestreLetivo bimestre){
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("select r.turmaAvaliada.codigoSistemaAcademico, "
					+ "r.item.grupo.id, r.item.grupo.descricao, "
					+ "r.item.id, r.item.texto, r.frequencia, "
					+ "count (r.frequencia) "
					+ "from RespostaAvaliacaoTurma r "
					+ "where r.bimestre = :bimestre and r.item.usarFrequencia=true "
					+ "group by r.turmaAvaliada.codigoSistemaAcademico, "
					+ "r.item.grupo.id, r.item.grupo.descricao, "
					+ "r.item.id, r.item.texto, r.frequencia "
					+ "order by r.turmaAvaliada.codigoSistemaAcademico, r.item.grupo.id, "
					+ "r.item.id ");
			query.setParameter("bimestre", bimestre);
			return query.list();
			
	}
}
