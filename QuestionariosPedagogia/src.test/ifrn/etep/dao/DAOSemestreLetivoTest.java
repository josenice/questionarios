package ifrn.etep.dao;

import ifrn.etep.dominio.SemestreLetivo;
import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

@ContextConfiguration("classpath:applicationContext.xml")
public class DAOSemestreLetivoTest extends AbstractTransactionalJUnit4SpringContextTests{
	
	@Autowired
	protected DAOSemestreLetivo daoSemestre;
	
	@Test
	public void testGetSemestreCorrente(){
		SemestreLetivo semestre = daoSemestre.getSemestreCorente();
		Assert.assertEquals(1, semestre.getId().intValue());
	}
}
