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
			htmlCode.append("<h3>Reliability results for UsageScenario: <font color=\"#707070\">"
					+ item.getScenarioName() + "</font></h3>");
			htmlCode.append("Scenario ID: <font color=\"#707070\">" +
					item.getScenarioId() + "</font><br />");
			htmlCode.append("Success probability: <font color=\"#707070\">"
					+ item.getSuccessProbability() + "</font><br />");
			// create HTML tables
			for (MarkovReportingTable table : item.getTables()) {
				if (table.getRows().size() == 0) {
					continue;	// table contains no rows, thus consider next table in list
				}
				htmlCode.append("<br />");
				htmlCode.append("<b>" + table.getTableName() + ":</b><br />");
				htmlCode.append("<table border=\"0\" style=\"margin-left: 0mm; margin-top: 1mm; border: 1px solid black;\">");
				// create header row
				htmlCode.append("<tr>");
				for (String headerEntry : table.getHeaderRow()) {
					htmlCode.append("<th>" + headerEntry + "</th>");
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
			}
		}

		return htmlCode.toString();
	}
}
