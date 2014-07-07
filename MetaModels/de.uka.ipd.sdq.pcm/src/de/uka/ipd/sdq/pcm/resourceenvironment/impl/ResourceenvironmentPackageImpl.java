/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resourceenvironment.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.uml2.types.TypesPackage;

import de.uka.ipd.sdq.identifier.IdentifierPackage;
import de.uka.ipd.sdq.pcm.PcmPackage;
import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;
import de.uka.ipd.sdq.pcm.allocation.impl.AllocationPackageImpl;
import de.uka.ipd.sdq.pcm.core.CorePackage;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.core.composition.impl.CompositionPackageImpl;
import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.core.entity.impl.EntityPackageImpl;
import de.uka.ipd.sdq.pcm.core.impl.CorePackageImpl;
import de.uka.ipd.sdq.pcm.impl.PcmPackageImpl;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.parameter.impl.ParameterPackageImpl;
import de.uka.ipd.sdq.pcm.protocol.ProtocolPackage;
import de.uka.ipd.sdq.pcm.protocol.impl.ProtocolPackageImpl;
import de.uka.ipd.sdq.pcm.qosannotations.QosannotationsPackage;
import de.uka.ipd.sdq.pcm.qosannotations.impl.QosannotationsPackageImpl;
import de.uka.ipd.sdq.pcm.qosannotations.qos_performance.QosPerformancePackage;
import de.uka.ipd.sdq.pcm.qosannotations.qos_performance.impl.QosPerformancePackageImpl;
import de.uka.ipd.sdq.pcm.qosannotations.qos_reliability.QosReliabilityPackage;
import de.uka.ipd.sdq.pcm.qosannotations.qos_reliability.impl.QosReliabilityPackageImpl;
import de.uka.ipd.sdq.pcm.reliability.ReliabilityPackage;
import de.uka.ipd.sdq.pcm.reliability.impl.ReliabilityPackageImpl;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl;
import de.uka.ipd.sdq.pcm.resourceenvironment.CommunicationLinkResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.LinkingResource;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceEnvironment;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentFactory;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;
import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;
import de.uka.ipd.sdq.pcm.resourcetype.impl.ResourcetypePackageImpl;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl;
import de.uka.ipd.sdq.pcm.seff.seff_performance.SeffPerformancePackage;
import de.uka.ipd.sdq.pcm.seff.seff_performance.impl.SeffPerformancePackageImpl;
import de.uka.ipd.sdq.pcm.seff.seff_reliability.SeffReliabilityPackage;
import de.uka.ipd.sdq.pcm.seff.seff_reliability.impl.SeffReliabilityPackageImpl;
import de.uka.ipd.sdq.pcm.subsystem.SubsystemPackage;
import de.uka.ipd.sdq.pcm.subsystem.impl.SubsystemPackageImpl;
import de.uka.ipd.sdq.pcm.system.SystemPackage;
import de.uka.ipd.sdq.pcm.system.impl.SystemPackageImpl;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;
import de.uka.ipd.sdq.pcm.usagemodel.impl.UsagemodelPackageImpl;
import de.uka.ipd.sdq.stoex.StoexPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class ResourceenvironmentPackageImpl extends EPackageImpl implements ResourceenvironmentPackage {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass resourceEnvironmentEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass linkingResourceEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass resourceContainerEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass processingResourceSpecificationEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass communicationLinkResourceSpecificationEClass = null;

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
     * @see de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private ResourceenvironmentPackageImpl() {
        super(eNS_URI, ResourceenvironmentFactory.eINSTANCE);
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
     * This method is used to initialize {@link ResourceenvironmentPackage#eINSTANCE} when that
     * field is accessed. Clients should not invoke it directly. Instead, they should simply access
     * that field to obtain the package. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static ResourceenvironmentPackage init() {
        if (isInited)
            return (ResourceenvironmentPackage) EPackage.Registry.INSTANCE
                    .getEPackage(ResourceenvironmentPackage.eNS_URI);

        // Obtain or create and register package
        ResourceenvironmentPackageImpl theResourceenvironmentPackage = (ResourceenvironmentPackageImpl) (EPackage.Registry.INSTANCE
                .get(eNS_URI) instanceof ResourceenvironmentPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI)
                : new ResourceenvironmentPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        IdentifierPackage.eINSTANCE.eClass();
        StoexPackage.eINSTANCE.eClass();
        TypesPackage.eINSTANCE.eClass();

        // Obtain or create and register interdependencies
        PcmPackageImpl thePcmPackage = (PcmPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(PcmPackage.eNS_URI) instanceof PcmPackageImpl ? EPackage.Registry.INSTANCE
                .getEPackage(PcmPackage.eNS_URI) : PcmPackage.eINSTANCE);
        CorePackageImpl theCorePackage = (CorePackageImpl) (EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI) instanceof CorePackageImpl ? EPackage.Registry.INSTANCE
                .getEPackage(CorePackage.eNS_URI) : CorePackage.eINSTANCE);
        EntityPackageImpl theEntityPackage = (EntityPackageImpl) (EPackage.Registry.INSTANCE
                .getEPackage(EntityPackage.eNS_URI) instanceof EntityPackageImpl ? EPackage.Registry.INSTANCE
                .getEPackage(EntityPackage.eNS_URI) : EntityPackage.eINSTANCE);
        CompositionPackageImpl theCompositionPackage = (CompositionPackageImpl) (EPackage.Registry.INSTANCE
                .getEPackage(CompositionPackage.eNS_URI) instanceof CompositionPackageImpl ? EPackage.Registry.INSTANCE
                .getEPackage(CompositionPackage.eNS_URI) : CompositionPackage.eINSTANCE);
        UsagemodelPackageImpl theUsagemodelPackage = (UsagemodelPackageImpl) (EPackage.Registry.INSTANCE
                .getEPackage(UsagemodelPackage.eNS_URI) instanceof UsagemodelPackageImpl ? EPackage.Registry.INSTANCE
                .getEPackage(UsagemodelPackage.eNS_URI) : UsagemodelPackage.eINSTANCE);
        RepositoryPackageImpl theRepositoryPackage = (RepositoryPackageImpl) (EPackage.Registry.INSTANCE
                .getEPackage(RepositoryPackage.eNS_URI) instanceof RepositoryPackageImpl ? EPackage.Registry.INSTANCE
                .getEPackage(RepositoryPackage.eNS_URI) : RepositoryPackage.eINSTANCE);
        ResourcetypePackageImpl theResourcetypePackage = (ResourcetypePackageImpl) (EPackage.Registry.INSTANCE
                .getEPackage(ResourcetypePackage.eNS_URI) instanceof ResourcetypePackageImpl ? EPackage.Registry.INSTANCE
                .getEPackage(ResourcetypePackage.eNS_URI) : ResourcetypePackage.eINSTANCE);
        ProtocolPackageImpl theProtocolPackage = (ProtocolPackageImpl) (EPackage.Registry.INSTANCE
                .getEPackage(ProtocolPackage.eNS_URI) instanceof ProtocolPackageImpl ? EPackage.Registry.INSTANCE
                .getEPackage(ProtocolPackage.eNS_URI) : ProtocolPackage.eINSTANCE);
        ParameterPackageImpl theParameterPackage = (ParameterPackageImpl) (EPackage.Registry.INSTANCE
                .getEPackage(ParameterPackage.eNS_URI) instanceof ParameterPackageImpl ? EPackage.Registry.INSTANCE
                .getEPackage(ParameterPackage.eNS_URI) : ParameterPackage.eINSTANCE);
        ReliabilityPackageImpl theReliabilityPackage = (ReliabilityPackageImpl) (EPackage.Registry.INSTANCE
                .getEPackage(ReliabilityPackage.eNS_URI) instanceof ReliabilityPackageImpl ? EPackage.Registry.INSTANCE
                .getEPackage(ReliabilityPackage.eNS_URI) : ReliabilityPackage.eINSTANCE);
        SeffPackageImpl theSeffPackage = (SeffPackageImpl) (EPackage.Registry.INSTANCE.getEPackage(SeffPackage.eNS_URI) instanceof SeffPackageImpl ? EPackage.Registry.INSTANCE
                .getEPackage(SeffPackage.eNS_URI) : SeffPackage.eINSTANCE);
        SeffPerformancePackageImpl theSeffPerformancePackage = (SeffPerformancePackageImpl) (EPackage.Registry.INSTANCE
                .getEPackage(SeffPerformancePackage.eNS_URI) instanceof SeffPerformancePackageImpl ? EPackage.Registry.INSTANCE
                .getEPackage(SeffPerformancePackage.eNS_URI) : SeffPerformancePackage.eINSTANCE);
        SeffReliabilityPackageImpl theSeffReliabilityPackage = (SeffReliabilityPackageImpl) (EPackage.Registry.INSTANCE
                .getEPackage(SeffReliabilityPackage.eNS_URI) instanceof SeffReliabilityPackageImpl ? EPackage.Registry.INSTANCE
                .getEPackage(SeffReliabilityPackage.eNS_URI) : SeffReliabilityPackage.eINSTANCE);
        QosannotationsPackageImpl theQosannotationsPackage = (QosannotationsPackageImpl) (EPackage.Registry.INSTANCE
                .getEPackage(QosannotationsPackage.eNS_URI) instanceof QosannotationsPackageImpl ? EPackage.Registry.INSTANCE
                .getEPackage(QosannotationsPackage.eNS_URI) : QosannotationsPackage.eINSTANCE);
        QosPerformancePackageImpl theQosPerformancePackage = (QosPerformancePackageImpl) (EPackage.Registry.INSTANCE
                .getEPackage(QosPerformancePackage.eNS_URI) instanceof QosPerformancePackageImpl ? EPackage.Registry.INSTANCE
                .getEPackage(QosPerformancePackage.eNS_URI) : QosPerformancePackage.eINSTANCE);
        QosReliabilityPackageImpl theQosReliabilityPackage = (QosReliabilityPackageImpl) (EPackage.Registry.INSTANCE
                .getEPackage(QosReliabilityPackage.eNS_URI) instanceof QosReliabilityPackageImpl ? EPackage.Registry.INSTANCE
                .getEPackage(QosReliabilityPackage.eNS_URI) : QosReliabilityPackage.eINSTANCE);
        SystemPackageImpl theSystemPackage = (SystemPackageImpl) (EPackage.Registry.INSTANCE
                .getEPackage(SystemPackage.eNS_URI) instanceof SystemPackageImpl ? EPackage.Registry.INSTANCE
                .getEPackage(SystemPackage.eNS_URI) : SystemPackage.eINSTANCE);
        AllocationPackageImpl theAllocationPackage = (AllocationPackageImpl) (EPackage.Registry.INSTANCE
                .getEPackage(AllocationPackage.eNS_URI) instanceof AllocationPackageImpl ? EPackage.Registry.INSTANCE
                .getEPackage(AllocationPackage.eNS_URI) : AllocationPackage.eINSTANCE);
        SubsystemPackageImpl theSubsystemPackage = (SubsystemPackageImpl) (EPackage.Registry.INSTANCE
                .getEPackage(SubsystemPackage.eNS_URI) instanceof SubsystemPackageImpl ? EPackage.Registry.INSTANCE
                .getEPackage(SubsystemPackage.eNS_URI) : SubsystemPackage.eINSTANCE);

        // Create package meta-data objects
        theResourceenvironmentPackage.createPackageContents();
        thePcmPackage.createPackageContents();
        theCorePackage.createPackageContents();
        theEntityPackage.createPackageContents();
        theCompositionPackage.createPackageContents();
        theUsagemodelPackage.createPackageContents();
        theRepositoryPackage.createPackageContents();
        theResourcetypePackage.createPackageContents();
        theProtocolPackage.createPackageContents();
        theParameterPackage.createPackageContents();
        theReliabilityPackage.createPackageContents();
        theSeffPackage.createPackageContents();
        theSeffPerformancePackage.createPackageContents();
        theSeffReliabilityPackage.createPackageContents();
        theQosannotationsPackage.createPackageContents();
        theQosPerformancePackage.createPackageContents();
        theQosReliabilityPackage.createPackageContents();
        theSystemPackage.createPackageContents();
        theAllocationPackage.createPackageContents();
        theSubsystemPackage.createPackageContents();

        // Initialize created meta-data
        theResourceenvironmentPackage.initializePackageContents();
        thePcmPackage.initializePackageContents();
        theCorePackage.initializePackageContents();
        theEntityPackage.initializePackageContents();
        theCompositionPackage.initializePackageContents();
        theUsagemodelPackage.initializePackageContents();
        theRepositoryPackage.initializePackageContents();
        theResourcetypePackage.initializePackageContents();
        theProtocolPackage.initializePackageContents();
        theParameterPackage.initializePackageContents();
        theReliabilityPackage.initializePackageContents();
        theSeffPackage.initializePackageContents();
        theSeffPerformancePackage.initializePackageContents();
        theSeffReliabilityPackage.initializePackageContents();
        theQosannotationsPackage.initializePackageContents();
        theQosPerformancePackage.initializePackageContents();
        theQosReliabilityPackage.initializePackageContents();
        theSystemPackage.initializePackageContents();
        theAllocationPackage.initializePackageContents();
        theSubsystemPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theResourceenvironmentPackage.freeze();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(ResourceenvironmentPackage.eNS_URI, theResourceenvironmentPackage);
        return theResourceenvironmentPackage;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getResourceEnvironment() {
        return resourceEnvironmentEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getResourceEnvironment_LinkingResources__ResourceEnvironment() {
        return (EReference) resourceEnvironmentEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getResourceEnvironment_ResourceContainer_ResourceEnvironment() {
        return (EReference) resourceEnvironmentEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getLinkingResource() {
        return linkingResourceEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getLinkingResource_ConnectedResourceContainers_LinkingResource() {
        return (EReference) linkingResourceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getLinkingResource_CommunicationLinkResourceSpecifications_LinkingResource() {
        return (EReference) linkingResourceEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getLinkingResource_ResourceEnvironment_LinkingResource() {
        return (EReference) linkingResourceEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getResourceContainer() {
        return resourceContainerEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getResourceContainer_ActiveResourceSpecifications_ResourceContainer() {
        return (EReference) resourceContainerEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getResourceContainer_ResourceEnvironment_ResourceContainer() {
        return (EReference) resourceContainerEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getResourceContainer_NestedResourceContainers__ResourceContainer() {
        return (EReference) resourceContainerEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getResourceContainer_ParentResourceContainer__ResourceContainer() {
        return (EReference) resourceContainerEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getProcessingResourceSpecification() {
        return processingResourceSpecificationEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getProcessingResourceSpecification_MTTR() {
        return (EAttribute) processingResourceSpecificationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getProcessingResourceSpecification_MTTF() {
        return (EAttribute) processingResourceSpecificationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getProcessingResourceSpecification_RequiredByContainer() {
        return (EAttribute) processingResourceSpecificationEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getProcessingResourceSpecification_SchedulingPolicy() {
        return (EReference) processingResourceSpecificationEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getProcessingResourceSpecification_ActiveResourceType_ActiveResourceSpecification() {
        return (EReference) processingResourceSpecificationEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getProcessingResourceSpecification_ProcessingRate_ProcessingResourceSpecification() {
        return (EReference) processingResourceSpecificationEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getProcessingResourceSpecification_NumberOfReplicas() {
        return (EAttribute) processingResourceSpecificationEClass.getEStructuralFeatures().get(6);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getProcessingResourceSpecification_ResourceContainer_ProcessingResourceSpecification() {
        return (EReference) processingResourceSpecificationEClass.getEStructuralFeatures().get(7);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getCommunicationLinkResourceSpecification() {
        return communicationLinkResourceSpecificationEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getCommunicationLinkResourceSpecification_LinkingResource_CommunicationLinkResourceSpecification() {
        return (EReference) communicationLinkResourceSpecificationEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EAttribute getCommunicationLinkResourceSpecification_FailureProbability() {
        return (EAttribute) communicationLinkResourceSpecificationEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getCommunicationLinkResourceSpecification_CommunicationLinkResourceType_CommunicationLinkResourceSpecification() {
        return (EReference) communicationLinkResourceSpecificationEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getCommunicationLinkResourceSpecification_Latency_CommunicationLinkResourceSpecification() {
        return (EReference) communicationLinkResourceSpecificationEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getCommunicationLinkResourceSpecification_Throughput_CommunicationLinkResourceSpecification() {
        return (EReference) communicationLinkResourceSpecificationEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public ResourceenvironmentFactory getResourceenvironmentFactory() {
        return (ResourceenvironmentFactory) getEFactoryInstance();
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
        resourceEnvironmentEClass = createEClass(RESOURCE_ENVIRONMENT);
        createEReference(resourceEnvironmentEClass, RESOURCE_ENVIRONMENT__LINKING_RESOURCES_RESOURCE_ENVIRONMENT);
        createEReference(resourceEnvironmentEClass, RESOURCE_ENVIRONMENT__RESOURCE_CONTAINER_RESOURCE_ENVIRONMENT);

        linkingResourceEClass = createEClass(LINKING_RESOURCE);
        createEReference(linkingResourceEClass, LINKING_RESOURCE__CONNECTED_RESOURCE_CONTAINERS_LINKING_RESOURCE);
        createEReference(linkingResourceEClass,
                LINKING_RESOURCE__COMMUNICATION_LINK_RESOURCE_SPECIFICATIONS_LINKING_RESOURCE);
        createEReference(linkingResourceEClass, LINKING_RESOURCE__RESOURCE_ENVIRONMENT_LINKING_RESOURCE);

        resourceContainerEClass = createEClass(RESOURCE_CONTAINER);
        createEReference(resourceContainerEClass, RESOURCE_CONTAINER__ACTIVE_RESOURCE_SPECIFICATIONS_RESOURCE_CONTAINER);
        createEReference(resourceContainerEClass, RESOURCE_CONTAINER__RESOURCE_ENVIRONMENT_RESOURCE_CONTAINER);
        createEReference(resourceContainerEClass, RESOURCE_CONTAINER__NESTED_RESOURCE_CONTAINERS_RESOURCE_CONTAINER);
        createEReference(resourceContainerEClass, RESOURCE_CONTAINER__PARENT_RESOURCE_CONTAINER_RESOURCE_CONTAINER);

        processingResourceSpecificationEClass = createEClass(PROCESSING_RESOURCE_SPECIFICATION);
        createEAttribute(processingResourceSpecificationEClass, PROCESSING_RESOURCE_SPECIFICATION__MTTR);
        createEAttribute(processingResourceSpecificationEClass, PROCESSING_RESOURCE_SPECIFICATION__MTTF);
        createEAttribute(processingResourceSpecificationEClass,
                PROCESSING_RESOURCE_SPECIFICATION__REQUIRED_BY_CONTAINER);
        createEReference(processingResourceSpecificationEClass, PROCESSING_RESOURCE_SPECIFICATION__SCHEDULING_POLICY);
        createEReference(processingResourceSpecificationEClass,
                PROCESSING_RESOURCE_SPECIFICATION__ACTIVE_RESOURCE_TYPE_ACTIVE_RESOURCE_SPECIFICATION);
        createEReference(processingResourceSpecificationEClass,
                PROCESSING_RESOURCE_SPECIFICATION__PROCESSING_RATE_PROCESSING_RESOURCE_SPECIFICATION);
        createEAttribute(processingResourceSpecificationEClass, PROCESSING_RESOURCE_SPECIFICATION__NUMBER_OF_REPLICAS);
        createEReference(processingResourceSpecificationEClass,
                PROCESSING_RESOURCE_SPECIFICATION__RESOURCE_CONTAINER_PROCESSING_RESOURCE_SPECIFICATION);

        communicationLinkResourceSpecificationEClass = createEClass(COMMUNICATION_LINK_RESOURCE_SPECIFICATION);
        createEReference(communicationLinkResourceSpecificationEClass,
                COMMUNICATION_LINK_RESOURCE_SPECIFICATION__LINKING_RESOURCE_COMMUNICATION_LINK_RESOURCE_SPECIFICATION);
        createEAttribute(communicationLinkResourceSpecificationEClass,
                COMMUNICATION_LINK_RESOURCE_SPECIFICATION__FAILURE_PROBABILITY);
        createEReference(communicationLinkResourceSpecificationEClass,
                COMMUNICATION_LINK_RESOURCE_SPECIFICATION__COMMUNICATION_LINK_RESOURCE_TYPE_COMMUNICATION_LINK_RESOURCE_SPECIFICATION);
        createEReference(communicationLinkResourceSpecificationEClass,
                COMMUNICATION_LINK_RESOURCE_SPECIFICATION__LATENCY_COMMUNICATION_LINK_RESOURCE_SPECIFICATION);
        createEReference(communicationLinkResourceSpecificationEClass,
                COMMUNICATION_LINK_RESOURCE_SPECIFICATION__THROUGHPUT_COMMUNICATION_LINK_RESOURCE_SPECIFICATION);
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
        IdentifierPackage theIdentifierPackage = (IdentifierPackage) EPackage.Registry.INSTANCE
                .getEPackage(IdentifierPackage.eNS_URI);
        ResourcetypePackage theResourcetypePackage = (ResourcetypePackage) EPackage.Registry.INSTANCE
                .getEPackage(ResourcetypePackage.eNS_URI);
        CorePackage theCorePackage = (CorePackage) EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        resourceEnvironmentEClass.getESuperTypes().add(theEntityPackage.getNamedElement());
        linkingResourceEClass.getESuperTypes().add(theEntityPackage.getEntity());
        resourceContainerEClass.getESuperTypes().add(theEntityPackage.getEntity());
        processingResourceSpecificationEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
        communicationLinkResourceSpecificationEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());

        // Initialize classes and features; add operations and parameters
        initEClass(resourceEnvironmentEClass, ResourceEnvironment.class, "ResourceEnvironment", !IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getResourceEnvironment_LinkingResources__ResourceEnvironment(), this.getLinkingResource(),
                this.getLinkingResource_ResourceEnvironment_LinkingResource(), "linkingResources__ResourceEnvironment",
                null, 0, -1, ResourceEnvironment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getResourceEnvironment_ResourceContainer_ResourceEnvironment(), this.getResourceContainer(),
                this.getResourceContainer_ResourceEnvironment_ResourceContainer(),
                "resourceContainer_ResourceEnvironment", null, 0, -1, ResourceEnvironment.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
                !IS_ORDERED);

        initEClass(linkingResourceEClass, LinkingResource.class, "LinkingResource", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEReference(getLinkingResource_ConnectedResourceContainers_LinkingResource(), this.getResourceContainer(),
                null, "connectedResourceContainers_LinkingResource", null, 0, -1, LinkingResource.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
                !IS_ORDERED);
        initEReference(
                getLinkingResource_CommunicationLinkResourceSpecifications_LinkingResource(),
                this.getCommunicationLinkResourceSpecification(),
                this.getCommunicationLinkResourceSpecification_LinkingResource_CommunicationLinkResourceSpecification(),
                "communicationLinkResourceSpecifications_LinkingResource", null, 1, 1, LinkingResource.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
                IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getLinkingResource_ResourceEnvironment_LinkingResource(), this.getResourceEnvironment(),
                this.getResourceEnvironment_LinkingResources__ResourceEnvironment(),
                "resourceEnvironment_LinkingResource", null, 1, 1, LinkingResource.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(resourceContainerEClass, ResourceContainer.class, "ResourceContainer", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEReference(getResourceContainer_ActiveResourceSpecifications_ResourceContainer(),
                this.getProcessingResourceSpecification(),
                this.getProcessingResourceSpecification_ResourceContainer_ProcessingResourceSpecification(),
                "activeResourceSpecifications_ResourceContainer", null, 0, -1, ResourceContainer.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
                !IS_ORDERED);
        initEReference(getResourceContainer_ResourceEnvironment_ResourceContainer(), this.getResourceEnvironment(),
                this.getResourceEnvironment_ResourceContainer_ResourceEnvironment(),
                "resourceEnvironment_ResourceContainer", null, 0, 1, ResourceContainer.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
                !IS_DERIVED, !IS_ORDERED);
        initEReference(getResourceContainer_NestedResourceContainers__ResourceContainer(), this.getResourceContainer(),
                this.getResourceContainer_ParentResourceContainer__ResourceContainer(),
                "nestedResourceContainers__ResourceContainer", null, 0, -1, ResourceContainer.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
                !IS_ORDERED);
        initEReference(getResourceContainer_ParentResourceContainer__ResourceContainer(), this.getResourceContainer(),
                this.getResourceContainer_NestedResourceContainers__ResourceContainer(),
                "parentResourceContainer__ResourceContainer", null, 0, 1, ResourceContainer.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE,
                !IS_DERIVED, !IS_ORDERED);

        initEClass(processingResourceSpecificationEClass, ProcessingResourceSpecification.class,
                "ProcessingResourceSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getProcessingResourceSpecification_MTTR(), ecorePackage.getEDouble(), "MTTR", "0.0", 1, 1,
                ProcessingResourceSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
                !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getProcessingResourceSpecification_MTTF(), ecorePackage.getEDouble(), "MTTF", "0.0", 1, 1,
                ProcessingResourceSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
                !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getProcessingResourceSpecification_RequiredByContainer(), ecorePackage.getEBoolean(),
                "requiredByContainer", null, 1, 1, ProcessingResourceSpecification.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getProcessingResourceSpecification_SchedulingPolicy(),
                theResourcetypePackage.getSchedulingPolicy(), null, "schedulingPolicy", null, 1, 1,
                ProcessingResourceSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getProcessingResourceSpecification_ActiveResourceType_ActiveResourceSpecification(),
                theResourcetypePackage.getProcessingResourceType(), null,
                "activeResourceType_ActiveResourceSpecification", null, 1, 1, ProcessingResourceSpecification.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
                IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getProcessingResourceSpecification_ProcessingRate_ProcessingResourceSpecification(),
                theCorePackage.getPCMRandomVariable(),
                theCorePackage.getPCMRandomVariable_ProcessingResourceSpecification_processingRate_PCMRandomVariable(),
                "processingRate_ProcessingResourceSpecification", null, 1, 1, ProcessingResourceSpecification.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
                IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getProcessingResourceSpecification_NumberOfReplicas(), ecorePackage.getEInt(),
                "numberOfReplicas", "1", 1, 1, ProcessingResourceSpecification.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getProcessingResourceSpecification_ResourceContainer_ProcessingResourceSpecification(),
                this.getResourceContainer(),
                this.getResourceContainer_ActiveResourceSpecifications_ResourceContainer(),
                "resourceContainer_ProcessingResourceSpecification", null, 1, 1, ProcessingResourceSpecification.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
                IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(communicationLinkResourceSpecificationEClass, CommunicationLinkResourceSpecification.class,
                "CommunicationLinkResourceSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(
                getCommunicationLinkResourceSpecification_LinkingResource_CommunicationLinkResourceSpecification(),
                this.getLinkingResource(),
                this.getLinkingResource_CommunicationLinkResourceSpecifications_LinkingResource(),
                "linkingResource_CommunicationLinkResourceSpecification", null, 1, 1,
                CommunicationLinkResourceSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getCommunicationLinkResourceSpecification_FailureProbability(), ecorePackage.getEDouble(),
                "failureProbability", "0.0", 1, 1, CommunicationLinkResourceSpecification.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(
                getCommunicationLinkResourceSpecification_CommunicationLinkResourceType_CommunicationLinkResourceSpecification(),
                theResourcetypePackage.getCommunicationLinkResourceType(), null,
                "communicationLinkResourceType_CommunicationLinkResourceSpecification", null, 1, 1,
                CommunicationLinkResourceSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getCommunicationLinkResourceSpecification_Latency_CommunicationLinkResourceSpecification(),
                theCorePackage.getPCMRandomVariable(),
                theCorePackage.getPCMRandomVariable_CommunicationLinkResourceSpecification_latency_PCMRandomVariable(),
                "latency_CommunicationLinkResourceSpecification", null, 1, 1,
                CommunicationLinkResourceSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getCommunicationLinkResourceSpecification_Throughput_CommunicationLinkResourceSpecification(),
                theCorePackage.getPCMRandomVariable(),
                theCorePackage
                        .getPCMRandomVariable_CommunicationLinkResourceSpecifcation_throughput_PCMRandomVariable(),
                "throughput_CommunicationLinkResourceSpecification", null, 1, 1,
                CommunicationLinkResourceSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
    }

} // ResourceenvironmentPackageImpl
