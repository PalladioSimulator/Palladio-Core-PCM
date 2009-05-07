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
	public SimuServiceResultStatus(){
	
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
	 * Indicates if the workflow was successfully executed.
	 */
	private boolean workflowExecuted = false;

	/**
	 * Sets the workflowExecuted property.
	 * 
	 * @param workflowExecuted
	 *            the property to set
	 */
	public void setWorkflowExecuted(boolean workflowExecuted) {
		if (!frozen) {
			this.workflowExecuted = workflowExecuted;
		}
	}

	/**
	 * Gets the value of the workflowExecuted property.
	 * 
	 * @return the property value
	 */
	public boolean isWorkflowExecuted() {
		return workflowExecuted;
	}

	/**
	 * Indicates if SimuService was successfully invoked and executed.
	 * 
	 * @return SimuService success status
	 */
	public boolean isSuccessful() {
		return (workflowParamsConfigured && workflowCreated && workflowExecuted);
	}

//	/**
//	 * Stores any exception that has occurred during SimuService execution.
//	 */
//	private Exception exception = null;
//
//	/**
//	 * Stores an exception that has occurred during SimuService execution.
//	 * 
//	 * @param exception
//	 *            the exception to set
//	 */
//	public void setException(Exception exception) {
//		if (!frozen) {
//			this.exception = exception;
//		}
//	}
//
//	/**
//	 * Gets any occurred exception.
//	 * 
//	 * @return the property value
//	 */
//	public Exception getException() {
//		return exception;
//	}
//
//	/**
//	 * Indicates if an exception has occurred during SimuService execution.
//	 * 
//	 * @return
//	 */
//	public boolean hasExceptionOccurred() {
//		return exception != null;
//	}
}
