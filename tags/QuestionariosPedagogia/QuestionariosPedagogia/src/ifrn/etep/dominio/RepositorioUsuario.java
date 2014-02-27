package ifrn.etep.dominio;

import java.util.List;

public interface RepositorioUsuario {
	
	void insert (Usuario usuario);
	void update (Usuario usuario);
	void delete(Integer idUsuario);
	Usuario getPorId(Integer idUsuario);
	List<Usuario>getAll();
	
	

}
