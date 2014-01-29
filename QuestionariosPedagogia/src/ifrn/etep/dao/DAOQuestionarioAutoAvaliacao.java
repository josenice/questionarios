package ifrn.etep.dao;

import ifrn.etep.dominio.QuestionarioDeAutoAvaliacao;
import ifrn.etep.dominio.RepositorioQuestionarioAutoAvaliacao;
import ifrn.etep.dominio.RespostaUsuarioAutoAvaliacao;
import ifrn.etep.dominio.SemestreLetivo;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DAOQuestionarioAutoAvaliacao implements RepositorioQuestionarioAutoAvaliacao{
	
	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	@Autowired
	private DAOSemesteLetivo daoSemestreLetivo;

	@Override
	public void insert(QuestionarioDeAutoAvaliacao questionario) {
		Session session =  sessionFactory.getCurrentSession();
		session.save(questionario);
		
	}

	@Override
	public void delete(Integer idQuestionario) {
		Session session = sessionFactory.getCurrentSession();
		QuestionarioDeAutoAvaliacao q = (QuestionarioDeAutoAvaliacao) session.get(QuestionarioDeAutoAvaliacao.class, idQuestionario);
		session.delete(q);
		
	}

	@Override
	public void update(QuestionarioDeAutoAvaliacao questionario) {
		Session session = sessionFactory.getCurrentSession();
		session.update(questionario);
		
	}
	@Override
	public List<QuestionarioDeAutoAvaliacao> getAll() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select q from QuestionarioDeAutoAvaliacao q");
		return query.list();
	}
	@Override
	public QuestionarioDeAutoAvaliacao getPorId(Integer idQuestionario) {
		Session session = sessionFactory.getCurrentSession();
		return (QuestionarioDeAutoAvaliacao) session.get(QuestionarioDeAutoAvaliacao.class, idQuestionario);
	}
	
	@Override
	public void salvarRespostas(List<RespostaUsuarioAutoAvaliacao> respostas){
		Session session = sessionFactory.getCurrentSession();
		for(RespostaUsuarioAutoAvaliacao r : respostas){
			session.save(r);
		}
	}
		
		@Override
		public QuestionarioDeAutoAvaliacao getDoSemestreCorrente() {
			SemestreLetivo semestreCorrente = daoSemestreLetivo.getSemestreCorente();
			
			return semestreCorrente.getModeloAutoAvaliacao();
		}

		@Override
		public boolean semAutoAvaliacao(Integer idUsuario) {
			Session session = sessionFactory.getCurrentSession();
			return semAutoAvaliacao(idUsuario);
		}

}
