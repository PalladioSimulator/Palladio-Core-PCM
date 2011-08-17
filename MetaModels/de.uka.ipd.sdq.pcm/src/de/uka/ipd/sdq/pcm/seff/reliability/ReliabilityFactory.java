/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.reliability;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.pcm.seff.reliability.ReliabilityPackage
 * @generated
 */
public interface ReliabilityFactory extends EFactory {
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
	ReliabilityFactory eINSTANCE = de.uka.ipd.sdq.pcm.seff.reliability.impl.ReliabilityFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Recovery Block Alternative Behaviour</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Recovery Block Alternative Behaviour</em>'.
	 * @generated
	 */
	RecoveryBlockAlternativeBehaviour createRecoveryBlockAlternativeBehaviour();

	/**
	 * Returns a new object of class '<em>Recovery Block Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Recovery Block Action</em>'.
	 * @generated
	 */
	RecoveryBlockAction createRecoveryBlockAction();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ReliabilityPackage getReliabilityPackage();

} //ReliabilityFactory
