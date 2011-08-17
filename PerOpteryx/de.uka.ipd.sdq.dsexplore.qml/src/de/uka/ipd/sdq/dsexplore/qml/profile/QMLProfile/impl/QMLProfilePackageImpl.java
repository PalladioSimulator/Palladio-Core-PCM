/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.impl;

import de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.QMLContractPackage;

import de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.impl.QMLContractPackageImpl;

import de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.QMLContractTypePackage;

import de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.QMLContractTypePackageImpl;

import de.uka.ipd.sdq.dsexplore.qml.declarations.QMLDeclarations.QMLDeclarationsPackage;

import de.uka.ipd.sdq.dsexplore.qml.declarations.QMLDeclarations.impl.QMLDeclarationsPackageImpl;

import de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.EntryLevelSystemCallRequirement;
import de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.GenericQMLProfile;
import de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.QMLProfileFactory;
import de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.QMLProfilePackage;
import de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.RefinedQMLProfile;
import de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.Requirement;
import de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.SimpleQMLProfile;
import de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.UsageScenarioRequirement;

import de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.util.QMLProfileValidator;

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

import de.uka.ipd.sdq.pcm.subsystem.SubsystemPackage;

import de.uka.ipd.sdq.pcm.system.SystemPackage;

import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class QMLProfilePackageImpl extends EPackageImpl implements QMLProfilePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simpleQMLProfileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass genericQMLProfileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass requirementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass refinedQMLProfileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass usageScenarioRequirementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass entryLevelSystemCallRequirementEClass = null;

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
	 * @see de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.QMLProfilePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private QMLProfilePackageImpl() {
		super(eNS_URI, QMLProfileFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link QMLProfilePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static QMLProfilePackage init() {
		if (isInited) return (QMLProfilePackage)EPackage.Registry.INSTANCE.getEPackage(QMLProfilePackage.eNS_URI);

		// Obtain or create and register package
		QMLProfilePackageImpl theQMLProfilePackage = (QMLProfilePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof QMLProfilePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new QMLProfilePackageImpl());

		isInited = true;

		// Initialize simple dependencies
		CorePackage.eINSTANCE.eClass();
		UsagemodelPackage.eINSTANCE.eClass();
		RepositoryPackage.eINSTANCE.eClass();
		ProtocolPackage.eINSTANCE.eClass();
		ParameterPackage.eINSTANCE.eClass();
		SeffPackage.eINSTANCE.eClass();
		ResourcetypePackage.eINSTANCE.eClass();
		QosannotationsPackage.eINSTANCE.eClass();
		SystemPackage.eINSTANCE.eClass();
		ResourceenvironmentPackage.eINSTANCE.eClass();
		AllocationPackage.eINSTANCE.eClass();
		SubsystemPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		QMLDeclarationsPackageImpl theQMLDeclarationsPackage = (QMLDeclarationsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(QMLDeclarationsPackage.eNS_URI) instanceof QMLDeclarationsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(QMLDeclarationsPackage.eNS_URI) : QMLDeclarationsPackage.eINSTANCE);
		QMLContractPackageImpl theQMLContractPackage = (QMLContractPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(QMLContractPackage.eNS_URI) instanceof QMLContractPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(QMLContractPackage.eNS_URI) : QMLContractPackage.eINSTANCE);
		QMLContractTypePackageImpl theQMLContractTypePackage = (QMLContractTypePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(QMLContractTypePackage.eNS_URI) instanceof QMLContractTypePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(QMLContractTypePackage.eNS_URI) : QMLContractTypePackage.eINSTANCE);

		// Create package meta-data objects
		theQMLProfilePackage.createPackageContents();
		theQMLDeclarationsPackage.createPackageContents();
		theQMLContractPackage.createPackageContents();
		theQMLContractTypePackage.createPackageContents();

		// Initialize created meta-data
		theQMLProfilePackage.initializePackageContents();
		theQMLDeclarationsPackage.initializePackageContents();
		theQMLContractPackage.initializePackageContents();
		theQMLContractTypePackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theQMLProfilePackage, 
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return QMLProfileValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theQMLProfilePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(QMLProfilePackage.eNS_URI, theQMLProfilePackage);
		return theQMLProfilePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimpleQMLProfile() {
		return simpleQMLProfileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSimpleQMLProfile_UsageModel() {
		return (EReference)simpleQMLProfileEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSimpleQMLProfile_Requirements() {
		return (EReference)simpleQMLProfileEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getGenericQMLProfile() {
		return genericQMLProfileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRequirement() {
		return requirementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRequirement_RequireContract() {
		return (EReference)requirementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRefinedQMLProfile() {
		return refinedQMLProfileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRefinedQMLProfile_BaseProfile() {
		return (EReference)refinedQMLProfileEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRefinedQMLProfile_RefinedBy() {
		return (EReference)refinedQMLProfileEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUsageScenarioRequirement() {
		return usageScenarioRequirementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getUsageScenarioRequirement_UsageScenario() {
		return (EReference)usageScenarioRequirementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEntryLevelSystemCallRequirement() {
		return entryLevelSystemCallRequirementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEntryLevelSystemCallRequirement_EntryLevelSystemCall() {
		return (EReference)entryLevelSystemCallRequirementEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QMLProfileFactory getQMLProfileFactory() {
		return (QMLProfileFactory)getEFactoryInstance();
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
		simpleQMLProfileEClass = createEClass(SIMPLE_QML_PROFILE);
		createEReference(simpleQMLProfileEClass, SIMPLE_QML_PROFILE__USAGE_MODEL);
		createEReference(simpleQMLProfileEClass, SIMPLE_QML_PROFILE__REQUIREMENTS);

		genericQMLProfileEClass = createEClass(GENERIC_QML_PROFILE);

		requirementEClass = createEClass(REQUIREMENT);
		createEReference(requirementEClass, REQUIREMENT__REQUIRE_CONTRACT);

		refinedQMLProfileEClass = createEClass(REFINED_QML_PROFILE);
		createEReference(refinedQMLProfileEClass, REFINED_QML_PROFILE__BASE_PROFILE);
		createEReference(refinedQMLProfileEClass, REFINED_QML_PROFILE__REFINED_BY);

		usageScenarioRequirementEClass = createEClass(USAGE_SCENARIO_REQUIREMENT);
		createEReference(usageScenarioRequirementEClass, USAGE_SCENARIO_REQUIREMENT__USAGE_SCENARIO);

		entryLevelSystemCallRequirementEClass = createEClass(ENTRY_LEVEL_SYSTEM_CALL_REQUIREMENT);
		createEReference(entryLevelSystemCallRequirementEClass, ENTRY_LEVEL_SYSTEM_CALL_REQUIREMENT__ENTRY_LEVEL_SYSTEM_CALL);
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
		UsagemodelPackage theUsagemodelPackage = (UsagemodelPackage)EPackage.Registry.INSTANCE.getEPackage(UsagemodelPackage.eNS_URI);
		QMLDeclarationsPackage theQMLDeclarationsPackage = (QMLDeclarationsPackage)EPackage.Registry.INSTANCE.getEPackage(QMLDeclarationsPackage.eNS_URI);
		IdentifierPackage theIdentifierPackage = (IdentifierPackage)EPackage.Registry.INSTANCE.getEPackage(IdentifierPackage.eNS_URI);
		QMLContractPackage theQMLContractPackage = (QMLContractPackage)EPackage.Registry.INSTANCE.getEPackage(QMLContractPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		simpleQMLProfileEClass.getESuperTypes().add(this.getGenericQMLProfile());
		genericQMLProfileEClass.getESuperTypes().add(theQMLDeclarationsPackage.getQMLDeclaration());
		requirementEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
		refinedQMLProfileEClass.getESuperTypes().add(this.getGenericQMLProfile());
		usageScenarioRequirementEClass.getESuperTypes().add(this.getRequirement());
		entryLevelSystemCallRequirementEClass.getESuperTypes().add(this.getRequirement());

		// Initialize classes and features; add operations and parameters
		initEClass(simpleQMLProfileEClass, SimpleQMLProfile.class, "SimpleQMLProfile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSimpleQMLProfile_UsageModel(), theUsagemodelPackage.getUsageModel(), null, "usageModel", null, 1, 1, SimpleQMLProfile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSimpleQMLProfile_Requirements(), this.getRequirement(), null, "requirements", null, 0, -1, SimpleQMLProfile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(genericQMLProfileEClass, GenericQMLProfile.class, "GenericQMLProfile", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(requirementEClass, Requirement.class, "Requirement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRequirement_RequireContract(), theQMLContractPackage.getGenericQMLContract(), null, "requireContract", null, 1, -1, Requirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(refinedQMLProfileEClass, RefinedQMLProfile.class, "RefinedQMLProfile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRefinedQMLProfile_BaseProfile(), this.getGenericQMLProfile(), null, "baseProfile", null, 1, 1, RefinedQMLProfile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getRefinedQMLProfile_RefinedBy(), this.getRequirement(), null, "refinedBy", null, 0, -1, RefinedQMLProfile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		EOperation op = addEOperation(refinedQMLProfileEClass, ecorePackage.getEBoolean(), "profile_cannot_refine_itself", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getEMap());
		EGenericType g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(usageScenarioRequirementEClass, UsageScenarioRequirement.class, "UsageScenarioRequirement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getUsageScenarioRequirement_UsageScenario(), theUsagemodelPackage.getUsageScenario(), null, "usageScenario", null, 0, 1, UsageScenarioRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(entryLevelSystemCallRequirementEClass, EntryLevelSystemCallRequirement.class, "EntryLevelSystemCallRequirement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEntryLevelSystemCallRequirement_EntryLevelSystemCall(), theUsagemodelPackage.getEntryLevelSystemCall(), null, "entryLevelSystemCall", null, 0, 1, EntryLevelSystemCallRequirement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //QMLProfilePackageImpl
