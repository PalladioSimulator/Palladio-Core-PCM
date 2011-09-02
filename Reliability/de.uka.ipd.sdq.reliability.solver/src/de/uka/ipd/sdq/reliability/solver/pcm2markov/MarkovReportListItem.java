package de.uka.ipd.sdq.reliability.solver.pcm2markov;

/**
 * Generates an abstract list (consisting of rows).
 * 
 * @author Daniel Patejdl
 *
 */
public class MarkovReportListItem extends MarkovReportItem {
	public MarkovReportListItem(String scenarioName, String scenarioId, double successProbability) {
		super(scenarioName, scenarioId, successProbability);
	}
}
