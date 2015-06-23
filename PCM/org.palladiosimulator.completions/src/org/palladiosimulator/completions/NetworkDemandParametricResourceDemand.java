/**
 * Copyright SDQ, IPD, U Karlsruhe, 2007
 */
package org.palladiosimulator.completions;

import de.uka.ipd.sdq.pcm.resourcetype.CommunicationLinkResourceType;

import de.uka.ipd.sdq.pcm.seff.seff_performance.ParametricResourceDemand;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Network Demand Parametric Resource Demand</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.palladiosimulator.completions.NetworkDemandParametricResourceDemand#getRequiredCommunicationLinkResource_ParametricResourceDemand <em>Required Communication Link Resource Parametric Resource Demand</em>}</li>
 * </ul>
 *
 * @see org.palladiosimulator.completions.CompletionsPackage#getNetworkDemandParametricResourceDemand()
 * @model
 * @generated
 */
public interface NetworkDemandParametricResourceDemand extends EObject, ParametricResourceDemand {
    /**
     * Returns the value of the '<em><b>Required Communication Link Resource Parametric Resource Demand</b></em>' reference.
     * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Required Communication Link Resource Parametric Resource Demand</em>' reference isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
     * @return the value of the '<em>Required Communication Link Resource Parametric Resource Demand</em>' reference.
     * @see #setRequiredCommunicationLinkResource_ParametricResourceDemand(CommunicationLinkResourceType)
     * @see org.palladiosimulator.completions.CompletionsPackage#getNetworkDemandParametricResourceDemand_RequiredCommunicationLinkResource_ParametricResourceDemand()
     * @model required="true" ordered="false"
     * @generated
     */
    CommunicationLinkResourceType getRequiredCommunicationLinkResource_ParametricResourceDemand();

    /**
     * Sets the value of the '{@link org.palladiosimulator.completions.NetworkDemandParametricResourceDemand#getRequiredCommunicationLinkResource_ParametricResourceDemand <em>Required Communication Link Resource Parametric Resource Demand</em>}' reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @param value the new value of the '<em>Required Communication Link Resource Parametric Resource Demand</em>' reference.
     * @see #getRequiredCommunicationLinkResource_ParametricResourceDemand()
     * @generated
     */
    void setRequiredCommunicationLinkResource_ParametricResourceDemand(CommunicationLinkResourceType value);

} // NetworkDemandParametricResourceDemand
