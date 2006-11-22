/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.qnm;

import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.spa.resourcemodel.AbstractResourceUsage;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Task</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.qnm.Task#getNumReplicas <em>Num Replicas</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.Task#getName <em>Name</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.qnm.Task#getResourceUsage <em>Resource Usage</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.qnm.QnmPackage#getTask()
 * @model
 * @generated
 */
public interface Task extends EObject {
	/**
	 * Returns the value of the '<em><b>Num Replicas</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Num Replicas</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Num Replicas</em>' attribute.
	 * @see #setNumReplicas(int)
	 * @see de.uka.ipd.sdq.qnm.QnmPackage#getTask_NumReplicas()
	 * @model unique="false" required="true"
	 * @generated
	 */
	int getNumReplicas();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.qnm.Task#getNumReplicas <em>Num Replicas</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Num Replicas</em>' attribute.
	 * @see #getNumReplicas()
	 * @generated
	 */
	void setNumReplicas(int value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.uka.ipd.sdq.qnm.QnmPackage#getTask_Name()
	 * @model default="" required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.qnm.Task#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Resource Usage</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Usage</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Usage</em>' containment reference.
	 * @see #setResourceUsage(AbstractResourceUsage)
	 * @see de.uka.ipd.sdq.qnm.QnmPackage#getTask_ResourceUsage()
	 * @model containment="true" required="true"
	 * @generated
	 */
	AbstractResourceUsage getResourceUsage();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.qnm.Task#getResourceUsage <em>Resource Usage</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource Usage</em>' containment reference.
	 * @see #getResourceUsage()
	 * @generated
	 */
	void setResourceUsage(AbstractResourceUsage value);

} // Task