package ifrn.etep.dao;

import ifrn.etep.dominio.BimestreLetivo;
import ifrn.etep.dominio.RespostaAvaliacaoDocente;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class DAORespostaItemAvaliacao {
	
	@Autowired
    private SessionFactory sessionFactory;
	
	@Transactional(readOnly=true)
	public List<RespostaAvaliacaoDocente> getDaAvaliacaoDocente(
			BimestreLetivo bimestre) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select r from RespostaAvaliacaoDocente r "
				+ "where r.bimestre = :bimestre order by r.item.grupo.id, "
				+ "r.item.id  ");
		query.setParameter("bimestre", bimestre);
		
		return query.list();
	}

}
