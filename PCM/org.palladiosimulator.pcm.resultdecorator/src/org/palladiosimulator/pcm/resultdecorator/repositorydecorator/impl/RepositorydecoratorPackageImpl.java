/**
 */
package org.palladiosimulator.pcm.resultdecorator.repositorydecorator.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.palladiosimulator.pcm.resultdecorator.ResultdecoratorPackage;
import org.palladiosimulator.pcm.resultdecorator.impl.ResultdecoratorPackageImpl;
import org.palladiosimulator.pcm.resultdecorator.repositorydecorator.AllocationContextResults;
import org.palladiosimulator.pcm.resultdecorator.repositorydecorator.AllocationServiceResult;
import org.palladiosimulator.pcm.resultdecorator.repositorydecorator.ComponentResult;
import org.palladiosimulator.pcm.resultdecorator.repositorydecorator.InterfaceProvidingRequiringEntityResults;
import org.palladiosimulator.pcm.resultdecorator.repositorydecorator.RepositorydecoratorFactory;
import org.palladiosimulator.pcm.resultdecorator.repositorydecorator.RepositorydecoratorPackage;
import org.palladiosimulator.pcm.resultdecorator.repositorydecorator.ServiceResult;
import org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ResourceenvironmentdecoratorPackage;
import org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.impl.ResourceenvironmentdecoratorPackageImpl;

import de.uka.ipd.sdq.pcm.PcmPackage;
import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;
import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 *
 * @generated
 */
