/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.system.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import de.uka.ipd.sdq.identifier.IdentifierPackage;
import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;
import de.uka.ipd.sdq.pcm.allocation.impl.AllocationPackageImpl;
import de.uka.ipd.sdq.pcm.assembly.AssemblyPackage;
import de.uka.ipd.sdq.pcm.assembly.impl.AssemblyPackageImpl;
import de.uka.ipd.sdq.pcm.core.connectors.ConnectorsPackage;
import de.uka.ipd.sdq.pcm.core.connectors.impl.ConnectorsPackageImpl;
import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.core.entity.impl.EntityPackageImpl;
import de.uka.ipd.sdq.pcm.core.stochastics.StochasticsPackage;
import de.uka.ipd.sdq.pcm.core.stochastics.impl.StochasticsPackageImpl;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.parameter.impl.ParameterPackageImpl;
import de.uka.ipd.sdq.pcm.protocol.ProtocolPackage;
import de.uka.ipd.sdq.pcm.protocol.impl.ProtocolPackageImpl;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;
import de.uka.ipd.sdq.pcm.resourceenvironment.impl.ResourceenvironmentPackageImpl;
import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;
import de.uka.ipd.sdq.pcm.resourcetype.impl.ResourcetypePackageImpl;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl;
import de.uka.ipd.sdq.pcm.system.SpecifiedTimeConsumption;
import de.uka.ipd.sdq.pcm.system.SystemFactory;
import de.uka.ipd.sdq.pcm.system.SystemPackage;
import de.uka.ipd.sdq.pcm.system.SystemProvidedDelegationConnector;
import de.uka.ipd.sdq.pcm.system.SystemProvidedRole;
import de.uka.ipd.sdq.pcm.system.SystemRequiredDelegationConnector;
import de.uka.ipd.sdq.pcm.system.SystemRequiredRole;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;
import de.uka.ipd.sdq.pcm.usagemodel.impl.UsagemodelPackageImpl;
import de.uka.ipd.sdq.probfunction.ProbfunctionPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SystemPackageImpl extends EPackageImpl implements SystemPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass systemRequiredRoleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass systemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass systemProvidedDelegationConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass systemRequiredDelegationConnectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass specifiedTimeConsumptionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass systemProvidedRoleEClass = null;

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
	 * @see de.uka.ipd.sdq.pcm.system.SystemPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SystemPackageImpl() {
		super(eNS_URI, SystemFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SystemPackage init() {
		if (isInited) return (SystemPackage)EPackage.Registry.INSTANCE.getEPackage(SystemPackage.eNS_URI);

		// Obtain or create and register package
		SystemPackageImpl theSystemPackage = (SystemPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof SystemPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new SystemPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		IdentifierPackage.eINSTANCE.eClass();
		ProbfunctionPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		AssemblyPackageImpl theAssemblyPackage = (AssemblyPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AssemblyPackage.eNS_URI) instanceof AssemblyPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AssemblyPackage.eNS_URI) : AssemblyPackage.eINSTANCE);
		StochasticsPackageImpl theStochasticsPackage = (StochasticsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(StochasticsPackage.eNS_URI) instanceof StochasticsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(StochasticsPackage.eNS_URI) : StochasticsPackage.eINSTANCE);
		EntityPackageImpl theEntityPackage = (EntityPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EntityPackage.eNS_URI) instanceof EntityPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EntityPackage.eNS_URI) : EntityPackage.eINSTANCE);
		ConnectorsPackageImpl theConnectorsPackage = (ConnectorsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ConnectorsPackage.eNS_URI) instanceof ConnectorsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ConnectorsPackage.eNS_URI) : ConnectorsPackage.eINSTANCE);
		RepositoryPackageImpl theRepositoryPackage = (RepositoryPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RepositoryPackage.eNS_URI) instanceof RepositoryPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RepositoryPackage.eNS_URI) : RepositoryPackage.eINSTANCE);
		ProtocolPackageImpl theProtocolPackage = (ProtocolPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ProtocolPackage.eNS_URI) instanceof ProtocolPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ProtocolPackage.eNS_URI) : ProtocolPackage.eINSTANCE);
		SeffPackageImpl theSeffPackage = (SeffPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SeffPackage.eNS_URI) instanceof SeffPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SeffPackage.eNS_URI) : SeffPackage.eINSTANCE);
		ResourcetypePackageImpl theResourcetypePackage = (ResourcetypePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ResourcetypePackage.eNS_URI) instanceof ResourcetypePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ResourcetypePackage.eNS_URI) : ResourcetypePackage.eINSTANCE);
		ParameterPackageImpl theParameterPackage = (ParameterPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ParameterPackage.eNS_URI) instanceof ParameterPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ParameterPackage.eNS_URI) : ParameterPackage.eINSTANCE);
		AllocationPackageImpl theAllocationPackage = (AllocationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AllocationPackage.eNS_URI) instanceof AllocationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AllocationPackage.eNS_URI) : AllocationPackage.eINSTANCE);
		ResourceenvironmentPackageImpl theResourceenvironmentPackage = (ResourceenvironmentPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ResourceenvironmentPackage.eNS_URI) instanceof ResourceenvironmentPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ResourceenvironmentPackage.eNS_URI) : ResourceenvironmentPackage.eINSTANCE);
		UsagemodelPackageImpl theUsagemodelPackage = (UsagemodelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(UsagemodelPackage.eNS_URI) instanceof UsagemodelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(UsagemodelPackage.eNS_URI) : UsagemodelPackage.eINSTANCE);

		// Create package meta-data objects
		theSystemPackage.createPackageContents();
		theAssemblyPackage.createPackageContents();
		theStochasticsPackage.createPackageContents();
		theEntityPackage.createPackageContents();
		theConnectorsPackage.createPackageContents();
		theRepositoryPackage.createPackageContents();
		theProtocolPackage.createPackageContents();
		theSeffPackage.createPackageContents();
		theResourcetypePackage.createPackageContents();
		theParameterPackage.createPackageContents();
		theAllocationPackage.createPackageContents();
		theResourceenvironmentPackage.createPackageContents();
		theUsagemodelPackage.createPackageContents();

		// Initialize created meta-data
		theSystemPackage.initializePackageContents();
		theAssemblyPackage.initializePackageContents();
		theStochasticsPackage.initializePackageContents();
		theEntityPackage.initializePackageContents();
		theConnectorsPackage.initializePackageContents();
		theRepositoryPackage.initializePackageContents();
		theProtocolPackage.initializePackageContents();
		theSeffPackage.initializePackageContents();
		theResourcetypePackage.initializePackageContents();
		theParameterPackage.initializePackageContents();
		theAllocationPackage.initializePackageContents();
		theResourceenvironmentPackage.initializePackageContents();
		theUsagemodelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSystemPackage.freeze();

		return theSystemPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSystemRequiredRole() {
		return systemRequiredRoleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemRequiredRole_System_SystemRequiredRole() {
		return (EReference)systemRequiredRoleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemRequiredRole_RequiredDelegationConnector_SystemRequiredRole() {
		return (EReference)systemRequiredRoleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemRequiredRole_Interface_SystemRequiredRole() {
		return (EReference)systemRequiredRoleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemRequiredRole_SpecifiedTimeConsumption_SystemRequiredRole() {
		return (EReference)systemRequiredRoleEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSystem() {
		return systemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystem_SystemProvidedRole_System() {
		return (EReference)systemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystem_Assembly_System() {
		return (EReference)systemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystem_ProvidedDelegationConnector_System() {
		return (EReference)systemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystem_RequiredDelegationConnector_System() {
		return (EReference)systemEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystem_Allocation_System() {
		return (EReference)systemEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystem_SystemRequiredRole_System() {
		return (EReference)systemEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSystemProvidedDelegationConnector() {
		return systemProvidedDelegationConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemProvidedDelegationConnector_SystemProvidedRole_SystemProvidedDelegationConnector() {
		return (EReference)systemProvidedDelegationConnectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemProvidedDelegationConnector_AssemblyContext_SystemProvidedDelegationConnector() {
		return (EReference)systemProvidedDelegationConnectorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemProvidedDelegationConnector_ComponentProvidedRole_SystemProvidedDelegationConnector() {
		return (EReference)systemProvidedDelegationConnectorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSystemRequiredDelegationConnector() {
		return systemRequiredDelegationConnectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemRequiredDelegationConnector_SystemRequiredRole_SystemRequiredDelegationConnector() {
		return (EReference)systemRequiredDelegationConnectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemRequiredDelegationConnector_AssemblyContext_SystemRequiredDelegationConnector() {
		return (EReference)systemRequiredDelegationConnectorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemRequiredDelegationConnector_RequiredRole_SystemRequiredDelegationConnector() {
		return (EReference)systemRequiredDelegationConnectorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSpecifiedTimeConsumption() {
		return specifiedTimeConsumptionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpecifiedTimeConsumption_Signature_SpecifiedTimeConsumption() {
		return (EReference)specifiedTimeConsumptionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSystemProvidedRole() {
		return systemProvidedRoleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemProvidedRole_System_SystemProvidedRole() {
		return (EReference)systemProvidedRoleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemProvidedRole_ProvidedDelegationConnector_SystemProvidedRole() {
		return (EReference)systemProvidedRoleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystemProvidedRole_Interface_SystemProvidedRole() {
		return (EReference)systemProvidedRoleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SystemFactory getSystemFactory() {
		return (SystemFactory)getEFactoryInstance();
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
		systemRequiredRoleEClass = createEClass(SYSTEM_REQUIRED_ROLE);
		createEReference(systemRequiredRoleEClass, SYSTEM_REQUIRED_ROLE__SYSTEM_SYSTEM_REQUIRED_ROLE);
		createEReference(systemRequiredRoleEClass, SYSTEM_REQUIRED_ROLE__REQUIRED_DELEGATION_CONNECTOR_SYSTEM_REQUIRED_ROLE);
		createEReference(systemRequiredRoleEClass, SYSTEM_REQUIRED_ROLE__INTERFACE_SYSTEM_REQUIRED_ROLE);
		createEReference(systemRequiredRoleEClass, SYSTEM_REQUIRED_ROLE__SPECIFIED_TIME_CONSUMPTION_SYSTEM_REQUIRED_ROLE);

		systemEClass = createEClass(SYSTEM);
		createEReference(systemEClass, SYSTEM__SYSTEM_PROVIDED_ROLE_SYSTEM);
		createEReference(systemEClass, SYSTEM__ASSEMBLY_SYSTEM);
		createEReference(systemEClass, SYSTEM__PROVIDED_DELEGATION_CONNECTOR_SYSTEM);
		createEReference(systemEClass, SYSTEM__REQUIRED_DELEGATION_CONNECTOR_SYSTEM);
		createEReference(systemEClass, SYSTEM__ALLOCATION_SYSTEM);
		createEReference(systemEClass, SYSTEM__SYSTEM_REQUIRED_ROLE_SYSTEM);

		systemProvidedDelegationConnectorEClass = createEClass(SYSTEM_PROVIDED_DELEGATION_CONNECTOR);
		createEReference(systemProvidedDelegationConnectorEClass, SYSTEM_PROVIDED_DELEGATION_CONNECTOR__SYSTEM_PROVIDED_ROLE_SYSTEM_PROVIDED_DELEGATION_CONNECTOR);
		createEReference(systemProvidedDelegationConnectorEClass, SYSTEM_PROVIDED_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SYSTEM_PROVIDED_DELEGATION_CONNECTOR);
		createEReference(systemProvidedDelegationConnectorEClass, SYSTEM_PROVIDED_DELEGATION_CONNECTOR__COMPONENT_PROVIDED_ROLE_SYSTEM_PROVIDED_DELEGATION_CONNECTOR);

		systemRequiredDelegationConnectorEClass = createEClass(SYSTEM_REQUIRED_DELEGATION_CONNECTOR);
		createEReference(systemRequiredDelegationConnectorEClass, SYSTEM_REQUIRED_DELEGATION_CONNECTOR__SYSTEM_REQUIRED_ROLE_SYSTEM_REQUIRED_DELEGATION_CONNECTOR);
		createEReference(systemRequiredDelegationConnectorEClass, SYSTEM_REQUIRED_DELEGATION_CONNECTOR__ASSEMBLY_CONTEXT_SYSTEM_REQUIRED_DELEGATION_CONNECTOR);
		createEReference(systemRequiredDelegationConnectorEClass, SYSTEM_REQUIRED_DELEGATION_CONNECTOR__REQUIRED_ROLE_SYSTEM_REQUIRED_DELEGATION_CONNECTOR);

		specifiedTimeConsumptionEClass = createEClass(SPECIFIED_TIME_CONSUMPTION);
		createEReference(specifiedTimeConsumptionEClass, SPECIFIED_TIME_CONSUMPTION__SIGNATURE_SPECIFIED_TIME_CONSUMPTION);

		systemProvidedRoleEClass = createEClass(SYSTEM_PROVIDED_ROLE);
		createEReference(systemProvidedRoleEClass, SYSTEM_PROVIDED_ROLE__SYSTEM_SYSTEM_PROVIDED_ROLE);
		createEReference(systemProvidedRoleEClass, SYSTEM_PROVIDED_ROLE__PROVIDED_DELEGATION_CONNECTOR_SYSTEM_PROVIDED_ROLE);
		createEReference(systemProvidedRoleEClass, SYSTEM_PROVIDED_ROLE__INTERFACE_SYSTEM_PROVIDED_ROLE);
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
		EntityPackage theEntityPackage = (EntityPackage)EPackage.Registry.INSTANCE.getEPackage(EntityPackage.eNS_URI);
		RepositoryPackage theRepositoryPackage = (RepositoryPackage)EPackage.Registry.INSTANCE.getEPackage(RepositoryPackage.eNS_URI);
		AssemblyPackage theAssemblyPackage = (AssemblyPackage)EPackage.Registry.INSTANCE.getEPackage(AssemblyPackage.eNS_URI);
		AllocationPackage theAllocationPackage = (AllocationPackage)EPackage.Registry.INSTANCE.getEPackage(AllocationPackage.eNS_URI);
		StochasticsPackage theStochasticsPackage = (StochasticsPackage)EPackage.Registry.INSTANCE.getEPackage(StochasticsPackage.eNS_URI);

		// Add supertypes to classes
		systemRequiredRoleEClass.getESuperTypes().add(theEntityPackage.getEntity());
		systemEClass.getESuperTypes().add(theEntityPackage.getEntity());
		specifiedTimeConsumptionEClass.getESuperTypes().add(theStochasticsPackage.getRandomVariable());
		systemProvidedRoleEClass.getESuperTypes().add(theEntityPackage.getEntity());

		// Initialize classes and features; add operations and parameters
		initEClass(systemRequiredRoleEClass, SystemRequiredRole.class, "SystemRequiredRole", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSystemRequiredRole_System_SystemRequiredRole(), this.getSystem(), this.getSystem_SystemRequiredRole_System(), "system_SystemRequiredRole", null, 1, 1, SystemRequiredRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSystemRequiredRole_RequiredDelegationConnector_SystemRequiredRole(), this.getSystemRequiredDelegationConnector(), this.getSystemRequiredDelegationConnector_SystemRequiredRole_SystemRequiredDelegationConnector(), "requiredDelegationConnector_SystemRequiredRole", null, 1, 1, SystemRequiredRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSystemRequiredRole_Interface_SystemRequiredRole(), theRepositoryPackage.getInterface(), null, "interface_SystemRequiredRole", null, 1, 1, SystemRequiredRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSystemRequiredRole_SpecifiedTimeConsumption_SystemRequiredRole(), this.getSpecifiedTimeConsumption(), null, "specifiedTimeConsumption_SystemRequiredRole", null, 0, -1, SystemRequiredRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(systemEClass, de.uka.ipd.sdq.pcm.system.System.class, "System", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSystem_SystemProvidedRole_System(), this.getSystemProvidedRole(), this.getSystemProvidedRole_System_SystemProvidedRole(), "systemProvidedRole_System", null, 0, -1, de.uka.ipd.sdq.pcm.system.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSystem_Assembly_System(), theAssemblyPackage.getAssembly(), null, "assembly_System", null, 1, 1, de.uka.ipd.sdq.pcm.system.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSystem_ProvidedDelegationConnector_System(), this.getSystemProvidedDelegationConnector(), null, "providedDelegationConnector_System", null, 0, -1, de.uka.ipd.sdq.pcm.system.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSystem_RequiredDelegationConnector_System(), this.getSystemRequiredDelegationConnector(), null, "requiredDelegationConnector_System", null, 0, -1, de.uka.ipd.sdq.pcm.system.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSystem_Allocation_System(), theAllocationPackage.getAllocation(), null, "allocation_System", null, 1, 1, de.uka.ipd.sdq.pcm.system.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSystem_SystemRequiredRole_System(), this.getSystemRequiredRole(), this.getSystemRequiredRole_System_SystemRequiredRole(), "systemRequiredRole_System", null, 0, -1, de.uka.ipd.sdq.pcm.system.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(systemProvidedDelegationConnectorEClass, SystemProvidedDelegationConnector.class, "SystemProvidedDelegationConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSystemProvidedDelegationConnector_SystemProvidedRole_SystemProvidedDelegationConnector(), this.getSystemProvidedRole(), this.getSystemProvidedRole_ProvidedDelegationConnector_SystemProvidedRole(), "systemProvidedRole_SystemProvidedDelegationConnector", null, 1, 1, SystemProvidedDelegationConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSystemProvidedDelegationConnector_AssemblyContext_SystemProvidedDelegationConnector(), theAssemblyPackage.getAssemblyContext(), null, "assemblyContext_SystemProvidedDelegationConnector", null, 1, 1, SystemProvidedDelegationConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSystemProvidedDelegationConnector_ComponentProvidedRole_SystemProvidedDelegationConnector(), theRepositoryPackage.getProvidedRole(), null, "componentProvidedRole_SystemProvidedDelegationConnector", null, 1, 1, SystemProvidedDelegationConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(systemRequiredDelegationConnectorEClass, SystemRequiredDelegationConnector.class, "SystemRequiredDelegationConnector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSystemRequiredDelegationConnector_SystemRequiredRole_SystemRequiredDelegationConnector(), this.getSystemRequiredRole(), this.getSystemRequiredRole_RequiredDelegationConnector_SystemRequiredRole(), "systemRequiredRole_SystemRequiredDelegationConnector", null, 1, 1, SystemRequiredDelegationConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSystemRequiredDelegationConnector_AssemblyContext_SystemRequiredDelegationConnector(), theAssemblyPackage.getAssemblyContext(), null, "assemblyContext_SystemRequiredDelegationConnector", null, 1, 1, SystemRequiredDelegationConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSystemRequiredDelegationConnector_RequiredRole_SystemRequiredDelegationConnector(), theRepositoryPackage.getRequiredRole(), null, "requiredRole_SystemRequiredDelegationConnector", null, 1, 1, SystemRequiredDelegationConnector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(specifiedTimeConsumptionEClass, SpecifiedTimeConsumption.class, "SpecifiedTimeConsumption", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSpecifiedTimeConsumption_Signature_SpecifiedTimeConsumption(), theRepositoryPackage.getSignature(), null, "signature_SpecifiedTimeConsumption", null, 1, 1, SpecifiedTimeConsumption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(systemProvidedRoleEClass, SystemProvidedRole.class, "SystemProvidedRole", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSystemProvidedRole_System_SystemProvidedRole(), this.getSystem(), this.getSystem_SystemProvidedRole_System(), "system_SystemProvidedRole", null, 1, 1, SystemProvidedRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSystemProvidedRole_ProvidedDelegationConnector_SystemProvidedRole(), this.getSystemProvidedDelegationConnector(), this.getSystemProvidedDelegationConnector_SystemProvidedRole_SystemProvidedDelegationConnector(), "providedDelegationConnector_SystemProvidedRole", null, 1, 1, SystemProvidedRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSystemProvidedRole_Interface_SystemProvidedRole(), theRepositoryPackage.getInterface(), null, "interface_SystemProvidedRole", null, 1, 1, SystemProvidedRole.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //SystemPackageImpl
