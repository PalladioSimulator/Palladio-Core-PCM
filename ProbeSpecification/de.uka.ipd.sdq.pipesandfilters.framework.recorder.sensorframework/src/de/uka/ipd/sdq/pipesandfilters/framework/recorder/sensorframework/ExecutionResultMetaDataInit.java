package de.uka.ipd.sdq.pipesandfilters.framework.recorder.sensorframework;

import java.util.Map;
import java.util.Vector;

import de.uka.ipd.sdq.pipesandfilters.framework.MeasurementMetric;
import de.uka.ipd.sdq.pipesandfilters.framework.recorder.sensorframework.launch.SensorFrameworkConfig;

/**
 * Represents the meta data for initialization of an
 * ExecutionResultWriteDataStrategy.
 * 
 * In addition to the super class, this class contains a mapping from numerical
 * values to strings representing the different possible execution results. This
 * is necessary so that during the simulation, only the numerical values need to
 * be piped to the target sensor.
 * 
 * @author brosch
 * 
 */
public class ExecutionResultMetaDataInit extends SensorFrameworkMetaDataInit {

	/**
	 * The mapping of numerical values to strings representing the possible
	 * execution results.
	 */
	private Map<Integer, String> executionResultTypes;

	/**
	 * The constructor.
	 * 
	 * @param measuredMetrics
	 *            a vector of all measured metrics of a calculator
	 * @param recorderConfiguration
	 *            the recorder configuration
	 * @param executionResultTypes
	 *            the mapping of numerical values to strings representing the
	 *            possible execution results
	 */
	public ExecutionResultMetaDataInit(
			final Vector<MeasurementMetric> measuredMetrics,
			final SensorFrameworkConfig recorderConfiguration,
			final Map<Integer, String> executionResultTypes) {
		super(measuredMetrics, recorderConfiguration);
		this.executionResultTypes = executionResultTypes;
	}

	/**
	 * Retrieves the collection of execution result types.
	 * 
	 * @return the execution result types
	 */
	public Map<Integer, String> getExecutionResultTypes() {
		return executionResultTypes;
	}
}
