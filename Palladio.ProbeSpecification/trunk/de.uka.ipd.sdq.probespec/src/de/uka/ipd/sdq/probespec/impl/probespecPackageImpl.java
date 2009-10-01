/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.probespec.impl;

import de.uka.ipd.sdq.identifier.IdentifierPackage;

import de.uka.ipd.sdq.pipesandfilters.pipesandfiltersPackage;

import de.uka.ipd.sdq.probespec.BinaryCalculator;
import de.uka.ipd.sdq.probespec.CPUDemandCalculator;
import de.uka.ipd.sdq.probespec.CPUDemandProbe;
import de.uka.ipd.sdq.probespec.CPUStateCalculator;
import de.uka.ipd.sdq.probespec.CPUStateProbe;
import de.uka.ipd.sdq.probespec.Calculator;
import de.uka.ipd.sdq.probespec.CurrentTimeProbe;
import de.uka.ipd.sdq.probespec.HDDDemandCalculator;
import de.uka.ipd.sdq.probespec.HDDDemandProbe;
import de.uka.ipd.sdq.probespec.HDDStateCalculator;
import de.uka.ipd.sdq.probespec.HDDStateProbe;
import de.uka.ipd.sdq.probespec.PassiveResourceCalculator;
import de.uka.ipd.sdq.probespec.PassiveResourceStateProbe;
import de.uka.ipd.sdq.probespec.Probe;
import de.uka.ipd.sdq.probespec.ProbeSet;
import de.uka.ipd.sdq.probespec.ProbeSetPosition;
import de.uka.ipd.sdq.probespec.ProbeSpecRepository;
import de.uka.ipd.sdq.probespec.ResponseTimeCalculator;
import de.uka.ipd.sdq.probespec.SEFFParameterCalculator;
import de.uka.ipd.sdq.probespec.SEFFParameterProbe;
import de.uka.ipd.sdq.probespec.StoExCalculator;
import de.uka.ipd.sdq.probespec.StoExProbe;
import de.uka.ipd.sdq.probespec.UnaryCalculator;
import de.uka.ipd.sdq.probespec.WaitingTimeCalculator;
import de.uka.ipd.sdq.probespec.probespecFactory;
import de.uka.ipd.sdq.probespec.probespecPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class probespecPackageImpl extends EPackageImpl implements probespecPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass calculatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass passiveResourceCalculatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass unaryCalculatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass probeSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass probeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass passiveResourceStateProbeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stoExProbeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass seffParameterProbeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass currentTimeProbeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stoExCalculatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass seffParameterCalculatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass responseTimeCalculatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass binaryCalculatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass waitingTimeCalculatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass probeSpecRepositoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cpuStateProbeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hddStateProbeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cpuDemandProbeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hddDemandProbeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hddStateCalculatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cpuStateCalculatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cpuDemandCalculatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass hddDemandCalculatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum probeSetPositionEEnum = null;

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
	 * @see de.uka.ipd.sdq.probespec.probespecPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private probespecPackageImpl() {
		super(eNS_URI, probespecFactory.eINSTANCE);
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
	public static probespecPackage init() {
		if (isInited) return (probespecPackage)EPackage.Registry.INSTANCE.getEPackage(probespecPackage.eNS_URI);

		// Obtain or create and register package
		probespecPackageImpl theprobespecPackage = (probespecPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof probespecPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new probespecPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();
		pipesandfiltersPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theprobespecPackage.createPackageContents();

		// Initialize created meta-data
		theprobespecPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theprobespecPackage.freeze();

		return theprobespecPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCalculator() {
		return calculatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCalculator_Active() {
		return (EAttribute)calculatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCalculator_PipeElement() {
		return (EReference)calculatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPassiveResourceCalculator() {
		return passiveResourceCalculatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUnaryCalculator() {
		return unaryCalculatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUnaryCalculator_ProbeSet() {
		return (EReference)unaryCalculatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProbeSet() {
		return probeSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProbeSet_Probes() {
		return (EReference)probeSetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProbeSet_Position() {
		return (EAttribute)probeSetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProbeSet_AnnotatedElement() {
		return (EReference)probeSetEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProbe() {
		return probeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPassiveResourceStateProbe() {
		return passiveResourceStateProbeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStoExProbe() {
		return stoExProbeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSEFFParameterProbe() {
		return seffParameterProbeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCurrentTimeProbe() {
		return currentTimeProbeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStoExCalculator() {
		return stoExCalculatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSEFFParameterCalculator() {
		return seffParameterCalculatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResponseTimeCalculator() {
		return responseTimeCalculatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBinaryCalculator() {
		return binaryCalculatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBinaryCalculator_ProbeSet() {
		return (EReference)binaryCalculatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getWaitingTimeCalculator() {
		return waitingTimeCalculatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProbeSpecRepository() {
		return probeSpecRepositoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProbeSpecRepository_Calculator() {
		return (EReference)probeSpecRepositoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCPUStateProbe() {
		return cpuStateProbeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHDDStateProbe() {
		return hddStateProbeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCPUDemandProbe() {
		return cpuDemandProbeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHDDDemandProbe() {
		return hddDemandProbeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHDDStateCalculator() {
		return hddStateCalculatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCPUStateCalculator() {
		return cpuStateCalculatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCPUDemandCalculator() {
		return cpuDemandCalculatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getHDDDemandCalculator() {
		return hddDemandCalculatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getProbeSetPosition() {
		return probeSetPositionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public probespecFactory getprobespecFactory() {
		return (probespecFactory)getEFactoryInstance();
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
		calculatorEClass = createEClass(CALCULATOR);
		createEAttribute(calculatorEClass, CALCULATOR__ACTIVE);
		createEReference(calculatorEClass, CALCULATOR__PIPE_ELEMENT);

		passiveResourceCalculatorEClass = createEClass(PASSIVE_RESOURCE_CALCULATOR);

		unaryCalculatorEClass = createEClass(UNARY_CALCULATOR);
		createEReference(unaryCalculatorEClass, UNARY_CALCULATOR__PROBE_SET);

		probeSetEClass = createEClass(PROBE_SET);
		createEReference(probeSetEClass, PROBE_SET__PROBES);
		createEAttribute(probeSetEClass, PROBE_SET__POSITION);
		createEReference(probeSetEClass, PROBE_SET__ANNOTATED_ELEMENT);

		probeEClass = createEClass(PROBE);

		passiveResourceStateProbeEClass = createEClass(PASSIVE_RESOURCE_STATE_PROBE);

		stoExProbeEClass = createEClass(STO_EX_PROBE);

		seffParameterProbeEClass = createEClass(SEFF_PARAMETER_PROBE);

		currentTimeProbeEClass = createEClass(CURRENT_TIME_PROBE);

		stoExCalculatorEClass = createEClass(STO_EX_CALCULATOR);

		seffParameterCalculatorEClass = createEClass(SEFF_PARAMETER_CALCULATOR);

		responseTimeCalculatorEClass = createEClass(RESPONSE_TIME_CALCULATOR);

		binaryCalculatorEClass = createEClass(BINARY_CALCULATOR);
		createEReference(binaryCalculatorEClass, BINARY_CALCULATOR__PROBE_SET);

		waitingTimeCalculatorEClass = createEClass(WAITING_TIME_CALCULATOR);

		probeSpecRepositoryEClass = createEClass(PROBE_SPEC_REPOSITORY);
		createEReference(probeSpecRepositoryEClass, PROBE_SPEC_REPOSITORY__CALCULATOR);

		cpuStateProbeEClass = createEClass(CPU_STATE_PROBE);

		hddStateProbeEClass = createEClass(HDD_STATE_PROBE);

		cpuDemandProbeEClass = createEClass(CPU_DEMAND_PROBE);

		hddDemandProbeEClass = createEClass(HDD_DEMAND_PROBE);

		hddStateCalculatorEClass = createEClass(HDD_STATE_CALCULATOR);

		cpuStateCalculatorEClass = createEClass(CPU_STATE_CALCULATOR);

		cpuDemandCalculatorEClass = createEClass(CPU_DEMAND_CALCULATOR);

		hddDemandCalculatorEClass = createEClass(HDD_DEMAND_CALCULATOR);

		// Create enums
		probeSetPositionEEnum = createEEnum(PROBE_SET_POSITION);
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
		IdentifierPackage theIdentifierPackage = (IdentifierPackage)EPackage.Registry.INSTANCE.getEPackage(IdentifierPackage.eNS_URI);
		pipesandfiltersPackage thepipesandfiltersPackage = (pipesandfiltersPackage)EPackage.Registry.INSTANCE.getEPackage(pipesandfiltersPackage.eNS_URI);
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		calculatorEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
		passiveResourceCalculatorEClass.getESuperTypes().add(this.getUnaryCalculator());
		unaryCalculatorEClass.getESuperTypes().add(this.getCalculator());
		probeSetEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
		probeEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
		passiveResourceStateProbeEClass.getESuperTypes().add(this.getProbe());
		stoExProbeEClass.getESuperTypes().add(this.getProbe());
		seffParameterProbeEClass.getESuperTypes().add(this.getProbe());
		currentTimeProbeEClass.getESuperTypes().add(this.getProbe());
		stoExCalculatorEClass.getESuperTypes().add(this.getUnaryCalculator());
		seffParameterCalculatorEClass.getESuperTypes().add(this.getUnaryCalculator());
		responseTimeCalculatorEClass.getESuperTypes().add(this.getBinaryCalculator());
		binaryCalculatorEClass.getESuperTypes().add(this.getCalculator());
		waitingTimeCalculatorEClass.getESuperTypes().add(this.getBinaryCalculator());
		cpuStateProbeEClass.getESuperTypes().add(this.getProbe());
		hddStateProbeEClass.getESuperTypes().add(this.getProbe());
		cpuDemandProbeEClass.getESuperTypes().add(this.getProbe());
		hddDemandProbeEClass.getESuperTypes().add(this.getProbe());
		hddStateCalculatorEClass.getESuperTypes().add(this.getUnaryCalculator());
		cpuStateCalculatorEClass.getESuperTypes().add(this.getUnaryCalculator());
		cpuDemandCalculatorEClass.getESuperTypes().add(this.getUnaryCalculator());
		hddDemandCalculatorEClass.getESuperTypes().add(this.getUnaryCalculator());

		// Initialize classes and features; add operations and parameters
		initEClass(calculatorEClass, Calculator.class, "Calculator", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCalculator_Active(), ecorePackage.getEBoolean(), "active", "true", 1, 1, Calculator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCalculator_PipeElement(), thepipesandfiltersPackage.getPipeElement(), null, "pipeElement", null, 0, 1, Calculator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(passiveResourceCalculatorEClass, PassiveResourceCalculator.class, "PassiveResourceCalculator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(unaryCalculatorEClass, UnaryCalculator.class, "UnaryCalculator", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUnaryCalculator_ProbeSet(), this.getProbeSet(), null, "probeSet", null, 1, 1, UnaryCalculator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(probeSetEClass, ProbeSet.class, "ProbeSet", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProbeSet_Probes(), this.getProbe(), null, "probes", null, 1, -1, ProbeSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getProbeSet_Position(), this.getProbeSetPosition(), "position", null, 1, 1, ProbeSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getProbeSet_AnnotatedElement(), theEcorePackage.getEObject(), null, "annotatedElement", null, 1, 1, ProbeSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(probeEClass, Probe.class, "Probe", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(passiveResourceStateProbeEClass, PassiveResourceStateProbe.class, "PassiveResourceStateProbe", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(stoExProbeEClass, StoExProbe.class, "StoExProbe", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(seffParameterProbeEClass, SEFFParameterProbe.class, "SEFFParameterProbe", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(currentTimeProbeEClass, CurrentTimeProbe.class, "CurrentTimeProbe", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(stoExCalculatorEClass, StoExCalculator.class, "StoExCalculator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(seffParameterCalculatorEClass, SEFFParameterCalculator.class, "SEFFParameterCalculator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(responseTimeCalculatorEClass, ResponseTimeCalculator.class, "ResponseTimeCalculator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(binaryCalculatorEClass, BinaryCalculator.class, "BinaryCalculator", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBinaryCalculator_ProbeSet(), this.getProbeSet(), null, "probeSet", null, 2, 2, BinaryCalculator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(waitingTimeCalculatorEClass, WaitingTimeCalculator.class, "WaitingTimeCalculator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(probeSpecRepositoryEClass, ProbeSpecRepository.class, "ProbeSpecRepository", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProbeSpecRepository_Calculator(), this.getCalculator(), null, "calculator", null, 0, -1, ProbeSpecRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(cpuStateProbeEClass, CPUStateProbe.class, "CPUStateProbe", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(hddStateProbeEClass, HDDStateProbe.class, "HDDStateProbe", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cpuDemandProbeEClass, CPUDemandProbe.class, "CPUDemandProbe", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(hddDemandProbeEClass, HDDDemandProbe.class, "HDDDemandProbe", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(hddStateCalculatorEClass, HDDStateCalculator.class, "HDDStateCalculator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cpuStateCalculatorEClass, CPUStateCalculator.class, "CPUStateCalculator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cpuDemandCalculatorEClass, CPUDemandCalculator.class, "CPUDemandCalculator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(hddDemandCalculatorEClass, HDDDemandCalculator.class, "HDDDemandCalculator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(probeSetPositionEEnum, ProbeSetPosition.class, "ProbeSetPosition");
		addEEnumLiteral(probeSetPositionEEnum, ProbeSetPosition.BEFORE);
		addEEnumLiteral(probeSetPositionEEnum, ProbeSetPosition.AFTER);
		addEEnumLiteral(probeSetPositionEEnum, ProbeSetPosition.NONE);

		// Create resource
		createResource(eNS_URI);
	}

} //probespecPackageImpl
