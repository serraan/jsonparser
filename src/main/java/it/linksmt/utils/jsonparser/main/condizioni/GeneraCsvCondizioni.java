package it.linksmt.utils.jsonparser.main.condizioni;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.linksmt.utils.jsonparser.main.utils.Utils;
import it.linksmt.utils.jsonparser.types.Condizione;
import it.linksmt.utils.jsonparser.types.TopLevel;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GeneraCsvCondizioni {

    static final String[] HEADERS = {"aggregato", "condizione", "attr1_nome", "attr1_valore", "attr2_nome", "attr2_valore"};

    public static void main(String[] args) {
        try {
            if (args.length > 0) { // Il path è stato passato da command line
                generateCsv(args[0].trim());
            } else { // Il path viene richiesto in console
                generateCsv(readFromConsole());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void generateCsv(String resourcePath) throws IOException {
        if (resourcePath.endsWith(".json")) {
            Utils utils = new Utils();
            ObjectMapper objectMapper = new ObjectMapper();

            String decorrenzeJson = utils.readJsonStringFromFile(resourcePath);
            TopLevel monetica = objectMapper.readValue(decorrenzeJson, TopLevel.class);

            List<List<String>> lines = new ArrayList<>();

            monetica.getDecorrenze().get(0).getAggregati().forEach(aggregato -> {
                aggregato.getCondizioni().forEach(condizione -> {
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

            String outPath = resourcePath.replace(".json", ".csv");
            File outputPath = new File(outPath);

            FileWriter out = new FileWriter(outputPath);
            try (CSVPrinter printer = new CSVPrinter(out, CSVFormat.EXCEL
                    .withHeader(HEADERS)
                    .withDelimiter('\t'))) {
                printer.printRecords(lines);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("CSV generato correttamente in: " + outputPath);
        } else {
            System.out.print("Il file passato in input non è un file json, riprovare.");
        }
        System.out.println("Premi invio per uscire...");
        System.in.read();
    }

    private static String readFromConsole() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Inserisci il path del json delle decorrenze:");
        return br.readLine().trim();
    }
}
