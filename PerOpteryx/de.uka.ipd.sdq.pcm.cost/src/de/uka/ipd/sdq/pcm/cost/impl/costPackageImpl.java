/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.cost.impl;

import de.uka.ipd.sdq.pcm.PcmPackage;
import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;

import de.uka.ipd.sdq.pcm.cost.ComponentCost;
import de.uka.ipd.sdq.pcm.cost.ComponentCostPerInstance;
import de.uka.ipd.sdq.pcm.cost.Cost;
import de.uka.ipd.sdq.pcm.cost.CostRepository;
import de.uka.ipd.sdq.pcm.cost.FixedLinkingResourceCost;
import de.uka.ipd.sdq.pcm.cost.FixedProcessingResourceCost;
import de.uka.ipd.sdq.pcm.cost.LinkingResourceCost;
import de.uka.ipd.sdq.pcm.cost.ProcessingResourceCost;
import de.uka.ipd.sdq.pcm.cost.ScalarFunction;
import de.uka.ipd.sdq.pcm.cost.VariableCost;
import de.uka.ipd.sdq.pcm.cost.VariableLinkingResourceCost;
import de.uka.ipd.sdq.pcm.cost.VariableProcessingResourceCost;
import de.uka.ipd.sdq.pcm.cost.costFactory;
import de.uka.ipd.sdq.pcm.cost.costPackage;

import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;

import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;

