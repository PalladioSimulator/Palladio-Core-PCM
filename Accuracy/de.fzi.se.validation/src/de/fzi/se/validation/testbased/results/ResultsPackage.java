/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.validation.testbased.results;

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
 * @see de.fzi.se.validation.testbased.results.ResultsFactory
 * @model kind="package"
 * @generated
 */
public interface ResultsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "results";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://fzi.de/PalladioComponentModel/Validation/TestBased/Results/0.2";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "results";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ResultsPackage eINSTANCE = de.fzi.se.validation.testbased.results.impl.ResultsPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.fzi.se.validation.testbased.results.impl.ValidationFailureNoticeImpl <em>Validation Failure Notice</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.se.validation.testbased.results.impl.ValidationFailureNoticeImpl
	 * @see de.fzi.se.validation.testbased.results.impl.ResultsPackageImpl#getValidationFailureNotice()
	 * @generated
	 */
	int VALIDATION_FAILURE_NOTICE = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_FAILURE_NOTICE__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_FAILURE_NOTICE__DESCRIPTION = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Run Protocol</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_FAILURE_NOTICE__RUN_PROTOCOL = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Expected</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_FAILURE_NOTICE__EXPECTED = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Validation Failure Notice</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALIDATION_FAILURE_NOTICE_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.fzi.se.validation.testbased.results.impl.ParameterVFNImpl <em>Parameter VFN</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.se.validation.testbased.results.impl.ParameterVFNImpl
	 * @see de.fzi.se.validation.testbased.results.impl.ResultsPackageImpl#getParameterVFN()
	 * @generated
	 */
	int PARAMETER_VFN = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_VFN__ID = VALIDATION_FAILURE_NOTICE__ID;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_VFN__DESCRIPTION = VALIDATION_FAILURE_NOTICE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Run Protocol</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_VFN__RUN_PROTOCOL = VALIDATION_FAILURE_NOTICE__RUN_PROTOCOL;

	/**
	 * The feature id for the '<em><b>Expected</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_VFN__EXPECTED = VALIDATION_FAILURE_NOTICE__EXPECTED;

	/**
	 * The feature id for the '<em><b>Observed Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_VFN__OBSERVED_VALUE = VALIDATION_FAILURE_NOTICE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Expected Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_VFN__EXPECTED_VALUE = VALIDATION_FAILURE_NOTICE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Parameter VFN</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_VFN_FEATURE_COUNT = VALIDATION_FAILURE_NOTICE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.fzi.se.validation.testbased.results.impl.InfrastructureCallVFNImpl <em>Infrastructure Call VFN</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.se.validation.testbased.results.impl.InfrastructureCallVFNImpl
	 * @see de.fzi.se.validation.testbased.results.impl.ResultsPackageImpl#getInfrastructureCallVFN()
	 * @generated
	 */
	int INFRASTRUCTURE_CALL_VFN = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFRASTRUCTURE_CALL_VFN__ID = VALIDATION_FAILURE_NOTICE__ID;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFRASTRUCTURE_CALL_VFN__DESCRIPTION = VALIDATION_FAILURE_NOTICE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Run Protocol</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFRASTRUCTURE_CALL_VFN__RUN_PROTOCOL = VALIDATION_FAILURE_NOTICE__RUN_PROTOCOL;

	/**
	 * The feature id for the '<em><b>Expected</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFRASTRUCTURE_CALL_VFN__EXPECTED = VALIDATION_FAILURE_NOTICE__EXPECTED;

	/**
	 * The feature id for the '<em><b>Observed</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFRASTRUCTURE_CALL_VFN__OBSERVED = VALIDATION_FAILURE_NOTICE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Infrastructure Call VFN</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INFRASTRUCTURE_CALL_VFN_FEATURE_COUNT = VALIDATION_FAILURE_NOTICE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.fzi.se.validation.testbased.results.impl.ExternalCallVFNImpl <em>External Call VFN</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.se.validation.testbased.results.impl.ExternalCallVFNImpl
	 * @see de.fzi.se.validation.testbased.results.impl.ResultsPackageImpl#getExternalCallVFN()
	 * @generated
	 */
	int EXTERNAL_CALL_VFN = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_CALL_VFN__ID = VALIDATION_FAILURE_NOTICE__ID;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_CALL_VFN__DESCRIPTION = VALIDATION_FAILURE_NOTICE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Run Protocol</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_CALL_VFN__RUN_PROTOCOL = VALIDATION_FAILURE_NOTICE__RUN_PROTOCOL;

	/**
	 * The feature id for the '<em><b>Expected</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_CALL_VFN__EXPECTED = VALIDATION_FAILURE_NOTICE__EXPECTED;

	/**
	 * The feature id for the '<em><b>Observed</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_CALL_VFN__OBSERVED = VALIDATION_FAILURE_NOTICE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>External Call VFN</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_CALL_VFN_FEATURE_COUNT = VALIDATION_FAILURE_NOTICE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.fzi.se.validation.testbased.results.impl.ExecutionTraceVFNImpl <em>Execution Trace VFN</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.se.validation.testbased.results.impl.ExecutionTraceVFNImpl
	 * @see de.fzi.se.validation.testbased.results.impl.ResultsPackageImpl#getExecutionTraceVFN()
	 * @generated
	 */
	int EXECUTION_TRACE_VFN = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_TRACE_VFN__ID = VALIDATION_FAILURE_NOTICE__ID;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_TRACE_VFN__DESCRIPTION = VALIDATION_FAILURE_NOTICE__DESCRIPTION;

	/**
	 * The feature id for the '<em><b>Run Protocol</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_TRACE_VFN__RUN_PROTOCOL = VALIDATION_FAILURE_NOTICE__RUN_PROTOCOL;

	/**
	 * The feature id for the '<em><b>Expected</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_TRACE_VFN__EXPECTED = VALIDATION_FAILURE_NOTICE__EXPECTED;

	/**
	 * The feature id for the '<em><b>Execution Trace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_TRACE_VFN__EXECUTION_TRACE = VALIDATION_FAILURE_NOTICE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Execution Trace VFN</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXECUTION_TRACE_VFN_FEATURE_COUNT = VALIDATION_FAILURE_NOTICE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.fzi.se.validation.testbased.results.impl.RunProtocolImpl <em>Run Protocol</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fzi.se.validation.testbased.results.impl.RunProtocolImpl
	 * @see de.fzi.se.validation.testbased.results.impl.ResultsPackageImpl#getRunProtocol()
	 * @generated
	 */
	int RUN_PROTOCOL = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUN_PROTOCOL__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The feature id for the '<em><b>Validation Failure Notices</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUN_PROTOCOL__VALIDATION_FAILURE_NOTICES = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Creation Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUN_PROTOCOL__CREATION_TIME = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Random Seed</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUN_PROTOCOL__RANDOM_SEED = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Validation Successful</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUN_PROTOCOL__VALIDATION_SUCCESSFUL = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Invalid Measurement Results</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUN_PROTOCOL__INVALID_MEASUREMENT_RESULTS = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Invalid Traces</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUN_PROTOCOL__INVALID_TRACES = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Run Protocol</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RUN_PROTOCOL_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 6;


	/**
	 * Returns the meta object for class '{@link de.fzi.se.validation.testbased.results.ValidationFailureNotice <em>Validation Failure Notice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Validation Failure Notice</em>'.
	 * @see de.fzi.se.validation.testbased.results.ValidationFailureNotice
	 * @generated
	 */
	EClass getValidationFailureNotice();

	/**
	 * Returns the meta object for the attribute '{@link de.fzi.se.validation.testbased.results.ValidationFailureNotice#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see de.fzi.se.validation.testbased.results.ValidationFailureNotice#getDescription()
	 * @see #getValidationFailureNotice()
	 * @generated
	 */
	EAttribute getValidationFailureNotice_Description();

	/**
	 * Returns the meta object for the container reference '{@link de.fzi.se.validation.testbased.results.ValidationFailureNotice#getRunProtocol <em>Run Protocol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Run Protocol</em>'.
	 * @see de.fzi.se.validation.testbased.results.ValidationFailureNotice#getRunProtocol()
	 * @see #getValidationFailureNotice()
	 * @generated
	 */
	EReference getValidationFailureNotice_RunProtocol();

	/**
	 * Returns the meta object for the reference '{@link de.fzi.se.validation.testbased.results.ValidationFailureNotice#getExpected <em>Expected</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Expected</em>'.
	 * @see de.fzi.se.validation.testbased.results.ValidationFailureNotice#getExpected()
	 * @see #getValidationFailureNotice()
	 * @generated
	 */
	EReference getValidationFailureNotice_Expected();

	/**
	 * Returns the meta object for class '{@link de.fzi.se.validation.testbased.results.ParameterVFN <em>Parameter VFN</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter VFN</em>'.
	 * @see de.fzi.se.validation.testbased.results.ParameterVFN
	 * @generated
	 */
	EClass getParameterVFN();

	/**
	 * Returns the meta object for the containment reference '{@link de.fzi.se.validation.testbased.results.ParameterVFN#getObservedValue <em>Observed Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Observed Value</em>'.
	 * @see de.fzi.se.validation.testbased.results.ParameterVFN#getObservedValue()
	 * @see #getParameterVFN()
	 * @generated
	 */
	EReference getParameterVFN_ObservedValue();

	/**
	 * Returns the meta object for the containment reference '{@link de.fzi.se.validation.testbased.results.ParameterVFN#getExpectedValue <em>Expected Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expected Value</em>'.
	 * @see de.fzi.se.validation.testbased.results.ParameterVFN#getExpectedValue()
	 * @see #getParameterVFN()
	 * @generated
	 */
	EReference getParameterVFN_ExpectedValue();

	/**
	 * Returns the meta object for class '{@link de.fzi.se.validation.testbased.results.InfrastructureCallVFN <em>Infrastructure Call VFN</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Infrastructure Call VFN</em>'.
	 * @see de.fzi.se.validation.testbased.results.InfrastructureCallVFN
	 * @generated
	 */
	EClass getInfrastructureCallVFN();

	/**
	 * Returns the meta object for the reference '{@link de.fzi.se.validation.testbased.results.InfrastructureCallVFN#getObserved <em>Observed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Observed</em>'.
	 * @see de.fzi.se.validation.testbased.results.InfrastructureCallVFN#getObserved()
	 * @see #getInfrastructureCallVFN()
	 * @generated
	 */
	EReference getInfrastructureCallVFN_Observed();

	/**
	 * Returns the meta object for class '{@link de.fzi.se.validation.testbased.results.ExternalCallVFN <em>External Call VFN</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>External Call VFN</em>'.
	 * @see de.fzi.se.validation.testbased.results.ExternalCallVFN
	 * @generated
	 */
	EClass getExternalCallVFN();

	/**
	 * Returns the meta object for the reference '{@link de.fzi.se.validation.testbased.results.ExternalCallVFN#getObserved <em>Observed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Observed</em>'.
	 * @see de.fzi.se.validation.testbased.results.ExternalCallVFN#getObserved()
	 * @see #getExternalCallVFN()
	 * @generated
	 */
	EReference getExternalCallVFN_Observed();

	/**
	 * Returns the meta object for class '{@link de.fzi.se.validation.testbased.results.ExecutionTraceVFN <em>Execution Trace VFN</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Execution Trace VFN</em>'.
	 * @see de.fzi.se.validation.testbased.results.ExecutionTraceVFN
	 * @generated
	 */
	EClass getExecutionTraceVFN();

	/**
	 * Returns the meta object for the reference '{@link de.fzi.se.validation.testbased.results.ExecutionTraceVFN#getExecutionTrace <em>Execution Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Execution Trace</em>'.
	 * @see de.fzi.se.validation.testbased.results.ExecutionTraceVFN#getExecutionTrace()
	 * @see #getExecutionTraceVFN()
	 * @generated
	 */
	EReference getExecutionTraceVFN_ExecutionTrace();

	/**
	 * Returns the meta object for class '{@link de.fzi.se.validation.testbased.results.RunProtocol <em>Run Protocol</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Run Protocol</em>'.
	 * @see de.fzi.se.validation.testbased.results.RunProtocol
	 * @generated
	 */
	EClass getRunProtocol();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fzi.se.validation.testbased.results.RunProtocol#getValidationFailureNotices <em>Validation Failure Notices</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Validation Failure Notices</em>'.
	 * @see de.fzi.se.validation.testbased.results.RunProtocol#getValidationFailureNotices()
	 * @see #getRunProtocol()
	 * @generated
	 */
	EReference getRunProtocol_ValidationFailureNotices();

	/**
	 * Returns the meta object for the attribute '{@link de.fzi.se.validation.testbased.results.RunProtocol#getCreationTime <em>Creation Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Creation Time</em>'.
	 * @see de.fzi.se.validation.testbased.results.RunProtocol#getCreationTime()
	 * @see #getRunProtocol()
	 * @generated
	 */
	EAttribute getRunProtocol_CreationTime();

	/**
	 * Returns the meta object for the attribute '{@link de.fzi.se.validation.testbased.results.RunProtocol#getRandomSeed <em>Random Seed</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Random Seed</em>'.
	 * @see de.fzi.se.validation.testbased.results.RunProtocol#getRandomSeed()
	 * @see #getRunProtocol()
	 * @generated
	 */
	EAttribute getRunProtocol_RandomSeed();

	/**
	 * Returns the meta object for the attribute '{@link de.fzi.se.validation.testbased.results.RunProtocol#isValidationSuccessful <em>Validation Successful</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Validation Successful</em>'.
	 * @see de.fzi.se.validation.testbased.results.RunProtocol#isValidationSuccessful()
	 * @see #getRunProtocol()
	 * @generated
	 */
	EAttribute getRunProtocol_ValidationSuccessful();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fzi.se.validation.testbased.results.RunProtocol#getInvalidMeasurementResults <em>Invalid Measurement Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Invalid Measurement Results</em>'.
	 * @see de.fzi.se.validation.testbased.results.RunProtocol#getInvalidMeasurementResults()
	 * @see #getRunProtocol()
	 * @generated
	 */
	EReference getRunProtocol_InvalidMeasurementResults();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fzi.se.validation.testbased.results.RunProtocol#getInvalidTraces <em>Invalid Traces</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Invalid Traces</em>'.
	 * @see de.fzi.se.validation.testbased.results.RunProtocol#getInvalidTraces()
	 * @see #getRunProtocol()
	 * @generated
	 */
	EReference getRunProtocol_InvalidTraces();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ResultsFactory getResultsFactory();

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
		 * The meta object literal for the '{@link de.fzi.se.validation.testbased.results.impl.ValidationFailureNoticeImpl <em>Validation Failure Notice</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.se.validation.testbased.results.impl.ValidationFailureNoticeImpl
		 * @see de.fzi.se.validation.testbased.results.impl.ResultsPackageImpl#getValidationFailureNotice()
		 * @generated
		 */
		EClass VALIDATION_FAILURE_NOTICE = eINSTANCE.getValidationFailureNotice();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VALIDATION_FAILURE_NOTICE__DESCRIPTION = eINSTANCE.getValidationFailureNotice_Description();

		/**
		 * The meta object literal for the '<em><b>Run Protocol</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALIDATION_FAILURE_NOTICE__RUN_PROTOCOL = eINSTANCE.getValidationFailureNotice_RunProtocol();

		/**
		 * The meta object literal for the '<em><b>Expected</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VALIDATION_FAILURE_NOTICE__EXPECTED = eINSTANCE.getValidationFailureNotice_Expected();

		/**
		 * The meta object literal for the '{@link de.fzi.se.validation.testbased.results.impl.ParameterVFNImpl <em>Parameter VFN</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.se.validation.testbased.results.impl.ParameterVFNImpl
		 * @see de.fzi.se.validation.testbased.results.impl.ResultsPackageImpl#getParameterVFN()
		 * @generated
		 */
		EClass PARAMETER_VFN = eINSTANCE.getParameterVFN();

		/**
		 * The meta object literal for the '<em><b>Observed Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER_VFN__OBSERVED_VALUE = eINSTANCE.getParameterVFN_ObservedValue();

		/**
		 * The meta object literal for the '<em><b>Expected Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER_VFN__EXPECTED_VALUE = eINSTANCE.getParameterVFN_ExpectedValue();

		/**
		 * The meta object literal for the '{@link de.fzi.se.validation.testbased.results.impl.InfrastructureCallVFNImpl <em>Infrastructure Call VFN</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.se.validation.testbased.results.impl.InfrastructureCallVFNImpl
		 * @see de.fzi.se.validation.testbased.results.impl.ResultsPackageImpl#getInfrastructureCallVFN()
		 * @generated
		 */
		EClass INFRASTRUCTURE_CALL_VFN = eINSTANCE.getInfrastructureCallVFN();

		/**
		 * The meta object literal for the '<em><b>Observed</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INFRASTRUCTURE_CALL_VFN__OBSERVED = eINSTANCE.getInfrastructureCallVFN_Observed();

		/**
		 * The meta object literal for the '{@link de.fzi.se.validation.testbased.results.impl.ExternalCallVFNImpl <em>External Call VFN</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.se.validation.testbased.results.impl.ExternalCallVFNImpl
		 * @see de.fzi.se.validation.testbased.results.impl.ResultsPackageImpl#getExternalCallVFN()
		 * @generated
		 */
		EClass EXTERNAL_CALL_VFN = eINSTANCE.getExternalCallVFN();

		/**
		 * The meta object literal for the '<em><b>Observed</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTERNAL_CALL_VFN__OBSERVED = eINSTANCE.getExternalCallVFN_Observed();

		/**
		 * The meta object literal for the '{@link de.fzi.se.validation.testbased.results.impl.ExecutionTraceVFNImpl <em>Execution Trace VFN</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.se.validation.testbased.results.impl.ExecutionTraceVFNImpl
		 * @see de.fzi.se.validation.testbased.results.impl.ResultsPackageImpl#getExecutionTraceVFN()
		 * @generated
		 */
		EClass EXECUTION_TRACE_VFN = eINSTANCE.getExecutionTraceVFN();

		/**
		 * The meta object literal for the '<em><b>Execution Trace</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXECUTION_TRACE_VFN__EXECUTION_TRACE = eINSTANCE.getExecutionTraceVFN_ExecutionTrace();

		/**
		 * The meta object literal for the '{@link de.fzi.se.validation.testbased.results.impl.RunProtocolImpl <em>Run Protocol</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fzi.se.validation.testbased.results.impl.RunProtocolImpl
		 * @see de.fzi.se.validation.testbased.results.impl.ResultsPackageImpl#getRunProtocol()
		 * @generated
		 */
		EClass RUN_PROTOCOL = eINSTANCE.getRunProtocol();

		/**
		 * The meta object literal for the '<em><b>Validation Failure Notices</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RUN_PROTOCOL__VALIDATION_FAILURE_NOTICES = eINSTANCE.getRunProtocol_ValidationFailureNotices();

		/**
		 * The meta object literal for the '<em><b>Creation Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RUN_PROTOCOL__CREATION_TIME = eINSTANCE.getRunProtocol_CreationTime();

		/**
		 * The meta object literal for the '<em><b>Random Seed</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RUN_PROTOCOL__RANDOM_SEED = eINSTANCE.getRunProtocol_RandomSeed();

		/**
		 * The meta object literal for the '<em><b>Validation Successful</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RUN_PROTOCOL__VALIDATION_SUCCESSFUL = eINSTANCE.getRunProtocol_ValidationSuccessful();

		/**
		 * The meta object literal for the '<em><b>Invalid Measurement Results</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RUN_PROTOCOL__INVALID_MEASUREMENT_RESULTS = eINSTANCE.getRunProtocol_InvalidMeasurementResults();

		/**
		 * The meta object literal for the '<em><b>Invalid Traces</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RUN_PROTOCOL__INVALID_TRACES = eINSTANCE.getRunProtocol_InvalidTraces();

	}

} //ResultsPackage
