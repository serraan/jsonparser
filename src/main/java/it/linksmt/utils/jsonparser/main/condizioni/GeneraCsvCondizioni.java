package it.linksmt.utils.jsonparser.main.condizioni;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.linksmt.utils.jsonparser.main.utils.Utils;
import it.linksmt.utils.jsonparser.types.TopLevel;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GeneraCsvCondizioni {

    static final String[] HEADERS = {"aggregato", "condizione", "attr1_nome", "attr1_valore", "attr2_nome", "attr2_valore"};
    // CAMBIARE QUESTO PATH CON QUELLO NEL QUALE SI VUOLE SALVARE IL FILE.
    static final String PATH = "C:\\Users\\LONGOG\\Downloads\\custodiaTitoli-2.csv";
    static final String RESOURCE_NAME = "condizioni.json";

    public static void main(String[] args) throws IOException {
        Utils utils = new Utils();
        ObjectMapper objectMapper = new ObjectMapper();
        String moneticaJson = utils.getJsonStringFromFile(RESOURCE_NAME);
        TopLevel monetica = objectMapper.readValue(moneticaJson, TopLevel.class);

        List<List<String>> lines = new ArrayList<>();

        monetica.getDecorrenze().get(0).getAggregati().stream().forEach(aggregato -> {
            aggregato.getCondizioni().stream().forEach(condizione -> {
                List<String> values = new ArrayList<>();
                values.add(aggregato.getNome());
                values.add(condizione.getCodice());
                values.add(condizione.getAttributi().get(0).getNome());
                values.add(condizione.getAttributi().get(0).getValore());
                values.add(condizione.getAttributi().get(1).getNome());
                values.add(condizione.getAttributi().get(1).getValore());
                lines.add(values);
            });
        });

        File outputPath = new File(PATH);

        FileWriter out = new FileWriter(outputPath);
        try (CSVPrinter printer = new CSVPrinter(out, CSVFormat.EXCEL
                .withHeader(HEADERS)
                .withDelimiter('\t'))) {
            printer.printRecords(lines);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
