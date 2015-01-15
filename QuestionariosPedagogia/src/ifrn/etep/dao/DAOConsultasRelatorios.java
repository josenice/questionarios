package ifrn.etep.dao;

import ifrn.etep.dominio.BimestreLetivo;
import ifrn.etep.dominio.RespostaAvaliacaoTurma;

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
	public List<Object[]> getRegistrosAvaliacaoDocente(BimestreLetivo bimestre) {
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
	//Faz a consulta da avaliação turma gerados por turma
	@Transactional(readOnly = true)
	public List<Object[]> getRegistrosAvaliacaoTurma(BimestreLetivo bimestre){
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select "
					+ "r.id, r.turmaAvaliada.codigoSistemaAcademico, "
					+ "g.id, g.descricao, r.item.id, r.item.texto, "
					+ "r.frequencia, count (r.frequencia) "
					+ "from RespostaAvaliacaoTurma r left join r.item.grupo g "
					+ "where "
					+ "r.bimestre = :bimestre and r.item.usarFrequencia=true "
					+ "group by "
					+ "r.id, r.turmaAvaliada.codigoSistemaAcademico, "
					+ "g.id, g.descricao, r.item.id, r.item.texto, "
					+ "r.frequencia ");
		query.setParameter("bimestre", bimestre);
		return query.list();
	}
	@Transactional(readOnly = true)
	public List<Object[]> getRegistrosAutoAvaliacaoDocente(BimestreLetivo bimestre){
		Session session = sessionFactory.getCurrentSession();
		Query query = session
				.createQuery("select r.interrogado.usuario.matricula, "
						+ "r.interrogado.usuario.nome, r.item.grupo.id, r.item.grupo.descricao, "
						+ "r.item.id, r.item.texto, r.frequencia, "
						+ "count(r.frequencia) "
						+ "from RespostaAutoAvaliacaoDocente r "
						+ "where r.bimestre = :bimestre and r.item.usarFrequencia=true "
						+ "group by r.interrogado.usuario.matricula, "
						+ "r.interrogado.usuario.nome, r.item.grupo.id, r.item.grupo.descricao, "
						+ "r.item.id, r.item.texto, r.frequencia "
						+ "order by r.interrogado.usuario.matricula, r.item.grupo.id, "
						+ "r.item.id ");
						
		query.setParameter("bimestre", bimestre);
		return query.list();
	}
	//Faz a consulta da avaliação turma gerados por diretoria
	@Transactional(readOnly = true)
	public List<Object[]> getRegistrosAvaliacaoTurmaDiretoria(BimestreLetivo bimestre){
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select "	+ "r.id, r.diretoria.nome, ");
							query.setParameter("bimestre", bimestre);
		return query.list();
	}
	
}
