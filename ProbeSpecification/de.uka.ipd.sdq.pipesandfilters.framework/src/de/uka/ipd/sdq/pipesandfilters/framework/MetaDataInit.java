package de.uka.ipd.sdq.pipesandfilters.framework;

import java.util.Vector;

import de.uka.ipd.sdq.pipesandfilters.framework.recorder.launch.IRecorderConfiguration;

/**
 * The MetaDataInit class is used to provide all recorders with initializing
 * meta information. It can be used by the specified WriteStrategy to store
 * detailed information about the measurements.
 * 
 * @author Baum
 * 
 */
public abstract class MetaDataInit {

	/**
	 * This vector should hold one MeasuredMetric with measurement information
	 * for each tuple that is inducted to the pipe by the calculators.
	 */
	private Vector<MeasurementMetric> measuredMetrics;

	/**
	 * TODO Comment
	 */
	private IRecorderConfiguration recorderConfiguration;

	/**
	 * The name of the measured metric.
	 */
	private String metricName;

	/**
	 * The name of the measurement.
	 */
	private String measurementName;

	/**
	 * The name of the experiment.
	 */
	private String experimentName;
	
	/**
	 * The name of the experiment run.
	 */
	private String experimentRunName;

	/**
	 * The id of the model element.
	 */
	private String modelElementID;

	/**
	 * The constructor of MetaDataInit
	 * 
	 * @param measuredMetrics
	 *            A vector of all measured metrics of a calculator.
	 */
	public MetaDataInit(Vector<MeasurementMetric> measuredMetrics,
			IRecorderConfiguration recorderConfiguration) {
		if (measuredMetrics.isEmpty())
			throw new IllegalArgumentException(
					"Vector of measured objects must not be empty.");
		this.measuredMetrics = measuredMetrics;
		this.recorderConfiguration = recorderConfiguration;
	}

	/**
	 * The constructor of MetaDataInit
	 * 
	 * @param measuredMetrics
	 *            A vector of all measured metrics of a calculator.
	 * @param metricName
	 *            The name of the metric that is measured.
	 * @param measurementName
	 *            The name of the performed measurement.
	 * @param experimentName
	 *            The name of the performed experiment.
	 */
	public MetaDataInit(Vector<MeasurementMetric> measuredMetrics,
			IRecorderConfiguration recorderConfiguration, String metricName,
			String measurementName, String experimentName) {
		this(measuredMetrics, recorderConfiguration);
		this.metricName = metricName;
		this.measurementName = measurementName;
		this.experimentName = experimentName;
	}

	/**
	 * TODO Comment
	 * 
	 * @return
	 */
	public IRecorderConfiguration getRecorderConfiguration() {
		return recorderConfiguration;
	}

	/**
	 * Returns the name of the metric.
	 * 
	 * @return The name of the metric.
	 */
	public String getMetricName() {
		return metricName;
	}

	/**
	 * Sets the name of the metric.
	 * 
	 * @param metricName
	 *            The name of the metric.
	 */
	public void setMetricName(String metricName) {
		this.metricName = metricName;
	}

	/**
	 * Returns the name of the experiment.
	 * 
	 * @return The name of the experiment.
	 */
	public String getExperimentName() {
		return experimentName;
	}

	/**
	 * Sets the name of the experiment.
	 * 
	 * @param experimentName
	 *            The name of the experiment.
	 */
	public void setExperimentName(String experimentName) {
		this.experimentName = experimentName;
	}
	
	/**
	 * Returns the name of the experiment run.
	 * 
	 * @return The name of the experiment run.
	 */
	public String getExperimentRunName() {
		return experimentRunName;
	}

	/**
	 * Sets the name of the experiment run.
	 * 
	 * @param experimentRunName
	 *            The name of the experiment run.
	 */
	public void setExperimentRunName(String experimentRunName) {
		this.experimentRunName = experimentRunName;
	}

	/**
	 * Returns the vector of all measured objects.
	 * 
	 * @return A Vector of measured objects.
	 */
	public Vector<MeasurementMetric> getMeasuredMetrics() {
		return measuredMetrics;
	}

	/**
	 * Sets the vector of measured objects.
	 * 
	 * @param measuredObjects
	 *            A vector of measured objects.
	 */
	public void setMeasuredObjects(Vector<MeasurementMetric> measuredMetrics) {
		this.measuredMetrics = measuredMetrics;
	}

	/**
	 * Adds a measured object to the vector of measured objects.
	 * 
	 * @param o
	 *            The measured object to be added.
	 */
	public void addMeasuredObject(MeasurementMetric o) {
		measuredMetrics.add(o);
	}

	/**
	 * Returns the name of the measurement.
	 * 
	 * @return The name of the measurement.
	 */
	public String getMeasurementName() {
		return measurementName;
	}

	/**
	 * Sets the name of the measurement.
	 * 
	 * @param measurementName
	 *            The name of the measurement.
	 */
	public void setMeasurementName(String measurementName) {
		this.measurementName = measurementName;
	}

	/**
	 * Sets the model element ID.
	 * 
	 * @param modelElementID
	 *            The model element ID.
	 */
	public void setModelElementID(String modelElementID) {
		this.modelElementID = modelElementID;
	}

	/**
	 * Returns the ID of the model element.
	 * 
	 * @return The model element ID.
	 */
	public String getModelElementID() {
		return modelElementID;
	}

}
