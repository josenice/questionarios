package ifrn.etep.dao;

import ifrn.etep.dominio.BimestreLetivo;
import ifrn.etep.dominio.ItemAvaliacao;
import ifrn.etep.dominio.QuestionarioAvaliacaoTurma;
import ifrn.etep.dominio.RepositorioQuestionarioAvaliacaoTurma;
import ifrn.etep.dominio.RespostaAvaliacaoTurma;

import java.util.Comparator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DAOQuestionarioAvaliacaoTurma implements RepositorioQuestionarioAvaliacaoTurma{
	
	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFectory){
		this.sessionFactory = sessionFectory;
	}
	
	@Autowired
	private DAOBimesteLetivo daoBimestreLetivo;

	@Override
	public void insert(QuestionarioAvaliacaoTurma questionario) {
		Session session =  sessionFactory.getCurrentSession();
		session.save(questionario);
		
	}

	@Override
	public void delete(Integer idQuestionario) {
		Session session = sessionFactory.getCurrentSession();
		QuestionarioAvaliacaoTurma q = (QuestionarioAvaliacaoTurma) session.get(QuestionarioAvaliacaoTurma.class, idQuestionario);
		session.delete(q);
	}

	@Override
	public void update(QuestionarioAvaliacaoTurma questionario) {
		Session session = sessionFactory.getCurrentSession();
		session.update(questionario);
		
	}

	@Override
	public List<QuestionarioAvaliacaoTurma> getAll() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select q from QuestionarioAvaliacaoDeTurma q");
		return query.list();
	}
	
	@Override
	public QuestionarioAvaliacaoTurma getPorId(Integer idQuestionario) {
		Session session = sessionFactory.getCurrentSession();
		return (QuestionarioAvaliacaoTurma) session.get(QuestionarioAvaliacaoTurma.class, idQuestionario);
	}
	
	@Override
	public void salvarRespostas(List<RespostaAvaliacaoTurma> respostas){
		Session session = sessionFactory.getCurrentSession();
		for(RespostaAvaliacaoTurma r : respostas){
			session.save(r);
		}
	}

	@Override
	public QuestionarioAvaliacaoTurma getDoBimestreCorente() {
		BimestreLetivo bimestreCorrente = daoBimestreLetivo.getBimestreCorrente();
		QuestionarioAvaliacaoTurma questionario = bimestreCorrente.getQuestionarioAvaliacaoDeTurma();
		Hibernate.initialize(questionario.getItens());
		questionario.getItens().sort(new Comparator<ItemAvaliacao>() {
			@Override
			public int compare(ItemAvaliacao item1, ItemAvaliacao item2) {
				return item1.getId() - item2.getId();
			}
		});
		
		return questionario;
	}
}
