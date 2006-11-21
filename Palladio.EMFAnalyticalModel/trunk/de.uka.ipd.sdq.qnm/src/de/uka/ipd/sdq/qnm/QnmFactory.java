/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.qnm;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.qnm.QnmPackage
 * @generated
 */
public interface QnmFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QnmFactory eINSTANCE = de.uka.ipd.sdq.qnm.impl.QnmFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>QN Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>QN Model</em>'.
	 * @generated
	 */
	QNModel createQNModel();

	/**
	 * Returns a new object of class '<em>Task</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Task</em>'.
	 * @generated
	 */
	Task createTask();

	/**
	 * Returns a new object of class '<em>Sequential Resource Usage</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sequential Resource Usage</em>'.
	 * @generated
	 */
	SequentialResourceUsage createSequentialResourceUsage();

	/**
	 * Returns a new object of class '<em>Alternative Resource Usage</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Alternative Resource Usage</em>'.
	 * @generated
	 */
	AlternativeResourceUsage createAlternativeResourceUsage();

	/**
	 * Returns a new object of class '<em>Iterative Resource Usage</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Iterative Resource Usage</em>'.
	 * @generated
	 */
	IterativeResourceUsage createIterativeResourceUsage();

	/**
	 * Returns a new object of class '<em>Parallel Resource Usage</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parallel Resource Usage</em>'.
	 * @generated
	 */
	ParallelResourceUsage createParallelResourceUsage();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	QnmPackage getQnmPackage();

} //QnmFactory
