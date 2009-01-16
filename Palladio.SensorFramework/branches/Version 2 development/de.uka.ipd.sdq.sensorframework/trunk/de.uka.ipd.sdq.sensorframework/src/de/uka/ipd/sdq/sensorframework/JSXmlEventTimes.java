/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensorframework;

import javax.measure.Measure;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>JS Xml Event Times</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Event times are stores as JScience durations.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensorframework.JSXmlEventTimes#getMeasurementTime <em>Measurement Time</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.sensorframework.sensorframeworkPackage#getJSXmlEventTimes()
 * @model
 * @generated
 */
public interface JSXmlEventTimes extends RawXValues {
	/**
	 * Returns the value of the '<em><b>Measurement Time</b></em>' attribute list.
	 * The list contents are of type {@link javax.measure.Measure}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Intentionally designed as array to allow efficient persistence. It refers to the point in time when the measurement is taken. Expresses the time passed since the start of the measuring.
	 * 
	 * For example, in a simulation environment this would mean simulation time passed since the start of the simulation. In a real world environment this would be the real time passed after the measurement has been started.
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Measurement Time</em>' attribute list.
	 * @see de.uka.ipd.sdq.sensorframework.sensorframeworkPackage#getJSXmlEventTimes_MeasurementTime()
	 * @model unique="false" dataType="de.uka.ipd.sdq.sensorframework.EJSDurationMeasure" ordered="false"
	 * @generated
	 */
	EList<Measure> getMeasurementTime();

} // JSXmlEventTimes
