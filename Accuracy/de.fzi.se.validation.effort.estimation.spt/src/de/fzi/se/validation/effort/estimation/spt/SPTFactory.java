/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.validation.effort.estimation.spt;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.fzi.se.validation.effort.estimation.spt.SPTPackage
 * @generated
 */
public interface SPTFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SPTFactory eINSTANCE = de.fzi.se.validation.effort.estimation.spt.impl.SPTFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Effort Estimation Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Effort Estimation Result</em>'.
	 * @generated
	 */
	SPTEffortEstimationResult createSPTEffortEstimationResult();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SPTPackage getSPTPackage();

} //SPTFactory
