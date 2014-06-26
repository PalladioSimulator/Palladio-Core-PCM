/**
 */
package de.uka.ipd.sdq.experimentautomation.experiments.simcomp;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.experimentautomation.experiments.simcomp.SimcompPackage
 * @generated
 */
public interface SimcompFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SimcompFactory eINSTANCE = de.uka.ipd.sdq.experimentautomation.experiments.simcomp.impl.SimcompFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Sim Comp Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Sim Comp Configuration</em>'.
	 * @generated
	 */
	SimCompConfiguration createSimCompConfiguration();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SimcompPackage getSimcompPackage();

} //SimcompFactory
