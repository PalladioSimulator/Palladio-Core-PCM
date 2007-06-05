package de.uka.ipd.sdq.codegen.simucontroller.workflow;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;

import de.uka.ipd.sdq.codegen.simucontroller.SimuComJob;
import de.uka.ipd.sdq.codegen.simucontroller.actions.ISimuComControl;
import de.uka.ipd.sdq.simucomframework.SimuComConfig;
import de.uka.ipd.sdq.simucomframework.SimuComStatus;

public class SimulateJob implements ISimulationJob {

	/** PID-Plug-In ID */
	private static final String PID = "de.uka.ipd.sdq.codegen.simucontroller";

	/** EPID - Extension Point ID */
	private static final String EPID = "controller";

	private long maxSimulationTime;

	private SimuComConfig config;

	public SimulateJob(SimuComConfig config) {
		this.config = config;
	}

	public void execute() throws Exception {
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
			throw new Exception("Locating simulation plugin failed", e);
		}

		SimuComJob job = new SimuComJob(control, config, null);
		try {
			job.setUser(true);
			job.schedule();
			job.join();
		} catch (Exception e) {
			throw new Exception("Simulation failed ", e);
		}
		if (job.getStatus() == SimuComStatus.ERROR)
			throw new Exception(job.getErrorMessage());
	}

	public String getName() {
		return "Simulate";
	}

	public void rollback() throws Exception {
	}
}
