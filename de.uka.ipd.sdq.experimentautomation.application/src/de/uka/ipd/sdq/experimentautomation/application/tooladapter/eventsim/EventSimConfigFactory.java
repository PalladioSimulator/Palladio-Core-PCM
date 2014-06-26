package de.uka.ipd.sdq.experimentautomation.application.tooladapter.eventsim;

import java.util.List;
import java.util.Map;

import de.uka.ipd.sdq.experimentautomation.application.tooladapter.abstractsimulation.AbstractSimulationConfigFactory;
import de.uka.ipd.sdq.experimentautomation.experiments.PCMModelFiles;
import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.StopCondition;
import de.uka.ipd.sdq.experimentautomation.experiments.eventsim.EventSimConfiguration;
import de.uka.ipd.sdq.simulation.AbstractSimulationConfig;
import edu.kit.ipd.sdq.eventsim.EventSimConfig;

public class EventSimConfigFactory {

    public static EventSimConfig createConfig(EventSimConfiguration config, List<StopCondition> stopConditions, PCMModelFiles model, String experimentName) {

    	Map<String, Object> configMap = AbstractSimulationConfigFactory.createConfigMap(config, stopConditions, model, experimentName);
    	configMap.put(AbstractSimulationConfig.SIMULATOR_ID, "de.uka.ipd.sdq.codegen.simucontroller.eventsim");
    	
    	return new EventSimConfig(configMap, false);
    }

}
