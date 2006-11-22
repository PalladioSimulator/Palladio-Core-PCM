/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.qnm.resultmodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.qnm.resultmodel.ResultModelPackage
 * @generated
 */
public interface ResultModelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ResultModelFactory eINSTANCE = de.uka.ipd.sdq.qnm.resultmodel.impl.ResultModelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>QNM Result Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>QNM Result Model</em>'.
	 * @generated
	 */
	QNMResultModel createQNMResultModel();

	/**
	 * Returns a new object of class '<em>Resource Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resource Result</em>'.
	 * @generated
	 */
	ResourceResult createResourceResult();

	/**
	 * Returns a new object of class '<em>Task Resource Usage</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Task Resource Usage</em>'.
	 * @generated
	 */
	TaskResourceUsage createTaskResourceUsage();

	/**
	 * Returns a new object of class '<em>Task Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Task Result</em>'.
	 * @generated
	 */
	TaskResult createTaskResult();

	/**
	 * Returns a new object of class '<em>Resource Usage Time</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resource Usage Time</em>'.
	 * @generated
	 */
	ResourceUsageTime createResourceUsageTime();

	/**
	 * Returns a new object of class '<em>Service Time Break Down</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Service Time Break Down</em>'.
	 * @generated
	 */
	ServiceTimeBreakDown createServiceTimeBreakDown();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ResultModelPackage getResultModelPackage();

} //ResultModelFactory
