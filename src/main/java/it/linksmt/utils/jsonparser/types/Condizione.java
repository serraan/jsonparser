package it.linksmt.utils.jsonparser.types;

import java.util.List;

public class Condizione {

	private String codice;
	private List<Attributo> attributi;

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public List<Attributo> getAttributi() {
		return attributi;
	}

	public void setAttributi(List<Attributo> attributi) {
		this.attributi = attributi;
	}

}
