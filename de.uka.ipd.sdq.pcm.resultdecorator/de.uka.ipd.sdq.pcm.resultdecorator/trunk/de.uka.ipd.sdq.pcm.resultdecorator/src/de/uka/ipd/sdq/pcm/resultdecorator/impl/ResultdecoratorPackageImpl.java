/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.resultdecorator.impl;

import de.uka.ipd.sdq.identifier.IdentifierPackage;

import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;

import de.uka.ipd.sdq.pcm.core.CorePackage;

import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;

import de.uka.ipd.sdq.pcm.protocol.ProtocolPackage;

import de.uka.ipd.sdq.pcm.qosannotations.QosannotationsPackage;

import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;

import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;

import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;

import de.uka.ipd.sdq.pcm.resultdecorator.ResultDecoratorRepository;
import de.uka.ipd.sdq.pcm.resultdecorator.ResultdecoratorFactory;
import de.uka.ipd.sdq.pcm.resultdecorator.ResultdecoratorPackage;

import de.uka.ipd.sdq.pcm.resultdecorator.repository.impl.repositorydecoratorPackageImpl;

import de.uka.ipd.sdq.pcm.resultdecorator.repository.repositorydecoratorPackage;

import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironment.impl.resourceenvironmentdecoratorPackageImpl;

import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironment.resourceenvironmentdecoratorPackage;

import de.uka.ipd.sdq.pcm.seff.SeffPackage;

import de.uka.ipd.sdq.pcm.system.SystemPackage;

import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;

import de.uka.ipd.sdq.probfunction.ProbfunctionPackage;

import de.uka.ipd.sdq.stoex.StoexPackage;

import de.uka.ipd.sdq.units.UnitsPackage;

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
public class ResultdecoratorPackageImpl extends EPackageImpl implements ResultdecoratorPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resultDecoratorRepositoryEClass = null;

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
	 * @see de.uka.ipd.sdq.pcm.resultdecorator.ResultdecoratorPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ResultdecoratorPackageImpl() {
		super(eNS_URI, ResultdecoratorFactory.eINSTANCE);
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
	public static ResultdecoratorPackage init() {
		if (isInited) return (ResultdecoratorPackage)EPackage.Registry.INSTANCE.getEPackage(ResultdecoratorPackage.eNS_URI);

		// Obtain or create and register package
		ResultdecoratorPackageImpl theResultdecoratorPackage = (ResultdecoratorPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof ResultdecoratorPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new ResultdecoratorPackageImpl());

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
		repositorydecoratorPackageImpl therepositorydecoratorPackage = (repositorydecoratorPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(repositorydecoratorPackage.eNS_URI) instanceof repositorydecoratorPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(repositorydecoratorPackage.eNS_URI) : repositorydecoratorPackage.eINSTANCE);
		resourceenvironmentdecoratorPackageImpl theresourceenvironmentdecoratorPackage = (resourceenvironmentdecoratorPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(resourceenvironmentdecoratorPackage.eNS_URI) instanceof resourceenvironmentdecoratorPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(resourceenvironmentdecoratorPackage.eNS_URI) : resourceenvironmentdecoratorPackage.eINSTANCE);

		// Create package meta-data objects
		theResultdecoratorPackage.createPackageContents();
		therepositorydecoratorPackage.createPackageContents();
		theresourceenvironmentdecoratorPackage.createPackageContents();

		// Initialize created meta-data
		theResultdecoratorPackage.initializePackageContents();
		therepositorydecoratorPackage.initializePackageContents();
		theresourceenvironmentdecoratorPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theResultdecoratorPackage.freeze();

		return theResultdecoratorPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResultDecoratorRepository() {
		return resultDecoratorRepositoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResultDecoratorRepository_Interfaceprovidingrequiringentityresults() {
		return (EReference)resultDecoratorRepositoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResultDecoratorRepository_Utilisationresult() {
		return (EReference)resultDecoratorRepositoryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ResultdecoratorFactory getResultdecoratorFactory() {
		return (ResultdecoratorFactory)getEFactoryInstance();
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
		resultDecoratorRepositoryEClass = createEClass(RESULT_DECORATOR_REPOSITORY);
		createEReference(resultDecoratorRepositoryEClass, RESULT_DECORATOR_REPOSITORY__INTERFACEPROVIDINGREQUIRINGENTITYRESULTS);
		createEReference(resultDecoratorRepositoryEClass, RESULT_DECORATOR_REPOSITORY__UTILISATIONRESULT);
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
		repositorydecoratorPackage therepositorydecoratorPackage = (repositorydecoratorPackage)EPackage.Registry.INSTANCE.getEPackage(repositorydecoratorPackage.eNS_URI);
		resourceenvironmentdecoratorPackage theresourceenvironmentdecoratorPackage = (resourceenvironmentdecoratorPackage)EPackage.Registry.INSTANCE.getEPackage(resourceenvironmentdecoratorPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(therepositorydecoratorPackage);
		getESubpackages().add(theresourceenvironmentdecoratorPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(resultDecoratorRepositoryEClass, ResultDecoratorRepository.class, "ResultDecoratorRepository", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getResultDecoratorRepository_Interfaceprovidingrequiringentityresults(), therepositorydecoratorPackage.getInterfaceProvidingRequiringEntityResults(), null, "interfaceprovidingrequiringentityresults", null, 0, -1, ResultDecoratorRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getResultDecoratorRepository_Utilisationresult(), theresourceenvironmentdecoratorPackage.getUtilisationResult(), null, "utilisationresult", null, 0, -1, ResultDecoratorRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //ResultdecoratorPackageImpl
