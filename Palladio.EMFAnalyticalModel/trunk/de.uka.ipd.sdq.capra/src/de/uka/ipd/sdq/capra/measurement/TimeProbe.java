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
 * A representation of the model object '<em><b>Time Probe</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.measurement.TimeProbe#getSensorsToStart <em>Sensors To Start</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.measurement.TimeProbe#getSensorsToStop <em>Sensors To Stop</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.capra.measurement.MeasurementPackage#getTimeProbe()
 * @model
 * @generated
 */
public interface TimeProbe extends ProbeAction {
	/**
	 * Returns the value of the '<em><b>Sensors To Start</b></em>' reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.capra.measurement.TimeSpanSensor}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.capra.measurement.TimeSpanSensor#getStartMeasurement <em>Start Measurement</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sensors To Start</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sensors To Start</em>' reference list.
	 * @see de.uka.ipd.sdq.capra.measurement.MeasurementPackage#getTimeProbe_SensorsToStart()
	 * @see de.uka.ipd.sdq.capra.measurement.TimeSpanSensor#getStartMeasurement
	 * @model type="de.uka.ipd.sdq.capra.measurement.TimeSpanSensor" opposite="startMeasurement"
	 * @generated
	 */
	EList<TimeSpanSensor> getSensorsToStart();

	/**
	 * Returns the value of the '<em><b>Sensors To Stop</b></em>' reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.capra.measurement.TimeSpanSensor}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.capra.measurement.TimeSpanSensor#getStopMeasurement <em>Stop Measurement</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sensors To Stop</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sensors To Stop</em>' reference list.
	 * @see de.uka.ipd.sdq.capra.measurement.MeasurementPackage#getTimeProbe_SensorsToStop()
	 * @see de.uka.ipd.sdq.capra.measurement.TimeSpanSensor#getStopMeasurement
	 * @model type="de.uka.ipd.sdq.capra.measurement.TimeSpanSensor" opposite="stopMeasurement"
	 * @generated
	 */
	EList<TimeSpanSensor> getSensorsToStop();

} // TimeProbe
