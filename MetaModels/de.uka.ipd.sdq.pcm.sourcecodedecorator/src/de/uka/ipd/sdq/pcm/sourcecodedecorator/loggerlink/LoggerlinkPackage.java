/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink;

import de.uka.ipd.sdq.identifier.IdentifierPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

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
 * <!-- begin-model-doc -->
 * The LoggerLink package is required for associating&nbsp;logging data to pcm entities&nbsp;only. It does not decorate the
 * source code.
 * <!-- end-model-doc -->
 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggerlinkFactory
 * @model kind="package"
 * @generated
 */
public interface LoggerlinkPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "loggerlink";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///SourceCodeDecorator/loggerLink.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "SourceCodeDecorator.loggerLink";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LoggerlinkPackage eINSTANCE = de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.LoggerlinkPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.LoggingPositionIdLinkImpl <em>Logging Position Id Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.LoggingPositionIdLinkImpl
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.LoggerlinkPackageImpl#getLoggingPositionIdLink()
	 * @generated
	 */
	int LOGGING_POSITION_ID_LINK = 8;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGGING_POSITION_ID_LINK__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The feature id for the '<em><b>Logging Position Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGGING_POSITION_ID_LINK__LOGGING_POSITION_ID = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Logging Position Id Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGGING_POSITION_ID_LINK_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.OutputLoggingPositionLinkImpl <em>Output Logging Position Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.OutputLoggingPositionLinkImpl
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.LoggerlinkPackageImpl#getOutputLoggingPositionLink()
	 * @generated
	 */
	int OUTPUT_LOGGING_POSITION_LINK = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_LOGGING_POSITION_LINK__ID = LOGGING_POSITION_ID_LINK__ID;

	/**
	 * The feature id for the '<em><b>Logging Position Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_LOGGING_POSITION_LINK__LOGGING_POSITION_ID = LOGGING_POSITION_ID_LINK__LOGGING_POSITION_ID;

	/**
	 * The number of structural features of the '<em>Output Logging Position Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_LOGGING_POSITION_LINK_FEATURE_COUNT = LOGGING_POSITION_ID_LINK_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.BeforeReturnValueLoggingPositionLinkImpl <em>Before Return Value Logging Position Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.BeforeReturnValueLoggingPositionLinkImpl
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.LoggerlinkPackageImpl#getBeforeReturnValueLoggingPositionLink()
	 * @generated
	 */
	int BEFORE_RETURN_VALUE_LOGGING_POSITION_LINK = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEFORE_RETURN_VALUE_LOGGING_POSITION_LINK__ID = OUTPUT_LOGGING_POSITION_LINK__ID;

	/**
	 * The feature id for the '<em><b>Logging Position Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEFORE_RETURN_VALUE_LOGGING_POSITION_LINK__LOGGING_POSITION_ID = OUTPUT_LOGGING_POSITION_LINK__LOGGING_POSITION_ID;

	/**
	 * The feature id for the '<em><b>Linked Set Variable Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEFORE_RETURN_VALUE_LOGGING_POSITION_LINK__LINKED_SET_VARIABLE_ACTION = OUTPUT_LOGGING_POSITION_LINK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Provided Function Of Surrounding Seff</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEFORE_RETURN_VALUE_LOGGING_POSITION_LINK__PROVIDED_FUNCTION_OF_SURROUNDING_SEFF = OUTPUT_LOGGING_POSITION_LINK_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Parameter Link</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEFORE_RETURN_VALUE_LOGGING_POSITION_LINK__PARAMETER_LINK = OUTPUT_LOGGING_POSITION_LINK_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Before Return Value Logging Position Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEFORE_RETURN_VALUE_LOGGING_POSITION_LINK_FEATURE_COUNT = OUTPUT_LOGGING_POSITION_LINK_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.BeforeExternalCallLoggingPositionLinkImpl <em>Before External Call Logging Position Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.BeforeExternalCallLoggingPositionLinkImpl
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.LoggerlinkPackageImpl#getBeforeExternalCallLoggingPositionLink()
	 * @generated
	 */
	int BEFORE_EXTERNAL_CALL_LOGGING_POSITION_LINK = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEFORE_EXTERNAL_CALL_LOGGING_POSITION_LINK__ID = OUTPUT_LOGGING_POSITION_LINK__ID;

	/**
	 * The feature id for the '<em><b>Logging Position Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEFORE_EXTERNAL_CALL_LOGGING_POSITION_LINK__LOGGING_POSITION_ID = OUTPUT_LOGGING_POSITION_LINK__LOGGING_POSITION_ID;

	/**
	 * The feature id for the '<em><b>Linked External Call Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEFORE_EXTERNAL_CALL_LOGGING_POSITION_LINK__LINKED_EXTERNAL_CALL_ACTION = OUTPUT_LOGGING_POSITION_LINK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Called Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEFORE_EXTERNAL_CALL_LOGGING_POSITION_LINK__CALLED_FUNCTION = OUTPUT_LOGGING_POSITION_LINK_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Parameter Link</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEFORE_EXTERNAL_CALL_LOGGING_POSITION_LINK__PARAMETER_LINK = OUTPUT_LOGGING_POSITION_LINK_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Before External Call Logging Position Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BEFORE_EXTERNAL_CALL_LOGGING_POSITION_LINK_FEATURE_COUNT = OUTPUT_LOGGING_POSITION_LINK_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.InputLoggingPositionLinkImpl <em>Input Logging Position Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.InputLoggingPositionLinkImpl
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.LoggerlinkPackageImpl#getInputLoggingPositionLink()
	 * @generated
	 */
	int INPUT_LOGGING_POSITION_LINK = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_LOGGING_POSITION_LINK__ID = LOGGING_POSITION_ID_LINK__ID;

	/**
	 * The feature id for the '<em><b>Logging Position Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_LOGGING_POSITION_LINK__LOGGING_POSITION_ID = LOGGING_POSITION_ID_LINK__LOGGING_POSITION_ID;

	/**
	 * The number of structural features of the '<em>Input Logging Position Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_LOGGING_POSITION_LINK_FEATURE_COUNT = LOGGING_POSITION_ID_LINK_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.MethodCallLoggingPositionLinkImpl <em>Method Call Logging Position Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.MethodCallLoggingPositionLinkImpl
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.LoggerlinkPackageImpl#getMethodCallLoggingPositionLink()
	 * @generated
	 */
	int METHOD_CALL_LOGGING_POSITION_LINK = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_CALL_LOGGING_POSITION_LINK__ID = INPUT_LOGGING_POSITION_LINK__ID;

	/**
	 * The feature id for the '<em><b>Logging Position Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_CALL_LOGGING_POSITION_LINK__LOGGING_POSITION_ID = INPUT_LOGGING_POSITION_LINK__LOGGING_POSITION_ID;

	/**
	 * The feature id for the '<em><b>Linked Service Effect Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_CALL_LOGGING_POSITION_LINK__LINKED_SERVICE_EFFECT_SPECIFICATION = INPUT_LOGGING_POSITION_LINK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Provided Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_CALL_LOGGING_POSITION_LINK__PROVIDED_FUNCTION = INPUT_LOGGING_POSITION_LINK_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Parameter Links</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_CALL_LOGGING_POSITION_LINK__PARAMETER_LINKS = INPUT_LOGGING_POSITION_LINK_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Method Call Logging Position Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int METHOD_CALL_LOGGING_POSITION_LINK_FEATURE_COUNT = INPUT_LOGGING_POSITION_LINK_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.AfterExternalCallLoggingPositionLinkImpl <em>After External Call Logging Position Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.AfterExternalCallLoggingPositionLinkImpl
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.LoggerlinkPackageImpl#getAfterExternalCallLoggingPositionLink()
	 * @generated
	 */
	int AFTER_EXTERNAL_CALL_LOGGING_POSITION_LINK = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AFTER_EXTERNAL_CALL_LOGGING_POSITION_LINK__ID = INPUT_LOGGING_POSITION_LINK__ID;

	/**
	 * The feature id for the '<em><b>Logging Position Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AFTER_EXTERNAL_CALL_LOGGING_POSITION_LINK__LOGGING_POSITION_ID = INPUT_LOGGING_POSITION_LINK__LOGGING_POSITION_ID;

	/**
	 * The feature id for the '<em><b>Linked External Call Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AFTER_EXTERNAL_CALL_LOGGING_POSITION_LINK__LINKED_EXTERNAL_CALL_ACTION = INPUT_LOGGING_POSITION_LINK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Called Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AFTER_EXTERNAL_CALL_LOGGING_POSITION_LINK__CALLED_FUNCTION = INPUT_LOGGING_POSITION_LINK_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Parameter Link</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AFTER_EXTERNAL_CALL_LOGGING_POSITION_LINK__PARAMETER_LINK = INPUT_LOGGING_POSITION_LINK_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>After External Call Logging Position Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AFTER_EXTERNAL_CALL_LOGGING_POSITION_LINK_FEATURE_COUNT = INPUT_LOGGING_POSITION_LINK_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.BranchLoggingPositionLinkImpl <em>Branch Logging Position Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.BranchLoggingPositionLinkImpl
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.LoggerlinkPackageImpl#getBranchLoggingPositionLink()
	 * @generated
	 */
	int BRANCH_LOGGING_POSITION_LINK = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_LOGGING_POSITION_LINK__ID = OUTPUT_LOGGING_POSITION_LINK__ID;

	/**
	 * The feature id for the '<em><b>Logging Position Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_LOGGING_POSITION_LINK__LOGGING_POSITION_ID = OUTPUT_LOGGING_POSITION_LINK__LOGGING_POSITION_ID;

	/**
	 * The feature id for the '<em><b>Linked Guarded Branch Transition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_LOGGING_POSITION_LINK__LINKED_GUARDED_BRANCH_TRANSITION = OUTPUT_LOGGING_POSITION_LINK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Branch Statement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_LOGGING_POSITION_LINK__BRANCH_STATEMENT = OUTPUT_LOGGING_POSITION_LINK_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Branch Logging Position Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BRANCH_LOGGING_POSITION_LINK_FEATURE_COUNT = OUTPUT_LOGGING_POSITION_LINK_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.LoopLoggingPositionLinkImpl <em>Loop Logging Position Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.LoopLoggingPositionLinkImpl
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.LoggerlinkPackageImpl#getLoopLoggingPositionLink()
	 * @generated
	 */
	int LOOP_LOGGING_POSITION_LINK = 7;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_LOGGING_POSITION_LINK__ID = OUTPUT_LOGGING_POSITION_LINK__ID;

	/**
	 * The feature id for the '<em><b>Logging Position Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_LOGGING_POSITION_LINK__LOGGING_POSITION_ID = OUTPUT_LOGGING_POSITION_LINK__LOGGING_POSITION_ID;

	/**
	 * The feature id for the '<em><b>Linked Loop Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_LOGGING_POSITION_LINK__LINKED_LOOP_ACTION = OUTPUT_LOGGING_POSITION_LINK_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Loop Statement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_LOGGING_POSITION_LINK__LOOP_STATEMENT = OUTPUT_LOGGING_POSITION_LINK_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Loop Logging Position Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOOP_LOGGING_POSITION_LINK_FEATURE_COUNT = OUTPUT_LOGGING_POSITION_LINK_FEATURE_COUNT + 2;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.BeforeReturnValueLoggingPositionLink <em>Before Return Value Logging Position Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Before Return Value Logging Position Link</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.BeforeReturnValueLoggingPositionLink
	 * @generated
	 */
	EClass getBeforeReturnValueLoggingPositionLink();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.BeforeReturnValueLoggingPositionLink#getLinkedSetVariableAction <em>Linked Set Variable Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Linked Set Variable Action</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.BeforeReturnValueLoggingPositionLink#getLinkedSetVariableAction()
	 * @see #getBeforeReturnValueLoggingPositionLink()
	 * @generated
	 */
	EReference getBeforeReturnValueLoggingPositionLink_LinkedSetVariableAction();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.BeforeReturnValueLoggingPositionLink#getProvidedFunctionOfSurroundingSeff <em>Provided Function Of Surrounding Seff</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Provided Function Of Surrounding Seff</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.BeforeReturnValueLoggingPositionLink#getProvidedFunctionOfSurroundingSeff()
	 * @see #getBeforeReturnValueLoggingPositionLink()
	 * @generated
	 */
	EReference getBeforeReturnValueLoggingPositionLink_ProvidedFunctionOfSurroundingSeff();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.BeforeReturnValueLoggingPositionLink#getParameterLink <em>Parameter Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter Link</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.BeforeReturnValueLoggingPositionLink#getParameterLink()
	 * @see #getBeforeReturnValueLoggingPositionLink()
	 * @generated
	 */
	EReference getBeforeReturnValueLoggingPositionLink_ParameterLink();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.OutputLoggingPositionLink <em>Output Logging Position Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output Logging Position Link</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.OutputLoggingPositionLink
	 * @generated
	 */
	EClass getOutputLoggingPositionLink();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.BeforeExternalCallLoggingPositionLink <em>Before External Call Logging Position Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Before External Call Logging Position Link</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.BeforeExternalCallLoggingPositionLink
	 * @generated
	 */
	EClass getBeforeExternalCallLoggingPositionLink();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.BeforeExternalCallLoggingPositionLink#getLinkedExternalCallAction <em>Linked External Call Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Linked External Call Action</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.BeforeExternalCallLoggingPositionLink#getLinkedExternalCallAction()
	 * @see #getBeforeExternalCallLoggingPositionLink()
	 * @generated
	 */
	EReference getBeforeExternalCallLoggingPositionLink_LinkedExternalCallAction();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.BeforeExternalCallLoggingPositionLink#getCalledFunction <em>Called Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Called Function</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.BeforeExternalCallLoggingPositionLink#getCalledFunction()
	 * @see #getBeforeExternalCallLoggingPositionLink()
	 * @generated
	 */
	EReference getBeforeExternalCallLoggingPositionLink_CalledFunction();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.BeforeExternalCallLoggingPositionLink#getParameterLink <em>Parameter Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter Link</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.BeforeExternalCallLoggingPositionLink#getParameterLink()
	 * @see #getBeforeExternalCallLoggingPositionLink()
	 * @generated
	 */
	EReference getBeforeExternalCallLoggingPositionLink_ParameterLink();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.MethodCallLoggingPositionLink <em>Method Call Logging Position Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Method Call Logging Position Link</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.MethodCallLoggingPositionLink
	 * @generated
	 */
	EClass getMethodCallLoggingPositionLink();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.MethodCallLoggingPositionLink#getLinkedServiceEffectSpecification <em>Linked Service Effect Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Linked Service Effect Specification</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.MethodCallLoggingPositionLink#getLinkedServiceEffectSpecification()
	 * @see #getMethodCallLoggingPositionLink()
	 * @generated
	 */
	EReference getMethodCallLoggingPositionLink_LinkedServiceEffectSpecification();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.MethodCallLoggingPositionLink#getProvidedFunction <em>Provided Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Provided Function</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.MethodCallLoggingPositionLink#getProvidedFunction()
	 * @see #getMethodCallLoggingPositionLink()
	 * @generated
	 */
	EReference getMethodCallLoggingPositionLink_ProvidedFunction();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.MethodCallLoggingPositionLink#getParameterLinks <em>Parameter Links</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter Links</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.MethodCallLoggingPositionLink#getParameterLinks()
	 * @see #getMethodCallLoggingPositionLink()
	 * @generated
	 */
	EReference getMethodCallLoggingPositionLink_ParameterLinks();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.InputLoggingPositionLink <em>Input Logging Position Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Logging Position Link</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.InputLoggingPositionLink
	 * @generated
	 */
	EClass getInputLoggingPositionLink();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.AfterExternalCallLoggingPositionLink <em>After External Call Logging Position Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>After External Call Logging Position Link</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.AfterExternalCallLoggingPositionLink
	 * @generated
	 */
	EClass getAfterExternalCallLoggingPositionLink();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.AfterExternalCallLoggingPositionLink#getLinkedExternalCallAction <em>Linked External Call Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Linked External Call Action</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.AfterExternalCallLoggingPositionLink#getLinkedExternalCallAction()
	 * @see #getAfterExternalCallLoggingPositionLink()
	 * @generated
	 */
	EReference getAfterExternalCallLoggingPositionLink_LinkedExternalCallAction();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.AfterExternalCallLoggingPositionLink#getCalledFunction <em>Called Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Called Function</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.AfterExternalCallLoggingPositionLink#getCalledFunction()
	 * @see #getAfterExternalCallLoggingPositionLink()
	 * @generated
	 */
	EReference getAfterExternalCallLoggingPositionLink_CalledFunction();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.AfterExternalCallLoggingPositionLink#getParameterLink <em>Parameter Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter Link</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.AfterExternalCallLoggingPositionLink#getParameterLink()
	 * @see #getAfterExternalCallLoggingPositionLink()
	 * @generated
	 */
	EReference getAfterExternalCallLoggingPositionLink_ParameterLink();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.BranchLoggingPositionLink <em>Branch Logging Position Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Branch Logging Position Link</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.BranchLoggingPositionLink
	 * @generated
	 */
	EClass getBranchLoggingPositionLink();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.BranchLoggingPositionLink#getLinkedGuardedBranchTransition <em>Linked Guarded Branch Transition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Linked Guarded Branch Transition</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.BranchLoggingPositionLink#getLinkedGuardedBranchTransition()
	 * @see #getBranchLoggingPositionLink()
	 * @generated
	 */
	EReference getBranchLoggingPositionLink_LinkedGuardedBranchTransition();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.BranchLoggingPositionLink#getBranchStatement <em>Branch Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Branch Statement</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.BranchLoggingPositionLink#getBranchStatement()
	 * @see #getBranchLoggingPositionLink()
	 * @generated
	 */
	EReference getBranchLoggingPositionLink_BranchStatement();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoopLoggingPositionLink <em>Loop Logging Position Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Loop Logging Position Link</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoopLoggingPositionLink
	 * @generated
	 */
	EClass getLoopLoggingPositionLink();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoopLoggingPositionLink#getLinkedLoopAction <em>Linked Loop Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Linked Loop Action</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoopLoggingPositionLink#getLinkedLoopAction()
	 * @see #getLoopLoggingPositionLink()
	 * @generated
	 */
	EReference getLoopLoggingPositionLink_LinkedLoopAction();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoopLoggingPositionLink#getLoopStatement <em>Loop Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Loop Statement</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoopLoggingPositionLink#getLoopStatement()
	 * @see #getLoopLoggingPositionLink()
	 * @generated
	 */
	EReference getLoopLoggingPositionLink_LoopStatement();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggingPositionIdLink <em>Logging Position Id Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Logging Position Id Link</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggingPositionIdLink
	 * @generated
	 */
	EClass getLoggingPositionIdLink();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggingPositionIdLink#getLoggingPositionId <em>Logging Position Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Logging Position Id</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggingPositionIdLink#getLoggingPositionId()
	 * @see #getLoggingPositionIdLink()
	 * @generated
	 */
	EAttribute getLoggingPositionIdLink_LoggingPositionId();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	LoggerlinkFactory getLoggerlinkFactory();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.BeforeReturnValueLoggingPositionLinkImpl <em>Before Return Value Logging Position Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.BeforeReturnValueLoggingPositionLinkImpl
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.LoggerlinkPackageImpl#getBeforeReturnValueLoggingPositionLink()
		 * @generated
		 */
		EClass BEFORE_RETURN_VALUE_LOGGING_POSITION_LINK = eINSTANCE.getBeforeReturnValueLoggingPositionLink();

		/**
		 * The meta object literal for the '<em><b>Linked Set Variable Action</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEFORE_RETURN_VALUE_LOGGING_POSITION_LINK__LINKED_SET_VARIABLE_ACTION = eINSTANCE.getBeforeReturnValueLoggingPositionLink_LinkedSetVariableAction();

		/**
		 * The meta object literal for the '<em><b>Provided Function Of Surrounding Seff</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEFORE_RETURN_VALUE_LOGGING_POSITION_LINK__PROVIDED_FUNCTION_OF_SURROUNDING_SEFF = eINSTANCE.getBeforeReturnValueLoggingPositionLink_ProvidedFunctionOfSurroundingSeff();

		/**
		 * The meta object literal for the '<em><b>Parameter Link</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEFORE_RETURN_VALUE_LOGGING_POSITION_LINK__PARAMETER_LINK = eINSTANCE.getBeforeReturnValueLoggingPositionLink_ParameterLink();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.OutputLoggingPositionLinkImpl <em>Output Logging Position Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.OutputLoggingPositionLinkImpl
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.LoggerlinkPackageImpl#getOutputLoggingPositionLink()
		 * @generated
		 */
		EClass OUTPUT_LOGGING_POSITION_LINK = eINSTANCE.getOutputLoggingPositionLink();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.BeforeExternalCallLoggingPositionLinkImpl <em>Before External Call Logging Position Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.BeforeExternalCallLoggingPositionLinkImpl
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.LoggerlinkPackageImpl#getBeforeExternalCallLoggingPositionLink()
		 * @generated
		 */
		EClass BEFORE_EXTERNAL_CALL_LOGGING_POSITION_LINK = eINSTANCE.getBeforeExternalCallLoggingPositionLink();

		/**
		 * The meta object literal for the '<em><b>Linked External Call Action</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEFORE_EXTERNAL_CALL_LOGGING_POSITION_LINK__LINKED_EXTERNAL_CALL_ACTION = eINSTANCE.getBeforeExternalCallLoggingPositionLink_LinkedExternalCallAction();

		/**
		 * The meta object literal for the '<em><b>Called Function</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEFORE_EXTERNAL_CALL_LOGGING_POSITION_LINK__CALLED_FUNCTION = eINSTANCE.getBeforeExternalCallLoggingPositionLink_CalledFunction();

		/**
		 * The meta object literal for the '<em><b>Parameter Link</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BEFORE_EXTERNAL_CALL_LOGGING_POSITION_LINK__PARAMETER_LINK = eINSTANCE.getBeforeExternalCallLoggingPositionLink_ParameterLink();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.MethodCallLoggingPositionLinkImpl <em>Method Call Logging Position Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.MethodCallLoggingPositionLinkImpl
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.LoggerlinkPackageImpl#getMethodCallLoggingPositionLink()
		 * @generated
		 */
		EClass METHOD_CALL_LOGGING_POSITION_LINK = eINSTANCE.getMethodCallLoggingPositionLink();

		/**
		 * The meta object literal for the '<em><b>Linked Service Effect Specification</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METHOD_CALL_LOGGING_POSITION_LINK__LINKED_SERVICE_EFFECT_SPECIFICATION = eINSTANCE.getMethodCallLoggingPositionLink_LinkedServiceEffectSpecification();

		/**
		 * The meta object literal for the '<em><b>Provided Function</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METHOD_CALL_LOGGING_POSITION_LINK__PROVIDED_FUNCTION = eINSTANCE.getMethodCallLoggingPositionLink_ProvidedFunction();

		/**
		 * The meta object literal for the '<em><b>Parameter Links</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference METHOD_CALL_LOGGING_POSITION_LINK__PARAMETER_LINKS = eINSTANCE.getMethodCallLoggingPositionLink_ParameterLinks();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.InputLoggingPositionLinkImpl <em>Input Logging Position Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.InputLoggingPositionLinkImpl
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.LoggerlinkPackageImpl#getInputLoggingPositionLink()
		 * @generated
		 */
		EClass INPUT_LOGGING_POSITION_LINK = eINSTANCE.getInputLoggingPositionLink();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.AfterExternalCallLoggingPositionLinkImpl <em>After External Call Logging Position Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.AfterExternalCallLoggingPositionLinkImpl
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.LoggerlinkPackageImpl#getAfterExternalCallLoggingPositionLink()
		 * @generated
		 */
		EClass AFTER_EXTERNAL_CALL_LOGGING_POSITION_LINK = eINSTANCE.getAfterExternalCallLoggingPositionLink();

		/**
		 * The meta object literal for the '<em><b>Linked External Call Action</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AFTER_EXTERNAL_CALL_LOGGING_POSITION_LINK__LINKED_EXTERNAL_CALL_ACTION = eINSTANCE.getAfterExternalCallLoggingPositionLink_LinkedExternalCallAction();

		/**
		 * The meta object literal for the '<em><b>Called Function</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AFTER_EXTERNAL_CALL_LOGGING_POSITION_LINK__CALLED_FUNCTION = eINSTANCE.getAfterExternalCallLoggingPositionLink_CalledFunction();

		/**
		 * The meta object literal for the '<em><b>Parameter Link</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AFTER_EXTERNAL_CALL_LOGGING_POSITION_LINK__PARAMETER_LINK = eINSTANCE.getAfterExternalCallLoggingPositionLink_ParameterLink();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.BranchLoggingPositionLinkImpl <em>Branch Logging Position Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.BranchLoggingPositionLinkImpl
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.LoggerlinkPackageImpl#getBranchLoggingPositionLink()
		 * @generated
		 */
		EClass BRANCH_LOGGING_POSITION_LINK = eINSTANCE.getBranchLoggingPositionLink();

		/**
		 * The meta object literal for the '<em><b>Linked Guarded Branch Transition</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BRANCH_LOGGING_POSITION_LINK__LINKED_GUARDED_BRANCH_TRANSITION = eINSTANCE.getBranchLoggingPositionLink_LinkedGuardedBranchTransition();

		/**
		 * The meta object literal for the '<em><b>Branch Statement</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BRANCH_LOGGING_POSITION_LINK__BRANCH_STATEMENT = eINSTANCE.getBranchLoggingPositionLink_BranchStatement();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.LoopLoggingPositionLinkImpl <em>Loop Logging Position Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.LoopLoggingPositionLinkImpl
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.LoggerlinkPackageImpl#getLoopLoggingPositionLink()
		 * @generated
		 */
		EClass LOOP_LOGGING_POSITION_LINK = eINSTANCE.getLoopLoggingPositionLink();

		/**
		 * The meta object literal for the '<em><b>Linked Loop Action</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOP_LOGGING_POSITION_LINK__LINKED_LOOP_ACTION = eINSTANCE.getLoopLoggingPositionLink_LinkedLoopAction();

		/**
		 * The meta object literal for the '<em><b>Loop Statement</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOOP_LOGGING_POSITION_LINK__LOOP_STATEMENT = eINSTANCE.getLoopLoggingPositionLink_LoopStatement();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.LoggingPositionIdLinkImpl <em>Logging Position Id Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.LoggingPositionIdLinkImpl
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.LoggerlinkPackageImpl#getLoggingPositionIdLink()
		 * @generated
		 */
		EClass LOGGING_POSITION_ID_LINK = eINSTANCE.getLoggingPositionIdLink();

		/**
		 * The meta object literal for the '<em><b>Logging Position Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOGGING_POSITION_ID_LINK__LOGGING_POSITION_ID = eINSTANCE.getLoggingPositionIdLink_LoggingPositionId();

	}

} //LoggerlinkPackage
