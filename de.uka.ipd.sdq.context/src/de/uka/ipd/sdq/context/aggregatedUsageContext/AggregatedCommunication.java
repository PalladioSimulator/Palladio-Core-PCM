/**
 * Copyright 2006, SDQ Group, University Karlsruhe (TH)
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.aggregatedUsageContext;

import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.pcm.resourceenvironment.CommunicationLinkResourceSpecification;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Aggregated Communication</b></em>'. <!-- end-user-doc -->
 *
 * <!-- begin-model-doc --> AggregatedCommunication holds the communication information for the
 * communication of two services, where the owning service is the sender and the referenced
 * receiver_AggregatedCommunication is the receiver.
 * 
 * If two services A and B communicate in different roles with each other, i.e. sometimes A calls B,
 * sometimes B calls A, there will be two AggregatedCommunication, one with A as the sender, one
 * with B as the sender. <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedCommunication#getAverageMessageSize
 * <em>Average Message Size</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedCommunication#getAverageMessageFrequency
 * <em>Average Message Frequency</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedCommunication#getReceiver_AggregatedCommunication
 * <em>Receiver Aggregated Communication</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedCommunication#getUsedCommunicationLinkResourceSpecification_AggregatedCommunication
 * <em>Used Communication Link Resource Specification Aggregated Communication</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedUsageContextPackage#getAggregatedCommunication()
 * @model
 * @generated
 */
public interface AggregatedCommunication extends EObject {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String copyright = "Copyright 2006, SDQ Group, University Karlsruhe (TH)";

    /**
     * Returns the value of the '<em><b>Average Message Size</b></em>' attribute. <!--
     * begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Average Message Size</em>' attribute isn't clear, there really
     * should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Average Message Size</em>' attribute.
     * @see #setAverageMessageSize(double)
     * @see de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedUsageContextPackage#getAggregatedCommunication_AverageMessageSize()
     * @model required="true" ordered="false"
     * @generated
     */
    double getAverageMessageSize();

    /**
     * Sets the value of the '
     * {@link de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedCommunication#getAverageMessageSize
     * <em>Average Message Size</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Average Message Size</em>' attribute.
     * @see #getAverageMessageSize()
     * @generated
     */
    void setAverageMessageSize(double value);

    /**
     * Returns the value of the '<em><b>Average Message Frequency</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> Average message frequency
     * of this communication when executing a UsageScenario. <!-- end-model-doc -->
     * 
     * @return the value of the '<em>Average Message Frequency</em>' attribute.
     * @see #setAverageMessageFrequency(double)
     * @see de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedUsageContextPackage#getAggregatedCommunication_AverageMessageFrequency()
     * @model required="true" ordered="false"
     * @generated
     */
    double getAverageMessageFrequency();

    /**
     * Sets the value of the '
     * {@link de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedCommunication#getAverageMessageFrequency
     * <em>Average Message Frequency</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Average Message Frequency</em>' attribute.
     * @see #getAverageMessageFrequency()
     * @generated
     */
    void setAverageMessageFrequency(double value);

    /**
     * Returns the value of the '<em><b>Receiver Aggregated Communication</b></em>' reference. It is
     * bidirectional and its opposite is '
     * {@link de.uka.ipd.sdq.context.aggregatedUsageContext.ServiceExecutionContext#getReceivedAggregatedCommunication_AggregatedCommunication
     * <em>Received Aggregated Communication Aggregated Communication</em>}'. <!-- begin-user-doc
     * --> <!-- end-user-doc --> <!-- begin-model-doc --> The receiver of this communication. <!--
     * end-model-doc -->
     * 
     * @return the value of the '<em>Receiver Aggregated Communication</em>' reference.
     * @see #setReceiver_AggregatedCommunication(ServiceExecutionContext)
     * @see de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedUsageContextPackage#getAggregatedCommunication_Receiver_AggregatedCommunication()
     * @see de.uka.ipd.sdq.context.aggregatedUsageContext.ServiceExecutionContext#getReceivedAggregatedCommunication_AggregatedCommunication
     * @model opposite="receivedAggregatedCommunication_AggregatedCommunication" required="true"
     *        ordered="false"
     * @generated
     */
    ServiceExecutionContext getReceiver_AggregatedCommunication();

    /**
     * Sets the value of the '
     * {@link de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedCommunication#getReceiver_AggregatedCommunication
     * <em>Receiver Aggregated Communication</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Receiver Aggregated Communication</em>' reference.
     * @see #getReceiver_AggregatedCommunication()
     * @generated
     */
    void setReceiver_AggregatedCommunication(ServiceExecutionContext value);

    /**
     * Returns the value of the '
     * <em><b>Used Communication Link Resource Specification Aggregated Communication</b></em>'
     * reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '
     * <em>Used Communication Link Resource Specification Aggregated Communication</em>' reference
     * isn't clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc --> <!-- begin-model-doc --> The usedCommunicationLinkResourceSpecification
     * is null if this is a local communication. <!-- end-model-doc -->
     * 
     * @return the value of the '
     *         <em>Used Communication Link Resource Specification Aggregated Communication</em>'
     *         reference.
     * @see #setUsedCommunicationLinkResourceSpecification_AggregatedCommunication(CommunicationLinkResourceSpecification)
     * @see de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedUsageContextPackage#getAggregatedCommunication_UsedCommunicationLinkResourceSpecification_AggregatedCommunication()
     * @model ordered="false"
     * @generated
     */
    CommunicationLinkResourceSpecification getUsedCommunicationLinkResourceSpecification_AggregatedCommunication();

    /**
     * Sets the value of the '
     * {@link de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedCommunication#getUsedCommunicationLinkResourceSpecification_AggregatedCommunication
     * <em>Used Communication Link Resource Specification Aggregated Communication</em>}' reference.
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @param value
     *            the new value of the '
     *            <em>Used Communication Link Resource Specification Aggregated Communication</em>'
     *            reference.
     * @see #getUsedCommunicationLinkResourceSpecification_AggregatedCommunication()
     * @generated
     */
    void setUsedCommunicationLinkResourceSpecification_AggregatedCommunication(
            CommunicationLinkResourceSpecification value);

} // AggregatedCommunication
