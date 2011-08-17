/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.cost;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.pcm.cost.costPackage
 * @generated
 */
public interface costFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	costFactory eINSTANCE = de.uka.ipd.sdq.pcm.cost.impl.costFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Component Cost</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Component Cost</em>'.
	 * @generated
	 */
	ComponentCost createComponentCost();

	/**
	 * Returns a new object of class '<em>Fixed Linking Resource Cost</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fixed Linking Resource Cost</em>'.
	 * @generated
	 */
	FixedLinkingResourceCost createFixedLinkingResourceCost();

	/**
	 * Returns a new object of class '<em>Fixed Processing Resource Cost</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Fixed Processing Resource Cost</em>'.
	 * @generated
	 */
	FixedProcessingResourceCost createFixedProcessingResourceCost();

	/**
	 * Returns a new object of class '<em>Variable Linking Resource Cost</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable Linking Resource Cost</em>'.
	 * @generated
	 */
	VariableLinkingResourceCost createVariableLinkingResourceCost();

	/**
	 * Returns a new object of class '<em>Variable Processing Resource Cost</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable Processing Resource Cost</em>'.
	 * @generated
	 */
	VariableProcessingResourceCost createVariableProcessingResourceCost();

	/**
	 * Returns a new object of class '<em>Scalar Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Scalar Function</em>'.
	 * @generated
	 */
	ScalarFunction createScalarFunction();

	/**
	 * Returns a new object of class '<em>Cost Repository</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Cost Repository</em>'.
	 * @generated
	 */
	CostRepository createCostRepository();

	/**
	 * Returns a new object of class '<em>Component Cost Per Instance</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Component Cost Per Instance</em>'.
	 * @generated
	 */
	ComponentCostPerInstance createComponentCostPerInstance();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	costPackage getcostPackage();

} //costFactory
