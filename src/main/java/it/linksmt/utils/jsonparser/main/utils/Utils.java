package it.linksmt.utils.jsonparser.main.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Utils {

	public String getJsonStringFromFile(String json) throws IOException {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(json).getFile());
		String out = FileUtils.readFileToString(file, "UTF-8");
		return out;
	}

}