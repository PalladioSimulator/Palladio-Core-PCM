/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.GastPcmLinkPackage
 * @generated
 */
public interface GastPcmLinkFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	GastPcmLinkFactory eINSTANCE = de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.impl.GastPcmLinkFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Internal Action Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Internal Action Link</em>'.
	 * @generated
	 */
	InternalActionLink createInternalActionLink();

	/**
	 * Returns a new object of class '<em>Parameter Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parameter Link</em>'.
	 * @generated
	 */
	ParameterLink createParameterLink();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	GastPcmLinkPackage getGastPcmLinkPackage();

} //GastPcmLinkFactory
