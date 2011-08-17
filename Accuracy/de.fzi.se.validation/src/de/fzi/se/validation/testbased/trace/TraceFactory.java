/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.validation.testbased.trace;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.fzi.se.validation.testbased.trace.TracePackage
 * @generated
 */
public interface TraceFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	TraceFactory eINSTANCE = de.fzi.se.validation.testbased.trace.impl.TraceFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Execution Trace</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Execution Trace</em>'.
	 * @generated
	 */
	ExecutionTrace createExecutionTrace();

	/**
	 * Returns a new object of class '<em>Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Action</em>'.
	 * @generated
	 */
	TraceAction createTraceAction();

	/**
	 * Returns a new object of class '<em>Component Parameter Assignment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Component Parameter Assignment</em>'.
	 * @generated
	 */
	ComponentParameterAssignment createComponentParameterAssignment();

	/**
	 * Returns a new object of class '<em>Internal Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Internal Call</em>'.
	 * @generated
	 */
	InternalCall createInternalCall();

	/**
	 * Returns a new object of class '<em>Outgoing Business Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Outgoing Business Call</em>'.
	 * @generated
	 */
	OutgoingBusinessCall createOutgoingBusinessCall();

	/**
	 * Returns a new object of class '<em>Outgoing Infrastructure Calls</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Outgoing Infrastructure Calls</em>'.
	 * @generated
	 */
	OutgoingInfrastructureCalls createOutgoingInfrastructureCalls();

	/**
	 * Returns a new object of class '<em>Operation Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operation Call</em>'.
	 * @generated
	 */
	OperationCall createOperationCall();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	TracePackage getTracePackage();

} //TraceFactory
