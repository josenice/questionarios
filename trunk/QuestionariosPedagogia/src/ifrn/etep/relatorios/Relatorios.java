/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ifrn.etep.relatorios;

import ifrn.etep.dao.DAOBimesteLetivo;
import ifrn.etep.dao.DAOConsultasRelatorios;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.ListOfArrayDataSource;
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRHtmlExporterParameter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.engine.util.JRLoader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
public class Relatorios {

	private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

	@Autowired
	private DAOConsultasRelatorios daoResposta;

	@Autowired
	private DAOBimesteLetivo daoBimestreLetivo;

	@Transactional(propagation = Propagation.REQUIRED)
	public JasperPrint avaliacaoDocente() throws JRException {

		JasperReport jReport = getRelatorio("avaliacao_docente.jasper");
		List<Object[]> registros = daoResposta
				.getRegistrosAvaliacaoDocente(daoBimestreLetivo
						.getBimestreCorrente());
		Map<String, Object> params = new HashMap<String, Object>();

		String[] titulos = { "MATRICULA", "NOME", "GRUPO_ID",
				"GRUPO_DESCRICAO", "ITEM_AVALIACAO_ID", "ITEM_AVALIACAO_TEXTO",
				"FREQUENCIA", "CONTAGEM" };
		JRDataSource dataSource = new ListOfArrayDataSource(registros, titulos);
		JasperPrint jPrint = JasperFillManager.fillReport(jReport, params,
				dataSource);

		return jPrint;
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public JasperPrint avaliacaoTurma() throws JRException {
		JasperReport jReport = getRelatorio("avaliacao_turma.jasper");
		List<Object[]> registrosDoDAO = daoResposta
				.getRegistrosAvaliacaoTurma(daoBimestreLetivo
						.getBimestreCorrente());
		Map<String, Object> params = new HashMap<String, Object>();

		String[] titulos = {"CODIGOSISTEMAACADEMICO", "GRUPO_ID",
				"GRUPO_DESCRICAO", "ITEM_AVALIACAO_ID", "ITEM_AVALIACAO_TEXTO",
				"FREQUENCIA", "CONTAGEM" , "FREQUENCIA_TEXTO"};
		
		List<Object[]> registrosDoRelatorio = new ArrayList<Object[]>();
		for(Object[] rDAO : registrosDoDAO){
			int n = rDAO.length;
			Object[] rRelatorio = new Object[n + 1];
			for(int i = 0; i < n; i++){
				rRelatorio[i] = rDAO[i];
			}
			rRelatorio[7] = getFrequenciaAsString(Integer.parseInt((String)rDAO[5]));
			registrosDoRelatorio.add(rRelatorio);
		}
		
		JRDataSource dataSource = new ListOfArrayDataSource(registrosDoRelatorio, titulos);
		JasperPrint jPrint = JasperFillManager.fillReport(jReport, params,
				dataSource);

		return jPrint;
	}
	@Transactional(propagation = Propagation.REQUIRED)
	public JasperPrint autoAvaliacaoDocente() throws JRException {
		JasperReport jReport = getRelatorio("autoAvaliacao_docente.jasper");
		List<Object[]> registros = daoResposta
				.getRegistrosAutoAvaliacaoDocente(daoBimestreLetivo
						.getBimestreCorrente());
		Map<String, Object> params = new HashMap<String, Object>();

		String[] titulos = { "MATRICULA", "NOME", "GRUPO_ID",
				"GRUPO_DESCRICAO", "ITEM_AVALIACAO_ID", "ITEM_AVALIACAO_TEXTO",
				"FREQUENCIA", "CONTAGEM"  };
		JRDataSource dataSource = new ListOfArrayDataSource(registros, titulos);
		JasperPrint jPrint = JasperFillManager.fillReport(jReport, params,
				dataSource);

		return jPrint;
	}
	@Transactional(propagation = Propagation.REQUIRED)
	public JasperPrint AvaliacaoTurmaDiretoria() throws JRException {
		JasperReport jReport = getRelatorio("Avaliacao_turma.jasper");
		List<Object[]> registros = daoResposta
				.getRegistrosAutoAvaliacaoDocente(daoBimestreLetivo
						.getBimestreCorrente());
		Map<String, Object> params = new HashMap<String, Object>();

		String[] titulos = { "ID", "DIRETORIA", "NOME"  };
		JRDataSource dataSource = new ListOfArrayDataSource(registros, titulos);
		JasperPrint jPrint = JasperFillManager.fillReport(jReport, params,
				dataSource);

		return jPrint;
	}
	// retorna um relat√≥rio a partir do seu nome de arquivo
	private JasperReport getRelatorio(String nomeRelatorio) throws JRException {
		JasperReport relatorio = (JasperReport) JRLoader
				.loadObject(Relatorios.class.getResourceAsStream(nomeRelatorio));
		return relatorio;
	}

	public InputStream paraPDF(JasperPrint jasperPrint) throws JRException {
		JRExporter pdfExporter = new JRPdfExporter();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		pdfExporter.setParameter(JRExporterParameter.OUTPUT_STREAM,
				outputStream);
		pdfExporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		pdfExporter.exportReport();

		return new ByteArrayInputStream(outputStream.toByteArray());
	}

	public InputStream paraHTML(JasperPrint jasperPrint) throws JRException {
		JRExporter htmlExporter = new JRHtmlExporter();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		htmlExporter.setParameter(JRExporterParameter.OUTPUT_STREAM,
				outputStream);
		htmlExporter
				.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
		htmlExporter
				.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN,
						Boolean.FALSE);
		htmlExporter.setParameter(
				JRHtmlExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,
				Boolean.TRUE);
		htmlExporter.setParameter(JRHtmlExporterParameter.CHARACTER_ENCODING,
				"ISO-8859-1");
		htmlExporter.exportReport();

		return new ByteArrayInputStream(outputStream.toByteArray());
	}

	public InputStream paraXLS(JasperPrint jasperPrint) throws JRException {
		JRExporter xlsExporter = new JRXlsxExporter();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		xlsExporter.setParameter(JRXlsExporterParameter.OUTPUT_STREAM,
				outputStream);
		xlsExporter.setParameter(JRXlsExporterParameter.JASPER_PRINT,
				jasperPrint);
		xlsExporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET,
				Boolean.TRUE);
		xlsExporter.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE,
				Boolean.TRUE);
		xlsExporter.setParameter(
				JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS,
				Boolean.TRUE);
		xlsExporter.setParameter(
				JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,
				Boolean.TRUE);
		xlsExporter.setParameter(
				JRXlsExporterParameter.IS_WHITE_PAGE_BACKGROUND, Boolean.FALSE);
		xlsExporter.exportReport();

		return new ByteArrayInputStream(outputStream.toByteArray());
	}
	
	private String getFrequenciaAsString(int frequencia){
		if(frequencia == 1)
			return "Sempre";
		else if(frequencia == 2)
			return "Quase sempre";
		else if(frequencia == 3)
			return "¿s vezes";
		else if(frequencia == 4)
			return "Nunca";
		
		throw new IllegalArgumentException("Frequencia deve estar entre 1 e 4: " + frequencia);
	}
}
