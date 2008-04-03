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
 *   <li>{@link scheduler.configuration.TimeSliceConfiguration#getGranularity <em>Granularity</em>}</li>
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
	 * Returns the value of the '<em><b>Granularity</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Granularity</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Granularity</em>' attribute.
	 * @see #setGranularity(int)
	 * @see scheduler.configuration.ConfigurationPackage#getTimeSliceConfiguration_Granularity()
	 * @model default="1" required="true" ordered="false"
	 * @generated
	 */
	int getGranularity();

	/**
	 * Sets the value of the '{@link scheduler.configuration.TimeSliceConfiguration#getGranularity <em>Granularity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Granularity</em>' attribute.
	 * @see #getGranularity()
	 * @generated
	 */
	void setGranularity(int value);

	/**
	 * Returns the value of the '<em><b>Timeslice</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Timeslice</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Timeslice</em>' containment reference.
	 * @see #setTimeslice(TimeValue)
	 * @see scheduler.configuration.ConfigurationPackage#getTimeSliceConfiguration_Timeslice()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	TimeValue getTimeslice();

	/**
	 * Sets the value of the '{@link scheduler.configuration.TimeSliceConfiguration#getTimeslice <em>Timeslice</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Timeslice</em>' containment reference.
	 * @see #getTimeslice()
	 * @generated
	 */
	void setTimeslice(TimeValue value);

} // TimeSliceConfiguration
