package ifrn.etep.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

@ContextConfiguration("classpath:applicationContext.xml")
public class DAORespostaItemAvaliacaoTest extends AbstractTransactionalJUnit4SpringContextTests{
	
	@Autowired
	protected DAORespostaItemAvaliacao daoResposta;
	
	@Autowired
	protected DAOBimesteLetivo daoBimestre;
	
	@Test
	public void testGetDaAvaliacaoDocente(){
		daoResposta.getDaAvaliacaoDocente(daoBimestre.getBimestreCorrente());
	}
}
