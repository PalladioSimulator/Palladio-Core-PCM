/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.seff_performance;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.pcm.seff.seff_performance.Seff_performancePackage
 * @generated
 */
public interface Seff_performanceFactory extends EFactory {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Seff_performanceFactory eINSTANCE = de.uka.ipd.sdq.pcm.seff.seff_performance.impl.Seff_performanceFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Infrastructure Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Infrastructure Call</em>'.
	 * @generated
	 */
	InfrastructureCall createInfrastructureCall();

	/**
	 * Returns a new object of class '<em>Resource Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resource Call</em>'.
	 * @generated
	 */
	ResourceCall createResourceCall();

	/**
	 * Returns a new object of class '<em>Parametric Resource Demand</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parametric Resource Demand</em>'.
	 * @generated
	 */
	ParametricResourceDemand createParametricResourceDemand();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	Seff_performancePackage getSeff_performancePackage();

} //Seff_performanceFactory
