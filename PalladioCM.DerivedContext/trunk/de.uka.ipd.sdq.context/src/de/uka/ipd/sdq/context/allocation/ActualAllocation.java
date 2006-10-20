/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.allocation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Actual Allocation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.context.allocation.ActualAllocation#getActualAllocationContexts <em>Actual Allocation Contexts</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.context.allocation.AllocationPackage#getActualAllocation()
 * @model
 * @generated
 */
public interface ActualAllocation extends EObject {
	/**
	 * Returns the value of the '<em><b>Actual Allocation Contexts</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.context.allocation.ActualAllocationContext}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actual Allocation Contexts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actual Allocation Contexts</em>' containment reference list.
	 * @see de.uka.ipd.sdq.context.allocation.AllocationPackage#getActualAllocation_ActualAllocationContexts()
	 * @model type="de.uka.ipd.sdq.context.allocation.ActualAllocationContext" containment="true" ordered="false"
	 * @generated
	 */
	EList getActualAllocationContexts();

} // ActualAllocation