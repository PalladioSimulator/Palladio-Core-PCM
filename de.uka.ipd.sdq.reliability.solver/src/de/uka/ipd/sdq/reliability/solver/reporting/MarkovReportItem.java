package de.uka.ipd.sdq.reliability.solver.reporting;

import java.util.ArrayList;
import java.util.List;

/**
 * Generates abstract tables based on the data of a reliability analysis of a given scenario. The
 * data encapsulated in this class can be used for later output.
 * 
 * @author Daniel Patejdl
 * 
 */
public class MarkovReportItem {

    /**
     * A MarkovReportItem may consist of several tables related to failure mode analysis.
     */
    private List<MarkovReportingTable> failureModeTables;

    /**
     * A MarkovReportItem may consist of several tables related to impact analysis.
     */
    private List<MarkovReportingTable> impactAnalysisTables;

    /**
     * The scenario's ID.
     */
    private String scenarioId;

    /**
     * The scenario's name.
     */
    private String scenarioName;

    /**
     * The scenario's success probability as String.
     */
    private String successProbabilityAsString;

    /**
     * Generates a new Markov report item, initialized with a scenario name, the scenario's ID and
     * the success probability of the scenario as String.
     * 
     * @param scenarioName
     *            the name of the scenario
     * @param scenarioId
     *            the ID of the scenario
     * @param successProbabilityAsString
     *            the success probability of the scenario as String
     */
    public MarkovReportItem(String scenarioName, String scenarioId, String successProbabilityAsString) {
        this.scenarioName = scenarioName;
        this.scenarioId = scenarioId;
        this.successProbabilityAsString = successProbabilityAsString;

        failureModeTables = new ArrayList<MarkovReportingTable>();
        impactAnalysisTables = new ArrayList<MarkovReportingTable>();
    }

    /**
     * Adds a table to the list of failure mode tables.
     * 
     * @param failureModeTable
     *            the table
     */
    public void addFailureModeTable(MarkovReportingTable failureModeTable) {
        failureModeTables.add(failureModeTable);
    }

    /**
     * Adds a table to the list of failure mode tables.
     * 
     * @param impactAnalysisTable
     *            the table
     */
    public void addImpactAnalysisTable(MarkovReportingTable impactAnalysisTable) {
        impactAnalysisTables.add(impactAnalysisTable);
    }

    /**
     * Returns all failure mode tables in the list.
     * 
     * @return all tables
     */
    public List<MarkovReportingTable> getFailureModeTables() {
        return failureModeTables;
    }

    /**
     * Returns all impact analysis tables in the list.
     * 
     * @return all tables
     */
    public List<MarkovReportingTable> getImpactAnalysisTables() {
        return impactAnalysisTables;
    }

    /**
     * Gets the scenario's ID.
     * 
     * @return the scenario's ID
     */
    public String getScenarioId() {
        return scenarioId;
    }

    /**
     * Gets the scenario's name.
     * 
     * @return the scenario's name
     */
    public String getScenarioName() {
        return scenarioName;
    }

    /**
     * Gets the scenario's success probability.
     */
    public String getSuccessProbabilityString() {
        return successProbabilityAsString;
    }

    /**
     * Sets the scenario's ID.
     * 
     * @param scenarioId
     *            the scenario's ID
     */
    public void setScenarioId(String scenarioId) {
        this.scenarioId = scenarioId;
    }

    /**
     * Sets the scenario's name.
     * 
     * @param scenarioName
     *            the scenario's name
     */
    public void setScenarioName(String scenarioName) {
        this.scenarioName = scenarioName;
    }
}
