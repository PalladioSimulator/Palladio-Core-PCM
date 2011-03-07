package de.uka.ipd.sdq.simuservice.types;

import java.util.ArrayList;
import java.util.List;

/**
 * This class captures the status resulting from a simulation run invoked
 * through the SimuService.
 * 
 * @author brosch, heupel
 * 
 */
public class SimuServiceResultStatus {

	/**
	 * Stores any exception that has occurred during SimuService execution.
	 */
	private String exception = null;

	/**
	 * After the object has been frozen, no properties can further be changed.
	 */
	private boolean frozen = false;

	/**
	 * Stores the aggregated simulation results.
	 */
	private List<SimulationResult> simulationResults = new ArrayList<SimulationResult>();

	/**
	 * Indicates if the simulation workflow was successfully created.
	 */
	private boolean workflowCreated = false;

	/**
	 * Indicates if all simulation workflow parameters were successfully set.
	 */
	private boolean workflowParamsConfigured = false;

	/**
	 * Indicates if workflow execution was successful.
	 */
	private boolean workflowSuccessful = false;

	/**
	 * Standard constructor - might be needed
	 */
	public SimuServiceResultStatus() {

	}

	/**
	 * Adds an aggregated simulation result.
	 * 
	 * @param simResult
	 *            the simulation result to add
	 */
	public void setSimulationResults(List<SimulationResult> simResults) {
		if (!frozen) {
			simulationResults = simResults;
		}
	}

	/**
	 * Freezes the properties of the object.
	 */
	public void freeze() {
		frozen = true;
		for (SimulationResult simResult : simulationResults) {
			simResult.freeze();
		}
	}

	/**
	 * Gets any occurred exception.
	 * 
	 * @return the property value
	 */
	public String getException() {
		return exception;
	}

	/**
	 * Retrieves the list of simulation results.
	 * 
	 * @return the list of simulation results
	 */
	public List<SimulationResult> getSimulationResults() {
		return simulationResults;
	}

	/**
	 * Gets the value of the workflowCreated property.
	 * 
	 * @return the property value
	 */
	public boolean isWorkflowCreated() {
		return workflowCreated;
	}

	/**
	 * Gets the value of the workflowParamsConfigured property.
	 * 
	 * @return the property value
	 */
	public boolean isWorkflowParamsConfigured() {
		return workflowParamsConfigured;
	}

	/**
	 * Gets the value of the workflowSuccessful property.
	 * 
	 * @return the property value
	 */
	public boolean isWorkflowSuccessful() {
		return workflowSuccessful;
	}

	/**
	 * Stores an exception that has occurred during SimuService execution.
	 * 
	 * @param exception
	 *            the exception to set
	 */
	public void setException(String exception) {
		if (!frozen) {
			this.exception = exception;
		}
	}

	/**
	 * Sets the workflowCreated property.
	 * 
	 * @param workflowCreated
	 *            the property to set
	 */
	public void setWorkflowCreated(boolean workflowCreated) {
		if (!frozen) {
			this.workflowCreated = workflowCreated;
		}
	}

	/**
	 * Sets the workflowParamsConfigured property.
	 * 
	 * @param workflowParamsConfigured
	 *            the property to set
	 */
	public void setWorkflowParamsConfigured(boolean workflowParamsConfigured) {
		if (!frozen) {
			this.workflowParamsConfigured = workflowParamsConfigured;
		}
	}

	/**
	 * Sets the workflowSuccessful property.
	 * 
	 * @param workflowSuccessful
	 *            the property to set
	 */
	public void setWorkflowSuccessful(boolean workflowSuccessful) {
		if (!frozen) {
			this.workflowSuccessful = workflowSuccessful;
		}
	}
}
