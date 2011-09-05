package de.uka.ipd.sdq.reliability.solver.pcm2markov;

/**
 * Abstract class that is responsible for generating abstract output formats (e.g. lists, tables)
 * of Markov transformation results.
 * 
 * @author Daniel Patejdl
 *
 */
public abstract class MarkovReportItem {
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

	public MarkovReportItem(String scenarioName, String scenarioId, double successProbability) {
		this.scenarioName = scenarioName;
		this.scenarioId = scenarioId;
		this.successProbability = successProbability;
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
}
