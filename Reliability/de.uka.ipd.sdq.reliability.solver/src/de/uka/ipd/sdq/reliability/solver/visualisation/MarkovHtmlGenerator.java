package de.uka.ipd.sdq.reliability.solver.visualisation;

import java.util.List;

import de.uka.ipd.sdq.reliability.solver.reporting.MarkovReportItem;
import de.uka.ipd.sdq.reliability.solver.reporting.MarkovReporting;
import de.uka.ipd.sdq.reliability.solver.reporting.MarkovReportingTable;

/**
 * Class that is responsible for generating HTML code (lists and tables)
 * from a given MarkovReporting instance.
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
	 * Generates a new instance that is responsible for creating HTML lists and tables,
	 * given a MarkovReporting instance as data source.
	 * @param markovReporting a MarkovReporting instance
	 */
	public MarkovHtmlGenerator(MarkovReporting markovReporting) {
		this.markovReportItems = markovReporting.getMarkovReportItems();
	}

	/**
	 * Creates and returns a String containing HTML code, either lists or tables. The HTML code reflects
	 * the Markov transformation results. All transformation result are represented as either HTML lists
	 * or tables.
	 * @return a String containing HTML code
	 */
	public String getHtml() {
		StringBuilder htmlCode = new StringBuilder();
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
				htmlCode.append("<h3>Failure Mode Analysis</h3>"); // note to myself: the upper rule belongs to this headline
			}
			for (MarkovReportingTable table : item.getFailureModeTables()) {
				if (table.getRows().size() == 0) {
					continue;	// table contains no rows, thus consider next table in list
				}
				htmlCode.append("<b>" + table.getTableName() + ":</b><br />");
				htmlCode.append("<table border=\"0\" style=\"margin-top: 1mm; border: 1px solid #a0a0a0;\">");
				// create header row
				htmlCode.append("<tr>");
				for (String headerEntry : table.getHeaderRow()) {
					htmlCode.append("<th class=\"headerRow\">" + headerEntry + "</th>");
				}
				htmlCode.append("</tr>");
				// create table data rows
				for (List<String> row : table.getRows()) {
					htmlCode.append("<tr>");
					for (String entry : row) {
						htmlCode.append("<td>" + entry + "</td>");
					}
					htmlCode.append("</tr>");
				}
				// finish table HTML code
				htmlCode.append("</table>");
				htmlCode.append("<br />");
			}
			if (item.getImpactAnalysisTables().size() != 0) {
				// draw horizontal separation line
				htmlCode.append("<hr />");
				// now, consider impact analysis tables
				htmlCode.append("<h3>Impact Analysis</h3>");	// note to myself: the upper rule belongs to this headline
				for (MarkovReportingTable table : item
						.getImpactAnalysisTables()) {
					if (table.getRows().size() == 0) {
						continue; // table contains no rows, thus consider next table in list
					}
					htmlCode.append("<b>" + table.getTableName()
							+ ":</b><br />");
					htmlCode.append("<table border=\"0\" style=\"margin-top: 1mm; border: 1px solid #a0a0a0;\">");
					// create header row
					htmlCode.append("<tr>");
					for (String headerEntry : table.getHeaderRow()) {
						htmlCode.append("<th class=\"headerRow\">"
								+ headerEntry + "</th>");
					}
					htmlCode.append("</tr>");
					// create table data rows
					for (List<String> row : table.getRows()) {
						htmlCode.append("<tr>");
						for (String entry : row) {
							htmlCode.append("<td>" + entry + "</td>");
						}
						htmlCode.append("</tr>");
					}
					// finish table HTML code
					htmlCode.append("</table>");
					htmlCode.append("<br />");
				}
			}
			// draw horizontal separation lines
			htmlCode.append("<hr>");
			htmlCode.append("<hr>");
		}

		return htmlCode.toString();
	}
}
