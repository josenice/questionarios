package ifrn.etep.dao;

import ifrn.etep.dominio.BimestreLetivo;
import ifrn.etep.dominio.ItemAvaliacao;
import ifrn.etep.dominio.QuestionarioAutoAvaliacaoDocente;
import ifrn.etep.dominio.RepositorioQuestionarioAutoAvaliacaoDocente;
import ifrn.etep.dominio.RespostaAutoAvaliacaoDocente;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DAOQuestionarioAutoAvaliacaoDocente implements RepositorioQuestionarioAutoAvaliacaoDocente{
	
	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Autowired
	private DAOBimesteLetivo daoBimestreLetivo;
	
	@Override
	public void insert(QuestionarioAutoAvaliacaoDocente questionario) {
		Session session =  sessionFactory.getCurrentSession();
		session.save(questionario);
		
	}

	@Override
	public void delete(Integer idQuestionario) {
		Session session = sessionFactory.getCurrentSession();
		QuestionarioAutoAvaliacaoDocente q = (QuestionarioAutoAvaliacaoDocente) session.get(QuestionarioAutoAvaliacaoDocente.class, idQuestionario);
		session.delete(q);
		
	}

	@Override
	public void update(QuestionarioAutoAvaliacaoDocente questionario) {
		Session session = sessionFactory.getCurrentSession();
		session.update(questionario);
		
	}
	@Override
	public List<QuestionarioAutoAvaliacaoDocente> getAll() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select q from QuestionarioDeAutoAvaliacao q");
		return query.list();
	}
	@Override
	public QuestionarioAutoAvaliacaoDocente getPorId(Integer idQuestionario) {
		Session session = sessionFactory.getCurrentSession();
		return (QuestionarioAutoAvaliacaoDocente) session.get(QuestionarioAutoAvaliacaoDocente.class, idQuestionario);
	}
	
	@Override
	public void salvarRespostas(List<RespostaAutoAvaliacaoDocente> respostas){
		Session session = sessionFactory.getCurrentSession();
		for(RespostaAutoAvaliacaoDocente r : respostas){
			session.save(r);
		}
	}
		
		@Override
			public QuestionarioAutoAvaliacaoDocente getDoBimestreCorrente() {
			BimestreLetivo bimestreCorrente = daoBimestreLetivo.getBimestreCorrente();
			QuestionarioAutoAvaliacaoDocente questionario = bimestreCorrente.getModeloAutoAvaliacaoDocente();
			Hibernate.initialize(questionario.getItens());
			Collections.sort(questionario.getItens(), new Comparator<ItemAvaliacao>() {
				@Override
				public int compare(ItemAvaliacao item1, ItemAvaliacao item2) {
					return item1.getId() - item2.getId();
				}
			});
			
			return questionario;
		}

		@Override
		public boolean isAutoAvaliacaoRespondida(Integer idUsuario) {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("select r From RespostaUsuarioAutoAvaliacao r " +
					"where r.bimestreAvaliado = :bimestre and r.id = :idUsuario");
			query.setParameter("bimestre", daoBimestreLetivo.getBimestreCorrente());
			query.setParameter("idUsuario", idUsuario);
			List l = query.list();
			if(l == null || l.isEmpty()){
				return false;
			}
			else{
				return true;
			}
		}

}
