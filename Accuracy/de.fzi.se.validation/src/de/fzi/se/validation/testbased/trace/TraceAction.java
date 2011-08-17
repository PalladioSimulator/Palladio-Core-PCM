/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.validation.testbased.trace;

import de.uka.ipd.sdq.identifier.Identifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fzi.se.validation.testbased.trace.TraceAction#getExecutionTrace <em>Execution Trace</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.validation.testbased.trace.TracePackage#getTraceAction()
 * @model
 * @generated
 */
public interface TraceAction extends Identifier {
	/**
	 * Returns the value of the '<em><b>Execution Trace</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fzi.se.validation.testbased.trace.ExecutionTrace#getTraceActions <em>Trace Actions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Execution Trace</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Execution Trace</em>' container reference.
	 * @see #setExecutionTrace(ExecutionTrace)
	 * @see de.fzi.se.validation.testbased.trace.TracePackage#getTraceAction_ExecutionTrace()
	 * @see de.fzi.se.validation.testbased.trace.ExecutionTrace#getTraceActions
	 * @model opposite="traceActions" required="true" transient="false" ordered="false"
	 * @generated
	 */
	ExecutionTrace getExecutionTrace();

	/**
	 * Sets the value of the '{@link de.fzi.se.validation.testbased.trace.TraceAction#getExecutionTrace <em>Execution Trace</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Execution Trace</em>' container reference.
	 * @see #getExecutionTrace()
	 * @generated
	 */
	void setExecutionTrace(ExecutionTrace value);

} // TraceAction
