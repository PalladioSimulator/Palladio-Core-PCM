/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scheduler.configuration;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Single Queue Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link scheduler.configuration.SingleQueueConfiguration#getProcessSelection <em>Process Selection</em>}</li>
 * </ul>
 * </p>
 *
 * @see scheduler.configuration.ConfigurationPackage#getSingleQueueConfiguration()
 * @model
 * @generated
 */
public interface SingleQueueConfiguration extends QueueingConfiguration {
	/**
	 * Returns the value of the '<em><b>Process Selection</b></em>' attribute.
	 * The literals are from the enumeration {@link scheduler.configuration.ProcessSelection}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Process Selection</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Process Selection</em>' attribute.
	 * @see scheduler.configuration.ProcessSelection
	 * @see #setProcessSelection(ProcessSelection)
	 * @see scheduler.configuration.ConfigurationPackage#getSingleQueueConfiguration_ProcessSelection()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ProcessSelection getProcessSelection();

	/**
	 * Sets the value of the '{@link scheduler.configuration.SingleQueueConfiguration#getProcessSelection <em>Process Selection</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Process Selection</em>' attribute.
	 * @see scheduler.configuration.ProcessSelection
	 * @see #getProcessSelection()
	 * @generated
	 */
	void setProcessSelection(ProcessSelection value);

} // SingleQueueConfiguration
