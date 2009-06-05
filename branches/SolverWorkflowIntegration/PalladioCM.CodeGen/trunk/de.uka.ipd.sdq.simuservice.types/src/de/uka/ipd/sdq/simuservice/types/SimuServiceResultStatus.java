package de.uka.ipd.sdq.simuservice.types;

/**
 * This class captures the status resulting from a simulation run invoked
 * through the SimuService.
 * 
 * @author brosch, heupel
 * 
 */
public class SimuServiceResultStatus {

	/**
	 * After the object has been frozen, no properties can further be changed.
	 */
	private boolean frozen = false;

	/**
	 * Standard constructor - might be needed
	 */
	public SimuServiceResultStatus() {

	}

	/**
	 * Freezes the properties of the object.
	 */
	public void freeze() {
		frozen = true;
	}

	/**
	 * Indicates if all simulation workflow parameters were successfully set.
	 */
	private boolean workflowParamsConfigured = false;

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
	 * Gets the value of the workflowParamsConfigured property.
	 * 
	 * @return the property value
	 */
	public boolean isWorkflowParamsConfigured() {
		return workflowParamsConfigured;
	}

	/**
	 * Indicates if the simulation workflow was successfully created.
	 */
	private boolean workflowCreated = false;

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
	 * Gets the value of the workflowCreated property.
	 * 
	 * @return the property value
	 */
	public boolean isWorkflowCreated() {
		return workflowCreated;
	}

	/**
	 * Indicates if workflow execution was successful.
	 */
	private boolean workflowSuccessful = false;

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

	/**
	 * Gets the value of the workflowSuccessful property.
	 * 
	 * @return the property value
	 */
	public boolean isWorkflowSuccessful() {
		return workflowSuccessful;
	}

	/**
	 * Stores any exception that has occurred during SimuService execution.
	 */
	private String exception = null;

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
	 * Gets any occurred exception.
	 * 
	 * @return the property value
	 */
	public String getException() {
		return exception;
	}
}
