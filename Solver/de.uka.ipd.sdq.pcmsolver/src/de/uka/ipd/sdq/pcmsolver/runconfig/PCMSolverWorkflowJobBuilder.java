package de.uka.ipd.sdq.pcmsolver.runconfig;

import org.eclipse.debug.core.ILaunch;

import de.uka.ipd.sdq.workflow.jobs.IJob;
import de.uka.ipd.sdq.workflow.pcm.configurations.AbstractPCMWorkflowRunConfiguration;
import de.uka.ipd.sdq.workflow.pcm.jobs.PCMWorkflowJobBuilder;

/**
 * This class creates a workflow for a PCM solver analysis.
 * 
 * The top-level job of this workflow is the PCMSolverJob.
 * 
 * @author brosch
 * 
 */
public class PCMSolverWorkflowJobBuilder extends PCMWorkflowJobBuilder {

	/**
	 * Eclipse launch object which is passed to the top-level job.
	 */
	private ILaunch launch;

	/**
	 * The constructor.
	 * @param launch the launch object
	 */
	public PCMSolverWorkflowJobBuilder(ILaunch launch) {
		this.launch = launch;
	}

	/*
	 * (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.pcm.jobs.PCMWorkflowJobBuilder#buildJob(de.uka.ipd.sdq.workflow.pcm.configurations.AbstractPCMWorkflowRunConfiguration)
	 */
	public IJob buildJob(AbstractPCMWorkflowRunConfiguration config) {
		return new PCMSolverJob(
				(PCMSolverWorkflowRunConfiguration) config, launch);
	}

}
