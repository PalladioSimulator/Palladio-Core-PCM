/**
 * Copyright 2006, SDQ Group, University Karlsruhe (TH)
 *
 * $Id$
 */
package de.uka.ipd.sdq.context.aggregatedUsageContext;

import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.pcm.resourcetype.ResourceType;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Aggregated Resource Demand</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>
 * {@link de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedResourceDemand#getAggregatedResourceDemand
 * <em>Aggregated Resource Demand</em>}</li>
 * <li>
 * {@link de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedResourceDemand#getResourceType_AggregatedResourceDemand
 * <em>Resource Type Aggregated Resource Demand</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedUsageContextPackage#getAggregatedResourceDemand()
 * @model
 * @generated
 */
public interface AggregatedResourceDemand extends EObject {
    /**
     * <!-- begin-user-doc --> <!-- end-user-doc -->
     * 
     * @generated
     */
    String copyright = "Copyright 2006, SDQ Group, University Karlsruhe (TH)";

    /**
     * Returns the value of the '<em><b>Aggregated Resource Demand</b></em>' attribute. <!--
     * begin-user-doc --> <!-- end-user-doc --> <!-- begin-model-doc --> The aggregated resource
     * demand of this service, where the single resource demands are weighted by their frequency
     * (including the frequency of the service itself) and averaged. <!-- end-model-doc -->
     * 
     * @return the value of the '<em>Aggregated Resource Demand</em>' attribute.
     * @see #setAggregatedResourceDemand(double)
     * @see de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedUsageContextPackage#getAggregatedResourceDemand_AggregatedResourceDemand()
     * @model required="true" ordered="false"
     * @generated
     */
    double getAggregatedResourceDemand();

    /**
     * Sets the value of the '
     * {@link de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedResourceDemand#getAggregatedResourceDemand
     * <em>Aggregated Resource Demand</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
     * -->
     * 
     * @param value
     *            the new value of the '<em>Aggregated Resource Demand</em>' attribute.
     * @see #getAggregatedResourceDemand()
     * @generated
     */
    void setAggregatedResourceDemand(double value);

    /**
     * Returns the value of the '<em><b>Resource Type Aggregated Resource Demand</b></em>'
     * reference. <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Resource Type Aggregated Resource Demand</em>' reference isn't
     * clear, there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * 
     * @return the value of the '<em>Resource Type Aggregated Resource Demand</em>' reference.
     * @see #setResourceType_AggregatedResourceDemand(ResourceType)
     * @see de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedUsageContextPackage#getAggregatedResourceDemand_ResourceType_AggregatedResourceDemand()
     * @model required="true" ordered="false"
     * @generated
     */
    ResourceType getResourceType_AggregatedResourceDemand();

    /**
     * Sets the value of the '
     * {@link de.uka.ipd.sdq.context.aggregatedUsageContext.AggregatedResourceDemand#getResourceType_AggregatedResourceDemand
     * <em>Resource Type Aggregated Resource Demand</em>}' reference. <!-- begin-user-doc --> <!--
     * end-user-doc -->
     * 
     * @param value
     *            the new value of the '<em>Resource Type Aggregated Resource Demand</em>'
     *            reference.
     * @see #getResourceType_AggregatedResourceDemand()
     * @generated
     */
    void setResourceType_AggregatedResourceDemand(ResourceType value);

} // AggregatedResourceDemand
