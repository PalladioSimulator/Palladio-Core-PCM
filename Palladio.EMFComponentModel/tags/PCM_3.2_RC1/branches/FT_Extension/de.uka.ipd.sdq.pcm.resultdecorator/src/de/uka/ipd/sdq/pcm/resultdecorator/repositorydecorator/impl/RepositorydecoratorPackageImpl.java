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
import de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.AllocationContextResults;
import de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.ComponentResult;
import de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.InterfaceProvidingRequiringEntityResults;
import de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.RepositorydecoratorFactory;
import de.uka.ipd.sdq.pcm.resultdecorator.repositorydecorator.RepositorydecoratorPackage;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.ResourceenvironmentdecoratorPackage;
import de.uka.ipd.sdq.pcm.resultdecorator.resourceenvironmentdecorator.impl.ResourceenvironmentdecoratorPackageImpl;
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
	public static RepositorydecoratorPackage init() {
		if (isInited) return (RepositorydecoratorPackage)EPackage.Registry.INSTANCE.getEPackage(RepositorydecoratorPackage.eNS_URI);

		// Obtain or create and register package
		RepositorydecoratorPackageImpl theRepositorydecoratorPackage = (RepositorydecoratorPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof RepositorydecoratorPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new RepositorydecoratorPackageImpl());

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
	public EReference getInterfaceProvidingRequiringEntityResults_Interfaceprovidingrequiringentity() {
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
	public EClass getAllocationContextResults() {
		return allocationContextResultsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAllocationContextResults_Allocationcontext() {
		return (EReference)allocationContextResultsEClass.getEStructuralFeatures().get(0);
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
		createEReference(interfaceProvidingRequiringEntityResultsEClass, INTERFACE_PROVIDING_REQUIRING_ENTITY_RESULTS__INTERFACEPROVIDINGREQUIRINGENTITY);

		componentResultEClass = createEClass(COMPONENT_RESULT);
		createEAttribute(componentResultEClass, COMPONENT_RESULT__NORMALISED_RESOURCE_DEMAND);
		createEAttribute(componentResultEClass, COMPONENT_RESULT__NORMALISED_RESPONSE_TIME);

		allocationContextResultsEClass = createEClass(ALLOCATION_CONTEXT_RESULTS);
		createEReference(allocationContextResultsEClass, ALLOCATION_CONTEXT_RESULTS__ALLOCATIONCONTEXT);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		interfaceProvidingRequiringEntityResultsEClass.getESuperTypes().add(this.getComponentResult());
		componentResultEClass.getESuperTypes().add(theEntityPackage.getNamedElement());
		allocationContextResultsEClass.getESuperTypes().add(this.getComponentResult());

		// Initialize classes and features; add operations and parameters
		initEClass(interfaceProvidingRequiringEntityResultsEClass, InterfaceProvidingRequiringEntityResults.class, "InterfaceProvidingRequiringEntityResults", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInterfaceProvidingRequiringEntityResults_Interfaceprovidingrequiringentity(), theEntityPackage.getInterfaceProvidingRequiringEntity(), null, "interfaceprovidingrequiringentity", null, 0, 1, InterfaceProvidingRequiringEntityResults.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(componentResultEClass, ComponentResult.class, "ComponentResult", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getComponentResult_NormalisedResourceDemand(), ecorePackage.getEDouble(), "normalisedResourceDemand", null, 1, 1, ComponentResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getComponentResult_NormalisedResponseTime(), ecorePackage.getEDouble(), "normalisedResponseTime", null, 1, 1, ComponentResult.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(allocationContextResultsEClass, AllocationContextResults.class, "AllocationContextResults", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAllocationContextResults_Allocationcontext(), theAllocationPackage.getAllocationContext(), null, "allocationcontext", null, 0, 1, AllocationContextResults.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
	}

} //RepositorydecoratorPackageImpl
