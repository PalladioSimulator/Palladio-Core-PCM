/**
 * Copyright 2006, SDQ Group, University Karlsruhe (TH)
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.actual_allocation;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.context.actual_allocation.Actual_AllocationPackage
 * @generated
 */
public interface Actual_AllocationFactory extends EFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2006, SDQ Group, University Karlsruhe (TH)";

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Actual_AllocationFactory eINSTANCE = de.uka.ipd.sdq.context.actual_allocation.impl.Actual_AllocationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Actual Allocation Context</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Actual Allocation Context</em>'.
	 * @generated
	 */
	ActualAllocationContext createActualAllocationContext();

	/**
	 * Returns a new object of class '<em>Actual Resource Demand</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Actual Resource Demand</em>'.
	 * @generated
	 */
	ActualResourceDemand createActualResourceDemand();

	/**
	 * Returns a new object of class '<em>Actual Allocation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Actual Allocation</em>'.
	 * @generated
	 */
	ActualAllocation createActualAllocation();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	Actual_AllocationPackage getActual_AllocationPackage();

} //Actual_AllocationFactory
