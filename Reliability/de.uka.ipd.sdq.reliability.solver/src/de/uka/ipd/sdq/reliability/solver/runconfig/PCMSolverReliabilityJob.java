package de.uka.ipd.sdq.reliability.solver.runconfig;

import org.eclipse.debug.core.ILaunch;

import de.uka.ipd.sdq.pcmsolver.runconfig.PCMSolverWorkflowRunConfiguration;
import de.uka.ipd.sdq.workflow.ICompositeJob;
import de.uka.ipd.sdq.workflow.OrderPreservingBlackboardCompositeJob;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.pcm.jobs.LoadPCMModelsIntoBlackboardJob;
import de.uka.ipd.sdq.workflow.pcm.jobs.ValidatePCMModelsJob;

public class PCMSolverReliabilityJob extends OrderPreservingBlackboardCompositeJob<MDSDBlackboard> implements ICompositeJob {

	public PCMSolverReliabilityJob(PCMSolverWorkflowRunConfiguration config, ILaunch launch) {
		super();

		// 1. Load PCM Models into memory
		this.addJob(new LoadPCMModelsIntoBlackboardJob(config));
		
		// 2. Validate PCM Models
		this.addJob(new ValidatePCMModelsJob(config));

		// 3. Run Analysis on Loaded Models
		this.add(new RunPCMReliabilityAnalysisJob(config));
	}
}
