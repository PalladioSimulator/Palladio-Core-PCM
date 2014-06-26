/**
 */
package de.uka.ipd.sdq.experimentautomation.variation;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.experimentautomation.variation.VariationPackage
 * @generated
 */
public interface VariationFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	VariationFactory eINSTANCE = de.uka.ipd.sdq.experimentautomation.variation.impl.VariationFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Value Variation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Value Variation</em>'.
	 * @generated
	 */
	ValueVariation createValueVariation();

	/**
	 * Returns a new object of class '<em>Structural Variation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Structural Variation</em>'.
	 * @generated
	 */
	StructuralVariation createStructuralVariation();

	/**
	 * Returns a new object of class '<em>Repository</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Repository</em>'.
	 * @generated
	 */
	VariationRepository createVariationRepository();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	VariationPackage getVariationPackage();

} //VariationFactory
