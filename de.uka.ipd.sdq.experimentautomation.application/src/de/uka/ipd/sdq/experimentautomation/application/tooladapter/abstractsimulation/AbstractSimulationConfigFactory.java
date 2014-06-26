package de.uka.ipd.sdq.experimentautomation.application.tooladapter.abstractsimulation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import de.uka.ipd.sdq.experimentautomation.application.tooladapter.abstractsimulation.sensorframework.SensorFrameworkFactory;
import de.uka.ipd.sdq.experimentautomation.experiments.PCMModelFiles;
import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.AbstractSimulationConfiguration;
import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.AbstractSimulationPackage;
import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.MeasurementCountStopCondition;
import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.RandomNumberGeneratorSeed;
import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.SensorFramework;
import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.SensorFrameworkDatasource;
import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.SimTimeStopCondition;
import de.uka.ipd.sdq.experimentautomation.experiments.abstractsimulation.StopCondition;
import de.uka.ipd.sdq.pipesandfilters.framework.recorder.sensorframework.launch.SensorFrameworkConfig;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;
import de.uka.ipd.sdq.simulation.AbstractSimulationConfig;
import de.uka.ipd.sdq.workflow.pcm.ConstantsContainer;

public class AbstractSimulationConfigFactory {
    
    public static Map<String, Object> createConfigMap(AbstractSimulationConfiguration config,
            List<StopCondition> stopConditions, PCMModelFiles model, String experimentName) {
        Map<String, Object> map = new HashMap<String, Object>();

        map.put(AbstractSimulationConfig.EXPERIMENT_RUN, experimentName);
        map.put(AbstractSimulationConfig.SIMULATION_TIME, getMaximumSimulationTime(config, stopConditions));
        map.put(AbstractSimulationConfig.MAXIMUM_MEASUREMENT_COUNT, getMaximumMeasurementCount(config, stopConditions));
        map.put(AbstractSimulationConfig.VERBOSE_LOGGING, false);
        map.put(AbstractSimulationConfig.BLACKBOARD_TYPE, config.getProbeSpecConfiguration().getBlackboardType());

        map.put(ConstantsContainer.ALLOCATION_FILE, model.getAllocationFile());
        map.put(ConstantsContainer.USAGE_FILE, model.getUsagemodelFile());

        fillRandomNumberGeneratorSeed(config, map);
        // fillConfidenceStopCondition(config, map);
        fillAndConfigurePersistenceFramework(config, map);

        // the class SimuComConfig expects map entries to have a value of type String
        adjustMapValueTypes(map);

        return map;
    }

    /**
     * Converts the values contained in the map to the data types that are expected by
     * {@link AbstractSimulationConfig}.
     * 
     * @param map
     */
    private static void adjustMapValueTypes(Map<String, Object> map) {
        for (Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (key.equals(SensorFrameworkConfig.DATASOURCE_ID)) {
                // FIXME the DATASOURCE_ID should be of type String. Fix this in the class
                // de.uka.ipd.sdq.pipesandfilters.framework.recorder.sensorframework.launch.SensorFrameworkTab
                entry.setValue(((Long) value).intValue());
            } else if (value instanceof Boolean) {
                // do nothing: As an exception, Booleans are not represented by string
            } else {
                entry.setValue(value.toString());
            }
        }
    }

    private static IDAOFactory fillAndConfigurePersistenceFramework(AbstractSimulationConfiguration config,
            Map<String, Object> map) {
        // if SensorFramework is to be used
        if (AbstractSimulationPackage.eINSTANCE.getSensorFramework().isInstance(config.getPersistenceFramework())) {
            map.put(AbstractSimulationConfig.PERSISTENCE_RECORDER_NAME, "SensorFramework");

            // create or open datasource as specified
            SensorFramework sensorFramework = (SensorFramework) config.getPersistenceFramework();
            SensorFrameworkDatasource datasource = sensorFramework.getDatasource();
            IDAOFactory daoFactory = SensorFrameworkFactory.createOrOpenDatasource(datasource);

            map.put(SensorFrameworkConfig.DATASOURCE_ID, daoFactory.getID());

            return daoFactory;
        }
        return null;
    }

