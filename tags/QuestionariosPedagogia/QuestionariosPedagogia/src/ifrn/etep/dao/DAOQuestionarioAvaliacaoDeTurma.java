package ifrn.etep.dao;

import ifrn.etep.dominio.BimestreLetivo;
import ifrn.etep.dominio.QuestionarioAvaliacaoDeTurma;
import ifrn.etep.dominio.RepositorioQuestionarioAvaliacaoDeTurma;
import ifrn.etep.dominio.RespostaUsuarioDaTurma;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DAOQuestionarioAvaliacaoDeTurma implements RepositorioQuestionarioAvaliacaoDeTurma{
	
	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFectory){
		this.sessionFactory = sessionFectory;
	}
	
	@Autowired
	private DAOBimesteLetivo daoBimestreLetivo;

	@Override
	public void insert(QuestionarioAvaliacaoDeTurma questionario) {
		Session session =  sessionFactory.getCurrentSession();
		session.save(questionario);
		
	}

	@Override
	public void delete(Integer idQuestionario) {
		Session session = sessionFactory.getCurrentSession();
		QuestionarioAvaliacaoDeTurma q = (QuestionarioAvaliacaoDeTurma) session.get(QuestionarioAvaliacaoDeTurma.class, idQuestionario);
		session.delete(q);
	}

	@Override
	public void update(QuestionarioAvaliacaoDeTurma questionario) {
		Session session = sessionFactory.getCurrentSession();
		session.update(questionario);
		
	}

	@Override
	public List<QuestionarioAvaliacaoDeTurma> getAll() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select q from QuestionarioAvaliacaoDeTurma q");
		return query.list();
	}
	
	@Override
	public QuestionarioAvaliacaoDeTurma getPorId(Integer idQuestionario) {
		Session session = sessionFactory.getCurrentSession();
		return (QuestionarioAvaliacaoDeTurma) session.get(QuestionarioAvaliacaoDeTurma.class, idQuestionario);
	}
	
	@Override
	public void salvarRespostas(List<RespostaUsuarioDaTurma> respostas){
		Session session = sessionFactory.getCurrentSession();
		for(RespostaUsuarioDaTurma r : respostas){
			session.save(r);
		}
	}

	@Override
	public QuestionarioAvaliacaoDeTurma getDoBimestreCorente() {
		BimestreLetivo bimestreCorrente = daoBimestreLetivo.getBimestreCorente();
		
		return bimestreCorrente.getModeloAvaliacaoDeTurma();
	}
}
