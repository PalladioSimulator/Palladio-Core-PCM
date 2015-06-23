/**
 */
package org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.palladiosimulator.pcm.resultdecorator.ResultdecoratorPackage;
import org.palladiosimulator.pcm.resultdecorator.impl.ResultdecoratorPackageImpl;
import org.palladiosimulator.pcm.resultdecorator.repositorydecorator.RepositorydecoratorPackage;
import org.palladiosimulator.pcm.resultdecorator.repositorydecorator.impl.RepositorydecoratorPackageImpl;
import org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ActiveResourceUtilisationResult;
import org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.LinkingResourceResults;
import org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.PassiveResourceResult;
import org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ProcessingResourceSpecificationResult;
import org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ResourceContainerResults;
import org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ResourceenvironmentdecoratorFactory;
import org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ResourceenvironmentdecoratorPackage;
import org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult;

import org.palladiosimulator.pcm.PcmPackage;
import org.palladiosimulator.pcm.core.composition.CompositionPackage;
import org.palladiosimulator.pcm.core.entity.EntityPackage;
import org.palladiosimulator.pcm.repository.RepositoryPackage;
import org.palladiosimulator.pcm.resourceenvironment.ResourceenvironmentPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 *
 * @generated
 */
public class ResourceenvironmentdecoratorPackageImpl extends EPackageImpl
        implements ResourceenvironmentdecoratorPackage {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass linkingResourceResultsEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass activeResourceUtilisationResultEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass utilisationResultEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass resourceContainerResultsEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass processingResourceSpecificationResultEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass passiveResourceResultEClass = null;

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
     * @see org.palladiosimulator.pcm.resultdecorator.resourceenvironmentdecorator.ResourceenvironmentdecoratorPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private ResourceenvironmentdecoratorPackageImpl() {
        super(eNS_URI, ResourceenvironmentdecoratorFactory.eINSTANCE);
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
     * This method is used to initialize {@link ResourceenvironmentdecoratorPackage#eINSTANCE} when
     * that field is accessed. Clients should not invoke it directly. Instead, they should simply
     * access that field to obtain the package. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static ResourceenvironmentdecoratorPackage init() {
        if (isInited) {
            return (ResourceenvironmentdecoratorPackage) EPackage.Registry.INSTANCE
                    .getEPackage(ResourceenvironmentdecoratorPackage.eNS_URI);
        }

        // Obtain or create and register package
        final ResourceenvironmentdecoratorPackageImpl theResourceenvironmentdecoratorPackage = (ResourceenvironmentdecoratorPackageImpl) (EPackage.Registry.INSTANCE
                .get(eNS_URI) instanceof ResourceenvironmentdecoratorPackageImpl
                        ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ResourceenvironmentdecoratorPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        PcmPackage.eINSTANCE.eClass();

        // Obtain or create and register interdependencies
        final ResultdecoratorPackageImpl theResultdecoratorPackage = (ResultdecoratorPackageImpl) (EPackage.Registry.INSTANCE
                .getEPackage(ResultdecoratorPackage.eNS_URI) instanceof ResultdecoratorPackageImpl
                        ? EPackage.Registry.INSTANCE.getEPackage(ResultdecoratorPackage.eNS_URI)
                        : ResultdecoratorPackage.eINSTANCE);
        final RepositorydecoratorPackageImpl theRepositorydecoratorPackage = (RepositorydecoratorPackageImpl) (EPackage.Registry.INSTANCE
                .getEPackage(RepositorydecoratorPackage.eNS_URI) instanceof RepositorydecoratorPackageImpl
                        ? EPackage.Registry.INSTANCE.getEPackage(RepositorydecoratorPackage.eNS_URI)
                        : RepositorydecoratorPackage.eINSTANCE);

        // Create package meta-data objects
        theResourceenvironmentdecoratorPackage.createPackageContents();
        theResultdecoratorPackage.createPackageContents();
        theRepositorydecoratorPackage.createPackageContents();

        // Initialize created meta-data
        theResourceenvironmentdecoratorPackage.initializePackageContents();
        theResultdecoratorPackage.initializePackageContents();
        theRepositorydecoratorPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theResourceenvironmentdecoratorPackage.freeze();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(ResourceenvironmentdecoratorPackage.eNS_URI,
                theResourceenvironmentdecoratorPackage);
        return theResourceenvironmentdecoratorPackage;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getLinkingResourceResults() {
        return this.linkingResourceResultsEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getLinkingResourceResults_LinkingResource_LinkingResourceResults() {
        return (EReference) this.linkingResourceResultsEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getActiveResourceUtilisationResult() {
        return this.activeResourceUtilisationResultEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getActiveResourceUtilisationResult_NormalisedDemandedTime() {
        return (EAttribute) this.activeResourceUtilisationResultEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getActiveResourceUtilisationResult_DemandedTime() {
        return (EAttribute) this.activeResourceUtilisationResultEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getUtilisationResult() {
        return this.utilisationResultEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getUtilisationResult_NormalisedResourceUtilisation() {
        return (EAttribute) this.utilisationResultEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getUtilisationResult_NormalisedWaitTime() {
        return (EAttribute) this.utilisationResultEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getUtilisationResult_ResourceUtilisation() {
        return (EAttribute) this.utilisationResultEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getUtilisationResult_AverageWaitTime() {
        return (EAttribute) this.utilisationResultEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getUtilisationResult_AverageQueueLength() {
        return (EAttribute) this.utilisationResultEClass.getEStructuralFeatures().get(4);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getUtilisationResult_MaxQueueLength() {
        return (EAttribute) this.utilisationResultEClass.getEStructuralFeatures().get(5);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getResourceContainerResults() {
        return this.resourceContainerResultsEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getResourceContainerResults_ResourceContainer_ResourceContainerResults() {
        return (EReference) this.resourceContainerResultsEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getProcessingResourceSpecificationResult() {
        return this.processingResourceSpecificationResultEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getProcessingResourceSpecificationResult_ProcessingResourceSpecification_ProcessingResourceSpecificationResult() {
        return (EReference) this.processingResourceSpecificationResultEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getPassiveResourceResult() {
        return this.passiveResourceResultEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getPassiveResourceResult_PassiveResource_PassiveResourceResult() {
        return (EReference) this.passiveResourceResultEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getPassiveResourceResult_AssemblyContext_PassiveResourceResult() {
        return (EReference) this.passiveResourceResultEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getPassiveResourceResult_AverageHoldingTime() {
        return (EAttribute) this.passiveResourceResultEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public ResourceenvironmentdecoratorFactory getResourceenvironmentdecoratorFactory() {
        return (ResourceenvironmentdecoratorFactory) this.getEFactoryInstance();
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
        this.linkingResourceResultsEClass = this.createEClass(LINKING_RESOURCE_RESULTS);
        this.createEReference(this.linkingResourceResultsEClass,
                LINKING_RESOURCE_RESULTS__LINKING_RESOURCE_LINKING_RESOURCE_RESULTS);

        this.activeResourceUtilisationResultEClass = this.createEClass(ACTIVE_RESOURCE_UTILISATION_RESULT);
        this.createEAttribute(this.activeResourceUtilisationResultEClass,
                ACTIVE_RESOURCE_UTILISATION_RESULT__NORMALISED_DEMANDED_TIME);
        this.createEAttribute(this.activeResourceUtilisationResultEClass,
                ACTIVE_RESOURCE_UTILISATION_RESULT__DEMANDED_TIME);

        this.utilisationResultEClass = this.createEClass(UTILISATION_RESULT);
        this.createEAttribute(this.utilisationResultEClass, UTILISATION_RESULT__NORMALISED_RESOURCE_UTILISATION);
        this.createEAttribute(this.utilisationResultEClass, UTILISATION_RESULT__NORMALISED_WAIT_TIME);
        this.createEAttribute(this.utilisationResultEClass, UTILISATION_RESULT__RESOURCE_UTILISATION);
        this.createEAttribute(this.utilisationResultEClass, UTILISATION_RESULT__AVERAGE_WAIT_TIME);
        this.createEAttribute(this.utilisationResultEClass, UTILISATION_RESULT__AVERAGE_QUEUE_LENGTH);
        this.createEAttribute(this.utilisationResultEClass, UTILISATION_RESULT__MAX_QUEUE_LENGTH);

        this.resourceContainerResultsEClass = this.createEClass(RESOURCE_CONTAINER_RESULTS);
        this.createEReference(this.resourceContainerResultsEClass,
                RESOURCE_CONTAINER_RESULTS__RESOURCE_CONTAINER_RESOURCE_CONTAINER_RESULTS);

        this.processingResourceSpecificationResultEClass = this.createEClass(PROCESSING_RESOURCE_SPECIFICATION_RESULT);
        this.createEReference(this.processingResourceSpecificationResultEClass,
                PROCESSING_RESOURCE_SPECIFICATION_RESULT__PROCESSING_RESOURCE_SPECIFICATION_PROCESSING_RESOURCE_SPECIFICATION_RESULT);

        this.passiveResourceResultEClass = this.createEClass(PASSIVE_RESOURCE_RESULT);
        this.createEReference(this.passiveResourceResultEClass,
                PASSIVE_RESOURCE_RESULT__PASSIVE_RESOURCE_PASSIVE_RESOURCE_RESULT);
        this.createEReference(this.passiveResourceResultEClass,
                PASSIVE_RESOURCE_RESULT__ASSEMBLY_CONTEXT_PASSIVE_RESOURCE_RESULT);
        this.createEAttribute(this.passiveResourceResultEClass, PASSIVE_RESOURCE_RESULT__AVERAGE_HOLDING_TIME);
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
        final ResourceenvironmentPackage theResourceenvironmentPackage = (ResourceenvironmentPackage) EPackage.Registry.INSTANCE
                .getEPackage(ResourceenvironmentPackage.eNS_URI);
        final EntityPackage theEntityPackage = (EntityPackage) EPackage.Registry.INSTANCE
                .getEPackage(EntityPackage.eNS_URI);
        final RepositoryPackage theRepositoryPackage = (RepositoryPackage) EPackage.Registry.INSTANCE
                .getEPackage(RepositoryPackage.eNS_URI);
        final CompositionPackage theCompositionPackage = (CompositionPackage) EPackage.Registry.INSTANCE
                .getEPackage(CompositionPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        this.linkingResourceResultsEClass.getESuperTypes().add(this.getActiveResourceUtilisationResult());
        this.activeResourceUtilisationResultEClass.getESuperTypes().add(this.getUtilisationResult());
        this.utilisationResultEClass.getESuperTypes().add(theEntityPackage.getNamedElement());
        this.resourceContainerResultsEClass.getESuperTypes().add(this.getActiveResourceUtilisationResult());
        this.processingResourceSpecificationResultEClass.getESuperTypes()
                .add(this.getActiveResourceUtilisationResult());
        this.passiveResourceResultEClass.getESuperTypes().add(this.getUtilisationResult());

        // Initialize classes and features; add operations and parameters
        this.initEClass(this.linkingResourceResultsEClass, LinkingResourceResults.class, "LinkingResourceResults",
                !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getLinkingResourceResults_LinkingResource_LinkingResourceResults(),
                theResourceenvironmentPackage.getLinkingResource(), null, "linkingResource_LinkingResourceResults",
                null, 0, 1, LinkingResourceResults.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        this.initEClass(this.activeResourceUtilisationResultEClass, ActiveResourceUtilisationResult.class,
                "ActiveResourceUtilisationResult", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEAttribute(this.getActiveResourceUtilisationResult_NormalisedDemandedTime(),
                this.ecorePackage.getEDouble(), "normalisedDemandedTime", null, 1, 1,
                ActiveResourceUtilisationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
                !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEAttribute(this.getActiveResourceUtilisationResult_DemandedTime(), this.ecorePackage.getEDouble(),
                "demandedTime", "0", 1, 1, ActiveResourceUtilisationResult.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        this.initEClass(this.utilisationResultEClass, UtilisationResult.class, "UtilisationResult", IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEAttribute(this.getUtilisationResult_NormalisedResourceUtilisation(), this.ecorePackage.getEDouble(),
                "normalisedResourceUtilisation", null, 1, 1, UtilisationResult.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEAttribute(this.getUtilisationResult_NormalisedWaitTime(), this.ecorePackage.getEDouble(),
                "normalisedWaitTime", null, 1, 1, UtilisationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEAttribute(this.getUtilisationResult_ResourceUtilisation(), this.ecorePackage.getEDouble(),
                "resourceUtilisation", "0", 1, 1, UtilisationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEAttribute(this.getUtilisationResult_AverageWaitTime(), this.ecorePackage.getEDouble(),
                "averageWaitTime", "0", 1, 1, UtilisationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEAttribute(this.getUtilisationResult_AverageQueueLength(), this.ecorePackage.getEDouble(),
                "averageQueueLength", "0", 1, 1, UtilisationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEAttribute(this.getUtilisationResult_MaxQueueLength(), this.ecorePackage.getEInt(), "maxQueueLength",
                "0", 1, 1, UtilisationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        this.initEClass(this.resourceContainerResultsEClass, ResourceContainerResults.class, "ResourceContainerResults",
                !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getResourceContainerResults_ResourceContainer_ResourceContainerResults(),
                theResourceenvironmentPackage.getResourceContainer(), null,
                "resourceContainer_ResourceContainerResults", null, 0, 1, ResourceContainerResults.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
                !IS_ORDERED);

        this.initEClass(this.processingResourceSpecificationResultEClass, ProcessingResourceSpecificationResult.class,
                "ProcessingResourceSpecificationResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(
                this.getProcessingResourceSpecificationResult_ProcessingResourceSpecification_ProcessingResourceSpecificationResult(),
                theResourceenvironmentPackage.getProcessingResourceSpecification(), null,
                "processingResourceSpecification_ProcessingResourceSpecificationResult", null, 0, 1,
                ProcessingResourceSpecificationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        this.initEClass(this.passiveResourceResultEClass, PassiveResourceResult.class, "PassiveResourceResult",
                !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getPassiveResourceResult_PassiveResource_PassiveResourceResult(),
                theRepositoryPackage.getPassiveResource(), null, "passiveResource_PassiveResourceResult", null, 1, 1,
                PassiveResourceResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEReference(this.getPassiveResourceResult_AssemblyContext_PassiveResourceResult(),
                theCompositionPackage.getAssemblyContext(), null, "assemblyContext_PassiveResourceResult", null, 0, 1,
                PassiveResourceResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        this.initEAttribute(this.getPassiveResourceResult_AverageHoldingTime(), this.ecorePackage.getEDouble(),
                "averageHoldingTime", null, 1, 1, PassiveResourceResult.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
    }

} // ResourceenvironmentdecoratorPackageImpl
