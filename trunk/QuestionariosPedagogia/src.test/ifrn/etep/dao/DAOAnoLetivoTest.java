package ifrn.etep.dao;

import ifrn.etep.dominio.AnoLetivo;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

@ContextConfiguration("classpath:applicationContext.xml")
public class DAOAnoLetivoTest extends AbstractTransactionalJUnit4SpringContextTests{
	
	@Autowired
	protected DAOAnoLetivo daoAnoLetivo;
	
	@Test
	public void testGetAnoCorrente(){
		AnoLetivo semestre = daoAnoLetivo.getAnoCorrente();
		Assert.assertEquals(1, semestre.getId().intValue());
	}
}
