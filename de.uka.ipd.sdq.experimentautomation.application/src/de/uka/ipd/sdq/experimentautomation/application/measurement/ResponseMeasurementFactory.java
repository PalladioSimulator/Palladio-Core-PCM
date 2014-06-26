package de.uka.ipd.sdq.experimentautomation.application.measurement;

import java.util.List;

import org.eclipse.emf.common.util.URI;

import de.uka.ipd.sdq.experimentautomation.application.ExperimentBookkeeping;
import de.uka.ipd.sdq.experimentautomation.experiments.JMXMeasurement;
import de.uka.ipd.sdq.experimentautomation.experiments.ProfilingMeasurement;
import de.uka.ipd.sdq.experimentautomation.experiments.ResponseMeasurement;
import de.uka.ipd.sdq.experimentautomation.experiments.SimulationDurationMeasurement;

public class ResponseMeasurementFactory {

    public static IResponseMeasurement createResponseMeasurement(ResponseMeasurement configuration, ExperimentBookkeeping bookkeeping, List<Long> variationValues, URI variationFolderUri) {
        if(configuration == null) {
            throw new RuntimeException("The configuration may not be null");
        }
        if (SimulationDurationMeasurement.class.isInstance(configuration)) {
            return new SimulationDurationSimulationListener(bookkeeping, variationValues, variationFolderUri);
        } else if (ProfilingMeasurement.class.isInstance(configuration)) {
            return new JProfilerSimulationListener(bookkeeping, variationValues, variationFolderUri);
        } else if (JMXMeasurement.class.isInstance(configuration)) {
            JMXMeasurement m = (JMXMeasurement) configuration;
            return new JMXSimulationListener(bookkeeping, variationValues, variationFolderUri, m.getPollingPeriod());
        }
        throw new RuntimeException("Unknown response measurement type: " + configuration.eClass().getName());
    }
    
}
