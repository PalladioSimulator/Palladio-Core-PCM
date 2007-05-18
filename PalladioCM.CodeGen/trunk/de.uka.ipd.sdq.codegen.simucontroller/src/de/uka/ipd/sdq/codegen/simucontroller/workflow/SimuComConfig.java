package de.uka.ipd.sdq.codegen.simucontroller.workflow;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;

import de.uka.ipd.sdq.codegen.simucontroller.runconfig.ResourceManagerTab;

/**
 * @author roman
 * 
 * The class encases all configuration options for SimuCom.
 */
public class SimuComConfig {

	/** configuration options */
	private String nameExperimentRun;
	private long simuTime;

	/**
	 * @param ILaunchConfiguration
	 */
	public SimuComConfig(ILaunchConfiguration configuration){
		try {
			this.nameExperimentRun = configuration.getAttribute(
					ResourceManagerTab.EXPERIMENT_RUN, "");
			this.simuTime = Long.valueOf(configuration.getAttribute(
					ResourceManagerTab.SIMULATION_TIME, ""));
		} catch (CoreException e) {
			// TODO
			this.nameExperimentRun = "ExceptionName";
			this.simuTime = 1500000;
			//throw new Exception("Setting up properties failed", e);
		}
	}

	public String getNameExperimentRun() {
		return nameExperimentRun;
	}

	public long getSimuTime() {
		return simuTime;
	}

}
