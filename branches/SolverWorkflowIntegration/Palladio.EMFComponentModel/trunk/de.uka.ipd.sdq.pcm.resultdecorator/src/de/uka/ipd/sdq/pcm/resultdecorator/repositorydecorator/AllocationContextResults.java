/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator;

import de.uka.ipd.sdq.pcm.allocation.AllocationContext;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Allocation Context Results</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.AllocationContextResults#getAllocationcontext <em>Allocationcontext</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.RepositorydecoratorPackage#getAllocationContextResults()
 * @model
 * @generated
 */
public interface AllocationContextResults extends ComponentResult {
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
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.RepositorydecoratorPackage#getAllocationContextResults_Allocationcontext()
	 * @model ordered="false"
	 * @generated
	 */
	AllocationContext getAllocationcontext();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.AllocationContextResults#getAllocationcontext <em>Allocationcontext</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Allocationcontext</em>' reference.
	 * @see #getAllocationcontext()
	 * @generated
	 */
	void setAllocationcontext(AllocationContext value);

} // AllocationContextResults
