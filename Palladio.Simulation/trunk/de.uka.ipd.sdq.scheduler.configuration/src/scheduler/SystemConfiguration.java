/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scheduler;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import scheduler.configuration.ActiveResourceConfiguration;
import scheduler.configuration.PassiveResourceConfiguration;
import scheduler.configuration.ProcessConfiguration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>System Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link scheduler.SystemConfiguration#getProcessConfiguration <em>Process Configuration</em>}</li>
 *   <li>{@link scheduler.SystemConfiguration#getActiveResourceConfiguration <em>Active Resource Configuration</em>}</li>
 *   <li>{@link scheduler.SystemConfiguration#getPassiveResourceConfiguration <em>Passive Resource Configuration</em>}</li>
 * </ul>
 * </p>
 *
 * @see scheduler.SchedulerPackage#getSystemConfiguration()
 * @model
 * @generated
 */
public interface SystemConfiguration extends EObject {
	/**
	 * Returns the value of the '<em><b>Process Configuration</b></em>' containment reference list.
	 * The list contents are of type {@link scheduler.configuration.ProcessConfiguration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Process Configuration</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Process Configuration</em>' containment reference list.
	 * @see scheduler.SchedulerPackage#getSystemConfiguration_ProcessConfiguration()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ProcessConfiguration> getProcessConfiguration();

	/**
	 * Returns the value of the '<em><b>Active Resource Configuration</b></em>' containment reference list.
	 * The list contents are of type {@link scheduler.configuration.ActiveResourceConfiguration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Active Resource Configuration</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Active Resource Configuration</em>' containment reference list.
	 * @see scheduler.SchedulerPackage#getSystemConfiguration_ActiveResourceConfiguration()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ActiveResourceConfiguration> getActiveResourceConfiguration();

	/**
	 * Returns the value of the '<em><b>Passive Resource Configuration</b></em>' containment reference list.
	 * The list contents are of type {@link scheduler.configuration.PassiveResourceConfiguration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Passive Resource Configuration</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Passive Resource Configuration</em>' containment reference list.
	 * @see scheduler.SchedulerPackage#getSystemConfiguration_PassiveResourceConfiguration()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<PassiveResourceConfiguration> getPassiveResourceConfiguration();

} // SystemConfiguration
