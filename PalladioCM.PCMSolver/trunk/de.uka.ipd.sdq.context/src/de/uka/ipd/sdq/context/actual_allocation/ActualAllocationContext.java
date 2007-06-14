/**
 * Copyright 2006, SDQ Group, University Karlsruhe (TH)
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.actual_allocation;

import de.uka.ipd.sdq.context.usage.UsageContext;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Actual Allocation Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.context.actual_allocation.ActualAllocationContext#getActualResourceDemands_ActualAllocationContext <em>Actual Resource Demands Actual Allocation Context</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.context.actual_allocation.ActualAllocationContext#getUsageContext_ActualAllocationContext <em>Usage Context Actual Allocation Context</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.context.actual_allocation.Actual_AllocationPackage#getActualAllocationContext()
 * @model
 * @generated
 */
public interface ActualAllocationContext extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2006, SDQ Group, University Karlsruhe (TH)";

	/**
	 * Returns the value of the '<em><b>Actual Resource Demands Actual Allocation Context</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.context.actual_allocation.ActualResourceDemand}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Actual Resource Demands Actual Allocation Context</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Actual Resource Demands Actual Allocation Context</em>' containment reference list.
	 * @see de.uka.ipd.sdq.context.actual_allocation.Actual_AllocationPackage#getActualAllocationContext_ActualResourceDemands_ActualAllocationContext()
	 * @model type="de.uka.ipd.sdq.context.actual_allocation.ActualResourceDemand" containment="true" ordered="false"
	 * @generated
	 */
	EList getActualResourceDemands_ActualAllocationContext();

	/**
	 * Returns the value of the '<em><b>Usage Context Actual Allocation Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Usage Context Actual Allocation Context</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Usage Context Actual Allocation Context</em>' reference.
	 * @see #setUsageContext_ActualAllocationContext(UsageContext)
	 * @see de.uka.ipd.sdq.context.actual_allocation.Actual_AllocationPackage#getActualAllocationContext_UsageContext_ActualAllocationContext()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	UsageContext getUsageContext_ActualAllocationContext();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.context.actual_allocation.ActualAllocationContext#getUsageContext_ActualAllocationContext <em>Usage Context Actual Allocation Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Usage Context Actual Allocation Context</em>' reference.
	 * @see #getUsageContext_ActualAllocationContext()
	 * @generated
	 */
	void setUsageContext_ActualAllocationContext(UsageContext value);

} // ActualAllocationContext
