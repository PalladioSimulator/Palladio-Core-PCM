/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.parameter.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import de.uka.ipd.sdq.identifier.IdentifierPackage;
import de.uka.ipd.sdq.pcm.PcmPackage;
import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;
import de.uka.ipd.sdq.pcm.allocation.impl.AllocationPackageImpl;
import de.uka.ipd.sdq.pcm.core.CorePackage;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.core.composition.impl.CompositionPackageImpl;
import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.core.entity.impl.EntityPackageImpl;
import de.uka.ipd.sdq.pcm.core.impl.CorePackageImpl;
import de.uka.ipd.sdq.pcm.impl.PcmPackageImpl;
import de.uka.ipd.sdq.pcm.parameter.CharacterisedVariable;
import de.uka.ipd.sdq.pcm.parameter.ParameterFactory;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.protocol.ProtocolPackage;
import de.uka.ipd.sdq.pcm.protocol.impl.ProtocolPackageImpl;
import de.uka.ipd.sdq.pcm.qosannotations.QosannotationsPackage;
import de.uka.ipd.sdq.pcm.qosannotations.impl.QosannotationsPackageImpl;
import de.uka.ipd.sdq.pcm.qosannotations.qos_performance.QosPerformancePackage;
import de.uka.ipd.sdq.pcm.qosannotations.qos_performance.impl.QosPerformancePackageImpl;
import de.uka.ipd.sdq.pcm.qosannotations.qos_reliability.QosReliabilityPackage;
import de.uka.ipd.sdq.pcm.qosannotations.qos_reliability.impl.QosReliabilityPackageImpl;
import de.uka.ipd.sdq.pcm.reliability.ReliabilityPackage;
import de.uka.ipd.sdq.pcm.reliability.impl.ReliabilityPackageImpl;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;
import de.uka.ipd.sdq.pcm.resourceenvironment.impl.ResourceenvironmentPackageImpl;
import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;
import de.uka.ipd.sdq.pcm.resourcetype.impl.ResourcetypePackageImpl;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl;
import de.uka.ipd.sdq.pcm.seff.seff_performance.SeffPerformancePackage;
import de.uka.ipd.sdq.pcm.seff.seff_performance.impl.SeffPerformancePackageImpl;
import de.uka.ipd.sdq.pcm.seff.seff_reliability.SeffReliabilityPackage;
import de.uka.ipd.sdq.pcm.seff.seff_reliability.impl.SeffReliabilityPackageImpl;
import de.uka.ipd.sdq.pcm.subsystem.SubsystemPackage;
import de.uka.ipd.sdq.pcm.subsystem.impl.SubsystemPackageImpl;
import de.uka.ipd.sdq.pcm.system.SystemPackage;
import de.uka.ipd.sdq.pcm.system.impl.SystemPackageImpl;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;
import de.uka.ipd.sdq.pcm.usagemodel.impl.UsagemodelPackageImpl;
import de.uka.ipd.sdq.stoex.StoexPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * @generated
 */
