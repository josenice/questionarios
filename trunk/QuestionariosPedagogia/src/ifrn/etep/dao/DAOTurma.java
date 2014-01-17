package ifrn.etep.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ifrn.etep.dominio.RepositorioTurma;
import ifrn.etep.dominio.SemestreLetivo;
import ifrn.etep.dominio.TurmaSeriada;

@Repository
public class DAOTurma implements RepositorioTurma{
	
	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Autowired
	private DAOSemesteLetivo daoSemestreLetivo;

	@Override
	public void insert(TurmaSeriada turma) {
		Session session = sessionFactory.getCurrentSession();
		session.save(turma);
		
	}

	@Override
	public void delete(Integer idTurma) {
		Session session = sessionFactory.getCurrentSession();
		TurmaSeriada t = (TurmaSeriada) session.get(TurmaSeriada.class, idTurma);
		session.delete(t);
	}

	@Override
	public void update(TurmaSeriada turma) {
		
		Session session = sessionFactory.getCurrentSession();
		session.update(turma);
	}


	@Override
	public List<TurmaSeriada> getAll() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select t from Turma t");
		return query.list();
	}


	@Override
	public List<TurmaSeriada> getTurmasNaoAvaliadasPorProfessor(
			Integer idProfessor) {
		//TODO completar a consulta para filtrar por professor e turmas não avaliadas
		SemestreLetivo semestreCorrente = daoSemestreLetivo.getSemestreCorente();
		Session session = sessionFactory.getCurrentSession();
		String hql = "select t from TurmaSeriada t join t.diarios d where d.semestre = :corrente ";
		Query q = session.createQuery(hql);
		q.setParameter("corrente", semestreCorrente);
		
		return q.list();
	}

}
