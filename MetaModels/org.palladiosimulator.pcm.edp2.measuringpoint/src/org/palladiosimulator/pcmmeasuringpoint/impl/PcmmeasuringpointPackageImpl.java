/**
 */
package org.palladiosimulator.pcmmeasuringpoint.impl;

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
import org.palladiosimulator.pcmmeasuringpoint.EntryLevelSystemCallMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.EntryLevelSystemCallReference;
import org.palladiosimulator.pcmmeasuringpoint.ExternalCallActionMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.ExternalCallActionReference;
import org.palladiosimulator.pcmmeasuringpoint.LinkingResourceMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.LinkingResourceReference;
import org.palladiosimulator.pcmmeasuringpoint.OperationReference;
import org.palladiosimulator.pcmmeasuringpoint.PassiveResourceReference;
import org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointFactory;
import org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage;
import org.palladiosimulator.pcmmeasuringpoint.ResourceEnvironmentMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.ResourceEnvironmentReference;
import org.palladiosimulator.pcmmeasuringpoint.SubSystemOperationMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.SubSystemReference;
import org.palladiosimulator.pcmmeasuringpoint.SystemOperationMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.SystemReference;
import org.palladiosimulator.pcmmeasuringpoint.UsageScenarioMeasuringPoint;
import org.palladiosimulator.pcmmeasuringpoint.UsageScenarioReference;

import de.uka.ipd.sdq.pcm.PcmPackage;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.subsystem.SubsystemPackage;
import de.uka.ipd.sdq.pcm.system.SystemPackage;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 *
 * @generated
 */
