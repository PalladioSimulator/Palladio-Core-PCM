/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package eu.qimpress.commonmodel.commonmodel.Allocation.impl;

import eu.qimpress.commonmodel.commonmodel.Allocation.AllocationFactory;
import eu.qimpress.commonmodel.commonmodel.Allocation.AllocationPackage;
import eu.qimpress.commonmodel.commonmodel.Allocation.Service;

import eu.qimpress.commonmodel.commonmodel.Allocation.util.AllocationValidator;

import eu.qimpress.commonmodel.commonmodel.Behavior.BehaviorPackage;

import eu.qimpress.commonmodel.commonmodel.Behavior.impl.BehaviorPackageImpl;

import eu.qimpress.commonmodel.commonmodel.ResourceEnvironment.ResourceEnvironmentPackage;

import eu.qimpress.commonmodel.commonmodel.ResourceEnvironment.impl.ResourceEnvironmentPackageImpl;

import eu.qimpress.commonmodel.commonmodel.StaticStructure.StaticStructurePackage;

import eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.StaticStructurePackageImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AllocationPackageImpl extends EPackageImpl implements AllocationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceEClass = null;

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
	 * @see eu.qimpress.commonmodel.commonmodel.Allocation.AllocationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private AllocationPackageImpl() {
		super(eNS_URI, AllocationFactory.eINSTANCE);
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
	public static AllocationPackage init() {
		if (isInited) return (AllocationPackage)EPackage.Registry.INSTANCE.getEPackage(AllocationPackage.eNS_URI);

		// Obtain or create and register package
		AllocationPackageImpl theAllocationPackage = (AllocationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof AllocationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new AllocationPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		ResourceEnvironmentPackageImpl theResourceEnvironmentPackage = (ResourceEnvironmentPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ResourceEnvironmentPackage.eNS_URI) instanceof ResourceEnvironmentPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ResourceEnvironmentPackage.eNS_URI) : ResourceEnvironmentPackage.eINSTANCE);
		BehaviorPackageImpl theBehaviorPackage = (BehaviorPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(BehaviorPackage.eNS_URI) instanceof BehaviorPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(BehaviorPackage.eNS_URI) : BehaviorPackage.eINSTANCE);
		StaticStructurePackageImpl theStaticStructurePackage = (StaticStructurePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(StaticStructurePackage.eNS_URI) instanceof StaticStructurePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(StaticStructurePackage.eNS_URI) : StaticStructurePackage.eINSTANCE);

		// Create package meta-data objects
		theAllocationPackage.createPackageContents();
		theResourceEnvironmentPackage.createPackageContents();
		theBehaviorPackage.createPackageContents();
		theStaticStructurePackage.createPackageContents();

		// Initialize created meta-data
		theAllocationPackage.initializePackageContents();
		theResourceEnvironmentPackage.initializePackageContents();
		theBehaviorPackage.initializePackageContents();
		theStaticStructurePackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theAllocationPackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return AllocationValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theAllocationPackage.freeze();

		return theAllocationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getService() {
		return serviceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getService_IsBlackBox() {
		return (EAttribute)serviceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getService_Node() {
		return (EReference)serviceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getService_Component() {
		return (EReference)serviceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AllocationFactory getAllocationFactory() {
		return (AllocationFactory)getEFactoryInstance();
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
		serviceEClass = createEClass(SERVICE);
		createEAttribute(serviceEClass, SERVICE__IS_BLACK_BOX);
		createEReference(serviceEClass, SERVICE__NODE);
		createEReference(serviceEClass, SERVICE__COMPONENT);
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
		StaticStructurePackage theStaticStructurePackage = (StaticStructurePackage)EPackage.Registry.INSTANCE.getEPackage(StaticStructurePackage.eNS_URI);
		ResourceEnvironmentPackage theResourceEnvironmentPackage = (ResourceEnvironmentPackage)EPackage.Registry.INSTANCE.getEPackage(ResourceEnvironmentPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		serviceEClass.getESuperTypes().add(theStaticStructurePackage.getCompositeStructure());

		// Initialize classes and features; add operations and parameters
		initEClass(serviceEClass, Service.class, "Service", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getService_IsBlackBox(), ecorePackage.getEBoolean(), "isBlackBox", null, 1, 1, Service.class, !IS_TRANSIENT, IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEReference(getService_Node(), theResourceEnvironmentPackage.getNode(), null, "node", null, 1, -1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getService_Component(), theStaticStructurePackage.getComponentType(), null, "component", null, 1, 1, Service.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		EOperation op = addEOperation(serviceEClass, ecorePackage.getEBoolean(), "isBlackBox", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getEMap());
		EGenericType g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //AllocationPackageImpl
