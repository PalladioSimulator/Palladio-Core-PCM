package de.uka.ipd.sdq.reliability.solver.reporting;

import java.util.ArrayList;
import java.util.List;

/**
 * Generates abstract tables (consisting of rows and columns).
 * 
 * @author Daniel Patejdl
 *
 */
public class MarkovReportItem {
	
	/**
	 * The scenario's name
	 */
	private String scenarioName;

	/**
	 * The scenario's ID.
	 */
	private String scenarioId;

	/**
	 * The scenario's success probability;
	 */
	private double successProbability;

	/**
	 * A MarkovReportItem consists of several tables.
	 */
	private List<MarkovReportingTable> tables;	// TODO splitten in
												// TODO (1) failureModeTables ("Failure Mode Analysis")
												// TODO (2) impactAnalysisTables ("Impact Analysis")

	public MarkovReportItem(String scenarioName, String scenarioId, double successProbability) {
		this.scenarioName = scenarioName;
		this.scenarioId = scenarioId;
		this.successProbability = successProbability;

		tables = new ArrayList<MarkovReportingTable>();
	}

	/**
	 * Gets the scenario's name.
	 * @return the scenario's name
	 */
	public String getScenarioName() {
		return scenarioName;
	}

	/**
	 * Sets the scenario's name.
	 * @param scenarioName the scenario's name
	 */
	public void setScenarioName(String scenarioName) {
		this.scenarioName = scenarioName;
	}

	/**
	 * Gets the scenario's ID.
	 * @return the scenario's ID
	 */
	public String getScenarioId() {
		return scenarioId;
	}

	/**
	 * Sets the scenario's ID.
	 * @param scenarioId the scenario's ID
	 */
	public void setScenarioId(String scenarioId) {
		this.scenarioId = scenarioId;
	}

	/**
	 * Gets the scenario's success probability.
	 */
	public double getSuccessProbability() {
		return successProbability;
	}

	/**
	 * Adds a table to the list of tables.
	 * @param table the table
	 */
	public void addTable(MarkovReportingTable table){
		tables.add(table);
	}

	/**
	 * Returns all tables in the list.
	 * @return all tables
	 */
	public List<MarkovReportingTable> getTables() {
		return tables;
	}
}
