/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.measurement;

import de.uka.ipd.sdq.capra.core.ProcessVariable;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Processor Share Sensor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.measurement.ProcessorShareSensor#getObservedProcess <em>Observed Process</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.capra.measurement.MeasurementPackage#getProcessorShareSensor()
 * @model
 * @generated
 */
public interface ProcessorShareSensor extends ResourceSensor, StateSensor {
	/**
	 * Returns the value of the '<em><b>Observed Process</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Observed Process</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Observed Process</em>' reference.
	 * @see #setObservedProcess(ProcessVariable)
	 * @see de.uka.ipd.sdq.capra.measurement.MeasurementPackage#getProcessorShareSensor_ObservedProcess()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ProcessVariable getObservedProcess();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.measurement.ProcessorShareSensor#getObservedProcess <em>Observed Process</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Observed Process</em>' reference.
	 * @see #getObservedProcess()
	 * @generated
	 */
	void setObservedProcess(ProcessVariable value);

} // ProcessorShareSensor
