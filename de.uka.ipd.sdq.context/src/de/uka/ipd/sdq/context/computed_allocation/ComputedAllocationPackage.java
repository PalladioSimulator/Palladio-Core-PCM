/**
 * Copyright 2006, SDQ Group, University Karlsruhe (TH)
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.computed_allocation;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;

/**
 * <!-- begin-user-doc --> The <b>Package</b> for the model. It contains accessors for the meta
 * objects to represent
 * <ul>
 * <li>each class,</li>
 * <li>each feature of each class,</li>
 * <li>each enum,</li>
 * <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * 
 * @see de.uka.ipd.sdq.context.computed_allocation.ComputedAllocationFactory
 * @model kind="package"
 * @generated
 */
public interface ComputedAllocationPackage extends EPackage {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String copyright = "Copyright 2006, SDQ Group, University Karlsruhe (TH)";

    /**
     * The package name. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNAME = "computed_allocation";

    /**
     * The package namespace URI. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNS_URI = "http://sdq.ipd.uka.de/Context/Allocation/1.0";

    /**
     * The package namespace name. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String eNS_PREFIX = "";

    /**
     * The singleton instance of the package. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    ComputedAllocationPackage eINSTANCE = de.uka.ipd.sdq.context.computed_allocation.impl.ComputedAllocationPackageImpl
            .init();

    /**
     * The meta object id for the '
     * {@link de.uka.ipd.sdq.context.computed_allocation.impl.ComputedAllocationContextImpl
     * <em>Context</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.uka.ipd.sdq.context.computed_allocation.impl.ComputedAllocationContextImpl
     * @see de.uka.ipd.sdq.context.computed_allocation.impl.ComputedAllocationPackageImpl#getComputedAllocationContext()
     * @generated
     */
    int COMPUTED_ALLOCATION_CONTEXT = 0;

    /**
     * The feature id for the '<em><b>Id</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int COMPUTED_ALLOCATION_CONTEXT__ID = EntityPackage.ENTITY__ID;

    /**
     * The feature id for the '<em><b>Entity Name</b></em>' attribute. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int COMPUTED_ALLOCATION_CONTEXT__ENTITY_NAME = EntityPackage.ENTITY__ENTITY_NAME;

    /**
     * The feature id for the '<em><b>Resource Demands Computed Allocation Context</b></em>'
     * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int COMPUTED_ALLOCATION_CONTEXT__RESOURCE_DEMANDS_COMPUTED_ALLOCATION_CONTEXT = EntityPackage.ENTITY_FEATURE_COUNT + 0;

    /**
     * The feature id for the '<em><b>Usage Context Computed Allocation Context</b></em>' reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int COMPUTED_ALLOCATION_CONTEXT__USAGE_CONTEXT_COMPUTED_ALLOCATION_CONTEXT = EntityPackage.ENTITY_FEATURE_COUNT + 1;

    /**
     * The feature id for the '<em><b>Allocation Context Computed Allocation Context</b></em>'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int COMPUTED_ALLOCATION_CONTEXT__ALLOCATION_CONTEXT_COMPUTED_ALLOCATION_CONTEXT = EntityPackage.ENTITY_FEATURE_COUNT + 2;

    /**
     * The number of structural features of the '<em>Context</em>' class. <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int COMPUTED_ALLOCATION_CONTEXT_FEATURE_COUNT = EntityPackage.ENTITY_FEATURE_COUNT + 3;

    /**
     * The meta object id for the '
     * {@link de.uka.ipd.sdq.context.computed_allocation.impl.ResourceDemandImpl
     * <em>Resource Demand</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.uka.ipd.sdq.context.computed_allocation.impl.ResourceDemandImpl
     * @see de.uka.ipd.sdq.context.computed_allocation.impl.ComputedAllocationPackageImpl#getResourceDemand()
     * @generated
     */
    int RESOURCE_DEMAND = 1;

    /**
     * The feature id for the '<em><b>Parametric Resource Demand Resource Demand</b></em>'
     * reference. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int RESOURCE_DEMAND__PARAMETRIC_RESOURCE_DEMAND_RESOURCE_DEMAND = 0;

    /**
     * The feature id for the '<em><b>Specification Resource Demand</b></em>' containment reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int RESOURCE_DEMAND__SPECIFICATION_RESOURCE_DEMAND = 1;

    /**
     * The number of structural features of the '<em>Resource Demand</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int RESOURCE_DEMAND_FEATURE_COUNT = 2;

    /**
     * The meta object id for the '
     * {@link de.uka.ipd.sdq.context.computed_allocation.impl.ComputedAllocationImpl
     * <em>Computed Allocation</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see de.uka.ipd.sdq.context.computed_allocation.impl.ComputedAllocationImpl
     * @see de.uka.ipd.sdq.context.computed_allocation.impl.ComputedAllocationPackageImpl#getComputedAllocation()
     * @generated
     */
    int COMPUTED_ALLOCATION = 2;