    // TODO
    // private static void fillConfidenceStopCondition(ToolConfiguration config, Map<String, Object>
    // map) {
    // if (getConfidenceStopCondition(config) != null) {
    // ConfidenceStopCondition confidenceConfig = getConfidenceStopCondition(config);
    // map.put(SimuComConfig.USE_CONFIDENCE, true);
    // map.put(SimuComConfig.CONFIDENCE_LEVEL, confidenceConfig.getConfidenceLevel());
    // map.put(SimuComConfig.CONFIDENCE_HALFWIDTH, confidenceConfig.getHalfWidth());
    // map.put(SimuComConfig.CONFIDENCE_MODELELEMENT_URI, ""); // TODO
    // map.put(SimuComConfig.CONFIDENCE_MODELELEMENT_NAME, ""); // TODO
    // } else {
    // map.put(SimuComConfig.USE_CONFIDENCE, false);
    // map.put(SimuComConfig.CONFIDENCE_LEVEL, 95);
    // map.put(SimuComConfig.CONFIDENCE_HALFWIDTH, 10);
    // map.put(SimuComConfig.CONFIDENCE_MODELELEMENT_URI, "");
    // map.put(SimuComConfig.CONFIDENCE_MODELELEMENT_NAME, "");
    // }
    // }

    private static void fillRandomNumberGeneratorSeed(AbstractSimulationConfiguration config, Map<String, Object> map) {
        if (config.getRandomNumberGeneratorSeed() != null) {
            map.put(AbstractSimulationConfig.USE_FIXED_SEED, true);

            RandomNumberGeneratorSeed seed = config.getRandomNumberGeneratorSeed();
            map.put(AbstractSimulationConfig.FIXED_SEED_PREFIX + "0", seed.getSeed0());
            map.put(AbstractSimulationConfig.FIXED_SEED_PREFIX + "1", seed.getSeed1());
            map.put(AbstractSimulationConfig.FIXED_SEED_PREFIX + "2", seed.getSeed2());
            map.put(AbstractSimulationConfig.FIXED_SEED_PREFIX + "3", seed.getSeed3());
            map.put(AbstractSimulationConfig.FIXED_SEED_PREFIX + "4", seed.getSeed4());
            map.put(AbstractSimulationConfig.FIXED_SEED_PREFIX + "5", seed.getSeed5());
        } else {
            map.put(AbstractSimulationConfig.USE_FIXED_SEED, false);
        }
    }

    private static int getMaximumSimulationTime(AbstractSimulationConfiguration config,
            List<StopCondition> stopConditions) {
        for (StopCondition s : stopConditions) {
            if (AbstractSimulationPackage.eINSTANCE.getSimTimeStopCondition().isInstance(s)) {
                return ((SimTimeStopCondition) s).getSimulationTime();
            }
        }

        List<StopCondition> defaultConditions = config.getStopConditions();
        for (StopCondition s : defaultConditions) {
            if (AbstractSimulationPackage.eINSTANCE.getSimTimeStopCondition().isInstance(s)) {
                return ((SimTimeStopCondition) s).getSimulationTime();
            }
        }

        // -1 causes the simulation to simulate indefinitely with regard to the simulation time
        return -1;
    }

    private static int getMaximumMeasurementCount(AbstractSimulationConfiguration config,
            List<StopCondition> stopConditions) {
        for (StopCondition s : stopConditions) {
            if (AbstractSimulationPackage.eINSTANCE.getMeasurementCountStopCondition().isInstance(s)) {
                return ((MeasurementCountStopCondition) s).getMeasurementCount();
            }
        }

        List<StopCondition> defaultConditions = config.getStopConditions();
        for (StopCondition s : defaultConditions) {
            if (AbstractSimulationPackage.eINSTANCE.getMeasurementCountStopCondition().isInstance(s)) {
                return ((MeasurementCountStopCondition) s).getMeasurementCount();
            }
        }

        // -1 causes the simulation to simulate indefinitely with regard to the measurement amount
        return -1;
    }

    // TODO
    // /**
    // * @return the stop condition, if there is one configured; null else.
    // */
    // private static ConfidenceStopCondition
    // getConfidenceStopCondition(AbstractSimulationConfiguration config) {
    // List<StopCondition> stopConditions = config.getStopConditions();
    // for (StopCondition s : stopConditions) {
    // if (s.eClass().isInstance(ConfidenceStopCondition.class)) {
    // return (ConfidenceStopCondition) s;
    // }
    // }
    //
    // return null;
    // }
}
