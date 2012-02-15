/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.validation.effort.estimation.spt.impl;

import de.fzi.se.validation.effort.estimation.EstimationPackage;

import de.fzi.se.validation.effort.estimation.spt.SPTEffortEstimationResult;
import de.fzi.se.validation.effort.estimation.spt.SPTFactory;
import de.fzi.se.validation.effort.estimation.spt.SPTPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SPTPackageImpl extends EPackageImpl implements SPTPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sptEffortEstimationResultEClass = null;

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
	 * @see de.fzi.se.validation.effort.estimation.spt.SPTPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SPTPackageImpl() {
		super(eNS_URI, SPTFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link SPTPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SPTPackage init() {
		if (isInited) return (SPTPackage)EPackage.Registry.INSTANCE.getEPackage(SPTPackage.eNS_URI);

		// Obtain or create and register package
		SPTPackageImpl theSPTPackage = (SPTPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SPTPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SPTPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EstimationPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theSPTPackage.createPackageContents();

		// Initialize created meta-data
		theSPTPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSPTPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SPTPackage.eNS_URI, theSPTPackage);
		return theSPTPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSPTEffortEstimationResult() {
		return sptEffortEstimationResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSPTEffortEstimationResult_N() {
		return (EAttribute)sptEffortEstimationResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SPTFactory getSPTFactory() {
		return (SPTFactory)getEFactoryInstance();
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
		sptEffortEstimationResultEClass = createEClass(SPT_EFFORT_ESTIMATION_RESULT);
		createEAttribute(sptEffortEstimationResultEClass, SPT_EFFORT_ESTIMATION_RESULT__N);
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
		EstimationPackage theEstimationPackage = (EstimationPackage)EPackage.Registry.INSTANCE.getEPackage(EstimationPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		sptEffortEstimationResultEClass.getESuperTypes().add(theEstimationPackage.getEffortEstimationResult());

		// Initialize classes and features; add operations and parameters
		initEClass(sptEffortEstimationResultEClass, SPTEffortEstimationResult.class, "SPTEffortEstimationResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSPTEffortEstimationResult_N(), ecorePackage.getEInt(), "n", null, 1, 1, SPTEffortEstimationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //SPTPackageImpl
