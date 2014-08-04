/**
 * Copyright 2006, SDQ Group, University Karlsruhe (TH)
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.computed_allocation.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedUsageContextPackage;
import de.uka.ipd.sdq.context.aggregatedUsageContext.impl.AggregatedUsageContextPackageImpl;
import de.uka.ipd.sdq.context.computed_allocation.ComputedAllocation;
import de.uka.ipd.sdq.context.computed_allocation.ComputedAllocationContext;
import de.uka.ipd.sdq.context.computed_allocation.ComputedAllocationFactory;
import de.uka.ipd.sdq.context.computed_allocation.ComputedAllocationPackage;
import de.uka.ipd.sdq.context.computed_allocation.ResourceDemand;
import de.uka.ipd.sdq.context.computed_usage.ComputedUsagePackage;
import de.uka.ipd.sdq.context.computed_usage.impl.ComputedUsagePackageImpl;
import de.uka.ipd.sdq.pcm.PcmPackage;
import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;
import de.uka.ipd.sdq.pcm.core.CorePackage;
import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.seff.seff_performance.SeffPerformancePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class ComputedAllocationPackageImpl extends EPackageImpl implements ComputedAllocationPackage {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright 2006, SDQ Group, University Karlsruhe (TH)";

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass computedAllocationContextEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass resourceDemandEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass computedAllocationEClass = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package package URI
     * value.
     * <p>
     * Note: the correct way to create the package is via the static factory method {@link #init
     * init()}, which also performs initialization of the package, or returns the registered
     * package, if one already exists. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see de.uka.ipd.sdq.context.computed_allocation.ComputedAllocationPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private ComputedAllocationPackageImpl() {
        super(eNS_URI, ComputedAllocationFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others
     * upon which it depends.
     * 
     * <p>
     * This method is used to initialize {@link ComputedAllocationPackage#eINSTANCE} when that field
     * is accessed. Clients should not invoke it directly. Instead, they should simply access that
     * field to obtain the package. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static ComputedAllocationPackage init() {
        if (isInited)
            return (ComputedAllocationPackage) EPackage.Registry.INSTANCE
                    .getEPackage(ComputedAllocationPackage.eNS_URI);

        // Obtain or create and register package
        ComputedAllocationPackageImpl theComputedAllocationPackage = (ComputedAllocationPackageImpl) (EPackage.Registry.INSTANCE
                .get(eNS_URI) instanceof ComputedAllocationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI)
                : new ComputedAllocationPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        PcmPackage.eINSTANCE.eClass();

        // Obtain or create and register interdependencies
        ComputedUsagePackageImpl theComputedUsagePackage = (ComputedUsagePackageImpl) (EPackage.Registry.INSTANCE
                .getEPackage(ComputedUsagePackage.eNS_URI) instanceof ComputedUsagePackageImpl ? EPackage.Registry.INSTANCE
                .getEPackage(ComputedUsagePackage.eNS_URI) : ComputedUsagePackage.eINSTANCE);
        AggregatedUsageContextPackageImpl theAggregatedUsageContextPackage = (AggregatedUsageContextPackageImpl) (EPackage.Registry.INSTANCE
                .getEPackage(AggregatedUsageContextPackage.eNS_URI) instanceof AggregatedUsageContextPackageImpl ? EPackage.Registry.INSTANCE
                .getEPackage(AggregatedUsageContextPackage.eNS_URI) : AggregatedUsageContextPackage.eINSTANCE);

        // Create package meta-data objects
        theComputedAllocationPackage.createPackageContents();
        theComputedUsagePackage.createPackageContents();
        theAggregatedUsageContextPackage.createPackageContents();

        // Initialize created meta-data
        theComputedAllocationPackage.initializePackageContents();
        theComputedUsagePackage.initializePackageContents();
        theAggregatedUsageContextPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theComputedAllocationPackage.freeze();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(ComputedAllocationPackage.eNS_URI, theComputedAllocationPackage);
        return theComputedAllocationPackage;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getComputedAllocationContext() {
        return computedAllocationContextEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getComputedAllocationContext_ResourceDemands_ComputedAllocationContext() {
        return (EReference) computedAllocationContextEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getComputedAllocationContext_UsageContext_ComputedAllocationContext() {
        return (EReference) computedAllocationContextEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getComputedAllocationContext_AllocationContext_ComputedAllocationContext() {
        return (EReference) computedAllocationContextEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getResourceDemand() {
        return resourceDemandEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getResourceDemand_ParametricResourceDemand_ResourceDemand() {
        return (EReference) resourceDemandEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getResourceDemand_Specification_ResourceDemand() {
        return (EReference) resourceDemandEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getComputedAllocation() {
        return computedAllocationEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getComputedAllocation_ComputedAllocationContexts_ComputedAllocation() {
        return (EReference) computedAllocationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public ComputedAllocationFactory getComputedAllocationFactory() {
        return (ComputedAllocationFactory) getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package. This method is guarded to have no affect on
     * any invocation but its first. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void createPackageContents() {
        if (isCreated)
            return;
        isCreated = true;

        // Create classes and their features
        computedAllocationContextEClass = createEClass(COMPUTED_ALLOCATION_CONTEXT);
        createEReference(computedAllocationContextEClass,
                COMPUTED_ALLOCATION_CONTEXT__RESOURCE_DEMANDS_COMPUTED_ALLOCATION_CONTEXT);
        createEReference(computedAllocationContextEClass,
                COMPUTED_ALLOCATION_CONTEXT__USAGE_CONTEXT_COMPUTED_ALLOCATION_CONTEXT);
        createEReference(computedAllocationContextEClass,
                COMPUTED_ALLOCATION_CONTEXT__ALLOCATION_CONTEXT_COMPUTED_ALLOCATION_CONTEXT);

        resourceDemandEClass = createEClass(RESOURCE_DEMAND);
        createEReference(resourceDemandEClass, RESOURCE_DEMAND__PARAMETRIC_RESOURCE_DEMAND_RESOURCE_DEMAND);
        createEReference(resourceDemandEClass, RESOURCE_DEMAND__SPECIFICATION_RESOURCE_DEMAND);

        computedAllocationEClass = createEClass(COMPUTED_ALLOCATION);
        createEReference(computedAllocationEClass,
                COMPUTED_ALLOCATION__COMPUTED_ALLOCATION_CONTEXTS_COMPUTED_ALLOCATION);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model. This method is guarded to have
     * no affect on any invocation but its first. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public void initializePackageContents() {
        if (isInitialized)
            return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Obtain other dependent packages
        EntityPackage theEntityPackage = (EntityPackage) EPackage.Registry.INSTANCE.getEPackage(EntityPackage.eNS_URI);
        ComputedUsagePackage theComputedUsagePackage = (ComputedUsagePackage) EPackage.Registry.INSTANCE
                .getEPackage(ComputedUsagePackage.eNS_URI);
        AllocationPackage theAllocationPackage = (AllocationPackage) EPackage.Registry.INSTANCE
                .getEPackage(AllocationPackage.eNS_URI);
        SeffPerformancePackage theSeffPerformancePackage = (SeffPerformancePackage) EPackage.Registry.INSTANCE
                .getEPackage(SeffPerformancePackage.eNS_URI);
        CorePackage theCorePackage = (CorePackage) EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        computedAllocationContextEClass.getESuperTypes().add(theEntityPackage.getEntity());

        // Initialize classes and features; add operations and parameters
        initEClass(computedAllocationContextEClass, ComputedAllocationContext.class, "ComputedAllocationContext",
                !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getComputedAllocationContext_ResourceDemands_ComputedAllocationContext(),
                this.getResourceDemand(), null, "resourceDemands_ComputedAllocationContext", null, 0, -1,
                ComputedAllocationContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getComputedAllocationContext_UsageContext_ComputedAllocationContext(),
                theComputedUsagePackage.getComputedUsageContext(), null, "usageContext_ComputedAllocationContext",
                null, 1, 1, ComputedAllocationContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getComputedAllocationContext_AllocationContext_ComputedAllocationContext(),
                theAllocationPackage.getAllocationContext(), null, "allocationContext_ComputedAllocationContext", null,
                1, 1, ComputedAllocationContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(resourceDemandEClass, ResourceDemand.class, "ResourceDemand", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEReference(getResourceDemand_ParametricResourceDemand_ResourceDemand(),
                theSeffPerformancePackage.getParametricResourceDemand(), null,
                "parametricResourceDemand_ResourceDemand", null, 1, 1, ResourceDemand.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
                !IS_ORDERED);
        initEReference(getResourceDemand_Specification_ResourceDemand(), theCorePackage.getPCMRandomVariable(), null,
                "specification_ResourceDemand", null, 1, 1, ResourceDemand.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(computedAllocationEClass, ComputedAllocation.class, "ComputedAllocation", !IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getComputedAllocation_ComputedAllocationContexts_ComputedAllocation(),
                this.getComputedAllocationContext(), null, "computedAllocationContexts_ComputedAllocation", null, 0,
                -1, ComputedAllocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        // Create resource
        createResource(eNS_URI);
    }

} // ComputedAllocationPackageImpl
