/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.validation.testbased.results;

import de.fzi.se.validation.testbased.trace.ExecutionTrace;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Execution Trace VFN</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fzi.se.validation.testbased.results.ExecutionTraceVFN#getExecutionTrace <em>Execution Trace</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.validation.testbased.results.ResultsPackage#getExecutionTraceVFN()
 * @model
 * @generated
 */
public interface ExecutionTraceVFN extends ValidationFailureNotice {
	/**
	 * Returns the value of the '<em><b>Execution Trace</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Execution Trace</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Execution Trace</em>' reference.
	 * @see #setExecutionTrace(ExecutionTrace)
	 * @see de.fzi.se.validation.testbased.results.ResultsPackage#getExecutionTraceVFN_ExecutionTrace()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ExecutionTrace getExecutionTrace();

	/**
	 * Sets the value of the '{@link de.fzi.se.validation.testbased.results.ExecutionTraceVFN#getExecutionTrace <em>Execution Trace</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Execution Trace</em>' reference.
	 * @see #getExecutionTrace()
	 * @generated
	 */
	void setExecutionTrace(ExecutionTrace value);

} // ExecutionTraceVFN
