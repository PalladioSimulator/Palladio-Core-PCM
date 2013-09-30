/**
 * Copyright 2006, SDQ Group, University Karlsruhe (TH)
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.aggregatedUsageContext;

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
 * @see de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedUsageContextFactory
 * @model kind="package"
 * @generated
 */
public interface AggregatedUsageContextPackage extends EPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2006, SDQ Group, University Karlsruhe (TH)";

	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "aggregatedUsageContext";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///context/aggregatedUsageContext.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "context.aggregatedUsageContext";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AggregatedUsageContextPackage eINSTANCE = de.uka.ipd.sdq.context.aggregatedUsageContext.impl.AggregatedUsageContextPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.context.aggregatedUsageContext.impl.ServiceExecutionContextImpl <em>Service Execution Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.context.aggregatedUsageContext.impl.ServiceExecutionContextImpl
	 * @see de.uka.ipd.sdq.context.aggregatedUsageContext.impl.AggregatedUsageContextPackageImpl#getServiceExecutionContext()
	 * @generated
	 */
	int SERVICE_EXECUTION_CONTEXT = 0;

	/**
	 * The feature id for the '<em><b>Global Execution Frequency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_EXECUTION_CONTEXT__GLOBAL_EXECUTION_FREQUENCY = 0;

	/**
	 * The feature id for the '<em><b>Allocation Context Service Execution Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_EXECUTION_CONTEXT__ALLOCATION_CONTEXT_SERVICE_EXECUTION_CONTEXT = 1;

	/**
	 * The feature id for the '<em><b>Described SEFF Service Execution Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_EXECUTION_CONTEXT__DESCRIBED_SEFF_SERVICE_EXECUTION_CONTEXT = 2;

	/**
	 * The feature id for the '<em><b>Aggregated Resource Demands Service Execution Context</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_EXECUTION_CONTEXT__AGGREGATED_RESOURCE_DEMANDS_SERVICE_EXECUTION_CONTEXT = 3;

	/**
	 * The feature id for the '<em><b>Usage Scenario Service Execution Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_EXECUTION_CONTEXT__USAGE_SCENARIO_SERVICE_EXECUTION_CONTEXT = 4;

	/**
	 * The feature id for the '<em><b>Sent Aggregated Communications Service Execution Context</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_EXECUTION_CONTEXT__SENT_AGGREGATED_COMMUNICATIONS_SERVICE_EXECUTION_CONTEXT = 5;

	/**
	 * The feature id for the '<em><b>Received Aggregated Communication Aggregated Communication</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_EXECUTION_CONTEXT__RECEIVED_AGGREGATED_COMMUNICATION_AGGREGATED_COMMUNICATION = 6;

	/**
	 * The number of structural features of the '<em>Service Execution Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVICE_EXECUTION_CONTEXT_FEATURE_COUNT = 7;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.context.aggregatedUsageContext.impl.AggregatedResourceDemandImpl <em>Aggregated Resource Demand</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.context.aggregatedUsageContext.impl.AggregatedResourceDemandImpl
	 * @see de.uka.ipd.sdq.context.aggregatedUsageContext.impl.AggregatedUsageContextPackageImpl#getAggregatedResourceDemand()
	 * @generated
	 */
	int AGGREGATED_RESOURCE_DEMAND = 1;

	/**
	 * The feature id for the '<em><b>Aggregated Resource Demand</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_RESOURCE_DEMAND__AGGREGATED_RESOURCE_DEMAND = 0;

	/**
	 * The feature id for the '<em><b>Resource Type Aggregated Resource Demand</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_RESOURCE_DEMAND__RESOURCE_TYPE_AGGREGATED_RESOURCE_DEMAND = 1;

	/**
	 * The number of structural features of the '<em>Aggregated Resource Demand</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_RESOURCE_DEMAND_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.context.aggregatedUsageContext.impl.AggregatedCommunicationImpl <em>Aggregated Communication</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.context.aggregatedUsageContext.impl.AggregatedCommunicationImpl
	 * @see de.uka.ipd.sdq.context.aggregatedUsageContext.impl.AggregatedUsageContextPackageImpl#getAggregatedCommunication()
	 * @generated
	 */
	int AGGREGATED_COMMUNICATION = 2;

	/**
	 * The feature id for the '<em><b>Average Message Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_COMMUNICATION__AVERAGE_MESSAGE_SIZE = 0;

	/**
	 * The feature id for the '<em><b>Average Message Frequency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_COMMUNICATION__AVERAGE_MESSAGE_FREQUENCY = 1;

	/**
	 * The feature id for the '<em><b>Receiver Aggregated Communication</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_COMMUNICATION__RECEIVER_AGGREGATED_COMMUNICATION = 2;

	/**
	 * The feature id for the '<em><b>Used Communication Link Resource Specification Aggregated Communication</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_COMMUNICATION__USED_COMMUNICATION_LINK_RESOURCE_SPECIFICATION_AGGREGATED_COMMUNICATION = 3;

	/**
	 * The number of structural features of the '<em>Aggregated Communication</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int AGGREGATED_COMMUNICATION_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.context.aggregatedUsageContext.impl.ComputedAggregatedUsageImpl <em>Computed Aggregated Usage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.context.aggregatedUsageContext.impl.ComputedAggregatedUsageImpl
	 * @see de.uka.ipd.sdq.context.aggregatedUsageContext.impl.AggregatedUsageContextPackageImpl#getComputedAggregatedUsage()
	 * @generated
	 */
	int COMPUTED_AGGREGATED_USAGE = 3;

	/**
	 * The feature id for the '<em><b>Service Execution Contexts Computed Aggregated Usage</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTED_AGGREGATED_USAGE__SERVICE_EXECUTION_CONTEXTS_COMPUTED_AGGREGATED_USAGE = 0;

	/**
	 * The number of structural features of the '<em>Computed Aggregated Usage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTED_AGGREGATED_USAGE_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.context.aggregatedUsageContext.ServiceExecutionContext <em>Service Execution Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Service Execution Context</em>'.
	 * @see de.uka.ipd.sdq.context.aggregatedUsageContext.ServiceExecutionContext
	 * @generated
	 */
	EClass getServiceExecutionContext();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.context.aggregatedUsageContext.ServiceExecutionContext#getGlobalExecutionFrequency <em>Global Execution Frequency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Global Execution Frequency</em>'.
	 * @see de.uka.ipd.sdq.context.aggregatedUsageContext.ServiceExecutionContext#getGlobalExecutionFrequency()
	 * @see #getServiceExecutionContext()
	 * @generated
	 */
	EAttribute getServiceExecutionContext_GlobalExecutionFrequency();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.context.aggregatedUsageContext.ServiceExecutionContext#getAllocationContext_ServiceExecutionContext <em>Allocation Context Service Execution Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Allocation Context Service Execution Context</em>'.
	 * @see de.uka.ipd.sdq.context.aggregatedUsageContext.ServiceExecutionContext#getAllocationContext_ServiceExecutionContext()
	 * @see #getServiceExecutionContext()
	 * @generated
	 */
	EReference getServiceExecutionContext_AllocationContext_ServiceExecutionContext();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.context.aggregatedUsageContext.ServiceExecutionContext#getDescribedSEFF_ServiceExecutionContext <em>Described SEFF Service Execution Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Described SEFF Service Execution Context</em>'.
	 * @see de.uka.ipd.sdq.context.aggregatedUsageContext.ServiceExecutionContext#getDescribedSEFF_ServiceExecutionContext()
	 * @see #getServiceExecutionContext()
	 * @generated
	 */
	EReference getServiceExecutionContext_DescribedSEFF_ServiceExecutionContext();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.context.aggregatedUsageContext.ServiceExecutionContext#getAggregatedResourceDemands_ServiceExecutionContext <em>Aggregated Resource Demands Service Execution Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Aggregated Resource Demands Service Execution Context</em>'.
	 * @see de.uka.ipd.sdq.context.aggregatedUsageContext.ServiceExecutionContext#getAggregatedResourceDemands_ServiceExecutionContext()
	 * @see #getServiceExecutionContext()
	 * @generated
	 */
	EReference getServiceExecutionContext_AggregatedResourceDemands_ServiceExecutionContext();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.context.aggregatedUsageContext.ServiceExecutionContext#getUsageScenario_ServiceExecutionContext <em>Usage Scenario Service Execution Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Usage Scenario Service Execution Context</em>'.
	 * @see de.uka.ipd.sdq.context.aggregatedUsageContext.ServiceExecutionContext#getUsageScenario_ServiceExecutionContext()
	 * @see #getServiceExecutionContext()
	 * @generated
	 */
	EReference getServiceExecutionContext_UsageScenario_ServiceExecutionContext();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.context.aggregatedUsageContext.ServiceExecutionContext#getSentAggregatedCommunications_ServiceExecutionContext <em>Sent Aggregated Communications Service Execution Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Sent Aggregated Communications Service Execution Context</em>'.
	 * @see de.uka.ipd.sdq.context.aggregatedUsageContext.ServiceExecutionContext#getSentAggregatedCommunications_ServiceExecutionContext()
	 * @see #getServiceExecutionContext()
	 * @generated
	 */
	EReference getServiceExecutionContext_SentAggregatedCommunications_ServiceExecutionContext();

	/**
	 * Returns the meta object for the reference list '{@link de.uka.ipd.sdq.context.aggregatedUsageContext.ServiceExecutionContext#getReceivedAggregatedCommunication_AggregatedCommunication <em>Received Aggregated Communication Aggregated Communication</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Received Aggregated Communication Aggregated Communication</em>'.
	 * @see de.uka.ipd.sdq.context.aggregatedUsageContext.ServiceExecutionContext#getReceivedAggregatedCommunication_AggregatedCommunication()
	 * @see #getServiceExecutionContext()
	 * @generated
	 */
	EReference getServiceExecutionContext_ReceivedAggregatedCommunication_AggregatedCommunication();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedResourceDemand <em>Aggregated Resource Demand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Aggregated Resource Demand</em>'.
	 * @see de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedResourceDemand
	 * @generated
	 */
	EClass getAggregatedResourceDemand();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedResourceDemand#getAggregatedResourceDemand <em>Aggregated Resource Demand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Aggregated Resource Demand</em>'.
	 * @see de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedResourceDemand#getAggregatedResourceDemand()
	 * @see #getAggregatedResourceDemand()
	 * @generated
	 */
	EAttribute getAggregatedResourceDemand_AggregatedResourceDemand();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedResourceDemand#getResourceType_AggregatedResourceDemand <em>Resource Type Aggregated Resource Demand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Resource Type Aggregated Resource Demand</em>'.
	 * @see de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedResourceDemand#getResourceType_AggregatedResourceDemand()
	 * @see #getAggregatedResourceDemand()
	 * @generated
	 */
	EReference getAggregatedResourceDemand_ResourceType_AggregatedResourceDemand();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedCommunication <em>Aggregated Communication</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Aggregated Communication</em>'.
	 * @see de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedCommunication
	 * @generated
	 */
	EClass getAggregatedCommunication();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedCommunication#getAverageMessageSize <em>Average Message Size</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Average Message Size</em>'.
	 * @see de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedCommunication#getAverageMessageSize()
	 * @see #getAggregatedCommunication()
	 * @generated
	 */
	EAttribute getAggregatedCommunication_AverageMessageSize();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedCommunication#getAverageMessageFrequency <em>Average Message Frequency</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Average Message Frequency</em>'.
	 * @see de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedCommunication#getAverageMessageFrequency()
	 * @see #getAggregatedCommunication()
	 * @generated
	 */
	EAttribute getAggregatedCommunication_AverageMessageFrequency();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedCommunication#getReceiver_AggregatedCommunication <em>Receiver Aggregated Communication</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Receiver Aggregated Communication</em>'.
	 * @see de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedCommunication#getReceiver_AggregatedCommunication()
	 * @see #getAggregatedCommunication()
	 * @generated
	 */
	EReference getAggregatedCommunication_Receiver_AggregatedCommunication();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedCommunication#getUsedCommunicationLinkResourceSpecification_AggregatedCommunication <em>Used Communication Link Resource Specification Aggregated Communication</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Used Communication Link Resource Specification Aggregated Communication</em>'.
	 * @see de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedCommunication#getUsedCommunicationLinkResourceSpecification_AggregatedCommunication()
	 * @see #getAggregatedCommunication()
	 * @generated
	 */
	EReference getAggregatedCommunication_UsedCommunicationLinkResourceSpecification_AggregatedCommunication();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.context.aggregatedUsageContext.ComputedAggregatedUsage <em>Computed Aggregated Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Computed Aggregated Usage</em>'.
	 * @see de.uka.ipd.sdq.context.aggregatedUsageContext.ComputedAggregatedUsage
	 * @generated
	 */
	EClass getComputedAggregatedUsage();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.context.aggregatedUsageContext.ComputedAggregatedUsage#getServiceExecutionContexts_ComputedAggregatedUsage <em>Service Execution Contexts Computed Aggregated Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Service Execution Contexts Computed Aggregated Usage</em>'.
	 * @see de.uka.ipd.sdq.context.aggregatedUsageContext.ComputedAggregatedUsage#getServiceExecutionContexts_ComputedAggregatedUsage()
	 * @see #getComputedAggregatedUsage()
	 * @generated
	 */
	EReference getComputedAggregatedUsage_ServiceExecutionContexts_ComputedAggregatedUsage();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AggregatedUsageContextFactory getAggregatedUsageContextFactory();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.context.aggregatedUsageContext.impl.ServiceExecutionContextImpl <em>Service Execution Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.context.aggregatedUsageContext.impl.ServiceExecutionContextImpl
		 * @see de.uka.ipd.sdq.context.aggregatedUsageContext.impl.AggregatedUsageContextPackageImpl#getServiceExecutionContext()
		 * @generated
		 */
		EClass SERVICE_EXECUTION_CONTEXT = eINSTANCE.getServiceExecutionContext();

		/**
		 * The meta object literal for the '<em><b>Global Execution Frequency</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SERVICE_EXECUTION_CONTEXT__GLOBAL_EXECUTION_FREQUENCY = eINSTANCE.getServiceExecutionContext_GlobalExecutionFrequency();

		/**
		 * The meta object literal for the '<em><b>Allocation Context Service Execution Context</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_EXECUTION_CONTEXT__ALLOCATION_CONTEXT_SERVICE_EXECUTION_CONTEXT = eINSTANCE.getServiceExecutionContext_AllocationContext_ServiceExecutionContext();

		/**
		 * The meta object literal for the '<em><b>Described SEFF Service Execution Context</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_EXECUTION_CONTEXT__DESCRIBED_SEFF_SERVICE_EXECUTION_CONTEXT = eINSTANCE.getServiceExecutionContext_DescribedSEFF_ServiceExecutionContext();

		/**
		 * The meta object literal for the '<em><b>Aggregated Resource Demands Service Execution Context</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_EXECUTION_CONTEXT__AGGREGATED_RESOURCE_DEMANDS_SERVICE_EXECUTION_CONTEXT = eINSTANCE.getServiceExecutionContext_AggregatedResourceDemands_ServiceExecutionContext();

		/**
		 * The meta object literal for the '<em><b>Usage Scenario Service Execution Context</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_EXECUTION_CONTEXT__USAGE_SCENARIO_SERVICE_EXECUTION_CONTEXT = eINSTANCE.getServiceExecutionContext_UsageScenario_ServiceExecutionContext();

		/**
		 * The meta object literal for the '<em><b>Sent Aggregated Communications Service Execution Context</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_EXECUTION_CONTEXT__SENT_AGGREGATED_COMMUNICATIONS_SERVICE_EXECUTION_CONTEXT = eINSTANCE.getServiceExecutionContext_SentAggregatedCommunications_ServiceExecutionContext();

		/**
		 * The meta object literal for the '<em><b>Received Aggregated Communication Aggregated Communication</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SERVICE_EXECUTION_CONTEXT__RECEIVED_AGGREGATED_COMMUNICATION_AGGREGATED_COMMUNICATION = eINSTANCE.getServiceExecutionContext_ReceivedAggregatedCommunication_AggregatedCommunication();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.context.aggregatedUsageContext.impl.AggregatedResourceDemandImpl <em>Aggregated Resource Demand</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.context.aggregatedUsageContext.impl.AggregatedResourceDemandImpl
		 * @see de.uka.ipd.sdq.context.aggregatedUsageContext.impl.AggregatedUsageContextPackageImpl#getAggregatedResourceDemand()
		 * @generated
		 */
		EClass AGGREGATED_RESOURCE_DEMAND = eINSTANCE.getAggregatedResourceDemand();

		/**
		 * The meta object literal for the '<em><b>Aggregated Resource Demand</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGGREGATED_RESOURCE_DEMAND__AGGREGATED_RESOURCE_DEMAND = eINSTANCE.getAggregatedResourceDemand_AggregatedResourceDemand();

		/**
		 * The meta object literal for the '<em><b>Resource Type Aggregated Resource Demand</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AGGREGATED_RESOURCE_DEMAND__RESOURCE_TYPE_AGGREGATED_RESOURCE_DEMAND = eINSTANCE.getAggregatedResourceDemand_ResourceType_AggregatedResourceDemand();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.context.aggregatedUsageContext.impl.AggregatedCommunicationImpl <em>Aggregated Communication</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.context.aggregatedUsageContext.impl.AggregatedCommunicationImpl
		 * @see de.uka.ipd.sdq.context.aggregatedUsageContext.impl.AggregatedUsageContextPackageImpl#getAggregatedCommunication()
		 * @generated
		 */
		EClass AGGREGATED_COMMUNICATION = eINSTANCE.getAggregatedCommunication();

		/**
		 * The meta object literal for the '<em><b>Average Message Size</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGGREGATED_COMMUNICATION__AVERAGE_MESSAGE_SIZE = eINSTANCE.getAggregatedCommunication_AverageMessageSize();

		/**
		 * The meta object literal for the '<em><b>Average Message Frequency</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute AGGREGATED_COMMUNICATION__AVERAGE_MESSAGE_FREQUENCY = eINSTANCE.getAggregatedCommunication_AverageMessageFrequency();

		/**
		 * The meta object literal for the '<em><b>Receiver Aggregated Communication</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AGGREGATED_COMMUNICATION__RECEIVER_AGGREGATED_COMMUNICATION = eINSTANCE.getAggregatedCommunication_Receiver_AggregatedCommunication();

		/**
		 * The meta object literal for the '<em><b>Used Communication Link Resource Specification Aggregated Communication</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference AGGREGATED_COMMUNICATION__USED_COMMUNICATION_LINK_RESOURCE_SPECIFICATION_AGGREGATED_COMMUNICATION = eINSTANCE.getAggregatedCommunication_UsedCommunicationLinkResourceSpecification_AggregatedCommunication();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.context.aggregatedUsageContext.impl.ComputedAggregatedUsageImpl <em>Computed Aggregated Usage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.context.aggregatedUsageContext.impl.ComputedAggregatedUsageImpl
		 * @see de.uka.ipd.sdq.context.aggregatedUsageContext.impl.AggregatedUsageContextPackageImpl#getComputedAggregatedUsage()
		 * @generated
		 */
		EClass COMPUTED_AGGREGATED_USAGE = eINSTANCE.getComputedAggregatedUsage();

		/**
		 * The meta object literal for the '<em><b>Service Execution Contexts Computed Aggregated Usage</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPUTED_AGGREGATED_USAGE__SERVICE_EXECUTION_CONTEXTS_COMPUTED_AGGREGATED_USAGE = eINSTANCE.getComputedAggregatedUsage_ServiceExecutionContexts_ComputedAggregatedUsage();

	}

} //AggregatedUsageContextPackage