    /**
     * The feature id for the '<em><b>Computed Allocation Contexts Computed Allocation</b></em>'
     * containment reference list. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int COMPUTED_ALLOCATION__COMPUTED_ALLOCATION_CONTEXTS_COMPUTED_ALLOCATION = 0;

    /**
     * The number of structural features of the '<em>Computed Allocation</em>' class. <!--
     * begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     * @ordered
     */
    int COMPUTED_ALLOCATION_FEATURE_COUNT = 1;

    /**
     * Returns the meta object for class '
     * {@link de.uka.ipd.sdq.context.computed_allocation.ComputedAllocationContext <em>Context</em>}
     * '. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Context</em>'.
     * @see de.uka.ipd.sdq.context.computed_allocation.ComputedAllocationContext
     * @generated
     */
    EClass getComputedAllocationContext();

    /**
     * Returns the meta object for the containment reference list '
     * {@link de.uka.ipd.sdq.context.computed_allocation.ComputedAllocationContext#getResourceDemands_ComputedAllocationContext
     * <em>Resource Demands Computed Allocation Context</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the meta object for the containment reference list '
     *         <em>Resource Demands Computed Allocation Context</em>'.
     * @see de.uka.ipd.sdq.context.computed_allocation.ComputedAllocationContext#getResourceDemands_ComputedAllocationContext()
     * @see #getComputedAllocationContext()
     * @generated
     */
    EReference getComputedAllocationContext_ResourceDemands_ComputedAllocationContext();

    /**
     * Returns the meta object for the reference '
     * {@link de.uka.ipd.sdq.context.computed_allocation.ComputedAllocationContext#getUsageContext_ComputedAllocationContext
     * <em>Usage Context Computed Allocation Context</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the meta object for the reference '<em>Usage Context Computed Allocation Context</em>
     *         '.
     * @see de.uka.ipd.sdq.context.computed_allocation.ComputedAllocationContext#getUsageContext_ComputedAllocationContext()
     * @see #getComputedAllocationContext()
     * @generated
     */
    EReference getComputedAllocationContext_UsageContext_ComputedAllocationContext();

    /**
     * Returns the meta object for the reference '
     * {@link de.uka.ipd.sdq.context.computed_allocation.ComputedAllocationContext#getAllocationContext_ComputedAllocationContext
     * <em>Allocation Context Computed Allocation Context</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the meta object for the reference '
     *         <em>Allocation Context Computed Allocation Context</em>'.
     * @see de.uka.ipd.sdq.context.computed_allocation.ComputedAllocationContext#getAllocationContext_ComputedAllocationContext()
     * @see #getComputedAllocationContext()
     * @generated
     */
    EReference getComputedAllocationContext_AllocationContext_ComputedAllocationContext();

    /**
     * Returns the meta object for class '
     * {@link de.uka.ipd.sdq.context.computed_allocation.ResourceDemand <em>Resource Demand</em>}'.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Resource Demand</em>'.
     * @see de.uka.ipd.sdq.context.computed_allocation.ResourceDemand
     * @generated
     */
    EClass getResourceDemand();

    /**
     * Returns the meta object for the reference '
     * {@link de.uka.ipd.sdq.context.computed_allocation.ResourceDemand#getParametricResourceDemand_ResourceDemand
     * <em>Parametric Resource Demand Resource Demand</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the meta object for the reference '
     *         <em>Parametric Resource Demand Resource Demand</em>'.
     * @see de.uka.ipd.sdq.context.computed_allocation.ResourceDemand#getParametricResourceDemand_ResourceDemand()
     * @see #getResourceDemand()
     * @generated
     */
    EReference getResourceDemand_ParametricResourceDemand_ResourceDemand();

    /**
     * Returns the meta object for the containment reference '
     * {@link de.uka.ipd.sdq.context.computed_allocation.ResourceDemand#getSpecification_ResourceDemand
     * <em>Specification Resource Demand</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for the containment reference '<em>Specification Resource Demand</em>
     *         '.
     * @see de.uka.ipd.sdq.context.computed_allocation.ResourceDemand#getSpecification_ResourceDemand()
     * @see #getResourceDemand()
     * @generated
     */
    EReference getResourceDemand_Specification_ResourceDemand();

    /**
     * Returns the meta object for class '
     * {@link de.uka.ipd.sdq.context.computed_allocation.ComputedAllocation
     * <em>Computed Allocation</em>}'. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @return the meta object for class '<em>Computed Allocation</em>'.
     * @see de.uka.ipd.sdq.context.computed_allocation.ComputedAllocation
     * @generated
     */
    EClass getComputedAllocation();

