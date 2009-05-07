/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.core;

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
 * @see de.uka.ipd.sdq.capra.core.CoreFactory
 * @model kind="package"
 * @generated
 */
public interface CorePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "core";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/Capra/Core/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "capra.core";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CorePackage eINSTANCE = de.uka.ipd.sdq.capra.core.impl.CorePackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.core.impl.ReplicatedProcessImpl <em>Replicated Process</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.core.impl.ReplicatedProcessImpl
	 * @see de.uka.ipd.sdq.capra.core.impl.CorePackageImpl#getReplicatedProcess()
	 * @generated
	 */
	int REPLICATED_PROCESS = 0;

	/**
	 * The feature id for the '<em><b>Num Replicas</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLICATED_PROCESS__NUM_REPLICAS = 0;

	/**
	 * The feature id for the '<em><b>Processvariable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLICATED_PROCESS__PROCESSVARIABLE = 1;

	/**
	 * The number of structural features of the '<em>Replicated Process</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REPLICATED_PROCESS_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.core.impl.ProcessVariableImpl <em>Process Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.core.impl.ProcessVariableImpl
	 * @see de.uka.ipd.sdq.capra.core.impl.CorePackageImpl#getProcessVariable()
	 * @generated
	 */
	int PROCESS_VARIABLE = 1;

	/**
	 * The feature id for the '<em><b>Process</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_VARIABLE__PROCESS = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_VARIABLE__NAME = 1;

	/**
	 * The number of structural features of the '<em>Process Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_VARIABLE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.core.impl.CapraExpressionImpl <em>Capra Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.core.impl.CapraExpressionImpl
	 * @see de.uka.ipd.sdq.capra.core.impl.CorePackageImpl#getCapraExpression()
	 * @generated
	 */
	int CAPRA_EXPRESSION = 2;

	/**
	 * The number of structural features of the '<em>Capra Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPRA_EXPRESSION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.core.impl.ActionImpl <em>Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.core.impl.ActionImpl
	 * @see de.uka.ipd.sdq.capra.core.impl.CorePackageImpl#getAction()
	 * @generated
	 */
	int ACTION = 4;

	/**
	 * The number of structural features of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.core.impl.InstantaneousActionImpl <em>Instantaneous Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.core.impl.InstantaneousActionImpl
	 * @see de.uka.ipd.sdq.capra.core.impl.CorePackageImpl#getInstantaneousAction()
	 * @generated
	 */
	int INSTANTANEOUS_ACTION = 3;

	/**
	 * The number of structural features of the '<em>Instantaneous Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INSTANTANEOUS_ACTION_FEATURE_COUNT = ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.core.impl.TerminalImpl <em>Terminal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.core.impl.TerminalImpl
	 * @see de.uka.ipd.sdq.capra.core.impl.CorePackageImpl#getTerminal()
	 * @generated
	 */
	int TERMINAL = 5;

	/**
	 * The number of structural features of the '<em>Terminal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TERMINAL_FEATURE_COUNT = CAPRA_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.core.impl.OperatorImpl <em>Operator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.core.impl.OperatorImpl
	 * @see de.uka.ipd.sdq.capra.core.impl.CorePackageImpl#getOperator()
	 * @generated
	 */
	int OPERATOR = 6;

	/**
	 * The number of structural features of the '<em>Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATOR_FEATURE_COUNT = CAPRA_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.core.impl.EventActionImpl <em>Event Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.core.impl.EventActionImpl
	 * @see de.uka.ipd.sdq.capra.core.impl.CorePackageImpl#getEventAction()
	 * @generated
	 */
	int EVENT_ACTION = 7;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_ACTION__IDENTIFIER = INSTANTANEOUS_ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Event Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_ACTION_FEATURE_COUNT = INSTANTANEOUS_ACTION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.core.impl.IdentifierImpl <em>Identifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.core.impl.IdentifierImpl
	 * @see de.uka.ipd.sdq.capra.core.impl.CorePackageImpl#getIdentifier()
	 * @generated
	 */
	int IDENTIFIER = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER__NAME = 0;

	/**
	 * The number of structural features of the '<em>Identifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IDENTIFIER_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.core.impl.CommunicationIdentifierImpl <em>Communication Identifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.core.impl.CommunicationIdentifierImpl
	 * @see de.uka.ipd.sdq.capra.core.impl.CorePackageImpl#getCommunicationIdentifier()
	 * @generated
	 */
	int COMMUNICATION_IDENTIFIER = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_IDENTIFIER__NAME = IDENTIFIER__NAME;

	/**
	 * The number of structural features of the '<em>Communication Identifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_IDENTIFIER_FEATURE_COUNT = IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.core.impl.DemandActionImpl <em>Demand Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.core.impl.DemandActionImpl
	 * @see de.uka.ipd.sdq.capra.core.impl.CorePackageImpl#getDemandAction()
	 * @generated
	 */
	int DEMAND_ACTION = 10;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEMAND_ACTION__IDENTIFIER = ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Resource Usage</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEMAND_ACTION__RESOURCE_USAGE = ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Demand Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEMAND_ACTION_FEATURE_COUNT = ACTION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.core.impl.DemandIdentifierImpl <em>Demand Identifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.core.impl.DemandIdentifierImpl
	 * @see de.uka.ipd.sdq.capra.core.impl.CorePackageImpl#getDemandIdentifier()
	 * @generated
	 */
	int DEMAND_IDENTIFIER = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEMAND_IDENTIFIER__NAME = IDENTIFIER__NAME;

	/**
	 * The number of structural features of the '<em>Demand Identifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEMAND_IDENTIFIER_FEATURE_COUNT = IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.core.impl.AbstractResourceUsageImpl <em>Abstract Resource Usage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.core.impl.AbstractResourceUsageImpl
	 * @see de.uka.ipd.sdq.capra.core.impl.CorePackageImpl#getAbstractResourceUsage()
	 * @generated
	 */
	int ABSTRACT_RESOURCE_USAGE = 12;

	/**
	 * The number of structural features of the '<em>Abstract Resource Usage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ABSTRACT_RESOURCE_USAGE_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.core.impl.SuccessfulTerminationImpl <em>Successful Termination</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.core.impl.SuccessfulTerminationImpl
	 * @see de.uka.ipd.sdq.capra.core.impl.CorePackageImpl#getSuccessfulTermination()
	 * @generated
	 */
	int SUCCESSFUL_TERMINATION = 13;

	/**
	 * The number of structural features of the '<em>Successful Termination</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SUCCESSFUL_TERMINATION_FEATURE_COUNT = TERMINAL_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.core.impl.ProbabilisticPrefixImpl <em>Probabilistic Prefix</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.core.impl.ProbabilisticPrefixImpl
	 * @see de.uka.ipd.sdq.capra.core.impl.CorePackageImpl#getProbabilisticPrefix()
	 * @generated
	 */
	int PROBABILISTIC_PREFIX = 14;

	/**
	 * The feature id for the '<em><b>Action</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBABILISTIC_PREFIX__ACTION = OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Options</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBABILISTIC_PREFIX__TARGET_OPTIONS = OPERATOR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Probabilistic Prefix</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROBABILISTIC_PREFIX_FEATURE_COUNT = OPERATOR_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.core.impl.InternalSelectorImpl <em>Internal Selector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.core.impl.InternalSelectorImpl
	 * @see de.uka.ipd.sdq.capra.core.impl.CorePackageImpl#getInternalSelector()
	 * @generated
	 */
	int INTERNAL_SELECTOR = 15;

	/**
	 * The feature id for the '<em><b>Probability</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_SELECTOR__PROBABILITY = 0;

	/**
	 * The feature id for the '<em><b>Process</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_SELECTOR__PROCESS = 1;

	/**
	 * The number of structural features of the '<em>Internal Selector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERNAL_SELECTOR_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.core.impl.ChoiceImpl <em>Choice</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.core.impl.ChoiceImpl
	 * @see de.uka.ipd.sdq.capra.core.impl.CorePackageImpl#getChoice()
	 * @generated
	 */
	int CHOICE = 16;

	/**
	 * The feature id for the '<em><b>Options</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE__OPTIONS = OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Choice</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHOICE_FEATURE_COUNT = OPERATOR_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.core.impl.ExternalSelectorImpl <em>External Selector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.core.impl.ExternalSelectorImpl
	 * @see de.uka.ipd.sdq.capra.core.impl.CorePackageImpl#getExternalSelector()
	 * @generated
	 */
	int EXTERNAL_SELECTOR = 17;

	/**
	 * The feature id for the '<em><b>Input</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_SELECTOR__INPUT = 0;

	/**
	 * The feature id for the '<em><b>Target Process</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_SELECTOR__TARGET_PROCESS = 1;

	/**
	 * The number of structural features of the '<em>External Selector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_SELECTOR_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.core.impl.InputEventActionImpl <em>Input Event Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.core.impl.InputEventActionImpl
	 * @see de.uka.ipd.sdq.capra.core.impl.CorePackageImpl#getInputEventAction()
	 * @generated
	 */
	int INPUT_EVENT_ACTION = 18;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_EVENT_ACTION__IDENTIFIER = EVENT_ACTION__IDENTIFIER;

	/**
	 * The number of structural features of the '<em>Input Event Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_EVENT_ACTION_FEATURE_COUNT = EVENT_ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.core.impl.OutputEventActionImpl <em>Output Event Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.core.impl.OutputEventActionImpl
	 * @see de.uka.ipd.sdq.capra.core.impl.CorePackageImpl#getOutputEventAction()
	 * @generated
	 */
	int OUTPUT_EVENT_ACTION = 19;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_EVENT_ACTION__IDENTIFIER = EVENT_ACTION__IDENTIFIER;

	/**
	 * The number of structural features of the '<em>Output Event Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_EVENT_ACTION_FEATURE_COUNT = EVENT_ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.core.impl.CommunicationEventActionImpl <em>Communication Event Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.core.impl.CommunicationEventActionImpl
	 * @see de.uka.ipd.sdq.capra.core.impl.CorePackageImpl#getCommunicationEventAction()
	 * @generated
	 */
	int COMMUNICATION_EVENT_ACTION = 20;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_EVENT_ACTION__IDENTIFIER = EVENT_ACTION__IDENTIFIER;

	/**
	 * The number of structural features of the '<em>Communication Event Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMUNICATION_EVENT_ACTION_FEATURE_COUNT = EVENT_ACTION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.core.impl.BoundedLoopImpl <em>Bounded Loop</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.core.impl.BoundedLoopImpl
	 * @see de.uka.ipd.sdq.capra.core.impl.CorePackageImpl#getBoundedLoop()
	 * @generated
	 */
	int BOUNDED_LOOP = 21;

	/**
	 * The feature id for the '<em><b>Repeated Process</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDED_LOOP__REPEATED_PROCESS = OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Process</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDED_LOOP__TARGET_PROCESS = OPERATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Number Of Iterations</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDED_LOOP__NUMBER_OF_ITERATIONS = OPERATOR_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Bounded Loop</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOUNDED_LOOP_FEATURE_COUNT = OPERATOR_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.core.impl.ParallelCompositionImpl <em>Parallel Composition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.core.impl.ParallelCompositionImpl
	 * @see de.uka.ipd.sdq.capra.core.impl.CorePackageImpl#getParallelComposition()
	 * @generated
	 */
	int PARALLEL_COMPOSITION = 22;

	/**
	 * The feature id for the '<em><b>Parallel Processes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_COMPOSITION__PARALLEL_PROCESSES = OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Process</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_COMPOSITION__TARGET_PROCESS = OPERATOR_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Is Synchronised</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_COMPOSITION__IS_SYNCHRONISED = OPERATOR_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Parallel Composition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARALLEL_COMPOSITION_FEATURE_COUNT = OPERATOR_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.core.impl.RestrictionImpl <em>Restriction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.core.impl.RestrictionImpl
	 * @see de.uka.ipd.sdq.capra.core.impl.CorePackageImpl#getRestriction()
	 * @generated
	 */
	int RESTRICTION = 23;

	/**
	 * The feature id for the '<em><b>Restricted Process</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESTRICTION__RESTRICTED_PROCESS = OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Restricted Identifiers</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESTRICTION__RESTRICTED_IDENTIFIERS = OPERATOR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Restriction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESTRICTION_FEATURE_COUNT = OPERATOR_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.core.impl.ResourceUsageImpl <em>Resource Usage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.core.impl.ResourceUsageImpl
	 * @see de.uka.ipd.sdq.capra.core.impl.CorePackageImpl#getResourceUsage()
	 * @generated
	 */
	int RESOURCE_USAGE = 24;

	/**
	 * The feature id for the '<em><b>Resource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_USAGE__RESOURCE = ABSTRACT_RESOURCE_USAGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Usage Time</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_USAGE__USAGE_TIME = ABSTRACT_RESOURCE_USAGE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Usage Time Specification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_USAGE__USAGE_TIME_SPECIFICATION = ABSTRACT_RESOURCE_USAGE_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Resource Usage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RESOURCE_USAGE_FEATURE_COUNT = ABSTRACT_RESOURCE_USAGE_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.core.impl.RenamingImpl <em>Renaming</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.core.impl.RenamingImpl
	 * @see de.uka.ipd.sdq.capra.core.impl.CorePackageImpl#getRenaming()
	 * @generated
	 */
	int RENAMING = 25;

	/**
	 * The feature id for the '<em><b>Renamed Process</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAMING__RENAMED_PROCESS = OPERATOR_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mapping</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAMING__MAPPING = OPERATOR_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Renaming</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RENAMING_FEATURE_COUNT = OPERATOR_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.core.impl.MappingImpl <em>Mapping</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.core.impl.MappingImpl
	 * @see de.uka.ipd.sdq.capra.core.impl.CorePackageImpl#getMapping()
	 * @generated
	 */
	int MAPPING = 26;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__SOURCE = 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING__TARGET = 1;

	/**
	 * The number of structural features of the '<em>Mapping</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MAPPING_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.core.impl.SilentIdentifierImpl <em>Silent Identifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.core.impl.SilentIdentifierImpl
	 * @see de.uka.ipd.sdq.capra.core.impl.CorePackageImpl#getSilentIdentifier()
	 * @generated
	 */
	int SILENT_IDENTIFIER = 27;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SILENT_IDENTIFIER__NAME = COMMUNICATION_IDENTIFIER__NAME;

	/**
	 * The number of structural features of the '<em>Silent Identifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SILENT_IDENTIFIER_FEATURE_COUNT = COMMUNICATION_IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.core.impl.ProcessVariableUsageImpl <em>Process Variable Usage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.core.impl.ProcessVariableUsageImpl
	 * @see de.uka.ipd.sdq.capra.core.impl.CorePackageImpl#getProcessVariableUsage()
	 * @generated
	 */
	int PROCESS_VARIABLE_USAGE = 28;

	/**
	 * The feature id for the '<em><b>Process Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_VARIABLE_USAGE__PROCESS_VARIABLE = CAPRA_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Process Variable Usage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROCESS_VARIABLE_USAGE_FEATURE_COUNT = CAPRA_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.capra.core.impl.VariableResourceUsageImpl <em>Variable Resource Usage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.capra.core.impl.VariableResourceUsageImpl
	 * @see de.uka.ipd.sdq.capra.core.impl.CorePackageImpl#getVariableResourceUsage()
	 * @generated
	 */
	int VARIABLE_RESOURCE_USAGE = 29;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_RESOURCE_USAGE__NAME = ABSTRACT_RESOURCE_USAGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Variable Resource Usage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_RESOURCE_USAGE_FEATURE_COUNT = ABSTRACT_RESOURCE_USAGE_FEATURE_COUNT + 1;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.core.ReplicatedProcess <em>Replicated Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Replicated Process</em>'.
	 * @see de.uka.ipd.sdq.capra.core.ReplicatedProcess
	 * @generated
	 */
	EClass getReplicatedProcess();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.capra.core.ReplicatedProcess#getNumReplicas <em>Num Replicas</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Num Replicas</em>'.
	 * @see de.uka.ipd.sdq.capra.core.ReplicatedProcess#getNumReplicas()
	 * @see #getReplicatedProcess()
	 * @generated
	 */
	EAttribute getReplicatedProcess_NumReplicas();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.capra.core.ReplicatedProcess#getProcessvariable <em>Processvariable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Processvariable</em>'.
	 * @see de.uka.ipd.sdq.capra.core.ReplicatedProcess#getProcessvariable()
	 * @see #getReplicatedProcess()
	 * @generated
	 */
	EReference getReplicatedProcess_Processvariable();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.core.ProcessVariable <em>Process Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Process Variable</em>'.
	 * @see de.uka.ipd.sdq.capra.core.ProcessVariable
	 * @generated
	 */
	EClass getProcessVariable();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.capra.core.ProcessVariable#getProcess <em>Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Process</em>'.
	 * @see de.uka.ipd.sdq.capra.core.ProcessVariable#getProcess()
	 * @see #getProcessVariable()
	 * @generated
	 */
	EReference getProcessVariable_Process();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.capra.core.ProcessVariable#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.uka.ipd.sdq.capra.core.ProcessVariable#getName()
	 * @see #getProcessVariable()
	 * @generated
	 */
	EAttribute getProcessVariable_Name();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.core.CapraExpression <em>Capra Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Capra Expression</em>'.
	 * @see de.uka.ipd.sdq.capra.core.CapraExpression
	 * @generated
	 */
	EClass getCapraExpression();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.core.InstantaneousAction <em>Instantaneous Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Instantaneous Action</em>'.
	 * @see de.uka.ipd.sdq.capra.core.InstantaneousAction
	 * @generated
	 */
	EClass getInstantaneousAction();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.core.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action</em>'.
	 * @see de.uka.ipd.sdq.capra.core.Action
	 * @generated
	 */
	EClass getAction();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.core.Terminal <em>Terminal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Terminal</em>'.
	 * @see de.uka.ipd.sdq.capra.core.Terminal
	 * @generated
	 */
	EClass getTerminal();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.core.Operator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Operator</em>'.
	 * @see de.uka.ipd.sdq.capra.core.Operator
	 * @generated
	 */
	EClass getOperator();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.core.EventAction <em>Event Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Event Action</em>'.
	 * @see de.uka.ipd.sdq.capra.core.EventAction
	 * @generated
	 */
	EClass getEventAction();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.capra.core.EventAction#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Identifier</em>'.
	 * @see de.uka.ipd.sdq.capra.core.EventAction#getIdentifier()
	 * @see #getEventAction()
	 * @generated
	 */
	EReference getEventAction_Identifier();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.core.CommunicationIdentifier <em>Communication Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Communication Identifier</em>'.
	 * @see de.uka.ipd.sdq.capra.core.CommunicationIdentifier
	 * @generated
	 */
	EClass getCommunicationIdentifier();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.core.Identifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Identifier</em>'.
	 * @see de.uka.ipd.sdq.capra.core.Identifier
	 * @generated
	 */
	EClass getIdentifier();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.capra.core.Identifier#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.uka.ipd.sdq.capra.core.Identifier#getName()
	 * @see #getIdentifier()
	 * @generated
	 */
	EAttribute getIdentifier_Name();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.core.DemandAction <em>Demand Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Demand Action</em>'.
	 * @see de.uka.ipd.sdq.capra.core.DemandAction
	 * @generated
	 */
	EClass getDemandAction();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.capra.core.DemandAction#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Identifier</em>'.
	 * @see de.uka.ipd.sdq.capra.core.DemandAction#getIdentifier()
	 * @see #getDemandAction()
	 * @generated
	 */
	EReference getDemandAction_Identifier();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.capra.core.DemandAction#getResourceUsage <em>Resource Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Resource Usage</em>'.
	 * @see de.uka.ipd.sdq.capra.core.DemandAction#getResourceUsage()
	 * @see #getDemandAction()
	 * @generated
	 */
	EReference getDemandAction_ResourceUsage();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.core.DemandIdentifier <em>Demand Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Demand Identifier</em>'.
	 * @see de.uka.ipd.sdq.capra.core.DemandIdentifier
	 * @generated
	 */
	EClass getDemandIdentifier();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.core.AbstractResourceUsage <em>Abstract Resource Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstract Resource Usage</em>'.
	 * @see de.uka.ipd.sdq.capra.core.AbstractResourceUsage
	 * @generated
	 */
	EClass getAbstractResourceUsage();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.core.SuccessfulTermination <em>Successful Termination</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Successful Termination</em>'.
	 * @see de.uka.ipd.sdq.capra.core.SuccessfulTermination
	 * @generated
	 */
	EClass getSuccessfulTermination();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.core.ProbabilisticPrefix <em>Probabilistic Prefix</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Probabilistic Prefix</em>'.
	 * @see de.uka.ipd.sdq.capra.core.ProbabilisticPrefix
	 * @generated
	 */
	EClass getProbabilisticPrefix();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.capra.core.ProbabilisticPrefix#getAction <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Action</em>'.
	 * @see de.uka.ipd.sdq.capra.core.ProbabilisticPrefix#getAction()
	 * @see #getProbabilisticPrefix()
	 * @generated
	 */
	EReference getProbabilisticPrefix_Action();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.capra.core.ProbabilisticPrefix#getTargetOptions <em>Target Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Target Options</em>'.
	 * @see de.uka.ipd.sdq.capra.core.ProbabilisticPrefix#getTargetOptions()
	 * @see #getProbabilisticPrefix()
	 * @generated
	 */
	EReference getProbabilisticPrefix_TargetOptions();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.core.InternalSelector <em>Internal Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Internal Selector</em>'.
	 * @see de.uka.ipd.sdq.capra.core.InternalSelector
	 * @generated
	 */
	EClass getInternalSelector();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.capra.core.InternalSelector#getProbability <em>Probability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Probability</em>'.
	 * @see de.uka.ipd.sdq.capra.core.InternalSelector#getProbability()
	 * @see #getInternalSelector()
	 * @generated
	 */
	EAttribute getInternalSelector_Probability();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.capra.core.InternalSelector#getProcess <em>Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Process</em>'.
	 * @see de.uka.ipd.sdq.capra.core.InternalSelector#getProcess()
	 * @see #getInternalSelector()
	 * @generated
	 */
	EReference getInternalSelector_Process();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.core.Choice <em>Choice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Choice</em>'.
	 * @see de.uka.ipd.sdq.capra.core.Choice
	 * @generated
	 */
	EClass getChoice();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.capra.core.Choice#getOptions <em>Options</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Options</em>'.
	 * @see de.uka.ipd.sdq.capra.core.Choice#getOptions()
	 * @see #getChoice()
	 * @generated
	 */
	EReference getChoice_Options();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.core.ExternalSelector <em>External Selector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>External Selector</em>'.
	 * @see de.uka.ipd.sdq.capra.core.ExternalSelector
	 * @generated
	 */
	EClass getExternalSelector();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.capra.core.ExternalSelector#getInput <em>Input</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Input</em>'.
	 * @see de.uka.ipd.sdq.capra.core.ExternalSelector#getInput()
	 * @see #getExternalSelector()
	 * @generated
	 */
	EReference getExternalSelector_Input();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.capra.core.ExternalSelector#getTargetProcess <em>Target Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target Process</em>'.
	 * @see de.uka.ipd.sdq.capra.core.ExternalSelector#getTargetProcess()
	 * @see #getExternalSelector()
	 * @generated
	 */
	EReference getExternalSelector_TargetProcess();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.core.InputEventAction <em>Input Event Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Event Action</em>'.
	 * @see de.uka.ipd.sdq.capra.core.InputEventAction
	 * @generated
	 */
	EClass getInputEventAction();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.core.OutputEventAction <em>Output Event Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output Event Action</em>'.
	 * @see de.uka.ipd.sdq.capra.core.OutputEventAction
	 * @generated
	 */
	EClass getOutputEventAction();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.core.CommunicationEventAction <em>Communication Event Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Communication Event Action</em>'.
	 * @see de.uka.ipd.sdq.capra.core.CommunicationEventAction
	 * @generated
	 */
	EClass getCommunicationEventAction();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.core.BoundedLoop <em>Bounded Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bounded Loop</em>'.
	 * @see de.uka.ipd.sdq.capra.core.BoundedLoop
	 * @generated
	 */
	EClass getBoundedLoop();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.capra.core.BoundedLoop#getRepeatedProcess <em>Repeated Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Repeated Process</em>'.
	 * @see de.uka.ipd.sdq.capra.core.BoundedLoop#getRepeatedProcess()
	 * @see #getBoundedLoop()
	 * @generated
	 */
	EReference getBoundedLoop_RepeatedProcess();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.capra.core.BoundedLoop#getTargetProcess <em>Target Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target Process</em>'.
	 * @see de.uka.ipd.sdq.capra.core.BoundedLoop#getTargetProcess()
	 * @see #getBoundedLoop()
	 * @generated
	 */
	EReference getBoundedLoop_TargetProcess();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.capra.core.BoundedLoop#getNumberOfIterations <em>Number Of Iterations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Number Of Iterations</em>'.
	 * @see de.uka.ipd.sdq.capra.core.BoundedLoop#getNumberOfIterations()
	 * @see #getBoundedLoop()
	 * @generated
	 */
	EReference getBoundedLoop_NumberOfIterations();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.core.ParallelComposition <em>Parallel Composition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parallel Composition</em>'.
	 * @see de.uka.ipd.sdq.capra.core.ParallelComposition
	 * @generated
	 */
	EClass getParallelComposition();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.capra.core.ParallelComposition#getParallelProcesses <em>Parallel Processes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parallel Processes</em>'.
	 * @see de.uka.ipd.sdq.capra.core.ParallelComposition#getParallelProcesses()
	 * @see #getParallelComposition()
	 * @generated
	 */
	EReference getParallelComposition_ParallelProcesses();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.capra.core.ParallelComposition#getTargetProcess <em>Target Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target Process</em>'.
	 * @see de.uka.ipd.sdq.capra.core.ParallelComposition#getTargetProcess()
	 * @see #getParallelComposition()
	 * @generated
	 */
	EReference getParallelComposition_TargetProcess();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.capra.core.ParallelComposition#isIsSynchronised <em>Is Synchronised</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Synchronised</em>'.
	 * @see de.uka.ipd.sdq.capra.core.ParallelComposition#isIsSynchronised()
	 * @see #getParallelComposition()
	 * @generated
	 */
	EAttribute getParallelComposition_IsSynchronised();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.core.Restriction <em>Restriction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Restriction</em>'.
	 * @see de.uka.ipd.sdq.capra.core.Restriction
	 * @generated
	 */
	EClass getRestriction();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.capra.core.Restriction#getRestrictedProcess <em>Restricted Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Restricted Process</em>'.
	 * @see de.uka.ipd.sdq.capra.core.Restriction#getRestrictedProcess()
	 * @see #getRestriction()
	 * @generated
	 */
	EReference getRestriction_RestrictedProcess();

	/**
	 * Returns the meta object for the reference list '{@link de.uka.ipd.sdq.capra.core.Restriction#getRestrictedIdentifiers <em>Restricted Identifiers</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Restricted Identifiers</em>'.
	 * @see de.uka.ipd.sdq.capra.core.Restriction#getRestrictedIdentifiers()
	 * @see #getRestriction()
	 * @generated
	 */
	EReference getRestriction_RestrictedIdentifiers();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.core.ResourceUsage <em>Resource Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Resource Usage</em>'.
	 * @see de.uka.ipd.sdq.capra.core.ResourceUsage
	 * @generated
	 */
	EClass getResourceUsage();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.capra.core.ResourceUsage#getResource <em>Resource</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Resource</em>'.
	 * @see de.uka.ipd.sdq.capra.core.ResourceUsage#getResource()
	 * @see #getResourceUsage()
	 * @generated
	 */
	EReference getResourceUsage_Resource();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.capra.core.ResourceUsage#getUsageTime <em>Usage Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Usage Time</em>'.
	 * @see de.uka.ipd.sdq.capra.core.ResourceUsage#getUsageTime()
	 * @see #getResourceUsage()
	 * @generated
	 */
	EReference getResourceUsage_UsageTime();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.capra.core.ResourceUsage#getUsageTimeSpecification <em>Usage Time Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Usage Time Specification</em>'.
	 * @see de.uka.ipd.sdq.capra.core.ResourceUsage#getUsageTimeSpecification()
	 * @see #getResourceUsage()
	 * @generated
	 */
	EAttribute getResourceUsage_UsageTimeSpecification();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.core.Renaming <em>Renaming</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Renaming</em>'.
	 * @see de.uka.ipd.sdq.capra.core.Renaming
	 * @generated
	 */
	EClass getRenaming();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.capra.core.Renaming#getRenamedProcess <em>Renamed Process</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Renamed Process</em>'.
	 * @see de.uka.ipd.sdq.capra.core.Renaming#getRenamedProcess()
	 * @see #getRenaming()
	 * @generated
	 */
	EReference getRenaming_RenamedProcess();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.capra.core.Renaming#getMapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mapping</em>'.
	 * @see de.uka.ipd.sdq.capra.core.Renaming#getMapping()
	 * @see #getRenaming()
	 * @generated
	 */
	EReference getRenaming_Mapping();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.core.Mapping <em>Mapping</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Mapping</em>'.
	 * @see de.uka.ipd.sdq.capra.core.Mapping
	 * @generated
	 */
	EClass getMapping();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.capra.core.Mapping#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see de.uka.ipd.sdq.capra.core.Mapping#getSource()
	 * @see #getMapping()
	 * @generated
	 */
	EReference getMapping_Source();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.capra.core.Mapping#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Target</em>'.
	 * @see de.uka.ipd.sdq.capra.core.Mapping#getTarget()
	 * @see #getMapping()
	 * @generated
	 */
	EReference getMapping_Target();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.core.SilentIdentifier <em>Silent Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Silent Identifier</em>'.
	 * @see de.uka.ipd.sdq.capra.core.SilentIdentifier
	 * @generated
	 */
	EClass getSilentIdentifier();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.core.ProcessVariableUsage <em>Process Variable Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Process Variable Usage</em>'.
	 * @see de.uka.ipd.sdq.capra.core.ProcessVariableUsage
	 * @generated
	 */
	EClass getProcessVariableUsage();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.capra.core.ProcessVariableUsage#getProcessVariable <em>Process Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Process Variable</em>'.
	 * @see de.uka.ipd.sdq.capra.core.ProcessVariableUsage#getProcessVariable()
	 * @see #getProcessVariableUsage()
	 * @generated
	 */
	EReference getProcessVariableUsage_ProcessVariable();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.capra.core.VariableResourceUsage <em>Variable Resource Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Resource Usage</em>'.
	 * @see de.uka.ipd.sdq.capra.core.VariableResourceUsage
	 * @generated
	 */
	EClass getVariableResourceUsage();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.capra.core.VariableResourceUsage#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.uka.ipd.sdq.capra.core.VariableResourceUsage#getName()
	 * @see #getVariableResourceUsage()
	 * @generated
	 */
	EAttribute getVariableResourceUsage_Name();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CoreFactory getCoreFactory();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.core.impl.ReplicatedProcessImpl <em>Replicated Process</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.core.impl.ReplicatedProcessImpl
		 * @see de.uka.ipd.sdq.capra.core.impl.CorePackageImpl#getReplicatedProcess()
		 * @generated
		 */
		EClass REPLICATED_PROCESS = eINSTANCE.getReplicatedProcess();

		/**
		 * The meta object literal for the '<em><b>Num Replicas</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute REPLICATED_PROCESS__NUM_REPLICAS = eINSTANCE.getReplicatedProcess_NumReplicas();

		/**
		 * The meta object literal for the '<em><b>Processvariable</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REPLICATED_PROCESS__PROCESSVARIABLE = eINSTANCE.getReplicatedProcess_Processvariable();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.core.impl.ProcessVariableImpl <em>Process Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.core.impl.ProcessVariableImpl
		 * @see de.uka.ipd.sdq.capra.core.impl.CorePackageImpl#getProcessVariable()
		 * @generated
		 */
		EClass PROCESS_VARIABLE = eINSTANCE.getProcessVariable();

		/**
		 * The meta object literal for the '<em><b>Process</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESS_VARIABLE__PROCESS = eINSTANCE.getProcessVariable_Process();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PROCESS_VARIABLE__NAME = eINSTANCE.getProcessVariable_Name();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.core.impl.CapraExpressionImpl <em>Capra Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.core.impl.CapraExpressionImpl
		 * @see de.uka.ipd.sdq.capra.core.impl.CorePackageImpl#getCapraExpression()
		 * @generated
		 */
		EClass CAPRA_EXPRESSION = eINSTANCE.getCapraExpression();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.core.impl.InstantaneousActionImpl <em>Instantaneous Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.core.impl.InstantaneousActionImpl
		 * @see de.uka.ipd.sdq.capra.core.impl.CorePackageImpl#getInstantaneousAction()
		 * @generated
		 */
		EClass INSTANTANEOUS_ACTION = eINSTANCE.getInstantaneousAction();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.core.impl.ActionImpl <em>Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.core.impl.ActionImpl
		 * @see de.uka.ipd.sdq.capra.core.impl.CorePackageImpl#getAction()
		 * @generated
		 */
		EClass ACTION = eINSTANCE.getAction();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.core.impl.TerminalImpl <em>Terminal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.core.impl.TerminalImpl
		 * @see de.uka.ipd.sdq.capra.core.impl.CorePackageImpl#getTerminal()
		 * @generated
		 */
		EClass TERMINAL = eINSTANCE.getTerminal();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.core.impl.OperatorImpl <em>Operator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.core.impl.OperatorImpl
		 * @see de.uka.ipd.sdq.capra.core.impl.CorePackageImpl#getOperator()
		 * @generated
		 */
		EClass OPERATOR = eINSTANCE.getOperator();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.core.impl.EventActionImpl <em>Event Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.core.impl.EventActionImpl
		 * @see de.uka.ipd.sdq.capra.core.impl.CorePackageImpl#getEventAction()
		 * @generated
		 */
		EClass EVENT_ACTION = eINSTANCE.getEventAction();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EVENT_ACTION__IDENTIFIER = eINSTANCE.getEventAction_Identifier();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.core.impl.CommunicationIdentifierImpl <em>Communication Identifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.core.impl.CommunicationIdentifierImpl
		 * @see de.uka.ipd.sdq.capra.core.impl.CorePackageImpl#getCommunicationIdentifier()
		 * @generated
		 */
		EClass COMMUNICATION_IDENTIFIER = eINSTANCE.getCommunicationIdentifier();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.core.impl.IdentifierImpl <em>Identifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.core.impl.IdentifierImpl
		 * @see de.uka.ipd.sdq.capra.core.impl.CorePackageImpl#getIdentifier()
		 * @generated
		 */
		EClass IDENTIFIER = eINSTANCE.getIdentifier();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IDENTIFIER__NAME = eINSTANCE.getIdentifier_Name();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.core.impl.DemandActionImpl <em>Demand Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.core.impl.DemandActionImpl
		 * @see de.uka.ipd.sdq.capra.core.impl.CorePackageImpl#getDemandAction()
		 * @generated
		 */
		EClass DEMAND_ACTION = eINSTANCE.getDemandAction();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEMAND_ACTION__IDENTIFIER = eINSTANCE.getDemandAction_Identifier();

		/**
		 * The meta object literal for the '<em><b>Resource Usage</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEMAND_ACTION__RESOURCE_USAGE = eINSTANCE.getDemandAction_ResourceUsage();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.core.impl.DemandIdentifierImpl <em>Demand Identifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.core.impl.DemandIdentifierImpl
		 * @see de.uka.ipd.sdq.capra.core.impl.CorePackageImpl#getDemandIdentifier()
		 * @generated
		 */
		EClass DEMAND_IDENTIFIER = eINSTANCE.getDemandIdentifier();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.core.impl.AbstractResourceUsageImpl <em>Abstract Resource Usage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.core.impl.AbstractResourceUsageImpl
		 * @see de.uka.ipd.sdq.capra.core.impl.CorePackageImpl#getAbstractResourceUsage()
		 * @generated
		 */
		EClass ABSTRACT_RESOURCE_USAGE = eINSTANCE.getAbstractResourceUsage();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.core.impl.SuccessfulTerminationImpl <em>Successful Termination</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.core.impl.SuccessfulTerminationImpl
		 * @see de.uka.ipd.sdq.capra.core.impl.CorePackageImpl#getSuccessfulTermination()
		 * @generated
		 */
		EClass SUCCESSFUL_TERMINATION = eINSTANCE.getSuccessfulTermination();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.core.impl.ProbabilisticPrefixImpl <em>Probabilistic Prefix</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.core.impl.ProbabilisticPrefixImpl
		 * @see de.uka.ipd.sdq.capra.core.impl.CorePackageImpl#getProbabilisticPrefix()
		 * @generated
		 */
		EClass PROBABILISTIC_PREFIX = eINSTANCE.getProbabilisticPrefix();

		/**
		 * The meta object literal for the '<em><b>Action</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROBABILISTIC_PREFIX__ACTION = eINSTANCE.getProbabilisticPrefix_Action();

		/**
		 * The meta object literal for the '<em><b>Target Options</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROBABILISTIC_PREFIX__TARGET_OPTIONS = eINSTANCE.getProbabilisticPrefix_TargetOptions();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.core.impl.InternalSelectorImpl <em>Internal Selector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.core.impl.InternalSelectorImpl
		 * @see de.uka.ipd.sdq.capra.core.impl.CorePackageImpl#getInternalSelector()
		 * @generated
		 */
		EClass INTERNAL_SELECTOR = eINSTANCE.getInternalSelector();

		/**
		 * The meta object literal for the '<em><b>Probability</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERNAL_SELECTOR__PROBABILITY = eINSTANCE.getInternalSelector_Probability();

		/**
		 * The meta object literal for the '<em><b>Process</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference INTERNAL_SELECTOR__PROCESS = eINSTANCE.getInternalSelector_Process();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.core.impl.ChoiceImpl <em>Choice</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.core.impl.ChoiceImpl
		 * @see de.uka.ipd.sdq.capra.core.impl.CorePackageImpl#getChoice()
		 * @generated
		 */
		EClass CHOICE = eINSTANCE.getChoice();

		/**
		 * The meta object literal for the '<em><b>Options</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHOICE__OPTIONS = eINSTANCE.getChoice_Options();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.core.impl.ExternalSelectorImpl <em>External Selector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.core.impl.ExternalSelectorImpl
		 * @see de.uka.ipd.sdq.capra.core.impl.CorePackageImpl#getExternalSelector()
		 * @generated
		 */
		EClass EXTERNAL_SELECTOR = eINSTANCE.getExternalSelector();

		/**
		 * The meta object literal for the '<em><b>Input</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTERNAL_SELECTOR__INPUT = eINSTANCE.getExternalSelector_Input();

		/**
		 * The meta object literal for the '<em><b>Target Process</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTERNAL_SELECTOR__TARGET_PROCESS = eINSTANCE.getExternalSelector_TargetProcess();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.core.impl.InputEventActionImpl <em>Input Event Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.core.impl.InputEventActionImpl
		 * @see de.uka.ipd.sdq.capra.core.impl.CorePackageImpl#getInputEventAction()
		 * @generated
		 */
		EClass INPUT_EVENT_ACTION = eINSTANCE.getInputEventAction();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.core.impl.OutputEventActionImpl <em>Output Event Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.core.impl.OutputEventActionImpl
		 * @see de.uka.ipd.sdq.capra.core.impl.CorePackageImpl#getOutputEventAction()
		 * @generated
		 */
		EClass OUTPUT_EVENT_ACTION = eINSTANCE.getOutputEventAction();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.core.impl.CommunicationEventActionImpl <em>Communication Event Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.core.impl.CommunicationEventActionImpl
		 * @see de.uka.ipd.sdq.capra.core.impl.CorePackageImpl#getCommunicationEventAction()
		 * @generated
		 */
		EClass COMMUNICATION_EVENT_ACTION = eINSTANCE.getCommunicationEventAction();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.core.impl.BoundedLoopImpl <em>Bounded Loop</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.core.impl.BoundedLoopImpl
		 * @see de.uka.ipd.sdq.capra.core.impl.CorePackageImpl#getBoundedLoop()
		 * @generated
		 */
		EClass BOUNDED_LOOP = eINSTANCE.getBoundedLoop();

		/**
		 * The meta object literal for the '<em><b>Repeated Process</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOUNDED_LOOP__REPEATED_PROCESS = eINSTANCE.getBoundedLoop_RepeatedProcess();

		/**
		 * The meta object literal for the '<em><b>Target Process</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOUNDED_LOOP__TARGET_PROCESS = eINSTANCE.getBoundedLoop_TargetProcess();

		/**
		 * The meta object literal for the '<em><b>Number Of Iterations</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BOUNDED_LOOP__NUMBER_OF_ITERATIONS = eINSTANCE.getBoundedLoop_NumberOfIterations();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.core.impl.ParallelCompositionImpl <em>Parallel Composition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.core.impl.ParallelCompositionImpl
		 * @see de.uka.ipd.sdq.capra.core.impl.CorePackageImpl#getParallelComposition()
		 * @generated
		 */
		EClass PARALLEL_COMPOSITION = eINSTANCE.getParallelComposition();

		/**
		 * The meta object literal for the '<em><b>Parallel Processes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARALLEL_COMPOSITION__PARALLEL_PROCESSES = eINSTANCE.getParallelComposition_ParallelProcesses();

		/**
		 * The meta object literal for the '<em><b>Target Process</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARALLEL_COMPOSITION__TARGET_PROCESS = eINSTANCE.getParallelComposition_TargetProcess();

		/**
		 * The meta object literal for the '<em><b>Is Synchronised</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARALLEL_COMPOSITION__IS_SYNCHRONISED = eINSTANCE.getParallelComposition_IsSynchronised();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.core.impl.RestrictionImpl <em>Restriction</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.core.impl.RestrictionImpl
		 * @see de.uka.ipd.sdq.capra.core.impl.CorePackageImpl#getRestriction()
		 * @generated
		 */
		EClass RESTRICTION = eINSTANCE.getRestriction();

		/**
		 * The meta object literal for the '<em><b>Restricted Process</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESTRICTION__RESTRICTED_PROCESS = eINSTANCE.getRestriction_RestrictedProcess();

		/**
		 * The meta object literal for the '<em><b>Restricted Identifiers</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESTRICTION__RESTRICTED_IDENTIFIERS = eINSTANCE.getRestriction_RestrictedIdentifiers();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.core.impl.ResourceUsageImpl <em>Resource Usage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.core.impl.ResourceUsageImpl
		 * @see de.uka.ipd.sdq.capra.core.impl.CorePackageImpl#getResourceUsage()
		 * @generated
		 */
		EClass RESOURCE_USAGE = eINSTANCE.getResourceUsage();

		/**
		 * The meta object literal for the '<em><b>Resource</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_USAGE__RESOURCE = eINSTANCE.getResourceUsage_Resource();

		/**
		 * The meta object literal for the '<em><b>Usage Time</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RESOURCE_USAGE__USAGE_TIME = eINSTANCE.getResourceUsage_UsageTime();

		/**
		 * The meta object literal for the '<em><b>Usage Time Specification</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RESOURCE_USAGE__USAGE_TIME_SPECIFICATION = eINSTANCE.getResourceUsage_UsageTimeSpecification();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.core.impl.RenamingImpl <em>Renaming</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.core.impl.RenamingImpl
		 * @see de.uka.ipd.sdq.capra.core.impl.CorePackageImpl#getRenaming()
		 * @generated
		 */
		EClass RENAMING = eINSTANCE.getRenaming();

		/**
		 * The meta object literal for the '<em><b>Renamed Process</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RENAMING__RENAMED_PROCESS = eINSTANCE.getRenaming_RenamedProcess();

		/**
		 * The meta object literal for the '<em><b>Mapping</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RENAMING__MAPPING = eINSTANCE.getRenaming_Mapping();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.core.impl.MappingImpl <em>Mapping</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.core.impl.MappingImpl
		 * @see de.uka.ipd.sdq.capra.core.impl.CorePackageImpl#getMapping()
		 * @generated
		 */
		EClass MAPPING = eINSTANCE.getMapping();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING__SOURCE = eINSTANCE.getMapping_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MAPPING__TARGET = eINSTANCE.getMapping_Target();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.core.impl.SilentIdentifierImpl <em>Silent Identifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.core.impl.SilentIdentifierImpl
		 * @see de.uka.ipd.sdq.capra.core.impl.CorePackageImpl#getSilentIdentifier()
		 * @generated
		 */
		EClass SILENT_IDENTIFIER = eINSTANCE.getSilentIdentifier();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.core.impl.ProcessVariableUsageImpl <em>Process Variable Usage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.core.impl.ProcessVariableUsageImpl
		 * @see de.uka.ipd.sdq.capra.core.impl.CorePackageImpl#getProcessVariableUsage()
		 * @generated
		 */
		EClass PROCESS_VARIABLE_USAGE = eINSTANCE.getProcessVariableUsage();

		/**
		 * The meta object literal for the '<em><b>Process Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PROCESS_VARIABLE_USAGE__PROCESS_VARIABLE = eINSTANCE.getProcessVariableUsage_ProcessVariable();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.capra.core.impl.VariableResourceUsageImpl <em>Variable Resource Usage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.capra.core.impl.VariableResourceUsageImpl
		 * @see de.uka.ipd.sdq.capra.core.impl.CorePackageImpl#getVariableResourceUsage()
		 * @generated
		 */
		EClass VARIABLE_RESOURCE_USAGE = eINSTANCE.getVariableResourceUsage();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_RESOURCE_USAGE__NAME = eINSTANCE.getVariableResourceUsage_Name();

	}

} //CorePackage
