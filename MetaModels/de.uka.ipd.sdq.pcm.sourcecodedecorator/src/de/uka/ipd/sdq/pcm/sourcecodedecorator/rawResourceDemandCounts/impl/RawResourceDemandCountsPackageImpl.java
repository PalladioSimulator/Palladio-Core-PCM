/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl;

import de.fzi.gast.accesses.accessesPackage;

import de.fzi.gast.annotations.annotationsPackage;

import de.fzi.gast.core.corePackage;

import de.fzi.gast.functions.functionsPackage;

import de.fzi.gast.statements.statementsPackage;

import de.fzi.gast.types.typesPackage;

import de.fzi.gast.variables.variablesPackage;

import de.uka.ipd.sdq.identifier.IdentifierPackage;

import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;

import de.uka.ipd.sdq.pcm.core.CorePackage;

import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;

import de.uka.ipd.sdq.pcm.protocol.ProtocolPackage;

import de.uka.ipd.sdq.pcm.qosannotations.QosannotationsPackage;

import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;

import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;

import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;

import de.uka.ipd.sdq.pcm.seff.SeffPackage;

import de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.GastPcmLinkPackage;

import de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.impl.GastPcmLinkPackageImpl;

import de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLinkRepository.PCMLinkRepositoryPackage;

import de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLinkRepository.impl.PCMLinkRepositoryPackageImpl;

import de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggerlinkPackage;

import de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.LoggerlinkPackageImpl;

import de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.BooleanCharacterisationValue;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.BytecodeMonitoringRun;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.DoubleCharacterisationValue;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.EnvironmentCharacterisation;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.LongCharacterisationValue;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.MeasuredCharacterisationValue;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.MeasuredCount;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.ParameterValue;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.RawResourceDemandCountsFactory;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.RawResourceDemandCountsPackage;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.RawResourceDemandsLink;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.RawResourceDemandsRepository;

import de.uka.ipd.sdq.pcm.subsystem.SubsystemPackage;

import de.uka.ipd.sdq.pcm.system.SystemPackage;

