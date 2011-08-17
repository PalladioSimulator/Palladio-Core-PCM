/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.impl;

import org.eclipse.emf.ecore.EAttribute;
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
import de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.PCMLinkPackage;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.impl.PCMLinkPackageImpl;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggerlinkPackage;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.LoggerlinkPackageImpl;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.ControlFlow;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.ControlFlowLevelSourceCodeLink;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.FileLevelSourceCodeLink;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.MethodLevelSourceCodeLink;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.Methods;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.SourceCodeDecoratorRepository;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.SourceCodeID;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.SourceFile;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.SourcecodedecoratorFactory;
import de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.SourcecodedecoratorPackage;
import de.uka.ipd.sdq.pcm.subsystem.SubsystemPackage;
import de.uka.ipd.sdq.pcm.system.SystemPackage;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SourcecodedecoratorPackageImpl extends EPackageImpl implements SourcecodedecoratorPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sourceCodeIDEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass fileLevelSourceCodeLinkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sourceFileEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass methodsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass methodLevelSourceCodeLinkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass controlFlowLevelSourceCodeLinkEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass controlFlowEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sourceCodeDecoratorRepositoryEClass = null;

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
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.SourcecodedecoratorPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private SourcecodedecoratorPackageImpl() {
		super(eNS_URI, SourcecodedecoratorFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link SourcecodedecoratorPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static SourcecodedecoratorPackage init() {
		if (isInited) return (SourcecodedecoratorPackage)EPackage.Registry.INSTANCE.getEPackage(SourcecodedecoratorPackage.eNS_URI);

		// Obtain or create and register package
		SourcecodedecoratorPackageImpl theSourcecodedecoratorPackage = (SourcecodedecoratorPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof SourcecodedecoratorPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new SourcecodedecoratorPackageImpl());

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
		PCMLinkPackageImpl thePCMLinkPackage = (PCMLinkPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(PCMLinkPackage.eNS_URI) instanceof PCMLinkPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(PCMLinkPackage.eNS_URI) : PCMLinkPackage.eINSTANCE);
		LoggerlinkPackageImpl theLoggerlinkPackage = (LoggerlinkPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(LoggerlinkPackage.eNS_URI) instanceof LoggerlinkPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(LoggerlinkPackage.eNS_URI) : LoggerlinkPackage.eINSTANCE);

		// Create package meta-data objects
		theSourcecodedecoratorPackage.createPackageContents();
		thePCMLinkPackage.createPackageContents();
		theLoggerlinkPackage.createPackageContents();

		// Initialize created meta-data
		theSourcecodedecoratorPackage.initializePackageContents();
		thePCMLinkPackage.initializePackageContents();
		theLoggerlinkPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theSourcecodedecoratorPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(SourcecodedecoratorPackage.eNS_URI, theSourcecodedecoratorPackage);
		return theSourcecodedecoratorPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSourceCodeID() {
		return sourceCodeIDEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSourceCodeID_SourceCodeID() {
		return (EAttribute)sourceCodeIDEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFileLevelSourceCodeLink() {
		return fileLevelSourceCodeLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFileLevelSourceCodeLink_Sourcefiles() {
		return (EReference)fileLevelSourceCodeLinkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSourceFile() {
		return sourceFileEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSourceFile_FullQualifiedName() {
		return (EAttribute)sourceFileEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMethods() {
		return methodsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMethods_RelativePathInFile() {
		return (EAttribute)methodsEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMethods_MethodName() {
		return (EAttribute)methodsEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMethodLevelSourceCodeLink() {
		return methodLevelSourceCodeLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMethodLevelSourceCodeLink_Methods() {
		return (EReference)methodLevelSourceCodeLinkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getControlFlowLevelSourceCodeLink() {
		return controlFlowLevelSourceCodeLinkEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getControlFlowLevelSourceCodeLink_Controlflow() {
		return (EReference)controlFlowLevelSourceCodeLinkEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getControlFlow() {
		return controlFlowEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getControlFlow_LineNumber() {
		return (EAttribute)controlFlowEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSourceCodeDecoratorRepository() {
		return sourceCodeDecoratorRepositoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSourceCodeDecoratorRepository_Filelevelsourcecodelink() {
		return (EReference)sourceCodeDecoratorRepositoryEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSourceCodeDecoratorRepository_Methodlevelsourcecodelink() {
		return (EReference)sourceCodeDecoratorRepositoryEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSourceCodeDecoratorRepository_Controlflowlevelsourcecodelink() {
		return (EReference)sourceCodeDecoratorRepositoryEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SourcecodedecoratorFactory getSourcecodedecoratorFactory() {
		return (SourcecodedecoratorFactory)getEFactoryInstance();
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
		sourceCodeIDEClass = createEClass(SOURCE_CODE_ID);
		createEAttribute(sourceCodeIDEClass, SOURCE_CODE_ID__SOURCE_CODE_ID);

		fileLevelSourceCodeLinkEClass = createEClass(FILE_LEVEL_SOURCE_CODE_LINK);
		createEReference(fileLevelSourceCodeLinkEClass, FILE_LEVEL_SOURCE_CODE_LINK__SOURCEFILES);

		sourceFileEClass = createEClass(SOURCE_FILE);
		createEAttribute(sourceFileEClass, SOURCE_FILE__FULL_QUALIFIED_NAME);

		methodsEClass = createEClass(METHODS);
		createEAttribute(methodsEClass, METHODS__RELATIVE_PATH_IN_FILE);
		createEAttribute(methodsEClass, METHODS__METHOD_NAME);

		methodLevelSourceCodeLinkEClass = createEClass(METHOD_LEVEL_SOURCE_CODE_LINK);
		createEReference(methodLevelSourceCodeLinkEClass, METHOD_LEVEL_SOURCE_CODE_LINK__METHODS);

		controlFlowLevelSourceCodeLinkEClass = createEClass(CONTROL_FLOW_LEVEL_SOURCE_CODE_LINK);
		createEReference(controlFlowLevelSourceCodeLinkEClass, CONTROL_FLOW_LEVEL_SOURCE_CODE_LINK__CONTROLFLOW);

		controlFlowEClass = createEClass(CONTROL_FLOW);
		createEAttribute(controlFlowEClass, CONTROL_FLOW__LINE_NUMBER);

		sourceCodeDecoratorRepositoryEClass = createEClass(SOURCE_CODE_DECORATOR_REPOSITORY);
		createEReference(sourceCodeDecoratorRepositoryEClass, SOURCE_CODE_DECORATOR_REPOSITORY__FILELEVELSOURCECODELINK);
		createEReference(sourceCodeDecoratorRepositoryEClass, SOURCE_CODE_DECORATOR_REPOSITORY__METHODLEVELSOURCECODELINK);
		createEReference(sourceCodeDecoratorRepositoryEClass, SOURCE_CODE_DECORATOR_REPOSITORY__CONTROLFLOWLEVELSOURCECODELINK);
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

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		sourceCodeIDEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
		fileLevelSourceCodeLinkEClass.getESuperTypes().add(this.getSourceCodeID());
		sourceFileEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
		methodsEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
		methodLevelSourceCodeLinkEClass.getESuperTypes().add(this.getFileLevelSourceCodeLink());
		controlFlowLevelSourceCodeLinkEClass.getESuperTypes().add(this.getMethodLevelSourceCodeLink());
		controlFlowEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());
		sourceCodeDecoratorRepositoryEClass.getESuperTypes().add(theIdentifierPackage.getIdentifier());

		// Initialize classes and features; add operations and parameters
		initEClass(sourceCodeIDEClass, SourceCodeID.class, "SourceCodeID", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSourceCodeID_SourceCodeID(), ecorePackage.getEString(), "sourceCodeID", null, 1, 1, SourceCodeID.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(fileLevelSourceCodeLinkEClass, FileLevelSourceCodeLink.class, "FileLevelSourceCodeLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFileLevelSourceCodeLink_Sourcefiles(), this.getSourceFile(), null, "sourcefiles", null, 0, -1, FileLevelSourceCodeLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(sourceFileEClass, SourceFile.class, "SourceFile", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSourceFile_FullQualifiedName(), ecorePackage.getEString(), "fullQualifiedName", null, 1, 1, SourceFile.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(methodsEClass, Methods.class, "Methods", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMethods_RelativePathInFile(), ecorePackage.getEString(), "relativePathInFile", null, 1, 1, Methods.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getMethods_MethodName(), ecorePackage.getEString(), "methodName", null, 1, 1, Methods.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(methodLevelSourceCodeLinkEClass, MethodLevelSourceCodeLink.class, "MethodLevelSourceCodeLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMethodLevelSourceCodeLink_Methods(), this.getMethods(), null, "methods", null, 0, -1, MethodLevelSourceCodeLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(controlFlowLevelSourceCodeLinkEClass, ControlFlowLevelSourceCodeLink.class, "ControlFlowLevelSourceCodeLink", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getControlFlowLevelSourceCodeLink_Controlflow(), this.getControlFlow(), null, "controlflow", null, 0, -1, ControlFlowLevelSourceCodeLink.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(controlFlowEClass, ControlFlow.class, "ControlFlow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getControlFlow_LineNumber(), ecorePackage.getEInt(), "lineNumber", null, 1, 1, ControlFlow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(sourceCodeDecoratorRepositoryEClass, SourceCodeDecoratorRepository.class, "SourceCodeDecoratorRepository", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSourceCodeDecoratorRepository_Filelevelsourcecodelink(), this.getFileLevelSourceCodeLink(), null, "filelevelsourcecodelink", null, 0, -1, SourceCodeDecoratorRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSourceCodeDecoratorRepository_Methodlevelsourcecodelink(), this.getMethodLevelSourceCodeLink(), null, "methodlevelsourcecodelink", null, 0, -1, SourceCodeDecoratorRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEReference(getSourceCodeDecoratorRepository_Controlflowlevelsourcecodelink(), this.getControlFlowLevelSourceCodeLink(), null, "controlflowlevelsourcecodelink", null, 0, -1, SourceCodeDecoratorRepository.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //SourcecodedecoratorPackageImpl
