package ifrn.etep.mb;

import ifrn.etep.dominio.Usuario;

import java.io.Serializable;

import javax.annotation.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

@ManagedBean
@ViewScoped
public class UsuarioMB implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Usuario usuario;
	
	
	public UsuarioMB() {
        usuario = new Usuario();
        SecurityContext context = SecurityContextHolder.getContext();
        if (context instanceof SecurityContext){
            Authentication authentication = context.getAuthentication();
            if (authentication instanceof Authentication){
                usuario.setNome(((User)authentication.getPrincipal()).getUsername());
            }
        }
    }

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}




