/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.spa.expression;

import de.uka.ipd.sdq.probfunction.ProbabilityDensityFunction;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sleep</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.spa.expression.Sleep#getPdf <em>Pdf</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.spa.expression.ExpressionPackage#getSleep()
 * @model
 * @generated
 */
public interface Sleep extends Terminal {
	/**
	 * Returns the value of the '<em><b>Pdf</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pdf</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pdf</em>' containment reference.
	 * @see #setPdf(ProbabilityDensityFunction)
	 * @see de.uka.ipd.sdq.spa.expression.ExpressionPackage#getSleep_Pdf()
	 * @model containment="true" required="true"
	 * @generated
	 */
	ProbabilityDensityFunction getPdf();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.spa.expression.Sleep#getPdf <em>Pdf</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pdf</em>' containment reference.
	 * @see #getPdf()
	 * @generated
	 */
	void setPdf(ProbabilityDensityFunction value);

} // Sleep