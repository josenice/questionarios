package ifrn.etep.dao;

import ifrn.etep.dominio.Professor;
import ifrn.etep.dominio.RepositorioProfessor;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DAOProfessor implements RepositorioProfessor{
	
	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory (SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Autowired
	private DAOBimesteLetivo daoBimestreLetivo;

	@Override
	public void insert(Professor professor) {
		Session session = sessionFactory.getCurrentSession();
		session.save(professor);
		
	}

	@Override
	public void delete(Integer idProfessor) {
		Session session = sessionFactory.getCurrentSession();
		Professor p = (Professor) session.get(Professor.class, idProfessor);
		session.delete(p);
		
	}

	@Override
	public void update(Professor professor) {
		Session session = sessionFactory.getCurrentSession();
		session.update(professor);
		
	}

	@Override
	public Professor getPorId(Integer idProfessor){
		Session session = sessionFactory.getCurrentSession();
		return (Professor) session.get(Professor.class, idProfessor);
	}

	@Override
	public List<Professor> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Professor> getProfessoresNaoAvaliadosPorAluno(Integer idAluno) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
