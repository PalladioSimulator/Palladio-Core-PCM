/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.validation.effort.estimation;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.fzi.se.validation.effort.estimation.EstimationPackage
 * @generated
 */
public interface EstimationFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	EstimationFactory eINSTANCE = de.fzi.se.validation.effort.estimation.impl.EstimationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Effort Estimation Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Effort Estimation Result</em>'.
	 * @generated
	 */
	EffortEstimationResult createEffortEstimationResult();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	EstimationPackage getEstimationPackage();

} //EstimationFactory
