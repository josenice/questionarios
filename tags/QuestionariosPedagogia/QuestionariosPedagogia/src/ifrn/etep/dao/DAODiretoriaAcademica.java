package ifrn.etep.dao;

import ifrn.etep.dominio.DiretoriaAcademica;
import ifrn.etep.dominio.RepositorioDiretoriaAcademica;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DAODiretoriaAcademica implements RepositorioDiretoriaAcademica{
	
	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void insert(DiretoriaAcademica diretoria) {
		Session session =  sessionFactory.getCurrentSession();
		session.save(diretoria);
	}

	@Override
	public void delete(Integer idDiretoria) {
		Session session = sessionFactory.getCurrentSession();
		DiretoriaAcademica d = (DiretoriaAcademica) session.get(DiretoriaAcademica.class, idDiretoria);
		session.delete(d);
	}

	@Override
	public void update(DiretoriaAcademica diretoria) {
		Session session = sessionFactory.getCurrentSession();
		session.update(diretoria);
		
	}

	@Override
	public List<DiretoriaAcademica> getAll() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select d from DiretoriaAcademica d");
		return query.list();
	}
	
}
