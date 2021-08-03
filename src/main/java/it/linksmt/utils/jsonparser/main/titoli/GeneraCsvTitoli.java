package it.linksmt.utils.jsonparser.main.titoli;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.linksmt.utils.jsonparser.main.utils.Utils;
import it.linksmt.utils.jsonparser.types.Aggregato;
import it.linksmt.utils.jsonparser.types.TopLevel;

public class GeneraCsvTitoli {

	static final String[] HEADERS = { "nome", "codice", "nome1", "valore1", "nome2", "valore2" };
	// CAMBIARE QUESTO PATH CON QUELLO NEL QUALE SI VUOLE SALVARE IL FILE.
	static final String PATH = "C:\\Users\\SERRAANDREA\\Desktop\\custodiaTitoli.csv";
	static final String RESOURCE_NAME = "custodiaTitoli.json";

	public static void main(String[] args) throws IOException {
		Utils utils = new Utils();
		ObjectMapper objectMapper = new ObjectMapper();
		String custodiaTitoliJson = utils.getJsonStringFromFile(RESOURCE_NAME);
		TopLevel custodiaTitoli = objectMapper.readValue(custodiaTitoliJson, TopLevel.class);

		List<Aggregato> aggregati = custodiaTitoli.getDecorrenze().get(0).getAggregati();

		List<String> nomi = new ArrayList<>();
		List<String> codici = new ArrayList<>();
		List<String> nomi1 = new ArrayList<>();
		List<String> valori1 = new ArrayList<>();
		List<String> nomi2 = new ArrayList<>();
		List<String> valori2 = new ArrayList<>();

		aggregati.stream().forEach(aggregato -> {
			nomi.add(aggregato.getNome());

			aggregato.getCondizioni().stream().forEach(condizione -> {
				codici.add(condizione.getCodice());
				nomi1.add(condizione.getAttributi().get(0).getNome());
				valori1.add(condizione.getAttributi().get(0).getValore());
				nomi2.add(condizione.getAttributi().get(1).getNome());
				valori2.add(condizione.getAttributi().get(1).getValore());
			});
		});

		File outputPath = new File(PATH);

		FileWriter out = new FileWriter(outputPath);
		try (CSVPrinter printer = new CSVPrinter(out, CSVFormat.EXCEL.withHeader(HEADERS))) {
			printer.printRecords(nomi, codici, nomi1, valori1, nomi2, valori2);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}