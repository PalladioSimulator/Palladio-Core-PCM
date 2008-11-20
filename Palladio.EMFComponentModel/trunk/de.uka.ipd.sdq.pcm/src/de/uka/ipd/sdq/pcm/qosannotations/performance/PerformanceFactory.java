/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.qosannotations.performance;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.pcm.qosannotations.performance.PerformancePackage
 * @generated
 */
public interface PerformanceFactory extends EFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2008 by SDQ, IPD, University of Karlsruhe, Germany";
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PerformanceFactory eINSTANCE = de.uka.ipd.sdq.pcm.qosannotations.performance.impl.PerformanceFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>System Specified Execution Time</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>System Specified Execution Time</em>'.
	 * @generated
	 */
	SystemSpecifiedExecutionTime createSystemSpecifiedExecutionTime();

	/**
	 * Returns a new object of class '<em>Component Specified Execution Time</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Component Specified Execution Time</em>'.
	 * @generated
	 */
	ComponentSpecifiedExecutionTime createComponentSpecifiedExecutionTime();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	PerformancePackage getPerformancePackage();

} //PerformanceFactory
