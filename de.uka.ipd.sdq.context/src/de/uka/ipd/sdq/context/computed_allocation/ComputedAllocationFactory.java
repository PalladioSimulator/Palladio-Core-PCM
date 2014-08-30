/**
 * Copyright 2006, SDQ Group, University Karlsruhe (TH)
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.computed_allocation;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc --> The <b>Factory</b> for the model. It provides a create method for each
 * non-abstract class of the model. <!-- end-user-doc -->
 * 
 * @see de.uka.ipd.sdq.context.computed_allocation.ComputedAllocationPackage
 * @generated
 */
public interface ComputedAllocationFactory extends EFactory {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String copyright = "Copyright 2006, SDQ Group, University Karlsruhe (TH)";

    /**
     * The singleton instance of the factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    ComputedAllocationFactory eINSTANCE = de.uka.ipd.sdq.context.computed_allocation.impl.ComputedAllocationFactoryImpl
            .init();

    /**
     * Returns a new object of class '<em>Context</em>'. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @return a new object of class '<em>Context</em>'.
     * @generated
     */
    ComputedAllocationContext createComputedAllocationContext();

    /**
     * Returns a new object of class '<em>Resource Demand</em>'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return a new object of class '<em>Resource Demand</em>'.
     * @generated
     */
    ResourceDemand createResourceDemand();

    /**
     * Returns a new object of class '<em>Computed Allocation</em>'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return a new object of class '<em>Computed Allocation</em>'.
     * @generated
     */
    ComputedAllocation createComputedAllocation();

    /**
     * Returns the package supported by this factory. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the package supported by this factory.
     * @generated
     */
    ComputedAllocationPackage getComputedAllocationPackage();

} // ComputedAllocationFactory
