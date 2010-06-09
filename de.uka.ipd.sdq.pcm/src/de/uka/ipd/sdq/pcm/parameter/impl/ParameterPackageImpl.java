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
import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;
import de.uka.ipd.sdq.pcm.allocation.impl.AllocationPackageImpl;
import de.uka.ipd.sdq.pcm.core.CorePackage;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.core.composition.impl.CompositionPackageImpl;
import de.uka.ipd.sdq.pcm.core.connectors.ConnectorsPackage;
import de.uka.ipd.sdq.pcm.core.connectors.impl.ConnectorsPackageImpl;
import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.core.entity.impl.EntityPackageImpl;
import de.uka.ipd.sdq.pcm.core.impl.CorePackageImpl;
import de.uka.ipd.sdq.pcm.parameter.ParameterFactory;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.parameter.Variable;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisationType;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacteristic;
import de.uka.ipd.sdq.pcm.parameter.VariableSetter;
import de.uka.ipd.sdq.pcm.protocol.ProtocolPackage;
import de.uka.ipd.sdq.pcm.protocol.impl.ProtocolPackageImpl;
import de.uka.ipd.sdq.pcm.qosannotations.QosannotationsPackage;
import de.uka.ipd.sdq.pcm.qosannotations.impl.QosannotationsPackageImpl;
import de.uka.ipd.sdq.pcm.qosannotations.reliability.ReliabilityPackage;
import de.uka.ipd.sdq.pcm.qosannotations.reliability.impl.ReliabilityPackageImpl;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;
import de.uka.ipd.sdq.pcm.resourceenvironment.impl.ResourceenvironmentPackageImpl;
import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;
import de.uka.ipd.sdq.pcm.resourcetype.impl.ResourcetypePackageImpl;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl;
import de.uka.ipd.sdq.pcm.seff.performance.PerformancePackage;
import de.uka.ipd.sdq.pcm.seff.performance.impl.PerformancePackageImpl;
import de.uka.ipd.sdq.pcm.subsystem.SubsystemPackage;
import de.uka.ipd.sdq.pcm.subsystem.impl.SubsystemPackageImpl;
import de.uka.ipd.sdq.pcm.system.SystemPackage;
import de.uka.ipd.sdq.pcm.system.impl.SystemPackageImpl;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;
import de.uka.ipd.sdq.pcm.usagemodel.impl.UsagemodelPackageImpl;
import de.uka.ipd.sdq.stoex.StoexPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ParameterPackageImpl extends EPackageImpl implements ParameterPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableSetterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum variableCharacterisationTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableCharacteristicEClass = null;

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
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ParameterPackageImpl() {
		super(eNS_URI, ParameterFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ParameterPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ParameterPackage init() {
		if (isInited) return (ParameterPackage)EPackage.Registry.INSTANCE.getEPackage(ParameterPackage.eNS_URI);

		// Obtain or create and register package
		ParameterPackageImpl theParameterPackage = (ParameterPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ParameterPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ParameterPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		IdentifierPackage.eINSTANCE.eClass();
		StoexPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		CorePackageImpl theCorePackage = (CorePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI) instanceof CorePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CorePackage.eNS_URI) : CorePackage.eINSTANCE);
		EntityPackageImpl theEntityPackage = (EntityPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EntityPackage.eNS_URI) instanceof EntityPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EntityPackage.eNS_URI) : EntityPackage.eINSTANCE);
		CompositionPackageImpl theCompositionPackage = (CompositionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CompositionPackage.eNS_URI) instanceof CompositionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CompositionPackage.eNS_URI) : CompositionPackage.eINSTANCE);
		ConnectorsPackageImpl theConnectorsPackage = (ConnectorsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ConnectorsPackage.eNS_URI) instanceof ConnectorsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ConnectorsPackage.eNS_URI) : ConnectorsPackage.eINSTANCE);
		UsagemodelPackageImpl theUsagemodelPackage = (UsagemodelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(UsagemodelPackage.eNS_URI) instanceof UsagemodelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(UsagemodelPackage.eNS_URI) : UsagemodelPackage.eINSTANCE);
		RepositoryPackageImpl theRepositoryPackage = (RepositoryPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RepositoryPackage.eNS_URI) instanceof RepositoryPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RepositoryPackage.eNS_URI) : RepositoryPackage.eINSTANCE);
		ProtocolPackageImpl theProtocolPackage = (ProtocolPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ProtocolPackage.eNS_URI) instanceof ProtocolPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ProtocolPackage.eNS_URI) : ProtocolPackage.eINSTANCE);
		SeffPackageImpl theSeffPackage = (SeffPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SeffPackage.eNS_URI) instanceof SeffPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SeffPackage.eNS_URI) : SeffPackage.eINSTANCE);
		PerformancePackageImpl thePerformancePackage = (PerformancePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PerformancePackage.eNS_URI) instanceof PerformancePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PerformancePackage.eNS_URI) : PerformancePackage.eINSTANCE);
		ResourcetypePackageImpl theResourcetypePackage = (ResourcetypePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ResourcetypePackage.eNS_URI) instanceof ResourcetypePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ResourcetypePackage.eNS_URI) : ResourcetypePackage.eINSTANCE);
		QosannotationsPackageImpl theQosannotationsPackage = (QosannotationsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(QosannotationsPackage.eNS_URI) instanceof QosannotationsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(QosannotationsPackage.eNS_URI) : QosannotationsPackage.eINSTANCE);
		de.uka.ipd.sdq.pcm.qosannotations.performance.impl.PerformancePackageImpl thePerformancePackage_1 = (de.uka.ipd.sdq.pcm.qosannotations.performance.impl.PerformancePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(de.uka.ipd.sdq.pcm.qosannotations.performance.PerformancePackage.eNS_URI) instanceof de.uka.ipd.sdq.pcm.qosannotations.performance.impl.PerformancePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(de.uka.ipd.sdq.pcm.qosannotations.performance.PerformancePackage.eNS_URI) : de.uka.ipd.sdq.pcm.qosannotations.performance.PerformancePackage.eINSTANCE);
		ReliabilityPackageImpl theReliabilityPackage = (ReliabilityPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ReliabilityPackage.eNS_URI) instanceof ReliabilityPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ReliabilityPackage.eNS_URI) : ReliabilityPackage.eINSTANCE);
		SystemPackageImpl theSystemPackage = (SystemPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SystemPackage.eNS_URI) instanceof SystemPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SystemPackage.eNS_URI) : SystemPackage.eINSTANCE);
		ResourceenvironmentPackageImpl theResourceenvironmentPackage = (ResourceenvironmentPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ResourceenvironmentPackage.eNS_URI) instanceof ResourceenvironmentPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ResourceenvironmentPackage.eNS_URI) : ResourceenvironmentPackage.eINSTANCE);
		AllocationPackageImpl theAllocationPackage = (AllocationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AllocationPackage.eNS_URI) instanceof AllocationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AllocationPackage.eNS_URI) : AllocationPackage.eINSTANCE);
		SubsystemPackageImpl theSubsystemPackage = (SubsystemPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SubsystemPackage.eNS_URI) instanceof SubsystemPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SubsystemPackage.eNS_URI) : SubsystemPackage.eINSTANCE);

		// Create package meta-data objects
		theParameterPackage.createPackageContents();
		theCorePackage.createPackageContents();
		theEntityPackage.createPackageContents();
		theCompositionPackage.createPackageContents();
		theConnectorsPackage.createPackageContents();
		theUsagemodelPackage.createPackageContents();
		theRepositoryPackage.createPackageContents();
		theProtocolPackage.createPackageContents();
		theSeffPackage.createPackageContents();
		thePerformancePackage.createPackageContents();
		theResourcetypePackage.createPackageContents();
		theQosannotationsPackage.createPackageContents();
		thePerformancePackage_1.createPackageContents();
		theReliabilityPackage.createPackageContents();
		theSystemPackage.createPackageContents();
		theResourceenvironmentPackage.createPackageContents();
		theAllocationPackage.createPackageContents();
		theSubsystemPackage.createPackageContents();

		// Initialize created meta-data
		theParameterPackage.initializePackageContents();
		theCorePackage.initializePackageContents();
		theEntityPackage.initializePackageContents();
		theCompositionPackage.initializePackageContents();
		theConnectorsPackage.initializePackageContents();
		theUsagemodelPackage.initializePackageContents();
		theRepositoryPackage.initializePackageContents();
		theProtocolPackage.initializePackageContents();
		theSeffPackage.initializePackageContents();
		thePerformancePackage.initializePackageContents();
		theResourcetypePackage.initializePackageContents();
		theQosannotationsPackage.initializePackageContents();
		thePerformancePackage_1.initializePackageContents();
		theReliabilityPackage.initializePackageContents();
		theSystemPackage.initializePackageContents();
		theResourceenvironmentPackage.initializePackageContents();
		theAllocationPackage.initializePackageContents();
		theSubsystemPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theParameterPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ParameterPackage.eNS_URI, theParameterPackage);
		return theParameterPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariableSetter() {
		return variableSetterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableSetter_Specification__VariableSetter() {
		return (EReference)variableSetterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableSetter_UserData__VariableSetter() {
		return (EReference)variableSetterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableSetter_AssemblyContext__VariableSetter() {
		return (EReference)variableSetterEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableSetter_EntryLevelSystemCall__InputVariableSetter() {
		return (EReference)variableSetterEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableSetter_EntryLevelSystemCall__OutputVariableSetter() {
		return (EReference)variableSetterEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableSetter_CallAction__VariableSetter() {
		return (EReference)variableSetterEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableSetter_SynchronisationPoint__VariableSetter() {
		return (EReference)variableSetterEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableSetter_CallReturnAction__VariableSetter() {
		return (EReference)variableSetterEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableSetter_SetVariableAction__VariableSetter() {
		return (EReference)variableSetterEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableSetter_SpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableSetter() {
		return (EReference)variableSetterEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableSetter_VariableCharacteristic__VariableSetter() {
		return (EReference)variableSetterEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getVariableCharacterisationType() {
		return variableCharacterisationTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariable() {
		return variableEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariable_ImplementationComponentType__Variable() {
		return (EReference)variableEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariable_EventType__Variable() {
		return (EReference)variableEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariable_VariableCharacteristics__Variable() {
		return (EReference)variableEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariable_DataType__Variable() {
		return (EReference)variableEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariable_CompositeDataType__Variable() {
		return (EReference)variableEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariable_ResourceSignature__Variable() {
		return (EReference)variableEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariable_InfrastructureSignature__Variable() {
		return (EReference)variableEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariable_OperationSignature__Variable() {
		return (EReference)variableEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariableCharacteristic() {
		return variableCharacteristicEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariableCharacteristic_CharacterisationDefinition__VariableCharacteristic() {
		return (EAttribute)variableCharacteristicEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableCharacteristic_Variable__VariableCharacteristic() {
		return (EReference)variableCharacteristicEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterFactory getParameterFactory() {
		return (ParameterFactory)getEFactoryInstance();
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
		variableSetterEClass = createEClass(VARIABLE_SETTER);
		createEReference(variableSetterEClass, VARIABLE_SETTER__SPECIFICATION_VARIABLE_SETTER);
		createEReference(variableSetterEClass, VARIABLE_SETTER__USER_DATA_VARIABLE_SETTER);
		createEReference(variableSetterEClass, VARIABLE_SETTER__ASSEMBLY_CONTEXT_VARIABLE_SETTER);
		createEReference(variableSetterEClass, VARIABLE_SETTER__ENTRY_LEVEL_SYSTEM_CALL_INPUT_VARIABLE_SETTER);
		createEReference(variableSetterEClass, VARIABLE_SETTER__ENTRY_LEVEL_SYSTEM_CALL_OUTPUT_VARIABLE_SETTER);
		createEReference(variableSetterEClass, VARIABLE_SETTER__CALL_ACTION_VARIABLE_SETTER);
		createEReference(variableSetterEClass, VARIABLE_SETTER__SYNCHRONISATION_POINT_VARIABLE_SETTER);
		createEReference(variableSetterEClass, VARIABLE_SETTER__CALL_RETURN_ACTION_VARIABLE_SETTER);
		createEReference(variableSetterEClass, VARIABLE_SETTER__SET_VARIABLE_ACTION_VARIABLE_SETTER);
		createEReference(variableSetterEClass, VARIABLE_SETTER__SPECIFIED_OUTPUT_PARAMETER_ABSTRACTION_EXPECTED_EXTERNAL_OUTPUTS_VARIABLE_SETTER);
		createEReference(variableSetterEClass, VARIABLE_SETTER__VARIABLE_CHARACTERISTIC_VARIABLE_SETTER);

		variableEClass = createEClass(VARIABLE);
		createEReference(variableEClass, VARIABLE__IMPLEMENTATION_COMPONENT_TYPE_VARIABLE);
		createEReference(variableEClass, VARIABLE__DATA_TYPE_VARIABLE);
		createEReference(variableEClass, VARIABLE__COMPOSITE_DATA_TYPE_VARIABLE);
		createEReference(variableEClass, VARIABLE__RESOURCE_SIGNATURE_VARIABLE);
		createEReference(variableEClass, VARIABLE__INFRASTRUCTURE_SIGNATURE_VARIABLE);
		createEReference(variableEClass, VARIABLE__EVENT_TYPE_VARIABLE);
		createEReference(variableEClass, VARIABLE__VARIABLE_CHARACTERISTICS_VARIABLE);
		createEReference(variableEClass, VARIABLE__OPERATION_SIGNATURE_VARIABLE);

		variableCharacteristicEClass = createEClass(VARIABLE_CHARACTERISTIC);
		createEAttribute(variableCharacteristicEClass, VARIABLE_CHARACTERISTIC__CHARACTERISATION_DEFINITION_VARIABLE_CHARACTERISTIC);
		createEReference(variableCharacteristicEClass, VARIABLE_CHARACTERISTIC__VARIABLE_VARIABLE_CHARACTERISTIC);

		// Create enums
		variableCharacterisationTypeEEnum = createEEnum(VARIABLE_CHARACTERISATION_TYPE);
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
		UsagemodelPackage theUsagemodelPackage = (UsagemodelPackage)EPackage.Registry.INSTANCE.getEPackage(UsagemodelPackage.eNS_URI);
		CompositionPackage theCompositionPackage = (CompositionPackage)EPackage.Registry.INSTANCE.getEPackage(CompositionPackage.eNS_URI);
		SeffPackage theSeffPackage = (SeffPackage)EPackage.Registry.INSTANCE.getEPackage(SeffPackage.eNS_URI);
		QosannotationsPackage theQosannotationsPackage = (QosannotationsPackage)EPackage.Registry.INSTANCE.getEPackage(QosannotationsPackage.eNS_URI);
		EntityPackage theEntityPackage = (EntityPackage)EPackage.Registry.INSTANCE.getEPackage(EntityPackage.eNS_URI);
		RepositoryPackage theRepositoryPackage = (RepositoryPackage)EPackage.Registry.INSTANCE.getEPackage(RepositoryPackage.eNS_URI);
		StoexPackage theStoexPackage = (StoexPackage)EPackage.Registry.INSTANCE.getEPackage(StoexPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		variableEClass.getESuperTypes().add(theEntityPackage.getEntity());
		variableCharacteristicEClass.getESuperTypes().add(theStoexPackage.getStoExVariable());

		// Initialize classes and features; add operations and parameters
		initEClass(variableSetterEClass, VariableSetter.class, "VariableSetter", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariableSetter_Specification__VariableSetter(), theCorePackage.getPCMRandomVariable(), theCorePackage.getPCMRandomVariable_VariableSetter__PCMRandomVariable(), "specification__VariableSetter", null, 1, 1, VariableSetter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getVariableSetter_UserData__VariableSetter(), theUsagemodelPackage.getUserData(), theUsagemodelPackage.getUserData_UserDataVariableSetters__UserData(), "userData__VariableSetter", null, 0, 1, VariableSetter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getVariableSetter_AssemblyContext__VariableSetter(), theCompositionPackage.getAssemblyContext(), theCompositionPackage.getAssemblyContext_ConfigVariableSetters__AssemblyContext(), "assemblyContext__VariableSetter", null, 0, 1, VariableSetter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getVariableSetter_EntryLevelSystemCall__InputVariableSetter(), theUsagemodelPackage.getEntryLevelSystemCall(), theUsagemodelPackage.getEntryLevelSystemCall_InputVariableSetters__EntryLevelSystemCall(), "entryLevelSystemCall__InputVariableSetter", null, 0, 1, VariableSetter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getVariableSetter_EntryLevelSystemCall__OutputVariableSetter(), theUsagemodelPackage.getEntryLevelSystemCall(), theUsagemodelPackage.getEntryLevelSystemCall_OutputVariableSetters__EntryLevelSystemCall(), "entryLevelSystemCall__OutputVariableSetter", null, 0, 1, VariableSetter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getVariableSetter_CallAction__VariableSetter(), theSeffPackage.getCallAction(), theSeffPackage.getCallAction_VariableSetterInputs__CallAction(), "callAction__VariableSetter", null, 0, 1, VariableSetter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getVariableSetter_SynchronisationPoint__VariableSetter(), theSeffPackage.getSynchronisationPoint(), theSeffPackage.getSynchronisationPoint_OutputVariableSetters__SynchronisationPoint(), "synchronisationPoint__VariableSetter", null, 0, 1, VariableSetter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getVariableSetter_CallReturnAction__VariableSetter(), theSeffPackage.getCallReturnAction(), theSeffPackage.getCallReturnAction_VariableSetterReturns__CallReturnAction(), "callReturnAction__VariableSetter", null, 0, 1, VariableSetter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getVariableSetter_SetVariableAction__VariableSetter(), theSeffPackage.getSetVariableAction(), theSeffPackage.getSetVariableAction_LocalVariableUsages_SetVariableAction(), "setVariableAction__VariableSetter", null, 0, 1, VariableSetter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getVariableSetter_SpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableSetter(), theQosannotationsPackage.getSpecifiedOutputParameterAbstraction(), theQosannotationsPackage.getSpecifiedOutputParameterAbstraction_ExpectedExternalOutputs_SpecifiedOutputParameterAbstraction(), "specifiedOutputParameterAbstraction_expectedExternalOutputs_VariableSetter", null, 0, 1, VariableSetter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getVariableSetter_VariableCharacteristic__VariableSetter(), this.getVariableCharacteristic(), null, "variableCharacteristic__VariableSetter", null, 1, 1, VariableSetter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(variableEClass, Variable.class, "Variable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariable_ImplementationComponentType__Variable(), theRepositoryPackage.getImplementationComponentType(), theRepositoryPackage.getImplementationComponentType_ComponentParameter__ImplementationComponentType(), "implementationComponentType__Variable", null, 0, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getVariable_DataType__Variable(), theRepositoryPackage.getDataType(), null, "dataType__Variable", null, 1, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getVariable_CompositeDataType__Variable(), theRepositoryPackage.getCompositeDataType(), theRepositoryPackage.getCompositeDataType_Members__CompositeDataType(), "compositeDataType__Variable", null, 0, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getVariable_ResourceSignature__Variable(), theRepositoryPackage.getResourceSignature(), theRepositoryPackage.getResourceSignature_Parameter__ResourceSignature(), "resourceSignature__Variable", null, 0, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getVariable_InfrastructureSignature__Variable(), theRepositoryPackage.getInfrastructureSignature(), theRepositoryPackage.getInfrastructureSignature_Parameters__InfrastructureSignature(), "infrastructureSignature__Variable", null, 0, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getVariable_EventType__Variable(), theRepositoryPackage.getEventType(), theRepositoryPackage.getEventType_Payload__EventType(), "eventType__Variable", null, 0, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getVariable_VariableCharacteristics__Variable(), this.getVariableCharacteristic(), this.getVariableCharacteristic_Variable__VariableCharacteristic(), "variableCharacteristics__Variable", null, 1, -1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getVariable_OperationSignature__Variable(), theRepositoryPackage.getOperationSignature(), theRepositoryPackage.getOperationSignature_Parameters__OperationSignature(), "operationSignature__Variable", null, 0, 1, Variable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(variableCharacteristicEClass, VariableCharacteristic.class, "VariableCharacteristic", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVariableCharacteristic_CharacterisationDefinition__VariableCharacteristic(), this.getVariableCharacterisationType(), "characterisationDefinition__VariableCharacteristic", null, 1, 1, VariableCharacteristic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getVariableCharacteristic_Variable__VariableCharacteristic(), this.getVariable(), this.getVariable_VariableCharacteristics__Variable(), "variable__VariableCharacteristic", null, 1, 1, VariableCharacteristic.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(variableCharacterisationTypeEEnum, VariableCharacterisationType.class, "VariableCharacterisationType");
		addEEnumLiteral(variableCharacterisationTypeEEnum, VariableCharacterisationType.STRUCTURE);
		addEEnumLiteral(variableCharacterisationTypeEEnum, VariableCharacterisationType.NUMBER_OF_ELEMENTS);
		addEEnumLiteral(variableCharacterisationTypeEEnum, VariableCharacterisationType.VALUE);
		addEEnumLiteral(variableCharacterisationTypeEEnum, VariableCharacterisationType.BYTESIZE);
		addEEnumLiteral(variableCharacterisationTypeEEnum, VariableCharacterisationType.TYPE);

		// Create resource
		createResource(eNS_URI);
	}

} //ParameterPackageImpl
