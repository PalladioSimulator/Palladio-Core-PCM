/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.validation.testbased.trace;

import de.fzi.se.quality.parameters.CallInstance;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Outgoing Business Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fzi.se.validation.testbased.trace.OutgoingBusinessCall#getCallInstance <em>Call Instance</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.validation.testbased.trace.TracePackage#getOutgoingBusinessCall()
 * @model
 * @generated
 */
public interface OutgoingBusinessCall extends TraceAction {
	/**
	 * Returns the value of the '<em><b>Call Instance</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Call Instance</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Call Instance</em>' containment reference.
	 * @see #setCallInstance(CallInstance)
	 * @see de.fzi.se.validation.testbased.trace.TracePackage#getOutgoingBusinessCall_CallInstance()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	CallInstance getCallInstance();

	/**
	 * Sets the value of the '{@link de.fzi.se.validation.testbased.trace.OutgoingBusinessCall#getCallInstance <em>Call Instance</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Call Instance</em>' containment reference.
	 * @see #getCallInstance()
	 * @generated
	 */
	void setCallInstance(CallInstance value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.callInstances->forAll(call | call.parameterReference.oclIsTypeOf(Validation::Parameters::BusinessOperationReference))
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='self.callInstances->forAll(call | call.parameterReference.oclIsTypeOf(Validation::Parameters::BusinessOperationReference))'"
	 * @generated
	 */
	boolean CallInstancemustreferenceBusinessoperation(DiagnosticChain diagnostics, Map<Object, Object> context);

} // OutgoingBusinessCall
