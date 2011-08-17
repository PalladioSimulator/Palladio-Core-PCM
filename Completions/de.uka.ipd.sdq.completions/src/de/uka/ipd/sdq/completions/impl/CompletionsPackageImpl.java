/**
 * Copyright SDQ, IPD, U Karlsruhe, 2007
 *
 * $Id$
 */
package de.uka.ipd.sdq.completions.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import de.uka.ipd.sdq.completions.Completion;
import de.uka.ipd.sdq.completions.CompletionRepository;
import de.uka.ipd.sdq.completions.CompletionsFactory;
import de.uka.ipd.sdq.completions.CompletionsPackage;
import de.uka.ipd.sdq.completions.DelegatingExternalCallAction;
import de.uka.ipd.sdq.pcm.PcmPackage;
import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CompletionsPackageImpl extends EPackageImpl implements CompletionsPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass completionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass completionRepositoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass delegatingExternalCallActionEClass = null;

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
	 * @see de.uka.ipd.sdq.completions.CompletionsPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CompletionsPackageImpl() {
		super(eNS_URI, CompletionsFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link CompletionsPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CompletionsPackage init() {
		if (isInited) return (CompletionsPackage)EPackage.Registry.INSTANCE.getEPackage(CompletionsPackage.eNS_URI);

		// Obtain or create and register package
		CompletionsPackageImpl theCompletionsPackage = (CompletionsPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof CompletionsPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new CompletionsPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		PcmPackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theCompletionsPackage.createPackageContents();

		// Initialize created meta-data
		theCompletionsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCompletionsPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CompletionsPackage.eNS_URI, theCompletionsPackage);
		return theCompletionsPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompletion() {
		return completionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompletionRepository() {
		return completionRepositoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompletionRepository_Completions_CompletionRepository() {
		return (EReference)completionRepositoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDelegatingExternalCallAction() {
		return delegatingExternalCallActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompletionsFactory getCompletionsFactory() {
		return (CompletionsFactory)getEFactoryInstance();
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
		completionEClass = createEClass(COMPLETION);

		completionRepositoryEClass = createEClass(COMPLETION_REPOSITORY);
		createEReference(completionRepositoryEClass, COMPLETION_REPOSITORY__COMPLETIONS_COMPLETION_REPOSITORY);

		delegatingExternalCallActionEClass = createEClass(DELEGATING_EXTERNAL_CALL_ACTION);
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
		RepositoryPackage theRepositoryPackage = (RepositoryPackage)EPackage.Registry.INSTANCE.getEPackage(RepositoryPackage.eNS_URI);
		SeffPackage theSeffPackage = (SeffPackage)EPackage.Registry.INSTANCE.getEPackage(SeffPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		completionEClass.getESuperTypes().add(theEntityPackage.getComposedProvidingRequiringEntity());
		completionEClass.getESuperTypes().add(theRepositoryPackage.getImplementationComponentType());
		delegatingExternalCallActionEClass.getESuperTypes().add(theSeffPackage.getExternalCallAction());

		// Initialize classes and features; add operations and parameters
		initEClass(completionEClass, Completion.class, "Completion", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(completionRepositoryEClass, CompletionRepository.class, "CompletionRepository", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompletionRepository_Completions_CompletionRepository(), this.getCompletion(), null, "completions_CompletionRepository", null, 0, -1, CompletionRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(delegatingExternalCallActionEClass, DelegatingExternalCallAction.class, "DelegatingExternalCallAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);
	}

} //CompletionsPackageImpl
