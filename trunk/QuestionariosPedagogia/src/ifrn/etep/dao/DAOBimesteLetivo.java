package ifrn.etep.dao;

import ifrn.etep.dominio.BimestreLetivo;
import ifrn.etep.dominio.AnoLetivo;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DAOBimesteLetivo{
        
        @Autowired
        private SessionFactory sessionFactory;
        public void setSessionFactory(SessionFactory sessionFactory){
                this.sessionFactory = sessionFactory;
        }
        
        @Autowired
        private DAOAnoLetivo daoSemestre;

        public BimestreLetivo getBimestreCorrente() {
                AnoLetivo anoCorrente = daoSemestre.getAnoCorrente();
                Session session = sessionFactory.getCurrentSession();
                Query query = session.createQuery("select b from BimestreLetivo b " +
                                "where b.ano = :s " +
                                "and b.ano =(select max(b2.bimestre) from BimestreLetivo b2)");
                query.setParameter("s", anoCorrente);
                return (BimestreLetivo)query.uniqueResult();
        }
}
