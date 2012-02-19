/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.featureconfig;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.featureconfig.featureconfigPackage
 * @generated
 */
public interface featureconfigFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	featureconfigFactory eINSTANCE = de.uka.ipd.sdq.featureconfig.impl.featureconfigFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Config Node</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Config Node</em>'.
	 * @generated
	 */
	ConfigNode createConfigNode();

	/**
	 * Returns a new object of class '<em>Feature Config</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Feature Config</em>'.
	 * @generated
	 */
	FeatureConfig createFeatureConfig();

	/**
	 * Returns a new object of class '<em>Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Configuration</em>'.
	 * @generated
	 */
	Configuration createConfiguration();

	/**
	 * Returns a new object of class '<em>Integer Attribute Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Integer Attribute Value</em>'.
	 * @generated
	 */
	IntegerAttributeValue createIntegerAttributeValue();

	/**
	 * Returns a new object of class '<em>Double Attribute Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Double Attribute Value</em>'.
	 * @generated
	 */
	DoubleAttributeValue createDoubleAttributeValue();

	/**
	 * Returns a new object of class '<em>String Attribute Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>String Attribute Value</em>'.
	 * @generated
	 */
	StringAttributeValue createStringAttributeValue();

	/**
	 * Returns a new object of class '<em>External Object Attribute Value</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>External Object Attribute Value</em>'.
	 * @generated
	 */
	ExternalObjectAttributeValue createExternalObjectAttributeValue();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	featureconfigPackage getfeatureconfigPackage();

} //featureconfigFactory
