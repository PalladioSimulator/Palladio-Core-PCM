/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.simucom.model.simucom.impl;

import de.uka.ipd.sdq.simucom.model.simucom.ServiceEffect;
import de.uka.ipd.sdq.simucom.model.simucom.SimuComModelFactory;
import de.uka.ipd.sdq.simucom.model.simucom.SimuComModelPackage;
import de.uka.ipd.sdq.simucom.model.simucom.SimulatedArchitecture;
import de.uka.ipd.sdq.simucom.model.simucom.SimulatedComponent;
import de.uka.ipd.sdq.simucom.model.simucom.SimulatedMethod;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.impl.EcorePackageImpl;

import org.eclipse.uml2.UML2Package;

import org.eclipse.uml2.impl.UML2PackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SimuComModelPackageImpl extends EPackageImpl implements SimuComModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "(c) by Steffen Becker, 2006"; //$NON-NLS-1$

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simulatedArchitectureEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simulatedComponentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simulatedMethodEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceEffectEClass = null;

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
	 * @see de.uka.ipd.sdq.simucom.model.simucom.SimuComModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SimuComModelPackageImpl() {
		super(eNS_URI, SimuComModelFactory.eINSTANCE);
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
	public static SimuComModelPackage init() {
		if (isInited) return (SimuComModelPackage)EPackage.Registry.INSTANCE.getEPackage(SimuComModelPackage.eNS_URI);

		// Obtain or create and register package
		SimuComModelPackageImpl theSimuComModelPackage = (SimuComModelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof SimuComModelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new SimuComModelPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackageImpl.init();
		UML2PackageImpl.init();

		// Create package meta-data objects
		theSimuComModelPackage.createPackageContents();

		// Initialize created meta-data
		theSimuComModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSimuComModelPackage.freeze();

		return theSimuComModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimulatedArchitecture() {
		return simulatedArchitectureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSimulatedArchitecture_Components() {
		return (EReference)simulatedArchitectureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimulatedComponent() {
		return simulatedComponentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSimulatedComponent_Methods() {
		return (EReference)simulatedComponentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimulatedMethod() {
		return simulatedMethodEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSimulatedMethod_ServiceEffect() {
		return (EReference)simulatedMethodEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSimulatedMethod_Name() {
		return (EAttribute)simulatedMethodEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServiceEffect() {
		return serviceEffectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServiceEffect_Activity() {
		return (EReference)serviceEffectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SimuComModelFactory getSimuComModelFactory() {
		return (SimuComModelFactory)getEFactoryInstance();
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
		simulatedArchitectureEClass = createEClass(SIMULATED_ARCHITECTURE);
		createEReference(simulatedArchitectureEClass, SIMULATED_ARCHITECTURE__COMPONENTS);

		simulatedComponentEClass = createEClass(SIMULATED_COMPONENT);
		createEReference(simulatedComponentEClass, SIMULATED_COMPONENT__METHODS);

		simulatedMethodEClass = createEClass(SIMULATED_METHOD);
		createEReference(simulatedMethodEClass, SIMULATED_METHOD__SERVICE_EFFECT);
		createEAttribute(simulatedMethodEClass, SIMULATED_METHOD__NAME);

		serviceEffectEClass = createEClass(SERVICE_EFFECT);
		createEReference(serviceEffectEClass, SERVICE_EFFECT__ACTIVITY);
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
		UML2PackageImpl theUML2Package = (UML2PackageImpl)EPackage.Registry.INSTANCE.getEPackage(UML2Package.eNS_URI);

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(simulatedArchitectureEClass, SimulatedArchitecture.class, "SimulatedArchitecture", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getSimulatedArchitecture_Components(), this.getSimulatedComponent(), null, "components", null, 0, -1, SimulatedArchitecture.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(simulatedComponentEClass, SimulatedComponent.class, "SimulatedComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getSimulatedComponent_Methods(), this.getSimulatedMethod(), null, "methods", null, 0, -1, SimulatedComponent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$

		initEClass(simulatedMethodEClass, SimulatedMethod.class, "SimulatedMethod", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getSimulatedMethod_ServiceEffect(), this.getServiceEffect(), null, "serviceEffect", null, 1, 1, SimulatedMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$
		initEAttribute(getSimulatedMethod_Name(), ecorePackage.getEString(), "name", "", 0, 1, SimulatedMethod.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		initEClass(serviceEffectEClass, ServiceEffect.class, "ServiceEffect", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS); //$NON-NLS-1$
		initEReference(getServiceEffect_Activity(), theUML2Package.getActivity(), null, "activity", "", 0, -1, ServiceEffect.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED); //$NON-NLS-1$ //$NON-NLS-2$

		// Create resource
		createResource(eNS_URI);
	}

} //SimuComModelPackageImpl
