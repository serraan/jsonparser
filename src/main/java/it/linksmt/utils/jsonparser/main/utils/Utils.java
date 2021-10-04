package it.linksmt.utils.jsonparser.main.utils;

import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class Utils {

	public String readJsonStringFromFile(String jsonPath) throws IOException {
		Path path = Paths.get(jsonPath);
		return new String(Files.readAllBytes(path));
	}

}