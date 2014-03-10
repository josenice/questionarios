package ifrn.etep.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ifrn.etep.dominio.RepositorioUsuario;
import ifrn.etep.dominio.Professor;
@Repository
public class DAOUsuario implements RepositorioUsuario{
	
	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Autowired
	private DAOBimesteLetivo daoBimestreLetivo;

	@Override
	public void insert(Professor usuario) {
		Session session = sessionFactory.getCurrentSession();
		session.save(usuario);
	}

	@Override
	public void update(Professor usuario) {
		Session session = sessionFactory.getCurrentSession();
		session.update(usuario);
	}

	@Override
	public void delete(Integer idUsuario) {
		Session session = sessionFactory.getCurrentSession();
		Professor u = (Professor) session.get(Professor.class, idUsuario);
		session.delete(u);
		
	}

	@Override
	public Professor getPorId(Integer idUsuario) {
		Session session = sessionFactory.getCurrentSession();
		return (Professor) session.get(Professor.class, idUsuario);
	}

	@Override
	public List<Professor> getAll() {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("select u from Usuario u");
		return query.list();
	}

		
	/*public List<TurmaSeriada> getUsuariosNaoAvaliados(Integer idUsuario) {
		// TODO Auto-generated method stub
		return null;*/
	}


