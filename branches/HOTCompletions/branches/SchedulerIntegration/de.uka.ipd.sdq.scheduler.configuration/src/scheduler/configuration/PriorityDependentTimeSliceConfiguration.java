/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scheduler.configuration;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Priority Dependent Time Slice Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link scheduler.configuration.PriorityDependentTimeSliceConfiguration#getMinTimeslice <em>Min Timeslice</em>}</li>
 * </ul>
 * </p>
 *
 * @see scheduler.configuration.ConfigurationPackage#getPriorityDependentTimeSliceConfiguration()
 * @model
 * @generated
 */
public interface PriorityDependentTimeSliceConfiguration extends TimeSliceConfiguration {
	/**
	 * Returns the value of the '<em><b>Min Timeslice</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Timeslice</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Timeslice</em>' containment reference.
	 * @see #setMinTimeslice(TimeValue)
	 * @see scheduler.configuration.ConfigurationPackage#getPriorityDependentTimeSliceConfiguration_MinTimeslice()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	TimeValue getMinTimeslice();

	/**
	 * Sets the value of the '{@link scheduler.configuration.PriorityDependentTimeSliceConfiguration#getMinTimeslice <em>Min Timeslice</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Timeslice</em>' containment reference.
	 * @see #getMinTimeslice()
	 * @generated
	 */
	void setMinTimeslice(TimeValue value);

} // PriorityDependentTimeSliceConfiguration
