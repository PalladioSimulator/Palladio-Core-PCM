package de.uka.ipd.sdq.reliability.solver.visualisation;

import java.util.List;

import de.uka.ipd.sdq.reliability.solver.reporting.MarkovReportItem;
import de.uka.ipd.sdq.reliability.solver.reporting.MarkovReportListItem;
import de.uka.ipd.sdq.reliability.solver.reporting.MarkovReportTableItem;
import de.uka.ipd.sdq.reliability.solver.reporting.MarkovReporting;

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

			// does the current item represent a list or a table?
			if (item instanceof MarkovReportListItem) {
				// we have a list item, so we will create HTML lists
				MarkovReportListItem listItem = (MarkovReportListItem) item;
				htmlCode.append("<ul>");
				List<List<String>> entries = listItem.getEntries();
				for (List<String> entry : entries) {
					htmlCode.append("<li>" + entry.get(0) + "</li>");	// TODO check for valid index?
					htmlCode.append("<ul>");
					for (int i = 1; i < entry.size(); i++) {
						htmlCode.append("<li>" + entry.get(i) + "</li>");
					}
					htmlCode.append("</ul></li>");
				}
				htmlCode.append("</ul>");
			} else if (item instanceof MarkovReportTableItem) {
				// we have table item, so we will create HTML tables
				MarkovReportTableItem tableItem = (MarkovReportTableItem) item;
				int numberOfTables = tableItem.getTables().size();
				for (int i = 0; i < numberOfTables; i++) {
					htmlCode.append("<br />");
					htmlCode.append("<b>" + tableItem.getTableNames().get(i) + ":</b><br />");
					htmlCode.append("<table border=\"1\" style=\"margin-left: 5mm; margin-top: 1mm;\">");
					// create header row
					htmlCode.append("<tr>");
					for (String headerEntry : tableItem.getHeaderRows().get(i)) {
						htmlCode.append("<th>" + headerEntry + "</th>");
					}
					htmlCode.append("</tr>");
					// create table data rows
					for (List<String> row : tableItem.getTables().get(i)) {
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
		}

		return htmlCode.toString();
	}
}
