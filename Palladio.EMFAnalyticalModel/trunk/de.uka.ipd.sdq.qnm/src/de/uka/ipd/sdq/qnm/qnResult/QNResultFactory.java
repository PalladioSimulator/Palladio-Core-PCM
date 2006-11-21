/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.qnm.qnResult;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.qnm.qnResult.QNResultPackage
 * @generated
 */
public interface QNResultFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QNResultFactory eINSTANCE = de.uka.ipd.sdq.qnm.qnResult.impl.QNResultFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Demand Server Usage</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Demand Server Usage</em>'.
	 * @generated
	 */
	DemandServerUsage createDemandServerUsage();

	/**
	 * Returns a new object of class '<em>Demand Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Demand Result</em>'.
	 * @generated
	 */
	DemandResult createDemandResult();

	/**
	 * Returns a new object of class '<em>Server Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Server Result</em>'.
	 * @generated
	 */
	ServerResult createServerResult();

	/**
	 * Returns a new object of class '<em>Customer Server Usage</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Customer Server Usage</em>'.
	 * @generated
	 */
	CustomerServerUsage createCustomerServerUsage();

	/**
	 * Returns a new object of class '<em>Customer Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Customer Result</em>'.
	 * @generated
	 */
	CustomerResult createCustomerResult();

	/**
	 * Returns a new object of class '<em>Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model</em>'.
	 * @generated
	 */
	QNResultModel createQNResultModel();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	QNResultPackage getQNResultPackage();

} //QNResultFactory
