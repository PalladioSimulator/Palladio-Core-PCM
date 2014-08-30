/**
 * Copyright 2006, SDQ Group, University Karlsruhe (TH)
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.computed_allocation;

import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.context.computed_usage.ComputedUsageContext;
import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.core.entity.Entity;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Context</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.context.computed_allocation.ComputedAllocationContext#getResourceDemands_ComputedAllocationContext
 * <em>Resource Demands Computed Allocation Context</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.context.computed_allocation.ComputedAllocationContext#getUsageContext_ComputedAllocationContext
 * <em>Usage Context Computed Allocation Context</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.context.computed_allocation.ComputedAllocationContext#getAllocationContext_ComputedAllocationContext
 * <em>Allocation Context Computed Allocation Context</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.context.computed_allocation.ComputedAllocationPackage#getComputedAllocationContext()
 * @model
 * @generated
 */
public interface ComputedAllocationContext extends Entity {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String copyright = "Copyright 2006, SDQ Group, University Karlsruhe (TH)";

    /**
     * Returns the value of the '<em><b>Resource Demands Computed Allocation Context</b></em>'
     * containment reference list. The list contents are of type
     * {@link de.uka.ipd.sdq.context.computed_allocation.ResourceDemand}. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Resource Demands Computed Allocation Context</em>' containment
     * reference list isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Resource Demands Computed Allocation Context</em>' containment
     *         reference list.
     * @see de.uka.ipd.sdq.context.computed_allocation.ComputedAllocationPackage#getComputedAllocationContext_ResourceDemands_ComputedAllocationContext()
     * @model containment="true" ordered="false"
     * @generated
     */
    EList<ResourceDemand> getResourceDemands_ComputedAllocationContext();

    /**
     * Returns the value of the '<em><b>Usage Context Computed Allocation Context</b></em>'
     * reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Usage Context Computed Allocation Context</em>' reference isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Usage Context Computed Allocation Context</em>' reference.
     * @see #setUsageContext_ComputedAllocationContext(ComputedUsageContext)
     * @see de.uka.ipd.sdq.context.computed_allocation.ComputedAllocationPackage#getComputedAllocationContext_UsageContext_ComputedAllocationContext()
     * @model required="true" ordered="false"
     * @generated
     */
    ComputedUsageContext getUsageContext_ComputedAllocationContext();

    /**
     * Sets the value of the '
     * {@link de.uka.ipd.sdq.context.computed_allocation.ComputedAllocationContext#getUsageContext_ComputedAllocationContext
     * <em>Usage Context Computed Allocation Context</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Usage Context Computed Allocation Context</em>'
     *            reference.
     * @see #getUsageContext_ComputedAllocationContext()
     * @generated
     */
    void setUsageContext_ComputedAllocationContext(ComputedUsageContext value);

    /**
     * Returns the value of the '<em><b>Allocation Context Computed Allocation Context</b></em>'
     * reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Allocation Context Computed Allocation Context</em>' reference
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Allocation Context Computed Allocation Context</em>' reference.
     * @see #setAllocationContext_ComputedAllocationContext(AllocationContext)
     * @see de.uka.ipd.sdq.context.computed_allocation.ComputedAllocationPackage#getComputedAllocationContext_AllocationContext_ComputedAllocationContext()
     * @model required="true" ordered="false"
     * @generated
     */
    AllocationContext getAllocationContext_ComputedAllocationContext();

    /**
     * Sets the value of the '
     * {@link de.uka.ipd.sdq.context.computed_allocation.ComputedAllocationContext#getAllocationContext_ComputedAllocationContext
     * <em>Allocation Context Computed Allocation Context</em>}' reference. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Allocation Context Computed Allocation Context</em>'
     *            reference.
     * @see #getAllocationContext_ComputedAllocationContext()
     * @generated
     */
    void setAllocationContext_ComputedAllocationContext(AllocationContext value);

} // ComputedAllocationContext
