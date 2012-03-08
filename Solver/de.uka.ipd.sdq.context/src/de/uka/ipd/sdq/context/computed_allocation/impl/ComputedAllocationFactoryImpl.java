/**
 * Copyright 2006, SDQ Group, University Karlsruhe (TH)
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.computed_allocation.impl;

import de.uka.ipd.sdq.context.computed_allocation.*;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

import de.uka.ipd.sdq.context.computed_allocation.ComputedAllocation;
import de.uka.ipd.sdq.context.computed_allocation.ComputedAllocationContext;
import de.uka.ipd.sdq.context.computed_allocation.ComputedAllocationFactory;
import de.uka.ipd.sdq.context.computed_allocation.ComputedAllocationPackage;
import de.uka.ipd.sdq.context.computed_allocation.ResourceDemand;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ComputedAllocationFactoryImpl extends EFactoryImpl implements ComputedAllocationFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2006, SDQ Group, University Karlsruhe (TH)";

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ComputedAllocationFactory init() {
		try {
			ComputedAllocationFactory theComputedAllocationFactory = (ComputedAllocationFactory)EPackage.Registry.INSTANCE.getEFactory("http://sdq.ipd.uka.de/Context/Allocation/1.0"); 
			if (theComputedAllocationFactory != null) {
				return theComputedAllocationFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ComputedAllocationFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputedAllocationFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ComputedAllocationPackage.COMPUTED_ALLOCATION_CONTEXT: return createComputedAllocationContext();
			case ComputedAllocationPackage.RESOURCE_DEMAND: return createResourceDemand();
			case ComputedAllocationPackage.COMPUTED_ALLOCATION: return createComputedAllocation();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputedAllocationContext createComputedAllocationContext() {
		ComputedAllocationContextImpl computedAllocationContext = new ComputedAllocationContextImpl();
		return computedAllocationContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceDemand createResourceDemand() {
		ResourceDemandImpl resourceDemand = new ResourceDemandImpl();
		return resourceDemand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputedAllocation createComputedAllocation() {
		ComputedAllocationImpl computedAllocation = new ComputedAllocationImpl();
		return computedAllocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComputedAllocationPackage getComputedAllocationPackage() {
		return (ComputedAllocationPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ComputedAllocationPackage getPackage() {
		return ComputedAllocationPackage.eINSTANCE;
	}

} //ComputedAllocationFactoryImpl