public class RepositorydecoratorPackageImpl extends EPackageImpl implements RepositorydecoratorPackage {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass interfaceProvidingRequiringEntityResultsEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass componentResultEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass allocationContextResultsEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass serviceResultEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass allocationServiceResultEClass = null;

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
     * @see org.palladiosimulator.pcm.resultdecorator.repositorydecorator.RepositorydecoratorPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private RepositorydecoratorPackageImpl() {
        super(eNS_URI, RepositorydecoratorFactory.eINSTANCE);
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
     * This method is used to initialize {@link RepositorydecoratorPackage#eINSTANCE} when that
     * field is accessed. Clients should not invoke it directly. Instead, they should simply access
     * that field to obtain the package. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static RepositorydecoratorPackage init() {
        if (isInited) {
            return (RepositorydecoratorPackage) EPackage.Registry.INSTANCE
                    .getEPackage(RepositorydecoratorPackage.eNS_URI);
        }

        // Obtain or create and register package
        final RepositorydecoratorPackageImpl theRepositorydecoratorPackage = (RepositorydecoratorPackageImpl) (EPackage.Registry.INSTANCE
                .get(eNS_URI) instanceof RepositorydecoratorPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI)
                        : new RepositorydecoratorPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        PcmPackage.eINSTANCE.eClass();

        // Obtain or create and register interdependencies
        final ResultdecoratorPackageImpl theResultdecoratorPackage = (ResultdecoratorPackageImpl) (EPackage.Registry.INSTANCE
                .getEPackage(ResultdecoratorPackage.eNS_URI) instanceof ResultdecoratorPackageImpl
                        ? EPackage.Registry.INSTANCE.getEPackage(ResultdecoratorPackage.eNS_URI)
                        : ResultdecoratorPackage.eINSTANCE);
        final ResourceenvironmentdecoratorPackageImpl theResourceenvironmentdecoratorPackage = (ResourceenvironmentdecoratorPackageImpl) (EPackage.Registry.INSTANCE
                .getEPackage(
                        ResourceenvironmentdecoratorPackage.eNS_URI) instanceof ResourceenvironmentdecoratorPackageImpl
                                ? EPackage.Registry.INSTANCE.getEPackage(ResourceenvironmentdecoratorPackage.eNS_URI)
                                : ResourceenvironmentdecoratorPackage.eINSTANCE);

        // Create package meta-data objects
        theRepositorydecoratorPackage.createPackageContents();
        theResultdecoratorPackage.createPackageContents();
        theResourceenvironmentdecoratorPackage.createPackageContents();

        // Initialize created meta-data
        theRepositorydecoratorPackage.initializePackageContents();
        theResultdecoratorPackage.initializePackageContents();
        theResourceenvironmentdecoratorPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theRepositorydecoratorPackage.freeze();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(RepositorydecoratorPackage.eNS_URI, theRepositorydecoratorPackage);
        return theRepositorydecoratorPackage;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getInterfaceProvidingRequiringEntityResults() {
        return this.interfaceProvidingRequiringEntityResultsEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getInterfaceProvidingRequiringEntityResults_InterfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult() {
        return (EReference) this.interfaceProvidingRequiringEntityResultsEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getComponentResult() {
        return this.componentResultEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getComponentResult_NormalisedResourceDemand() {
        return (EAttribute) this.componentResultEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getComponentResult_NormalisedResponseTime() {
        return (EAttribute) this.componentResultEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getComponentResult_AverageResourceDemand() {
        return (EAttribute) this.componentResultEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getComponentResult_MeanResponseTime() {
        return (EAttribute) this.componentResultEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getComponentResult_AverageNumberOfSentMessages() {
        return (EAttribute) this.componentResultEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getAllocationContextResults() {
        return this.allocationContextResultsEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getAllocationContextResults_AllocationContext_AllocationContextResult() {
        return (EReference) this.allocationContextResultsEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getServiceResult() {
        return this.serviceResultEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getServiceResult_MeanResponseTime() {
        return (EAttribute) this.serviceResultEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getServiceResult_Throughput() {
        return (EAttribute) this.serviceResultEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getServiceResult_ServiceEffectSpecification_ServiceResult() {
        return (EReference) this.serviceResultEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getAllocationServiceResult() {
        return this.allocationServiceResultEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getAllocationServiceResult_AllocationContext_AllocationServiceResult() {
        return (EReference) this.allocationServiceResultEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public RepositorydecoratorFactory getRepositorydecoratorFactory() {
        return (RepositorydecoratorFactory) this.getEFactoryInstance();
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
        if (this.isCreated) {
            return;
        }
        this.isCreated = true;

        // Create classes and their features
        this.interfaceProvidingRequiringEntityResultsEClass = this
                .createEClass(INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS);
        this.createEReference(this.interfaceProvidingRequiringEntityResultsEClass,
                INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS__INTERFACE_PROVIDING_REQUIRING_ENTITY_INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULT);

        this.componentResultEClass = this.createEClass(COMPONENT_RESULT);
        this.createEAttribute(this.componentResultEClass, COMPONENT_RESULT__NORMALISED_RESOURCE_DEMAND);
        this.createEAttribute(this.componentResultEClass, COMPONENT_RESULT__NORMALISED_RESPONSE_TIME);
        this.createEAttribute(this.componentResultEClass, COMPONENT_RESULT__AVERAGE_RESOURCE_DEMAND);
        this.createEAttribute(this.componentResultEClass, COMPONENT_RESULT__MEAN_RESPONSE_TIME);
        this.createEAttribute(this.componentResultEClass, COMPONENT_RESULT__AVERAGE_NUMBER_OF_SENT_MESSAGES);

        this.allocationContextResultsEClass = this.createEClass(ALLOCATION_CONTEXT_RESULTS);
        this.createEReference(this.allocationContextResultsEClass,
                ALLOCATION_CONTEXT_RESULTS__ALLOCATION_CONTEXT_ALLOCATION_CONTEXT_RESULT);

        this.serviceResultEClass = this.createEClass(SERVICE_RESULT);
        this.createEAttribute(this.serviceResultEClass, SERVICE_RESULT__MEAN_RESPONSE_TIME);
        this.createEAttribute(this.serviceResultEClass, SERVICE_RESULT__THROUGHPUT);
        this.createEReference(this.serviceResultEClass, SERVICE_RESULT__SERVICE_EFFECT_SPECIFICATION_SERVICE_RESULT);

        this.allocationServiceResultEClass = this.createEClass(ALLOCATION_SERVICE_RESULT);
        this.createEReference(this.allocationServiceResultEClass,
                ALLOCATION_SERVICE_RESULT__ALLOCATION_CONTEXT_ALLOCATION_SERVICE_RESULT);
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
        if (this.isInitialized) {
            return;
        }
        this.isInitialized = true;

        // Initialize package
        this.setName(eNAME);
        this.setNsPrefix(eNS_PREFIX);
        this.setNsURI(eNS_URI);

        // Obtain other dependent packages
        final EntityPackage theEntityPackage = (EntityPackage) EPackage.Registry.INSTANCE
                .getEPackage(EntityPackage.eNS_URI);
        final AllocationPackage theAllocationPackage = (AllocationPackage) EPackage.Registry.INSTANCE
                .getEPackage(AllocationPackage.eNS_URI);
        final SeffPackage theSeffPackage = (SeffPackage) EPackage.Registry.INSTANCE.getEPackage(SeffPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        this.interfaceProvidingRequiringEntityResultsEClass.getESuperTypes().add(this.getComponentResult());
        this.componentResultEClass.getESuperTypes().add(theEntityPackage.getNamedElement());
        this.allocationContextResultsEClass.getESuperTypes().add(this.getComponentResult());
        this.allocationServiceResultEClass.getESuperTypes().add(this.getServiceResult());

        // Initialize classes and features; add operations and parameters
        this.initEClass(this.interfaceProvidingRequiringEntityResultsEClass,
                InterfaceProvidingRequiringEntityResults.class, "InterfaceProvidingRequiringEntityResults",
                !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(
                this.getInterfaceProvidingRequiringEntityResults_InterfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult(),
                theEntityPackage.getInterfaceProvidingRequiringEntity(), null,
                "interfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult", null, 0, 1,
                InterfaceProvidingRequiringEntityResults.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        this.initEClass(this.componentResultEClass, ComponentResult.class, "ComponentResult", IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEAttribute(this.getComponentResult_NormalisedResourceDemand(), this.ecorePackage.getEDouble(),
                "normalisedResourceDemand", null, 1, 1, ComponentResult.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEAttribute(this.getComponentResult_NormalisedResponseTime(), this.ecorePackage.getEDouble(),
                "normalisedResponseTime", null, 1, 1, ComponentResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEAttribute(this.getComponentResult_AverageResourceDemand(), this.ecorePackage.getEDouble(),
                "averageResourceDemand", null, 1, 1, ComponentResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEAttribute(this.getComponentResult_MeanResponseTime(), this.ecorePackage.getEDouble(),
                "meanResponseTime", null, 1, 1, ComponentResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEAttribute(this.getComponentResult_AverageNumberOfSentMessages(), this.ecorePackage.getEDouble(),
                "averageNumberOfSentMessages", null, 1, 1, ComponentResult.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        this.initEClass(this.allocationContextResultsEClass, AllocationContextResults.class, "AllocationContextResults",
                !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getAllocationContextResults_AllocationContext_AllocationContextResult(),
                theAllocationPackage.getAllocationContext(), null, "allocationContext_AllocationContextResult", null, 0,
                1, AllocationContextResults.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        this.initEClass(this.serviceResultEClass, ServiceResult.class, "ServiceResult", IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        this.initEAttribute(this.getServiceResult_MeanResponseTime(), this.ecorePackage.getEDouble(),
                "meanResponseTime", null, 1, 1, ServiceResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEAttribute(this.getServiceResult_Throughput(), this.ecorePackage.getEDouble(), "throughput", null, 1,
                1, ServiceResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getServiceResult_ServiceEffectSpecification_ServiceResult(),
                theSeffPackage.getServiceEffectSpecification(), null, "serviceEffectSpecification_ServiceResult", null,
                1, 1, ServiceResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        this.initEClass(this.allocationServiceResultEClass, AllocationServiceResult.class, "AllocationServiceResult",
                !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getAllocationServiceResult_AllocationContext_AllocationServiceResult(),
                theAllocationPackage.getAllocationContext(), null, "allocationContext_AllocationServiceResult", null, 1,
                1, AllocationServiceResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
    }

} // RepositorydecoratorPackageImpl
