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
 * A representation of the model object '<em><b>Preemption Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link scheduler.configuration.PreemptionConfiguration#getTimesliceConfiguration <em>Timeslice Configuration</em>}</li>
 * </ul>
 * </p>
 *
 * @see scheduler.configuration.ConfigurationPackage#getPreemptionConfiguration()
 * @model
 * @generated
 */
public interface PreemptionConfiguration extends EObject {
	/**
	 * Returns the value of the '<em><b>Timeslice Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Timeslice Configuration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Timeslice Configuration</em>' containment reference.
	 * @see #setTimesliceConfiguration(TimeSliceConfiguration)
	 * @see scheduler.configuration.ConfigurationPackage#getPreemptionConfiguration_TimesliceConfiguration()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	TimeSliceConfiguration getTimesliceConfiguration();

	/**
	 * Sets the value of the '{@link scheduler.configuration.PreemptionConfiguration#getTimesliceConfiguration <em>Timeslice Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timeslice Configuration</em>' containment reference.
	 * @see #getTimesliceConfiguration()
	 * @generated
	 */
	void setTimesliceConfiguration(TimeSliceConfiguration value);

} // PreemptionConfiguration
