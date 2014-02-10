package ifrn.etep.dao;

import ifrn.etep.dominio.SemestreLetivo;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DAOSemestreLetivo{
	
	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	public SemestreLetivo getSemestreCorente() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select s from SemestreLetivo s " +
				"where s.ano = (select max(s1.ano) from SemestreLetivo s1) " +
				"and s.semestre =(select max(s2.semestre) from SemestreLetivo s2)");
		return (SemestreLetivo)query.uniqueResult();
	}
}
