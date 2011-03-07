package de.uka.ipd.sdq.pipesandfilters.framework.recorder.edp2;

import de.uka.ipd.sdq.edp2.impl.MeasurementsUtility;
import de.uka.ipd.sdq.edp2.models.ExperimentData.BaseMetricDescription;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataFactory;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentGroup;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentRun;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentSetting;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Measurement;
import de.uka.ipd.sdq.edp2.models.ExperimentData.MeasurementRange;
import de.uka.ipd.sdq.edp2.models.ExperimentData.MetricSetDescription;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Monotonic;
import de.uka.ipd.sdq.edp2.models.ExperimentData.OrdinalMeasure;
import de.uka.ipd.sdq.edp2.models.ExperimentData.PersistenceKindOptions;
import de.uka.ipd.sdq.pipesandfilters.framework.MeasurementMetric;
import de.uka.ipd.sdq.pipesandfilters.framework.MetaDataInit;
import de.uka.ipd.sdq.pipesandfilters.framework.PipeData;
import de.uka.ipd.sdq.pipesandfilters.framework.edp2.EDP2MetaDataInit;

/**
 * This abstract class provides methods necessary to write raw or aggregated measurements to the EDP2.
 * 
 * @author Baum
 * 
 */
public abstract class Edp2WriteStrategy {
	/**
	 * The metric of the measured data.
	 */
	protected MetricSetDescription metric;
	/**
	 * The EDP2 measure.
	 */
	protected OrdinalMeasure measure;
	/**
	 * The EDP2 experiment setting.
	 */
	protected ExperimentSetting experimentSetting;
	/**
	 * The EDP2 experiment group.
	 */
	protected ExperimentGroup experimentGroup;
	/**
	 * The EDP2 measurement.
	 */
	protected Measurement measurement;
	/**
	 * The EDP2 experiment run.
	 */
	protected ExperimentRun experimentRun;
	/**
	 * The EDP2 measurement range.
	 */
	protected MeasurementRange measurementRange;

	/**
	 * A string containing the name of the directory the data is stored at.
	 */
	protected String directoryName;


	/**
	 * The constructor of Edp2AggregationWriteStrategy.
	 */
	public Edp2WriteStrategy() {
		directoryName = "Edp2Measurements";
	}
	
	/**
	 * Returns the name of the directory the incoming data is stored at.
	 * 
	 * @return The name of the directory.
	 */
	public String getDirectoryName() {
		return directoryName;
	}

	/**
	 * Sets the name of the directory incoming data is stored at. Note: The
	 * specified directory must exist.
	 * 
	 * @param directoryName
	 *            The name of the directory.
	 */
	public void setDirectoryName(String directoryName) {
		this.directoryName = directoryName;
	}

	/**
	 * Returns the experiment group used by this writer.
	 * 
	 * @return The experiment group this writer is using.
	 */
	public ExperimentGroup getExperimentGroup() {
		return experimentGroup;
	}

	/**
	 * Returns the experiment setting of this writer.
	 * 
	 * @return The experiment setting of this writer.
	 */
	public ExperimentSetting getExperimentSetting() {
		return experimentSetting;
	}
	
	/**
	 * In this method an EDP2 experiment run is prepared by initializing all
	 * necessary EDP2 members.
	 */
	protected abstract void prepareExperimentRun();

