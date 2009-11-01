/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package SourceCodeDecorator.loggerLink;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see SourceCodeDecorator.loggerLink.LoggerLinkPackage
 * @generated
 */
public interface LoggerLinkFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LoggerLinkFactory eINSTANCE = SourceCodeDecorator.loggerLink.impl.LoggerLinkFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Logging Position Id</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Logging Position Id</em>'.
	 * @generated
	 */
	LoggingPositionId createLoggingPositionId();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	LoggerLinkPackage getLoggerLinkPackage();

} //LoggerLinkFactory
