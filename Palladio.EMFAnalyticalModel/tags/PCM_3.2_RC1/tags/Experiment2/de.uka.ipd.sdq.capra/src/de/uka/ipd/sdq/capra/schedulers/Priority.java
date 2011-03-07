/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.schedulers;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Priority</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.schedulers.Priority#isHasDynamicPriority <em>Has Dynamic Priority</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.schedulers.Priority#getPreference <em>Preference</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.capra.schedulers.SchedulersPackage#getPriority()
 * @model
 * @generated
 */
public interface Priority extends SelectionPolicy {
	/**
	 * Returns the value of the '<em><b>Has Dynamic Priority</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Dynamic Priority</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Dynamic Priority</em>' attribute.
	 * @see #setHasDynamicPriority(boolean)
	 * @see de.uka.ipd.sdq.capra.schedulers.SchedulersPackage#getPriority_HasDynamicPriority()
	 * @model required="true"
	 * @generated
	 */
	boolean isHasDynamicPriority();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.schedulers.Priority#isHasDynamicPriority <em>Has Dynamic Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Has Dynamic Priority</em>' attribute.
	 * @see #isHasDynamicPriority()
	 * @generated
	 */
	void setHasDynamicPriority(boolean value);

	/**
	 * Returns the value of the '<em><b>Preference</b></em>' attribute.
	 * The literals are from the enumeration {@link de.uka.ipd.sdq.capra.schedulers.Preference}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Preference</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Preference</em>' attribute.
	 * @see de.uka.ipd.sdq.capra.schedulers.Preference
	 * @see #setPreference(Preference)
	 * @see de.uka.ipd.sdq.capra.schedulers.SchedulersPackage#getPriority_Preference()
	 * @model required="true"
	 * @generated
	 */
	Preference getPreference();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.schedulers.Priority#getPreference <em>Preference</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Preference</em>' attribute.
	 * @see de.uka.ipd.sdq.capra.schedulers.Preference
	 * @see #getPreference()
	 * @generated
	 */
	void setPreference(Preference value);

} // Priority
