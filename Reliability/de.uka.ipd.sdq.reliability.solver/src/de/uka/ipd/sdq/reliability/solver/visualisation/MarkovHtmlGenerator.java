package de.uka.ipd.sdq.reliability.solver.visualisation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;

import de.uka.ipd.sdq.reliability.solver.reporting.MarkovReportItem;
import de.uka.ipd.sdq.reliability.solver.reporting.MarkovReporting;
import de.uka.ipd.sdq.reliability.solver.reporting.MarkovReportingTable;

/**
 * Class that is responsible for generating HTML code from a given
 * MarkovReporting instance.
 * 
 * @author Daniel Patejdl
 *
 */
public class MarkovHtmlGenerator {
	/**
	 * A MarkovReporting instance; serves as central data source of this class.
	 */
	private List<MarkovReportItem> markovReportItems;

	/**
	 * Generates a new instance that is responsible for creating a HTML page,
	 * given a MarkovReporting instance as data source.
	 * @param markovReporting a MarkovReporting instance
	 */
	public MarkovHtmlGenerator(MarkovReporting markovReporting) {
		this.markovReportItems = markovReporting.getMarkovReportItems();
	}
	
	/**
	 * Retrieves a file object from a resource contained within the bundle.
	 * 
	 * @param resourceLocation
	 *            the resource location as a relative path within the bundle
	 * @return the resulting file object
	 * @throws IOException
	 *             indicates an invalid resource location
	 * @throws URISyntaxException
	 *             indicates an invalid resource location
	 */
	private File getBundleResourceFile(final String resourceLocation)
			throws IOException, URISyntaxException {
		String bundleName = "de.uka.ipd.sdq.reliability.solver";
		Bundle bundle = Platform.getBundle(bundleName);
		if (bundle == null) {
			// Probably no JUnit Plug-in Test running, but only JUnit Test:
			throw new IllegalArgumentException(
					"Bundle " + bundleName + " not found.");
		}
		URL fileURL = bundle.getEntry(resourceLocation);
		File file = new File(FileLocator.resolve(fileURL).toURI());
		return file;
	}
	
	/**
	 * Reads the contents of the given file into a String object.
	 * 
	 * @param file
	 *            the file to read
	 * @return the string representing the file contents
	 * @throws IOException
	 *             indicates that the file could not be found or file contents
	 *             could not be read (e.g. because of missing access rights)
	 */
	private String getFileContents(final File file) throws IOException {
		String result = "";
		String newLine = System.getProperty("line.separator");
		BufferedReader in = new BufferedReader(new FileReader(file));
		String line;
		while ((line = in.readLine()) != null) {
			result += (line + newLine);
		}
		in.close();
		return result;
	}

