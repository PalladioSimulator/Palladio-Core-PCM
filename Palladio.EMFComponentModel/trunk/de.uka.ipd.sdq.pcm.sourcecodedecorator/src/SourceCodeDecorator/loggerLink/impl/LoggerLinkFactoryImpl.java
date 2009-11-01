/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package SourceCodeDecorator.loggerLink.impl;

import SourceCodeDecorator.loggerLink.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LoggerLinkFactoryImpl extends EFactoryImpl implements LoggerLinkFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static LoggerLinkFactory init() {
		try {
			LoggerLinkFactory theLoggerLinkFactory = (LoggerLinkFactory)EPackage.Registry.INSTANCE.getEFactory("http:///SourceCodeDecorator/loggerLink.ecore"); 
			if (theLoggerLinkFactory != null) {
				return theLoggerLinkFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new LoggerLinkFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoggerLinkFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case LoggerLinkPackage.LOGGING_POSITION_ID: return createLoggingPositionId();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoggingPositionId createLoggingPositionId() {
		LoggingPositionIdImpl loggingPositionId = new LoggingPositionIdImpl();
		return loggingPositionId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoggerLinkPackage getLoggerLinkPackage() {
		return (LoggerLinkPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static LoggerLinkPackage getPackage() {
		return LoggerLinkPackage.eINSTANCE;
	}

} //LoggerLinkFactoryImpl
