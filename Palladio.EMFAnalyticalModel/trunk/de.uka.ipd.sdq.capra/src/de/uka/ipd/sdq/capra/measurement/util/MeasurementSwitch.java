/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.measurement.util;

import de.uka.ipd.sdq.capra.core.Action;

import de.uka.ipd.sdq.capra.measurement.*;

import java.util.List;

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
 * @see de.uka.ipd.sdq.capra.measurement.MeasurementPackage
 * @generated
 */
public class MeasurementSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static MeasurementPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MeasurementSwitch() {
		if (modelPackage == null) {
			modelPackage = MeasurementPackage.eINSTANCE;
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
			case MeasurementPackage.TIME_PROBE: {
				TimeProbe timeProbe = (TimeProbe)theEObject;
				T result = caseTimeProbe(timeProbe);
				if (result == null) result = caseProbeAction(timeProbe);
				if (result == null) result = caseAction(timeProbe);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MeasurementPackage.PROBE_ACTION: {
				ProbeAction probeAction = (ProbeAction)theEObject;
				T result = caseProbeAction(probeAction);
				if (result == null) result = caseAction(probeAction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MeasurementPackage.TIME_SPAN_SENSOR: {
				TimeSpanSensor timeSpanSensor = (TimeSpanSensor)theEObject;
				T result = caseTimeSpanSensor(timeSpanSensor);
				if (result == null) result = caseSensor(timeSpanSensor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MeasurementPackage.SENSOR: {
				Sensor sensor = (Sensor)theEObject;
				T result = caseSensor(sensor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MeasurementPackage.TIME_SPAN_RECORDER: {
				TimeSpanRecorder timeSpanRecorder = (TimeSpanRecorder)theEObject;
				T result = caseTimeSpanRecorder(timeSpanRecorder);
				if (result == null) result = caseRecorder(timeSpanRecorder);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MeasurementPackage.RECORDER: {
				Recorder recorder = (Recorder)theEObject;
				T result = caseRecorder(recorder);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MeasurementPackage.CONDITION: {
				Condition condition = (Condition)theEObject;
				T result = caseCondition(condition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MeasurementPackage.VISIT_PROBE: {
				VisitProbe visitProbe = (VisitProbe)theEObject;
				T result = caseVisitProbe(visitProbe);
				if (result == null) result = caseProbeAction(visitProbe);
				if (result == null) result = caseAction(visitProbe);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MeasurementPackage.STATE_SENSOR: {
				StateSensor stateSensor = (StateSensor)theEObject;
				T result = caseStateSensor(stateSensor);
				if (result == null) result = caseSensor(stateSensor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MeasurementPackage.STATE_RECORDER: {
				StateRecorder stateRecorder = (StateRecorder)theEObject;
				T result = caseStateRecorder(stateRecorder);
				if (result == null) result = caseRecorder(stateRecorder);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MeasurementPackage.COUNTING_SENSOR: {
				CountingSensor countingSensor = (CountingSensor)theEObject;
				T result = caseCountingSensor(countingSensor);
				if (result == null) result = caseSensor(countingSensor);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MeasurementPackage.COUNTING_RECORDER: {
				CountingRecorder countingRecorder = (CountingRecorder)theEObject;
				T result = caseCountingRecorder(countingRecorder);
				if (result == null) result = caseRecorder(countingRecorder);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MeasurementPackage.HISTOGRAM_RECORDER: {
				HistogramRecorder histogramRecorder = (HistogramRecorder)theEObject;
				T result = caseHistogramRecorder(histogramRecorder);
				if (result == null) result = caseTimeSpanRecorder(histogramRecorder);
				if (result == null) result = caseRecorder(histogramRecorder);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MeasurementPackage.FULL_TIME_SPAN_RECORDER: {
				FullTimeSpanRecorder fullTimeSpanRecorder = (FullTimeSpanRecorder)theEObject;
				T result = caseFullTimeSpanRecorder(fullTimeSpanRecorder);
				if (result == null) result = caseTimeSpanRecorder(fullTimeSpanRecorder);
				if (result == null) result = caseRecorder(fullTimeSpanRecorder);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MeasurementPackage.STEADY_STATE_RECORDER: {
				SteadyStateRecorder steadyStateRecorder = (SteadyStateRecorder)theEObject;
				T result = caseSteadyStateRecorder(steadyStateRecorder);
				if (result == null) result = caseStateRecorder(steadyStateRecorder);
				if (result == null) result = caseRecorder(steadyStateRecorder);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MeasurementPackage.FULL_STATE_RECORDER: {
				FullStateRecorder fullStateRecorder = (FullStateRecorder)theEObject;
				T result = caseFullStateRecorder(fullStateRecorder);
				if (result == null) result = caseStateRecorder(fullStateRecorder);
				if (result == null) result = caseRecorder(fullStateRecorder);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case MeasurementPackage.FINAL_VALUE_RECORDER: {
				FinalValueRecorder finalValueRecorder = (FinalValueRecorder)theEObject;
				T result = caseFinalValueRecorder(finalValueRecorder);
				if (result == null) result = caseCountingRecorder(finalValueRecorder);
				if (result == null) result = caseRecorder(finalValueRecorder);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Time Probe</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Time Probe</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTimeProbe(TimeProbe object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Probe Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Probe Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProbeAction(ProbeAction object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Time Span Sensor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Time Span Sensor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTimeSpanSensor(TimeSpanSensor object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Sensor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Sensor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSensor(Sensor object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Time Span Recorder</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Time Span Recorder</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTimeSpanRecorder(TimeSpanRecorder object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Recorder</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Recorder</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRecorder(Recorder object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Condition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Condition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCondition(Condition object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Visit Probe</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Visit Probe</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVisitProbe(VisitProbe object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>State Sensor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>State Sensor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStateSensor(StateSensor object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>State Recorder</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>State Recorder</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStateRecorder(StateRecorder object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Counting Sensor</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Counting Sensor</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCountingSensor(CountingSensor object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Counting Recorder</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Counting Recorder</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCountingRecorder(CountingRecorder object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Histogram Recorder</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Histogram Recorder</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseHistogramRecorder(HistogramRecorder object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Full Time Span Recorder</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Full Time Span Recorder</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFullTimeSpanRecorder(FullTimeSpanRecorder object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Steady State Recorder</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Steady State Recorder</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSteadyStateRecorder(SteadyStateRecorder object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Full State Recorder</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Full State Recorder</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFullStateRecorder(FullStateRecorder object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Final Value Recorder</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Final Value Recorder</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFinalValueRecorder(FinalValueRecorder object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>Action</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>Action</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAction(Action object) {
		return null;
	}

	/**
	 * Returns the result of interpretting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpretting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //MeasurementSwitch
