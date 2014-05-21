package ifrn.etep.dao;

import ifrn.etep.dominio.TurmaSeriada;

import java.util.List;



import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

@ContextConfiguration("classpath:applicationContext.xml")
public class DAOTurmaTest extends AbstractTransactionalJUnit4SpringContextTests{
	
	@Autowired
	protected DAOTurma daoTurma;
	
	@Test
	public void testGetTurmasNaoAvaliadasPorProfessor(){
		List<TurmaSeriada> turmas = daoTurma.getTurmasNaoAvaliadasPorProfessor(1);
		Assert.assertEquals(3, turmas.size());
		
		/*turmas = daoTurma.getTurmasNaoAvaliadasPorProfessor(2);
		Assert.assertEquals(1, turmas.size());*/
	}
}
