/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.edp2.models.Presentation.UI;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.edp2.models.Presentation.UI.UIPackage
 * @generated
 */
public interface UIFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	UIFactory eINSTANCE = de.uka.ipd.sdq.edp2.models.Presentation.UI.impl.UIFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Presentation Configuration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Presentation Configuration</em>'.
	 * @generated
	 */
	PresentationConfiguration createPresentationConfiguration();

	/**
	 * Returns a new object of class '<em>Presentation Property Pane</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Presentation Property Pane</em>'.
	 * @generated
	 */
	PresentationPropertyPane createPresentationPropertyPane();

	/**
	 * Returns a new object of class '<em>Presentation Input</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Presentation Input</em>'.
	 * @generated
	 */
	PresentationInput createPresentationInput();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	UIPackage getUIPackage();

} //UIFactory
