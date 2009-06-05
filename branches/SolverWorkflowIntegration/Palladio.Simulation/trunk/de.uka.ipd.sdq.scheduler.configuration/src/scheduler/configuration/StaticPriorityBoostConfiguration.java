/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scheduler.configuration;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Static Priority Boost Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link scheduler.configuration.StaticPriorityBoostConfiguration#getStarvationBoost <em>Starvation Boost</em>}</li>
 * </ul>
 * </p>
 *
 * @see scheduler.configuration.ConfigurationPackage#getStaticPriorityBoostConfiguration()
 * @model
 * @generated
 */
public interface StaticPriorityBoostConfiguration extends PriorityBoostConfiguration {
	/**
	 * Returns the value of the '<em><b>Starvation Boost</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Starvation Boost</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Starvation Boost</em>' containment reference.
	 * @see #setStarvationBoost(StaticPriorityBoost)
	 * @see scheduler.configuration.ConfigurationPackage#getStaticPriorityBoostConfiguration_StarvationBoost()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	StaticPriorityBoost getStarvationBoost();

	/**
	 * Sets the value of the '{@link scheduler.configuration.StaticPriorityBoostConfiguration#getStarvationBoost <em>Starvation Boost</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Starvation Boost</em>' containment reference.
	 * @see #getStarvationBoost()
	 * @generated
	 */
	void setStarvationBoost(StaticPriorityBoost value);

} // StaticPriorityBoostConfiguration
