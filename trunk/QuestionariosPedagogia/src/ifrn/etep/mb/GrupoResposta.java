package ifrn.etep.mb;

import ifrn.etep.dominio.GrupoItemAvaliacao;
import ifrn.etep.dominio.RespostaItemAvaliacao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class GrupoResposta implements Serializable{

	private static final long serialVersionUID = 1L;
	private List<RespostaItemAvaliacao> respostas = new ArrayList<>();
	private GrupoItemAvaliacao grupo;
	
	public GrupoResposta(GrupoItemAvaliacao grupo) {
		this.grupo = grupo;
	}

	public GrupoItemAvaliacao getGrupoItemAvaliacao() {
		return grupo;  
	}

	public List<RespostaItemAvaliacao> getRespostas() {
		return respostas;
	}
	
	public static List<GrupoResposta> gerarGruposResposta(List<? extends RespostaItemAvaliacao> respostas){
		List<GrupoResposta> gruposRespostas = new ArrayList<GrupoResposta>();
		HashMap<GrupoItemAvaliacao, GrupoResposta> mapaGrupos = new LinkedHashMap<>();
		for(RespostaItemAvaliacao resposta : respostas){
			GrupoItemAvaliacao grupoItem = resposta.getItem().getGrupo();
			GrupoResposta grupoResposta = mapaGrupos.get(grupoItem);
			if(grupoResposta == null){
				grupoResposta = new GrupoResposta(grupoItem);
				mapaGrupos.put(grupoItem, grupoResposta);
				gruposRespostas.add(grupoResposta);
			}
			grupoResposta.getRespostas().add(resposta);
		}
		
		return gruposRespostas;
	}
}