import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;

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
public class RawResourceDemandCountsPackageImpl extends EPackageImpl implements RawResourceDemandCountsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rawResourceDemandsLinkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass bytecodeMonitoringRunEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass measuredCountEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass measuredCharacterisationValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass environmentCharacterisationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rawResourceDemandsRepositoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass doubleCharacterisationValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass longCharacterisationValueEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanCharacterisationValueEClass = null;

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
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.RawResourceDemandCountsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private RawResourceDemandCountsPackageImpl() {
		super(eNS_URI, RawResourceDemandCountsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link RawResourceDemandCountsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static RawResourceDemandCountsPackage init() {
		if (isInited) return (RawResourceDemandCountsPackage)EPackage.Registry.INSTANCE.getEPackage(RawResourceDemandCountsPackage.eNS_URI);

		// Obtain or create and register package
		RawResourceDemandCountsPackageImpl theRawResourceDemandCountsPackage = (RawResourceDemandCountsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof RawResourceDemandCountsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new RawResourceDemandCountsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CorePackage.eINSTANCE.eClass();
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
		SubsystemPackage.eINSTANCE.eClass();
		statementsPackage.eINSTANCE.eClass();
		corePackage.eINSTANCE.eClass();
		annotationsPackage.eINSTANCE.eClass();
		typesPackage.eINSTANCE.eClass();
		accessesPackage.eINSTANCE.eClass();
		variablesPackage.eINSTANCE.eClass();
		functionsPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		PCMLinkRepositoryPackageImpl thePCMLinkRepositoryPackage = (PCMLinkRepositoryPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PCMLinkRepositoryPackage.eNS_URI) instanceof PCMLinkRepositoryPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PCMLinkRepositoryPackage.eNS_URI) : PCMLinkRepositoryPackage.eINSTANCE);
		LoggerlinkPackageImpl theLoggerlinkPackage = (LoggerlinkPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(LoggerlinkPackage.eNS_URI) instanceof LoggerlinkPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(LoggerlinkPackage.eNS_URI) : LoggerlinkPackage.eINSTANCE);
		GastPcmLinkPackageImpl theGastPcmLinkPackage = (GastPcmLinkPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(GastPcmLinkPackage.eNS_URI) instanceof GastPcmLinkPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(GastPcmLinkPackage.eNS_URI) : GastPcmLinkPackage.eINSTANCE);

		// Create package meta-data objects
		theRawResourceDemandCountsPackage.createPackageContents();
		thePCMLinkRepositoryPackage.createPackageContents();
		theLoggerlinkPackage.createPackageContents();
		theGastPcmLinkPackage.createPackageContents();

		// Initialize created meta-data
		theRawResourceDemandCountsPackage.initializePackageContents();
		thePCMLinkRepositoryPackage.initializePackageContents();
		theLoggerlinkPackage.initializePackageContents();
		theGastPcmLinkPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theRawResourceDemandCountsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(RawResourceDemandCountsPackage.eNS_URI, theRawResourceDemandCountsPackage);
		return theRawResourceDemandCountsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRawResourceDemandsLink() {
		return rawResourceDemandsLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRawResourceDemandsLink_InternalAction() {
		return (EReference)rawResourceDemandsLinkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRawResourceDemandsLink_BytecodeMonitoringRuns() {
		return (EReference)rawResourceDemandsLinkEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBytecodeMonitoringRun() {
		return bytecodeMonitoringRunEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBytecodeMonitoringRun_MeasuredCounts() {
		return (EReference)bytecodeMonitoringRunEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBytecodeMonitoringRun_InputParameterCharacterisations() {
		return (EReference)bytecodeMonitoringRunEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBytecodeMonitoringRun_EnvironmentCharacterisation() {
		return (EReference)bytecodeMonitoringRunEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBytecodeMonitoringRun_RawResourceDemandsLink() {
		return (EReference)bytecodeMonitoringRunEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMeasuredCount() {
		return measuredCountEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMeasuredCount_Count() {
		return (EAttribute)measuredCountEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMeasuredCount_Signature() {
		return (EReference)measuredCountEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMeasuredCount_ParameterValues() {
		return (EReference)measuredCountEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameterValue() {
		return parameterValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameterValue_DescribedParameter() {
		return (EReference)parameterValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameterValue_MeasuredCharacterisationValue() {
		return (EReference)parameterValueEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMeasuredCharacterisationValue() {
		return measuredCharacterisationValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMeasuredCharacterisationValue_RequiredCharacterisation() {
		return (EReference)measuredCharacterisationValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEnvironmentCharacterisation() {
		return environmentCharacterisationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEnvironmentCharacterisation_BytecodeMonitoringRuns() {
		return (EReference)environmentCharacterisationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRawResourceDemandsRepository() {
		return rawResourceDemandsRepositoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRawResourceDemandsRepository_BytecodeMonitoringRuns() {
		return (EReference)rawResourceDemandsRepositoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRawResourceDemandsRepository_RawResourceDemandsLinks() {
		return (EReference)rawResourceDemandsRepositoryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRawResourceDemandsRepository_EnvironmentCharacterisations() {
		return (EReference)rawResourceDemandsRepositoryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDoubleCharacterisationValue() {
		return doubleCharacterisationValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDoubleCharacterisationValue_Value() {
		return (EAttribute)doubleCharacterisationValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLongCharacterisationValue() {
		return longCharacterisationValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLongCharacterisationValue_Value() {
		return (EAttribute)longCharacterisationValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBooleanCharacterisationValue() {
		return booleanCharacterisationValueEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBooleanCharacterisationValue_Value() {
		return (EAttribute)booleanCharacterisationValueEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RawResourceDemandCountsFactory getRawResourceDemandCountsFactory() {
		return (RawResourceDemandCountsFactory)getEFactoryInstance();
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
		rawResourceDemandsLinkEClass = createEClass(RAW_RESOURCE_DEMANDS_LINK);
		createEReference(rawResourceDemandsLinkEClass, RAW_RESOURCE_DEMANDS_LINK__INTERNAL_ACTION);
		createEReference(rawResourceDemandsLinkEClass, RAW_RESOURCE_DEMANDS_LINK__BYTECODE_MONITORING_RUNS);

		bytecodeMonitoringRunEClass = createEClass(BYTECODE_MONITORING_RUN);
		createEReference(bytecodeMonitoringRunEClass, BYTECODE_MONITORING_RUN__MEASURED_COUNTS);
		createEReference(bytecodeMonitoringRunEClass, BYTECODE_MONITORING_RUN__INPUT_PARAMETER_CHARACTERISATIONS);
		createEReference(bytecodeMonitoringRunEClass, BYTECODE_MONITORING_RUN__ENVIRONMENT_CHARACTERISATION);
		createEReference(bytecodeMonitoringRunEClass, BYTECODE_MONITORING_RUN__RAW_RESOURCE_DEMANDS_LINK);

		measuredCountEClass = createEClass(MEASURED_COUNT);
		createEAttribute(measuredCountEClass, MEASURED_COUNT__COUNT);
		createEReference(measuredCountEClass, MEASURED_COUNT__SIGNATURE);
		createEReference(measuredCountEClass, MEASURED_COUNT__PARAMETER_VALUES);

		parameterValueEClass = createEClass(PARAMETER_VALUE);
		createEReference(parameterValueEClass, PARAMETER_VALUE__DESCRIBED_PARAMETER);
		createEReference(parameterValueEClass, PARAMETER_VALUE__MEASURED_CHARACTERISATION_VALUE);

		measuredCharacterisationValueEClass = createEClass(MEASURED_CHARACTERISATION_VALUE);
		createEReference(measuredCharacterisationValueEClass, MEASURED_CHARACTERISATION_VALUE__REQUIRED_CHARACTERISATION);

		environmentCharacterisationEClass = createEClass(ENVIRONMENT_CHARACTERISATION);
		createEReference(environmentCharacterisationEClass, ENVIRONMENT_CHARACTERISATION__BYTECODE_MONITORING_RUNS);

		rawResourceDemandsRepositoryEClass = createEClass(RAW_RESOURCE_DEMANDS_REPOSITORY);
		createEReference(rawResourceDemandsRepositoryEClass, RAW_RESOURCE_DEMANDS_REPOSITORY__BYTECODE_MONITORING_RUNS);
		createEReference(rawResourceDemandsRepositoryEClass, RAW_RESOURCE_DEMANDS_REPOSITORY__RAW_RESOURCE_DEMANDS_LINKS);
		createEReference(rawResourceDemandsRepositoryEClass, RAW_RESOURCE_DEMANDS_REPOSITORY__ENVIRONMENT_CHARACTERISATIONS);

		doubleCharacterisationValueEClass = createEClass(DOUBLE_CHARACTERISATION_VALUE);
		createEAttribute(doubleCharacterisationValueEClass, DOUBLE_CHARACTERISATION_VALUE__VALUE);

		longCharacterisationValueEClass = createEClass(LONG_CHARACTERISATION_VALUE);
		createEAttribute(longCharacterisationValueEClass, LONG_CHARACTERISATION_VALUE__VALUE);

		booleanCharacterisationValueEClass = createEClass(BOOLEAN_CHARACTERISATION_VALUE);
		createEAttribute(booleanCharacterisationValueEClass, BOOLEAN_CHARACTERISATION_VALUE__VALUE);
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
		SeffPackage theSeffPackage = (SeffPackage)EPackage.Registry.INSTANCE.getEPackage(SeffPackage.eNS_URI);
		RepositoryPackage theRepositoryPackage = (RepositoryPackage)EPackage.Registry.INSTANCE.getEPackage(RepositoryPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		rawResourceDemandsLinkEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
		bytecodeMonitoringRunEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
		measuredCountEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
		parameterValueEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
		measuredCharacterisationValueEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
		environmentCharacterisationEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
		rawResourceDemandsRepositoryEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
		doubleCharacterisationValueEClass.getESuperTypes().add(this.getMeasuredCharacterisationValue());
		longCharacterisationValueEClass.getESuperTypes().add(this.getMeasuredCharacterisationValue());
		booleanCharacterisationValueEClass.getESuperTypes().add(this.getMeasuredCharacterisationValue());

		// Initialize classes and features; add operations and parameters
		initEClass(rawResourceDemandsLinkEClass, RawResourceDemandsLink.class, "RawResourceDemandsLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRawResourceDemandsLink_InternalAction(), theSeffPackage.getAbstractInternalControlFlowAction(), null, "internalAction", null, 1, 1, RawResourceDemandsLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRawResourceDemandsLink_BytecodeMonitoringRuns(), this.getBytecodeMonitoringRun(), this.getBytecodeMonitoringRun_RawResourceDemandsLink(), "bytecodeMonitoringRuns", null, 0, -1, RawResourceDemandsLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(bytecodeMonitoringRunEClass, BytecodeMonitoringRun.class, "BytecodeMonitoringRun", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBytecodeMonitoringRun_MeasuredCounts(), this.getMeasuredCount(), null, "measuredCounts", null, 0, -1, BytecodeMonitoringRun.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getBytecodeMonitoringRun_InputParameterCharacterisations(), this.getMeasuredCharacterisationValue(), null, "inputParameterCharacterisations", null, 0, -1, BytecodeMonitoringRun.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getBytecodeMonitoringRun_EnvironmentCharacterisation(), this.getEnvironmentCharacterisation(), this.getEnvironmentCharacterisation_BytecodeMonitoringRuns(), "environmentCharacterisation", null, 0, 1, BytecodeMonitoringRun.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getBytecodeMonitoringRun_RawResourceDemandsLink(), this.getRawResourceDemandsLink(), this.getRawResourceDemandsLink_BytecodeMonitoringRuns(), "rawResourceDemandsLink", null, 1, 1, BytecodeMonitoringRun.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(measuredCountEClass, MeasuredCount.class, "MeasuredCount", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMeasuredCount_Count(), ecorePackage.getEDouble(), "count", null, 1, 1, MeasuredCount.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMeasuredCount_Signature(), theRepositoryPackage.getSignature(), null, "signature", null, 1, 1, MeasuredCount.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getMeasuredCount_ParameterValues(), this.getParameterValue(), null, "parameterValues", null, 0, -1, MeasuredCount.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(parameterValueEClass, ParameterValue.class, "ParameterValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParameterValue_DescribedParameter(), theRepositoryPackage.getParameter(), null, "describedParameter", null, 1, 1, ParameterValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getParameterValue_MeasuredCharacterisationValue(), this.getMeasuredCharacterisationValue(), null, "measuredCharacterisationValue", null, 0, -1, ParameterValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(measuredCharacterisationValueEClass, MeasuredCharacterisationValue.class, "MeasuredCharacterisationValue", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMeasuredCharacterisationValue_RequiredCharacterisation(), theRepositoryPackage.getRequiredCharacterisation(), null, "requiredCharacterisation", null, 1, 1, MeasuredCharacterisationValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(environmentCharacterisationEClass, EnvironmentCharacterisation.class, "EnvironmentCharacterisation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEnvironmentCharacterisation_BytecodeMonitoringRuns(), this.getBytecodeMonitoringRun(), this.getBytecodeMonitoringRun_EnvironmentCharacterisation(), "bytecodeMonitoringRuns", null, 0, -1, EnvironmentCharacterisation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(rawResourceDemandsRepositoryEClass, RawResourceDemandsRepository.class, "RawResourceDemandsRepository", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRawResourceDemandsRepository_BytecodeMonitoringRuns(), this.getBytecodeMonitoringRun(), null, "bytecodeMonitoringRuns", null, 0, -1, RawResourceDemandsRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRawResourceDemandsRepository_RawResourceDemandsLinks(), this.getRawResourceDemandsLink(), null, "rawResourceDemandsLinks", null, 0, -1, RawResourceDemandsRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRawResourceDemandsRepository_EnvironmentCharacterisations(), this.getEnvironmentCharacterisation(), null, "environmentCharacterisations", null, 0, -1, RawResourceDemandsRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(doubleCharacterisationValueEClass, DoubleCharacterisationValue.class, "DoubleCharacterisationValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDoubleCharacterisationValue_Value(), ecorePackage.getEDouble(), "value", null, 1, 1, DoubleCharacterisationValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(longCharacterisationValueEClass, LongCharacterisationValue.class, "LongCharacterisationValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLongCharacterisationValue_Value(), ecorePackage.getELong(), "value", null, 1, 1, LongCharacterisationValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(booleanCharacterisationValueEClass, BooleanCharacterisationValue.class, "BooleanCharacterisationValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBooleanCharacterisationValue_Value(), ecorePackage.getEBoolean(), "value", null, 1, 1, BooleanCharacterisationValue.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //RawResourceDemandCountsPackageImpl
