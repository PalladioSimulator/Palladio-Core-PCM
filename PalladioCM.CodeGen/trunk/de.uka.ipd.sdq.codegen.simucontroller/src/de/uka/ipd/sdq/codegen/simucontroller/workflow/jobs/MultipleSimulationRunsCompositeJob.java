package de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs;

import java.util.Map;
import java.util.Properties;

import org.eclipse.core.runtime.CoreException;

import de.uka.ipd.sdq.codegen.runconfig.tabs.ConstantsContainer;
import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuAttributesGetMethods;
import de.uka.ipd.sdq.codegen.workflow.IJob;
import de.uka.ipd.sdq.codegen.workflow.JobFailedException;
import de.uka.ipd.sdq.codegen.workflow.OrderPreservingCompositeJob;
import de.uka.ipd.sdq.codegen.workflow.RollbackFailedException;
import de.uka.ipd.sdq.codegen.workflow.UserCanceledException;
import de.uka.ipd.sdq.simucomframework.SimuComConfig;

public class MultipleSimulationRunsCompositeJob extends
		OrderPreservingCompositeJob {


	public MultipleSimulationRunsCompositeJob(SimuAttributesGetMethods attributes) throws JobFailedException, CoreException {
		Map<String, String> p = attributes.getOAWWorkflowProperties();
		double current = Double.parseDouble(p.get(ConstantsContainer.MINIMUM_TEXT));
		double step = Double.parseDouble(p.get(ConstantsContainer.STEP_WIDTH_TEXT));
		double max = Double.parseDouble(p.get(ConstantsContainer.MAXIMUM_TEXT));
		int i = 1;
		for (; current <= max; current += step) {
			this.addJob(new SimulationRunCompositeJob(attributes,i));
			i++;
		}
	}

	public void execute() throws JobFailedException, UserCanceledException {
		for (IJob job : myJobs) {
			job.execute();
			try {
				job.rollback();
			} catch (RollbackFailedException e) {
				throw new JobFailedException("Automated simulation run failed",e);
			}
		}
	}
}
