package ifrn.etep.mb;

import ifrn.etep.dominio.DiretoriaAcademica;
import ifrn.etep.dominio.ServiceDiretoriaAcademica;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;


@ManagedBean
@ViewScoped
public class DiretoriasMB implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<DiretoriaAcademica> diretorias;
	private DiretoriaAcademica diretoriaEmEdicao;
	
	
	public void setDiretoriaEmEdicao(DiretoriaAcademica diretoriaEmEdicao) {
		this.diretoriaEmEdicao = diretoriaEmEdicao;
	}
	public DiretoriaAcademica getDiretoriaEmEdicao() {
		return diretoriaEmEdicao;
	}
	public List<DiretoriaAcademica> getDiretorias() {
		return diretorias;
	}
	
	@ManagedProperty("#{serviceDiretoriaAcademica}")
	private ServiceDiretoriaAcademica service;
	public void setService(ServiceDiretoriaAcademica service) {
		this.service = service;
	}

	@PostConstruct
	public void init(){
		carregarDiretorias();
		diretoriaEmEdicao = new DiretoriaAcademica();
		
	}
	
	private void carregarDiretorias(){
		diretorias = service.getTodas();
	}
		
	public void salvarDiretoria(){
		String msg = null;
		try{
			if(diretoriaEmEdicao.getId() == null){
				service.cadastrarDiretoria(diretoriaEmEdicao);
				diretorias.add(diretoriaEmEdicao);
				diretoriaEmEdicao = new DiretoriaAcademica();
				msg = "Diretoria cadastrada com sucesso";
			}
			else{
				service.atualizarDiretoria(diretoriaEmEdicao);
				diretoriaEmEdicao = new DiretoriaAcademica();
				msg = "Diretoria atualizada com sucesso";
				
			}
		}catch(Exception ex){
			ex.printStackTrace();
			msg = "Ocorreu um erro";
		}
		
		FacesContext ctx = FacesContext.getCurrentInstance();
		ctx.addMessage(null, new FacesMessage(msg));
		
		/*return "diretorias.jsf?faces-redirect=true";*/
	}
	
	public void cancelar(){
		diretoriaEmEdicao = new DiretoriaAcademica();
	}

	public void excluir(){
		String msg = null;
		try{
			service.excluirDiretoria(diretoriaEmEdicao.getId());
			carregarDiretorias();
			msg = "Diretoria excluída com sucesso";
		}catch(Exception ex){
			ex.printStackTrace();
			msg = "Ocorreu um erro";
		}
		
		FacesContext ctx = FacesContext.getCurrentInstance();
		ctx.addMessage(null, new FacesMessage(msg));
	}
	
	
}
