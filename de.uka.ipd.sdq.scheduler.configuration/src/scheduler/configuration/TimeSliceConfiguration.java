/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scheduler.configuration;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Time Slice Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link scheduler.configuration.TimeSliceConfiguration#getTimeslice <em>Timeslice</em>}</li>
 * </ul>
 * </p>
 *
 * @see scheduler.configuration.ConfigurationPackage#getTimeSliceConfiguration()
 * @model abstract="true"
 * @generated
 */
public interface TimeSliceConfiguration extends EObject {
	/**
	 * Returns the value of the '<em><b>Timeslice</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Timeslice</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Timeslice</em>' attribute.
	 * @see #setTimeslice(double)
	 * @see scheduler.configuration.ConfigurationPackage#getTimeSliceConfiguration_Timeslice()
	 * @model
	 * @generated
	 */
	double getTimeslice();

	/**
	 * Sets the value of the '{@link scheduler.configuration.TimeSliceConfiguration#getTimeslice <em>Timeslice</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timeslice</em>' attribute.
	 * @see #getTimeslice()
	 * @generated
	 */
	void setTimeslice(double value);

} // TimeSliceConfiguration
