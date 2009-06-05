/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scheduler.configuration;

import de.uka.ipd.sdq.identifier.Identifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Active Resource Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link scheduler.configuration.ActiveResourceConfiguration#getSchedulerConfiguration <em>Scheduler Configuration</em>}</li>
 *   <li>{@link scheduler.configuration.ActiveResourceConfiguration#getReplicas <em>Replicas</em>}</li>
 *   <li>{@link scheduler.configuration.ActiveResourceConfiguration#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see scheduler.configuration.ConfigurationPackage#getActiveResourceConfiguration()
 * @model
 * @generated
 */
public interface ActiveResourceConfiguration extends Identifier {
	/**
	 * Returns the value of the '<em><b>Scheduler Configuration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scheduler Configuration</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scheduler Configuration</em>' reference.
	 * @see #setSchedulerConfiguration(SchedulerConfiguration)
	 * @see scheduler.configuration.ConfigurationPackage#getActiveResourceConfiguration_SchedulerConfiguration()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	SchedulerConfiguration getSchedulerConfiguration();

	/**
	 * Sets the value of the '{@link scheduler.configuration.ActiveResourceConfiguration#getSchedulerConfiguration <em>Scheduler Configuration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scheduler Configuration</em>' reference.
	 * @see #getSchedulerConfiguration()
	 * @generated
	 */
	void setSchedulerConfiguration(SchedulerConfiguration value);

	/**
	 * Returns the value of the '<em><b>Replicas</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Replicas</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Replicas</em>' attribute.
	 * @see #setReplicas(int)
	 * @see scheduler.configuration.ConfigurationPackage#getActiveResourceConfiguration_Replicas()
	 * @model default="1" required="true" ordered="false"
	 * @generated
	 */
	int getReplicas();

	/**
	 * Sets the value of the '{@link scheduler.configuration.ActiveResourceConfiguration#getReplicas <em>Replicas</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Replicas</em>' attribute.
	 * @see #getReplicas()
	 * @generated
	 */
	void setReplicas(int value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see scheduler.configuration.ConfigurationPackage#getActiveResourceConfiguration_Name()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link scheduler.configuration.ActiveResourceConfiguration#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

} // ActiveResourceConfiguration
