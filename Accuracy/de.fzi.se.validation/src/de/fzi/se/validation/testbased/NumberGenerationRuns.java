/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.validation.testbased;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Number Generation Runs</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fzi.se.validation.testbased.NumberGenerationRuns#getNumber <em>Number</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.validation.testbased.TestbasedPackage#getNumberGenerationRuns()
 * @model
 * @generated
 */
public interface NumberGenerationRuns extends TestcaseExecutionStopStrategy {
	/**
	 * Returns the value of the '<em><b>Number</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number</em>' attribute.
	 * @see #setNumber(long)
	 * @see de.fzi.se.validation.testbased.TestbasedPackage#getNumberGenerationRuns_Number()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	long getNumber();

	/**
	 * Sets the value of the '{@link de.fzi.se.validation.testbased.NumberGenerationRuns#getNumber <em>Number</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number</em>' attribute.
	 * @see #getNumber()
	 * @generated
	 */
	void setNumber(long value);

} // NumberGenerationRuns
