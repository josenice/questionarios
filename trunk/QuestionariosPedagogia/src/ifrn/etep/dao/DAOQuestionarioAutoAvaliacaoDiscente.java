package ifrn.etep.dao;

import ifrn.etep.dominio.BimestreLetivo;
import ifrn.etep.dominio.ItemAvaliacao;
import ifrn.etep.dominio.QuestionarioAutoAvaliacaoDiscente;
import ifrn.etep.dominio.RepositorioQuestionarioAutoAvaliacaoDiscente;
import ifrn.etep.dominio.RespostaAutoAvaliacaoDiscente;

import java.util.Comparator;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DAOQuestionarioAutoAvaliacaoDiscente implements RepositorioQuestionarioAutoAvaliacaoDiscente{
	
	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Autowired
	private DAOBimesteLetivo daoBimestreLetivo;
	
	@Override
	public void insert(QuestionarioAutoAvaliacaoDiscente questionario) {
		Session session =  sessionFactory.getCurrentSession();
		session.save(questionario);
		
	}

	@Override
	public void delete(Integer idQuestionario) {
		Session session = sessionFactory.getCurrentSession();
		QuestionarioAutoAvaliacaoDiscente q = (QuestionarioAutoAvaliacaoDiscente) session.get(QuestionarioAutoAvaliacaoDiscente.class, idQuestionario);
		session.delete(q);
		
	}

	@Override
	public void update(QuestionarioAutoAvaliacaoDiscente questionario) {
		Session session = sessionFactory.getCurrentSession();
		session.update(questionario);
		
	}
	@Override
	public List<QuestionarioAutoAvaliacaoDiscente> getAll() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select q from QuestionarioDeAutoAvaliacao q");
		return query.list();
	}
	@Override
	public QuestionarioAutoAvaliacaoDiscente getPorId(Integer idQuestionario) {
		Session session = sessionFactory.getCurrentSession();
		return (QuestionarioAutoAvaliacaoDiscente) session.get(QuestionarioAutoAvaliacaoDiscente.class, idQuestionario);
	}
	
	@Override
	public void salvarRespostas(List<RespostaAutoAvaliacaoDiscente> respostas){
		Session session = sessionFactory.getCurrentSession();
		for(RespostaAutoAvaliacaoDiscente r : respostas){
			session.save(r);
		}
	}
		
		@Override
		public QuestionarioAutoAvaliacaoDiscente getDoBimestreCorrente() {
			BimestreLetivo bimestreCorrente = daoBimestreLetivo.getBimestreCorrente();
			QuestionarioAutoAvaliacaoDiscente questionario = bimestreCorrente.getModeloAutoAvaliacaoDiscente();
			Hibernate.initialize(questionario.getItens());
			questionario.getItens().sort(new Comparator<ItemAvaliacao>() { //alteração aqui
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
