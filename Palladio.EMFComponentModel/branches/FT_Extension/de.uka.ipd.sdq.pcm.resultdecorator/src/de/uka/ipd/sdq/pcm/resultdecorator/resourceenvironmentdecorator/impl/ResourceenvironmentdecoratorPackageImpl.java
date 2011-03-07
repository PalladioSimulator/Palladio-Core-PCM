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

import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;
import de.uka.ipd.sdq.pcm.core.CorePackage;
import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.protocol.ProtocolPackage;
import de.uka.ipd.sdq.pcm.qosannotations.QosannotationsPackage;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;
import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;
import de.uka.ipd.sdq.pcm.resultdecorator.ResultdecoratorPackage;
import de.uka.ipd.sdq.pcm.resultdecorator.impl.ResultdecoratorPackageImpl;
import de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.RepositorydecoratorPackage;
import de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.impl.RepositorydecoratorPackageImpl;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.LinkingResourceResults;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.ProcessingResourceSpecificationResult;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.ResourceContainerResults;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.ResourceenvironmentdecoratorFactory;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.ResourceenvironmentdecoratorPackage;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.UtilisationResult;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.subsystem.SubsystemPackage;
import de.uka.ipd.sdq.pcm.system.SystemPackage;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;

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
	public static ResourceenvironmentdecoratorPackage init() {
		if (isInited) return (ResourceenvironmentdecoratorPackage)EPackage.Registry.INSTANCE.getEPackage(ResourceenvironmentdecoratorPackage.eNS_URI);

		// Obtain or create and register package
		ResourceenvironmentdecoratorPackageImpl theResourceenvironmentdecoratorPackage = (ResourceenvironmentdecoratorPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof ResourceenvironmentdecoratorPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new ResourceenvironmentdecoratorPackageImpl());

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
	public EReference getLinkingResourceResults_Linkingresource() {
		return (EReference)linkingResourceResultsEClass.getEStructuralFeatures().get(0);
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
	public EAttribute getUtilisationResult_NormalisedDemandedTime() {
		return (EAttribute)utilisationResultEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUtilisationResult_NormalisedWaitTime() {
		return (EAttribute)utilisationResultEClass.getEStructuralFeatures().get(2);
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
	public EReference getResourceContainerResults_Resourcecontainer() {
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
	public EReference getProcessingResourceSpecificationResult_Processingresourcespecification() {
		return (EReference)processingResourceSpecificationResultEClass.getEStructuralFeatures().get(0);
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
		createEReference(linkingResourceResultsEClass, LINKING_RESOURCE_RESULTS__LINKINGRESOURCE);

		utilisationResultEClass = createEClass(UTILISATION_RESULT);
		createEAttribute(utilisationResultEClass, UTILISATION_RESULT__NORMALISED_RESOURCE_UTILISATION);
		createEAttribute(utilisationResultEClass, UTILISATION_RESULT__NORMALISED_DEMANDED_TIME);
		createEAttribute(utilisationResultEClass, UTILISATION_RESULT__NORMALISED_WAIT_TIME);

		resourceContainerResultsEClass = createEClass(RESOURCE_CONTAINER_RESULTS);
		createEReference(resourceContainerResultsEClass, RESOURCE_CONTAINER_RESULTS__RESOURCECONTAINER);

		processingResourceSpecificationResultEClass = createEClass(PROCESSING_RESOURCE_SPECIFICATION_RESULT);
		createEReference(processingResourceSpecificationResultEClass, PROCESSING_RESOURCE_SPECIFICATION_RESULT__PROCESSINGRESOURCESPECIFICATION);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		linkingResourceResultsEClass.getESuperTypes().add(this.getUtilisationResult());
		utilisationResultEClass.getESuperTypes().add(theEntityPackage.getNamedElement());
		resourceContainerResultsEClass.getESuperTypes().add(this.getUtilisationResult());
		processingResourceSpecificationResultEClass.getESuperTypes().add(this.getUtilisationResult());

		// Initialize classes and features; add operations and parameters
		initEClass(linkingResourceResultsEClass, LinkingResourceResults.class, "LinkingResourceResults", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLinkingResourceResults_Linkingresource(), theResourceenvironmentPackage.getLinkingResource(), null, "linkingresource", null, 0, 1, LinkingResourceResults.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(utilisationResultEClass, UtilisationResult.class, "UtilisationResult", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUtilisationResult_NormalisedResourceUtilisation(), ecorePackage.getEDouble(), "normalisedResourceUtilisation", null, 1, 1, UtilisationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getUtilisationResult_NormalisedDemandedTime(), ecorePackage.getEDouble(), "normalisedDemandedTime", null, 1, 1, UtilisationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getUtilisationResult_NormalisedWaitTime(), ecorePackage.getEDouble(), "normalisedWaitTime", null, 1, 1, UtilisationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(resourceContainerResultsEClass, ResourceContainerResults.class, "ResourceContainerResults", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResourceContainerResults_Resourcecontainer(), theResourceenvironmentPackage.getResourceContainer(), null, "resourcecontainer", null, 0, 1, ResourceContainerResults.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(processingResourceSpecificationResultEClass, ProcessingResourceSpecificationResult.class, "ProcessingResourceSpecificationResult", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getProcessingResourceSpecificationResult_Processingresourcespecification(), theResourceenvironmentPackage.getProcessingResourceSpecification(), null, "processingresourcespecification", null, 0, 1, ProcessingResourceSpecificationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
	}

} //ResourceenvironmentdecoratorPackageImpl
