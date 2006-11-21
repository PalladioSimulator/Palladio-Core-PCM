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
	 * Returns a new object of class '<em>Customer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Customer</em>'.
	 * @generated
	 */
	Task createCustomer();

	/**
	 * Returns a new object of class '<em>Device Server</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Device Server</em>'.
	 * @generated
	 */
	DeviceServer createDeviceServer();

	/**
	 * Returns a new object of class '<em>Logical Server</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Logical Server</em>'.
	 * @generated
	 */
	LogicalServer createLogicalServer();

	/**
	 * Returns a new object of class '<em>Device Demand</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Device Demand</em>'.
	 * @generated
	 */
	DeviceDemand createDeviceDemand();

	/**
	 * Returns a new object of class '<em>Sequential Demand</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sequential Demand</em>'.
	 * @generated
	 */
	SequentialDemand createSequentialDemand();

	/**
	 * Returns a new object of class '<em>Alternative Demand</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Alternative Demand</em>'.
	 * @generated
	 */
	AlternativeDemand createAlternativeDemand();

	/**
	 * Returns a new object of class '<em>Iterative Demand</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Iterative Demand</em>'.
	 * @generated
	 */
	IterativeDemand createIterativeDemand();

	/**
	 * Returns a new object of class '<em>Parallel Demand</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parallel Demand</em>'.
	 * @generated
	 */
	ParallelDemand createParallelDemand();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	QnmPackage getQnmPackage();

} //QnmFactory
