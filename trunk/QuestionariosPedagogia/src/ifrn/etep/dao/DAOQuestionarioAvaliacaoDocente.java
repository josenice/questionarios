package ifrn.etep.dao;

import ifrn.etep.dominio.BimestreLetivo;
import ifrn.etep.dominio.ItemAvaliacao;
import ifrn.etep.dominio.QuestionarioAvaliacaoDocente;
import ifrn.etep.dominio.RepositorioQuestionarioAvaliacaoDocente;
import ifrn.etep.dominio.RespostaAvaliacaoDocente;

import java.util.Comparator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DAOQuestionarioAvaliacaoDocente implements RepositorioQuestionarioAvaliacaoDocente{
	
	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFectory){
		this.sessionFactory = sessionFectory;
	}
	
	@Autowired
	private DAOBimesteLetivo daoBimestreLetivo;

	@Override
	public void insert(QuestionarioAvaliacaoDocente questionario) {
		Session session =  sessionFactory.getCurrentSession();
		session.save(questionario);
		
	}

	@Override
	public void delete(Integer idQuestionario) {
		Session session = sessionFactory.getCurrentSession();
		QuestionarioAvaliacaoDocente q = (QuestionarioAvaliacaoDocente) session.get(QuestionarioAvaliacaoDocente.class, idQuestionario);
		session.delete(q);
	}

	@Override
	public void update(QuestionarioAvaliacaoDocente questionario) {
		Session session = sessionFactory.getCurrentSession();
		session.update(questionario);
		
	}

	@Override
	public List<QuestionarioAvaliacaoDocente> getAll() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select q from QuestionarioAvaliacaoDocente q");
		return query.list();
	}
	
	@Override
	public QuestionarioAvaliacaoDocente getPorId(Integer idQuestionario) {
		Session session = sessionFactory.getCurrentSession();
		return (QuestionarioAvaliacaoDocente) session.get(QuestionarioAvaliacaoDocente.class, idQuestionario);
	}
	
	@Override
	public void salvarRespostas(List<RespostaAvaliacaoDocente> respostas){
		Session session = sessionFactory.getCurrentSession();
		for(RespostaAvaliacaoDocente r : respostas){
			session.save(r);
		}
	}

	@Override
	public QuestionarioAvaliacaoDocente getDoBimestreCorente() {
		BimestreLetivo bimestreCorrente = daoBimestreLetivo.getBimestreCorrente();
		QuestionarioAvaliacaoDocente questionario = bimestreCorrente.getQuestionarioAvaliacaoDocente();
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
