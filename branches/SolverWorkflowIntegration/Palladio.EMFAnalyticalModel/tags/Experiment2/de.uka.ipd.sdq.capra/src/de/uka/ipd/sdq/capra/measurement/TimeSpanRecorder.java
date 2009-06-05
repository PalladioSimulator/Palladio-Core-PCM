/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.measurement;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Time Span Recorder</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.measurement.TimeSpanRecorder#getTimeSpanSensor <em>Time Span Sensor</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.capra.measurement.MeasurementPackage#getTimeSpanRecorder()
 * @model abstract="true"
 * @generated
 */
public interface TimeSpanRecorder extends Recorder {
	/**
	 * Returns the value of the '<em><b>Time Span Sensor</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.capra.measurement.TimeSpanSensor#getTimeSpanRecorders <em>Time Span Recorders</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Span Sensor</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Span Sensor</em>' container reference.
	 * @see #setTimeSpanSensor(TimeSpanSensor)
	 * @see de.uka.ipd.sdq.capra.measurement.MeasurementPackage#getTimeSpanRecorder_TimeSpanSensor()
	 * @see de.uka.ipd.sdq.capra.measurement.TimeSpanSensor#getTimeSpanRecorders
	 * @model opposite="timeSpanRecorders" required="true"
	 * @generated
	 */
	TimeSpanSensor getTimeSpanSensor();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.measurement.TimeSpanRecorder#getTimeSpanSensor <em>Time Span Sensor</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Span Sensor</em>' container reference.
	 * @see #getTimeSpanSensor()
	 * @generated
	 */
	void setTimeSpanSensor(TimeSpanSensor value);

} // TimeSpanRecorder
