/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.spa.expression;

import de.uka.ipd.sdq.spa.resourcemodel.PassiveResource;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Acquire</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.spa.expression.Acquire#getResource <em>Resource</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.spa.expression.ExpressionPackage#getAcquire()
 * @model
 * @generated
 */
public interface Acquire extends Terminal {
	/**
	 * Returns the value of the '<em><b>Resource</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Resource</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Resource</em>' reference.
	 * @see #setResource(PassiveResource)
	 * @see de.uka.ipd.sdq.spa.expression.ExpressionPackage#getAcquire_Resource()
	 * @model required="true"
	 * @generated
	 */
	PassiveResource getResource();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.spa.expression.Acquire#getResource <em>Resource</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Resource</em>' reference.
	 * @see #getResource()
	 * @generated
	 */
	void setResource(PassiveResource value);

} // Acquire
