/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.validation.testbased.trace;

import de.fzi.se.validation.testbased.results.RunProtocol;

import de.uka.ipd.sdq.identifier.Identifier;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Execution Trace</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fzi.se.validation.testbased.trace.ExecutionTrace#getTraceActions <em>Trace Actions</em>}</li>
 *   <li>{@link de.fzi.se.validation.testbased.trace.ExecutionTrace#getRunProtocol <em>Run Protocol</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.validation.testbased.trace.TracePackage#getExecutionTrace()
 * @model
 * @generated
 */
public interface ExecutionTrace extends Identifier {
	/**
	 * Returns the value of the '<em><b>Trace Actions</b></em>' containment reference list.
	 * The list contents are of type {@link de.fzi.se.validation.testbased.trace.TraceAction}.
	 * It is bidirectional and its opposite is '{@link de.fzi.se.validation.testbased.trace.TraceAction#getExecutionTrace <em>Execution Trace</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Trace Actions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Trace Actions</em>' containment reference list.
	 * @see de.fzi.se.validation.testbased.trace.TracePackage#getExecutionTrace_TraceActions()
	 * @see de.fzi.se.validation.testbased.trace.TraceAction#getExecutionTrace
	 * @model opposite="executionTrace" containment="true"
	 * @generated
	 */
	EList<TraceAction> getTraceActions();

	/**
	 * Returns the value of the '<em><b>Run Protocol</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fzi.se.validation.testbased.results.RunProtocol#getInvalidTraces <em>Invalid Traces</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Run Protocol</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Run Protocol</em>' container reference.
	 * @see #setRunProtocol(RunProtocol)
	 * @see de.fzi.se.validation.testbased.trace.TracePackage#getExecutionTrace_RunProtocol()
	 * @see de.fzi.se.validation.testbased.results.RunProtocol#getInvalidTraces
	 * @model opposite="invalidTraces" transient="false" ordered="false"
	 * @generated
	 */
	RunProtocol getRunProtocol();

	/**
	 * Sets the value of the '{@link de.fzi.se.validation.testbased.trace.ExecutionTrace#getRunProtocol <em>Run Protocol</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Run Protocol</em>' container reference.
	 * @see #getRunProtocol()
	 * @generated
	 */
	void setRunProtocol(RunProtocol value);

} // ExecutionTrace
