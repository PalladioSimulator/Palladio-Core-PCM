
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.core.stochastics;

import de.uka.ipd.sdq.probfunction.ProbabilityFunction;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Probability Function Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.core.stochastics.ProbabilityFunctionLiteral#getFunction_ProbabilityFunctionLiteral <em>Function Probability Function Literal</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.core.stochastics.StochasticsPackage#getProbabilityFunctionLiteral()
 * @model
 * @generated
 */
public interface ProbabilityFunctionLiteral extends Atom {
	/**
	 * Returns the value of the '<em><b>Function Probability Function Literal</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function Probability Function Literal</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function Probability Function Literal</em>' containment reference.
	 * @see #setFunction_ProbabilityFunctionLiteral(ProbabilityFunction)
	 * @see de.uka.ipd.sdq.pcm.core.stochastics.StochasticsPackage#getProbabilityFunctionLiteral_Function_ProbabilityFunctionLiteral()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	ProbabilityFunction getFunction_ProbabilityFunctionLiteral();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.core.stochastics.ProbabilityFunctionLiteral#getFunction_ProbabilityFunctionLiteral <em>Function Probability Function Literal</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Function Probability Function Literal</em>' containment reference.
	 * @see #getFunction_ProbabilityFunctionLiteral()
	 * @generated
	 */
	void setFunction_ProbabilityFunctionLiteral(ProbabilityFunction value);

} // ProbabilityFunctionLiteral