package de.uka.ipd.sdq.experimentautomation.application.tooladapter.simcomp;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import de.uka.ipd.sdq.experimentautomation.application.tooladapter.abstractsimulation.AbstractSimulationConfigFactory;
import de.uka.ipd.sdq.experimentautomation.experiments.PCMModelFiles;
import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.AbstractSimulationConfiguration;
import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.StopCondition;
import de.uka.ipd.sdq.experimentautomation.experiments.simcomp.SimCompConfiguration;
import de.uka.ipd.sdq.simulation.AbstractSimulationConfig;
import edu.kit.ipd.sdq.simcomp.middleware.simulation.config.SimulationConfiguration;

public class SimCompConfigFactory {

    public static SimulationConfiguration createConfig(SimCompConfiguration config, List<StopCondition> stopConditions, PCMModelFiles model, String experimentName) {

    	Map<String, Object> configMap = AbstractSimulationConfigFactory.createConfigMap((AbstractSimulationConfiguration) config, stopConditions, model, experimentName);
    	configMap.put(AbstractSimulationConfig.SIMULATOR_ID, "de.uka.ipd.sdq.codegen.simucontroller.simcomp");

    	//Logger.getRootLogger().setLevel(Level.DEBUG);
    	
    	return new SimulationConfiguration(configMap, false);
    }
}
