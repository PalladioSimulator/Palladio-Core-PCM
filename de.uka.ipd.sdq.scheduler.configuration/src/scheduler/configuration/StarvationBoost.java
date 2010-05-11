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
 * A representation of the model object '<em><b>Starvation Boost</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link scheduler.configuration.StarvationBoost#getStarvationLimit <em>Starvation Limit</em>}</li>
 *   <li>{@link scheduler.configuration.StarvationBoost#getBoost <em>Boost</em>}</li>
 *   <li>{@link scheduler.configuration.StarvationBoost#getDurationInTimeslices <em>Duration In Timeslices</em>}</li>
 * </ul>
 * </p>
 *
 * @see scheduler.configuration.ConfigurationPackage#getStarvationBoost()
 * @model
 * @generated
 */
public interface StarvationBoost extends EObject {
	/**
	 * Returns the value of the '<em><b>Starvation Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Starvation Limit</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Starvation Limit</em>' attribute.
	 * @see #setStarvationLimit(double)
	 * @see scheduler.configuration.ConfigurationPackage#getStarvationBoost_StarvationLimit()
	 * @model
	 * @generated
	 */
	double getStarvationLimit();

	/**
	 * Sets the value of the '{@link scheduler.configuration.StarvationBoost#getStarvationLimit <em>Starvation Limit</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Starvation Limit</em>' attribute.
	 * @see #getStarvationLimit()
	 * @generated
	 */
	void setStarvationLimit(double value);

	/**
	 * Returns the value of the '<em><b>Boost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Boost</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Boost</em>' attribute.
	 * @see #setBoost(int)
	 * @see scheduler.configuration.ConfigurationPackage#getStarvationBoost_Boost()
	 * @model
	 * @generated
	 */
	int getBoost();

	/**
	 * Sets the value of the '{@link scheduler.configuration.StarvationBoost#getBoost <em>Boost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Boost</em>' attribute.
	 * @see #getBoost()
	 * @generated
	 */
	void setBoost(int value);

	/**
	 * Returns the value of the '<em><b>Duration In Timeslices</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Duration In Timeslices</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Duration In Timeslices</em>' attribute.
	 * @see #setDurationInTimeslices(int)
	 * @see scheduler.configuration.ConfigurationPackage#getStarvationBoost_DurationInTimeslices()
	 * @model
	 * @generated
	 */
	int getDurationInTimeslices();

	/**
	 * Sets the value of the '{@link scheduler.configuration.StarvationBoost#getDurationInTimeslices <em>Duration In Timeslices</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Duration In Timeslices</em>' attribute.
	 * @see #getDurationInTimeslices()
	 * @generated
	 */
	void setDurationInTimeslices(int value);

} // StarvationBoost
