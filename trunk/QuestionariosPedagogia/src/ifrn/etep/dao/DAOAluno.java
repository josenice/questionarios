package ifrn.etep.dao;

import ifrn.etep.dominio.Aluno;
import ifrn.etep.dominio.RepositorioAluno;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DAOAluno implements RepositorioAluno{
	
	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory (SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	
	@Autowired
	private DAOBimesteLetivo daoBimestreLetivo;

	@Override
	public void insert(Aluno aluno) {
		Session session = sessionFactory.getCurrentSession();
		session.save(aluno);
		
	}

	@Override
	public void delete(Integer idAluno) {
		Session session = sessionFactory.getCurrentSession();
		Aluno a = (Aluno) session.get(Aluno.class, idAluno);
		session.delete(a);
		
	}

	@Override
	public void update(Aluno aluno) {
		Session session = sessionFactory.getCurrentSession();
		session.update(aluno);
		
	}

	@Override
	public Aluno getPorId(Integer idAluno){
		Session session = sessionFactory.getCurrentSession();
		return (Aluno) session.get(Aluno.class, idAluno);
	}

	@Override
	public List<Aluno> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Aluno> getAlunosNaoAvaliadosPorProfessor(Integer idProfessor) {
		// TODO Auto-generated method stub
		return null;
	}


}
