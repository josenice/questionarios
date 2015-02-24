package ifrn.etep.dao;

import ifrn.etep.dominio.BimestreLetivo;
import ifrn.etep.dominio.RespostaAvaliacaoTurma;

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
	public void testGetRegistrosAvaliacaoDocente(){
		List<Object[]> registros = daoResposta.getRegistrosAvaliacaoDocente(daoBimestre.getBimestreCorrente());
		for(Object[] r : registros){
			for(int i = 0; i < r.length; i++){
				System.out.print(r[i] + " | ");
			}
			System.out.println("");
		}
	}
	
	@Test
	public void testGetRegistrosAvaliacaoTurma(){
		BimestreLetivo bimestreCorrente = daoBimestre.getBimestreCorrente();
		List<Object[]> registros = daoResposta.getRegistrosAvaliacaoTurma(bimestreCorrente);
		System.out.println("REGISTROS\n---------");
		for(Object[] r : registros){
			for(int i = 0; i < r.length; i++){
				System.out.print(r[i] + " | ");
			}
			System.out.println("");
		}
	}
	@Test
	public void testGetAutoAvaliacaoDocente(){
		BimestreLetivo bimestreCorrente = daoBimestre.getBimestreCorrente();
		List<Object[]> registros = daoResposta.getRegistrosAutoAvaliacaoDocente(bimestreCorrente);
		System.out.println("REGISTROS\n---------");
		for(Object[] r : registros){
			for(int i = 0; i < r.length; i++){
				System.out.print(r[i] + " | ");
			}
			System.out.println("");
		}
	}
	/*@Test
	public void testGetAvaliacaoTurmaDiretoria(){
		BimestreLetivo bimestreCorrente = daoBimestre.getBimestreCorrente();
		List<Object[]> registros = daoResposta.getRegistrosAvaliacaoTurmaDiretoria(bimestreCorrente);
		System.out.println("REGISTROS\n---------");
		for(Object[] r : registros){
			for(int i = 0; i < r.length; i++){
				System.out.print(r[i] + " | ");
			}
			System.out.println("");
		}
	}*/
}
	
