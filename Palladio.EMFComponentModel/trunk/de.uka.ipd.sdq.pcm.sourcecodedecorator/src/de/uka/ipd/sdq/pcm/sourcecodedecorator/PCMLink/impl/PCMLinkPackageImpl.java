/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

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
import de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.ActionControlFlowLink;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.ComponentFileLink;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.PCMLinkFactory;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.PCMLinkPackage;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.PCMLinkRepository;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.SEFFMethodLink;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggerlinkPackage;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.LoggerlinkPackageImpl;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.SourcecodedecoratorPackage;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.impl.SourcecodedecoratorPackageImpl;
import de.uka.ipd.sdq.pcm.subsystem.SubsystemPackage;
import de.uka.ipd.sdq.pcm.system.SystemPackage;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PCMLinkPackageImpl extends EPackageImpl implements PCMLinkPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentFileLinkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass seffMethodLinkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actionControlFlowLinkEClass = null;

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
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.PCMLinkPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private PCMLinkPackageImpl() {
		super(eNS_URI, PCMLinkFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link PCMLinkPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static PCMLinkPackage init() {
		if (isInited) return (PCMLinkPackage)EPackage.Registry.INSTANCE.getEPackage(PCMLinkPackage.eNS_URI);

		// Obtain or create and register package
		PCMLinkPackageImpl thePCMLinkPackage = (PCMLinkPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof PCMLinkPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new PCMLinkPackageImpl());

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
		SourcecodedecoratorPackageImpl theSourcecodedecoratorPackage = (SourcecodedecoratorPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(SourcecodedecoratorPackage.eNS_URI) instanceof SourcecodedecoratorPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(SourcecodedecoratorPackage.eNS_URI) : SourcecodedecoratorPackage.eINSTANCE);
		LoggerlinkPackageImpl theLoggerlinkPackage = (LoggerlinkPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(LoggerlinkPackage.eNS_URI) instanceof LoggerlinkPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(LoggerlinkPackage.eNS_URI) : LoggerlinkPackage.eINSTANCE);

		// Create package meta-data objects
		thePCMLinkPackage.createPackageContents();
		theSourcecodedecoratorPackage.createPackageContents();
		theLoggerlinkPackage.createPackageContents();

		// Initialize created meta-data
		thePCMLinkPackage.initializePackageContents();
		theSourcecodedecoratorPackage.initializePackageContents();
		theLoggerlinkPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thePCMLinkPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(PCMLinkPackage.eNS_URI, thePCMLinkPackage);
		return thePCMLinkPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponentFileLink() {
		return componentFileLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentFileLink_Filelevelsourcecodelink() {
		return (EReference)componentFileLinkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentFileLink_Repositorycomponent() {
		return (EReference)componentFileLinkEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSEFFMethodLink() {
		return seffMethodLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSEFFMethodLink_Methodlevelsourcecodelink() {
		return (EReference)seffMethodLinkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSEFFMethodLink_Serviceeffectspecification() {
		return (EReference)seffMethodLinkEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getActionControlFlowLink() {
		return actionControlFlowLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActionControlFlowLink_Controlflowlevelsourcecodelink() {
		return (EReference)actionControlFlowLinkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getActionControlFlowLink_Abstractaction() {
		return (EReference)actionControlFlowLinkEClass.getEStructuralFeatures().get(1);
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
	public EReference getPCMLinkRepository_Componentfilelink() {
		return (EReference)pcmLinkRepositoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPCMLinkRepository_Seffmethodlink() {
		return (EReference)pcmLinkRepositoryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPCMLinkRepository_Actioncontrolflowlink() {
		return (EReference)pcmLinkRepositoryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPCMLinkRepository_LoggingPositionIds() {
		return (EReference)pcmLinkRepositoryEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PCMLinkFactory getPCMLinkFactory() {
		return (PCMLinkFactory)getEFactoryInstance();
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
		componentFileLinkEClass = createEClass(COMPONENT_FILE_LINK);
		createEReference(componentFileLinkEClass, COMPONENT_FILE_LINK__FILELEVELSOURCECODELINK);
		createEReference(componentFileLinkEClass, COMPONENT_FILE_LINK__REPOSITORYCOMPONENT);

		seffMethodLinkEClass = createEClass(SEFF_METHOD_LINK);
		createEReference(seffMethodLinkEClass, SEFF_METHOD_LINK__METHODLEVELSOURCECODELINK);
		createEReference(seffMethodLinkEClass, SEFF_METHOD_LINK__SERVICEEFFECTSPECIFICATION);

		actionControlFlowLinkEClass = createEClass(ACTION_CONTROL_FLOW_LINK);
		createEReference(actionControlFlowLinkEClass, ACTION_CONTROL_FLOW_LINK__CONTROLFLOWLEVELSOURCECODELINK);
		createEReference(actionControlFlowLinkEClass, ACTION_CONTROL_FLOW_LINK__ABSTRACTACTION);

		pcmLinkRepositoryEClass = createEClass(PCM_LINK_REPOSITORY);
		createEReference(pcmLinkRepositoryEClass, PCM_LINK_REPOSITORY__COMPONENTFILELINK);
		createEReference(pcmLinkRepositoryEClass, PCM_LINK_REPOSITORY__SEFFMETHODLINK);
		createEReference(pcmLinkRepositoryEClass, PCM_LINK_REPOSITORY__ACTIONCONTROLFLOWLINK);
		createEReference(pcmLinkRepositoryEClass, PCM_LINK_REPOSITORY__LOGGING_POSITION_IDS);
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
		SourcecodedecoratorPackage theSourcecodedecoratorPackage = (SourcecodedecoratorPackage)EPackage.Registry.INSTANCE.getEPackage(SourcecodedecoratorPackage.eNS_URI);
		RepositoryPackage theRepositoryPackage = (RepositoryPackage)EPackage.Registry.INSTANCE.getEPackage(RepositoryPackage.eNS_URI);
		SeffPackage theSeffPackage = (SeffPackage)EPackage.Registry.INSTANCE.getEPackage(SeffPackage.eNS_URI);
		LoggerlinkPackage theLoggerlinkPackage = (LoggerlinkPackage)EPackage.Registry.INSTANCE.getEPackage(LoggerlinkPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		componentFileLinkEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
		seffMethodLinkEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
		actionControlFlowLinkEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
		pcmLinkRepositoryEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());

		// Initialize classes and features; add operations and parameters
		initEClass(componentFileLinkEClass, ComponentFileLink.class, "ComponentFileLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComponentFileLink_Filelevelsourcecodelink(), theSourcecodedecoratorPackage.getFileLevelSourceCodeLink(), null, "filelevelsourcecodelink", null, 1, 1, ComponentFileLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getComponentFileLink_Repositorycomponent(), theRepositoryPackage.getRepositoryComponent(), null, "repositorycomponent", null, 1, 1, ComponentFileLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(seffMethodLinkEClass, SEFFMethodLink.class, "SEFFMethodLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSEFFMethodLink_Methodlevelsourcecodelink(), theSourcecodedecoratorPackage.getMethodLevelSourceCodeLink(), null, "methodlevelsourcecodelink", null, 1, 1, SEFFMethodLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSEFFMethodLink_Serviceeffectspecification(), theSeffPackage.getServiceEffectSpecification(), null, "serviceeffectspecification", null, 1, 1, SEFFMethodLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(actionControlFlowLinkEClass, ActionControlFlowLink.class, "ActionControlFlowLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getActionControlFlowLink_Controlflowlevelsourcecodelink(), theSourcecodedecoratorPackage.getControlFlowLevelSourceCodeLink(), null, "controlflowlevelsourcecodelink", null, 1, 1, ActionControlFlowLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getActionControlFlowLink_Abstractaction(), theSeffPackage.getAbstractAction(), null, "abstractaction", null, 1, 1, ActionControlFlowLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(pcmLinkRepositoryEClass, PCMLinkRepository.class, "PCMLinkRepository", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPCMLinkRepository_Componentfilelink(), this.getComponentFileLink(), null, "componentfilelink", null, 0, -1, PCMLinkRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPCMLinkRepository_Seffmethodlink(), this.getSEFFMethodLink(), null, "seffmethodlink", null, 0, -1, PCMLinkRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPCMLinkRepository_Actioncontrolflowlink(), this.getActionControlFlowLink(), null, "actioncontrolflowlink", null, 0, -1, PCMLinkRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getPCMLinkRepository_LoggingPositionIds(), theLoggerlinkPackage.getLoggingPositionIdLink(), null, "loggingPositionIds", null, 0, -1, PCMLinkRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //PCMLinkPackageImpl
