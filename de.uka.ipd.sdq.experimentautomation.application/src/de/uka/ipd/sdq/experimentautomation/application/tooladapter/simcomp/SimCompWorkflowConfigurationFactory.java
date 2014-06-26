package de.uka.ipd.sdq.experimentautomation.application.tooladapter.simcomp;

import java.util.HashMap;
import java.util.Map;

import de.uka.ipd.sdq.experimentautomation.application.tooladapter.abstractsimulation.AbstractSimulationWorkflowConfigurationFactory;
import de.uka.ipd.sdq.experimentautomation.experiments.PCMModelFiles;
import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.AbstractSimulationConfiguration;
import de.uka.ipd.sdq.experimentautomation.experiments.simcomp.SimCompConfiguration;
import de.uka.ipd.sdq.simulation.AbstractSimulationConfig;
import edu.kit.ipd.sdq.simcomp.controller.runconfig.SimulationComponentWorkflowConfiguration;
import edu.kit.ipd.sdq.simcomp.middleware.simulation.config.SimulationConfiguration;

public class SimCompWorkflowConfigurationFactory {

    public static SimulationComponentWorkflowConfiguration createWorkflowConfiguration(SimCompConfiguration configuration,
            PCMModelFiles pcm, AbstractSimulationConfig simConfig) {
    	Map<String, Object> attributesMap = new HashMap<String, Object>();
    	SimulationComponentWorkflowConfiguration workflowConfig = new SimulationComponentWorkflowConfiguration(attributesMap);
        workflowConfig.setSimulationConfiguration((SimulationConfiguration) simConfig);
       
        AbstractSimulationWorkflowConfigurationFactory.fillWorkflowConfiguration(workflowConfig, (AbstractSimulationConfiguration) configuration, pcm, simConfig);

        return workflowConfig;
    }
}
