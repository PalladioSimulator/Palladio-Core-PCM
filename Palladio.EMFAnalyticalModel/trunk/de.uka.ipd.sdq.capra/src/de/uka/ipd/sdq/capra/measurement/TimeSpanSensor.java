/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.measurement;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Time Span Sensor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.measurement.TimeSpanSensor#getTimeSpanRecorders <em>Time Span Recorders</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.measurement.TimeSpanSensor#getStartMeasurement <em>Start Measurement</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.measurement.TimeSpanSensor#getStopMeasurement <em>Stop Measurement</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.capra.measurement.MeasurementPackage#getTimeSpanSensor()
 * @model
 * @generated
 */
public interface TimeSpanSensor extends Sensor {
	/**
	 * Returns the value of the '<em><b>Time Span Recorders</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.capra.measurement.TimeSpanRecorder}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.capra.measurement.TimeSpanRecorder#getTimeSpanSensor <em>Time Span Sensor</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Span Recorders</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Span Recorders</em>' containment reference list.
	 * @see de.uka.ipd.sdq.capra.measurement.MeasurementPackage#getTimeSpanSensor_TimeSpanRecorders()
	 * @see de.uka.ipd.sdq.capra.measurement.TimeSpanRecorder#getTimeSpanSensor
	 * @model type="de.uka.ipd.sdq.capra.measurement.TimeSpanRecorder" opposite="timeSpanSensor" containment="true"
	 * @generated
	 */
	EList<TimeSpanRecorder> getTimeSpanRecorders();

	/**
	 * Returns the value of the '<em><b>Start Measurement</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.capra.measurement.TimeProbe#getSensorsToStart <em>Sensors To Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start Measurement</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Measurement</em>' reference.
	 * @see #setStartMeasurement(TimeProbe)
	 * @see de.uka.ipd.sdq.capra.measurement.MeasurementPackage#getTimeSpanSensor_StartMeasurement()
	 * @see de.uka.ipd.sdq.capra.measurement.TimeProbe#getSensorsToStart
	 * @model opposite="sensorsToStart" required="true"
	 * @generated
	 */
	TimeProbe getStartMeasurement();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.measurement.TimeSpanSensor#getStartMeasurement <em>Start Measurement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Measurement</em>' reference.
	 * @see #getStartMeasurement()
	 * @generated
	 */
	void setStartMeasurement(TimeProbe value);

	/**
	 * Returns the value of the '<em><b>Stop Measurement</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.capra.measurement.TimeProbe#getSensorsToStop <em>Sensors To Stop</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stop Measurement</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stop Measurement</em>' reference.
	 * @see #setStopMeasurement(TimeProbe)
	 * @see de.uka.ipd.sdq.capra.measurement.MeasurementPackage#getTimeSpanSensor_StopMeasurement()
	 * @see de.uka.ipd.sdq.capra.measurement.TimeProbe#getSensorsToStop
	 * @model opposite="sensorsToStop" required="true"
	 * @generated
	 */
	TimeProbe getStopMeasurement();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.measurement.TimeSpanSensor#getStopMeasurement <em>Stop Measurement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stop Measurement</em>' reference.
	 * @see #getStopMeasurement()
	 * @generated
	 */
	void setStopMeasurement(TimeProbe value);

} // TimeSpanSensor
