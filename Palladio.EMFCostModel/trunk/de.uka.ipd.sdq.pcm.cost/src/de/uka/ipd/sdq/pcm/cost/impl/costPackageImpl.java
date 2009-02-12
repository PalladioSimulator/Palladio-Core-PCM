/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.cost.impl;

import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;

import de.uka.ipd.sdq.pcm.core.CorePackage;

import de.uka.ipd.sdq.pcm.cost.ComponentCost;
import de.uka.ipd.sdq.pcm.cost.Cost;
import de.uka.ipd.sdq.pcm.cost.CostRepository;
import de.uka.ipd.sdq.pcm.cost.FixedLinkingResourceCost;
import de.uka.ipd.sdq.pcm.cost.FixedProcessingResourceCost;
import de.uka.ipd.sdq.pcm.cost.VariableCost;
import de.uka.ipd.sdq.pcm.cost.VariableLinkingResourceCost;
import de.uka.ipd.sdq.pcm.cost.VariableProcessingResourceCost;
import de.uka.ipd.sdq.pcm.cost.costFactory;
import de.uka.ipd.sdq.pcm.cost.costPackage;

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
public class costPackageImpl extends EPackageImpl implements costPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentCostEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass costEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fixedLinkingResourceCostEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fixedProcessingResourceCostEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableCostEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableLinkingResourceCostEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variableProcessingResourceCostEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass costRepositoryEClass = null;

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
	 * @see de.uka.ipd.sdq.pcm.cost.costPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private costPackageImpl() {
		super(eNS_URI, costFactory.eINSTANCE);
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
	public static costPackage init() {
		if (isInited) return (costPackage)EPackage.Registry.INSTANCE.getEPackage(costPackage.eNS_URI);

		// Obtain or create and register package
		costPackageImpl thecostPackage = (costPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof costPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new costPackageImpl());

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

		// Create package meta-data objects
		thecostPackage.createPackageContents();

		// Initialize created meta-data
		thecostPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thecostPackage.freeze();

		return thecostPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponentCost() {
		return componentCostEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponentCost_ComponentOperatingCost() {
		return (EAttribute)componentCostEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponentCost_ComponentInitialCost() {
		return (EAttribute)componentCostEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentCost_RepositoryComponent() {
		return (EReference)componentCostEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCost() {
		return costEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCost_OperatingCost() {
		return (EAttribute)costEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCost_InitialCost() {
		return (EAttribute)costEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFixedLinkingResourceCost() {
		return fixedLinkingResourceCostEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFixedLinkingResourceCost_Linkingresource() {
		return (EReference)fixedLinkingResourceCostEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFixedProcessingResourceCost() {
		return fixedProcessingResourceCostEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFixedProcessingResourceCost_Processingresourcespecification() {
		return (EReference)fixedProcessingResourceCostEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariableCost() {
		return variableCostEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariableCost_FixedInitialCost() {
		return (EAttribute)variableCostEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariableCost_FixedOperatingCost() {
		return (EAttribute)variableCostEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariableLinkingResourceCost() {
		return variableLinkingResourceCostEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariableLinkingResourceCost_BandwithInitialFactor() {
		return (EAttribute)variableLinkingResourceCostEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariableLinkingResourceCost_BandwidthOperatingFactor() {
		return (EAttribute)variableLinkingResourceCostEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableLinkingResourceCost_Linkingresource() {
		return (EReference)variableLinkingResourceCostEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVariableProcessingResourceCost() {
		return variableProcessingResourceCostEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariableProcessingResourceCost_ProcessingRateInitialFactor() {
		return (EAttribute)variableProcessingResourceCostEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVariableProcessingResourceCost_ProcessingRateOperatingFactor() {
		return (EAttribute)variableProcessingResourceCostEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableProcessingResourceCost_Processingresourcespecification() {
		return (EReference)variableProcessingResourceCostEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCostRepository() {
		return costRepositoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCostRepository_Cost() {
		return (EReference)costRepositoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public costFactory getcostFactory() {
		return (costFactory)getEFactoryInstance();
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
		componentCostEClass = createEClass(COMPONENT_COST);
		createEAttribute(componentCostEClass, COMPONENT_COST__COMPONENT_OPERATING_COST);
		createEAttribute(componentCostEClass, COMPONENT_COST__COMPONENT_INITIAL_COST);
		createEReference(componentCostEClass, COMPONENT_COST__REPOSITORY_COMPONENT);

		costEClass = createEClass(COST);
		createEAttribute(costEClass, COST__OPERATING_COST);
		createEAttribute(costEClass, COST__INITIAL_COST);

		fixedLinkingResourceCostEClass = createEClass(FIXED_LINKING_RESOURCE_COST);
		createEReference(fixedLinkingResourceCostEClass, FIXED_LINKING_RESOURCE_COST__LINKINGRESOURCE);

		fixedProcessingResourceCostEClass = createEClass(FIXED_PROCESSING_RESOURCE_COST);
		createEReference(fixedProcessingResourceCostEClass, FIXED_PROCESSING_RESOURCE_COST__PROCESSINGRESOURCESPECIFICATION);

		variableCostEClass = createEClass(VARIABLE_COST);
		createEAttribute(variableCostEClass, VARIABLE_COST__FIXED_INITIAL_COST);
		createEAttribute(variableCostEClass, VARIABLE_COST__FIXED_OPERATING_COST);

		variableLinkingResourceCostEClass = createEClass(VARIABLE_LINKING_RESOURCE_COST);
		createEAttribute(variableLinkingResourceCostEClass, VARIABLE_LINKING_RESOURCE_COST__BANDWITH_INITIAL_FACTOR);
		createEAttribute(variableLinkingResourceCostEClass, VARIABLE_LINKING_RESOURCE_COST__BANDWIDTH_OPERATING_FACTOR);
		createEReference(variableLinkingResourceCostEClass, VARIABLE_LINKING_RESOURCE_COST__LINKINGRESOURCE);

		variableProcessingResourceCostEClass = createEClass(VARIABLE_PROCESSING_RESOURCE_COST);
		createEAttribute(variableProcessingResourceCostEClass, VARIABLE_PROCESSING_RESOURCE_COST__PROCESSING_RATE_INITIAL_FACTOR);
		createEAttribute(variableProcessingResourceCostEClass, VARIABLE_PROCESSING_RESOURCE_COST__PROCESSING_RATE_OPERATING_FACTOR);
		createEReference(variableProcessingResourceCostEClass, VARIABLE_PROCESSING_RESOURCE_COST__PROCESSINGRESOURCESPECIFICATION);

		costRepositoryEClass = createEClass(COST_REPOSITORY);
		createEReference(costRepositoryEClass, COST_REPOSITORY__COST);
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
		RepositoryPackage theRepositoryPackage = (RepositoryPackage)EPackage.Registry.INSTANCE.getEPackage(RepositoryPackage.eNS_URI);
		ResourceenvironmentPackage theResourceenvironmentPackage = (ResourceenvironmentPackage)EPackage.Registry.INSTANCE.getEPackage(ResourceenvironmentPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		componentCostEClass.getESuperTypes().add(this.getCost());
		fixedLinkingResourceCostEClass.getESuperTypes().add(this.getCost());
		fixedProcessingResourceCostEClass.getESuperTypes().add(this.getCost());
		variableCostEClass.getESuperTypes().add(this.getCost());
		variableLinkingResourceCostEClass.getESuperTypes().add(this.getVariableCost());
		variableProcessingResourceCostEClass.getESuperTypes().add(this.getVariableCost());

		// Initialize classes and features; add operations and parameters
		initEClass(componentCostEClass, ComponentCost.class, "ComponentCost", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getComponentCost_ComponentOperatingCost(), ecorePackage.getEDouble(), "componentOperatingCost", null, 1, 1, ComponentCost.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getComponentCost_ComponentInitialCost(), ecorePackage.getEDouble(), "componentInitialCost", null, 1, 1, ComponentCost.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getComponentCost_RepositoryComponent(), theRepositoryPackage.getRepositoryComponent(), null, "repositoryComponent", null, 1, 1, ComponentCost.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(costEClass, Cost.class, "Cost", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCost_OperatingCost(), ecorePackage.getEDouble(), "operatingCost", null, 1, 1, Cost.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCost_InitialCost(), ecorePackage.getEDouble(), "initialCost", null, 1, 1, Cost.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);

		initEClass(fixedLinkingResourceCostEClass, FixedLinkingResourceCost.class, "FixedLinkingResourceCost", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFixedLinkingResourceCost_Linkingresource(), theResourceenvironmentPackage.getLinkingResource(), null, "linkingresource", null, 1, 1, FixedLinkingResourceCost.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(fixedProcessingResourceCostEClass, FixedProcessingResourceCost.class, "FixedProcessingResourceCost", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFixedProcessingResourceCost_Processingresourcespecification(), theResourceenvironmentPackage.getProcessingResourceSpecification(), null, "processingresourcespecification", null, 1, 1, FixedProcessingResourceCost.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(variableCostEClass, VariableCost.class, "VariableCost", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVariableCost_FixedInitialCost(), ecorePackage.getEDouble(), "fixedInitialCost", null, 1, 1, VariableCost.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getVariableCost_FixedOperatingCost(), ecorePackage.getEDouble(), "fixedOperatingCost", null, 1, 1, VariableCost.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(variableLinkingResourceCostEClass, VariableLinkingResourceCost.class, "VariableLinkingResourceCost", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVariableLinkingResourceCost_BandwithInitialFactor(), ecorePackage.getEDouble(), "bandwithInitialFactor", null, 1, 1, VariableLinkingResourceCost.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getVariableLinkingResourceCost_BandwidthOperatingFactor(), ecorePackage.getEDouble(), "bandwidthOperatingFactor", null, 1, 1, VariableLinkingResourceCost.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getVariableLinkingResourceCost_Linkingresource(), theResourceenvironmentPackage.getLinkingResource(), null, "linkingresource", null, 1, 1, VariableLinkingResourceCost.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(variableProcessingResourceCostEClass, VariableProcessingResourceCost.class, "VariableProcessingResourceCost", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVariableProcessingResourceCost_ProcessingRateInitialFactor(), ecorePackage.getEDouble(), "processingRateInitialFactor", null, 1, 1, VariableProcessingResourceCost.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getVariableProcessingResourceCost_ProcessingRateOperatingFactor(), ecorePackage.getEDouble(), "processingRateOperatingFactor", null, 1, 1, VariableProcessingResourceCost.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getVariableProcessingResourceCost_Processingresourcespecification(), theResourceenvironmentPackage.getProcessingResourceSpecification(), null, "processingresourcespecification", null, 1, 1, VariableProcessingResourceCost.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(costRepositoryEClass, CostRepository.class, "CostRepository", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCostRepository_Cost(), this.getCost(), null, "cost", null, 0, -1, CostRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //costPackageImpl
