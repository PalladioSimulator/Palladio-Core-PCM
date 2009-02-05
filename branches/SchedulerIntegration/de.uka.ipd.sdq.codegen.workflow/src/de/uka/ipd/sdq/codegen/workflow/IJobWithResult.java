package de.uka.ipd.sdq.codegen.workflow;


/**
 * An interface for jobs which return a result when they are done. The generic type parameter T gives the type of the job's result
 * 
 * @author Steffen Becker
 *
 */
public interface IJobWithResult<T> 
	extends IJob {
	
	/**
	 * This method gives the result of the job when the job finished execution, i.e., after a call to its execute method.
	 * @return The result of the computation done by this job
	 */
	T getResult();
}
