/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.core;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Demand Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.core.DemandAction#getIdentifier <em>Identifier</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.core.DemandAction#getResourceUsage <em>Resource Usage</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.capra.core.CorePackage#getDemandAction()
 * @model
 * @generated
 */
public interface DemandAction extends Action {
	/**
	 * Returns the value of the '<em><b>Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifier</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifier</em>' reference.
	 * @see #setIdentifier(DemandIdentifier)
	 * @see de.uka.ipd.sdq.capra.core.CorePackage#getDemandAction_Identifier()
	 * @model required="true"
	 * @generated
	 */
	DemandIdentifier getIdentifier();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.core.DemandAction#getIdentifier <em>Identifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identifier</em>' reference.
	 * @see #getIdentifier()
	 * @generated
	 */
	void setIdentifier(DemandIdentifier value);

	/**
	 * Returns the value of the '<em><b>Resource Usage</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource Usage</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource Usage</em>' containment reference.
	 * @see #setResourceUsage(ResourceUsage)
	 * @see de.uka.ipd.sdq.capra.core.CorePackage#getDemandAction_ResourceUsage()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ResourceUsage getResourceUsage();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.core.DemandAction#getResourceUsage <em>Resource Usage</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource Usage</em>' containment reference.
	 * @see #getResourceUsage()
	 * @generated
	 */
	void setResourceUsage(ResourceUsage value);

} // DemandAction