	// FIXME Images (arrows up and down) aren't shown on the resulting HTML page.
	/**
	 * Creates and returns a String containing HTML code. The HTML code reflects
	 * the Markov transformation results. All transformation results are represented as HTML tables.
	 * @return a String containing HTML code
	 */
	public String getHtml() {
		String cssCode = "";	// will hold CSS source code for later use in HTML page
		String jsCode = "";	// will hold JavaScript source code for later use in HTML page
		try {
			// attempt to read CSS/JavaScript code from file.
			cssCode = getFileContents(getBundleResourceFile("resources/jsComponents.css"));
			jsCode = getFileContents(getBundleResourceFile("resources/jsComponents.js"));
		} catch (IOException e) {
			// in case we don't find the desired CSS/JavaScript code, we will simply continue,
			// since basic functionality of the HTML page will still be given
		} catch (URISyntaxException e) {
			// in case we don't find the desired CSS/JavaScript code, we will simply continue,
			// since basic functionality of the HTML page will still be given
		}
		// create HTML page header
		StringBuilder htmlCode = new StringBuilder("<html><head>"
				+ "<title>Markov Results</title>"
				+ "<script type=\"text/javascript\">"
				+ jsCode
				+ "</script>"
				+ "<style type=\"text/css\">"
				+ cssCode
				+ "		body { font-family: Lucida Grande, Arial, Tahoma, Verdana; font-size: 12px; }"
				+ "		td, th { font-size: 11px; }"
				+ "		th { background-color: c0c0c0; margin: 1px; padding: 3px 5px 3px 5px; border: 1px solid black; }"
				+ "		td { background-color: dfdfdf; margin: 1px; padding: 3px 5px 3px 5px; }"
				+ "</style>"
				+ "</head><body>");
		for (MarkovReportItem item : markovReportItems) {
			htmlCode.append("<h2>Reliability results for UsageScenario: <font color=\"#606060\">"
					+ item.getScenarioName() + "</font></h2>");
			htmlCode.append("Scenario ID: <font color=\"#606060\">" +
					item.getScenarioId() + "</font><br />");
			htmlCode.append("Success probability: <font color=\"#606060\">"
					+ item.getSuccessProbabilityString() + "</font><br />");
			// create tables: failure mode tables first, then impact analysis tables
			if (item.getFailureModeTables().size() != 0) {
				// draw horizontal separation line
				htmlCode.append("<hr />");
				htmlCode.append("<h3>Failure Mode Analysis</h3>");
			}
			for (MarkovReportingTable table : item.getFailureModeTables()) {
				if (table.getRows().size() == 0) {
					continue;	// table contains no rows, thus consider next table in list
				}
				htmlCode.append("<div class=\"JSTableStripe\"><div class=\"JSTableSort\">");
				htmlCode.append("<b>" + table.getTableName() + ":</b><br />");
				htmlCode.append("<table border=\"0\" style=\"margin-top: 1mm; border: 1px solid black;\">");
				// create header row
				htmlCode.append("<thead><tr>");
				for (String headerEntry : table.getHeaderRow()) {
					htmlCode.append("<th class=\"SortString\" onselectstart=\"return false;\">" + headerEntry + "</th>");
				}
				htmlCode.append("</tr></thead><tbody>");
				// create table data rows
				for (List<String> row : table.getRows()) {
					htmlCode.append("<tr>");
					for (String entry : row) {
						htmlCode.append("<td>" + entry + "</td>");
					}
					htmlCode.append("</tr>");
				}
				// finish table HTML code
				htmlCode.append("</tbody></table>");
				htmlCode.append("</div></div><br />");
			}
			if (item.getImpactAnalysisTables().size() != 0) {
				// draw horizontal separation line
				htmlCode.append("<hr />");
				// now, consider impact analysis tables
				htmlCode.append("<h3>Impact Analysis</h3>");
				for (MarkovReportingTable table : item
						.getImpactAnalysisTables()) {
					if (table.getRows().size() == 0) {
						continue; // table contains no rows, thus consider next table in list
					}
					htmlCode.append("<div class=\"JSTableStripe\"><div class=\"JSTableSort\">");
					htmlCode.append("<table border=\"0\" style=\"margin-top: 1mm; border: 1px solid black;\">");
					// create header row
					htmlCode.append("<thead><tr>");
					for (String headerEntry : table.getHeaderRow()) {
						htmlCode.append("<th class=\"SortString\" onselectstart=\"return false;\">" + headerEntry + "</th>");
					}
					htmlCode.append("</tr></thead><tbody>");
					// create table data rows
					for (List<String> row : table.getRows()) {
						htmlCode.append("<tr>");
						for (String entry : row) {
							htmlCode.append("<td>" + entry + "</td>");
						}
						htmlCode.append("</tr>");
					}
					// finish table HTML code
					htmlCode.append("</tbody></table>");
					htmlCode.append("</div></div><br />");
				}
			}
			// draw horizontal separation lines
			htmlCode.append("<hr>");
			htmlCode.append("<hr>");
		}

		// finish page
		htmlCode.append("</body></html>");
		return htmlCode.toString();
	}
}
