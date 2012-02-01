/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.controlflowdescription;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.fzi.se.controlflowdescription.ControlFlowDescriptionPackage
 * @generated
 */
public interface ControlFlowDescriptionFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ControlFlowDescriptionFactory eINSTANCE = de.fzi.se.controlflowdescription.impl.ControlFlowDescriptionFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Control Flow Description</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Control Flow Description</em>'.
	 * @generated
	 */
	ControlFlowDescription createControlFlowDescription();

	/**
	 * Returns a new object of class '<em>Control Flow Descriptions</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Control Flow Descriptions</em>'.
	 * @generated
	 */
	ControlFlowDescriptions createControlFlowDescriptions();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ControlFlowDescriptionPackage getControlFlowDescriptionPackage();

} //ControlFlowDescriptionFactory
