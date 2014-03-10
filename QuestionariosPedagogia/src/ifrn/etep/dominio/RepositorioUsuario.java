package ifrn.etep.dominio;

import java.util.List;

public interface RepositorioUsuario {
	
	void insert (Professor usuario);
	void update (Professor usuario);
	void delete(Integer idUsuario);
	Professor getPorId(Integer idUsuario);
	List<Professor>getAll();
	
	

}
