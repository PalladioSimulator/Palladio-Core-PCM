/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.measurement;

import de.uka.ipd.sdq.capra.resources.ActiveResource;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Resource Sensor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.measurement.ResourceSensor#getObservedResource <em>Observed Resource</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.capra.measurement.MeasurementPackage#getResourceSensor()
 * @model abstract="true"
 * @generated
 */
public interface ResourceSensor extends Sensor {
	/**
	 * Returns the value of the '<em><b>Observed Resource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Observed Resource</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Observed Resource</em>' reference.
	 * @see #setObservedResource(ActiveResource)
	 * @see de.uka.ipd.sdq.capra.measurement.MeasurementPackage#getResourceSensor_ObservedResource()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ActiveResource getObservedResource();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.measurement.ResourceSensor#getObservedResource <em>Observed Resource</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Observed Resource</em>' reference.
	 * @see #getObservedResource()
	 * @generated
	 */
	void setObservedResource(ActiveResource value);

} // ResourceSensor
