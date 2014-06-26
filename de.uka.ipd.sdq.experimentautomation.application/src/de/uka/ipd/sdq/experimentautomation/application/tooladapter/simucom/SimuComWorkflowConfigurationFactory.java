package de.uka.ipd.sdq.experimentautomation.application.tooladapter.simucom;

import java.util.HashMap;
import java.util.Map;

import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuComWorkflowConfiguration;
import de.uka.ipd.sdq.experimentautomation.application.tooladapter.abstractsimulation.AbstractSimulationWorkflowConfigurationFactory;
import de.uka.ipd.sdq.experimentautomation.experiments.PCMModelFiles;
import de.uka.ipd.sdq.experimentautomation.experiments.simucom.SimuComConfiguration;
import de.uka.ipd.sdq.simucomframework.SimuComConfig;
import de.uka.ipd.sdq.simulation.AbstractSimulationConfig;

public class SimuComWorkflowConfigurationFactory {

    public static SimuComWorkflowConfiguration createWorkflowConfiguration(SimuComConfiguration configuration,
            PCMModelFiles pcm, AbstractSimulationConfig simConfig) {
    	Map<String, Object> attributesMap = new HashMap<String, Object>();
        SimuComWorkflowConfiguration workflowConfig = new SimuComWorkflowConfiguration(attributesMap);
        workflowConfig.setSimulateFailures(configuration.isSimulateFailures());
        workflowConfig.setSimulateLinkingResources(configuration.isSimulateLinkingResources());
        workflowConfig.setSimuComConfiguration((SimuComConfig)simConfig);
        
        AbstractSimulationWorkflowConfigurationFactory.fillWorkflowConfiguration(workflowConfig, configuration, pcm,
                simConfig);

        return workflowConfig;
    }

}
