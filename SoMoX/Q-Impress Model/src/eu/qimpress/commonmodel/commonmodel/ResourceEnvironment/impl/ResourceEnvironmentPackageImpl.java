/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package eu.qimpress.commonmodel.commonmodel.ResourceEnvironment.impl;

import eu.qimpress.commonmodel.commonmodel.Allocation.AllocationPackage;

import eu.qimpress.commonmodel.commonmodel.Allocation.impl.AllocationPackageImpl;

import eu.qimpress.commonmodel.commonmodel.Behavior.BehaviorPackage;

import eu.qimpress.commonmodel.commonmodel.Behavior.impl.BehaviorPackageImpl;

import eu.qimpress.commonmodel.commonmodel.ResourceEnvironment.Node;
import eu.qimpress.commonmodel.commonmodel.ResourceEnvironment.ResourceEnvironmentFactory;
import eu.qimpress.commonmodel.commonmodel.ResourceEnvironment.ResourceEnvironmentPackage;

import eu.qimpress.commonmodel.commonmodel.StaticStructure.StaticStructurePackage;

import eu.qimpress.commonmodel.commonmodel.StaticStructure.impl.StaticStructurePackageImpl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ResourceEnvironmentPackageImpl extends EPackageImpl implements ResourceEnvironmentPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodeEClass = null;

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
	 * @see eu.qimpress.commonmodel.commonmodel.ResourceEnvironment.ResourceEnvironmentPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ResourceEnvironmentPackageImpl() {
		super(eNS_URI, ResourceEnvironmentFactory.eINSTANCE);
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
	public static ResourceEnvironmentPackage init() {
		if (isInited) return (ResourceEnvironmentPackage)EPackage.Registry.INSTANCE.getEPackage(ResourceEnvironmentPackage.eNS_URI);

		// Obtain or create and register package
		ResourceEnvironmentPackageImpl theResourceEnvironmentPackage = (ResourceEnvironmentPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof ResourceEnvironmentPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new ResourceEnvironmentPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		AllocationPackageImpl theAllocationPackage = (AllocationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AllocationPackage.eNS_URI) instanceof AllocationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AllocationPackage.eNS_URI) : AllocationPackage.eINSTANCE);
		BehaviorPackageImpl theBehaviorPackage = (BehaviorPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(BehaviorPackage.eNS_URI) instanceof BehaviorPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(BehaviorPackage.eNS_URI) : BehaviorPackage.eINSTANCE);
		StaticStructurePackageImpl theStaticStructurePackage = (StaticStructurePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(StaticStructurePackage.eNS_URI) instanceof StaticStructurePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(StaticStructurePackage.eNS_URI) : StaticStructurePackage.eINSTANCE);

		// Create package meta-data objects
		theResourceEnvironmentPackage.createPackageContents();
		theAllocationPackage.createPackageContents();
		theBehaviorPackage.createPackageContents();
		theStaticStructurePackage.createPackageContents();

		// Initialize created meta-data
		theResourceEnvironmentPackage.initializePackageContents();
		theAllocationPackage.initializePackageContents();
		theBehaviorPackage.initializePackageContents();
		theStaticStructurePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theResourceEnvironmentPackage.freeze();

		return theResourceEnvironmentPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNode() {
		return nodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceEnvironmentFactory getResourceEnvironmentFactory() {
		return (ResourceEnvironmentFactory)getEFactoryInstance();
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
		nodeEClass = createEClass(NODE);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(nodeEClass, Node.class, "Node", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //ResourceEnvironmentPackageImpl
