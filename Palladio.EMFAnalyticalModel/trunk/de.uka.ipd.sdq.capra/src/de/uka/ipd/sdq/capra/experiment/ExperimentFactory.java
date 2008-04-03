/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.capra.experiment;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.capra.experiment.ExperimentPackage
 * @generated
 */
public interface ExperimentFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExperimentFactory eINSTANCE = de.uka.ipd.sdq.capra.experiment.impl.ExperimentFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Resource Usage Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Resource Usage Specification</em>'.
	 * @generated
	 */
	ResourceUsageSpecification createResourceUsageSpecification();

	/**
	 * Returns a new object of class '<em>Experiment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Experiment</em>'.
	 * @generated
	 */
	Experiment createExperiment();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ExperimentPackage getExperimentPackage();

} //ExperimentFactory
