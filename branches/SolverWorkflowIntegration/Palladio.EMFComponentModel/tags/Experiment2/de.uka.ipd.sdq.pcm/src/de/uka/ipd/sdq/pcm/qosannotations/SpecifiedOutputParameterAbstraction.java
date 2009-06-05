/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.qosannotations;

import de.uka.ipd.sdq.pcm.parameter.VariableUsage;

import de.uka.ipd.sdq.pcm.repository.Role;
import de.uka.ipd.sdq.pcm.repository.Signature;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Specified Output Parameter Abstraction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.qosannotations.SpecifiedOutputParameterAbstraction#getSignature_SpecifiedOutputParameterAbstraction <em>Signature Specified Output Parameter Abstraction</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.qosannotations.SpecifiedOutputParameterAbstraction#getRole_SpecifiedOutputParameterAbstraction <em>Role Specified Output Parameter Abstraction</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.qosannotations.QosannotationsPackage#getSpecifiedOutputParameterAbstraction()
 * @model
 * @generated
 */
public interface SpecifiedOutputParameterAbstraction extends VariableUsage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Signature Specified Output Parameter Abstraction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Signature Specified Output Parameter Abstraction</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Signature Specified Output Parameter Abstraction</em>' reference.
	 * @see #setSignature_SpecifiedOutputParameterAbstraction(Signature)
	 * @see de.uka.ipd.sdq.pcm.qosannotations.QosannotationsPackage#getSpecifiedOutputParameterAbstraction_Signature_SpecifiedOutputParameterAbstraction()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Signature getSignature_SpecifiedOutputParameterAbstraction();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.qosannotations.SpecifiedOutputParameterAbstraction#getSignature_SpecifiedOutputParameterAbstraction <em>Signature Specified Output Parameter Abstraction</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Signature Specified Output Parameter Abstraction</em>' reference.
	 * @see #getSignature_SpecifiedOutputParameterAbstraction()
	 * @generated
	 */
	void setSignature_SpecifiedOutputParameterAbstraction(Signature value);

	/**
	 * Returns the value of the '<em><b>Role Specified Output Parameter Abstraction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Role Specified Output Parameter Abstraction</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Role Specified Output Parameter Abstraction</em>' reference.
	 * @see #setRole_SpecifiedOutputParameterAbstraction(Role)
	 * @see de.uka.ipd.sdq.pcm.qosannotations.QosannotationsPackage#getSpecifiedOutputParameterAbstraction_Role_SpecifiedOutputParameterAbstraction()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Role getRole_SpecifiedOutputParameterAbstraction();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.qosannotations.SpecifiedOutputParameterAbstraction#getRole_SpecifiedOutputParameterAbstraction <em>Role Specified Output Parameter Abstraction</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Role Specified Output Parameter Abstraction</em>' reference.
	 * @see #getRole_SpecifiedOutputParameterAbstraction()
	 * @generated
	 */
	void setRole_SpecifiedOutputParameterAbstraction(Role value);

} // SpecifiedOutputParameterAbstraction
