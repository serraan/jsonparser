package it.linksmt.utils.jsonparser.types;

import java.util.List;

public class Aggregato {

	private String nome;
	private List<Condizione> condizioni;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Condizione> getCondizioni() {
		return condizioni;
	}

	public void setCondizioni(List<Condizione> condizioni) {
		this.condizioni = condizioni;
	}

}