public class PcmmeasuringpointPackageImpl extends EPackageImpl implements PcmmeasuringpointPackage {

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass assemblyOperationMeasuringPointEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass assemblyPassiveResourceMeasuringPointEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass activeResourceMeasuringPointEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass systemOperationMeasuringPointEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass operationReferenceEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass assemblyReferenceEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass systemReferenceEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass passiveResourceReferenceEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass activeResourceReferenceEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass linkingResourceMeasuringPointEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass linkingResourceReferenceEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass subSystemOperationMeasuringPointEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass subSystemReferenceEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass usageScenarioMeasuringPointEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass usageScenarioReferenceEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass entryLevelSystemCallMeasuringPointEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass externalCallActionMeasuringPointEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass externalCallActionReferenceEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass entryLevelSystemCallReferenceEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass resourceEnvironmentMeasuringPointEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    private EClass resourceEnvironmentReferenceEClass = null;

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
     * @see org.palladiosimulator.pcmmeasuringpoint.PcmmeasuringpointPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private PcmmeasuringpointPackageImpl() {
        super(eNS_URI, PcmmeasuringpointFactory.eINSTANCE);
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
     * This method is used to initialize {@link PcmmeasuringpointPackage#eINSTANCE} when that field
     * is accessed. Clients should not invoke it directly. Instead, they should simply access that
     * field to obtain the package. <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static PcmmeasuringpointPackage init() {
        if (isInited) {
            return (PcmmeasuringpointPackage) EPackage.Registry.INSTANCE.getEPackage(PcmmeasuringpointPackage.eNS_URI);
        }

        // Obtain or create and register package
        final PcmmeasuringpointPackageImpl thePcmmeasuringpointPackage = (PcmmeasuringpointPackageImpl) (EPackage.Registry.INSTANCE
                .get(eNS_URI) instanceof PcmmeasuringpointPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI)
                : new PcmmeasuringpointPackageImpl());

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
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getAssemblyOperationMeasuringPoint() {
        return this.assemblyOperationMeasuringPointEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getAssemblyPassiveResourceMeasuringPoint() {
        return this.assemblyPassiveResourceMeasuringPointEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getActiveResourceMeasuringPoint() {
        return this.activeResourceMeasuringPointEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getSystemOperationMeasuringPoint() {
        return this.systemOperationMeasuringPointEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getOperationReference() {
        return this.operationReferenceEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getOperationReference_Role() {
        return (EReference) this.operationReferenceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getOperationReference_OperationSignature() {
        return (EReference) this.operationReferenceEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getAssemblyReference() {
        return this.assemblyReferenceEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getAssemblyReference_Assembly() {
        return (EReference) this.assemblyReferenceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getSystemReference() {
        return this.systemReferenceEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getSystemReference_System() {
        return (EReference) this.systemReferenceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getPassiveResourceReference() {
        return this.passiveResourceReferenceEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getPassiveResourceReference_PassiveResource() {
        return (EReference) this.passiveResourceReferenceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getActiveResourceReference() {
        return this.activeResourceReferenceEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getActiveResourceReference_ActiveResource() {
        return (EReference) this.activeResourceReferenceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EAttribute getActiveResourceReference_ReplicaID() {
        return (EAttribute) this.activeResourceReferenceEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getLinkingResourceMeasuringPoint() {
        return this.linkingResourceMeasuringPointEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getLinkingResourceReference() {
        return this.linkingResourceReferenceEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getLinkingResourceReference_LinkingResource() {
        return (EReference) this.linkingResourceReferenceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getSubSystemOperationMeasuringPoint() {
        return this.subSystemOperationMeasuringPointEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getSubSystemReference() {
        return this.subSystemReferenceEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getSubSystemReference_Subsystem() {
        return (EReference) this.subSystemReferenceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getUsageScenarioMeasuringPoint() {
        return this.usageScenarioMeasuringPointEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getUsageScenarioReference() {
        return this.usageScenarioReferenceEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getUsageScenarioReference_UsageScenario() {
        return (EReference) this.usageScenarioReferenceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getEntryLevelSystemCallMeasuringPoint() {
        return this.entryLevelSystemCallMeasuringPointEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getExternalCallActionMeasuringPoint() {
        return this.externalCallActionMeasuringPointEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getExternalCallActionReference() {
        return this.externalCallActionReferenceEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getExternalCallActionReference_ExternalCall() {
        return (EReference) this.externalCallActionReferenceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getEntryLevelSystemCallReference() {
        return this.entryLevelSystemCallReferenceEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getEntryLevelSystemCallReference_EntryLevelSystemCall() {
        return (EReference) this.entryLevelSystemCallReferenceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getResourceEnvironmentMeasuringPoint() {
        return this.resourceEnvironmentMeasuringPointEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EClass getResourceEnvironmentReference() {
        return this.resourceEnvironmentReferenceEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public EReference getResourceEnvironmentReference_ResourceEnvironment() {
        return (EReference) this.resourceEnvironmentReferenceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     *
     * @generated
     */
    @Override
    public PcmmeasuringpointFactory getPcmmeasuringpointFactory() {
        return (PcmmeasuringpointFactory) this.getEFactoryInstance();
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
        this.assemblyOperationMeasuringPointEClass = this.createEClass(ASSEMBLY_OPERATION_MEASURING_POINT);

        this.assemblyPassiveResourceMeasuringPointEClass = this.createEClass(ASSEMBLY_PASSIVE_RESOURCE_MEASURING_POINT);

        this.activeResourceMeasuringPointEClass = this.createEClass(ACTIVE_RESOURCE_MEASURING_POINT);

        this.systemOperationMeasuringPointEClass = this.createEClass(SYSTEM_OPERATION_MEASURING_POINT);

        this.operationReferenceEClass = this.createEClass(OPERATION_REFERENCE);
        this.createEReference(this.operationReferenceEClass, OPERATION_REFERENCE__ROLE);
        this.createEReference(this.operationReferenceEClass, OPERATION_REFERENCE__OPERATION_SIGNATURE);

        this.assemblyReferenceEClass = this.createEClass(ASSEMBLY_REFERENCE);
        this.createEReference(this.assemblyReferenceEClass, ASSEMBLY_REFERENCE__ASSEMBLY);

        this.systemReferenceEClass = this.createEClass(SYSTEM_REFERENCE);
        this.createEReference(this.systemReferenceEClass, SYSTEM_REFERENCE__SYSTEM);

        this.passiveResourceReferenceEClass = this.createEClass(PASSIVE_RESOURCE_REFERENCE);
        this.createEReference(this.passiveResourceReferenceEClass, PASSIVE_RESOURCE_REFERENCE__PASSIVE_RESOURCE);

        this.activeResourceReferenceEClass = this.createEClass(ACTIVE_RESOURCE_REFERENCE);
        this.createEReference(this.activeResourceReferenceEClass, ACTIVE_RESOURCE_REFERENCE__ACTIVE_RESOURCE);
        this.createEAttribute(this.activeResourceReferenceEClass, ACTIVE_RESOURCE_REFERENCE__REPLICA_ID);

        this.linkingResourceMeasuringPointEClass = this.createEClass(LINKING_RESOURCE_MEASURING_POINT);

        this.linkingResourceReferenceEClass = this.createEClass(LINKING_RESOURCE_REFERENCE);
        this.createEReference(this.linkingResourceReferenceEClass, LINKING_RESOURCE_REFERENCE__LINKING_RESOURCE);

        this.subSystemOperationMeasuringPointEClass = this.createEClass(SUB_SYSTEM_OPERATION_MEASURING_POINT);

        this.subSystemReferenceEClass = this.createEClass(SUB_SYSTEM_REFERENCE);
        this.createEReference(this.subSystemReferenceEClass, SUB_SYSTEM_REFERENCE__SUBSYSTEM);

        this.usageScenarioMeasuringPointEClass = this.createEClass(USAGE_SCENARIO_MEASURING_POINT);

        this.usageScenarioReferenceEClass = this.createEClass(USAGE_SCENARIO_REFERENCE);
        this.createEReference(this.usageScenarioReferenceEClass, USAGE_SCENARIO_REFERENCE__USAGE_SCENARIO);

        this.entryLevelSystemCallMeasuringPointEClass = this.createEClass(ENTRY_LEVEL_SYSTEM_CALL_MEASURING_POINT);

        this.externalCallActionMeasuringPointEClass = this.createEClass(EXTERNAL_CALL_ACTION_MEASURING_POINT);

        this.externalCallActionReferenceEClass = this.createEClass(EXTERNAL_CALL_ACTION_REFERENCE);
        this.createEReference(this.externalCallActionReferenceEClass, EXTERNAL_CALL_ACTION_REFERENCE__EXTERNAL_CALL);

        this.entryLevelSystemCallReferenceEClass = this.createEClass(ENTRY_LEVEL_SYSTEM_CALL_REFERENCE);
        this.createEReference(this.entryLevelSystemCallReferenceEClass,
                ENTRY_LEVEL_SYSTEM_CALL_REFERENCE__ENTRY_LEVEL_SYSTEM_CALL);

        this.resourceEnvironmentMeasuringPointEClass = this.createEClass(RESOURCE_ENVIRONMENT_MEASURING_POINT);

        this.resourceEnvironmentReferenceEClass = this.createEClass(RESOURCE_ENVIRONMENT_REFERENCE);
        this.createEReference(this.resourceEnvironmentReferenceEClass,
                RESOURCE_ENVIRONMENT_REFERENCE__RESOURCE_ENVIRONMENT);
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
        final MeasuringpointPackage theMeasuringpointPackage = (MeasuringpointPackage) EPackage.Registry.INSTANCE
                .getEPackage(MeasuringpointPackage.eNS_URI);
        final de.uka.ipd.sdq.pcm.repository.RepositoryPackage theRepositoryPackage_1 = (de.uka.ipd.sdq.pcm.repository.RepositoryPackage) EPackage.Registry.INSTANCE
                .getEPackage(de.uka.ipd.sdq.pcm.repository.RepositoryPackage.eNS_URI);
        final CompositionPackage theCompositionPackage = (CompositionPackage) EPackage.Registry.INSTANCE
                .getEPackage(CompositionPackage.eNS_URI);
        final SystemPackage theSystemPackage = (SystemPackage) EPackage.Registry.INSTANCE
                .getEPackage(SystemPackage.eNS_URI);
        final ResourceenvironmentPackage theResourceenvironmentPackage = (ResourceenvironmentPackage) EPackage.Registry.INSTANCE
                .getEPackage(ResourceenvironmentPackage.eNS_URI);
        final SubsystemPackage theSubsystemPackage = (SubsystemPackage) EPackage.Registry.INSTANCE
                .getEPackage(SubsystemPackage.eNS_URI);
        final UsagemodelPackage theUsagemodelPackage = (UsagemodelPackage) EPackage.Registry.INSTANCE
                .getEPackage(UsagemodelPackage.eNS_URI);
        final SeffPackage theSeffPackage = (SeffPackage) EPackage.Registry.INSTANCE.getEPackage(SeffPackage.eNS_URI);

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        this.assemblyOperationMeasuringPointEClass.getESuperTypes().add(this.getOperationReference());
        this.assemblyOperationMeasuringPointEClass.getESuperTypes().add(this.getAssemblyReference());
        this.assemblyOperationMeasuringPointEClass.getESuperTypes().add(theMeasuringpointPackage.getMeasuringPoint());
        this.assemblyPassiveResourceMeasuringPointEClass.getESuperTypes().add(this.getAssemblyReference());
        this.assemblyPassiveResourceMeasuringPointEClass.getESuperTypes().add(this.getPassiveResourceReference());
        this.assemblyPassiveResourceMeasuringPointEClass.getESuperTypes().add(
                theMeasuringpointPackage.getMeasuringPoint());
        this.activeResourceMeasuringPointEClass.getESuperTypes().add(theMeasuringpointPackage.getMeasuringPoint());
        this.activeResourceMeasuringPointEClass.getESuperTypes().add(this.getActiveResourceReference());
        this.systemOperationMeasuringPointEClass.getESuperTypes().add(this.getOperationReference());
        this.systemOperationMeasuringPointEClass.getESuperTypes().add(theMeasuringpointPackage.getMeasuringPoint());
        this.systemOperationMeasuringPointEClass.getESuperTypes().add(this.getSystemReference());
        this.linkingResourceMeasuringPointEClass.getESuperTypes().add(theMeasuringpointPackage.getMeasuringPoint());
        this.linkingResourceMeasuringPointEClass.getESuperTypes().add(this.getLinkingResourceReference());
        this.subSystemOperationMeasuringPointEClass.getESuperTypes().add(theMeasuringpointPackage.getMeasuringPoint());
        this.subSystemOperationMeasuringPointEClass.getESuperTypes().add(this.getSubSystemReference());
        this.subSystemOperationMeasuringPointEClass.getESuperTypes().add(this.getOperationReference());
        this.usageScenarioMeasuringPointEClass.getESuperTypes().add(theMeasuringpointPackage.getMeasuringPoint());
        this.usageScenarioMeasuringPointEClass.getESuperTypes().add(this.getUsageScenarioReference());
        this.entryLevelSystemCallMeasuringPointEClass.getESuperTypes()
        .add(theMeasuringpointPackage.getMeasuringPoint());
        this.entryLevelSystemCallMeasuringPointEClass.getESuperTypes().add(this.getEntryLevelSystemCallReference());
        this.externalCallActionMeasuringPointEClass.getESuperTypes().add(theMeasuringpointPackage.getMeasuringPoint());
        this.externalCallActionMeasuringPointEClass.getESuperTypes().add(this.getExternalCallActionReference());
        this.resourceEnvironmentMeasuringPointEClass.getESuperTypes().add(this.getResourceEnvironmentReference());
        this.resourceEnvironmentMeasuringPointEClass.getESuperTypes().add(theMeasuringpointPackage.getMeasuringPoint());

        // Initialize classes and features; add operations and parameters
        this.initEClass(this.assemblyOperationMeasuringPointEClass, AssemblyOperationMeasuringPoint.class,
                "AssemblyOperationMeasuringPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        this.initEClass(this.assemblyPassiveResourceMeasuringPointEClass, AssemblyPassiveResourceMeasuringPoint.class,
                "AssemblyPassiveResourceMeasuringPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        this.initEClass(this.activeResourceMeasuringPointEClass, ActiveResourceMeasuringPoint.class,
                "ActiveResourceMeasuringPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        this.initEClass(this.systemOperationMeasuringPointEClass, SystemOperationMeasuringPoint.class,
                "SystemOperationMeasuringPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        this.initEClass(this.operationReferenceEClass, OperationReference.class, "OperationReference", IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getOperationReference_Role(), theRepositoryPackage_1.getRole(), null, "role", null, 1,
                1, OperationReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEReference(this.getOperationReference_OperationSignature(),
                theRepositoryPackage_1.getOperationSignature(), null, "operationSignature", null, 1, 1,
                OperationReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.assemblyReferenceEClass, AssemblyReference.class, "AssemblyReference", IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getAssemblyReference_Assembly(), theCompositionPackage.getAssemblyContext(), null,
                "assembly", null, 1, 1, AssemblyReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.systemReferenceEClass, SystemReference.class, "SystemReference", IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getSystemReference_System(), theSystemPackage.getSystem(), null, "system", null, 1, 1,
                SystemReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.passiveResourceReferenceEClass, PassiveResourceReference.class,
                "PassiveResourceReference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getPassiveResourceReference_PassiveResource(),
                theRepositoryPackage_1.getPassiveResource(), null, "passiveResource", null, 1, 1,
                PassiveResourceReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.activeResourceReferenceEClass, ActiveResourceReference.class, "ActiveResourceReference",
                IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getActiveResourceReference_ActiveResource(),
                theResourceenvironmentPackage.getProcessingResourceSpecification(), null, "activeResource", null, 1, 1,
                ActiveResourceReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
        this.initEAttribute(this.getActiveResourceReference_ReplicaID(), this.ecorePackage.getEInt(), "replicaID", "0",
                1, 1, ActiveResourceReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE,
                !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.linkingResourceMeasuringPointEClass, LinkingResourceMeasuringPoint.class,
                "LinkingResourceMeasuringPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        this.initEClass(this.linkingResourceReferenceEClass, LinkingResourceReference.class,
                "LinkingResourceReference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getLinkingResourceReference_LinkingResource(),
                theResourceenvironmentPackage.getLinkingResource(), null, "linkingResource", null, 1, 1,
                LinkingResourceReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.subSystemOperationMeasuringPointEClass, SubSystemOperationMeasuringPoint.class,
                "SubSystemOperationMeasuringPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        this.initEClass(this.subSystemReferenceEClass, SubSystemReference.class, "SubSystemReference", IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getSubSystemReference_Subsystem(), theSubsystemPackage.getSubSystem(), null,
                "subsystem", null, 1, 1, SubSystemReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.usageScenarioMeasuringPointEClass, UsageScenarioMeasuringPoint.class,
                "UsageScenarioMeasuringPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        this.initEClass(this.usageScenarioReferenceEClass, UsageScenarioReference.class, "UsageScenarioReference",
                IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getUsageScenarioReference_UsageScenario(), theUsagemodelPackage.getUsageScenario(),
                null, "usageScenario", null, 1, 1, UsageScenarioReference.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.entryLevelSystemCallMeasuringPointEClass, EntryLevelSystemCallMeasuringPoint.class,
                "EntryLevelSystemCallMeasuringPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        this.initEClass(this.externalCallActionMeasuringPointEClass, ExternalCallActionMeasuringPoint.class,
                "ExternalCallActionMeasuringPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        this.initEClass(this.externalCallActionReferenceEClass, ExternalCallActionReference.class,
                "ExternalCallActionReference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getExternalCallActionReference_ExternalCall(), theSeffPackage.getExternalCallAction(),
                null, "externalCall", null, 1, 1, ExternalCallActionReference.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.entryLevelSystemCallReferenceEClass, EntryLevelSystemCallReference.class,
                "EntryLevelSystemCallReference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getEntryLevelSystemCallReference_EntryLevelSystemCall(),
                theUsagemodelPackage.getEntryLevelSystemCall(), null, "entryLevelSystemCall", null, 1, 1,
                EntryLevelSystemCallReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        this.initEClass(this.resourceEnvironmentMeasuringPointEClass, ResourceEnvironmentMeasuringPoint.class,
                "ResourceEnvironmentMeasuringPoint", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

        this.initEClass(this.resourceEnvironmentReferenceEClass, ResourceEnvironmentReference.class,
                "ResourceEnvironmentReference", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        this.initEReference(this.getResourceEnvironmentReference_ResourceEnvironment(),
                theResourceenvironmentPackage.getResourceEnvironment(), null, "resourceEnvironment", null, 1, 1,
                ResourceEnvironmentReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

        // Create resource
        this.createResource(eNS_URI);
    }

} // PcmmeasuringpointPackageImpl
