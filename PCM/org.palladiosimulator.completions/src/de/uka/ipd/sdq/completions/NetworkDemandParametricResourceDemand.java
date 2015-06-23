/**
 * Copyright SDQ, IPD, U Karlsruhe, 2007
 */
package de.uka.ipd.sdq.completions;

import de.uka.ipd.sdq.pcm.resourcetype.CommunicationLinkResourceType;
import de.uka.ipd.sdq.pcm.seff.seff_performance.ParametricResourceDemand;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Network Demand Parametric Resource Demand</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.completions.NetworkDemandParametricResourceDemand#getRequiredCommunicationLinkResource_ParametricResourceDemand <em>Required Communication Link Resource Parametric Resource Demand</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.completions.CompletionsPackage#getNetworkDemandParametricResourceDemand()
 * @model
 * @generated
 */
public interface NetworkDemandParametricResourceDemand extends ParametricResourceDemand {

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
	 * @see de.uka.ipd.sdq.completions.CompletionsPackage#getNetworkDemandParametricResourceDemand_RequiredCommunicationLinkResource_ParametricResourceDemand()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	CommunicationLinkResourceType getRequiredCommunicationLinkResource_ParametricResourceDemand();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.completions.NetworkDemandParametricResourceDemand#getRequiredCommunicationLinkResource_ParametricResourceDemand <em>Required Communication Link Resource Parametric Resource Demand</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required Communication Link Resource Parametric Resource Demand</em>' reference.
	 * @see #getRequiredCommunicationLinkResource_ParametricResourceDemand()
	 * @generated
	 */
	void setRequiredCommunicationLinkResource_ParametricResourceDemand(CommunicationLinkResourceType value);
} // NetworkDemandParametricResourceDemand
