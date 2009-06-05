/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.core;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parallel Composition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.core.ParallelComposition#getParallelProcesses <em>Parallel Processes</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.core.ParallelComposition#getTargetProcess <em>Target Process</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.core.ParallelComposition#isIsSynchronised <em>Is Synchronised</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.capra.core.CorePackage#getParallelComposition()
 * @model
 * @generated
 */
public interface ParallelComposition extends Operator {
	/**
	 * Returns the value of the '<em><b>Parallel Processes</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.capra.core.CapraExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parallel Processes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parallel Processes</em>' containment reference list.
	 * @see de.uka.ipd.sdq.capra.core.CorePackage#getParallelComposition_ParallelProcesses()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<CapraExpression> getParallelProcesses();

	/**
	 * Returns the value of the '<em><b>Target Process</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target Process</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Process</em>' containment reference.
	 * @see #setTargetProcess(CapraExpression)
	 * @see de.uka.ipd.sdq.capra.core.CorePackage#getParallelComposition_TargetProcess()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	CapraExpression getTargetProcess();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.core.ParallelComposition#getTargetProcess <em>Target Process</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Process</em>' containment reference.
	 * @see #getTargetProcess()
	 * @generated
	 */
	void setTargetProcess(CapraExpression value);

	/**
	 * Returns the value of the '<em><b>Is Synchronised</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Synchronised</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Synchronised</em>' attribute.
	 * @see #setIsSynchronised(boolean)
	 * @see de.uka.ipd.sdq.capra.core.CorePackage#getParallelComposition_IsSynchronised()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	boolean isIsSynchronised();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.core.ParallelComposition#isIsSynchronised <em>Is Synchronised</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Synchronised</em>' attribute.
	 * @see #isIsSynchronised()
	 * @generated
	 */
	void setIsSynchronised(boolean value);

} // ParallelComposition
