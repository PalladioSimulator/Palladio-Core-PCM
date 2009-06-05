/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.experiment.impl;

import de.uka.ipd.sdq.capra.CapraPackage;

import de.uka.ipd.sdq.capra.core.CorePackage;

import de.uka.ipd.sdq.capra.core.impl.CorePackageImpl;

import de.uka.ipd.sdq.capra.experiment.Experiment;
import de.uka.ipd.sdq.capra.experiment.ExperimentFactory;
import de.uka.ipd.sdq.capra.experiment.ExperimentPackage;
import de.uka.ipd.sdq.capra.experiment.ResourceUsageSpecification;

import de.uka.ipd.sdq.capra.extension.ExtensionPackage;

import de.uka.ipd.sdq.capra.extension.impl.ExtensionPackageImpl;

import de.uka.ipd.sdq.capra.impl.CapraPackageImpl;

import de.uka.ipd.sdq.capra.measurement.MeasurementPackage;

import de.uka.ipd.sdq.capra.measurement.impl.MeasurementPackageImpl;

import de.uka.ipd.sdq.capra.resources.ResourcesPackage;

import de.uka.ipd.sdq.capra.resources.impl.ResourcesPackageImpl;

import de.uka.ipd.sdq.capra.schedulers.SchedulersPackage;

import de.uka.ipd.sdq.capra.schedulers.impl.SchedulersPackageImpl;

import de.uka.ipd.sdq.identifier.IdentifierPackage;

import de.uka.ipd.sdq.probfunction.ProbfunctionPackage;

import de.uka.ipd.sdq.units.UnitsPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import scheduler.SchedulerPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExperimentPackageImpl extends EPackageImpl implements ExperimentPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceUsageSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass experimentEClass = null;

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
	 * @see de.uka.ipd.sdq.capra.experiment.ExperimentPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ExperimentPackageImpl() {
		super(eNS_URI, ExperimentFactory.eINSTANCE);
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
	public static ExperimentPackage init() {
		if (isInited) return (ExperimentPackage)EPackage.Registry.INSTANCE.getEPackage(ExperimentPackage.eNS_URI);

		// Obtain or create and register package
		ExperimentPackageImpl theExperimentPackage = (ExperimentPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof ExperimentPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new ExperimentPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		IdentifierPackage.eINSTANCE.eClass();
		ProbfunctionPackage.eINSTANCE.eClass();
		SchedulerPackage.eINSTANCE.eClass();
		UnitsPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		CapraPackageImpl theCapraPackage = (CapraPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CapraPackage.eNS_URI) instanceof CapraPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CapraPackage.eNS_URI) : CapraPackage.eINSTANCE);
		CorePackageImpl theCorePackage = (CorePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI) instanceof CorePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI) : CorePackage.eINSTANCE);
		ResourcesPackageImpl theResourcesPackage = (ResourcesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ResourcesPackage.eNS_URI) instanceof ResourcesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ResourcesPackage.eNS_URI) : ResourcesPackage.eINSTANCE);
		SchedulersPackageImpl theSchedulersPackage = (SchedulersPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SchedulersPackage.eNS_URI) instanceof SchedulersPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SchedulersPackage.eNS_URI) : SchedulersPackage.eINSTANCE);
		MeasurementPackageImpl theMeasurementPackage = (MeasurementPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MeasurementPackage.eNS_URI) instanceof MeasurementPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MeasurementPackage.eNS_URI) : MeasurementPackage.eINSTANCE);
		ExtensionPackageImpl theExtensionPackage = (ExtensionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ExtensionPackage.eNS_URI) instanceof ExtensionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ExtensionPackage.eNS_URI) : ExtensionPackage.eINSTANCE);

		// Create package meta-data objects
		theExperimentPackage.createPackageContents();
		theCapraPackage.createPackageContents();
		theCorePackage.createPackageContents();
		theResourcesPackage.createPackageContents();
		theSchedulersPackage.createPackageContents();
		theMeasurementPackage.createPackageContents();
		theExtensionPackage.createPackageContents();

		// Initialize created meta-data
		theExperimentPackage.initializePackageContents();
		theCapraPackage.initializePackageContents();
		theCorePackage.initializePackageContents();
		theResourcesPackage.initializePackageContents();
		theSchedulersPackage.initializePackageContents();
		theMeasurementPackage.initializePackageContents();
		theExtensionPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theExperimentPackage.freeze();

		return theExperimentPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResourceUsageSpecification() {
		return resourceUsageSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceUsageSpecification_Variable() {
		return (EReference)resourceUsageSpecificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceUsageSpecification_ResourceUsageSpecification() {
		return (EReference)resourceUsageSpecificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExperiment() {
		return experimentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExperiment_ResourceUsageSpecification() {
		return (EReference)experimentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExperiment_Name() {
		return (EAttribute)experimentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExperimentFactory getExperimentFactory() {
		return (ExperimentFactory)getEFactoryInstance();
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
		resourceUsageSpecificationEClass = createEClass(RESOURCE_USAGE_SPECIFICATION);
		createEReference(resourceUsageSpecificationEClass, RESOURCE_USAGE_SPECIFICATION__VARIABLE);
		createEReference(resourceUsageSpecificationEClass, RESOURCE_USAGE_SPECIFICATION__RESOURCE_USAGE_SPECIFICATION);

		experimentEClass = createEClass(EXPERIMENT);
		createEReference(experimentEClass, EXPERIMENT__RESOURCE_USAGE_SPECIFICATION);
		createEAttribute(experimentEClass, EXPERIMENT__NAME);
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
		CorePackage theCorePackage = (CorePackage)EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(resourceUsageSpecificationEClass, ResourceUsageSpecification.class, "ResourceUsageSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResourceUsageSpecification_Variable(), theCorePackage.getVariableResourceUsage(), null, "variable", null, 1, 1, ResourceUsageSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getResourceUsageSpecification_ResourceUsageSpecification(), theCorePackage.getResourceUsage(), null, "resourceUsageSpecification", null, 1, 1, ResourceUsageSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(experimentEClass, Experiment.class, "Experiment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExperiment_ResourceUsageSpecification(), this.getResourceUsageSpecification(), null, "resourceUsageSpecification", null, 0, -1, Experiment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getExperiment_Name(), ecorePackage.getEString(), "name", null, 1, 1, Experiment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
	}

} //ExperimentPackageImpl
