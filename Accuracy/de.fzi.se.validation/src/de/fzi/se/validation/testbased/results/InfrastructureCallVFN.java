/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.validation.testbased.results;

import edu.kit.ipd.sdq.bycounter.output.ObservedEntityExecution;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Infrastructure Call VFN</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fzi.se.validation.testbased.results.InfrastructureCallVFN#getObserved <em>Observed</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.validation.testbased.results.ResultsPackage#getInfrastructureCallVFN()
 * @model
 * @generated
 */
public interface InfrastructureCallVFN extends ValidationFailureNotice {
	/**
	 * Returns the value of the '<em><b>Observed</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Observed</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Observed</em>' reference.
	 * @see #setObserved(ObservedEntityExecution)
	 * @see de.fzi.se.validation.testbased.results.ResultsPackage#getInfrastructureCallVFN_Observed()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ObservedEntityExecution getObserved();

	/**
	 * Sets the value of the '{@link de.fzi.se.validation.testbased.results.InfrastructureCallVFN#getObserved <em>Observed</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Observed</em>' reference.
	 * @see #getObserved()
	 * @generated
	 */
	void setObserved(ObservedEntityExecution value);

} // InfrastructureCallVFN
