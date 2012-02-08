/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.validation.effort.estimation.impl;

import de.fzi.se.validation.effort.estimation.EffortEstimationResult;
import de.fzi.se.validation.effort.estimation.EstimationFactory;
import de.fzi.se.validation.effort.estimation.EstimationPackage;

import de.uka.ipd.sdq.pcm.PcmPackage;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import org.eclipse.emf.ecore.EAttribute;
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
public class EstimationPackageImpl extends EPackageImpl implements EstimationPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass effortEstimationResultEClass = null;

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
	 * @see de.fzi.se.validation.effort.estimation.EstimationPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private EstimationPackageImpl() {
		super(eNS_URI, EstimationFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link EstimationPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static EstimationPackage init() {
		if (isInited) return (EstimationPackage)EPackage.Registry.INSTANCE.getEPackage(EstimationPackage.eNS_URI);

		// Obtain or create and register package
		EstimationPackageImpl theEstimationPackage = (EstimationPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof EstimationPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new EstimationPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		PcmPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theEstimationPackage.createPackageContents();

		// Initialize created meta-data
		theEstimationPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theEstimationPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(EstimationPackage.eNS_URI, theEstimationPackage);
		return theEstimationPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEffortEstimationResult() {
		return effortEstimationResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEffortEstimationResult_NumberTestcases() {
		return (EAttribute)effortEstimationResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEffortEstimationResult_TargetId() {
		return (EAttribute)effortEstimationResultEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEffortEstimationResult_Alpha() {
		return (EAttribute)effortEstimationResultEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getEffortEstimationResult_TargetUri() {
		return (EAttribute)effortEstimationResultEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEffortEstimationResult_ResourceDemandingBehaviour() {
		return (EReference)effortEstimationResultEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EstimationFactory getEstimationFactory() {
		return (EstimationFactory)getEFactoryInstance();
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
		effortEstimationResultEClass = createEClass(EFFORT_ESTIMATION_RESULT);
		createEAttribute(effortEstimationResultEClass, EFFORT_ESTIMATION_RESULT__NUMBER_TESTCASES);
		createEAttribute(effortEstimationResultEClass, EFFORT_ESTIMATION_RESULT__TARGET_ID);
		createEAttribute(effortEstimationResultEClass, EFFORT_ESTIMATION_RESULT__ALPHA);
		createEAttribute(effortEstimationResultEClass, EFFORT_ESTIMATION_RESULT__TARGET_URI);
		createEReference(effortEstimationResultEClass, EFFORT_ESTIMATION_RESULT__RESOURCE_DEMANDING_BEHAVIOUR);
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
		SeffPackage theSeffPackage = (SeffPackage)EPackage.Registry.INSTANCE.getEPackage(SeffPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(effortEstimationResultEClass, EffortEstimationResult.class, "EffortEstimationResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getEffortEstimationResult_NumberTestcases(), ecorePackage.getEInt(), "numberTestcases", null, 1, 1, EffortEstimationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getEffortEstimationResult_TargetId(), ecorePackage.getEString(), "targetId", null, 1, 1, EffortEstimationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getEffortEstimationResult_Alpha(), ecorePackage.getEDouble(), "alpha", null, 1, 1, EffortEstimationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getEffortEstimationResult_TargetUri(), ecorePackage.getEString(), "targetUri", null, 1, 1, EffortEstimationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getEffortEstimationResult_ResourceDemandingBehaviour(), theSeffPackage.getResourceDemandingBehaviour(), null, "resourceDemandingBehaviour", null, 0, 1, EffortEstimationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //EstimationPackageImpl
