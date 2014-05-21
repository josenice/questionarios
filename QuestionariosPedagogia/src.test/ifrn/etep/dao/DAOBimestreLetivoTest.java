package ifrn.etep.dao;

import ifrn.etep.dominio.BimestreLetivo;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

@ContextConfiguration("classpath:applicationContext.xml")
public class DAOBimestreLetivoTest extends AbstractTransactionalJUnit4SpringContextTests{
	
	@Autowired
	protected DAOBimesteLetivo daoBimestre;
	
	@Test
	public void testGetBimestreCorrente(){
		BimestreLetivo bimestre = daoBimestre.getBimestreCorrente();
		Assert.assertEquals(1, bimestre.getId().intValue());
	}
}
