/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package scheduler.configuration;

import de.uka.ipd.sdq.identifier.Identifier;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Process Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link scheduler.configuration.ProcessConfiguration#getPriority <em>Priority</em>}</li>
 *   <li>{@link scheduler.configuration.ProcessConfiguration#getReplicas <em>Replicas</em>}</li>
 *   <li>{@link scheduler.configuration.ProcessConfiguration#getName <em>Name</em>}</li>
 *   <li>{@link scheduler.configuration.ProcessConfiguration#getAffinityList <em>Affinity List</em>}</li>
 * </ul>
 * </p>
 *
 * @see scheduler.configuration.ConfigurationPackage#getProcessConfiguration()
 * @model
 * @generated
 */
public interface ProcessConfiguration extends Identifier {
	/**
	 * Returns the value of the '<em><b>Priority</b></em>' attribute.
	 * The literals are from the enumeration {@link scheduler.configuration.PriorityClass}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Priority</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Priority</em>' attribute.
	 * @see scheduler.configuration.PriorityClass
	 * @see #setPriority(PriorityClass)
	 * @see scheduler.configuration.ConfigurationPackage#getProcessConfiguration_Priority()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	PriorityClass getPriority();

	/**
	 * Sets the value of the '{@link scheduler.configuration.ProcessConfiguration#getPriority <em>Priority</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Priority</em>' attribute.
	 * @see scheduler.configuration.PriorityClass
	 * @see #getPriority()
	 * @generated
	 */
	void setPriority(PriorityClass value);

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
	 * @see scheduler.configuration.ConfigurationPackage#getProcessConfiguration_Replicas()
	 * @model default="1" required="true" ordered="false"
	 * @generated
	 */
	int getReplicas();

	/**
	 * Sets the value of the '{@link scheduler.configuration.ProcessConfiguration#getReplicas <em>Replicas</em>}' attribute.
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
	 * @see scheduler.configuration.ConfigurationPackage#getProcessConfiguration_Name()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link scheduler.configuration.ProcessConfiguration#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Affinity List</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.Integer}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Affinity List</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Affinity List</em>' attribute list.
	 * @see scheduler.configuration.ConfigurationPackage#getProcessConfiguration_AffinityList()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Integer> getAffinityList();

} // ProcessConfiguration
