/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision.QualityProperties;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.pcm.designdecision.QualityProperties.QualityPropertiesPackage
 * @generated
 */
public interface QualityPropertiesFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QualityPropertiesFactory eINSTANCE = de.uka.ipd.sdq.pcm.designdecision.QualityProperties.impl.QualityPropertiesFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Confidence Interval</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Confidence Interval</em>'.
	 * @generated
	 */
	ConfidenceInterval createConfidenceInterval();

	/**
	 * Returns a new object of class '<em>Element Quality Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Element Quality Property</em>'.
	 * @generated
	 */
	ElementQualityProperty createElementQualityProperty();

	/**
	 * Returns a new object of class '<em>Integer Quality Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Integer Quality Property</em>'.
	 * @generated
	 */
	IntegerQualityProperty createIntegerQualityProperty();

	/**
	 * Returns a new object of class '<em>Double Quality Property</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Double Quality Property</em>'.
	 * @generated
	 */
	DoubleQualityProperty createDoubleQualityProperty();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	QualityPropertiesPackage getQualityPropertiesPackage();

} //QualityPropertiesFactory
