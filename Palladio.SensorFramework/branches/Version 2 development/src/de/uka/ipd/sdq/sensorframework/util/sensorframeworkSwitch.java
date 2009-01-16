/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensorframework.util;

import de.uka.ipd.sdq.sensorframework.*;

import java.util.List;
import java.util.Map;

import javax.measure.quantity.Duration;
import javax.measure.quantity.Quantity;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.sensorframework.sensorframeworkPackage
 * @generated
 */
public class sensorframeworkSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static sensorframeworkPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public sensorframeworkSwitch() {
		if (modelPackage == null) {
			modelPackage = sensorframeworkPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case sensorframeworkPackage.AGGREGATED_MEASUREMENTS: {
				AggregatedMeasurements aggregatedMeasurements = (AggregatedMeasurements)theEObject;
				T result = caseAggregatedMeasurements(aggregatedMeasurements);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case sensorframeworkPackage.MEASUREMENT_RANGE: {
				MeasurementRange measurementRange = (MeasurementRange)theEObject;
				T result = caseMeasurementRange(measurementRange);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case sensorframeworkPackage.RAW_MEASUREMENTS: {
				RawMeasurements rawMeasurements = (RawMeasurements)theEObject;
				T result = caseRawMeasurements(rawMeasurements);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case sensorframeworkPackage.RAW_XVALUES: {
				RawXValues rawXValues = (RawXValues)theEObject;
				T result = caseRawXValues(rawXValues);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case sensorframeworkPackage.RAW_YVALUES: {
				RawYValues rawYValues = (RawYValues)theEObject;
				T result = caseRawYValues(rawYValues);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case sensorframeworkPackage.STATISTICS: {
				Statistics statistics = (Statistics)theEObject;
				T result = caseStatistics(statistics);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case sensorframeworkPackage.COLLECTED_DATA: {
				CollectedData collectedData = (CollectedData)theEObject;
				T result = caseCollectedData(collectedData);
				if (result == null) result = casePropertyable(collectedData);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case sensorframeworkPackage.PROPERTYABLE: {
				Propertyable propertyable = (Propertyable)theEObject;
				T result = casePropertyable(propertyable);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case sensorframeworkPackage.ESTRINGTO_EOBJECT_MAP_ENTRY: {
				@SuppressWarnings("unchecked") Map.Entry<String, Object> eStringtoEObjectMapEntry = (Map.Entry<String, Object>)theEObject;
				T result = caseEStringtoEObjectMapEntry(eStringtoEObjectMapEntry);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case sensorframeworkPackage.SENSOR_DECLARATION: {
				SensorDeclaration sensorDeclaration = (SensorDeclaration)theEObject;
				T result = caseSensorDeclaration(sensorDeclaration);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case sensorframeworkPackage.EXPERIMENT_SETTING: {
				ExperimentSetting experimentSetting = (ExperimentSetting)theEObject;
				T result = caseExperimentSetting(experimentSetting);
				if (result == null) result = casePropertyable(experimentSetting);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case sensorframeworkPackage.EXPERIMENT_RUN: {
				ExperimentRun experimentRun = (ExperimentRun)theEObject;
				T result = caseExperimentRun(experimentRun);
				if (result == null) result = casePropertyable(experimentRun);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case sensorframeworkPackage.MEASURE_CHARACTERIZATION: {
				MeasureCharacterization measureCharacterization = (MeasureCharacterization)theEObject;
				T result = caseMeasureCharacterization(measureCharacterization);
				if (result == null) result = casePropertyable(measureCharacterization);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case sensorframeworkPackage.LONG_MEASUREMENTS: {
				LongMeasurements longMeasurements = (LongMeasurements)theEObject;
				T result = caseLongMeasurements(longMeasurements);
				if (result == null) result = caseRawYValues(longMeasurements);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case sensorframeworkPackage.STATE: {
				State state = (State)theEObject;
				T result = caseState(state);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case sensorframeworkPackage.STATE_MEASUREMENTS: {
				StateMeasurements stateMeasurements = (StateMeasurements)theEObject;
				T result = caseStateMeasurements(stateMeasurements);
				if (result == null) result = caseRawYValues(stateMeasurements);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case sensorframeworkPackage.STATE_SENSOR: {
				StateSensor stateSensor = (StateSensor)theEObject;
				T result = caseStateSensor(stateSensor);
				if (result == null) result = caseSensorDeclaration(stateSensor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case sensorframeworkPackage.DOUBLE_MEASUREMENTS: {
				DoubleMeasurements doubleMeasurements = (DoubleMeasurements)theEObject;
				T result = caseDoubleMeasurements(doubleMeasurements);
				if (result == null) result = caseRawYValues(doubleMeasurements);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case sensorframeworkPackage.EXPERIMENT_GROUP: {
				ExperimentGroup experimentGroup = (ExperimentGroup)theEObject;
				T result = caseExperimentGroup(experimentGroup);
				if (result == null) result = casePropertyable(experimentGroup);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case sensorframeworkPackage.MEASURABLE_SENSOR: {
				MeasurableSensor measurableSensor = (MeasurableSensor)theEObject;
				T result = caseMeasurableSensor(measurableSensor);
				if (result == null) result = caseSensorDeclaration(measurableSensor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case sensorframeworkPackage.JS_XML_MEASUREMENTS: {
				JSXmlMeasurements jsXmlMeasurements = (JSXmlMeasurements)theEObject;
				T result = caseJSXmlMeasurements(jsXmlMeasurements);
				if (result == null) result = caseRawYValues(jsXmlMeasurements);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case sensorframeworkPackage.EVENT_TIME_AGGREGATION: {
				EventTimeAggregation eventTimeAggregation = (EventTimeAggregation)theEObject;
				T result = caseEventTimeAggregation(eventTimeAggregation);
				if (result == null) result = caseFixedWidthAggregation(eventTimeAggregation);
				if (result == null) result = caseAggregatedMeasurements(eventTimeAggregation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case sensorframeworkPackage.FIXED_WIDTH_AGGREGATION: {
				FixedWidthAggregation fixedWidthAggregation = (FixedWidthAggregation)theEObject;
				T result = caseFixedWidthAggregation(fixedWidthAggregation);
				if (result == null) result = caseAggregatedMeasurements(fixedWidthAggregation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case sensorframeworkPackage.INTERVALS: {
				Intervals intervals = (Intervals)theEObject;
				T result = caseIntervals(intervals);
				if (result == null) result = caseRawXValues(intervals);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case sensorframeworkPackage.VALUE_AGGREGATION: {
				ValueAggregation valueAggregation = (ValueAggregation)theEObject;
				T result = caseValueAggregation(valueAggregation);
				if (result == null) result = caseFixedWidthAggregation(valueAggregation);
				if (result == null) result = caseAggregatedMeasurements(valueAggregation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case sensorframeworkPackage.INCREASING_MEASURABLE_SENSOR: {
				IncreasingMeasurableSensor increasingMeasurableSensor = (IncreasingMeasurableSensor)theEObject;
				T result = caseIncreasingMeasurableSensor(increasingMeasurableSensor);
				if (result == null) result = caseMeasurableSensor(increasingMeasurableSensor);
				if (result == null) result = caseSensorDeclaration(increasingMeasurableSensor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case sensorframeworkPackage.ADVANCED_STATISTICS: {
				AdvancedStatistics advancedStatistics = (AdvancedStatistics)theEObject;
				T result = caseAdvancedStatistics(advancedStatistics);
				if (result == null) result = caseStatistics(advancedStatistics);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case sensorframeworkPackage.JS_XML_EVENT_TIMES: {
				JSXmlEventTimes jsXmlEventTimes = (JSXmlEventTimes)theEObject;
				T result = caseJSXmlEventTimes(jsXmlEventTimes);
				if (result == null) result = caseRawXValues(jsXmlEventTimes);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case sensorframeworkPackage.DOUBLE_EVENT_TIMES: {
				DoubleEventTimes doubleEventTimes = (DoubleEventTimes)theEObject;
				T result = caseDoubleEventTimes(doubleEventTimes);
				if (result == null) result = caseRawXValues(doubleEventTimes);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Aggregated Measurements</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Aggregated Measurements</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAggregatedMeasurements(AggregatedMeasurements object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Measurement Range</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Measurement Range</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMeasurementRange(MeasurementRange object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Raw Measurements</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Raw Measurements</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRawMeasurements(RawMeasurements object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Raw XValues</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Raw XValues</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRawXValues(RawXValues object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Raw YValues</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Raw YValues</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRawYValues(RawYValues object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Statistics</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Statistics</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStatistics(Statistics object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Collected Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Collected Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCollectedData(CollectedData object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Propertyable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Propertyable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePropertyable(Propertyable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EStringto EObject Map Entry</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EStringto EObject Map Entry</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEStringtoEObjectMapEntry(Map.Entry<String, Object> object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Sensor Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Sensor Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSensorDeclaration(SensorDeclaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Experiment Setting</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Experiment Setting</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExperimentSetting(ExperimentSetting object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Experiment Run</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Experiment Run</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExperimentRun(ExperimentRun object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Measure Characterization</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Measure Characterization</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMeasureCharacterization(MeasureCharacterization object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Long Measurements</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Long Measurements</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLongMeasurements(LongMeasurements object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseState(State object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>State Measurements</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>State Measurements</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStateMeasurements(StateMeasurements object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>State Sensor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>State Sensor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStateSensor(StateSensor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Double Measurements</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Double Measurements</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDoubleMeasurements(DoubleMeasurements object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Experiment Group</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Experiment Group</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExperimentGroup(ExperimentGroup object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Measurable Sensor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Measurable Sensor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMeasurableSensor(MeasurableSensor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JS Xml Measurements</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JS Xml Measurements</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJSXmlMeasurements(JSXmlMeasurements object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event Time Aggregation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event Time Aggregation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventTimeAggregation(EventTimeAggregation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Fixed Width Aggregation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Fixed Width Aggregation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFixedWidthAggregation(FixedWidthAggregation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Intervals</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Intervals</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntervals(Intervals object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Value Aggregation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Value Aggregation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseValueAggregation(ValueAggregation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Increasing Measurable Sensor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Increasing Measurable Sensor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIncreasingMeasurableSensor(IncreasingMeasurableSensor object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Advanced Statistics</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Advanced Statistics</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAdvancedStatistics(AdvancedStatistics object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>JS Xml Event Times</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>JS Xml Event Times</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseJSXmlEventTimes(JSXmlEventTimes object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Double Event Times</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Double Event Times</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDoubleEventTimes(DoubleEventTimes object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IJS Duration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IJS Duration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIJSDuration(Duration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>IJS Quantity</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>IJS Quantity</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIJSQuantity(Quantity object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //sensorframeworkSwitch
