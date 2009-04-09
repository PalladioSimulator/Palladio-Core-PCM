package de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs;

import org.eclipse.core.runtime.CoreException;

import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuComWorkflowConfiguration;
import de.uka.ipd.sdq.codegen.workflow.ParallelCompositeJob;

/**
 * A job which runs multiple simulations in sequence or parallel to perform a sensitivity analysis
 * 
 * @author Steffen
 */
public class MultipleSimulationRunsCompositeJob 
extends	ParallelCompositeJob {

	public MultipleSimulationRunsCompositeJob(SimuComWorkflowConfiguration configuration) throws CoreException {
		super(1);
		
		double current = configuration.getSensitivityAnalysisConfiguration().getMin(); 
		double step = configuration.getSensitivityAnalysisConfiguration().getStep(); 
		double max = configuration.getSensitivityAnalysisConfiguration().getMax(); 
		int i = 1;
		
		for (; current <= max; current += step) {
			this.addJob(new SimulationRunCompositeJob(configuration,i));
			i++;
		}
	}
}
