package it.linksmt.utils.jsonparser.types;

import java.util.List;

public class CustodiaTitoli {

	private String chiaveServizio;
	private String codiceServizioAnagrafe;
	private String codiceFiliale;
	private String numeroRapporto;
	private String codicePartita;
	private String numeroDocumentoDiSintesi;
	private String annoDataDocumento;
	private String codiceProdottoTecnico;
	private String numeroVariazioni;
	private String famigliaTemplate;
	private List<Decorrenza> decorrenze;

	public String getChiaveServizio() {
		return chiaveServizio;
	}

	public void setChiaveServizio(String chiaveServizio) {
		this.chiaveServizio = chiaveServizio;
	}

	public String getCodiceServizioAnagrafe() {
		return codiceServizioAnagrafe;
	}

	public void setCodiceServizioAnagrafe(String codiceServizioAnagrafe) {
		this.codiceServizioAnagrafe = codiceServizioAnagrafe;
	}

	public String getCodiceFiliale() {
		return codiceFiliale;
	}

	public void setCodiceFiliale(String codiceFiliale) {
		this.codiceFiliale = codiceFiliale;
	}

	public String getNumeroRapporto() {
		return numeroRapporto;
	}

	public void setNumeroRapporto(String numeroRapporto) {
		this.numeroRapporto = numeroRapporto;
	}

	public String getCodicePartita() {
		return codicePartita;
	}

	public void setCodicePartita(String codicePartita) {
		this.codicePartita = codicePartita;
	}

	public String getNumeroDocumentoDiSintesi() {
		return numeroDocumentoDiSintesi;
	}

	public void setNumeroDocumentoDiSintesi(String numeroDocumentoDiSintesi) {
		this.numeroDocumentoDiSintesi = numeroDocumentoDiSintesi;
	}

	public String getAnnoDataDocumento() {
		return annoDataDocumento;
	}

	public void setAnnoDataDocumento(String annoDataDocumento) {
		this.annoDataDocumento = annoDataDocumento;
	}

	public String getCodiceProdottoTecnico() {
		return codiceProdottoTecnico;
	}

	public void setCodiceProdottoTecnico(String codiceProdottoTecnico) {
		this.codiceProdottoTecnico = codiceProdottoTecnico;
	}

	public String getNumeroVariazioni() {
		return numeroVariazioni;
	}

	public void setNumeroVariazioni(String numeroVariazioni) {
		this.numeroVariazioni = numeroVariazioni;
	}

	public String getFamigliaTemplate() {
		return famigliaTemplate;
	}

	public void setFamigliaTemplate(String famigliaTemplate) {
		this.famigliaTemplate = famigliaTemplate;
	}

	public List<Decorrenza> getDecorrenze() {
		return decorrenze;
	}

	public void setDecorrenze(List<Decorrenza> decorrenze) {
		this.decorrenze = decorrenze;
	}

}
