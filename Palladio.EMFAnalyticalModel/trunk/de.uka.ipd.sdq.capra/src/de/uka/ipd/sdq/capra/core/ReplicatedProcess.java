/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.core;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Replicated Process</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.core.ReplicatedProcess#getNumReplicas <em>Num Replicas</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.core.ReplicatedProcess#getProcessvariable <em>Processvariable</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.capra.core.CorePackage#getReplicatedProcess()
 * @model
 * @generated
 */
public interface ReplicatedProcess extends EObject {
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
	 * @see de.uka.ipd.sdq.capra.core.CorePackage#getReplicatedProcess_NumReplicas()
	 * @model ordered="false"
	 * @generated
	 */
	int getNumReplicas();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.core.ReplicatedProcess#getNumReplicas <em>Num Replicas</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Num Replicas</em>' attribute.
	 * @see #getNumReplicas()
	 * @generated
	 */
	void setNumReplicas(int value);

	/**
	 * Returns the value of the '<em><b>Processvariable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Processvariable</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Processvariable</em>' containment reference.
	 * @see #setProcessvariable(ProcessVariable)
	 * @see de.uka.ipd.sdq.capra.core.CorePackage#getReplicatedProcess_Processvariable()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	ProcessVariable getProcessvariable();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.core.ReplicatedProcess#getProcessvariable <em>Processvariable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Processvariable</em>' containment reference.
	 * @see #getProcessvariable()
	 * @generated
	 */
	void setProcessvariable(ProcessVariable value);

} // ReplicatedProcess
