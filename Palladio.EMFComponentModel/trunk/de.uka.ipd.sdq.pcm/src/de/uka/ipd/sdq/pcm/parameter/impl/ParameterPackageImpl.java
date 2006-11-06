/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.parameter.impl;

import de.uka.ipd.sdq.identifier.IdentifierPackage;

import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;

import de.uka.ipd.sdq.pcm.allocation.impl.AllocationPackageImpl;

import de.uka.ipd.sdq.pcm.core.composition.CompositionPackage;

import de.uka.ipd.sdq.pcm.core.composition.impl.CompositionPackageImpl;

import de.uka.ipd.sdq.pcm.core.connectors.ConnectorsPackage;

import de.uka.ipd.sdq.pcm.core.connectors.impl.ConnectorsPackageImpl;

import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;

import de.uka.ipd.sdq.pcm.core.entity.impl.EntityPackageImpl;

import de.uka.ipd.sdq.pcm.core.stochastics.StochasticsPackage;

import de.uka.ipd.sdq.pcm.core.stochastics.impl.StochasticsPackageImpl;

import de.uka.ipd.sdq.pcm.parameter.CollectionParameterCharacterisation;
import de.uka.ipd.sdq.pcm.parameter.CollectionParameterCharacterisationType;
import de.uka.ipd.sdq.pcm.parameter.CollectionParameterUsage;
import de.uka.ipd.sdq.pcm.parameter.CompositeParameterUsage;
import de.uka.ipd.sdq.pcm.parameter.ParameterFactory;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.parameter.ParameterUsage;
import de.uka.ipd.sdq.pcm.parameter.PrimitiveParameterCharacterisation;
import de.uka.ipd.sdq.pcm.parameter.PrimitiveParameterCharacterisationType;

import de.uka.ipd.sdq.pcm.protocol.ProtocolPackage;

import de.uka.ipd.sdq.pcm.protocol.impl.ProtocolPackageImpl;

import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;

import de.uka.ipd.sdq.pcm.repository.impl.RepositoryPackageImpl;

import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;

import de.uka.ipd.sdq.pcm.resourceenvironment.impl.ResourceenvironmentPackageImpl;

import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;

import de.uka.ipd.sdq.pcm.resourcetype.impl.ResourcetypePackageImpl;

import de.uka.ipd.sdq.pcm.seff.SeffPackage;

import de.uka.ipd.sdq.pcm.seff.impl.SeffPackageImpl;

import de.uka.ipd.sdq.pcm.system.SystemPackage;

import de.uka.ipd.sdq.pcm.system.impl.SystemPackageImpl;

import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;

import de.uka.ipd.sdq.pcm.usagemodel.impl.UsagemodelPackageImpl;

