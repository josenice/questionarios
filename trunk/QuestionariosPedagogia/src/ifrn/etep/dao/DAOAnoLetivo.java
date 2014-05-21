package ifrn.etep.dao;

import ifrn.etep.dominio.AnoLetivo;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DAOAnoLetivo{
	
	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}

	public AnoLetivo getAnoCorrente() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select s from AnoLetivo s " +
				"where s.ano = (select max(s1.ano) from AnoLetivo s1) ");
		return (AnoLetivo)query.uniqueResult();
	}
	
	
}
