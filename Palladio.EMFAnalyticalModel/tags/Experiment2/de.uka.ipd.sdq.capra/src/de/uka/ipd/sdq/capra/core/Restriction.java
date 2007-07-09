/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.core;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Restriction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.capra.core.Restriction#getRestrictedProcess <em>Restricted Process</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.capra.core.Restriction#getRestrictedIdentifiers <em>Restricted Identifiers</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.capra.core.CorePackage#getRestriction()
 * @model
 * @generated
 */
public interface Restriction extends Operator {
	/**
	 * Returns the value of the '<em><b>Restricted Process</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Restricted Process</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Restricted Process</em>' containment reference.
	 * @see #setRestrictedProcess(CapraExpression)
	 * @see de.uka.ipd.sdq.capra.core.CorePackage#getRestriction_RestrictedProcess()
	 * @model containment="true" required="true"
	 * @generated
	 */
	CapraExpression getRestrictedProcess();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.capra.core.Restriction#getRestrictedProcess <em>Restricted Process</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Restricted Process</em>' containment reference.
	 * @see #getRestrictedProcess()
	 * @generated
	 */
	void setRestrictedProcess(CapraExpression value);

	/**
	 * Returns the value of the '<em><b>Restricted Identifiers</b></em>' reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.capra.core.CommunicationIdentifier}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Restricted Identifiers</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Restricted Identifiers</em>' reference list.
	 * @see de.uka.ipd.sdq.capra.core.CorePackage#getRestriction_RestrictedIdentifiers()
	 * @model type="de.uka.ipd.sdq.capra.core.CommunicationIdentifier"
	 * @generated
	 */
	EList<CommunicationIdentifier> getRestrictedIdentifiers();

} // Restriction
