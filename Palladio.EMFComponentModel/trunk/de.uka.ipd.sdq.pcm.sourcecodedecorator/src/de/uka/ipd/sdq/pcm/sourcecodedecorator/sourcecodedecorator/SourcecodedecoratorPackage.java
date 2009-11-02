/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import de.uka.ipd.sdq.identifier.IdentifierPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.SourcecodedecoratorFactory
 * @model kind="package"
 * @generated
 */
public interface SourcecodedecoratorPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "sourcecodedecorator";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///SourceCodeDecorator/sourcecodedecorator.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "SourceCodeDecorator.sourcecodedecorator";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SourcecodedecoratorPackage eINSTANCE = de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.impl.SourcecodedecoratorPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.impl.SourceCodeIDImpl <em>Source Code ID</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.impl.SourceCodeIDImpl
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.impl.SourcecodedecoratorPackageImpl#getSourceCodeID()
	 * @generated
	 */
	int SOURCE_CODE_ID = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_CODE_ID__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The feature id for the '<em><b>Source Code ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_CODE_ID__SOURCE_CODE_ID = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Source Code ID</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_CODE_ID_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.impl.FileLevelSourceCodeLinkImpl <em>File Level Source Code Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.impl.FileLevelSourceCodeLinkImpl
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.impl.SourcecodedecoratorPackageImpl#getFileLevelSourceCodeLink()
	 * @generated
	 */
	int FILE_LEVEL_SOURCE_CODE_LINK = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_LEVEL_SOURCE_CODE_LINK__ID = SOURCE_CODE_ID__ID;

	/**
	 * The feature id for the '<em><b>Source Code ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_LEVEL_SOURCE_CODE_LINK__SOURCE_CODE_ID = SOURCE_CODE_ID__SOURCE_CODE_ID;

	/**
	 * The feature id for the '<em><b>Sourcefiles</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_LEVEL_SOURCE_CODE_LINK__SOURCEFILES = SOURCE_CODE_ID_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>File Level Source Code Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILE_LEVEL_SOURCE_CODE_LINK_FEATURE_COUNT = SOURCE_CODE_ID_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.impl.SourceFileImpl <em>Source File</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.impl.SourceFileImpl
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.impl.SourcecodedecoratorPackageImpl#getSourceFile()
	 * @generated
	 */
	int SOURCE_FILE = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_FILE__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The feature id for the '<em><b>Full Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_FILE__FULL_QUALIFIED_NAME = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Source File</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_FILE_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.impl.MethodsImpl <em>Methods</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.impl.MethodsImpl
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.impl.SourcecodedecoratorPackageImpl#getMethods()
	 * @generated
	 */
	int METHODS = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHODS__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The feature id for the '<em><b>Relative Path In File</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHODS__RELATIVE_PATH_IN_FILE = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Method Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHODS__METHOD_NAME = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Methods</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHODS_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.impl.MethodLevelSourceCodeLinkImpl <em>Method Level Source Code Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.impl.MethodLevelSourceCodeLinkImpl
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.impl.SourcecodedecoratorPackageImpl#getMethodLevelSourceCodeLink()
	 * @generated
	 */
	int METHOD_LEVEL_SOURCE_CODE_LINK = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_LEVEL_SOURCE_CODE_LINK__ID = FILE_LEVEL_SOURCE_CODE_LINK__ID;

	/**
	 * The feature id for the '<em><b>Source Code ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_LEVEL_SOURCE_CODE_LINK__SOURCE_CODE_ID = FILE_LEVEL_SOURCE_CODE_LINK__SOURCE_CODE_ID;

	/**
	 * The feature id for the '<em><b>Sourcefiles</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_LEVEL_SOURCE_CODE_LINK__SOURCEFILES = FILE_LEVEL_SOURCE_CODE_LINK__SOURCEFILES;

	/**
	 * The feature id for the '<em><b>Methods</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_LEVEL_SOURCE_CODE_LINK__METHODS = FILE_LEVEL_SOURCE_CODE_LINK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Method Level Source Code Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_LEVEL_SOURCE_CODE_LINK_FEATURE_COUNT = FILE_LEVEL_SOURCE_CODE_LINK_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.impl.ControlFlowLevelSourceCodeLinkImpl <em>Control Flow Level Source Code Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.impl.ControlFlowLevelSourceCodeLinkImpl
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.impl.SourcecodedecoratorPackageImpl#getControlFlowLevelSourceCodeLink()
	 * @generated
	 */
	int CONTROL_FLOW_LEVEL_SOURCE_CODE_LINK = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_FLOW_LEVEL_SOURCE_CODE_LINK__ID = METHOD_LEVEL_SOURCE_CODE_LINK__ID;

	/**
	 * The feature id for the '<em><b>Source Code ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_FLOW_LEVEL_SOURCE_CODE_LINK__SOURCE_CODE_ID = METHOD_LEVEL_SOURCE_CODE_LINK__SOURCE_CODE_ID;

	/**
	 * The feature id for the '<em><b>Sourcefiles</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_FLOW_LEVEL_SOURCE_CODE_LINK__SOURCEFILES = METHOD_LEVEL_SOURCE_CODE_LINK__SOURCEFILES;

	/**
	 * The feature id for the '<em><b>Methods</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_FLOW_LEVEL_SOURCE_CODE_LINK__METHODS = METHOD_LEVEL_SOURCE_CODE_LINK__METHODS;

	/**
	 * The feature id for the '<em><b>Controlflow</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_FLOW_LEVEL_SOURCE_CODE_LINK__CONTROLFLOW = METHOD_LEVEL_SOURCE_CODE_LINK_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Control Flow Level Source Code Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_FLOW_LEVEL_SOURCE_CODE_LINK_FEATURE_COUNT = METHOD_LEVEL_SOURCE_CODE_LINK_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.impl.ControlFlowImpl <em>Control Flow</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.impl.ControlFlowImpl
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.impl.SourcecodedecoratorPackageImpl#getControlFlow()
	 * @generated
	 */
	int CONTROL_FLOW = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_FLOW__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The feature id for the '<em><b>Line Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_FLOW__LINE_NUMBER = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Control Flow</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTROL_FLOW_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.impl.SourceCodeDecoratorRepositoryImpl <em>Source Code Decorator Repository</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.impl.SourceCodeDecoratorRepositoryImpl
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.impl.SourcecodedecoratorPackageImpl#getSourceCodeDecoratorRepository()
	 * @generated
	 */
	int SOURCE_CODE_DECORATOR_REPOSITORY = 7;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_CODE_DECORATOR_REPOSITORY__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The feature id for the '<em><b>Filelevelsourcecodelink</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_CODE_DECORATOR_REPOSITORY__FILELEVELSOURCECODELINK = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Methodlevelsourcecodelink</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_CODE_DECORATOR_REPOSITORY__METHODLEVELSOURCECODELINK = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Controlflowlevelsourcecodelink</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_CODE_DECORATOR_REPOSITORY__CONTROLFLOWLEVELSOURCECODELINK = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Source Code Decorator Repository</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOURCE_CODE_DECORATOR_REPOSITORY_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 3;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.SourceCodeID <em>Source Code ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Source Code ID</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.SourceCodeID
	 * @generated
	 */
	EClass getSourceCodeID();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.SourceCodeID#getSourceCodeID <em>Source Code ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Source Code ID</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.SourceCodeID#getSourceCodeID()
	 * @see #getSourceCodeID()
	 * @generated
	 */
	EAttribute getSourceCodeID_SourceCodeID();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.FileLevelSourceCodeLink <em>File Level Source Code Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>File Level Source Code Link</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.FileLevelSourceCodeLink
	 * @generated
	 */
	EClass getFileLevelSourceCodeLink();

	/**
	 * Returns the meta object for the reference list '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.FileLevelSourceCodeLink#getSourcefiles <em>Sourcefiles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Sourcefiles</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.FileLevelSourceCodeLink#getSourcefiles()
	 * @see #getFileLevelSourceCodeLink()
	 * @generated
	 */
	EReference getFileLevelSourceCodeLink_Sourcefiles();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.SourceFile <em>Source File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Source File</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.SourceFile
	 * @generated
	 */
	EClass getSourceFile();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.SourceFile#getFullQualifiedName <em>Full Qualified Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Full Qualified Name</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.SourceFile#getFullQualifiedName()
	 * @see #getSourceFile()
	 * @generated
	 */
	EAttribute getSourceFile_FullQualifiedName();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.Methods <em>Methods</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Methods</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.Methods
	 * @generated
	 */
	EClass getMethods();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.Methods#getRelativePathInFile <em>Relative Path In File</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Relative Path In File</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.Methods#getRelativePathInFile()
	 * @see #getMethods()
	 * @generated
	 */
	EAttribute getMethods_RelativePathInFile();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.Methods#getMethodName <em>Method Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Method Name</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.Methods#getMethodName()
	 * @see #getMethods()
	 * @generated
	 */
	EAttribute getMethods_MethodName();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.MethodLevelSourceCodeLink <em>Method Level Source Code Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Method Level Source Code Link</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.MethodLevelSourceCodeLink
	 * @generated
	 */
	EClass getMethodLevelSourceCodeLink();

	/**
	 * Returns the meta object for the reference list '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.MethodLevelSourceCodeLink#getMethods <em>Methods</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Methods</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.MethodLevelSourceCodeLink#getMethods()
	 * @see #getMethodLevelSourceCodeLink()
	 * @generated
	 */
	EReference getMethodLevelSourceCodeLink_Methods();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.ControlFlowLevelSourceCodeLink <em>Control Flow Level Source Code Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Control Flow Level Source Code Link</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.ControlFlowLevelSourceCodeLink
	 * @generated
	 */
	EClass getControlFlowLevelSourceCodeLink();

	/**
	 * Returns the meta object for the reference list '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.ControlFlowLevelSourceCodeLink#getControlflow <em>Controlflow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Controlflow</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.ControlFlowLevelSourceCodeLink#getControlflow()
	 * @see #getControlFlowLevelSourceCodeLink()
	 * @generated
	 */
	EReference getControlFlowLevelSourceCodeLink_Controlflow();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.ControlFlow <em>Control Flow</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Control Flow</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.ControlFlow
	 * @generated
	 */
	EClass getControlFlow();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.ControlFlow#getLineNumber <em>Line Number</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Line Number</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.ControlFlow#getLineNumber()
	 * @see #getControlFlow()
	 * @generated
	 */
	EAttribute getControlFlow_LineNumber();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.SourceCodeDecoratorRepository <em>Source Code Decorator Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Source Code Decorator Repository</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.SourceCodeDecoratorRepository
	 * @generated
	 */
	EClass getSourceCodeDecoratorRepository();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.SourceCodeDecoratorRepository#getFilelevelsourcecodelink <em>Filelevelsourcecodelink</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Filelevelsourcecodelink</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.SourceCodeDecoratorRepository#getFilelevelsourcecodelink()
	 * @see #getSourceCodeDecoratorRepository()
	 * @generated
	 */
	EReference getSourceCodeDecoratorRepository_Filelevelsourcecodelink();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.SourceCodeDecoratorRepository#getMethodlevelsourcecodelink <em>Methodlevelsourcecodelink</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Methodlevelsourcecodelink</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.SourceCodeDecoratorRepository#getMethodlevelsourcecodelink()
	 * @see #getSourceCodeDecoratorRepository()
	 * @generated
	 */
	EReference getSourceCodeDecoratorRepository_Methodlevelsourcecodelink();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.SourceCodeDecoratorRepository#getControlflowlevelsourcecodelink <em>Controlflowlevelsourcecodelink</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Controlflowlevelsourcecodelink</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.SourceCodeDecoratorRepository#getControlflowlevelsourcecodelink()
	 * @see #getSourceCodeDecoratorRepository()
	 * @generated
	 */
	EReference getSourceCodeDecoratorRepository_Controlflowlevelsourcecodelink();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SourcecodedecoratorFactory getSourcecodedecoratorFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.impl.SourceCodeIDImpl <em>Source Code ID</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.impl.SourceCodeIDImpl
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.impl.SourcecodedecoratorPackageImpl#getSourceCodeID()
		 * @generated
		 */
		EClass SOURCE_CODE_ID = eINSTANCE.getSourceCodeID();

		/**
		 * The meta object literal for the '<em><b>Source Code ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOURCE_CODE_ID__SOURCE_CODE_ID = eINSTANCE.getSourceCodeID_SourceCodeID();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.impl.FileLevelSourceCodeLinkImpl <em>File Level Source Code Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.impl.FileLevelSourceCodeLinkImpl
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.impl.SourcecodedecoratorPackageImpl#getFileLevelSourceCodeLink()
		 * @generated
		 */
		EClass FILE_LEVEL_SOURCE_CODE_LINK = eINSTANCE.getFileLevelSourceCodeLink();

		/**
		 * The meta object literal for the '<em><b>Sourcefiles</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FILE_LEVEL_SOURCE_CODE_LINK__SOURCEFILES = eINSTANCE.getFileLevelSourceCodeLink_Sourcefiles();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.impl.SourceFileImpl <em>Source File</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.impl.SourceFileImpl
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.impl.SourcecodedecoratorPackageImpl#getSourceFile()
		 * @generated
		 */
		EClass SOURCE_FILE = eINSTANCE.getSourceFile();

		/**
		 * The meta object literal for the '<em><b>Full Qualified Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOURCE_FILE__FULL_QUALIFIED_NAME = eINSTANCE.getSourceFile_FullQualifiedName();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.impl.MethodsImpl <em>Methods</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.impl.MethodsImpl
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.impl.SourcecodedecoratorPackageImpl#getMethods()
		 * @generated
		 */
		EClass METHODS = eINSTANCE.getMethods();

		/**
		 * The meta object literal for the '<em><b>Relative Path In File</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METHODS__RELATIVE_PATH_IN_FILE = eINSTANCE.getMethods_RelativePathInFile();

		/**
		 * The meta object literal for the '<em><b>Method Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute METHODS__METHOD_NAME = eINSTANCE.getMethods_MethodName();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.impl.MethodLevelSourceCodeLinkImpl <em>Method Level Source Code Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.impl.MethodLevelSourceCodeLinkImpl
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.impl.SourcecodedecoratorPackageImpl#getMethodLevelSourceCodeLink()
		 * @generated
		 */
		EClass METHOD_LEVEL_SOURCE_CODE_LINK = eINSTANCE.getMethodLevelSourceCodeLink();

		/**
		 * The meta object literal for the '<em><b>Methods</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METHOD_LEVEL_SOURCE_CODE_LINK__METHODS = eINSTANCE.getMethodLevelSourceCodeLink_Methods();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.impl.ControlFlowLevelSourceCodeLinkImpl <em>Control Flow Level Source Code Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.impl.ControlFlowLevelSourceCodeLinkImpl
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.impl.SourcecodedecoratorPackageImpl#getControlFlowLevelSourceCodeLink()
		 * @generated
		 */
		EClass CONTROL_FLOW_LEVEL_SOURCE_CODE_LINK = eINSTANCE.getControlFlowLevelSourceCodeLink();

		/**
		 * The meta object literal for the '<em><b>Controlflow</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONTROL_FLOW_LEVEL_SOURCE_CODE_LINK__CONTROLFLOW = eINSTANCE.getControlFlowLevelSourceCodeLink_Controlflow();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.impl.ControlFlowImpl <em>Control Flow</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.impl.ControlFlowImpl
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.impl.SourcecodedecoratorPackageImpl#getControlFlow()
		 * @generated
		 */
		EClass CONTROL_FLOW = eINSTANCE.getControlFlow();

		/**
		 * The meta object literal for the '<em><b>Line Number</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTROL_FLOW__LINE_NUMBER = eINSTANCE.getControlFlow_LineNumber();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.impl.SourceCodeDecoratorRepositoryImpl <em>Source Code Decorator Repository</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.impl.SourceCodeDecoratorRepositoryImpl
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.impl.SourcecodedecoratorPackageImpl#getSourceCodeDecoratorRepository()
		 * @generated
		 */
		EClass SOURCE_CODE_DECORATOR_REPOSITORY = eINSTANCE.getSourceCodeDecoratorRepository();

		/**
		 * The meta object literal for the '<em><b>Filelevelsourcecodelink</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOURCE_CODE_DECORATOR_REPOSITORY__FILELEVELSOURCECODELINK = eINSTANCE.getSourceCodeDecoratorRepository_Filelevelsourcecodelink();

		/**
		 * The meta object literal for the '<em><b>Methodlevelsourcecodelink</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOURCE_CODE_DECORATOR_REPOSITORY__METHODLEVELSOURCECODELINK = eINSTANCE.getSourceCodeDecoratorRepository_Methodlevelsourcecodelink();

		/**
		 * The meta object literal for the '<em><b>Controlflowlevelsourcecodelink</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOURCE_CODE_DECORATOR_REPOSITORY__CONTROLFLOWLEVELSOURCECODELINK = eINSTANCE.getSourceCodeDecoratorRepository_Controlflowlevelsourcecodelink();

	}

} //SourcecodedecoratorPackage
