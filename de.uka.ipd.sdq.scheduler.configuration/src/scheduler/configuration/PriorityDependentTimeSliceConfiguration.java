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
 *   <li>{@link scheduler.configuration.PriorityDependentTimeSliceConfiguration#getMinTimeToBeScheduled <em>Min Time To Be Scheduled</em>}</li>
 * </ul>
 * </p>
 *
 * @see scheduler.configuration.ConfigurationPackage#getPriorityDependentTimeSliceConfiguration()
 * @model
 * @generated
 */
public interface PriorityDependentTimeSliceConfiguration extends TimeSliceConfiguration {
	/**
	 * Returns the value of the '<em><b>Min Timeslice</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Timeslice</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Timeslice</em>' attribute.
	 * @see #setMinTimeslice(double)
	 * @see scheduler.configuration.ConfigurationPackage#getPriorityDependentTimeSliceConfiguration_MinTimeslice()
	 * @model
	 * @generated
	 */
	double getMinTimeslice();

	/**
	 * Sets the value of the '{@link scheduler.configuration.PriorityDependentTimeSliceConfiguration#getMinTimeslice <em>Min Timeslice</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Timeslice</em>' attribute.
	 * @see #getMinTimeslice()
	 * @generated
	 */
	void setMinTimeslice(double value);

	/**
	 * Returns the value of the '<em><b>Min Time To Be Scheduled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Min Time To Be Scheduled</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Min Time To Be Scheduled</em>' attribute.
	 * @see #setMinTimeToBeScheduled(double)
	 * @see scheduler.configuration.ConfigurationPackage#getPriorityDependentTimeSliceConfiguration_MinTimeToBeScheduled()
	 * @model
	 * @generated
	 */
	double getMinTimeToBeScheduled();

	/**
	 * Sets the value of the '{@link scheduler.configuration.PriorityDependentTimeSliceConfiguration#getMinTimeToBeScheduled <em>Min Time To Be Scheduled</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Min Time To Be Scheduled</em>' attribute.
	 * @see #getMinTimeToBeScheduled()
	 * @generated
	 */
	void setMinTimeToBeScheduled(double value);

} // PriorityDependentTimeSliceConfiguration
