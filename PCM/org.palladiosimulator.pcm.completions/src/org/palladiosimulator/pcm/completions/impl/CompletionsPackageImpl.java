/**
 * Copyright SDQ, IPD, U Karlsruhe, 2007
 */
package org.palladiosimulator.pcm.completions.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.palladiosimulator.pcm.completions.Completion;
import org.palladiosimulator.pcm.completions.CompletionRepository;
import org.palladiosimulator.pcm.completions.CompletionsFactory;
import org.palladiosimulator.pcm.completions.CompletionsPackage;
import org.palladiosimulator.pcm.completions.DelegatingExternalCallAction;
import org.palladiosimulator.pcm.completions.NetworkDemandParametricResourceDemand;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class CompletionsPackageImpl extends EPackageImpl implements CompletionsPackage {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass completionEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass completionRepositoryEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass delegatingExternalCallActionEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass networkDemandParametricResourceDemandEClass = null;

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
     * @see org.palladiosimulator.pcm.completions.CompletionsPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private CompletionsPackageImpl() {
        super(eNS_URI, CompletionsFactory.eINSTANCE);
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
     * This method is used to initialize {@link CompletionsPackage#eINSTANCE} when that field is
     * accessed. Clients should not invoke it directly. Instead, they should simply access that
     * field to obtain the package. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static CompletionsPackage init() {
        if (isInited) {
            return (CompletionsPackage) EPackage.Registry.INSTANCE.getEPackage(CompletionsPackage.eNS_URI);
        }

        // Obtain or create and register package
        final CompletionsPackageImpl theCompletionsPackage = (CompletionsPackageImpl) (EPackage.Registry.INSTANCE
                .get(eNS_URI) instanceof CompletionsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI)
                        : new CompletionsPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        de.uka.ipd.sdq.pcm.PcmPackage.eINSTANCE.eClass();

        // Create package meta-data objects
        theCompletionsPackage.createPackageContents();

        // Initialize created meta-data
        theCompletionsPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theCompletionsPackage.freeze();

        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(CompletionsPackage.eNS_URI, theCompletionsPackage);
        return theCompletionsPackage;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getCompletion() {
        return this.completionEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getCompletionRepository() {
        return this.completionRepositoryEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getCompletionRepository_Completions_CompletionRepository() {
        return (EReference) this.completionRepositoryEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getDelegatingExternalCallAction() {
        return this.delegatingExternalCallActionEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EClass getNetworkDemandParametricResourceDemand() {
        return this.networkDemandParametricResourceDemandEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public EReference getNetworkDemandParametricResourceDemand_RequiredCommunicationLinkResource_ParametricResourceDemand() {
        return (EReference) this.networkDemandParametricResourceDemandEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    @Override
    public CompletionsFactory getCompletionsFactory() {
        return (CompletionsFactory) this.getEFactoryInstance();
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
        this.completionEClass = this.createEClass(COMPLETION);

        this.completionRepositoryEClass = this.createEClass(COMPLETION_REPOSITORY);
        this.createEReference(this.completionRepositoryEClass,
                COMPLETION_REPOSITORY__COMPLETIONS_COMPLETION_REPOSITORY);

        this.delegatingExternalCallActionEClass = this.createEClass(DELEGATING_EXTERNAL_CALL_ACTION);

        this.networkDemandParametricResourceDemandEClass = this.createEClass(NETWORK_DEMAND_PARAMETRIC_RESOURCE_DEMAND);
        this.createEReference(this.networkDemandParametricResourceDemandEClass,
                NETWORK_DEMAND_PARAMETRIC_RESOURCE_DEMAND__REQUIRED_COMMUNICATION_LINK_RESOURCE_PARAMETRIC_RESOURCE_DEMAND);
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
        final org.palladiosimulator.pcm.core.entity.EntityPackage theEntityPackage = (org.palladiosimulator.pcm.core.entity.EntityPackage) EPackage.Registry.INSTANCE
                .getEPackage(org.palladiosimulator.pcm.core.entity.EntityPackage.eNS_URI);
        final org.palladiosimulator.pcm.repository.RepositoryPackage theRepositoryPackage = (org.palladiosimulator.pcm.repository.RepositoryPackage) EPackage.Registry.INSTANCE
                .getEPackage(org.palladiosimulator.pcm.repository.RepositoryPackage.eNS_URI);
        final org.palladiosimulator.pcm.seff.SeffPackage theSeffPackage = (org.palladiosimulator.pcm.seff.SeffPackage) EPackage.Registry.INSTANCE
                .getEPackage(org.palladiosimulator.pcm.seff.SeffPackage.eNS_URI);
        final org.palladiosimulator.pcm.seff.seff_performance.SeffPerformancePackage theSeffPerformancePackage = (org.palladiosimulator.pcm.seff.seff_performance.SeffPerformancePackage) EPackage.Registry.INSTANCE
                .getEPackage(org.palladiosimulator.pcm.seff.seff_performance.SeffPerformancePackage.eNS_URI);
        final org.palladiosimulator.pcm.resourcetype.ResourcetypePackage theResourcetypePackage = (org.palladiosimulator.pcm.resourcetype.ResourcetypePackage) EPackage.Registry.INSTANCE
                .getEPackage(org.palladiosimulator.pcm.resourcetype.ResourcetypePackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        this.completionEClass.getESuperTypes().add(theEntityPackage.getComposedProvidingRequiringEntity());
        this.completionEClass.getESuperTypes().add(theRepositoryPackage.getImplementationComponentType());
        this.delegatingExternalCallActionEClass.getESuperTypes().add(theSeffPackage.getExternalCallAction());
        this.networkDemandParametricResourceDemandEClass.getESuperTypes()
                .add(theSeffPerformancePackage.getParametricResourceDemand());

        // Initialize classes and features; add operations and parameters
        this.initEClass(this.completionEClass, Completion.class, "Completion", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);

        this.initEClass(this.completionRepositoryEClass, CompletionRepository.class, "CompletionRepository",
                !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getCompletionRepository_Completions_CompletionRepository(), this.getCompletion(), null,
                "completions_CompletionRepository", null, 0, -1, CompletionRepository.class, !IS_TRANSIENT,
                !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
                !IS_ORDERED);

        this.initEClass(this.delegatingExternalCallActionEClass, DelegatingExternalCallAction.class,
                "DelegatingExternalCallAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        this.initEClass(this.networkDemandParametricResourceDemandEClass, NetworkDemandParametricResourceDemand.class,
                "NetworkDemandParametricResourceDemand", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(
                this.getNetworkDemandParametricResourceDemand_RequiredCommunicationLinkResource_ParametricResourceDemand(),
                theResourcetypePackage.getCommunicationLinkResourceType(), null,
                "requiredCommunicationLinkResource_ParametricResourceDemand", null, 1, 1,
                NetworkDemandParametricResourceDemand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        // Create resource
        this.createResource(eNS_URI);
    }

} // CompletionsPackageImpl
