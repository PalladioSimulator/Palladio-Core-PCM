/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironment.impl;

import de.uka.ipd.sdq.identifier.IdentifierPackage;

import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;

import de.uka.ipd.sdq.pcm.core.CorePackage;

import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;

import de.uka.ipd.sdq.pcm.protocol.ProtocolPackage;

import de.uka.ipd.sdq.pcm.qosannotations.QosannotationsPackage;

import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;

import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;

import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;

import de.uka.ipd.sdq.pcm.resultdecorator.ResultdecoratorPackage;

import de.uka.ipd.sdq.pcm.resultdecorator.impl.ResultdecoratorPackageImpl;

import de.uka.ipd.sdq.pcm.resultdecorator.repository.impl.repositorydecoratorPackageImpl;

import de.uka.ipd.sdq.pcm.resultdecorator.repository.repositorydecoratorPackage;

import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironment.LinkingResourceResults;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironment.ResourceContainerResults;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironment.UtilisationResult;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironment.resourceenvironmentdecoratorFactory;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironment.resourceenvironmentdecoratorPackage;

import de.uka.ipd.sdq.pcm.seff.SeffPackage;

import de.uka.ipd.sdq.pcm.system.SystemPackage;

import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;

import de.uka.ipd.sdq.probfunction.ProbfunctionPackage;

import de.uka.ipd.sdq.stoex.StoexPackage;

import de.uka.ipd.sdq.units.UnitsPackage;

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
public class resourceenvironmentdecoratorPackageImpl extends EPackageImpl implements resourceenvironmentdecoratorPackage {
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
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironment.resourceenvironmentdecoratorPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private resourceenvironmentdecoratorPackageImpl() {
		super(eNS_URI, resourceenvironmentdecoratorFactory.eINSTANCE);
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
	public static resourceenvironmentdecoratorPackage init() {
		if (isInited) return (resourceenvironmentdecoratorPackage)EPackage.Registry.INSTANCE.getEPackage(resourceenvironmentdecoratorPackage.eNS_URI);

		// Obtain or create and register package
		resourceenvironmentdecoratorPackageImpl theresourceenvironmentdecoratorPackage = (resourceenvironmentdecoratorPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof resourceenvironmentdecoratorPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new resourceenvironmentdecoratorPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		IdentifierPackage.eINSTANCE.eClass();
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
		ProbfunctionPackage.eINSTANCE.eClass();
		StoexPackage.eINSTANCE.eClass();
		UnitsPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		ResultdecoratorPackageImpl theResultdecoratorPackage = (ResultdecoratorPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ResultdecoratorPackage.eNS_URI) instanceof ResultdecoratorPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ResultdecoratorPackage.eNS_URI) : ResultdecoratorPackage.eINSTANCE);
		repositorydecoratorPackageImpl therepositorydecoratorPackage = (repositorydecoratorPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(repositorydecoratorPackage.eNS_URI) instanceof repositorydecoratorPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(repositorydecoratorPackage.eNS_URI) : repositorydecoratorPackage.eINSTANCE);

		// Create package meta-data objects
		theresourceenvironmentdecoratorPackage.createPackageContents();
		theResultdecoratorPackage.createPackageContents();
		therepositorydecoratorPackage.createPackageContents();

		// Initialize created meta-data
		theresourceenvironmentdecoratorPackage.initializePackageContents();
		theResultdecoratorPackage.initializePackageContents();
		therepositorydecoratorPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theresourceenvironmentdecoratorPackage.freeze();

		return theresourceenvironmentdecoratorPackage;
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
	public resourceenvironmentdecoratorFactory getresourceenvironmentdecoratorFactory() {
		return (resourceenvironmentdecoratorFactory)getEFactoryInstance();
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		linkingResourceResultsEClass.getESuperTypes().add(this.getUtilisationResult());
		resourceContainerResultsEClass.getESuperTypes().add(this.getUtilisationResult());

		// Initialize classes and features; add operations and parameters
		initEClass(linkingResourceResultsEClass, LinkingResourceResults.class, "LinkingResourceResults", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLinkingResourceResults_Linkingresource(), theResourceenvironmentPackage.getLinkingResource(), null, "linkingresource", null, 0, 1, LinkingResourceResults.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(utilisationResultEClass, UtilisationResult.class, "UtilisationResult", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUtilisationResult_NormalisedResourceUtilisation(), ecorePackage.getEDouble(), "normalisedResourceUtilisation", null, 1, 1, UtilisationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getUtilisationResult_NormalisedDemandedTime(), ecorePackage.getEDouble(), "normalisedDemandedTime", null, 1, 1, UtilisationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getUtilisationResult_NormalisedWaitTime(), ecorePackage.getEDouble(), "normalisedWaitTime", null, 1, 1, UtilisationResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(resourceContainerResultsEClass, ResourceContainerResults.class, "ResourceContainerResults", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResourceContainerResults_Resourcecontainer(), theResourceenvironmentPackage.getResourceContainer(), null, "resourcecontainer", null, 0, 1, ResourceContainerResults.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
	}

} //resourceenvironmentdecoratorPackageImpl
