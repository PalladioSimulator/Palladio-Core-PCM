package edu.kit.ipd.sdq.pcm.codegen.m2m.reliability.jobs;

import java.util.Map;

import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuComExtensionConfigurationBuilder;
import de.uka.ipd.sdq.simucomframework.SimuComConfigExtension;
import de.uka.ipd.sdq.workflow.extension.AbstractExtensionJobConfiguration;

/**
 * This class provides functionality to configure reliability-enabled SimuCom runs.
 */
public class ReliabilityExtensionConfigurationBuilder extends SimuComExtensionConfigurationBuilder {

    @Override
    public final AbstractExtensionJobConfiguration buildConfiguration(final Map<String, Object> attributes) {
        ReliabilityExtensionJobConfiguration configuration = new ReliabilityExtensionJobConfiguration();
        if (attributes.containsKey(ReliabilityExtensionTab.SIMULATE_FAILURES)) {
            Boolean simulateFailures = (Boolean) attributes.get(ReliabilityExtensionTab.SIMULATE_FAILURES);
            configuration.setSimulateFailures(simulateFailures);
        }
        return configuration;
    }

    @Override
    public final SimuComConfigExtension deriveSimuComConfigExtension(final Map<String, Object> attributes) {
        return null;
    }

}
