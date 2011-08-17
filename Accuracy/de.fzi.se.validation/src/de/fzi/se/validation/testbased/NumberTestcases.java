/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.validation.testbased;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Number Testcases</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fzi.se.validation.testbased.NumberTestcases#getMinimum <em>Minimum</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.validation.testbased.TestbasedPackage#getNumberTestcases()
 * @model
 * @generated
 */
public interface NumberTestcases extends TestcaseExecutionStopStrategy {
	/**
	 * Returns the value of the '<em><b>Minimum</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Minimum</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Minimum</em>' attribute.
	 * @see #setMinimum(long)
	 * @see de.fzi.se.validation.testbased.TestbasedPackage#getNumberTestcases_Minimum()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	long getMinimum();

	/**
	 * Sets the value of the '{@link de.fzi.se.validation.testbased.NumberTestcases#getMinimum <em>Minimum</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Minimum</em>' attribute.
	 * @see #getMinimum()
	 * @generated
	 */
	void setMinimum(long value);

} // NumberTestcases
