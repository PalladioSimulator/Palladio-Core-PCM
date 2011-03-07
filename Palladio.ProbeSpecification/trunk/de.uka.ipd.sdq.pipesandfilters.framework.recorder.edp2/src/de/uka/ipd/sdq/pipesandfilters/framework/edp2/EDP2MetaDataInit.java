package de.uka.ipd.sdq.pipesandfilters.framework.edp2;

import java.util.Date;
import java.util.Vector;

import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataFactory;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentGroup;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentRun;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentSetting;
import de.uka.ipd.sdq.pipesandfilters.framework.MeasurementMetric;
import de.uka.ipd.sdq.pipesandfilters.framework.MetaDataInit;

/**
 * This class contains all meta data information necessary for EDP2 data. This
 * includes the specification of an EDP2 experimentGroup, experimentSetting and
 * experimentGroup.
 * 
 * @author Baum
 * 
 */
public class EDP2MetaDataInit extends MetaDataInit {

	private ExperimentRun experimentRun;
	private ExperimentSetting experimentSetting;
	private ExperimentGroup experimentGroup;

	/**
	 * The constructor of EDP2MetaDataInit. This constructor also instantiate
	 * the experiment setting, experiment setting and experiment group.
	 * 
	 * @param measuredMetrics
	 *            A vector of all measured metrics of a calculator.
	 */
	public EDP2MetaDataInit(Vector<MeasurementMetric> measuredMetrics) {
		super(measuredMetrics);

		experimentRun = ExperimentDataFactory.eINSTANCE.createExperimentRun();
		experimentRun.setStartTime(new Date());
		experimentSetting = ExperimentDataFactory.eINSTANCE.createExperimentSetting();
		experimentGroup = ExperimentDataFactory.eINSTANCE.createExperimentGroup();
	}

	/**
	 * The constructor of EDP2MetaDataInit. This constructor also instantiate
	 * the experiment setting, experiment setting and experiment group.
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
	public EDP2MetaDataInit(Vector<MeasurementMetric> measuredObjects,
			String metricName, String measurementName, String experimentName) {

		super(measuredObjects, metricName, measurementName, experimentName);

		experimentRun = ExperimentDataFactory.eINSTANCE.createExperimentRun();
		experimentRun.setStartTime(new Date());
		experimentSetting = ExperimentDataFactory.eINSTANCE.createExperimentSetting();
		experimentSetting.setDescription(experimentName);
		experimentGroup = ExperimentDataFactory.eINSTANCE.createExperimentGroup();
	}

	/**
	 * The constructor of EDP2MetaDataInit.
	 * 
	 * @param measuredMetrics
	 *            A vector of all measured metrics of a calculator.
	 * @param experimentGroup
	 *            The experiment group of the initialized EDP2 experiment run.
	 * @param experimentSetting
	 *            The experiment setting of the initialized EDP2 experiment run.
	 */
	public EDP2MetaDataInit(Vector<MeasurementMetric> measuredMetrics,
			ExperimentGroup experimentGroup, ExperimentSetting experimentSetting) {

		super(measuredMetrics);

		experimentRun = ExperimentDataFactory.eINSTANCE.createExperimentRun();
		experimentRun.setStartTime(new Date());
		this.experimentSetting = experimentSetting;
		setExperimentName(experimentSetting.getDescription());
		this.experimentGroup = experimentGroup;
	}

	/**
	 * Sets the name of the experiment.
	 * 
	 * @param experimentName
	 *            The name of the experiment.
	 */
	public void setExperimentName(String experimentName) {
		super.setExperimentName(experimentName);
		experimentSetting.setDescription(experimentName);
	}

	/**
	 * Returns the experiment run.
	 * 
	 * @return The experiment run object.
	 */
	public ExperimentRun getExperimentRun() {
		return experimentRun;
	}

	/**
	 * Returns the experiment setting.
	 * 
	 * @return The experiment setting object.
	 */
	public ExperimentSetting getExperimentSetting() {
		return experimentSetting;
	}

	/**
	 * Returns the experiment group.
	 * 
	 * @return The experiment group object.
	 */
	public ExperimentGroup getExperimentGroup() {
		return experimentGroup;
	}
}
