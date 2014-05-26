/**
 */
package org.palladiosimulator.pcmmeasuringpoint.impl;

import de.uka.ipd.sdq.pcm.PcmPackage;

import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;

import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;

import de.uka.ipd.sdq.pcm.subsystem.SubsystemPackage;

import de.uka.ipd.sdq.pcm.system.SystemPackage;

import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.palladiosimulator.edp2.models.ExperimentData.ExperimentDataPackage;

import org.palladiosimulator.edp2.models.Repository.RepositoryPackage;

import org.palladiosimulator.edp2.models.measuringpoint.MeasuringpointPackage;

import org.palladiosimulator.pcmmeasuringpoint.ActiveResourceMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.ActiveResourceReference;
import org.palladiosimulator.pcmmeasuringpoint.AssemblyOperationMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.AssemblyPassiveResourceMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.AssemblyReference;
import org.palladiosimulator.pcmmeasuringpoint.LinkingResourceMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.LinkingResourceReference;
import org.palladiosimulator.pcmmeasuringpoint.OperationReference;
import org.palladiosimulator.pcmmeasuringpoint.PassiveResourceReference;
import org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointFactory;
import org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage;
import org.palladiosimulator.pcmmeasuringpoint.SubSystemOperationMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.SubSystemReference;
import org.palladiosimulator.pcmmeasuringpoint.SystemOperationMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.SystemReference;
import org.palladiosimulator.pcmmeasuringpoint.UsageScenarioMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.UsageScenarioReference;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PcmmeasuringpointPackageImpl extends EPackageImpl implements PcmmeasuringpointPackage {
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass assemblyOperationMeasuringPointEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass assemblyPassiveResourceMeasuringPointEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass activeResourceMeasuringPointEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass systemOperationMeasuringPointEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass operationReferenceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass assemblyReferenceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass systemReferenceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass passiveResourceReferenceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass activeResourceReferenceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass linkingResourceMeasuringPointEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass linkingResourceReferenceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass subSystemOperationMeasuringPointEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass subSystemReferenceEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass usageScenarioMeasuringPointEClass = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private EClass usageScenarioReferenceEClass = null;

    /**
     * Creates an instance of the model <b>Package</b>, registered with
     * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
     * package URI value.
     * <p>Note: the correct way to create the package is via the static
     * factory method {@link #init init()}, which also performs
     * initialization of the package, or returns the registered package,
     * if one already exists.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipse.emf.ecore.EPackage.Registry
     * @see org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private PcmmeasuringpointPackageImpl() {
        super(eNS_URI, PcmmeasuringpointFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
     * 
     * <p>This method is used to initialize {@link PcmmeasuringpointPackage#eINSTANCE} when that field is accessed.
     * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static PcmmeasuringpointPackage init() {
        if (isInited) return (PcmmeasuringpointPackage)EPackage.Registry.INSTANCE.getEPackage(PcmmeasuringpointPackage.eNS_URI);

        // Obtain or create and register package
        PcmmeasuringpointPackageImpl thePcmmeasuringpointPackage = (PcmmeasuringpointPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PcmmeasuringpointPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new PcmmeasuringpointPackageImpl());

        isInited = true;

        // Initialize simple dependencies
        ExperimentDataPackage.eINSTANCE.eClass();
        RepositoryPackage.eINSTANCE.eClass();
        MeasuringpointPackage.eINSTANCE.eClass();
        PcmPackage.eINSTANCE.eClass();

        // Create package meta-data objects
        thePcmmeasuringpointPackage.createPackageContents();

        // Initialize created meta-data
        thePcmmeasuringpointPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        thePcmmeasuringpointPackage.freeze();

  
        // Update the registry and return the package
        EPackage.Registry.INSTANCE.put(PcmmeasuringpointPackage.eNS_URI, thePcmmeasuringpointPackage);
        return thePcmmeasuringpointPackage;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getAssemblyOperationMeasuringPoint() {
        return assemblyOperationMeasuringPointEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getAssemblyPassiveResourceMeasuringPoint() {
        return assemblyPassiveResourceMeasuringPointEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getActiveResourceMeasuringPoint() {
        return activeResourceMeasuringPointEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSystemOperationMeasuringPoint() {
        return systemOperationMeasuringPointEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getOperationReference() {
        return operationReferenceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOperationReference_Role() {
        return (EReference)operationReferenceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getOperationReference_OperationSignature() {
        return (EReference)operationReferenceEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getAssemblyReference() {
        return assemblyReferenceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getAssemblyReference_Assembly() {
        return (EReference)assemblyReferenceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSystemReference() {
        return systemReferenceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSystemReference_System() {
        return (EReference)systemReferenceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getPassiveResourceReference() {
        return passiveResourceReferenceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getPassiveResourceReference_PassiveResource() {
        return (EReference)passiveResourceReferenceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getActiveResourceReference() {
        return activeResourceReferenceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getActiveResourceReference_ActiveResource() {
        return (EReference)activeResourceReferenceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EAttribute getActiveResourceReference_ReplicaID() {
        return (EAttribute)activeResourceReferenceEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getLinkingResourceMeasuringPoint() {
        return linkingResourceMeasuringPointEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getLinkingResourceReference() {
        return linkingResourceReferenceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getLinkingResourceReference_LinkingResource() {
        return (EReference)linkingResourceReferenceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSubSystemOperationMeasuringPoint() {
        return subSystemOperationMeasuringPointEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getSubSystemReference() {
        return subSystemReferenceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getSubSystemReference_Subsystem() {
        return (EReference)subSystemReferenceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getUsageScenarioMeasuringPoint() {
        return usageScenarioMeasuringPointEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EClass getUsageScenarioReference() {
        return usageScenarioReferenceEClass;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public EReference getUsageScenarioReference_UsageScenario() {
        return (EReference)usageScenarioReferenceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public PcmmeasuringpointFactory getPcmmeasuringpointFactory() {
        return (PcmmeasuringpointFactory)getEFactoryInstance();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isCreated = false;

    /**
     * Creates the meta-model objects for the package.  This method is
     * guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void createPackageContents() {
        if (isCreated) return;
        isCreated = true;

        // Create classes and their features
        assemblyOperationMeasuringPointEClass = createEClass(ASSEMBLY_OPERATION_MEASURING_POINT);

        assemblyPassiveResourceMeasuringPointEClass = createEClass(ASSEMBLY_PASSIVE_RESOURCE_MEASURING_POINT);

        activeResourceMeasuringPointEClass = createEClass(ACTIVE_RESOURCE_MEASURING_POINT);

        systemOperationMeasuringPointEClass = createEClass(SYSTEM_OPERATION_MEASURING_POINT);

        operationReferenceEClass = createEClass(OPERATION_REFERENCE);
        createEReference(operationReferenceEClass, OPERATION_REFERENCE__ROLE);
        createEReference(operationReferenceEClass, OPERATION_REFERENCE__OPERATION_SIGNATURE);

        assemblyReferenceEClass = createEClass(ASSEMBLY_REFERENCE);
        createEReference(assemblyReferenceEClass, ASSEMBLY_REFERENCE__ASSEMBLY);

        systemReferenceEClass = createEClass(SYSTEM_REFERENCE);
        createEReference(systemReferenceEClass, SYSTEM_REFERENCE__SYSTEM);

        passiveResourceReferenceEClass = createEClass(PASSIVE_RESOURCE_REFERENCE);
        createEReference(passiveResourceReferenceEClass, PASSIVE_RESOURCE_REFERENCE__PASSIVE_RESOURCE);

        activeResourceReferenceEClass = createEClass(ACTIVE_RESOURCE_REFERENCE);
        createEReference(activeResourceReferenceEClass, ACTIVE_RESOURCE_REFERENCE__ACTIVE_RESOURCE);
        createEAttribute(activeResourceReferenceEClass, ACTIVE_RESOURCE_REFERENCE__REPLICA_ID);

        linkingResourceMeasuringPointEClass = createEClass(LINKING_RESOURCE_MEASURING_POINT);

        linkingResourceReferenceEClass = createEClass(LINKING_RESOURCE_REFERENCE);
        createEReference(linkingResourceReferenceEClass, LINKING_RESOURCE_REFERENCE__LINKING_RESOURCE);

        subSystemOperationMeasuringPointEClass = createEClass(SUB_SYSTEM_OPERATION_MEASURING_POINT);

        subSystemReferenceEClass = createEClass(SUB_SYSTEM_REFERENCE);
        createEReference(subSystemReferenceEClass, SUB_SYSTEM_REFERENCE__SUBSYSTEM);

        usageScenarioMeasuringPointEClass = createEClass(USAGE_SCENARIO_MEASURING_POINT);

        usageScenarioReferenceEClass = createEClass(USAGE_SCENARIO_REFERENCE);
        createEReference(usageScenarioReferenceEClass, USAGE_SCENARIO_REFERENCE__USAGE_SCENARIO);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    private boolean isInitialized = false;

    /**
     * Complete the initialization of the package and its meta-model.  This
     * method is guarded to have no affect on any invocation but its first.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void initializePackageContents() {
        if (isInitialized) return;
        isInitialized = true;

        // Initialize package
        setName(eNAME);
        setNsPrefix(eNS_PREFIX);
        setNsURI(eNS_URI);

        // Obtain other dependent packages
        MeasuringpointPackage theMeasuringpointPackage = (MeasuringpointPackage)EPackage.Registry.INSTANCE.getEPackage(MeasuringpointPackage.eNS_URI);
        de.uka.ipd.sdq.pcm.repository.RepositoryPackage theRepositoryPackage_1 = (de.uka.ipd.sdq.pcm.repository.RepositoryPackage)EPackage.Registry.INSTANCE.getEPackage(de.uka.ipd.sdq.pcm.repository.RepositoryPackage.eNS_URI);
        CompositionPackage theCompositionPackage = (CompositionPackage)EPackage.Registry.INSTANCE.getEPackage(CompositionPackage.eNS_URI);
        SystemPackage theSystemPackage = (SystemPackage)EPackage.Registry.INSTANCE.getEPackage(SystemPackage.eNS_URI);
        ResourceenvironmentPackage theResourceenvironmentPackage = (ResourceenvironmentPackage)EPackage.Registry.INSTANCE.getEPackage(ResourceenvironmentPackage.eNS_URI);
        SubsystemPackage theSubsystemPackage = (SubsystemPackage)EPackage.Registry.INSTANCE.getEPackage(SubsystemPackage.eNS_URI);
        UsagemodelPackage theUsagemodelPackage = (UsagemodelPackage)EPackage.Registry.INSTANCE.getEPackage(UsagemodelPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        assemblyOperationMeasuringPointEClass.getESuperTypes().add(this.getOperationReference());
        assemblyOperationMeasuringPointEClass.getESuperTypes().add(this.getAssemblyReference());
        assemblyOperationMeasuringPointEClass.getESuperTypes().add(theMeasuringpointPackage.getMeasuringPoint());
        assemblyPassiveResourceMeasuringPointEClass.getESuperTypes().add(this.getAssemblyReference());
        assemblyPassiveResourceMeasuringPointEClass.getESuperTypes().add(this.getPassiveResourceReference());
        assemblyPassiveResourceMeasuringPointEClass.getESuperTypes().add(theMeasuringpointPackage.getMeasuringPoint());
        activeResourceMeasuringPointEClass.getESuperTypes().add(theMeasuringpointPackage.getMeasuringPoint());
        activeResourceMeasuringPointEClass.getESuperTypes().add(this.getActiveResourceReference());
        systemOperationMeasuringPointEClass.getESuperTypes().add(this.getOperationReference());
        systemOperationMeasuringPointEClass.getESuperTypes().add(theMeasuringpointPackage.getMeasuringPoint());
        systemOperationMeasuringPointEClass.getESuperTypes().add(this.getSystemReference());
        linkingResourceMeasuringPointEClass.getESuperTypes().add(theMeasuringpointPackage.getMeasuringPoint());
        linkingResourceMeasuringPointEClass.getESuperTypes().add(this.getLinkingResourceReference());
        subSystemOperationMeasuringPointEClass.getESuperTypes().add(theMeasuringpointPackage.getMeasuringPoint());
        subSystemOperationMeasuringPointEClass.getESuperTypes().add(this.getSubSystemReference());
        subSystemOperationMeasuringPointEClass.getESuperTypes().add(this.getOperationReference());
        usageScenarioMeasuringPointEClass.getESuperTypes().add(theMeasuringpointPackage.getMeasuringPoint());
        usageScenarioMeasuringPointEClass.getESuperTypes().add(this.getUsageScenarioReference());

        // Initialize classes and features; add operations and parameters
        initEClass(assemblyOperationMeasuringPointEClass, AssemblyOperationMeasuringPoint.class, "AssemblyOperationMeasuringPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(assemblyPassiveResourceMeasuringPointEClass, AssemblyPassiveResourceMeasuringPoint.class, "AssemblyPassiveResourceMeasuringPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(activeResourceMeasuringPointEClass, ActiveResourceMeasuringPoint.class, "ActiveResourceMeasuringPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(systemOperationMeasuringPointEClass, SystemOperationMeasuringPoint.class, "SystemOperationMeasuringPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(operationReferenceEClass, OperationReference.class, "OperationReference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getOperationReference_Role(), theRepositoryPackage_1.getRole(), null, "role", null, 1, 1, OperationReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEReference(getOperationReference_OperationSignature(), theRepositoryPackage_1.getOperationSignature(), null, "operationSignature", null, 1, 1, OperationReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(assemblyReferenceEClass, AssemblyReference.class, "AssemblyReference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getAssemblyReference_Assembly(), theCompositionPackage.getAssemblyContext(), null, "assembly", null, 1, 1, AssemblyReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(systemReferenceEClass, SystemReference.class, "SystemReference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getSystemReference_System(), theSystemPackage.getSystem(), null, "system", null, 1, 1, SystemReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(passiveResourceReferenceEClass, PassiveResourceReference.class, "PassiveResourceReference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getPassiveResourceReference_PassiveResource(), theRepositoryPackage_1.getPassiveResource(), null, "passiveResource", null, 1, 1, PassiveResourceReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(activeResourceReferenceEClass, ActiveResourceReference.class, "ActiveResourceReference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getActiveResourceReference_ActiveResource(), theResourceenvironmentPackage.getProcessingResourceSpecification(), null, "activeResource", null, 1, 1, ActiveResourceReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        initEAttribute(getActiveResourceReference_ReplicaID(), ecorePackage.getEInt(), "replicaID", "0", 1, 1, ActiveResourceReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(linkingResourceMeasuringPointEClass, LinkingResourceMeasuringPoint.class, "LinkingResourceMeasuringPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(linkingResourceReferenceEClass, LinkingResourceReference.class, "LinkingResourceReference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getLinkingResourceReference_LinkingResource(), theResourceenvironmentPackage.getLinkingResource(), null, "linkingResource", null, 1, 1, LinkingResourceReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(subSystemOperationMeasuringPointEClass, SubSystemOperationMeasuringPoint.class, "SubSystemOperationMeasuringPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(subSystemReferenceEClass, SubSystemReference.class, "SubSystemReference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getSubSystemReference_Subsystem(), theSubsystemPackage.getSubSystem(), null, "subsystem", null, 1, 1, SubSystemReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        initEClass(usageScenarioMeasuringPointEClass, UsageScenarioMeasuringPoint.class, "UsageScenarioMeasuringPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        initEClass(usageScenarioReferenceEClass, UsageScenarioReference.class, "UsageScenarioReference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getUsageScenarioReference_UsageScenario(), theUsagemodelPackage.getUsageScenario(), null, "usageScenario", null, 1, 1, UsageScenarioReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Create resource
        createResource(eNS_URI);
    }

} //PcmmeasuringpointPackageImpl
