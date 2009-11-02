/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggerlinkPackage
 * @generated
 */
public interface LoggerlinkFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LoggerlinkFactory eINSTANCE = de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.LoggerlinkFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Before Return Value Logging Position Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Before Return Value Logging Position Link</em>'.
	 * @generated
	 */
	BeforeReturnValueLoggingPositionLink createBeforeReturnValueLoggingPositionLink();

	/**
	 * Returns a new object of class '<em>Before External Call Logging Position Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Before External Call Logging Position Link</em>'.
	 * @generated
	 */
	BeforeExternalCallLoggingPositionLink createBeforeExternalCallLoggingPositionLink();

	/**
	 * Returns a new object of class '<em>Method Call Logging Position Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Method Call Logging Position Link</em>'.
	 * @generated
	 */
	MethodCallLoggingPositionLink createMethodCallLoggingPositionLink();

	/**
	 * Returns a new object of class '<em>After External Call Logging Position Link</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>After External Call Logging Position Link</em>'.
	 * @generated
	 */
	AfterExternalCallLoggingPositionLink createAfterExternalCallLoggingPositionLink();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	LoggerlinkPackage getLoggerlinkPackage();

} //LoggerlinkFactory
