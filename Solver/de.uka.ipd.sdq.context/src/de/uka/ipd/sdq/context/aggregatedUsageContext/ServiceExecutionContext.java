/**
 * Copyright 2006, SDQ Group, University Karlsruhe (TH)
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.aggregatedUsageContext;

import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Service Execution Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Stores context information for the execution of a service. The information is aggregated on the level of AssembyContexts and aggregates the calls to this service from different other components. 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.context.aggregatedUsageContext.ServiceExecutionContext#getGlobalExecutionFrequency <em>Global Execution Frequency</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.context.aggregatedUsageContext.ServiceExecutionContext#getAllocationContext_ServiceExecutionContext <em>Allocation Context Service Execution Context</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.context.aggregatedUsageContext.ServiceExecutionContext#getDescribedSEFF_ServiceExecutionContext <em>Described SEFF Service Execution Context</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.context.aggregatedUsageContext.ServiceExecutionContext#getAggregatedResourceDemands_ServiceExecutionContext <em>Aggregated Resource Demands Service Execution Context</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.context.aggregatedUsageContext.ServiceExecutionContext#getUsageScenario_ServiceExecutionContext <em>Usage Scenario Service Execution Context</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.context.aggregatedUsageContext.ServiceExecutionContext#getSentAggregatedCommunications_ServiceExecutionContext <em>Sent Aggregated Communications Service Execution Context</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.context.aggregatedUsageContext.ServiceExecutionContext#getReceivedAggregatedCommunication_AggregatedCommunication <em>Received Aggregated Communication Aggregated Communication</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedUsageContextPackage#getServiceExecutionContext()
 * @model
 * @generated
 */
public interface ServiceExecutionContext extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2006, SDQ Group, University Karlsruhe (TH)";

	/**
	 * Returns the value of the '<em><b>Global Execution Frequency</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * Average frequency of executing this service when executing a UsageScenario. 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Global Execution Frequency</em>' attribute.
	 * @see #setGlobalExecutionFrequency(double)
	 * @see de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedUsageContextPackage#getServiceExecutionContext_GlobalExecutionFrequency()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	double getGlobalExecutionFrequency();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.context.aggregatedUsageContext.ServiceExecutionContext#getGlobalExecutionFrequency <em>Global Execution Frequency</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Global Execution Frequency</em>' attribute.
	 * @see #getGlobalExecutionFrequency()
	 * @generated
	 */
	void setGlobalExecutionFrequency(double value);

	/**
	 * Returns the value of the '<em><b>Allocation Context Service Execution Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Allocation Context Service Execution Context</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allocation Context Service Execution Context</em>' reference.
	 * @see #setAllocationContext_ServiceExecutionContext(AllocationContext)
	 * @see de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedUsageContextPackage#getServiceExecutionContext_AllocationContext_ServiceExecutionContext()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	AllocationContext getAllocationContext_ServiceExecutionContext();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.context.aggregatedUsageContext.ServiceExecutionContext#getAllocationContext_ServiceExecutionContext <em>Allocation Context Service Execution Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Allocation Context Service Execution Context</em>' reference.
	 * @see #getAllocationContext_ServiceExecutionContext()
	 * @generated
	 */
	void setAllocationContext_ServiceExecutionContext(AllocationContext value);

	/**
	 * Returns the value of the '<em><b>Described SEFF Service Execution Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Described SEFF Service Execution Context</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Described SEFF Service Execution Context</em>' reference.
	 * @see #setDescribedSEFF_ServiceExecutionContext(ResourceDemandingSEFF)
	 * @see de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedUsageContextPackage#getServiceExecutionContext_DescribedSEFF_ServiceExecutionContext()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ResourceDemandingSEFF getDescribedSEFF_ServiceExecutionContext();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.context.aggregatedUsageContext.ServiceExecutionContext#getDescribedSEFF_ServiceExecutionContext <em>Described SEFF Service Execution Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Described SEFF Service Execution Context</em>' reference.
	 * @see #getDescribedSEFF_ServiceExecutionContext()
	 * @generated
	 */
	void setDescribedSEFF_ServiceExecutionContext(ResourceDemandingSEFF value);

	/**
	 * Returns the value of the '<em><b>Aggregated Resource Demands Service Execution Context</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedResourceDemand}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Aggregated Resource Demands Service Execution Context</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Aggregated Resource Demands Service Execution Context</em>' containment reference list.
	 * @see de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedUsageContextPackage#getServiceExecutionContext_AggregatedResourceDemands_ServiceExecutionContext()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<AggregatedResourceDemand> getAggregatedResourceDemands_ServiceExecutionContext();

	/**
	 * Returns the value of the '<em><b>Usage Scenario Service Execution Context</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Usage Scenario Service Execution Context</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Usage Scenario Service Execution Context</em>' reference.
	 * @see #setUsageScenario_ServiceExecutionContext(UsageScenario)
	 * @see de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedUsageContextPackage#getServiceExecutionContext_UsageScenario_ServiceExecutionContext()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	UsageScenario getUsageScenario_ServiceExecutionContext();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.context.aggregatedUsageContext.ServiceExecutionContext#getUsageScenario_ServiceExecutionContext <em>Usage Scenario Service Execution Context</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Usage Scenario Service Execution Context</em>' reference.
	 * @see #getUsageScenario_ServiceExecutionContext()
	 * @generated
	 */
	void setUsageScenario_ServiceExecutionContext(UsageScenario value);

	/**
	 * Returns the value of the '<em><b>Sent Aggregated Communications Service Execution Context</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedCommunication}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The AggregatedCommunication in which this service is the sender. 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Sent Aggregated Communications Service Execution Context</em>' containment reference list.
	 * @see de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedUsageContextPackage#getServiceExecutionContext_SentAggregatedCommunications_ServiceExecutionContext()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<AggregatedCommunication> getSentAggregatedCommunications_ServiceExecutionContext();

	/**
	 * Returns the value of the '<em><b>Received Aggregated Communication Aggregated Communication</b></em>' reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedCommunication}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedCommunication#getReceiver_AggregatedCommunication <em>Receiver Aggregated Communication</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * The AggregatedCommunication in which this service is the receiver. 
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Received Aggregated Communication Aggregated Communication</em>' reference list.
	 * @see de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedUsageContextPackage#getServiceExecutionContext_ReceivedAggregatedCommunication_AggregatedCommunication()
	 * @see de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedCommunication#getReceiver_AggregatedCommunication
	 * @model opposite="receiver_AggregatedCommunication" ordered="false"
	 * @generated
	 */
	EList<AggregatedCommunication> getReceivedAggregatedCommunication_AggregatedCommunication();

} // ServiceExecutionContext
