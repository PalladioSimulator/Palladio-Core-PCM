/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLinkRepository.impl;

import de.fzi.gast.accesses.accessesPackage;

import de.fzi.gast.annotations.annotationsPackage;

import de.fzi.gast.core.corePackage;

import de.fzi.gast.functions.functionsPackage;

import de.fzi.gast.statements.statementsPackage;

import de.fzi.gast.types.typesPackage;

import de.fzi.gast.variables.variablesPackage;

import de.uka.ipd.sdq.identifier.IdentifierPackage;

import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;

import de.uka.ipd.sdq.pcm.core.CorePackage;

import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;

import de.uka.ipd.sdq.pcm.protocol.ProtocolPackage;

import de.uka.ipd.sdq.pcm.qosannotations.QosannotationsPackage;

import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;

import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;

import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;

import de.uka.ipd.sdq.pcm.seff.SeffPackage;

import de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.GastPcmLinkPackage;

import de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.impl.GastPcmLinkPackageImpl;

import de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLinkRepository.PCMLinkRepository;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLinkRepository.PCMLinkRepositoryFactory;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLinkRepository.PCMLinkRepositoryPackage;

import de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggerlinkPackage;

import de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.LoggerlinkPackageImpl;

import de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.RawResourceDemandCountsPackage;

import de.uka.ipd.sdq.pcm.sourcecodedecorator.rawResourceDemandCounts.impl.RawResourceDemandCountsPackageImpl;

import de.uka.ipd.sdq.pcm.subsystem.SubsystemPackage;

import de.uka.ipd.sdq.pcm.system.SystemPackage;

import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;

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
public class PCMLinkRepositoryPackageImpl extends EPackageImpl implements PCMLinkRepositoryPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pcmLinkRepositoryEClass = null;

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
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLinkRepository.PCMLinkRepositoryPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PCMLinkRepositoryPackageImpl() {
		super(eNS_URI, PCMLinkRepositoryFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link PCMLinkRepositoryPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PCMLinkRepositoryPackage init() {
		if (isInited) return (PCMLinkRepositoryPackage)EPackage.Registry.INSTANCE.getEPackage(PCMLinkRepositoryPackage.eNS_URI);

		// Obtain or create and register package
		PCMLinkRepositoryPackageImpl thePCMLinkRepositoryPackage = (PCMLinkRepositoryPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PCMLinkRepositoryPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new PCMLinkRepositoryPackageImpl());

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
		statementsPackage.eINSTANCE.eClass();
		corePackage.eINSTANCE.eClass();
		annotationsPackage.eINSTANCE.eClass();
		typesPackage.eINSTANCE.eClass();
		accessesPackage.eINSTANCE.eClass();
		variablesPackage.eINSTANCE.eClass();
		functionsPackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		LoggerlinkPackageImpl theLoggerlinkPackage = (LoggerlinkPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(LoggerlinkPackage.eNS_URI) instanceof LoggerlinkPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(LoggerlinkPackage.eNS_URI) : LoggerlinkPackage.eINSTANCE);
		GastPcmLinkPackageImpl theGastPcmLinkPackage = (GastPcmLinkPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(GastPcmLinkPackage.eNS_URI) instanceof GastPcmLinkPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(GastPcmLinkPackage.eNS_URI) : GastPcmLinkPackage.eINSTANCE);
		RawResourceDemandCountsPackageImpl theRawResourceDemandCountsPackage = (RawResourceDemandCountsPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(RawResourceDemandCountsPackage.eNS_URI) instanceof RawResourceDemandCountsPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(RawResourceDemandCountsPackage.eNS_URI) : RawResourceDemandCountsPackage.eINSTANCE);

		// Create package meta-data objects
		thePCMLinkRepositoryPackage.createPackageContents();
		theLoggerlinkPackage.createPackageContents();
		theGastPcmLinkPackage.createPackageContents();
		theRawResourceDemandCountsPackage.createPackageContents();

		// Initialize created meta-data
		thePCMLinkRepositoryPackage.initializePackageContents();
		theLoggerlinkPackage.initializePackageContents();
		theGastPcmLinkPackage.initializePackageContents();
		theRawResourceDemandCountsPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePCMLinkRepositoryPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PCMLinkRepositoryPackage.eNS_URI, thePCMLinkRepositoryPackage);
		return thePCMLinkRepositoryPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPCMLinkRepository() {
		return pcmLinkRepositoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPCMLinkRepository_LoggingPositionLinks() {
		return (EReference)pcmLinkRepositoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPCMLinkRepository_InternalActionLinks() {
		return (EReference)pcmLinkRepositoryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPCMLinkRepository_InputParameterLinks() {
		return (EReference)pcmLinkRepositoryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMLinkRepositoryFactory getPCMLinkRepositoryFactory() {
		return (PCMLinkRepositoryFactory)getEFactoryInstance();
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
		pcmLinkRepositoryEClass = createEClass(PCM_LINK_REPOSITORY);
		createEReference(pcmLinkRepositoryEClass, PCM_LINK_REPOSITORY__LOGGING_POSITION_LINKS);
		createEReference(pcmLinkRepositoryEClass, PCM_LINK_REPOSITORY__INTERNAL_ACTION_LINKS);
		createEReference(pcmLinkRepositoryEClass, PCM_LINK_REPOSITORY__INPUT_PARAMETER_LINKS);
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
		IdentifierPackage theIdentifierPackage = (IdentifierPackage)EPackage.Registry.INSTANCE.getEPackage(IdentifierPackage.eNS_URI);
		LoggerlinkPackage theLoggerlinkPackage = (LoggerlinkPackage)EPackage.Registry.INSTANCE.getEPackage(LoggerlinkPackage.eNS_URI);
		GastPcmLinkPackage theGastPcmLinkPackage = (GastPcmLinkPackage)EPackage.Registry.INSTANCE.getEPackage(GastPcmLinkPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		pcmLinkRepositoryEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());

		// Initialize classes and features; add operations and parameters
		initEClass(pcmLinkRepositoryEClass, PCMLinkRepository.class, "PCMLinkRepository", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPCMLinkRepository_LoggingPositionLinks(), theLoggerlinkPackage.getLoggingPositionIdLink(), null, "loggingPositionLinks", null, 0, -1, PCMLinkRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPCMLinkRepository_InternalActionLinks(), theGastPcmLinkPackage.getInternalActionLink(), null, "internalActionLinks", null, 0, -1, PCMLinkRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPCMLinkRepository_InputParameterLinks(), theGastPcmLinkPackage.getParameterLink(), null, "inputParameterLinks", null, 0, -1, PCMLinkRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //PCMLinkRepositoryPackageImpl
