package de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

import de.uka.ipd.sdq.codegen.simucontroller.SimuComJob;
import de.uka.ipd.sdq.codegen.workflow.IJob;
import de.uka.ipd.sdq.codegen.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.simucomframework.ISimuComControl;
import de.uka.ipd.sdq.simucomframework.SimuComConfig;
import de.uka.ipd.sdq.simucomframework.SimuComResult;

public class SimulateJob implements IJob {

	/** PID-Plug-In ID */
	private static final String PID = "de.uka.ipd.sdq.simucomframework";

	/** EPID - Extension Point ID */
	private static final String EPID = "controller";

	private SimuComConfig config;

	public SimulateJob(SimuComConfig config) {
		this.config = config;
	}

	public void execute() throws JobFailedException {
		ISimuComControl control = null;

		try {
			for (IConfigurationElement configurationElement : Platform
					.getExtensionRegistry().getConfigurationElementsFor(
							PID + "." + EPID)) {
				control = (ISimuComControl) configurationElement
						.createExecutableExtension("class");
				if (control != null) {
					//successful
					break;
				}
			}
		} catch (Exception e) {
			throw new JobFailedException("Locating simulation plugin failed. Possibly the workspace path is too long.", e);
		}

		SimuComJob job = new SimuComJob(control, config);
		try {
			job.setUser(true);
			job.schedule();
			job.join();
		} catch (Exception e) {
			throw new JobFailedException("Simulation failed ", e);
		}
		if (job.getStatus() == SimuComResult.ERROR)
			throw new JobFailedException("Simulation run failed",job.getErrorThrowable());
	}

	public String getName() {
		return "Simulate";
	}

	public void rollback() {
		// do nothing
	}
}
