/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scheduler;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

import scheduler.configuration.SchedulerConfiguration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Library</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link scheduler.SchedulerLibrary#getSchedulerConfiguration <em>Scheduler Configuration</em>}</li>
 * </ul>
 * </p>
 *
 * @see scheduler.SchedulerPackage#getSchedulerLibrary()
 * @model
 * @generated
 */
public interface SchedulerLibrary extends EObject {
	/**
	 * Returns the value of the '<em><b>Scheduler Configuration</b></em>' containment reference list.
	 * The list contents are of type {@link scheduler.configuration.SchedulerConfiguration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scheduler Configuration</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scheduler Configuration</em>' containment reference list.
	 * @see scheduler.SchedulerPackage#getSchedulerLibrary_SchedulerConfiguration()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<SchedulerConfiguration> getSchedulerConfiguration();

} // SchedulerLibrary
