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
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Outgoing Infrastructure Calls</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fzi.se.validation.testbased.trace.OutgoingInfrastructureCalls#getCallInstances <em>Call Instances</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.validation.testbased.trace.TracePackage#getOutgoingInfrastructureCalls()
 * @model
 * @generated
 */
public interface OutgoingInfrastructureCalls extends TraceAction {
	/**
	 * Returns the value of the '<em><b>Call Instances</b></em>' containment reference list.
	 * The list contents are of type {@link de.fzi.se.quality.parameters.CallInstance}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Call Instances</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Call Instances</em>' containment reference list.
	 * @see de.fzi.se.validation.testbased.trace.TracePackage#getOutgoingInfrastructureCalls_CallInstances()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<CallInstance> getCallInstances();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.callInstances->forAll(call | call.parameterReference.oclIsTypeOf(Validation::Parameters::InfrastructureOperationReference))
	 * 
	 * 
	 * 
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='self.callInstances->forAll(call | call.parameterReference.oclIsTypeOf(Validation::Parameters::InfrastructureOperationReference))\r\n\r\n\r\n'"
	 * @generated
	 */
	boolean CallInstancemustreferenceInfrastructureoperation(DiagnosticChain diagnostics, Map<Object, Object> context);

} // OutgoingInfrastructureCalls