import de.uka.ipd.sdq.stoex.StoexPackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
	private EClass linkingResourceCostEClass = null;

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
	private EClass processingResourceCostEClass = null;

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
	private EClass scalarFunctionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass costRepositoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentCostPerInstanceEClass = null;

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
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link costPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
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
		costPackageImpl thecostPackage = (costPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof costPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new costPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		EcorePackage.eINSTANCE.eClass();
		PcmPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		thecostPackage.createPackageContents();

		// Initialize created meta-data
		thecostPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thecostPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(costPackage.eNS_URI, thecostPackage);
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
	public EReference getCost_AnnotatedElement() {
		return (EReference)costEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCost_OperatingCost() {
		return (EAttribute)costEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCost_InitialCost() {
		return (EAttribute)costEClass.getEStructuralFeatures().get(2);
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
	public EClass getLinkingResourceCost() {
		return linkingResourceCostEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLinkingResourceCost_Linkingresource() {
		return (EReference)linkingResourceCostEClass.getEStructuralFeatures().get(0);
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
	public EAttribute getFixedProcessingResourceCost_FixedOperatingCost() {
		return (EAttribute)fixedProcessingResourceCostEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFixedProcessingResourceCost_FixedInitialCost() {
		return (EAttribute)fixedProcessingResourceCostEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProcessingResourceCost() {
		return processingResourceCostEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcessingResourceCost_Processingresourcespecification() {
		return (EReference)processingResourceCostEClass.getEStructuralFeatures().get(0);
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
	public EClass getVariableProcessingResourceCost() {
		return variableProcessingResourceCostEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableProcessingResourceCost_ProcessingRateInitialFunction() {
		return (EReference)variableProcessingResourceCostEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVariableProcessingResourceCost_ProcessingRateOperatingFunction() {
		return (EReference)variableProcessingResourceCostEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getScalarFunction() {
		return scalarFunctionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getScalarFunction_Specification() {
		return (EAttribute)scalarFunctionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getScalarFunction_Term() {
		return (EReference)scalarFunctionEClass.getEStructuralFeatures().get(1);
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
	public EAttribute getCostRepository_TimePeriodYears() {
		return (EAttribute)costRepositoryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCostRepository_Interest() {
		return (EAttribute)costRepositoryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponentCostPerInstance() {
		return componentCostPerInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentCostPerInstance_Allocation() {
		return (EReference)componentCostPerInstanceEClass.getEStructuralFeatures().get(0);
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
		createEReference(costEClass, COST__ANNOTATED_ELEMENT);
		createEAttribute(costEClass, COST__OPERATING_COST);
		createEAttribute(costEClass, COST__INITIAL_COST);

		fixedLinkingResourceCostEClass = createEClass(FIXED_LINKING_RESOURCE_COST);

		linkingResourceCostEClass = createEClass(LINKING_RESOURCE_COST);
		createEReference(linkingResourceCostEClass, LINKING_RESOURCE_COST__LINKINGRESOURCE);

		fixedProcessingResourceCostEClass = createEClass(FIXED_PROCESSING_RESOURCE_COST);
		createEAttribute(fixedProcessingResourceCostEClass, FIXED_PROCESSING_RESOURCE_COST__FIXED_OPERATING_COST);
		createEAttribute(fixedProcessingResourceCostEClass, FIXED_PROCESSING_RESOURCE_COST__FIXED_INITIAL_COST);

		processingResourceCostEClass = createEClass(PROCESSING_RESOURCE_COST);
		createEReference(processingResourceCostEClass, PROCESSING_RESOURCE_COST__PROCESSINGRESOURCESPECIFICATION);

		variableCostEClass = createEClass(VARIABLE_COST);
		createEAttribute(variableCostEClass, VARIABLE_COST__FIXED_INITIAL_COST);
		createEAttribute(variableCostEClass, VARIABLE_COST__FIXED_OPERATING_COST);

		variableLinkingResourceCostEClass = createEClass(VARIABLE_LINKING_RESOURCE_COST);
		createEAttribute(variableLinkingResourceCostEClass, VARIABLE_LINKING_RESOURCE_COST__BANDWITH_INITIAL_FACTOR);
		createEAttribute(variableLinkingResourceCostEClass, VARIABLE_LINKING_RESOURCE_COST__BANDWIDTH_OPERATING_FACTOR);

		variableProcessingResourceCostEClass = createEClass(VARIABLE_PROCESSING_RESOURCE_COST);
		createEReference(variableProcessingResourceCostEClass, VARIABLE_PROCESSING_RESOURCE_COST__PROCESSING_RATE_INITIAL_FUNCTION);
		createEReference(variableProcessingResourceCostEClass, VARIABLE_PROCESSING_RESOURCE_COST__PROCESSING_RATE_OPERATING_FUNCTION);

		scalarFunctionEClass = createEClass(SCALAR_FUNCTION);
		createEAttribute(scalarFunctionEClass, SCALAR_FUNCTION__SPECIFICATION);
		createEReference(scalarFunctionEClass, SCALAR_FUNCTION__TERM);

		costRepositoryEClass = createEClass(COST_REPOSITORY);
		createEReference(costRepositoryEClass, COST_REPOSITORY__COST);
		createEAttribute(costRepositoryEClass, COST_REPOSITORY__TIME_PERIOD_YEARS);
		createEAttribute(costRepositoryEClass, COST_REPOSITORY__INTEREST);

		componentCostPerInstanceEClass = createEClass(COMPONENT_COST_PER_INSTANCE);
		createEReference(componentCostPerInstanceEClass, COMPONENT_COST_PER_INSTANCE__ALLOCATION);
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
		EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);
		ResourceenvironmentPackage theResourceenvironmentPackage = (ResourceenvironmentPackage)EPackage.Registry.INSTANCE.getEPackage(ResourceenvironmentPackage.eNS_URI);
		StoexPackage theStoexPackage = (StoexPackage)EPackage.Registry.INSTANCE.getEPackage(StoexPackage.eNS_URI);
		AllocationPackage theAllocationPackage = (AllocationPackage)EPackage.Registry.INSTANCE.getEPackage(AllocationPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		componentCostEClass.getESuperTypes().add(this.getCost());
		fixedLinkingResourceCostEClass.getESuperTypes().add(this.getLinkingResourceCost());
		fixedLinkingResourceCostEClass.getESuperTypes().add(this.getCost());
		linkingResourceCostEClass.getESuperTypes().add(this.getCost());
		fixedProcessingResourceCostEClass.getESuperTypes().add(this.getProcessingResourceCost());
		fixedProcessingResourceCostEClass.getESuperTypes().add(this.getCost());
		processingResourceCostEClass.getESuperTypes().add(this.getCost());
		variableCostEClass.getESuperTypes().add(this.getCost());
		variableLinkingResourceCostEClass.getESuperTypes().add(this.getVariableCost());
		variableLinkingResourceCostEClass.getESuperTypes().add(this.getLinkingResourceCost());
		variableProcessingResourceCostEClass.getESuperTypes().add(this.getVariableCost());
		variableProcessingResourceCostEClass.getESuperTypes().add(this.getProcessingResourceCost());
		componentCostPerInstanceEClass.getESuperTypes().add(this.getComponentCost());

		// Initialize classes and features; add operations and parameters
		initEClass(componentCostEClass, ComponentCost.class, "ComponentCost", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getComponentCost_ComponentOperatingCost(), ecorePackage.getEDouble(), "componentOperatingCost", null, 1, 1, ComponentCost.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getComponentCost_ComponentInitialCost(), ecorePackage.getEDouble(), "componentInitialCost", null, 1, 1, ComponentCost.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getComponentCost_RepositoryComponent(), theRepositoryPackage.getRepositoryComponent(), null, "repositoryComponent", null, 1, 1, ComponentCost.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(costEClass, Cost.class, "Cost", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCost_AnnotatedElement(), theEcorePackage.getEObject(), null, "annotatedElement", null, 1, 1, Cost.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCost_OperatingCost(), ecorePackage.getEDouble(), "operatingCost", null, 1, 1, Cost.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCost_InitialCost(), ecorePackage.getEDouble(), "initialCost", null, 1, 1, Cost.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);

		initEClass(fixedLinkingResourceCostEClass, FixedLinkingResourceCost.class, "FixedLinkingResourceCost", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(linkingResourceCostEClass, LinkingResourceCost.class, "LinkingResourceCost", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLinkingResourceCost_Linkingresource(), theResourceenvironmentPackage.getLinkingResource(), null, "linkingresource", null, 1, 1, LinkingResourceCost.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(fixedProcessingResourceCostEClass, FixedProcessingResourceCost.class, "FixedProcessingResourceCost", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFixedProcessingResourceCost_FixedOperatingCost(), theEcorePackage.getEDouble(), "fixedOperatingCost", null, 1, 1, FixedProcessingResourceCost.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getFixedProcessingResourceCost_FixedInitialCost(), theEcorePackage.getEDouble(), "fixedInitialCost", null, 1, 1, FixedProcessingResourceCost.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(processingResourceCostEClass, ProcessingResourceCost.class, "ProcessingResourceCost", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProcessingResourceCost_Processingresourcespecification(), theResourceenvironmentPackage.getProcessingResourceSpecification(), null, "processingresourcespecification", null, 1, 1, ProcessingResourceCost.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(variableCostEClass, VariableCost.class, "VariableCost", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVariableCost_FixedInitialCost(), ecorePackage.getEDouble(), "fixedInitialCost", null, 1, 1, VariableCost.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getVariableCost_FixedOperatingCost(), ecorePackage.getEDouble(), "fixedOperatingCost", null, 1, 1, VariableCost.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(variableLinkingResourceCostEClass, VariableLinkingResourceCost.class, "VariableLinkingResourceCost", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVariableLinkingResourceCost_BandwithInitialFactor(), ecorePackage.getEDouble(), "bandwithInitialFactor", null, 1, 1, VariableLinkingResourceCost.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getVariableLinkingResourceCost_BandwidthOperatingFactor(), ecorePackage.getEDouble(), "bandwidthOperatingFactor", null, 1, 1, VariableLinkingResourceCost.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(variableProcessingResourceCostEClass, VariableProcessingResourceCost.class, "VariableProcessingResourceCost", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVariableProcessingResourceCost_ProcessingRateInitialFunction(), this.getScalarFunction(), null, "processingRateInitialFunction", null, 1, 1, VariableProcessingResourceCost.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getVariableProcessingResourceCost_ProcessingRateOperatingFunction(), this.getScalarFunction(), null, "processingRateOperatingFunction", null, 1, 1, VariableProcessingResourceCost.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(scalarFunctionEClass, ScalarFunction.class, "ScalarFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getScalarFunction_Specification(), ecorePackage.getEString(), "specification", null, 1, 1, ScalarFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getScalarFunction_Term(), theStoexPackage.getTerm(), null, "term", null, 1, 1, ScalarFunction.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, IS_UNSETTABLE, IS_UNIQUE, IS_DERIVED, !IS_ORDERED);

		initEClass(costRepositoryEClass, CostRepository.class, "CostRepository", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCostRepository_Cost(), this.getCost(), null, "cost", null, 0, -1, CostRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCostRepository_TimePeriodYears(), ecorePackage.getEInt(), "timePeriodYears", null, 1, 1, CostRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getCostRepository_Interest(), ecorePackage.getEDouble(), "interest", null, 1, 1, CostRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(componentCostPerInstanceEClass, ComponentCostPerInstance.class, "ComponentCostPerInstance", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComponentCostPerInstance_Allocation(), theAllocationPackage.getAllocation(), null, "allocation", null, 0, 1, ComponentCostPerInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";										
		addAnnotation
		  (getScalarFunction_Term(), 
		   source, 
		   new String[] {
			 "namespace", ""
		   });					
	}

} //costPackageImpl
