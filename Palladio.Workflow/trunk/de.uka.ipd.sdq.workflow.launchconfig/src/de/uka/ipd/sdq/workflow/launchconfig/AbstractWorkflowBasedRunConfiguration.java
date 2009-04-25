package de.uka.ipd.sdq.workflow.launchconfig;

/**
 * Base class for all configurations used to configure an Eclipse based run (or launch)
 * which internally executes a sequence of jobs (compile, M2M Transforms, simulations, etc.)
 */
public class AbstractWorkflowBasedRunConfiguration {

	protected boolean isInteractive = false;
	protected boolean isDebug = false;
	protected boolean isFixed = false;
	
	/**
	 * Returns whether the workflow engine runs in interactive mode. In non-interactive mode it 
	 * throws an exception upon failing its task. In interactive mode 
	 * it displays an error message to the user and logs the failure in the OSGi log.
	 * 
	 * Non-interactive mode is usefull for batch execution and unit testing. It is the default.
	 * 
	 * @return Whether the workflow engine runs in interactive (UI-based) mode
	 */
	public boolean isInteractive() {
		return isInteractive;
	}

	/**
	 * Return whether the workflow runs in interactive mode, i.e., whether user interaction is possible
	 * 
	 * @param isInteractive Whether the workflow runs in interactive mode
	 */
	public void setInteractive(boolean isInteractive) {
		checkFixed();
		this.isInteractive = isInteractive;
	}
	
	/**
	 * Is debug determines whether the run is executed as debug run. In debug mode, the
	 * run can be interrupted to inspect the state of the run. Debug mode can have an impact on
	 * all steps executed in a workflow.
	 * 
	 * @return Whether the workflow runs in debug mode
	 */
	public boolean isDebug() {
		return isDebug;
	}

	/**
	 * Set the isDebug property. Can only be called as long as the configuration is not validated and 
	 * frozen.
	 * 
	 * @param isDebug Whether debug is enabled or not
	 */
	public void setDebug(boolean isDebug) {
		checkFixed();
		this.isDebug = isDebug;
	}
	
	/**
	 * The last method to call by any builder or code creating an configuration for the workflow engine. The
	 * configuration will be checked and if the check is successfull it cannot be changed any longer.
	 * 
	 * If check fails it throws an Exception.
	 */
	public void validateAndFreeze() {
		this.isFixed = true;
	}
	
	/** 
	 * Get the status of this configuration. If it is frozen, it cannot be changed any longer and hence is
	 * ready to be passed to the workflow engine.
	 * 
	 * @return Whether the configuration can still be changed
	 */
	public boolean isFrozen() {
		return this.isFixed;
	}
	
	/**
	 * Used in setter methods to check whether the object can still be modified 
	 */
	protected void checkFixed() {
		if (this.isFixed)
			throw new UnsupportedOperationException("Configuration cannot be changed any longer after fixing it");
	}
}
