/**
 * Copyright 2008, sdq.ipd.uka.de, U KA
 *
 * $Id$
 */
package de.uka.ipd.sdq.simucomframework.simucomstatus.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import de.uka.ipd.sdq.simucomframework.simucomstatus.Action;
import de.uka.ipd.sdq.simucomframework.simucomstatus.ActiveResouce;
import de.uka.ipd.sdq.simucomframework.simucomstatus.PassiveResource;
import de.uka.ipd.sdq.simucomframework.simucomstatus.SimuComStatus;
import de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusFactory;
import de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusPackage;
import de.uka.ipd.sdq.simucomframework.simucomstatus.SimulatedProcesses;
import de.uka.ipd.sdq.simucomframework.simucomstatus.SimulatedResources;
import de.uka.ipd.sdq.simucomframework.simucomstatus.WaitForAcquire;
import de.uka.ipd.sdq.simucomframework.simucomstatus.WaitForDelay;
import de.uka.ipd.sdq.simucomframework.simucomstatus.WaitForDemand;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * 
 * @generated
 */
public class SimucomstatusPackageImpl extends EPackageImpl implements SimucomstatusPackage {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass simuComStatusEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass simulatedProcessesEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass processEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass actionEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass simulatedResourcesEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass activeResouceEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass waitForDemandEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass passiveResourceEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass waitForAcquireEClass = null;

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private EClass waitForDelayEClass = null;

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
     * @see de.uka.ipd.sdq.simucomframework.simucomstatus.SimucomstatusPackage#eNS_URI
     * @see #init()
     * @generated
     */
    private SimucomstatusPackageImpl() {
        super(eNS_URI, SimucomstatusFactory.eINSTANCE);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    private static boolean isInited = false;

    /**
     * Creates, registers, and initializes the <b>Package</b> for this model, and for any others
     * upon which it depends. Simple dependencies are satisfied by calling this method on all
     * dependent packages before doing anything else. This method drives initialization for
     * interdependent packages directly, in parallel with this package, itself.
     * <p>
     * Of this package and its interdependencies, all packages which have not yet been registered by
     * their URI values are first created and registered. The packages are then initialized in two
     * steps: meta-model objects for all of the packages are created before any are initialized,
     * since one package's meta-model objects may refer to those of another.
     * <p>
     * Invocation of this method will not affect any packages that have already been initialized.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @see #eNS_URI
     * @see #createPackageContents()
     * @see #initializePackageContents()
     * @generated
     */
    public static SimucomstatusPackage init() {
        if (isInited)
            return (SimucomstatusPackage) EPackage.Registry.INSTANCE.getEPackage(SimucomstatusPackage.eNS_URI);

        // Obtain or create and register package
        SimucomstatusPackageImpl theSimucomstatusPackage = (SimucomstatusPackageImpl) (EPackage.Registry.INSTANCE
                .getEPackage(eNS_URI) instanceof SimucomstatusPackageImpl ? EPackage.Registry.INSTANCE
                .getEPackage(eNS_URI) : new SimucomstatusPackageImpl());

        isInited = true;

        // Create package meta-data objects
        theSimucomstatusPackage.createPackageContents();

        // Initialize created meta-data
        theSimucomstatusPackage.initializePackageContents();

        // Mark meta-data to indicate it can't be changed
        theSimucomstatusPackage.freeze();

        return theSimucomstatusPackage;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getSimuComStatus() {
        return simuComStatusEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getSimuComStatus_ProcessStatus() {
        return (EReference) simuComStatusEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getSimuComStatus_ResourceStatus() {
        return (EReference) simuComStatusEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getSimuComStatus_CurrentSimulationTime() {
        return (EAttribute) simuComStatusEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getSimulatedProcesses() {
        return simulatedProcessesEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getSimulatedProcesses_Processes() {
        return (EReference) simulatedProcessesEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getProcess() {
        return processEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getProcess_CurrentAction() {
        return (EReference) processEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getProcess_Id() {
        return (EAttribute) processEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getProcess_ProcessStartTime() {
        return (EAttribute) processEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getAction() {
        return actionEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getAction_ActionStartTime() {
        return (EAttribute) actionEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getAction_ActionDuration() {
        return (EAttribute) actionEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getSimulatedResources() {
        return simulatedResourcesEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getSimulatedResources_ActiveResources() {
        return (EReference) simulatedResourcesEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getSimulatedResources_PassiveResources() {
        return (EReference) simulatedResourcesEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getActiveResouce() {
        return activeResouceEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getActiveResouce_WaitingDemands() {
        return (EReference) activeResouceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getActiveResouce_Id() {
        return (EAttribute) activeResouceEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getWaitForDemand() {
        return waitForDemandEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getWaitForDemand_Demand() {
        return (EAttribute) waitForDemandEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getWaitForDemand_Resource() {
        return (EReference) waitForDemandEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getPassiveResource() {
        return passiveResourceEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getPassiveResource_WaitingProcesses() {
        return (EReference) passiveResourceEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getPassiveResource_InitialResourceCount() {
        return (EAttribute) passiveResourceEClass.getEStructuralFeatures().get(1);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getPassiveResource_ResourcesAvailable() {
        return (EAttribute) passiveResourceEClass.getEStructuralFeatures().get(2);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getPassiveResource_Id() {
        return (EAttribute) passiveResourceEClass.getEStructuralFeatures().get(3);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getWaitForAcquire() {
        return waitForAcquireEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EReference getWaitForAcquire_Resource() {
        return (EReference) waitForAcquireEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EClass getWaitForDelay() {
        return waitForDelayEClass;
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public EAttribute getWaitForDelay_Delay() {
        return (EAttribute) waitForDelayEClass.getEStructuralFeatures().get(0);
    }

    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    public SimucomstatusFactory getSimucomstatusFactory() {
        return (SimucomstatusFactory) getEFactoryInstance();
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
        simuComStatusEClass = createEClass(SIMU_COM_STATUS);
        createEReference(simuComStatusEClass, SIMU_COM_STATUS__PROCESS_STATUS);
        createEReference(simuComStatusEClass, SIMU_COM_STATUS__RESOURCE_STATUS);
        createEAttribute(simuComStatusEClass, SIMU_COM_STATUS__CURRENT_SIMULATION_TIME);

        simulatedProcessesEClass = createEClass(SIMULATED_PROCESSES);
        createEReference(simulatedProcessesEClass, SIMULATED_PROCESSES__PROCESSES);

        processEClass = createEClass(PROCESS);
        createEReference(processEClass, PROCESS__CURRENT_ACTION);
        createEAttribute(processEClass, PROCESS__ID);
        createEAttribute(processEClass, PROCESS__PROCESS_START_TIME);

        actionEClass = createEClass(ACTION);
        createEAttribute(actionEClass, ACTION__ACTION_START_TIME);
        createEAttribute(actionEClass, ACTION__ACTION_DURATION);

        simulatedResourcesEClass = createEClass(SIMULATED_RESOURCES);
        createEReference(simulatedResourcesEClass, SIMULATED_RESOURCES__ACTIVE_RESOURCES);
        createEReference(simulatedResourcesEClass, SIMULATED_RESOURCES__PASSIVE_RESOURCES);

        activeResouceEClass = createEClass(ACTIVE_RESOUCE);
        createEReference(activeResouceEClass, ACTIVE_RESOUCE__WAITING_DEMANDS);
        createEAttribute(activeResouceEClass, ACTIVE_RESOUCE__ID);

        waitForDemandEClass = createEClass(WAIT_FOR_DEMAND);
        createEAttribute(waitForDemandEClass, WAIT_FOR_DEMAND__DEMAND);
        createEReference(waitForDemandEClass, WAIT_FOR_DEMAND__RESOURCE);

        passiveResourceEClass = createEClass(PASSIVE_RESOURCE);
        createEReference(passiveResourceEClass, PASSIVE_RESOURCE__WAITING_PROCESSES);
        createEAttribute(passiveResourceEClass, PASSIVE_RESOURCE__INITIAL_RESOURCE_COUNT);
        createEAttribute(passiveResourceEClass, PASSIVE_RESOURCE__RESOURCES_AVAILABLE);
        createEAttribute(passiveResourceEClass, PASSIVE_RESOURCE__ID);

        waitForAcquireEClass = createEClass(WAIT_FOR_ACQUIRE);
        createEReference(waitForAcquireEClass, WAIT_FOR_ACQUIRE__RESOURCE);

        waitForDelayEClass = createEClass(WAIT_FOR_DELAY);
        createEAttribute(waitForDelayEClass, WAIT_FOR_DELAY__DELAY);
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

        // Create type parameters

        // Set bounds for type parameters

        // Add supertypes to classes
        waitForDemandEClass.getESuperTypes().add(this.getAction());
        waitForAcquireEClass.getESuperTypes().add(this.getAction());
        waitForDelayEClass.getESuperTypes().add(this.getAction());

        // Initialize classes and features; add operations and parameters
        initEClass(simuComStatusEClass, SimuComStatus.class, "SimuComStatus", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEReference(getSimuComStatus_ProcessStatus(), this.getSimulatedProcesses(), null, "processStatus", null, 1,
                1, SimuComStatus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
                !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getSimuComStatus_ResourceStatus(), this.getSimulatedResources(), null, "resourceStatus", null,
                1, 1, SimuComStatus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getSimuComStatus_CurrentSimulationTime(), ecorePackage.getEDouble(), "currentSimulationTime",
                null, 1, 1, SimuComStatus.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(simulatedProcessesEClass, SimulatedProcesses.class, "SimulatedProcesses", !IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getSimulatedProcesses_Processes(), this.getProcess(), null, "processes", null, 0, -1,
                SimulatedProcesses.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(processEClass, de.uka.ipd.sdq.simucomframework.simucomstatus.Process.class, "Process", !IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getProcess_CurrentAction(), this.getAction(), null, "currentAction", null, 1, 1,
                de.uka.ipd.sdq.simucomframework.simucomstatus.Process.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getProcess_Id(), ecorePackage.getEString(), "id", null, 1, 1,
                de.uka.ipd.sdq.simucomframework.simucomstatus.Process.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getProcess_ProcessStartTime(), ecorePackage.getEDouble(), "processStartTime", null, 1, 1,
                de.uka.ipd.sdq.simucomframework.simucomstatus.Process.class, !IS_TRANSIENT, !IS_VOLATILE,
                IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(actionEClass, Action.class, "Action", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getAction_ActionStartTime(), ecorePackage.getEDouble(), "actionStartTime", null, 1, 1,
                Action.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
                !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getAction_ActionDuration(), ecorePackage.getEDouble(), "actionDuration", null, 1, 1,
                Action.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
                !IS_ORDERED);

        initEClass(simulatedResourcesEClass, SimulatedResources.class, "SimulatedResources", !IS_ABSTRACT,
                !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
        initEReference(getSimulatedResources_ActiveResources(), this.getActiveResouce(), null, "activeResources", null,
                0, -1, SimulatedResources.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getSimulatedResources_PassiveResources(), this.getPassiveResource(), null, "passiveResources",
                null, 0, -1, SimulatedResources.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
                !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(activeResouceEClass, ActiveResouce.class, "ActiveResouce", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEReference(getActiveResouce_WaitingDemands(), this.getWaitForDemand(), this.getWaitForDemand_Resource(),
                "waitingDemands", null, 0, -1, ActiveResouce.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
                !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getActiveResouce_Id(), ecorePackage.getEString(), "id", null, 1, 1, ActiveResouce.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(waitForDemandEClass, WaitForDemand.class, "WaitForDemand", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWaitForDemand_Demand(), ecorePackage.getEDouble(), "demand", null, 1, 1, WaitForDemand.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEReference(getWaitForDemand_Resource(), this.getActiveResouce(), this.getActiveResouce_WaitingDemands(),
                "resource", null, 1, 1, WaitForDemand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
                IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(passiveResourceEClass, PassiveResource.class, "PassiveResource", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEReference(getPassiveResource_WaitingProcesses(), this.getWaitForAcquire(),
                this.getWaitForAcquire_Resource(), "waitingProcesses", null, 0, -1, PassiveResource.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
                IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getPassiveResource_InitialResourceCount(), ecorePackage.getEDouble(), "initialResourceCount",
                null, 1, 1, PassiveResource.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getPassiveResource_ResourcesAvailable(), ecorePackage.getEDouble(), "resourcesAvailable", null,
                1, 1, PassiveResource.class, IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
                IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
        initEAttribute(getPassiveResource_Id(), ecorePackage.getEString(), "id", null, 1, 1, PassiveResource.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(waitForAcquireEClass, WaitForAcquire.class, "WaitForAcquire", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEReference(getWaitForAcquire_Resource(), this.getPassiveResource(),
                this.getPassiveResource_WaitingProcesses(), "resource", null, 1, 1, WaitForAcquire.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
                IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        initEClass(waitForDelayEClass, WaitForDelay.class, "WaitForDelay", !IS_ABSTRACT, !IS_INTERFACE,
                IS_GENERATED_INSTANCE_CLASS);
        initEAttribute(getWaitForDelay_Delay(), ecorePackage.getEDouble(), "delay", null, 1, 1, WaitForDelay.class,
                !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

        // Create resource
        createResource(eNS_URI);
    }

} // SimucomstatusPackageImpl
