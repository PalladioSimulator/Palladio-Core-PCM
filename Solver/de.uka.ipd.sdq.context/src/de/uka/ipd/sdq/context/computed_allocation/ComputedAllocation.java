/**
 * Copyright 2006, SDQ Group, University Karlsruhe (TH)
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.computed_allocation;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Computed Allocation</b></em>
 * '. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.context.computed_allocation.ComputedAllocation#getComputedAllocationContexts_ComputedAllocation
 * <em>Computed Allocation Contexts Computed Allocation</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.context.computed_allocation.ComputedAllocationPackage#getComputedAllocation()
 * @model
 * @generated
 */
public interface ComputedAllocation extends EObject {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String copyright = "Copyright 2006, SDQ Group, University Karlsruhe (TH)";

    /**
     * Returns the value of the '<em><b>Computed Allocation Contexts Computed Allocation</b></em>'
     * containment reference list. The list contents are of type
     * {@link de.uka.ipd.sdq.context.computed_allocation.ComputedAllocationContext}. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Computed Allocation Contexts Computed Allocation</em>' containment
     * reference list isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Computed Allocation Contexts Computed Allocation</em>'
     *         containment reference list.
     * @see de.uka.ipd.sdq.context.computed_allocation.ComputedAllocationPackage#getComputedAllocation_ComputedAllocationContexts_ComputedAllocation()
     * @model containment="true" ordered="false"
     * @generated
     */
    EList<ComputedAllocationContext> getComputedAllocationContexts_ComputedAllocation();

} // ComputedAllocation
