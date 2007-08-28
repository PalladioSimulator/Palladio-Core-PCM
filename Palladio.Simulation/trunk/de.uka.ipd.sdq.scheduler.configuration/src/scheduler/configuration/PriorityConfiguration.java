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
 * A representation of the model object '<em><b>Priority Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link scheduler.configuration.PriorityConfiguration#getRange <em>Range</em>}</li>
 *   <li>{@link scheduler.configuration.PriorityConfiguration#getBoostConfiguration <em>Boost Configuration</em>}</li>
 * </ul>
 * </p>
 *
 * @see scheduler.configuration.ConfigurationPackage#getPriorityConfiguration()
 * @model
 * @generated
 */
public interface PriorityConfiguration extends EObject {
	/**
	 * Returns the value of the '<em><b>Range</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Range</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Range</em>' containment reference.
	 * @see #setRange(PriorityRange)
	 * @see scheduler.configuration.ConfigurationPackage#getPriorityConfiguration_Range()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	PriorityRange getRange();

	/**
	 * Sets the value of the '{@link scheduler.configuration.PriorityConfiguration#getRange <em>Range</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Range</em>' containment reference.
	 * @see #getRange()
	 * @generated
	 */
	void setRange(PriorityRange value);

	/**
	 * Returns the value of the '<em><b>Boost Configuration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Boost Configuration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Boost Configuration</em>' containment reference.
	 * @see #setBoostConfiguration(PriorityBoostConfiguration)
	 * @see scheduler.configuration.ConfigurationPackage#getPriorityConfiguration_BoostConfiguration()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	PriorityBoostConfiguration getBoostConfiguration();

	/**
	 * Sets the value of the '{@link scheduler.configuration.PriorityConfiguration#getBoostConfiguration <em>Boost Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Boost Configuration</em>' containment reference.
	 * @see #getBoostConfiguration()
	 * @generated
	 */
	void setBoostConfiguration(PriorityBoostConfiguration value);

} // PriorityConfiguration
