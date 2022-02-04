package robatortas.code.files.core.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileUtils {
	
	public static String loadAsString(String file) {
		String result = "";
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			// Temp line
			String buffer = "";
			// While there are still lines being read
			// readLine() advances to next line
			while((buffer = reader.readLine()) != null) {
				result += buffer + "\n";
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
}
