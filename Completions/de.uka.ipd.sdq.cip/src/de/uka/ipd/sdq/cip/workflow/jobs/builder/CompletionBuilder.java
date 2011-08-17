package de.uka.ipd.sdq.cip.workflow.jobs.builder;

import java.util.Collection;

import de.uka.ipd.sdq.workflow.IJob;

/**
 * Interface for CompletionBuilder
 * It provides a buildJobs method which returns the jobs for a completion 
 *  
 * @author Thomas Schuischel
 *
 */
public interface CompletionBuilder {
	/**
	 * Returns a Collection of Jobs.
	 * This method should return the needed job for a given completion type.
	 * 
	 * @return a collection of jobs
	 */
	public Collection<IJob> buildJobs();
}
