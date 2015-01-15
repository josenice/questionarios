package ifrn.etep.mb;

import java.io.Serializable;

import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;


import org.springframework.beans.factory.support.SecurityContextProvider;
import org.springframework.stereotype.Controller;

import ifrn.etep.dominio.ServiceUsuario;
import ifrn.etep.dominio.ServiceProfessor;
import ifrn.etep.dominio.Usuario;

@ManagedBean
@ViewScoped
public class UsuarioMB implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	
	public UsuarioMB(){
		usuario = new Usuario();
		//SecurityContextProvider context = SecurityContextProvider.get();
		//if();
			
		}
	}


