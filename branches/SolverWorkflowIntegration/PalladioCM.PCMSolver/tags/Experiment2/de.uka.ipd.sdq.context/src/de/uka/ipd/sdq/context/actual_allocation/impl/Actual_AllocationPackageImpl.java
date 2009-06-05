/**
 * Copyright 2006, SDQ Group, University Karlsruhe (TH)
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.actual_allocation.impl;

import de.uka.ipd.sdq.context.actual_allocation.ActualAllocation;
import de.uka.ipd.sdq.context.actual_allocation.ActualAllocationContext;
import de.uka.ipd.sdq.context.actual_allocation.ActualResourceDemand;
import de.uka.ipd.sdq.context.actual_allocation.Actual_AllocationFactory;
import de.uka.ipd.sdq.context.actual_allocation.Actual_AllocationPackage;

import de.uka.ipd.sdq.context.usage.UsagePackage;

import de.uka.ipd.sdq.context.usage.impl.UsagePackageImpl;

import de.uka.ipd.sdq.identifier.IdentifierPackage;

import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;

import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;

import de.uka.ipd.sdq.pcm.core.connectors.ConnectorsPackage;

import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;

import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;

import de.uka.ipd.sdq.pcm.protocol.ProtocolPackage;

import de.uka.ipd.sdq.pcm.qosannotations.QosannotationsPackage;

import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;

import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;

import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;

import de.uka.ipd.sdq.pcm.seff.SeffPackage;

import de.uka.ipd.sdq.pcm.system.SystemPackage;

import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;

import de.uka.ipd.sdq.probfunction.ProbfunctionPackage;

import de.uka.ipd.sdq.stoex.StoexPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class Actual_AllocationPackageImpl extends EPackageImpl implements Actual_AllocationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2006, SDQ Group, University Karlsruhe (TH)";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actualAllocationContextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actualResourceDemandEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actualAllocationEClass = null;

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
	 * @see de.uka.ipd.sdq.context.actual_allocation.Actual_AllocationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private Actual_AllocationPackageImpl() {
		super(eNS_URI, Actual_AllocationFactory.eINSTANCE);
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
	public static Actual_AllocationPackage init() {
		if (isInited) return (Actual_AllocationPackage)EPackage.Registry.INSTANCE.getEPackage(Actual_AllocationPackage.eNS_URI);

		// Obtain or create and register package
		Actual_AllocationPackageImpl theActual_AllocationPackage = (Actual_AllocationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof Actual_AllocationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new Actual_AllocationPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		IdentifierPackage.eINSTANCE.eClass();
		EntityPackage.eINSTANCE.eClass();
		ConnectorsPackage.eINSTANCE.eClass();
		CompositionPackage.eINSTANCE.eClass();
		RepositoryPackage.eINSTANCE.eClass();
		ProtocolPackage.eINSTANCE.eClass();
		ParameterPackage.eINSTANCE.eClass();
		SeffPackage.eINSTANCE.eClass();
		ResourcetypePackage.eINSTANCE.eClass();
		AllocationPackage.eINSTANCE.eClass();
		ResourceenvironmentPackage.eINSTANCE.eClass();
		SystemPackage.eINSTANCE.eClass();
		QosannotationsPackage.eINSTANCE.eClass();
		UsagemodelPackage.eINSTANCE.eClass();
		ProbfunctionPackage.eINSTANCE.eClass();
		StoexPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		UsagePackageImpl theUsagePackage = (UsagePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(UsagePackage.eNS_URI) instanceof UsagePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(UsagePackage.eNS_URI) : UsagePackage.eINSTANCE);

		// Create package meta-data objects
		theActual_AllocationPackage.createPackageContents();
		theUsagePackage.createPackageContents();

		// Initialize created meta-data
		theActual_AllocationPackage.initializePackageContents();
		theUsagePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theActual_AllocationPackage.freeze();

		return theActual_AllocationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActualAllocationContext() {
		return actualAllocationContextEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActualAllocationContext_ActualResourceDemands_ActualAllocationContext() {
		return (EReference)actualAllocationContextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActualAllocationContext_UsageContext_ActualAllocationContext() {
		return (EReference)actualAllocationContextEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActualResourceDemand() {
		return actualResourceDemandEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActualResourceDemand_ParametricResourceDemand_ActualResourceDemand() {
		return (EReference)actualResourceDemandEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActualAllocation() {
		return actualAllocationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActualAllocation_ActualAllocationContexts_ActualAllocation() {
		return (EReference)actualAllocationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Actual_AllocationFactory getActual_AllocationFactory() {
		return (Actual_AllocationFactory)getEFactoryInstance();
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
		actualAllocationContextEClass = createEClass(ACTUAL_ALLOCATION_CONTEXT);
		createEReference(actualAllocationContextEClass, ACTUAL_ALLOCATION_CONTEXT__ACTUAL_RESOURCE_DEMANDS_ACTUAL_ALLOCATION_CONTEXT);
		createEReference(actualAllocationContextEClass, ACTUAL_ALLOCATION_CONTEXT__USAGE_CONTEXT_ACTUAL_ALLOCATION_CONTEXT);

		actualResourceDemandEClass = createEClass(ACTUAL_RESOURCE_DEMAND);
		createEReference(actualResourceDemandEClass, ACTUAL_RESOURCE_DEMAND__PARAMETRIC_RESOURCE_DEMAND_ACTUAL_RESOURCE_DEMAND);

		actualAllocationEClass = createEClass(ACTUAL_ALLOCATION);
		createEReference(actualAllocationEClass, ACTUAL_ALLOCATION__ACTUAL_ALLOCATION_CONTEXTS_ACTUAL_ALLOCATION);
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
		UsagePackage theUsagePackage = (UsagePackage)EPackage.Registry.INSTANCE.getEPackage(UsagePackage.eNS_URI);
		StoexPackage theStoexPackage = (StoexPackage)EPackage.Registry.INSTANCE.getEPackage(StoexPackage.eNS_URI);
		SeffPackage theSeffPackage = (SeffPackage)EPackage.Registry.INSTANCE.getEPackage(SeffPackage.eNS_URI);

		// Add supertypes to classes
		actualResourceDemandEClass.getESuperTypes().add(theStoexPackage.getRandomVariable());

		// Initialize classes and features; add operations and parameters
		initEClass(actualAllocationContextEClass, ActualAllocationContext.class, "ActualAllocationContext", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActualAllocationContext_ActualResourceDemands_ActualAllocationContext(), this.getActualResourceDemand(), null, "actualResourceDemands_ActualAllocationContext", null, 0, -1, ActualAllocationContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getActualAllocationContext_UsageContext_ActualAllocationContext(), theUsagePackage.getUsageContext(), null, "usageContext_ActualAllocationContext", null, 1, 1, ActualAllocationContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(actualResourceDemandEClass, ActualResourceDemand.class, "ActualResourceDemand", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActualResourceDemand_ParametricResourceDemand_ActualResourceDemand(), theSeffPackage.getParametricResourceDemand(), null, "parametricResourceDemand_ActualResourceDemand", null, 1, 1, ActualResourceDemand.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(actualAllocationEClass, ActualAllocation.class, "ActualAllocation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActualAllocation_ActualAllocationContexts_ActualAllocation(), this.getActualAllocationContext(), null, "actualAllocationContexts_ActualAllocation", null, 0, -1, ActualAllocation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //Actual_AllocationPackageImpl
