/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.validation.testbased.results;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.fzi.se.validation.testbased.results.ResultsPackage
 * @generated
 */
public interface ResultsFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ResultsFactory eINSTANCE = de.fzi.se.validation.testbased.results.impl.ResultsFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Parameter VFN</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parameter VFN</em>'.
	 * @generated
	 */
	ParameterVFN createParameterVFN();

	/**
	 * Returns a new object of class '<em>Infrastructure Call VFN</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Infrastructure Call VFN</em>'.
	 * @generated
	 */
	InfrastructureCallVFN createInfrastructureCallVFN();

	/**
	 * Returns a new object of class '<em>External Call VFN</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>External Call VFN</em>'.
	 * @generated
	 */
	ExternalCallVFN createExternalCallVFN();

	/**
	 * Returns a new object of class '<em>Execution Trace VFN</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Execution Trace VFN</em>'.
	 * @generated
	 */
	ExecutionTraceVFN createExecutionTraceVFN();

	/**
	 * Returns a new object of class '<em>Run Protocol</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Run Protocol</em>'.
	 * @generated
	 */
	RunProtocol createRunProtocol();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ResultsPackage getResultsPackage();

} //ResultsFactory
