/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.extension.impl;

import de.uka.ipd.sdq.capra.CapraPackage;

import de.uka.ipd.sdq.capra.core.CorePackage;

import de.uka.ipd.sdq.capra.core.impl.CorePackageImpl;

import de.uka.ipd.sdq.capra.extension.AcquireAction;
import de.uka.ipd.sdq.capra.extension.ExtensionFactory;
import de.uka.ipd.sdq.capra.extension.ExtensionPackage;
import de.uka.ipd.sdq.capra.extension.PassiveResource;
import de.uka.ipd.sdq.capra.extension.ReleaseAction;
import de.uka.ipd.sdq.capra.extension.SchedulingStrategy;
import de.uka.ipd.sdq.capra.extension.StrongSemaphore;
import de.uka.ipd.sdq.capra.extension.WeakSemaphore;

import de.uka.ipd.sdq.capra.impl.CapraPackageImpl;

import de.uka.ipd.sdq.capra.measurement.MeasurementPackage;

import de.uka.ipd.sdq.capra.measurement.impl.MeasurementPackageImpl;

import de.uka.ipd.sdq.capra.resources.ResourcesPackage;

import de.uka.ipd.sdq.capra.resources.impl.ResourcesPackageImpl;

import de.uka.ipd.sdq.capra.schedulers.SchedulersPackage;

import de.uka.ipd.sdq.capra.schedulers.impl.SchedulersPackageImpl;

import de.uka.ipd.sdq.probfunction.ProbfunctionPackage;

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
public class ExtensionPackageImpl extends EPackageImpl implements ExtensionPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass passiveResourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass acquireActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass releaseActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass weakSemaphoreEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass strongSemaphoreEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass schedulingStrategyEClass = null;

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
	 * @see de.uka.ipd.sdq.capra.extension.ExtensionPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ExtensionPackageImpl() {
		super(eNS_URI, ExtensionFactory.eINSTANCE);
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
	public static ExtensionPackage init() {
		if (isInited) return (ExtensionPackage)EPackage.Registry.INSTANCE.getEPackage(ExtensionPackage.eNS_URI);

		// Obtain or create and register package
		ExtensionPackageImpl theExtensionPackage = (ExtensionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof ExtensionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new ExtensionPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		ProbfunctionPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		CapraPackageImpl theCapraPackage = (CapraPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CapraPackage.eNS_URI) instanceof CapraPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CapraPackage.eNS_URI) : CapraPackage.eINSTANCE);
		CorePackageImpl theCorePackage = (CorePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI) instanceof CorePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI) : CorePackage.eINSTANCE);
		ResourcesPackageImpl theResourcesPackage = (ResourcesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ResourcesPackage.eNS_URI) instanceof ResourcesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ResourcesPackage.eNS_URI) : ResourcesPackage.eINSTANCE);
		SchedulersPackageImpl theSchedulersPackage = (SchedulersPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SchedulersPackage.eNS_URI) instanceof SchedulersPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SchedulersPackage.eNS_URI) : SchedulersPackage.eINSTANCE);
		MeasurementPackageImpl theMeasurementPackage = (MeasurementPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(MeasurementPackage.eNS_URI) instanceof MeasurementPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(MeasurementPackage.eNS_URI) : MeasurementPackage.eINSTANCE);

		// Create package meta-data objects
		theExtensionPackage.createPackageContents();
		theCapraPackage.createPackageContents();
		theCorePackage.createPackageContents();
		theResourcesPackage.createPackageContents();
		theSchedulersPackage.createPackageContents();
		theMeasurementPackage.createPackageContents();

		// Initialize created meta-data
		theExtensionPackage.initializePackageContents();
		theCapraPackage.initializePackageContents();
		theCorePackage.initializePackageContents();
		theResourcesPackage.initializePackageContents();
		theSchedulersPackage.initializePackageContents();
		theMeasurementPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theExtensionPackage.freeze();

		return theExtensionPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPassiveResource() {
		return passiveResourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAcquireAction() {
		return acquireActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAcquireAction_Number() {
		return (EAttribute)acquireActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAcquireAction_Resource() {
		return (EReference)acquireActionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReleaseAction() {
		return releaseActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReleaseAction_Number() {
		return (EAttribute)releaseActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReleaseAction_Resource() {
		return (EReference)releaseActionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWeakSemaphore() {
		return weakSemaphoreEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStrongSemaphore() {
		return strongSemaphoreEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSchedulingStrategy() {
		return schedulingStrategyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExtensionFactory getExtensionFactory() {
		return (ExtensionFactory)getEFactoryInstance();
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
		passiveResourceEClass = createEClass(PASSIVE_RESOURCE);

		acquireActionEClass = createEClass(ACQUIRE_ACTION);
		createEAttribute(acquireActionEClass, ACQUIRE_ACTION__NUMBER);
		createEReference(acquireActionEClass, ACQUIRE_ACTION__RESOURCE);

		releaseActionEClass = createEClass(RELEASE_ACTION);
		createEAttribute(releaseActionEClass, RELEASE_ACTION__NUMBER);
		createEReference(releaseActionEClass, RELEASE_ACTION__RESOURCE);

		weakSemaphoreEClass = createEClass(WEAK_SEMAPHORE);

		strongSemaphoreEClass = createEClass(STRONG_SEMAPHORE);

		schedulingStrategyEClass = createEClass(SCHEDULING_STRATEGY);
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
		ResourcesPackage theResourcesPackage = (ResourcesPackage)EPackage.Registry.INSTANCE.getEPackage(ResourcesPackage.eNS_URI);
		CorePackage theCorePackage = (CorePackage)EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		passiveResourceEClass.getESuperTypes().add(theResourcesPackage.getContentionResource());
		acquireActionEClass.getESuperTypes().add(theCorePackage.getEventAction());
		releaseActionEClass.getESuperTypes().add(theCorePackage.getEventAction());
		weakSemaphoreEClass.getESuperTypes().add(this.getPassiveResource());
		strongSemaphoreEClass.getESuperTypes().add(this.getPassiveResource());

		// Initialize classes and features; add operations and parameters
		initEClass(passiveResourceEClass, PassiveResource.class, "PassiveResource", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(acquireActionEClass, AcquireAction.class, "AcquireAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAcquireAction_Number(), ecorePackage.getEInt(), "number", null, 1, 1, AcquireAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAcquireAction_Resource(), this.getPassiveResource(), null, "resource", null, 1, 1, AcquireAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(releaseActionEClass, ReleaseAction.class, "ReleaseAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getReleaseAction_Number(), ecorePackage.getEInt(), "number", null, 1, 1, ReleaseAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReleaseAction_Resource(), this.getPassiveResource(), null, "resource", null, 1, 1, ReleaseAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(weakSemaphoreEClass, WeakSemaphore.class, "WeakSemaphore", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(strongSemaphoreEClass, StrongSemaphore.class, "StrongSemaphore", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(schedulingStrategyEClass, SchedulingStrategy.class, "SchedulingStrategy", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
	}

} //ExtensionPackageImpl