public class ParameterPackageImpl extends EPackageImpl implements
		ParameterPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableUsageEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableCharacterisationEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass characterisedVariableEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum variableCharacterisationTypeEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ParameterPackageImpl() {
		super(eNS_URI, ParameterFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ParameterPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ParameterPackage init() {
		if (isInited)
			return (ParameterPackage) EPackage.Registry.INSTANCE
					.getEPackage(ParameterPackage.eNS_URI);

		// Obtain or create and register package
		ParameterPackageImpl theParameterPackage = (ParameterPackageImpl) (EPackage.Registry.INSTANCE
				.get(eNS_URI) instanceof ParameterPackageImpl ? EPackage.Registry.INSTANCE
				.get(eNS_URI) : new ParameterPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		IdentifierPackage.eINSTANCE.eClass();
		StoexPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		PcmPackageImpl thePcmPackage = (PcmPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(PcmPackage.eNS_URI) instanceof PcmPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(PcmPackage.eNS_URI) : PcmPackage.eINSTANCE);
		CorePackageImpl theCorePackage = (CorePackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(CorePackage.eNS_URI) instanceof CorePackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(CorePackage.eNS_URI) : CorePackage.eINSTANCE);
		EntityPackageImpl theEntityPackage = (EntityPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(EntityPackage.eNS_URI) instanceof EntityPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(EntityPackage.eNS_URI) : EntityPackage.eINSTANCE);
		CompositionPackageImpl theCompositionPackage = (CompositionPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(CompositionPackage.eNS_URI) instanceof CompositionPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(CompositionPackage.eNS_URI)
				: CompositionPackage.eINSTANCE);
		UsagemodelPackageImpl theUsagemodelPackage = (UsagemodelPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(UsagemodelPackage.eNS_URI) instanceof UsagemodelPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(UsagemodelPackage.eNS_URI)
				: UsagemodelPackage.eINSTANCE);
		RepositoryPackageImpl theRepositoryPackage = (RepositoryPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(RepositoryPackage.eNS_URI) instanceof RepositoryPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(RepositoryPackage.eNS_URI)
				: RepositoryPackage.eINSTANCE);
		ResourcetypePackageImpl theResourcetypePackage = (ResourcetypePackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(ResourcetypePackage.eNS_URI) instanceof ResourcetypePackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(ResourcetypePackage.eNS_URI)
				: ResourcetypePackage.eINSTANCE);
		ProtocolPackageImpl theProtocolPackage = (ProtocolPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(ProtocolPackage.eNS_URI) instanceof ProtocolPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(ProtocolPackage.eNS_URI)
				: ProtocolPackage.eINSTANCE);
		ReliabilityPackageImpl theReliabilityPackage = (ReliabilityPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(ReliabilityPackage.eNS_URI) instanceof ReliabilityPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(ReliabilityPackage.eNS_URI)
				: ReliabilityPackage.eINSTANCE);
		SeffPackageImpl theSeffPackage = (SeffPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(SeffPackage.eNS_URI) instanceof SeffPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(SeffPackage.eNS_URI) : SeffPackage.eINSTANCE);
		SeffPerformancePackageImpl theSeffPerformancePackage = (SeffPerformancePackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(SeffPerformancePackage.eNS_URI) instanceof SeffPerformancePackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(SeffPerformancePackage.eNS_URI)
				: SeffPerformancePackage.eINSTANCE);
		SeffReliabilityPackageImpl theSeffReliabilityPackage = (SeffReliabilityPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(SeffReliabilityPackage.eNS_URI) instanceof SeffReliabilityPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(SeffReliabilityPackage.eNS_URI)
				: SeffReliabilityPackage.eINSTANCE);
		QosannotationsPackageImpl theQosannotationsPackage = (QosannotationsPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(QosannotationsPackage.eNS_URI) instanceof QosannotationsPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(QosannotationsPackage.eNS_URI)
				: QosannotationsPackage.eINSTANCE);
		QosPerformancePackageImpl theQosPerformancePackage = (QosPerformancePackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(QosPerformancePackage.eNS_URI) instanceof QosPerformancePackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(QosPerformancePackage.eNS_URI)
				: QosPerformancePackage.eINSTANCE);
		QosReliabilityPackageImpl theQosReliabilityPackage = (QosReliabilityPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(QosReliabilityPackage.eNS_URI) instanceof QosReliabilityPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(QosReliabilityPackage.eNS_URI)
				: QosReliabilityPackage.eINSTANCE);
		SystemPackageImpl theSystemPackage = (SystemPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(SystemPackage.eNS_URI) instanceof SystemPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(SystemPackage.eNS_URI) : SystemPackage.eINSTANCE);
		ResourceenvironmentPackageImpl theResourceenvironmentPackage = (ResourceenvironmentPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(ResourceenvironmentPackage.eNS_URI) instanceof ResourceenvironmentPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(ResourceenvironmentPackage.eNS_URI)
				: ResourceenvironmentPackage.eINSTANCE);
		AllocationPackageImpl theAllocationPackage = (AllocationPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(AllocationPackage.eNS_URI) instanceof AllocationPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(AllocationPackage.eNS_URI)
				: AllocationPackage.eINSTANCE);
		SubsystemPackageImpl theSubsystemPackage = (SubsystemPackageImpl) (EPackage.Registry.INSTANCE
				.getEPackage(SubsystemPackage.eNS_URI) instanceof SubsystemPackageImpl ? EPackage.Registry.INSTANCE
				.getEPackage(SubsystemPackage.eNS_URI)
				: SubsystemPackage.eINSTANCE);

		// Create package meta-data objects
		theParameterPackage.createPackageContents();
		thePcmPackage.createPackageContents();
		theCorePackage.createPackageContents();
		theEntityPackage.createPackageContents();
		theCompositionPackage.createPackageContents();
		theUsagemodelPackage.createPackageContents();
		theRepositoryPackage.createPackageContents();
		theResourcetypePackage.createPackageContents();
		theProtocolPackage.createPackageContents();
		theReliabilityPackage.createPackageContents();
		theSeffPackage.createPackageContents();
		theSeffPerformancePackage.createPackageContents();
		theSeffReliabilityPackage.createPackageContents();
		theQosannotationsPackage.createPackageContents();
		theQosPerformancePackage.createPackageContents();
		theQosReliabilityPackage.createPackageContents();
		theSystemPackage.createPackageContents();
		theResourceenvironmentPackage.createPackageContents();
		theAllocationPackage.createPackageContents();
		theSubsystemPackage.createPackageContents();

		// Initialize created meta-data
		theParameterPackage.initializePackageContents();
		thePcmPackage.initializePackageContents();
		theCorePackage.initializePackageContents();
		theEntityPackage.initializePackageContents();
		theCompositionPackage.initializePackageContents();
		theUsagemodelPackage.initializePackageContents();
		theRepositoryPackage.initializePackageContents();
		theResourcetypePackage.initializePackageContents();
		theProtocolPackage.initializePackageContents();
		theReliabilityPackage.initializePackageContents();
		theSeffPackage.initializePackageContents();
		theSeffPerformancePackage.initializePackageContents();
		theSeffReliabilityPackage.initializePackageContents();
		theQosannotationsPackage.initializePackageContents();
		theQosPerformancePackage.initializePackageContents();
		theQosReliabilityPackage.initializePackageContents();
		theSystemPackage.initializePackageContents();
		theResourceenvironmentPackage.initializePackageContents();
		theAllocationPackage.initializePackageContents();
		theSubsystemPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theParameterPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ParameterPackage.eNS_URI,
				theParameterPackage);
		return theParameterPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVariableUsage() {
		return variableUsageEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVariableUsage_VariableCharacterisation_VariableUsage() {
		return (EReference) variableUsageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVariableUsage_UserData_VariableUsage() {
		return (EReference) variableUsageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVariableUsage_CallAction__VariableUsage() {
		return (EReference) variableUsageEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVariableUsage_SynchronisationPoint_VariableUsage() {
		return (EReference) variableUsageEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVariableUsage_CallReturnAction__VariableUsage() {
		return (EReference) variableUsageEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVariableUsage_SetVariableAction_VariableUsage() {
		return (EReference) variableUsageEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVariableUsage_SpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableUsage() {
		return (EReference) variableUsageEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVariableUsage_AssemblyContext__VariableUsage() {
		return (EReference) variableUsageEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVariableUsage_EntryLevelSystemCall_InputParameterUsage() {
		return (EReference) variableUsageEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVariableUsage_EntryLevelSystemCall_OutputParameterUsage() {
		return (EReference) variableUsageEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVariableUsage_NamedReference__VariableUsage() {
		return (EReference) variableUsageEClass.getEStructuralFeatures()
				.get(10);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVariableCharacterisation() {
		return variableCharacterisationEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getVariableCharacterisation_Type() {
		return (EAttribute) variableCharacterisationEClass
				.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVariableCharacterisation_Specification_VariableCharacterisation() {
		return (EReference) variableCharacterisationEClass
				.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getVariableCharacterisation_VariableUsage_VariableCharacterisation() {
		return (EReference) variableCharacterisationEClass
				.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCharacterisedVariable() {
		return characterisedVariableEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCharacterisedVariable_CharacterisationType() {
		return (EAttribute) characterisedVariableEClass
				.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getVariableCharacterisationType() {
		return variableCharacterisationTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ParameterFactory getParameterFactory() {
		return (ParameterFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		variableUsageEClass = createEClass(VARIABLE_USAGE);
		createEReference(variableUsageEClass,
				VARIABLE_USAGE__VARIABLE_CHARACTERISATION_VARIABLE_USAGE);
		createEReference(variableUsageEClass,
				VARIABLE_USAGE__USER_DATA_VARIABLE_USAGE);
		createEReference(variableUsageEClass,
				VARIABLE_USAGE__CALL_ACTION_VARIABLE_USAGE);
		createEReference(variableUsageEClass,
				VARIABLE_USAGE__SYNCHRONISATION_POINT_VARIABLE_USAGE);
		createEReference(variableUsageEClass,
				VARIABLE_USAGE__CALL_RETURN_ACTION_VARIABLE_USAGE);
		createEReference(variableUsageEClass,
				VARIABLE_USAGE__SET_VARIABLE_ACTION_VARIABLE_USAGE);
		createEReference(
				variableUsageEClass,
				VARIABLE_USAGE__SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION_EXPECTED_EXTERNAL_OUTPUTS_VARIABLE_USAGE);
		createEReference(variableUsageEClass,
				VARIABLE_USAGE__ASSEMBLY_CONTEXT_VARIABLE_USAGE);
		createEReference(variableUsageEClass,
				VARIABLE_USAGE__ENTRY_LEVEL_SYSTEM_CALL_INPUT_PARAMETER_USAGE);
		createEReference(variableUsageEClass,
				VARIABLE_USAGE__ENTRY_LEVEL_SYSTEM_CALL_OUTPUT_PARAMETER_USAGE);
		createEReference(variableUsageEClass,
				VARIABLE_USAGE__NAMED_REFERENCE_VARIABLE_USAGE);

		variableCharacterisationEClass = createEClass(VARIABLE_CHARACTERISATION);
		createEAttribute(variableCharacterisationEClass,
				VARIABLE_CHARACTERISATION__TYPE);
		createEReference(variableCharacterisationEClass,
				VARIABLE_CHARACTERISATION__SPECIFICATION_VARIABLE_CHARACTERISATION);
		createEReference(variableCharacterisationEClass,
				VARIABLE_CHARACTERISATION__VARIABLE_USAGE_VARIABLE_CHARACTERISATION);

		characterisedVariableEClass = createEClass(CHARACTERISED_VARIABLE);
		createEAttribute(characterisedVariableEClass,
				CHARACTERISED_VARIABLE__CHARACTERISATION_TYPE);

		// Create enums
		variableCharacterisationTypeEEnum = createEEnum(VARIABLE_CHARACTERISATION_TYPE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		UsagemodelPackage theUsagemodelPackage = (UsagemodelPackage) EPackage.Registry.INSTANCE
				.getEPackage(UsagemodelPackage.eNS_URI);
		SeffPackage theSeffPackage = (SeffPackage) EPackage.Registry.INSTANCE
				.getEPackage(SeffPackage.eNS_URI);
		QosannotationsPackage theQosannotationsPackage = (QosannotationsPackage) EPackage.Registry.INSTANCE
				.getEPackage(QosannotationsPackage.eNS_URI);
		CompositionPackage theCompositionPackage = (CompositionPackage) EPackage.Registry.INSTANCE
				.getEPackage(CompositionPackage.eNS_URI);
		StoexPackage theStoexPackage = (StoexPackage) EPackage.Registry.INSTANCE
				.getEPackage(StoexPackage.eNS_URI);
		CorePackage theCorePackage = (CorePackage) EPackage.Registry.INSTANCE
				.getEPackage(CorePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		characterisedVariableEClass.getESuperTypes().add(
				theStoexPackage.getVariable());

		// Initialize classes and features; add operations and parameters
		initEClass(variableUsageEClass, VariableUsage.class, "VariableUsage",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(
				getVariableUsage_VariableCharacterisation_VariableUsage(),
				this.getVariableCharacterisation(),
				this.getVariableCharacterisation_VariableUsage_VariableCharacterisation(),
				"variableCharacterisation_VariableUsage", null, 0, -1,
				VariableUsage.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getVariableUsage_UserData_VariableUsage(),
				theUsagemodelPackage.getUserData(),
				theUsagemodelPackage
						.getUserData_UserDataParameterUsages_UserData(),
				"userData_VariableUsage", null, 0, 1, VariableUsage.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				!IS_ORDERED);
		initEReference(getVariableUsage_CallAction__VariableUsage(),
				theSeffPackage.getCallAction(),
				theSeffPackage.getCallAction_InputVariableUsages__CallAction(),
				"callAction__VariableUsage", null, 0, 1, VariableUsage.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				!IS_ORDERED);
		initEReference(
				getVariableUsage_SynchronisationPoint_VariableUsage(),
				theSeffPackage.getSynchronisationPoint(),
				theSeffPackage
						.getSynchronisationPoint_OutputParameterUsage_SynchronisationPoint(),
				"synchronisationPoint_VariableUsage", null, 0, 1,
				VariableUsage.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(
				getVariableUsage_CallReturnAction__VariableUsage(),
				theSeffPackage.getCallReturnAction(),
				theSeffPackage
						.getCallReturnAction_ReturnVariableUsage__CallReturnAction(),
				"callReturnAction__VariableUsage", null, 0, 1,
				VariableUsage.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(
				getVariableUsage_SetVariableAction_VariableUsage(),
				theSeffPackage.getSetVariableAction(),
				theSeffPackage
						.getSetVariableAction_LocalVariableUsages_SetVariableAction(),
				"setVariableAction_VariableUsage", null, 0, 1,
				VariableUsage.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(
				getVariableUsage_SpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableUsage(),
				theQosannotationsPackage
						.getSpecifiedOutputParameterAbstraction(),
				theQosannotationsPackage
						.getSpecifiedOutputParameterAbstraction_ExpectedExternalOutputs_SpecifiedOutputParameterAbstraction(),
				"specifiedOutputParameterAbstraction_expectedExternalOutputs_VariableUsage",
				null, 0, 1, VariableUsage.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(
				getVariableUsage_AssemblyContext__VariableUsage(),
				theCompositionPackage.getAssemblyContext(),
				theCompositionPackage
						.getAssemblyContext_ConfigParameterUsages__AssemblyContext(),
				"assemblyContext__VariableUsage", null, 0, 1,
				VariableUsage.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(
				getVariableUsage_EntryLevelSystemCall_InputParameterUsage(),
				theUsagemodelPackage.getEntryLevelSystemCall(),
				theUsagemodelPackage
						.getEntryLevelSystemCall_InputParameterUsages_EntryLevelSystemCall(),
				"entryLevelSystemCall_InputParameterUsage", null, 0, 1,
				VariableUsage.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(
				getVariableUsage_EntryLevelSystemCall_OutputParameterUsage(),
				theUsagemodelPackage.getEntryLevelSystemCall(),
				theUsagemodelPackage
						.getEntryLevelSystemCall_OutputParameterUsages_EntryLevelSystemCall(),
				"entryLevelSystemCall_OutputParameterUsage", null, 0, 1,
				VariableUsage.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getVariableUsage_NamedReference__VariableUsage(),
				theStoexPackage.getAbstractNamedReference(), null,
				"namedReference__VariableUsage", null, 1, 1,
				VariableUsage.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(variableCharacterisationEClass,
				VariableCharacterisation.class, "VariableCharacterisation",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVariableCharacterisation_Type(),
				this.getVariableCharacterisationType(), "type", null, 1, 1,
				VariableCharacterisation.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED,
				!IS_ORDERED);
		initEReference(
				getVariableCharacterisation_Specification_VariableCharacterisation(),
				theCorePackage.getPCMRandomVariable(),
				theCorePackage
						.getPCMRandomVariable_VariableCharacterisation_Specification(),
				"specification_VariableCharacterisation", null, 1, 1,
				VariableCharacterisation.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(
				getVariableCharacterisation_VariableUsage_VariableCharacterisation(),
				this.getVariableUsage(),
				this.getVariableUsage_VariableCharacterisation_VariableUsage(),
				"variableUsage_VariableCharacterisation", null, 0, 1,
				VariableCharacterisation.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(characterisedVariableEClass, CharacterisedVariable.class,
				"CharacterisedVariable", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCharacterisedVariable_CharacterisationType(),
				this.getVariableCharacterisationType(), "characterisationType",
				null, 1, 1, CharacterisedVariable.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, !IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(variableCharacterisationTypeEEnum,
				VariableCharacterisationType.class,
				"VariableCharacterisationType");
		addEEnumLiteral(variableCharacterisationTypeEEnum,
				VariableCharacterisationType.STRUCTURE);
		addEEnumLiteral(variableCharacterisationTypeEEnum,
				VariableCharacterisationType.NUMBER_OF_ELEMENTS);
		addEEnumLiteral(variableCharacterisationTypeEEnum,
				VariableCharacterisationType.VALUE);
		addEEnumLiteral(variableCharacterisationTypeEEnum,
				VariableCharacterisationType.BYTESIZE);
		addEEnumLiteral(variableCharacterisationTypeEEnum,
				VariableCharacterisationType.TYPE);
	}

} // ParameterPackageImpl
