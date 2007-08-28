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
 * A representation of the model object '<em><b>Queueing Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link scheduler.configuration.QueueingConfiguration#getInitialInstanceSelection <em>Initial Instance Selection</em>}</li>
 *   <li>{@link scheduler.configuration.QueueingConfiguration#getRunqueueType <em>Runqueue Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see scheduler.configuration.ConfigurationPackage#getQueueingConfiguration()
 * @model abstract="true"
 * @generated
 */
public interface QueueingConfiguration extends EObject {
	/**
	 * Returns the value of the '<em><b>Initial Instance Selection</b></em>' attribute.
	 * The literals are from the enumeration {@link scheduler.configuration.ResourceInstanceSelection}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial Instance Selection</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial Instance Selection</em>' attribute.
	 * @see scheduler.configuration.ResourceInstanceSelection
	 * @see #setInitialInstanceSelection(ResourceInstanceSelection)
	 * @see scheduler.configuration.ConfigurationPackage#getQueueingConfiguration_InitialInstanceSelection()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ResourceInstanceSelection getInitialInstanceSelection();

	/**
	 * Sets the value of the '{@link scheduler.configuration.QueueingConfiguration#getInitialInstanceSelection <em>Initial Instance Selection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial Instance Selection</em>' attribute.
	 * @see scheduler.configuration.ResourceInstanceSelection
	 * @see #getInitialInstanceSelection()
	 * @generated
	 */
	void setInitialInstanceSelection(ResourceInstanceSelection value);

	/**
	 * Returns the value of the '<em><b>Runqueue Type</b></em>' attribute.
	 * The literals are from the enumeration {@link scheduler.configuration.RunQueueType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Runqueue Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Runqueue Type</em>' attribute.
	 * @see scheduler.configuration.RunQueueType
	 * @see #setRunqueueType(RunQueueType)
	 * @see scheduler.configuration.ConfigurationPackage#getQueueingConfiguration_RunqueueType()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	RunQueueType getRunqueueType();

	/**
	 * Sets the value of the '{@link scheduler.configuration.QueueingConfiguration#getRunqueueType <em>Runqueue Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Runqueue Type</em>' attribute.
	 * @see scheduler.configuration.RunQueueType
	 * @see #getRunqueueType()
	 * @generated
	 */
	void setRunqueueType(RunQueueType value);

} // QueueingConfiguration
