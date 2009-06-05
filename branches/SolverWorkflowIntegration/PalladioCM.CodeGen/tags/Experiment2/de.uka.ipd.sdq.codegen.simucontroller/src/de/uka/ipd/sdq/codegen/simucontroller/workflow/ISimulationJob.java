package de.uka.ipd.sdq.codegen.simucontroller.workflow;

/**
 * Interface for jobs to be added to a SimulationWorkflow.
 */

public interface ISimulationJob {
	/**
	public boolean execute() throws Exception;
	 * Execute the job. In case of an error throw an exception
	 * with a meaningful name which can be understood by a user.
	 * @return false If this job did finish without exception, however, the
	 * 				user canceled the execution
	 * 			true otherwise
	 * @throws Exception
	 */
	public boolean execute() throws Exception;
	
	/**
	 * Return to the state before the execute() method was called.
	 * This method will be called on every simulation run to remove
	 * automatically created files and to leave the environment in a
	 * state in which the simulation run can be started again with
	 * the same results.
	 * 
	 * @throws Exception
	 */
	public void rollback() throws Exception;
	
	/**
	 * Supply a name of this job. This will be used for
	 * the progress monitor.
	 * 
	 * @return the name of the job
	 */
	public String getName();
}
