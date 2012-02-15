/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.validation.effort.estimation.spt;

import de.fzi.se.validation.effort.estimation.EffortEstimationResult;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Effort Estimation Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fzi.se.validation.effort.estimation.spt.SPTEffortEstimationResult#getN <em>N</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.validation.effort.estimation.spt.SPTPackage#getSPTEffortEstimationResult()
 * @model
 * @generated
 */
public interface SPTEffortEstimationResult extends EffortEstimationResult {
	/**
	 * Returns the value of the '<em><b>N</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>N</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>N</em>' attribute.
	 * @see #setN(int)
	 * @see de.fzi.se.validation.effort.estimation.spt.SPTPackage#getSPTEffortEstimationResult_N()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getN();

	/**
	 * Sets the value of the '{@link de.fzi.se.validation.effort.estimation.spt.SPTEffortEstimationResult#getN <em>N</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>N</em>' attribute.
	 * @see #getN()
	 * @generated
	 */
	void setN(int value);

} // SPTEffortEstimationResult
