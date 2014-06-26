package de.uka.ipd.sdq.experimentautomation.application.tooladapter.simucom;

import java.util.List;
import java.util.Map;

import de.uka.ipd.sdq.experimentautomation.application.tooladapter.abstractsimulation.AbstractSimulationConfigFactory;
import de.uka.ipd.sdq.experimentautomation.experiments.PCMModelFiles;
import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.AbstractSimulationConfiguration;
import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.StopCondition;
import de.uka.ipd.sdq.experimentautomation.experiments.simucom.SimuComConfiguration;
import de.uka.ipd.sdq.simucomframework.SimuComConfig;
import de.uka.ipd.sdq.simulation.AbstractSimulationConfig;

/**
 * The factory provides methods to build a {@link AbstractSimulationConfig} object based on a
 * configuration model. The configuration model is represented by a
 * {@link AbstractSimulationConfiguration} object.
 * 
 * @author Philipp Merkle
 * 
 */
public class SimuComConfigFactory {

    public static SimuComConfig createConfig(SimuComConfiguration config, List<StopCondition> stopConditions, PCMModelFiles model, String experimentName) {
    	Map<String, Object> configMap = AbstractSimulationConfigFactory.createConfigMap(config, stopConditions, model, experimentName);
    	configMap.put(AbstractSimulationConfig.SIMULATOR_ID, "de.uka.ipd.sdq.codegen.simucontroller.simucom");
        return new SimuComConfig(configMap, false);
    }

}
