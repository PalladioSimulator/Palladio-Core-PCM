/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.spa;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.spa.SpaPackage
 * @generated
 */
public interface SpaFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SpaFactory eINSTANCE = de.uka.ipd.sdq.spa.impl.SpaFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Process Behaviour</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Process Behaviour</em>'.
	 * @generated
	 */
	ProcessBehaviour createProcessBehaviour();

	/**
	 * Returns a new object of class '<em>SPA Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SPA Model</em>'.
	 * @generated
	 */
	SPAModel createSPAModel();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	SpaPackage getSpaPackage();

} //SpaFactory
