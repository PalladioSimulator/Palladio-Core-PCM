package de.uka.ipd.sdq.reliability.solver.reporting;

import java.util.ArrayList;
import java.util.List;

/**
 * Generates abstract lists (consisting of rows).
 * 
 * @author Daniel Patejdl
 *
 */
public class MarkovReportListItem extends MarkovReportItem {
	
	private List<List<String>> entries;

	public MarkovReportListItem(String scenarioName, String scenarioId, double successProbability) {
		super(scenarioName, scenarioId, successProbability);
		entries = new ArrayList<List<String>>();
	}
	
	/**
	 * Gets the entries (lines, rows) in this MarkovReportListItem.
	 * @return the list of entries
	 */
	public List<List<String>> getEntries() {
		return entries;
	}
	
	/**
	 * Adds a new entry (line, row) to this MarkovReportListItem.
	 * @param entry the new entry
	 */
	public void addEntry(List<String> entry) {
		entries.add(entry);
	}
}
