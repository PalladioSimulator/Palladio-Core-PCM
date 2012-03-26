package edu.kit.ipd.sdq.pcm.codegen.m2m.reliability.jobs;

import java.util.Map;

import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuComExtensionConfigurationBuilder;
import de.uka.ipd.sdq.simucomframework.SimuComConfigExtension;
import de.uka.ipd.sdq.workflow.launchconfig.extension.AbstractExtensionJobConfiguration;

public class ReliabilityExtensionConfigurationBuilder  extends SimuComExtensionConfigurationBuilder {

	@Override
	public AbstractExtensionJobConfiguration buildConfiguration(Map<String, Object> attributes) {
		ReliabilityExtensionJobConfiguration configuration = new ReliabilityExtensionJobConfiguration();
		if (attributes.containsKey(ReliabilityExtensionTab.SIMULATE_FAILURES)) {
			Boolean simulateFailures = (Boolean)attributes.get(ReliabilityExtensionTab.SIMULATE_FAILURES);
			configuration.setSimulateFailures(simulateFailures);
		}
		return configuration;
	}

	@Override
	public SimuComConfigExtension deriveSimuComConfigExtension(Map<String,Object> attributes) {
		return null;
	}
	

}
