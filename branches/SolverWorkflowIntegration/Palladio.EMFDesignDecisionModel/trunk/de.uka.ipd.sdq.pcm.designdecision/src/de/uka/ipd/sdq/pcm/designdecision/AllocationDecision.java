/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision;

import de.uka.ipd.sdq.pcm.allocation.AllocationContext;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Allocation Decision</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * TODO: Constraint that only works for design decisions that have the domain availableServers of which the assembled component is an element. 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.designdecision.AllocationDecision#getAllocationcontext <em>Allocationcontext</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getAllocationDecision()
 * @model
 * @generated
 */
public interface AllocationDecision extends DesignDecision {
	/**
	 * Returns the value of the '<em><b>Allocationcontext</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Allocationcontext</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allocationcontext</em>' reference.
	 * @see #setAllocationcontext(AllocationContext)
	 * @see de.uka.ipd.sdq.pcm.designdecision.designdecisionPackage#getAllocationDecision_Allocationcontext()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	AllocationContext getAllocationcontext();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.designdecision.AllocationDecision#getAllocationcontext <em>Allocationcontext</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Allocationcontext</em>' reference.
	 * @see #getAllocationcontext()
	 * @generated
	 */
	void setAllocationcontext(AllocationContext value);

} // AllocationDecision
