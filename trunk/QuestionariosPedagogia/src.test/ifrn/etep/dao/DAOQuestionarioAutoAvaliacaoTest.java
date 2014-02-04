package ifrn.etep.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;


@ContextConfiguration("classpath:applicationContext.xml")
public class DAOQuestionarioAutoAvaliacaoTest extends AbstractTransactionalJUnit4SpringContextTests {
	@Autowired
	protected DAOQuestionarioAutoAvaliacao daoQuestionarioAutoAvaliacao;
	
	@Test
	public void testIsAutoAvaliacaoRespondida(){
		boolean resultado = daoQuestionarioAutoAvaliacao.isAutoAvaliacaoRespondida(1);
		Assert.assertFalse(resultado);
	}
	

}
