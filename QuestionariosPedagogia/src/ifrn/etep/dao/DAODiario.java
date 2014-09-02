package ifrn.etep.dao;

import ifrn.etep.dominio.Diario;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DAODiario{
	
	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	public Diario getPorId(Integer idDiario) {
		Session session = sessionFactory.getCurrentSession();
		return (Diario) session.get(Diario.class, idDiario);
	}

}
