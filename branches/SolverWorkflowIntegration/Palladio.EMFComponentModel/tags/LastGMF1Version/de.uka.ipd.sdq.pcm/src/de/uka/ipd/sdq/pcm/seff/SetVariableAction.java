
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff;

import de.uka.ipd.sdq.pcm.parameter.VariableUsage;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Set Variable Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.SetVariableAction#getVariableUsage_SetVariableAction <em>Variable Usage Set Variable Action</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getSetVariableAction()
 * @model
 * @generated
 */
public interface SetVariableAction extends AbstractResourceDemandingAction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * Returns the value of the '<em><b>Variable Usage Set Variable Action</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable Usage Set Variable Action</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Usage Set Variable Action</em>' containment reference.
	 * @see #setVariableUsage_SetVariableAction(VariableUsage)
	 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getSetVariableAction_VariableUsage_SetVariableAction()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	VariableUsage getVariableUsage_SetVariableAction();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.seff.SetVariableAction#getVariableUsage_SetVariableAction <em>Variable Usage Set Variable Action</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable Usage Set Variable Action</em>' containment reference.
	 * @see #getVariableUsage_SetVariableAction()
	 * @generated
	 */
	void setVariableUsage_SetVariableAction(VariableUsage value);

} // SetVariableAction