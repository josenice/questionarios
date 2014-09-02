package ifrn.etep.relatorios;

import java.util.Scanner;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

import org.junit.AfterClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

@ContextConfiguration("classpath:applicationContext.xml")
public class RelatoriosTest extends AbstractTransactionalJUnit4SpringContextTests{
	
	@Autowired
	private Relatorios relatorios;
	
	@Test
	public void testAvaliacaoDocente() throws JRException{
		JasperPrint jasperPrint = relatorios.avaliacaoDocente();
		JasperViewer.viewReport(jasperPrint, true);
	}
	
	@AfterClass
	public static void afterClass(){
		Scanner s = new Scanner(System.in);
		s.nextLine();
	}
}
