/**
 * Copyright 2006, SDQ Group, University Karlsruhe (TH)
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.aggregatedUsageContext.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedCommunication;
import de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedResourceDemand;
import de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedUsageContextFactory;
import de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedUsageContextPackage;
import de.uka.ipd.sdq.context.aggregatedUsageContext.ComputedAggregatedUsage;
import de.uka.ipd.sdq.context.aggregatedUsageContext.ServiceExecutionContext;
import de.uka.ipd.sdq.context.computed_allocation.ComputedAllocationPackage;
import de.uka.ipd.sdq.context.computed_allocation.impl.ComputedAllocationPackageImpl;
import de.uka.ipd.sdq.context.computed_usage.ComputedUsagePackage;
import de.uka.ipd.sdq.context.computed_usage.impl.ComputedUsagePackageImpl;
import de.uka.ipd.sdq.pcm.PcmPackage;
import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;
import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class AggregatedUsageContextPackageImpl extends EPackageImpl implements AggregatedUsageContextPackage {
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
    private EClass serviceExecutionContextEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass aggregatedResourceDemandEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass aggregatedCommunicationEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass computedAggregatedUsageEClass = null;

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
     * @see de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedUsageContextPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private AggregatedUsageContextPackageImpl() {
        super(eNS_URI, AggregatedUsageContextFactory.eINSTANCE);
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
     * This method is used to initialize {@link AggregatedUsageContextPackage#eINSTANCE} when that
     * field is accessed. Clients should not invoke it directly. Instead, they should simply access
     * that field to obtain the package. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static AggregatedUsageContextPackage init() {
        if (isInited)
            return (AggregatedUsageContextPackage) EPackage.Registry.INSTANCE
                    .getEPackage(AggregatedUsageContextPackage.eNS_URI);

        // Obtain or create and register package
        AggregatedUsageContextPackageImpl theAggregatedUsageContextPackage = (AggregatedUsageContextPackageImpl) (EPackage.Registry.INSTANCE
                .get(eNS_URI) instanceof AggregatedUsageContextPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI)
                : new AggregatedUsageContextPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        PcmPackage.eINSTANCE.eClass();

        // Obtain or create and register interdependencies
        ComputedUsagePackageImpl theComputedUsagePackage = (ComputedUsagePackageImpl) (EPackage.Registry.INSTANCE
                .getEPackage(ComputedUsagePackage.eNS_URI) instanceof ComputedUsagePackageImpl ? EPackage.Registry.INSTANCE
                .getEPackage(ComputedUsagePackage.eNS_URI) : ComputedUsagePackage.eINSTANCE);
        ComputedAllocationPackageImpl theComputedAllocationPackage = (ComputedAllocationPackageImpl) (EPackage.Registry.INSTANCE
                .getEPackage(ComputedAllocationPackage.eNS_URI) instanceof ComputedAllocationPackageImpl ? EPackage.Registry.INSTANCE
                .getEPackage(ComputedAllocationPackage.eNS_URI) : ComputedAllocationPackage.eINSTANCE);

        // Create package meta-data objects
        theAggregatedUsageContextPackage.createPackageContents();
        theComputedUsagePackage.createPackageContents();
        theComputedAllocationPackage.createPackageContents();

        // Initialize created meta-data
        theAggregatedUsageContextPackage.initializePackageContents();
        theComputedUsagePackage.initializePackageContents();
        theComputedAllocationPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theAggregatedUsageContextPackage.freeze();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(AggregatedUsageContextPackage.eNS_URI, theAggregatedUsageContextPackage);
        return theAggregatedUsageContextPackage;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getServiceExecutionContext() {
        return serviceExecutionContextEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getServiceExecutionContext_GlobalExecutionFrequency() {
        return (EAttribute) serviceExecutionContextEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getServiceExecutionContext_AllocationContext_ServiceExecutionContext() {
        return (EReference) serviceExecutionContextEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getServiceExecutionContext_DescribedSEFF_ServiceExecutionContext() {
        return (EReference) serviceExecutionContextEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getServiceExecutionContext_AggregatedResourceDemands_ServiceExecutionContext() {
        return (EReference) serviceExecutionContextEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getServiceExecutionContext_UsageScenario_ServiceExecutionContext() {
        return (EReference) serviceExecutionContextEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getServiceExecutionContext_SentAggregatedCommunications_ServiceExecutionContext() {
        return (EReference) serviceExecutionContextEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getServiceExecutionContext_ReceivedAggregatedCommunication_AggregatedCommunication() {
        return (EReference) serviceExecutionContextEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getAggregatedResourceDemand() {
        return aggregatedResourceDemandEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getAggregatedResourceDemand_AggregatedResourceDemand() {
        return (EAttribute) aggregatedResourceDemandEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getAggregatedResourceDemand_ResourceType_AggregatedResourceDemand() {
        return (EReference) aggregatedResourceDemandEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getAggregatedCommunication() {
        return aggregatedCommunicationEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getAggregatedCommunication_AverageMessageSize() {
        return (EAttribute) aggregatedCommunicationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getAggregatedCommunication_AverageMessageFrequency() {
        return (EAttribute) aggregatedCommunicationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getAggregatedCommunication_Receiver_AggregatedCommunication() {
        return (EReference) aggregatedCommunicationEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getAggregatedCommunication_UsedCommunicationLinkResourceSpecification_AggregatedCommunication() {
        return (EReference) aggregatedCommunicationEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getComputedAggregatedUsage() {
        return computedAggregatedUsageEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getComputedAggregatedUsage_ServiceExecutionContexts_ComputedAggregatedUsage() {
        return (EReference) computedAggregatedUsageEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public AggregatedUsageContextFactory getAggregatedUsageContextFactory() {
        return (AggregatedUsageContextFactory) getEFactoryInstance();
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
        serviceExecutionContextEClass = createEClass(SERVICE_EXECUTION_CONTEXT);
        createEAttribute(serviceExecutionContextEClass, SERVICE_EXECUTION_CONTEXT__GLOBAL_EXECUTION_FREQUENCY);
        createEReference(serviceExecutionContextEClass,
                SERVICE_EXECUTION_CONTEXT__ALLOCATION_CONTEXT_SERVICE_EXECUTION_CONTEXT);
        createEReference(serviceExecutionContextEClass,
                SERVICE_EXECUTION_CONTEXT__DESCRIBED_SEFF_SERVICE_EXECUTION_CONTEXT);
        createEReference(serviceExecutionContextEClass,
                SERVICE_EXECUTION_CONTEXT__AGGREGATED_RESOURCE_DEMANDS_SERVICE_EXECUTION_CONTEXT);
        createEReference(serviceExecutionContextEClass,
                SERVICE_EXECUTION_CONTEXT__USAGE_SCENARIO_SERVICE_EXECUTION_CONTEXT);
        createEReference(serviceExecutionContextEClass,
                SERVICE_EXECUTION_CONTEXT__SENT_AGGREGATED_COMMUNICATIONS_SERVICE_EXECUTION_CONTEXT);
        createEReference(serviceExecutionContextEClass,
                SERVICE_EXECUTION_CONTEXT__RECEIVED_AGGREGATED_COMMUNICATION_AGGREGATED_COMMUNICATION);

        aggregatedResourceDemandEClass = createEClass(AGGREGATED_RESOURCE_DEMAND);
        createEAttribute(aggregatedResourceDemandEClass, AGGREGATED_RESOURCE_DEMAND__AGGREGATED_RESOURCE_DEMAND);
        createEReference(aggregatedResourceDemandEClass,
                AGGREGATED_RESOURCE_DEMAND__RESOURCE_TYPE_AGGREGATED_RESOURCE_DEMAND);

        aggregatedCommunicationEClass = createEClass(AGGREGATED_COMMUNICATION);
        createEAttribute(aggregatedCommunicationEClass, AGGREGATED_COMMUNICATION__AVERAGE_MESSAGE_SIZE);
        createEAttribute(aggregatedCommunicationEClass, AGGREGATED_COMMUNICATION__AVERAGE_MESSAGE_FREQUENCY);
        createEReference(aggregatedCommunicationEClass, AGGREGATED_COMMUNICATION__RECEIVER_AGGREGATED_COMMUNICATION);
        createEReference(aggregatedCommunicationEClass,
                AGGREGATED_COMMUNICATION__USED_COMMUNICATION_LINK_RESOURCE_SPECIFICATION_AGGREGATED_COMMUNICATION);

        computedAggregatedUsageEClass = createEClass(COMPUTED_AGGREGATED_USAGE);
        createEReference(computedAggregatedUsageEClass,
                COMPUTED_AGGREGATED_USAGE__SERVICE_EXECUTION_CONTEXTS_COMPUTED_AGGREGATED_USAGE);
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
        AllocationPackage theAllocationPackage = (AllocationPackage) EPackage.Registry.INSTANCE
                .getEPackage(AllocationPackage.eNS_URI);
        SeffPackage theSeffPackage = (SeffPackage) EPackage.Registry.INSTANCE.getEPackage(SeffPackage.eNS_URI);
        UsagemodelPackage theUsagemodelPackage = (UsagemodelPackage) EPackage.Registry.INSTANCE
                .getEPackage(UsagemodelPackage.eNS_URI);
        ResourcetypePackage theResourcetypePackage = (ResourcetypePackage) EPackage.Registry.INSTANCE
                .getEPackage(ResourcetypePackage.eNS_URI);
        ResourceenvironmentPackage theResourceenvironmentPackage = (ResourceenvironmentPackage) EPackage.Registry.INSTANCE
                .getEPackage(ResourceenvironmentPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes

        // Initialize classes and features; add operations and parameters
        initEClass(serviceExecutionContextEClass, ServiceExecutionContext.class, "ServiceExecutionContext",
                !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getServiceExecutionContext_GlobalExecutionFrequency(), ecorePackage.getEDouble(),
                "globalExecutionFrequency", null, 1, 1, ServiceExecutionContext.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getServiceExecutionContext_AllocationContext_ServiceExecutionContext(),
                theAllocationPackage.getAllocationContext(), null, "allocationContext_ServiceExecutionContext", null,
                1, 1, ServiceExecutionContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getServiceExecutionContext_DescribedSEFF_ServiceExecutionContext(),
                theSeffPackage.getResourceDemandingSEFF(), null, "describedSEFF_ServiceExecutionContext", null, 1, 1,
                ServiceExecutionContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getServiceExecutionContext_AggregatedResourceDemands_ServiceExecutionContext(),
                this.getAggregatedResourceDemand(), null, "aggregatedResourceDemands_ServiceExecutionContext", null, 0,
                -1, ServiceExecutionContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getServiceExecutionContext_UsageScenario_ServiceExecutionContext(),
                theUsagemodelPackage.getUsageScenario(), null, "usageScenario_ServiceExecutionContext", null, 1, 1,
                ServiceExecutionContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getServiceExecutionContext_SentAggregatedCommunications_ServiceExecutionContext(),
                this.getAggregatedCommunication(), null, "sentAggregatedCommunications_ServiceExecutionContext", null,
                0, -1, ServiceExecutionContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getServiceExecutionContext_ReceivedAggregatedCommunication_AggregatedCommunication(),
                this.getAggregatedCommunication(), this.getAggregatedCommunication_Receiver_AggregatedCommunication(),
                "receivedAggregatedCommunication_AggregatedCommunication", null, 0, -1, ServiceExecutionContext.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
                IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(aggregatedResourceDemandEClass, AggregatedResourceDemand.class, "AggregatedResourceDemand",
                !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getAggregatedResourceDemand_AggregatedResourceDemand(), ecorePackage.getEDouble(),
                "aggregatedResourceDemand", null, 1, 1, AggregatedResourceDemand.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getAggregatedResourceDemand_ResourceType_AggregatedResourceDemand(),
                theResourcetypePackage.getResourceType(), null, "resourceType_AggregatedResourceDemand", null, 1, 1,
                AggregatedResourceDemand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(aggregatedCommunicationEClass, AggregatedCommunication.class, "AggregatedCommunication",
                !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getAggregatedCommunication_AverageMessageSize(), ecorePackage.getEDouble(),
                "averageMessageSize", null, 1, 1, AggregatedCommunication.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getAggregatedCommunication_AverageMessageFrequency(), ecorePackage.getEDouble(),
                "averageMessageFrequency", null, 1, 1, AggregatedCommunication.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getAggregatedCommunication_Receiver_AggregatedCommunication(),
                this.getServiceExecutionContext(),
                this.getServiceExecutionContext_ReceivedAggregatedCommunication_AggregatedCommunication(),
                "receiver_AggregatedCommunication", null, 1, 1, AggregatedCommunication.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
                !IS_ORDERED);
        initEReference(getAggregatedCommunication_UsedCommunicationLinkResourceSpecification_AggregatedCommunication(),
                theResourceenvironmentPackage.getCommunicationLinkResourceSpecification(), null,
                "usedCommunicationLinkResourceSpecification_AggregatedCommunication", null, 0, 1,
                AggregatedCommunication.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(computedAggregatedUsageEClass, ComputedAggregatedUsage.class, "ComputedAggregatedUsage",
                !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getComputedAggregatedUsage_ServiceExecutionContexts_ComputedAggregatedUsage(),
                this.getServiceExecutionContext(), null, "serviceExecutionContexts_ComputedAggregatedUsage", null, 0,
                -1, ComputedAggregatedUsage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        // Create resource
        createResource(eNS_URI);
    }

} // AggregatedUsageContextPackageImpl
