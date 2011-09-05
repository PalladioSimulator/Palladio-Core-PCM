package de.uka.ipd.sdq.reliability.solver.pcm2markov;

import java.util.List;

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
				// we have table, so we will create an HTML table
				MarkovReportTableItem tableItem = (MarkovReportTableItem) item;
				// TODO
			}
		}

		return htmlCode.toString();
	}
}
