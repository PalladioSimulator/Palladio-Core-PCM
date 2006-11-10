/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.allocation;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.context.allocation.AllocationFactory
 * @model kind="package"
 * @generated
 */
public interface AllocationPackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2006, SDQ Group, University Karlsruhe (TH)";

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "allocation";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/Context/Allocation/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "context.allocation";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AllocationPackage eINSTANCE = de.uka.ipd.sdq.context.allocation.impl.AllocationPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.context.allocation.impl.ActualAllocationContextImpl <em>Actual Allocation Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.context.allocation.impl.ActualAllocationContextImpl
	 * @see de.uka.ipd.sdq.context.allocation.impl.AllocationPackageImpl#getActualAllocationContext()
	 * @generated
	 */
	int ACTUAL_ALLOCATION_CONTEXT = 0;

	/**
	 * The feature id for the '<em><b>Actual Resource Demands Actual Allocation Context</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUAL_ALLOCATION_CONTEXT__ACTUAL_RESOURCE_DEMANDS_ACTUAL_ALLOCATION_CONTEXT = 0;

	/**
	 * The feature id for the '<em><b>Usage Context Actual Allocation Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUAL_ALLOCATION_CONTEXT__USAGE_CONTEXT_ACTUAL_ALLOCATION_CONTEXT = 1;

	/**
	 * The number of structural features of the '<em>Actual Allocation Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUAL_ALLOCATION_CONTEXT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.context.allocation.impl.ActualResourceDemandImpl <em>Actual Resource Demand</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.context.allocation.impl.ActualResourceDemandImpl
	 * @see de.uka.ipd.sdq.context.allocation.impl.AllocationPackageImpl#getActualResourceDemand()
	 * @generated
	 */
	int ACTUAL_RESOURCE_DEMAND = 1;

	/**
	 * The feature id for the '<em><b>Parametric Resource Demand Actual Resource Demand</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUAL_RESOURCE_DEMAND__PARAMETRIC_RESOURCE_DEMAND_ACTUAL_RESOURCE_DEMAND = 0;

	/**
	 * The feature id for the '<em><b>Random Variable Actual Resource Demand</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUAL_RESOURCE_DEMAND__RANDOM_VARIABLE_ACTUAL_RESOURCE_DEMAND = 1;

	/**
	 * The number of structural features of the '<em>Actual Resource Demand</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUAL_RESOURCE_DEMAND_FEATURE_COUNT = 2;


	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.context.allocation.impl.ActualAllocationImpl <em>Actual Allocation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.context.allocation.impl.ActualAllocationImpl
	 * @see de.uka.ipd.sdq.context.allocation.impl.AllocationPackageImpl#getActualAllocation()
	 * @generated
	 */
	int ACTUAL_ALLOCATION = 2;

	/**
	 * The feature id for the '<em><b>Actual Allocation Context Actual Allocation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUAL_ALLOCATION__ACTUAL_ALLOCATION_CONTEXT_ACTUAL_ALLOCATION = 0;

	/**
	 * The number of structural features of the '<em>Actual Allocation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTUAL_ALLOCATION_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.context.allocation.ActualAllocationContext <em>Actual Allocation Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Actual Allocation Context</em>'.
	 * @see de.uka.ipd.sdq.context.allocation.ActualAllocationContext
	 * @generated
	 */
	EClass getActualAllocationContext();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.context.allocation.ActualAllocationContext#getActualResourceDemands_ActualAllocationContext <em>Actual Resource Demands Actual Allocation Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actual Resource Demands Actual Allocation Context</em>'.
	 * @see de.uka.ipd.sdq.context.allocation.ActualAllocationContext#getActualResourceDemands_ActualAllocationContext()
	 * @see #getActualAllocationContext()
	 * @generated
	 */
	EReference getActualAllocationContext_ActualResourceDemands_ActualAllocationContext();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.context.allocation.ActualAllocationContext#getUsageContext_ActualAllocationContext <em>Usage Context Actual Allocation Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Usage Context Actual Allocation Context</em>'.
	 * @see de.uka.ipd.sdq.context.allocation.ActualAllocationContext#getUsageContext_ActualAllocationContext()
	 * @see #getActualAllocationContext()
	 * @generated
	 */
	EReference getActualAllocationContext_UsageContext_ActualAllocationContext();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.context.allocation.ActualResourceDemand <em>Actual Resource Demand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Actual Resource Demand</em>'.
	 * @see de.uka.ipd.sdq.context.allocation.ActualResourceDemand
	 * @generated
	 */
	EClass getActualResourceDemand();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.context.allocation.ActualResourceDemand#getParametricResourceDemand_ActualResourceDemand <em>Parametric Resource Demand Actual Resource Demand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parametric Resource Demand Actual Resource Demand</em>'.
	 * @see de.uka.ipd.sdq.context.allocation.ActualResourceDemand#getParametricResourceDemand_ActualResourceDemand()
	 * @see #getActualResourceDemand()
	 * @generated
	 */
	EReference getActualResourceDemand_ParametricResourceDemand_ActualResourceDemand();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.context.allocation.ActualResourceDemand#getRandomVariable_ActualResourceDemand <em>Random Variable Actual Resource Demand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Random Variable Actual Resource Demand</em>'.
	 * @see de.uka.ipd.sdq.context.allocation.ActualResourceDemand#getRandomVariable_ActualResourceDemand()
	 * @see #getActualResourceDemand()
	 * @generated
	 */
	EReference getActualResourceDemand_RandomVariable_ActualResourceDemand();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.context.allocation.ActualAllocation <em>Actual Allocation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Actual Allocation</em>'.
	 * @see de.uka.ipd.sdq.context.allocation.ActualAllocation
	 * @generated
	 */
	EClass getActualAllocation();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.context.allocation.ActualAllocation#getActualAllocationContext_ActualAllocation <em>Actual Allocation Context Actual Allocation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Actual Allocation Context Actual Allocation</em>'.
	 * @see de.uka.ipd.sdq.context.allocation.ActualAllocation#getActualAllocationContext_ActualAllocation()
	 * @see #getActualAllocation()
	 * @generated
	 */
	EReference getActualAllocation_ActualAllocationContext_ActualAllocation();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AllocationFactory getAllocationFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals  {
		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.context.allocation.impl.ActualAllocationContextImpl <em>Actual Allocation Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.context.allocation.impl.ActualAllocationContextImpl
		 * @see de.uka.ipd.sdq.context.allocation.impl.AllocationPackageImpl#getActualAllocationContext()
		 * @generated
		 */
		EClass ACTUAL_ALLOCATION_CONTEXT = eINSTANCE.getActualAllocationContext();

		/**
		 * The meta object literal for the '<em><b>Actual Resource Demands Actual Allocation Context</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTUAL_ALLOCATION_CONTEXT__ACTUAL_RESOURCE_DEMANDS_ACTUAL_ALLOCATION_CONTEXT = eINSTANCE.getActualAllocationContext_ActualResourceDemands_ActualAllocationContext();

		/**
		 * The meta object literal for the '<em><b>Usage Context Actual Allocation Context</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTUAL_ALLOCATION_CONTEXT__USAGE_CONTEXT_ACTUAL_ALLOCATION_CONTEXT = eINSTANCE.getActualAllocationContext_UsageContext_ActualAllocationContext();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.context.allocation.impl.ActualResourceDemandImpl <em>Actual Resource Demand</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.context.allocation.impl.ActualResourceDemandImpl
		 * @see de.uka.ipd.sdq.context.allocation.impl.AllocationPackageImpl#getActualResourceDemand()
		 * @generated
		 */
		EClass ACTUAL_RESOURCE_DEMAND = eINSTANCE.getActualResourceDemand();

		/**
		 * The meta object literal for the '<em><b>Parametric Resource Demand Actual Resource Demand</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTUAL_RESOURCE_DEMAND__PARAMETRIC_RESOURCE_DEMAND_ACTUAL_RESOURCE_DEMAND = eINSTANCE.getActualResourceDemand_ParametricResourceDemand_ActualResourceDemand();

		/**
		 * The meta object literal for the '<em><b>Random Variable Actual Resource Demand</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTUAL_RESOURCE_DEMAND__RANDOM_VARIABLE_ACTUAL_RESOURCE_DEMAND = eINSTANCE.getActualResourceDemand_RandomVariable_ActualResourceDemand();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.context.allocation.impl.ActualAllocationImpl <em>Actual Allocation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.context.allocation.impl.ActualAllocationImpl
		 * @see de.uka.ipd.sdq.context.allocation.impl.AllocationPackageImpl#getActualAllocation()
		 * @generated
		 */
		EClass ACTUAL_ALLOCATION = eINSTANCE.getActualAllocation();

		/**
		 * The meta object literal for the '<em><b>Actual Allocation Context Actual Allocation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ACTUAL_ALLOCATION__ACTUAL_ALLOCATION_CONTEXT_ACTUAL_ALLOCATION = eINSTANCE.getActualAllocation_ActualAllocationContext_ActualAllocation();

	}

} //AllocationPackage