	/**
	 * Converts a MeasurementMetric object to a BaseMetricDescription object.
	 * 
	 * @param measuredObject
	 *            The MeasurementMetric object.
	 * @return The converted BaseMetricDescription object.
	 */
	protected BaseMetricDescription convertMeasurementMetricToBaseMetricDescription(
			MeasurementMetric measuredObject) {
		BaseMetricDescription desc = ExperimentDataFactory.eINSTANCE
				.createBaseMetricDescription();

		// CaptureType:
		if (measuredObject.getCaptureType() == de.uka.ipd.sdq.pipesandfilters.framework.CaptureType.NATURAL_NUMBER) {
			desc
					.setCaptureType(de.uka.ipd.sdq.edp2.models.ExperimentData.CaptureType.NATURAL_NUMBER);
		} else if (measuredObject.getCaptureType() == de.uka.ipd.sdq.pipesandfilters.framework.CaptureType.REAL_NUMBER) {
			desc
					.setCaptureType(de.uka.ipd.sdq.edp2.models.ExperimentData.CaptureType.REAL_NUMBER);
		}

		// DefaultUnit:
		desc.setDefaultUnit(measuredObject.getUnit());

		// Monotonic:
		if (measuredObject.isStrongMonotonic())
			desc.setMonotonic(Monotonic.STRONG);
		else if (measuredObject.isMonotonic())
			desc.setMonotonic(Monotonic.YES);
		else
			desc.setMonotonic(Monotonic.NO);

		// Name:
		desc.setName(measuredObject.getName());

		// Scale:
		if (measuredObject.getScale() == de.uka.ipd.sdq.pipesandfilters.framework.Scale.INTERVAL) {
			desc.setScale(de.uka.ipd.sdq.edp2.models.ExperimentData.Scale.INTERVAL);
		} else if (measuredObject.getScale() == de.uka.ipd.sdq.pipesandfilters.framework.Scale.NOMINAL) {
			desc.setScale(de.uka.ipd.sdq.edp2.models.ExperimentData.Scale.NOMINAL);
		} else if (measuredObject.getScale() == de.uka.ipd.sdq.pipesandfilters.framework.Scale.ORDINAL) {
			desc.setScale(de.uka.ipd.sdq.edp2.models.ExperimentData.Scale.ORDINAL);
		} else if (measuredObject.getScale() == de.uka.ipd.sdq.pipesandfilters.framework.Scale.RATIO) {
			desc.setScale(de.uka.ipd.sdq.edp2.models.ExperimentData.Scale.RATIO);
		}

		// Description:
		desc.setTextualDescription(measuredObject.getDescription());

		return desc;
	}
	
	/**
	 * The initializing meta data provided by the recorder is used to define all
	 * metrics which are necessary for the EDP2.
	 */
	public void initialize(MetaDataInit metaData) {

		EDP2MetaDataInit edp2MetaData;

		if (metaData instanceof EDP2MetaDataInit) {
			edp2MetaData = (EDP2MetaDataInit) metaData;
		} else {
			throw new IllegalArgumentException(
					"Argument metaData must be of the type EDP2MetaDataInit");
		}

		// Initialize the metric
		metric = ExperimentDataFactory.eINSTANCE.createMetricSetDescription();
		metric.setName(edp2MetaData.getMetricName());

		for (MeasurementMetric measuredObject : edp2MetaData
				.getMeasuredMetrics()) {

			BaseMetricDescription desc = convertMeasurementMetricToBaseMetricDescription(measuredObject);
			metric.getSubsumedMetrics().add(desc);
		}

		// Initialize measure
		measure = ExperimentDataFactory.eINSTANCE.createOrdinalMeasure();
		measure.setPersistencyKind(PersistenceKindOptions.BINARY_PREFERRED);
		measure.setMetric(metric);
		measure.setMeasuredObject(edp2MetaData.getMeasurementName());
		// Important: Identifiers are not supported by the probespec so far
		// because ordinal values are used instead to represent nominal values.
		// If identifiers should be allowed, the initial identifier must
		// be set here.

		// Get experiment setting
		experimentSetting = edp2MetaData.getExperimentSetting();
		//experimentSetting.getMeasure().add(measure);

		// Get experiment group
		experimentGroup = edp2MetaData.getExperimentGroup();
		experimentGroup.getExperimentSettings().add(experimentSetting);
		experimentGroup.getMeasure().add(measure);

		// Get experiment run
		experimentRun = edp2MetaData.getExperimentRun();

		// Set up measurement
		measurement = ExperimentDataFactory.eINSTANCE.createMeasurement();
		measurement.setMeasure(measure);
		measurement.getAdditionalInformation().put("ModelElementID",
				metaData.getModelElementID());

		prepareExperimentRun();
	}
	
	/**
	 * This method writes given measurement data to the EDP2.
	 */
	public void writeData(PipeData pipeData) {
		Object[] data = new Object[pipeData.getTupleSize()];
		
		for (int i = 0; i < pipeData.getTupleSize(); i++) {
			data[i] = pipeData.getTupleElement(i);
		}

		MeasurementsUtility.storeMeasurement(measurement, data);
	}
	
	/**
	 * This method should end the current experiment and close the data output
	 * stream.
	 */
	public abstract void flush();
}
