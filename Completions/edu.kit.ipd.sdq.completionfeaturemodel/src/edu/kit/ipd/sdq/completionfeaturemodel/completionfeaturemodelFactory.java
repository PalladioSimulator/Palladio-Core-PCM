/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.kit.ipd.sdq.completionfeaturemodel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see edu.kit.ipd.sdq.completionfeaturemodel.completionfeaturemodelPackage
 * @generated
 */
public interface completionfeaturemodelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	completionfeaturemodelFactory eINSTANCE = edu.kit.ipd.sdq.completionfeaturemodel.impl.completionfeaturemodelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Completion Feature</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Completion Feature</em>'.
	 * @generated
	 */
	CompletionFeature createCompletionFeature();

	/**
	 * Returns a new object of class '<em>Disambiguation Rule</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Disambiguation Rule</em>'.
	 * @generated
	 */
	DisambiguationRule createDisambiguationRule();

	/**
	 * Returns a new object of class '<em>Completion Feature Diagram</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Completion Feature Diagram</em>'.
	 * @generated
	 */
	CompletionFeatureDiagram createCompletionFeatureDiagram();

	/**
	 * Returns a new object of class '<em>Completion Simple</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Completion Simple</em>'.
	 * @generated
	 */
	CompletionSimple createCompletionSimple();

	/**
	 * Returns a new object of class '<em>Completion Feature Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Completion Feature Group</em>'.
	 * @generated
	 */
	CompletionFeatureGroup createCompletionFeatureGroup();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	completionfeaturemodelPackage getcompletionfeaturemodelPackage();

} //completionfeaturemodelFactory
