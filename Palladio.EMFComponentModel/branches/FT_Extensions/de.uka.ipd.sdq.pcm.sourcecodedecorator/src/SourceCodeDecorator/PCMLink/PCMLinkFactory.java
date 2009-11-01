/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package SourceCodeDecorator.PCMLink;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see SourceCodeDecorator.PCMLink.PCMLinkPackage
 * @generated
 */
public interface PCMLinkFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	PCMLinkFactory eINSTANCE = SourceCodeDecorator.PCMLink.impl.PCMLinkFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Component File Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Component File Link</em>'.
	 * @generated
	 */
	ComponentFileLink createComponentFileLink();

	/**
	 * Returns a new object of class '<em>SEFF Method Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>SEFF Method Link</em>'.
	 * @generated
	 */
	SEFFMethodLink createSEFFMethodLink();

	/**
	 * Returns a new object of class '<em>Action Control Flow Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Action Control Flow Link</em>'.
	 * @generated
	 */
	ActionControlFlowLink createActionControlFlowLink();

	/**
	 * Returns a new object of class '<em>Repository</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Repository</em>'.
	 * @generated
	 */
	PCMLinkRepository createPCMLinkRepository();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	PCMLinkPackage getPCMLinkPackage();

} //PCMLinkFactory
