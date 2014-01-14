package ifrn.etep.dominio;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Component
@Scope(proxyMode=ScopedProxyMode.TARGET_CLASS)
@Transactional(propagation=Propagation.REQUIRED)
public class ServiceTurma {

	public TurmaSeriada getPorId(Integer idTurma) {
		// TODO
		TurmaSeriada t = new TurmaSeriada();
		t.setId(1);
		t.setCodigoSistemaAcademico("20132.4404");
		return t;
	}

}
