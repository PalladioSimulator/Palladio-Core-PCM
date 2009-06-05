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
 *   <li>{@link de.uka.ipd.sdq.capra.core.ParallelComposition#getProcesses <em>Processes</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.capra.core.CorePackage#getParallelComposition()
 * @model
 * @generated
 */
public interface ParallelComposition extends Operator {
	/**
	 * Returns the value of the '<em><b>Processes</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.capra.core.CapraExpression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Processes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Processes</em>' containment reference list.
	 * @see de.uka.ipd.sdq.capra.core.CorePackage#getParallelComposition_Processes()
	 * @model type="de.uka.ipd.sdq.capra.core.CapraExpression" containment="true"
	 * @generated
	 */
	EList<CapraExpression> getProcesses();

} // ParallelComposition
