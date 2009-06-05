/**
 * 
 */
package de.uka.ipd.sdq.probfunction.visualization;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Ihssane
 * 
 */
public class ChartConfigReader {
	private static final String BEGINN_DELIMITER = "[CDATA[<model:ChartWithAxes";
	private static final String END_DELIMITER = "]]";

	private String src;
	private String dest;

	public ChartConfigReader(String src, String dest) {
		this.src = src;
		this.dest = dest;
	}

	public void readSrcFile() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(src));
		FileWriter writer = new FileWriter(dest);
		String line = null;
		boolean inChart = false;
		try {
			while ((line = reader.readLine()) != null) {
				if (inChart && containsEndDelimiter(line))
					break;
				if (inChart)
					writer.append(setMarkupLower(line));
				if (!inChart && containsBeginnDelimiter(line)) {
					inChart = true;
					line = adjustFirtLine(line);
					writer.append(line + '\n');
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		reader.close();
		writer.close();
	}

	private boolean containsBeginnDelimiter(String line) {
		return line.contains(BEGINN_DELIMITER);
	}

	private boolean containsEndDelimiter(String line) {
		return line.contains(END_DELIMITER);
	}

	private String adjustFirtLine(String line) {
		int index = line.indexOf(BEGINN_DELIMITER);
		return line.substring(index + 7);
	}

	private String setMarkupLower(String line) {
		String result = "";
		boolean toLower = false;
		for (char c : line.toCharArray()) {
			if (toLower)
				c = Character.toLowerCase(c);
			result += c;
			if (c == '<' || c == '/')
				toLower = true;
			else
				toLower = false;
		}
		return result += '\n';
	}

	public static void main(String[] ihs) {
		if (ihs.length != 2) {
			System.err
					.println("Usage: ChartConfigReader <source file> <destination file>");
			return;
		} else {
			String src = ihs[0];
			String dest = ihs[1];

			if (!src.endsWith(".rptdesign")) {
				System.err
						.println("Error: source file must ends with .rptdesign");
				return;
			}

			if (!dest.endsWith(".chart")) {
				System.err
						.println("Error: destination file must ends with .chart");
				return;
			}
			ChartConfigReader c = new ChartConfigReader(src, dest);
			try {
				c.readSrcFile();
				System.out.println("configuration file successful saved.");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
