/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensorframework.models.emfmodel.impl;

import de.uka.ipd.sdq.sensorframework.models.emfmodel.*;

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
public class emfmodelFactoryImpl extends EFactoryImpl implements emfmodelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static emfmodelFactory init() {
		try {
			emfmodelFactory theemfmodelFactory = (emfmodelFactory)EPackage.Registry.INSTANCE.getEFactory("http://sdq.ipd.uka.de/SensorFramework/2.0.0"); 
			if (theemfmodelFactory != null) {
				return theemfmodelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new emfmodelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public emfmodelFactoryImpl() {
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
			case emfmodelPackage.MEASUREMENT_RANGE: return createMeasurementRange();
			case emfmodelPackage.STATISTICS: return createStatistics();
			case emfmodelPackage.INTERVALS: return createIntervals();
			case emfmodelPackage.COLLECTED_DATA: return createCollectedData();
			case emfmodelPackage.ESTRINGTO_EOBJECT_MAP_ENTRY: return (EObject)createEStringtoEObjectMapEntry();
			case emfmodelPackage.EXPERIMENT_SETTING: return createExperimentSetting();
			case emfmodelPackage.EXPERIMENT_RUN: return createExperimentRun();
			case emfmodelPackage.MEASURE_CHARACTERIZATION: return createMeasureCharacterization();
			case emfmodelPackage.AGGREGATION_CHARACTERIZATION: return createAggregationCharacterization();
			case emfmodelPackage.LONG_BINARY_MEASUREMENTS: return createLongBinaryMeasurements();
			case emfmodelPackage.STATE: return createState();
			case emfmodelPackage.STATE_MEASUREMENTS: return createStateMeasurements();
			case emfmodelPackage.STATE_SENSOR: return createStateSensor();
			case emfmodelPackage.DOUBLE_BINARY_MEASUREMENTS: return createDoubleBinaryMeasurements();
			case emfmodelPackage.EXPERIMENT_GROUP: return createExperimentGroup();
			case emfmodelPackage.MEASURABLE_SENSOR: return createMeasurableSensor();
			case emfmodelPackage.JS_XML_MEASUREMENTS: return createJSXmlMeasurements();
			case emfmodelPackage.EVENT_TIME_AGGREGATION: return createEventTimeAggregation();
			case emfmodelPackage.VALUE_AGGREGATION: return createValueAggregation();
			case emfmodelPackage.INCREASING_MEASURABLE_SENSOR: return createIncreasingMeasurableSensor();
			case emfmodelPackage.ADVANCED_STATISTICS: return createAdvancedStatistics();
			case emfmodelPackage.DOUBLE_BINARY_EVENT_TIMES: return createDoubleBinaryEventTimes();
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
			case emfmodelPackage.PERSISTENCE_KIND_OPTIONS:
				return createPersistenceKindOptionsFromString(eDataType, initialValue);
			case emfmodelPackage.EJS_MEASURE:
				return createEJSMeasureFromString(eDataType, initialValue);
			case emfmodelPackage.EJS_DURATION_MEASURE:
				return createEJSDurationMeasureFromString(eDataType, initialValue);
			case emfmodelPackage.EJS_UNIT:
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
			case emfmodelPackage.PERSISTENCE_KIND_OPTIONS:
				return convertPersistenceKindOptionsToString(eDataType, instanceValue);
			case emfmodelPackage.EJS_MEASURE:
				return convertEJSMeasureToString(eDataType, instanceValue);
			case emfmodelPackage.EJS_DURATION_MEASURE:
				return convertEJSDurationMeasureToString(eDataType, instanceValue);
			case emfmodelPackage.EJS_UNIT:
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
	public Intervals createIntervals() {
		IntervalsImpl intervals = new IntervalsImpl();
		return intervals;
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
	public AggregationCharacterization createAggregationCharacterization() {
		AggregationCharacterizationImpl aggregationCharacterization = new AggregationCharacterizationImpl();
		return aggregationCharacterization;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LongBinaryMeasurements createLongBinaryMeasurements() {
		LongBinaryMeasurementsImpl longBinaryMeasurements = new LongBinaryMeasurementsImpl();
		return longBinaryMeasurements;
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
	public DoubleBinaryMeasurements createDoubleBinaryMeasurements() {
		DoubleBinaryMeasurementsImpl doubleBinaryMeasurements = new DoubleBinaryMeasurementsImpl();
		return doubleBinaryMeasurements;
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
	public DoubleBinaryEventTimes createDoubleBinaryEventTimes() {
		DoubleBinaryEventTimesImpl doubleBinaryEventTimes = new DoubleBinaryEventTimesImpl();
		return doubleBinaryEventTimes;
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
	public emfmodelPackage getemfmodelPackage() {
		return (emfmodelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static emfmodelPackage getPackage() {
		return emfmodelPackage.eINSTANCE;
	}

} //emfmodelFactoryImpl
