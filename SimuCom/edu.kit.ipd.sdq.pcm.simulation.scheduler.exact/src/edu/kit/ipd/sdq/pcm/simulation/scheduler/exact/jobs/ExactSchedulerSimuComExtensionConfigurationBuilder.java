package edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.jobs;

import java.util.Map;

import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuComExtensionConfigurationBuilder;
import de.uka.ipd.sdq.simucomframework.SimuComConfigExtension;
import de.uka.ipd.sdq.simucomframework.SimuComSimProcess;
import de.uka.ipd.sdq.workflow.launchconfig.extension.AbstractExtensionJobConfiguration;

public class ExactSchedulerSimuComExtensionConfigurationBuilder  extends SimuComExtensionConfigurationBuilder {

	@Override
	public AbstractExtensionJobConfiguration buildConfiguration(Map<String, Object> attributes) {
		return null;
	}

	@Override
	public SimuComConfigExtension deriveSimuComConfigExtension(Map<String,Object> attributes) {
		return null;
	}
	

}
