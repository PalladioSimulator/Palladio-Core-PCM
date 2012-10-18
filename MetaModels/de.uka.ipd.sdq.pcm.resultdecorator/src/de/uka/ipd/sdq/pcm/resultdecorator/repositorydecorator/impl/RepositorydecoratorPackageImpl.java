/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import de.uka.ipd.sdq.pcm.PcmPackage;
import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;
import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.resultdecorator.ResultdecoratorPackage;
import de.uka.ipd.sdq.pcm.resultdecorator.impl.ResultdecoratorPackageImpl;
import de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.AllocationContextResults;
import de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.AllocationServiceResult;
import de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.ComponentResult;
import de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.InterfaceProvidingRequiringEntityResults;
import de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.RepositorydecoratorFactory;
import de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.RepositorydecoratorPackage;
import de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.ServiceResult;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.ResourceenvironmentdecoratorPackage;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.impl.ResourceenvironmentdecoratorPackageImpl;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RepositorydecoratorPackageImpl extends EPackageImpl implements RepositorydecoratorPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass interfaceProvidingRequiringEntityResultsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass allocationContextResultsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serviceResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass allocationServiceResultEClass = null;

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
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.RepositorydecoratorPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private RepositorydecoratorPackageImpl() {
		super(eNS_URI, RepositorydecoratorFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link RepositorydecoratorPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static RepositorydecoratorPackage init() {
		if (isInited) return (RepositorydecoratorPackage)EPackage.Registry.INSTANCE.getEPackage(RepositorydecoratorPackage.eNS_URI);

		// Obtain or create and register package
		RepositorydecoratorPackageImpl theRepositorydecoratorPackage = (RepositorydecoratorPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof RepositorydecoratorPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new RepositorydecoratorPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		PcmPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		ResultdecoratorPackageImpl theResultdecoratorPackage = (ResultdecoratorPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ResultdecoratorPackage.eNS_URI) instanceof ResultdecoratorPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ResultdecoratorPackage.eNS_URI) : ResultdecoratorPackage.eINSTANCE);
		ResourceenvironmentdecoratorPackageImpl theResourceenvironmentdecoratorPackage = (ResourceenvironmentdecoratorPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ResourceenvironmentdecoratorPackage.eNS_URI) instanceof ResourceenvironmentdecoratorPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ResourceenvironmentdecoratorPackage.eNS_URI) : ResourceenvironmentdecoratorPackage.eINSTANCE);

		// Create package meta-data objects
		theRepositorydecoratorPackage.createPackageContents();
		theResultdecoratorPackage.createPackageContents();
		theResourceenvironmentdecoratorPackage.createPackageContents();

		// Initialize created meta-data
		theRepositorydecoratorPackage.initializePackageContents();
		theResultdecoratorPackage.initializePackageContents();
		theResourceenvironmentdecoratorPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theRepositorydecoratorPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(RepositorydecoratorPackage.eNS_URI, theRepositorydecoratorPackage);
		return theRepositorydecoratorPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInterfaceProvidingRequiringEntityResults() {
		return interfaceProvidingRequiringEntityResultsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInterfaceProvidingRequiringEntityResults_InterfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult() {
		return (EReference)interfaceProvidingRequiringEntityResultsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponentResult() {
		return componentResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponentResult_NormalisedResourceDemand() {
		return (EAttribute)componentResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponentResult_NormalisedResponseTime() {
		return (EAttribute)componentResultEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponentResult_AverageResourceDemand() {
		return (EAttribute)componentResultEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponentResult_MeanResponseTime() {
		return (EAttribute)componentResultEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponentResult_AverageNumberOfSentMessages() {
		return (EAttribute)componentResultEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAllocationContextResults() {
		return allocationContextResultsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAllocationContextResults_AllocationContext_AllocationContextResult() {
		return (EReference)allocationContextResultsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServiceResult() {
		return serviceResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceResult_MeanResponseTime() {
		return (EAttribute)serviceResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getServiceResult_Throughput() {
		return (EAttribute)serviceResultEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getServiceResult_ServiceEffectSpecification_ServiceResult() {
		return (EReference)serviceResultEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAllocationServiceResult() {
		return allocationServiceResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAllocationServiceResult_AllocationContext_AllocationServiceResult() {
		return (EReference)allocationServiceResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RepositorydecoratorFactory getRepositorydecoratorFactory() {
		return (RepositorydecoratorFactory)getEFactoryInstance();
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
		interfaceProvidingRequiringEntityResultsEClass = createEClass(INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS);
		createEReference(interfaceProvidingRequiringEntityResultsEClass, INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS__INTERFACE_PROVIDING_REQUIRING_ENTITY_INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULT);

		componentResultEClass = createEClass(COMPONENT_RESULT);
		createEAttribute(componentResultEClass, COMPONENT_RESULT__NORMALISED_RESOURCE_DEMAND);
		createEAttribute(componentResultEClass, COMPONENT_RESULT__NORMALISED_RESPONSE_TIME);
		createEAttribute(componentResultEClass, COMPONENT_RESULT__AVERAGE_RESOURCE_DEMAND);
		createEAttribute(componentResultEClass, COMPONENT_RESULT__MEAN_RESPONSE_TIME);
		createEAttribute(componentResultEClass, COMPONENT_RESULT__AVERAGE_NUMBER_OF_SENT_MESSAGES);

		allocationContextResultsEClass = createEClass(ALLOCATION_CONTEXT_RESULTS);
		createEReference(allocationContextResultsEClass, ALLOCATION_CONTEXT_RESULTS__ALLOCATION_CONTEXT_ALLOCATION_CONTEXT_RESULT);

		serviceResultEClass = createEClass(SERVICE_RESULT);
		createEAttribute(serviceResultEClass, SERVICE_RESULT__MEAN_RESPONSE_TIME);
		createEAttribute(serviceResultEClass, SERVICE_RESULT__THROUGHPUT);
		createEReference(serviceResultEClass, SERVICE_RESULT__SERVICE_EFFECT_SPECIFICATION_SERVICE_RESULT);

		allocationServiceResultEClass = createEClass(ALLOCATION_SERVICE_RESULT);
		createEReference(allocationServiceResultEClass, ALLOCATION_SERVICE_RESULT__ALLOCATION_CONTEXT_ALLOCATION_SERVICE_RESULT);
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
		EntityPackage theEntityPackage = (EntityPackage)EPackage.Registry.INSTANCE.getEPackage(EntityPackage.eNS_URI);
		AllocationPackage theAllocationPackage = (AllocationPackage)EPackage.Registry.INSTANCE.getEPackage(AllocationPackage.eNS_URI);
		SeffPackage theSeffPackage = (SeffPackage)EPackage.Registry.INSTANCE.getEPackage(SeffPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		interfaceProvidingRequiringEntityResultsEClass.getESuperTypes().add(this.getComponentResult());
		componentResultEClass.getESuperTypes().add(theEntityPackage.getNamedElement());
		allocationContextResultsEClass.getESuperTypes().add(this.getComponentResult());
		allocationServiceResultEClass.getESuperTypes().add(this.getServiceResult());

		// Initialize classes and features; add operations and parameters
		initEClass(interfaceProvidingRequiringEntityResultsEClass, InterfaceProvidingRequiringEntityResults.class, "InterfaceProvidingRequiringEntityResults", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInterfaceProvidingRequiringEntityResults_InterfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult(), theEntityPackage.getInterfaceProvidingRequiringEntity(), null, "interfaceProvidingRequiringEntity_InterfaceProvidingRequiringEntityResult", null, 0, 1, InterfaceProvidingRequiringEntityResults.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(componentResultEClass, ComponentResult.class, "ComponentResult", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getComponentResult_NormalisedResourceDemand(), ecorePackage.getEDouble(), "normalisedResourceDemand", null, 1, 1, ComponentResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getComponentResult_NormalisedResponseTime(), ecorePackage.getEDouble(), "normalisedResponseTime", null, 1, 1, ComponentResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getComponentResult_AverageResourceDemand(), ecorePackage.getEDouble(), "averageResourceDemand", null, 1, 1, ComponentResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getComponentResult_MeanResponseTime(), ecorePackage.getEDouble(), "meanResponseTime", null, 1, 1, ComponentResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getComponentResult_AverageNumberOfSentMessages(), ecorePackage.getEDouble(), "averageNumberOfSentMessages", null, 1, 1, ComponentResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(allocationContextResultsEClass, AllocationContextResults.class, "AllocationContextResults", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAllocationContextResults_AllocationContext_AllocationContextResult(), theAllocationPackage.getAllocationContext(), null, "allocationContext_AllocationContextResult", null, 0, 1, AllocationContextResults.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(serviceResultEClass, ServiceResult.class, "ServiceResult", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getServiceResult_MeanResponseTime(), ecorePackage.getEDouble(), "meanResponseTime", null, 1, 1, ServiceResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getServiceResult_Throughput(), ecorePackage.getEDouble(), "throughput", null, 1, 1, ServiceResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getServiceResult_ServiceEffectSpecification_ServiceResult(), theSeffPackage.getServiceEffectSpecification(), null, "serviceEffectSpecification_ServiceResult", null, 1, 1, ServiceResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(allocationServiceResultEClass, AllocationServiceResult.class, "AllocationServiceResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAllocationServiceResult_AllocationContext_AllocationServiceResult(), theAllocationPackage.getAllocationContext(), null, "allocationContext_AllocationServiceResult", null, 1, 1, AllocationServiceResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
	}

} //RepositorydecoratorPackageImpl