    /**
     * Returns the meta object for the containment reference list '
     * {@link de.uka.ipd.sdq.context.computed_allocation.ComputedAllocation#getComputedAllocationContexts_ComputedAllocation
     * <em>Computed Allocation Contexts Computed Allocation</em>}'. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the meta object for the containment reference list '
     *         <em>Computed Allocation Contexts Computed Allocation</em>'.
     * @see de.uka.ipd.sdq.context.computed_allocation.ComputedAllocation#getComputedAllocationContexts_ComputedAllocation()
     * @see #getComputedAllocation()
     * @generated
     */
    EReference getComputedAllocation_ComputedAllocationContexts_ComputedAllocation();

    /**
     * Returns the factory that creates the instances of the model. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @return the factory that creates the instances of the model.
     * @generated
     */
    ComputedAllocationFactory getComputedAllocationFactory();

    /**
     * <!-- begin-user-doc --> Defines literals for the meta objects that represent
     * <ul>
     * <li>each class,</li>
     * <li>each feature of each class,</li>
     * <li>each enum,</li>
     * <li>and each data type</li>
     * </ul>
     * <!-- end-user-doc -->
     * 
     * @generated
     */
    interface Literals {
        /**
         * The meta object literal for the '
         * {@link de.uka.ipd.sdq.context.computed_allocation.impl.ComputedAllocationContextImpl
         * <em>Context</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see de.uka.ipd.sdq.context.computed_allocation.impl.ComputedAllocationContextImpl
         * @see de.uka.ipd.sdq.context.computed_allocation.impl.ComputedAllocationPackageImpl#getComputedAllocationContext()
         * @generated
         */
        EClass COMPUTED_ALLOCATION_CONTEXT = eINSTANCE.getComputedAllocationContext();

        /**
         * The meta object literal for the '
         * <em><b>Resource Demands Computed Allocation Context</b></em>' containment reference list
         * feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference COMPUTED_ALLOCATION_CONTEXT__RESOURCE_DEMANDS_COMPUTED_ALLOCATION_CONTEXT = eINSTANCE
                .getComputedAllocationContext_ResourceDemands_ComputedAllocationContext();

        /**
         * The meta object literal for the '
         * <em><b>Usage Context Computed Allocation Context</b></em>' reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference COMPUTED_ALLOCATION_CONTEXT__USAGE_CONTEXT_COMPUTED_ALLOCATION_CONTEXT = eINSTANCE
                .getComputedAllocationContext_UsageContext_ComputedAllocationContext();

        /**
         * The meta object literal for the '
         * <em><b>Allocation Context Computed Allocation Context</b></em>' reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference COMPUTED_ALLOCATION_CONTEXT__ALLOCATION_CONTEXT_COMPUTED_ALLOCATION_CONTEXT = eINSTANCE
                .getComputedAllocationContext_AllocationContext_ComputedAllocationContext();

        /**
         * The meta object literal for the '
         * {@link de.uka.ipd.sdq.context.computed_allocation.impl.ResourceDemandImpl
         * <em>Resource Demand</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see de.uka.ipd.sdq.context.computed_allocation.impl.ResourceDemandImpl
         * @see de.uka.ipd.sdq.context.computed_allocation.impl.ComputedAllocationPackageImpl#getResourceDemand()
         * @generated
         */
        EClass RESOURCE_DEMAND = eINSTANCE.getResourceDemand();

        /**
         * The meta object literal for the '
         * <em><b>Parametric Resource Demand Resource Demand</b></em>' reference feature. <!--
         * begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference RESOURCE_DEMAND__PARAMETRIC_RESOURCE_DEMAND_RESOURCE_DEMAND = eINSTANCE
                .getResourceDemand_ParametricResourceDemand_ResourceDemand();

        /**
         * The meta object literal for the '<em><b>Specification Resource Demand</b></em>'
         * containment reference feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference RESOURCE_DEMAND__SPECIFICATION_RESOURCE_DEMAND = eINSTANCE
                .getResourceDemand_Specification_ResourceDemand();

        /**
         * The meta object literal for the '
         * {@link de.uka.ipd.sdq.context.computed_allocation.impl.ComputedAllocationImpl
         * <em>Computed Allocation</em>}' class. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @see de.uka.ipd.sdq.context.computed_allocation.impl.ComputedAllocationImpl
         * @see de.uka.ipd.sdq.context.computed_allocation.impl.ComputedAllocationPackageImpl#getComputedAllocation()
         * @generated
         */
        EClass COMPUTED_ALLOCATION = eINSTANCE.getComputedAllocation();

        /**
         * The meta object literal for the '
         * <em><b>Computed Allocation Contexts Computed Allocation</b></em>' containment reference
         * list feature. <!-- begin-user-doc --> <!-- end-user-doc -->
         * 
         * @generated
         */
        EReference COMPUTED_ALLOCATION__COMPUTED_ALLOCATION_CONTEXTS_COMPUTED_ALLOCATION = eINSTANCE
                .getComputedAllocation_ComputedAllocationContexts_ComputedAllocation();

    }

} // ComputedAllocationPackage