import de.uka.ipd.sdq.probfunction.ProbfunctionPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ParameterPackageImpl extends EPackageImpl implements ParameterPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass primitiveParameterCharacterisationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterUsageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositeParameterUsageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collectionParameterUsageEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass collectionParameterCharacterisationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum collectionParameterCharacterisationTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum primitiveParameterCharacterisationTypeEEnum = null;

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
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ParameterPackageImpl() {
		super(eNS_URI, ParameterFactory.eINSTANCE);
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
	public static ParameterPackage init() {
		if (isInited) return (ParameterPackage)EPackage.Registry.INSTANCE.getEPackage(ParameterPackage.eNS_URI);

		// Obtain or create and register package
		ParameterPackageImpl theParameterPackage = (ParameterPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof ParameterPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new ParameterPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		IdentifierPackage.eINSTANCE.eClass();
		ProbfunctionPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		StochasticsPackageImpl theStochasticsPackage = (StochasticsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(StochasticsPackage.eNS_URI) instanceof StochasticsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(StochasticsPackage.eNS_URI) : StochasticsPackage.eINSTANCE);
		EntityPackageImpl theEntityPackage = (EntityPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(EntityPackage.eNS_URI) instanceof EntityPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(EntityPackage.eNS_URI) : EntityPackage.eINSTANCE);
		ConnectorsPackageImpl theConnectorsPackage = (ConnectorsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ConnectorsPackage.eNS_URI) instanceof ConnectorsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ConnectorsPackage.eNS_URI) : ConnectorsPackage.eINSTANCE);
		CompositionPackageImpl theCompositionPackage = (CompositionPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(CompositionPackage.eNS_URI) instanceof CompositionPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(CompositionPackage.eNS_URI) : CompositionPackage.eINSTANCE);
		RepositoryPackageImpl theRepositoryPackage = (RepositoryPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RepositoryPackage.eNS_URI) instanceof RepositoryPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RepositoryPackage.eNS_URI) : RepositoryPackage.eINSTANCE);
		ProtocolPackageImpl theProtocolPackage = (ProtocolPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ProtocolPackage.eNS_URI) instanceof ProtocolPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ProtocolPackage.eNS_URI) : ProtocolPackage.eINSTANCE);
		SeffPackageImpl theSeffPackage = (SeffPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SeffPackage.eNS_URI) instanceof SeffPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SeffPackage.eNS_URI) : SeffPackage.eINSTANCE);
		ResourcetypePackageImpl theResourcetypePackage = (ResourcetypePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ResourcetypePackage.eNS_URI) instanceof ResourcetypePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ResourcetypePackage.eNS_URI) : ResourcetypePackage.eINSTANCE);
		AllocationPackageImpl theAllocationPackage = (AllocationPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AllocationPackage.eNS_URI) instanceof AllocationPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AllocationPackage.eNS_URI) : AllocationPackage.eINSTANCE);
		ResourceenvironmentPackageImpl theResourceenvironmentPackage = (ResourceenvironmentPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(ResourceenvironmentPackage.eNS_URI) instanceof ResourceenvironmentPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(ResourceenvironmentPackage.eNS_URI) : ResourceenvironmentPackage.eINSTANCE);
		UsagemodelPackageImpl theUsagemodelPackage = (UsagemodelPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(UsagemodelPackage.eNS_URI) instanceof UsagemodelPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(UsagemodelPackage.eNS_URI) : UsagemodelPackage.eINSTANCE);
		SystemPackageImpl theSystemPackage = (SystemPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SystemPackage.eNS_URI) instanceof SystemPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SystemPackage.eNS_URI) : SystemPackage.eINSTANCE);

		// Create package meta-data objects
		theParameterPackage.createPackageContents();
		theStochasticsPackage.createPackageContents();
		theEntityPackage.createPackageContents();
		theConnectorsPackage.createPackageContents();
		theCompositionPackage.createPackageContents();
		theRepositoryPackage.createPackageContents();
		theProtocolPackage.createPackageContents();
		theSeffPackage.createPackageContents();
		theResourcetypePackage.createPackageContents();
		theAllocationPackage.createPackageContents();
		theResourceenvironmentPackage.createPackageContents();
		theUsagemodelPackage.createPackageContents();
		theSystemPackage.createPackageContents();

		// Initialize created meta-data
		theParameterPackage.initializePackageContents();
		theStochasticsPackage.initializePackageContents();
		theEntityPackage.initializePackageContents();
		theConnectorsPackage.initializePackageContents();
		theCompositionPackage.initializePackageContents();
		theRepositoryPackage.initializePackageContents();
		theProtocolPackage.initializePackageContents();
		theSeffPackage.initializePackageContents();
		theResourcetypePackage.initializePackageContents();
		theAllocationPackage.initializePackageContents();
		theResourceenvironmentPackage.initializePackageContents();
		theUsagemodelPackage.initializePackageContents();
		theSystemPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theParameterPackage.freeze();

		return theParameterPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPrimitiveParameterCharacterisation() {
		return primitiveParameterCharacterisationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPrimitiveParameterCharacterisation_Type() {
		return (EAttribute)primitiveParameterCharacterisationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameterUsage() {
		return parameterUsageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameterUsage_Parameter_ParameterUsage() {
		return (EReference)parameterUsageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameterUsage_ParameterCharacterisation_ParameterUsage() {
		return (EReference)parameterUsageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompositeParameterUsage() {
		return compositeParameterUsageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeParameterUsage_InnerParameters_ParameterUsage() {
		return (EReference)compositeParameterUsageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCollectionParameterUsage() {
		return collectionParameterUsageEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionParameterUsage_InnerElement_ParameterUsage() {
		return (EReference)collectionParameterUsageEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCollectionParameterUsage_ParameterCharacterisation_CollectionParameterUsage() {
		return (EReference)collectionParameterUsageEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCollectionParameterCharacterisation() {
		return collectionParameterCharacterisationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCollectionParameterCharacterisation_Type() {
		return (EAttribute)collectionParameterCharacterisationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCollectionParameterCharacterisationType() {
		return collectionParameterCharacterisationTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPrimitiveParameterCharacterisationType() {
		return primitiveParameterCharacterisationTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterFactory getParameterFactory() {
		return (ParameterFactory)getEFactoryInstance();
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
		primitiveParameterCharacterisationEClass = createEClass(PRIMITIVE_PARAMETER_CHARACTERISATION);
		createEAttribute(primitiveParameterCharacterisationEClass, PRIMITIVE_PARAMETER_CHARACTERISATION__TYPE);

		parameterUsageEClass = createEClass(PARAMETER_USAGE);
		createEReference(parameterUsageEClass, PARAMETER_USAGE__PARAMETER_PARAMETER_USAGE);
		createEReference(parameterUsageEClass, PARAMETER_USAGE__PARAMETER_CHARACTERISATION_PARAMETER_USAGE);

		compositeParameterUsageEClass = createEClass(COMPOSITE_PARAMETER_USAGE);
		createEReference(compositeParameterUsageEClass, COMPOSITE_PARAMETER_USAGE__INNER_PARAMETERS_PARAMETER_USAGE);

		collectionParameterUsageEClass = createEClass(COLLECTION_PARAMETER_USAGE);
		createEReference(collectionParameterUsageEClass, COLLECTION_PARAMETER_USAGE__INNER_ELEMENT_PARAMETER_USAGE);
		createEReference(collectionParameterUsageEClass, COLLECTION_PARAMETER_USAGE__PARAMETER_CHARACTERISATION_COLLECTION_PARAMETER_USAGE);

		collectionParameterCharacterisationEClass = createEClass(COLLECTION_PARAMETER_CHARACTERISATION);
		createEAttribute(collectionParameterCharacterisationEClass, COLLECTION_PARAMETER_CHARACTERISATION__TYPE);

		// Create enums
		collectionParameterCharacterisationTypeEEnum = createEEnum(COLLECTION_PARAMETER_CHARACTERISATION_TYPE);
		primitiveParameterCharacterisationTypeEEnum = createEEnum(PRIMITIVE_PARAMETER_CHARACTERISATION_TYPE);
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
		StochasticsPackage theStochasticsPackage = (StochasticsPackage)EPackage.Registry.INSTANCE.getEPackage(StochasticsPackage.eNS_URI);
		RepositoryPackage theRepositoryPackage = (RepositoryPackage)EPackage.Registry.INSTANCE.getEPackage(RepositoryPackage.eNS_URI);

		// Add supertypes to classes
		primitiveParameterCharacterisationEClass.getESuperTypes().add(theStochasticsPackage.getRandomVariable());
		compositeParameterUsageEClass.getESuperTypes().add(this.getParameterUsage());
		collectionParameterUsageEClass.getESuperTypes().add(this.getParameterUsage());
		collectionParameterCharacterisationEClass.getESuperTypes().add(theStochasticsPackage.getRandomVariable());

		// Initialize classes and features; add operations and parameters
		initEClass(primitiveParameterCharacterisationEClass, PrimitiveParameterCharacterisation.class, "PrimitiveParameterCharacterisation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPrimitiveParameterCharacterisation_Type(), this.getPrimitiveParameterCharacterisationType(), "type", null, 1, 1, PrimitiveParameterCharacterisation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(parameterUsageEClass, ParameterUsage.class, "ParameterUsage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParameterUsage_Parameter_ParameterUsage(), theRepositoryPackage.getParameter(), null, "parameter_ParameterUsage", null, 1, 1, ParameterUsage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getParameterUsage_ParameterCharacterisation_ParameterUsage(), this.getPrimitiveParameterCharacterisation(), null, "parameterCharacterisation_ParameterUsage", null, 0, -1, ParameterUsage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(compositeParameterUsageEClass, CompositeParameterUsage.class, "CompositeParameterUsage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompositeParameterUsage_InnerParameters_ParameterUsage(), this.getParameterUsage(), null, "innerParameters_ParameterUsage", null, 0, -1, CompositeParameterUsage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(collectionParameterUsageEClass, CollectionParameterUsage.class, "CollectionParameterUsage", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCollectionParameterUsage_InnerElement_ParameterUsage(), this.getParameterUsage(), null, "innerElement_ParameterUsage", null, 1, 1, CollectionParameterUsage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getCollectionParameterUsage_ParameterCharacterisation_CollectionParameterUsage(), this.getCollectionParameterCharacterisation(), null, "parameterCharacterisation_CollectionParameterUsage", null, 0, -1, CollectionParameterUsage.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(collectionParameterCharacterisationEClass, CollectionParameterCharacterisation.class, "CollectionParameterCharacterisation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCollectionParameterCharacterisation_Type(), this.getCollectionParameterCharacterisationType(), "type", null, 1, 1, CollectionParameterCharacterisation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(collectionParameterCharacterisationTypeEEnum, CollectionParameterCharacterisationType.class, "CollectionParameterCharacterisationType");
		addEEnumLiteral(collectionParameterCharacterisationTypeEEnum, CollectionParameterCharacterisationType.NUMBER_OF_ELEMENTS_LITERAL);
		addEEnumLiteral(collectionParameterCharacterisationTypeEEnum, CollectionParameterCharacterisationType.STRUCTURE_LITERAL);

		initEEnum(primitiveParameterCharacterisationTypeEEnum, PrimitiveParameterCharacterisationType.class, "PrimitiveParameterCharacterisationType");
		addEEnumLiteral(primitiveParameterCharacterisationTypeEEnum, PrimitiveParameterCharacterisationType.VALUE_LITERAL);
		addEEnumLiteral(primitiveParameterCharacterisationTypeEEnum, PrimitiveParameterCharacterisationType.BYTESIZE_LITERAL);
		addEEnumLiteral(primitiveParameterCharacterisationTypeEEnum, PrimitiveParameterCharacterisationType.DATATYPE_LITERAL);

		// Create resource
		createResource(eNS_URI);
	}

} //ParameterPackageImpl
