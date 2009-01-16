/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensorframework.impl;

import de.uka.ipd.sdq.sensorframework.*;

import java.util.Map;

import javax.measure.Measure;

import javax.measure.unit.Unit;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class sensorframeworkFactoryImpl extends EFactoryImpl implements sensorframeworkFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static sensorframeworkFactory init() {
		try {
			sensorframeworkFactory thesensorframeworkFactory = (sensorframeworkFactory)EPackage.Registry.INSTANCE.getEFactory("http://sdq.ipd.uka.de/SensorFramework/2.0.0"); 
			if (thesensorframeworkFactory != null) {
				return thesensorframeworkFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new sensorframeworkFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public sensorframeworkFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case sensorframeworkPackage.MEASUREMENT_RANGE: return createMeasurementRange();
			case sensorframeworkPackage.STATISTICS: return createStatistics();
			case sensorframeworkPackage.COLLECTED_DATA: return createCollectedData();
			case sensorframeworkPackage.ESTRINGTO_EOBJECT_MAP_ENTRY: return (EObject)createEStringtoEObjectMapEntry();
			case sensorframeworkPackage.EXPERIMENT_SETTING: return createExperimentSetting();
			case sensorframeworkPackage.EXPERIMENT_RUN: return createExperimentRun();
			case sensorframeworkPackage.MEASURE_CHARACTERIZATION: return createMeasureCharacterization();
			case sensorframeworkPackage.LONG_MEASUREMENTS: return createLongMeasurements();
			case sensorframeworkPackage.STATE: return createState();
			case sensorframeworkPackage.STATE_MEASUREMENTS: return createStateMeasurements();
			case sensorframeworkPackage.STATE_SENSOR: return createStateSensor();
			case sensorframeworkPackage.DOUBLE_MEASUREMENTS: return createDoubleMeasurements();
			case sensorframeworkPackage.EXPERIMENT_GROUP: return createExperimentGroup();
			case sensorframeworkPackage.MEASURABLE_SENSOR: return createMeasurableSensor();
			case sensorframeworkPackage.JS_XML_MEASUREMENTS: return createJSXmlMeasurements();
			case sensorframeworkPackage.EVENT_TIME_AGGREGATION: return createEventTimeAggregation();
			case sensorframeworkPackage.INTERVALS: return createIntervals();
			case sensorframeworkPackage.VALUE_AGGREGATION: return createValueAggregation();
			case sensorframeworkPackage.INCREASING_MEASURABLE_SENSOR: return createIncreasingMeasurableSensor();
			case sensorframeworkPackage.ADVANCED_STATISTICS: return createAdvancedStatistics();
			case sensorframeworkPackage.JS_XML_EVENT_TIMES: return createJSXmlEventTimes();
			case sensorframeworkPackage.DOUBLE_EVENT_TIMES: return createDoubleEventTimes();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case sensorframeworkPackage.PERSISTENCE_KIND_OPTIONS:
				return createPersistenceKindOptionsFromString(eDataType, initialValue);
			case sensorframeworkPackage.EJS_MEASURE:
				return createEJSMeasureFromString(eDataType, initialValue);
			case sensorframeworkPackage.EJS_DURATION_MEASURE:
				return createEJSDurationMeasureFromString(eDataType, initialValue);
			case sensorframeworkPackage.EJS_UNIT:
				return createEJSUnitFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case sensorframeworkPackage.PERSISTENCE_KIND_OPTIONS:
				return convertPersistenceKindOptionsToString(eDataType, instanceValue);
			case sensorframeworkPackage.EJS_MEASURE:
				return convertEJSMeasureToString(eDataType, instanceValue);
			case sensorframeworkPackage.EJS_DURATION_MEASURE:
				return convertEJSDurationMeasureToString(eDataType, instanceValue);
			case sensorframeworkPackage.EJS_UNIT:
				return convertEJSUnitToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MeasurementRange createMeasurementRange() {
		MeasurementRangeImpl measurementRange = new MeasurementRangeImpl();
		return measurementRange;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Statistics createStatistics() {
		StatisticsImpl statistics = new StatisticsImpl();
		return statistics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CollectedData createCollectedData() {
		CollectedDataImpl collectedData = new CollectedDataImpl();
		return collectedData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Map.Entry<String, Object> createEStringtoEObjectMapEntry() {
		EStringtoEObjectMapEntryImpl eStringtoEObjectMapEntry = new EStringtoEObjectMapEntryImpl();
		return eStringtoEObjectMapEntry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExperimentSetting createExperimentSetting() {
		ExperimentSettingImpl experimentSetting = new ExperimentSettingImpl();
		return experimentSetting;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExperimentRun createExperimentRun() {
		ExperimentRunImpl experimentRun = new ExperimentRunImpl();
		return experimentRun;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MeasureCharacterization createMeasureCharacterization() {
		MeasureCharacterizationImpl measureCharacterization = new MeasureCharacterizationImpl();
		return measureCharacterization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LongMeasurements createLongMeasurements() {
		LongMeasurementsImpl longMeasurements = new LongMeasurementsImpl();
		return longMeasurements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public State createState() {
		StateImpl state = new StateImpl();
		return state;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateMeasurements createStateMeasurements() {
		StateMeasurementsImpl stateMeasurements = new StateMeasurementsImpl();
		return stateMeasurements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateSensor createStateSensor() {
		StateSensorImpl stateSensor = new StateSensorImpl();
		return stateSensor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoubleMeasurements createDoubleMeasurements() {
		DoubleMeasurementsImpl doubleMeasurements = new DoubleMeasurementsImpl();
		return doubleMeasurements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExperimentGroup createExperimentGroup() {
		ExperimentGroupImpl experimentGroup = new ExperimentGroupImpl();
		return experimentGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MeasurableSensor createMeasurableSensor() {
		MeasurableSensorImpl measurableSensor = new MeasurableSensorImpl();
		return measurableSensor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JSXmlMeasurements createJSXmlMeasurements() {
		JSXmlMeasurementsImpl jsXmlMeasurements = new JSXmlMeasurementsImpl();
		return jsXmlMeasurements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EventTimeAggregation createEventTimeAggregation() {
		EventTimeAggregationImpl eventTimeAggregation = new EventTimeAggregationImpl();
		return eventTimeAggregation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Intervals createIntervals() {
		IntervalsImpl intervals = new IntervalsImpl();
		return intervals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValueAggregation createValueAggregation() {
		ValueAggregationImpl valueAggregation = new ValueAggregationImpl();
		return valueAggregation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IncreasingMeasurableSensor createIncreasingMeasurableSensor() {
		IncreasingMeasurableSensorImpl increasingMeasurableSensor = new IncreasingMeasurableSensorImpl();
		return increasingMeasurableSensor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdvancedStatistics createAdvancedStatistics() {
		AdvancedStatisticsImpl advancedStatistics = new AdvancedStatisticsImpl();
		return advancedStatistics;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JSXmlEventTimes createJSXmlEventTimes() {
		JSXmlEventTimesImpl jsXmlEventTimes = new JSXmlEventTimesImpl();
		return jsXmlEventTimes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoubleEventTimes createDoubleEventTimes() {
		DoubleEventTimesImpl doubleEventTimes = new DoubleEventTimesImpl();
		return doubleEventTimes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PersistenceKindOptions createPersistenceKindOptionsFromString(EDataType eDataType, String initialValue) {
		PersistenceKindOptions result = PersistenceKindOptions.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPersistenceKindOptionsToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Measure createEJSMeasureFromString(EDataType eDataType, String initialValue) {
		return (Measure)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEJSMeasureToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Measure createEJSDurationMeasureFromString(EDataType eDataType, String initialValue) {
		return (Measure)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEJSDurationMeasureToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Unit createEJSUnitFromString(EDataType eDataType, String initialValue) {
		return (Unit)super.createFromString(eDataType, initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEJSUnitToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(eDataType, instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public sensorframeworkPackage getsensorframeworkPackage() {
		return (sensorframeworkPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static sensorframeworkPackage getPackage() {
		return sensorframeworkPackage.eINSTANCE;
	}

} //sensorframeworkFactoryImpl
