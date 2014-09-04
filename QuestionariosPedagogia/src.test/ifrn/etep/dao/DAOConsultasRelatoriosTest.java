package ifrn.etep.dao;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

@ContextConfiguration("classpath:applicationContext.xml")
public class DAOConsultasRelatoriosTest extends AbstractTransactionalJUnit4SpringContextTests{
	
	@Autowired
	protected DAOConsultasRelatorios daoResposta;
	
	@Autowired
	protected DAOBimesteLetivo daoBimestre;
	
	@Test
	public void testGetRegistros(){
		List<Object[]> registros = daoResposta.getRegistros(daoBimestre.getBimestreCorrente());
		for(Object[] r : registros){
			for(int i = 0; i < r.length; i++){
				System.out.print(r[i] + " | ");
			}
			System.out.println("");
		}
	}
}
