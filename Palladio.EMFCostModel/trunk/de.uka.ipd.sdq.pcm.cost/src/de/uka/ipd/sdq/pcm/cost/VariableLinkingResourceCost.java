/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.cost;

import de.uka.ipd.sdq.pcm.resourceenvironment.LinkingResource;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Linking Resource Cost</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * see VariableProcessingResourceCost, this one works analogously. 
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.cost.VariableLinkingResourceCost#getBandwithInitialFactor <em>Bandwith Initial Factor</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.cost.VariableLinkingResourceCost#getBandwidthOperatingFactor <em>Bandwidth Operating Factor</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.cost.VariableLinkingResourceCost#getLinkingresource <em>Linkingresource</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.cost.costPackage#getVariableLinkingResourceCost()
 * @model
 * @generated
 */
public interface VariableLinkingResourceCost extends VariableCost {
	/**
	 * Returns the value of the '<em><b>Bandwith Initial Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bandwith Initial Factor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bandwith Initial Factor</em>' attribute.
	 * @see #setBandwithInitialFactor(double)
	 * @see de.uka.ipd.sdq.pcm.cost.costPackage#getVariableLinkingResourceCost_BandwithInitialFactor()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	double getBandwithInitialFactor();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.cost.VariableLinkingResourceCost#getBandwithInitialFactor <em>Bandwith Initial Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bandwith Initial Factor</em>' attribute.
	 * @see #getBandwithInitialFactor()
	 * @generated
	 */
	void setBandwithInitialFactor(double value);

	/**
	 * Returns the value of the '<em><b>Bandwidth Operating Factor</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Bandwidth Operating Factor</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Bandwidth Operating Factor</em>' attribute.
	 * @see #setBandwidthOperatingFactor(double)
	 * @see de.uka.ipd.sdq.pcm.cost.costPackage#getVariableLinkingResourceCost_BandwidthOperatingFactor()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	double getBandwidthOperatingFactor();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.cost.VariableLinkingResourceCost#getBandwidthOperatingFactor <em>Bandwidth Operating Factor</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Bandwidth Operating Factor</em>' attribute.
	 * @see #getBandwidthOperatingFactor()
	 * @generated
	 */
	void setBandwidthOperatingFactor(double value);

	/**
	 * Returns the value of the '<em><b>Linkingresource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Linkingresource</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Linkingresource</em>' reference.
	 * @see #setLinkingresource(LinkingResource)
	 * @see de.uka.ipd.sdq.pcm.cost.costPackage#getVariableLinkingResourceCost_Linkingresource()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	LinkingResource getLinkingresource();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.cost.VariableLinkingResourceCost#getLinkingresource <em>Linkingresource</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Linkingresource</em>' reference.
	 * @see #getLinkingresource()
	 * @generated
	 */
	void setLinkingresource(LinkingResource value);

} // VariableLinkingResourceCost
