package de.uka.ipd.sdq.pcmsolver.runconfig;

import org.eclipse.debug.core.ILaunch;

import de.uka.ipd.sdq.pcmsolver.RunPCMAnalysisJob;
import de.uka.ipd.sdq.workflow.ICompositeJob;
import de.uka.ipd.sdq.workflow.OrderPreservingBlackboardCompositeJob;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.pcm.jobs.LoadPCMModelsIntoBlackboardJob;
import de.uka.ipd.sdq.workflow.pcm.jobs.ValidateModelJob;

public class PCMSolverJob extends OrderPreservingBlackboardCompositeJob<MDSDBlackboard> implements ICompositeJob {

	public PCMSolverJob(PCMSolverWorkflowRunConfiguration config, ILaunch launch) {
		super();

		// 1. Load PCM Models into memory
		this.addJob(new LoadPCMModelsIntoBlackboardJob(config));
		
		// 2. Validate PCM Models
		this.addJob(new ValidateModelJob(config));

		// 3. Run Analysis on Loaded Models
		this.add(new RunPCMAnalysisJob(config.getRawConfiguration(), config.isReliabilityAnalysis()));
	}

}
