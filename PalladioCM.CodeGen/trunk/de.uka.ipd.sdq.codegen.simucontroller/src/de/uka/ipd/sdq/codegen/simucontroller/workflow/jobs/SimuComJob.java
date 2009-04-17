package de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs;

import org.eclipse.core.runtime.CoreException;

import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuComWorkflowConfiguration;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.MDSDBlackboard;
import de.uka.ipd.sdq.codegen.workflow.IBlackboardInteractingJob;
import de.uka.ipd.sdq.codegen.workflow.OrderPreservingBlackboardCompositeJob;

/**
 * Main job for the SDQ workflow engine which will run a SimuComSimulation
 * @author Steffen
 */
public class SimuComJob 
extends OrderPreservingBlackboardCompositeJob<MDSDBlackboard>
implements IBlackboardInteractingJob<MDSDBlackboard> {

	public SimuComJob(SimuComWorkflowConfiguration configuration) throws CoreException {
		super();
		
		// 1. Load PCM Models into memory
		this.addJob(new LoadPCMModelsIntoBlackboard(configuration));
		
		// 2. Validate PCM Models
		this.addJob(new CheckOAWConstraintsJob(
				configuration.getPCMModelFiles(), !configuration.isInteractive()));

		// 3. Run all model transformations
		if (configuration.isSensitivityAnalysisEnabled()) {
			this.addJob(new MultipleSimulationRunsCompositeJob(configuration));
		} else {
			this.addJob(new SimulationRunCompositeJob(configuration));
		}
	}
}
