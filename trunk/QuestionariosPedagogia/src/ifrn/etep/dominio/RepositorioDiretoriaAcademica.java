package ifrn.etep.dominio;

import java.util.List;

public interface RepositorioDiretoriaAcademica {
    
    void insert(DiretoriaAcademica diretoria);
    
    void delete(Integer idDiretoria);
    
    void update(DiretoriaAcademica diretoria);
    
    List<DiretoriaAcademica> getAll();

}
