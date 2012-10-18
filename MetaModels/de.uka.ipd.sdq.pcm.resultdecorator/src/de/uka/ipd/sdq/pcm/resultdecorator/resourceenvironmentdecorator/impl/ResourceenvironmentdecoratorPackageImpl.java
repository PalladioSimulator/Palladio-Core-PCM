/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import de.uka.ipd.sdq.pcm.PcmPackage;
import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;
import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;
import de.uka.ipd.sdq.pcm.resultdecorator.ResultdecoratorPackage;
import de.uka.ipd.sdq.pcm.resultdecorator.impl.ResultdecoratorPackageImpl;
import de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.RepositorydecoratorPackage;
import de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.impl.RepositorydecoratorPackageImpl;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.ActiveResourceUtilisationResult;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.LinkingResourceResults;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.PassiveResourceResult;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.ProcessingResourceSpecificationResult;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.ResourceContainerResults;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.ResourceenvironmentdecoratorFactory;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.ResourceenvironmentdecoratorPackage;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ResourceenvironmentdecoratorPackageImpl extends EPackageImpl implements ResourceenvironmentdecoratorPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass linkingResourceResultsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass activeResourceUtilisationResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass utilisationResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceContainerResultsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass processingResourceSpecificationResultEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass passiveResourceResultEClass = null;

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
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.ResourceenvironmentdecoratorPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ResourceenvironmentdecoratorPackageImpl() {
		super(eNS_URI, ResourceenvironmentdecoratorFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ResourceenvironmentdecoratorPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ResourceenvironmentdecoratorPackage init() {
		if (isInited) return (ResourceenvironmentdecoratorPackage)EPackage.Registry.INSTANCE.getEPackage(ResourceenvironmentdecoratorPackage.eNS_URI);

		// Obtain or create and register package
		ResourceenvironmentdecoratorPackageImpl theResourceenvironmentdecoratorPackage = (ResourceenvironmentdecoratorPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ResourceenvironmentdecoratorPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ResourceenvironmentdecoratorPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		PcmPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		ResultdecoratorPackageImpl theResultdecoratorPackage = (ResultdecoratorPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ResultdecoratorPackage.eNS_URI) instanceof ResultdecoratorPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ResultdecoratorPackage.eNS_URI) : ResultdecoratorPackage.eINSTANCE);
		RepositorydecoratorPackageImpl theRepositorydecoratorPackage = (RepositorydecoratorPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RepositorydecoratorPackage.eNS_URI) instanceof RepositorydecoratorPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RepositorydecoratorPackage.eNS_URI) : RepositorydecoratorPackage.eINSTANCE);

		// Create package meta-data objects
		theResourceenvironmentdecoratorPackage.createPackageContents();
		theResultdecoratorPackage.createPackageContents();
		theRepositorydecoratorPackage.createPackageContents();

		// Initialize created meta-data
		theResourceenvironmentdecoratorPackage.initializePackageContents();
		theResultdecoratorPackage.initializePackageContents();
		theRepositorydecoratorPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theResourceenvironmentdecoratorPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ResourceenvironmentdecoratorPackage.eNS_URI, theResourceenvironmentdecoratorPackage);
		return theResourceenvironmentdecoratorPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLinkingResourceResults() {
		return linkingResourceResultsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getLinkingResourceResults_LinkingResource_LinkingResourceResults() {
		return (EReference)linkingResourceResultsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActiveResourceUtilisationResult() {
		return activeResourceUtilisationResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActiveResourceUtilisationResult_NormalisedDemandedTime() {
		return (EAttribute)activeResourceUtilisationResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getActiveResourceUtilisationResult_DemandedTime() {
		return (EAttribute)activeResourceUtilisationResultEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUtilisationResult() {
		return utilisationResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUtilisationResult_NormalisedResourceUtilisation() {
		return (EAttribute)utilisationResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUtilisationResult_NormalisedWaitTime() {
		return (EAttribute)utilisationResultEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUtilisationResult_ResourceUtilisation() {
		return (EAttribute)utilisationResultEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUtilisationResult_AverageWaitTime() {
		return (EAttribute)utilisationResultEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUtilisationResult_AverageQueueLength() {
		return (EAttribute)utilisationResultEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUtilisationResult_MaxQueueLength() {
		return (EAttribute)utilisationResultEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResourceContainerResults() {
		return resourceContainerResultsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResourceContainerResults_ResourceContainer_ResourceContainerResults() {
		return (EReference)resourceContainerResultsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProcessingResourceSpecificationResult() {
		return processingResourceSpecificationResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProcessingResourceSpecificationResult_ProcessingResourceSpecification_ProcessingResourceSpecificationResult() {
		return (EReference)processingResourceSpecificationResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPassiveResourceResult() {
		return passiveResourceResultEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPassiveResourceResult_PassiveResource_PassiveResourceResult() {
		return (EReference)passiveResourceResultEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPassiveResourceResult_AssemblyContext_PassiveResourceResult() {
		return (EReference)passiveResourceResultEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPassiveResourceResult_AverageHoldingTime() {
		return (EAttribute)passiveResourceResultEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResourceenvironmentdecoratorFactory getResourceenvironmentdecoratorFactory() {
		return (ResourceenvironmentdecoratorFactory)getEFactoryInstance();
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
		linkingResourceResultsEClass = createEClass(LINKING_RESOURCE_RESULTS);
		createEReference(linkingResourceResultsEClass, LINKING_RESOURCE_RESULTS__LINKING_RESOURCE_LINKING_RESOURCE_RESULTS);

		activeResourceUtilisationResultEClass = createEClass(ACTIVE_RESOURCE_UTILISATION_RESULT);
		createEAttribute(activeResourceUtilisationResultEClass, ACTIVE_RESOURCE_UTILISATION_RESULT__NORMALISED_DEMANDED_TIME);
		createEAttribute(activeResourceUtilisationResultEClass, ACTIVE_RESOURCE_UTILISATION_RESULT__DEMANDED_TIME);

		utilisationResultEClass = createEClass(UTILISATION_RESULT);
		createEAttribute(utilisationResultEClass, UTILISATION_RESULT__NORMALISED_RESOURCE_UTILISATION);
		createEAttribute(utilisationResultEClass, UTILISATION_RESULT__NORMALISED_WAIT_TIME);
		createEAttribute(utilisationResultEClass, UTILISATION_RESULT__RESOURCE_UTILISATION);
		createEAttribute(utilisationResultEClass, UTILISATION_RESULT__AVERAGE_WAIT_TIME);
		createEAttribute(utilisationResultEClass, UTILISATION_RESULT__AVERAGE_QUEUE_LENGTH);
		createEAttribute(utilisationResultEClass, UTILISATION_RESULT__MAX_QUEUE_LENGTH);

		resourceContainerResultsEClass = createEClass(RESOURCE_CONTAINER_RESULTS);
		createEReference(resourceContainerResultsEClass, RESOURCE_CONTAINER_RESULTS__RESOURCE_CONTAINER_RESOURCE_CONTAINER_RESULTS);

		processingResourceSpecificationResultEClass = createEClass(PROCESSING_RESOURCE_SPECIFICATION_RESULT);
		createEReference(processingResourceSpecificationResultEClass, PROCESSING_RESOURCE_SPECIFICATION_RESULT__PROCESSING_RESOURCE_SPECIFICATION_PROCESSING_RESOURCE_SPECIFICATION_RESULT);

		passiveResourceResultEClass = createEClass(PASSIVE_RESOURCE_RESULT);
		createEReference(passiveResourceResultEClass, PASSIVE_RESOURCE_RESULT__PASSIVE_RESOURCE_PASSIVE_RESOURCE_RESULT);
		createEReference(passiveResourceResultEClass, PASSIVE_RESOURCE_RESULT__ASSEMBLY_CONTEXT_PASSIVE_RESOURCE_RESULT);
		createEAttribute(passiveResourceResultEClass, PASSIVE_RESOURCE_RESULT__AVERAGE_HOLDING_TIME);
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
		ResourceenvironmentPackage theResourceenvironmentPackage = (ResourceenvironmentPackage)EPackage.Registry.INSTANCE.getEPackage(ResourceenvironmentPackage.eNS_URI);
		EntityPackage theEntityPackage = (EntityPackage)EPackage.Registry.INSTANCE.getEPackage(EntityPackage.eNS_URI);
		RepositoryPackage theRepositoryPackage = (RepositoryPackage)EPackage.Registry.INSTANCE.getEPackage(RepositoryPackage.eNS_URI);
		CompositionPackage theCompositionPackage = (CompositionPackage)EPackage.Registry.INSTANCE.getEPackage(CompositionPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		linkingResourceResultsEClass.getESuperTypes().add(this.getActiveResourceUtilisationResult());
		activeResourceUtilisationResultEClass.getESuperTypes().add(this.getUtilisationResult());
		utilisationResultEClass.getESuperTypes().add(theEntityPackage.getNamedElement());
		resourceContainerResultsEClass.getESuperTypes().add(this.getActiveResourceUtilisationResult());
		processingResourceSpecificationResultEClass.getESuperTypes().add(this.getActiveResourceUtilisationResult());
		passiveResourceResultEClass.getESuperTypes().add(this.getUtilisationResult());

		// Initialize classes and features; add operations and parameters
		initEClass(linkingResourceResultsEClass, LinkingResourceResults.class, "LinkingResourceResults", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLinkingResourceResults_LinkingResource_LinkingResourceResults(), theResourceenvironmentPackage.getLinkingResource(), null, "linkingResource_LinkingResourceResults", null, 0, 1, LinkingResourceResults.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(activeResourceUtilisationResultEClass, ActiveResourceUtilisationResult.class, "ActiveResourceUtilisationResult", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getActiveResourceUtilisationResult_NormalisedDemandedTime(), ecorePackage.getEDouble(), "normalisedDemandedTime", null, 1, 1, ActiveResourceUtilisationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getActiveResourceUtilisationResult_DemandedTime(), ecorePackage.getEDouble(), "demandedTime", "0", 1, 1, ActiveResourceUtilisationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(utilisationResultEClass, UtilisationResult.class, "UtilisationResult", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUtilisationResult_NormalisedResourceUtilisation(), ecorePackage.getEDouble(), "normalisedResourceUtilisation", null, 1, 1, UtilisationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getUtilisationResult_NormalisedWaitTime(), ecorePackage.getEDouble(), "normalisedWaitTime", null, 1, 1, UtilisationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getUtilisationResult_ResourceUtilisation(), ecorePackage.getEDouble(), "resourceUtilisation", "0", 1, 1, UtilisationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getUtilisationResult_AverageWaitTime(), ecorePackage.getEDouble(), "averageWaitTime", "0", 1, 1, UtilisationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getUtilisationResult_AverageQueueLength(), ecorePackage.getEDouble(), "averageQueueLength", "0", 1, 1, UtilisationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getUtilisationResult_MaxQueueLength(), ecorePackage.getEInt(), "maxQueueLength", "0", 1, 1, UtilisationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(resourceContainerResultsEClass, ResourceContainerResults.class, "ResourceContainerResults", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResourceContainerResults_ResourceContainer_ResourceContainerResults(), theResourceenvironmentPackage.getResourceContainer(), null, "resourceContainer_ResourceContainerResults", null, 0, 1, ResourceContainerResults.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(processingResourceSpecificationResultEClass, ProcessingResourceSpecificationResult.class, "ProcessingResourceSpecificationResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProcessingResourceSpecificationResult_ProcessingResourceSpecification_ProcessingResourceSpecificationResult(), theResourceenvironmentPackage.getProcessingResourceSpecification(), null, "processingResourceSpecification_ProcessingResourceSpecificationResult", null, 0, 1, ProcessingResourceSpecificationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(passiveResourceResultEClass, PassiveResourceResult.class, "PassiveResourceResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPassiveResourceResult_PassiveResource_PassiveResourceResult(), theRepositoryPackage.getPassiveResource(), null, "passiveResource_PassiveResourceResult", null, 1, 1, PassiveResourceResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPassiveResourceResult_AssemblyContext_PassiveResourceResult(), theCompositionPackage.getAssemblyContext(), null, "assemblyContext_PassiveResourceResult", null, 0, 1, PassiveResourceResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getPassiveResourceResult_AverageHoldingTime(), ecorePackage.getEDouble(), "averageHoldingTime", null, 1, 1, PassiveResourceResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
	}

} //ResourceenvironmentdecoratorPackageImpl
