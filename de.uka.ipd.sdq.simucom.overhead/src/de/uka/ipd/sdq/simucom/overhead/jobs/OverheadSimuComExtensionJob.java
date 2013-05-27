package de.uka.ipd.sdq.simucom.overhead.jobs;

import org.eclipse.core.runtime.IProgressMonitor;

import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.AbstractSimuComExtensionJob;
import de.uka.ipd.sdq.simucom.overhead.virtualizationoverhead.LoadDependentOverheadConfiguration;
import de.uka.ipd.sdq.simucom.overhead.virtualizationoverhead.LoadDependentResourceContainer;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.resources.AbstractSimulatedResourceContainer;
import de.uka.ipd.sdq.simucomframework.resources.SimulatedResourceContainer;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.RollbackFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;

public class OverheadSimuComExtensionJob extends AbstractSimuComExtensionJob {
	
	LoadDependentOverheadConfiguration loadDependentOverheadConfiguration = null;

	@Override
	public void execute(IProgressMonitor monitor) throws JobFailedException,
			UserCanceledException {
		
		SimuComModel simuComModel = getSimuComModel();
		if ((getJobConfiguration() != null) && (getJobConfiguration() instanceof OverheadExtensionJobConfiguration)) {
			loadDependentOverheadConfiguration = ((OverheadExtensionJobConfiguration)getJobConfiguration()).getLoadDependentOverheadConfiguration();
		}
		if (simuComModel == null) {
			throw new JobFailedException("OverheadSimuComExtensionJob failed. SimuCom Model is not available.");
		}
		if (loadDependentOverheadConfiguration != null) {
			for (String resourceContainerId : loadDependentOverheadConfiguration.getResourceContainerIds()) {
				if (simuComModel.getResourceRegistry().containsResourceContainer(resourceContainerId)) {
					AbstractSimulatedResourceContainer container = simuComModel.getResourceRegistry().removeResourceContainerFromRegistry(resourceContainerId);
					LoadDependentResourceContainer loadDependentResourceContainer = new LoadDependentResourceContainer(simuComModel, container.getResourceContainerID(), container, loadDependentOverheadConfiguration.getOverhead(resourceContainerId));
					if (container instanceof SimulatedResourceContainer) {
						if (((SimulatedResourceContainer)container).getParentResourceContainer() != null) {
							((SimulatedResourceContainer)container).getParentResourceContainer().getNestedResourceContainers().remove(((SimulatedResourceContainer)container));
							((SimulatedResourceContainer)container).getParentResourceContainer().getNestedResourceContainers().add(loadDependentResourceContainer);
						}
					}
					simuComModel.getResourceRegistry().addResourceContainer(loadDependentResourceContainer);
										
				} else {
					logger.warn("Load Overhead Configuration: No resource container found for resource container " + resourceContainerId);
				}
			}
			
		}
	}
	

	@Override
	public String getName() {
		return "Simucom Overhead Job";
	}

	@Override
	public void rollback(IProgressMonitor monitor)
			throws RollbackFailedException {
	}

}
