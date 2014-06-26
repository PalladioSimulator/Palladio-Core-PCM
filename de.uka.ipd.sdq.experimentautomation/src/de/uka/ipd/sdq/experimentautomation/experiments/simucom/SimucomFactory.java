/**
 */
package de.uka.ipd.sdq.experimentautomation.experiments.simucom;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.experimentautomation.experiments.simucom.SimucomPackage
 * @generated
 */
public interface SimucomFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SimucomFactory eINSTANCE = de.uka.ipd.sdq.experimentautomation.experiments.simucom.impl.SimucomFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Simu Com Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simu Com Configuration</em>'.
	 * @generated
	 */
	SimuComConfiguration createSimuComConfiguration();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SimucomPackage getSimucomPackage();

} //SimucomFactory
