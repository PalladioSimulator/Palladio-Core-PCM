package edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.jobs;

import org.eclipse.core.runtime.IProgressMonitor;

import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.AbstractSimuComExtensionJob;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.resources.AbstractScheduledResource;
import de.uka.ipd.sdq.simucomframework.resources.AbstractSimulatedResourceContainer;
import de.uka.ipd.sdq.simucomframework.resources.SimulatedResourceContainer;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.RollbackFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;

public class ExactSchedulerSimuComExtensionJob extends AbstractSimuComExtensionJob {

	@Override
	public void execute(IProgressMonitor monitor) throws JobFailedException,
			UserCanceledException {
		SimuComModel simuComModel = getSimuComModel();
		for (SimulatedResourceContainer simulatedResourceContainer : simuComModel.getResourceRegistry().getSimulatedResourceContainers()) {
			for (AbstractScheduledResource resource : simulatedResourceContainer.getActiveResources()) {
				if (resource.getSchedulingStrategyID().startsWith("edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.")) {
					AbstractSimulatedResourceContainer container = simuComModel.getResourceRegistry().removeResourceContainerFromRegistry(simulatedResourceContainer.getResourceContainerID());
					ResourceContainerWrapper resourceContainerWrapper = new ResourceContainerWrapper(simuComModel, container.getResourceContainerID(), container, resource.getSchedulingStrategyID(), resource.getResourceTypeId());
					simuComModel.getResourceRegistry().addResourceContainer(resourceContainerWrapper);
				}
			}
		}
	}

	@Override
	public String getName() {
		return "Simucom Exact Scheduler Extension Job";
	}

	@Override
	public void rollback(IProgressMonitor monitor)
			throws RollbackFailedException {

	}

}
