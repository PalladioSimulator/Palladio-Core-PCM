/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl;

import de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.*;

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
public class LoggerlinkFactoryImpl extends EFactoryImpl implements LoggerlinkFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static LoggerlinkFactory init() {
		try {
			LoggerlinkFactory theLoggerlinkFactory = (LoggerlinkFactory)EPackage.Registry.INSTANCE.getEFactory("http:///SourceCodeDecorator/loggerLink.ecore"); 
			if (theLoggerlinkFactory != null) {
				return theLoggerlinkFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new LoggerlinkFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoggerlinkFactoryImpl() {
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
			case LoggerlinkPackage.BEFORE_RETURN_VALUE_LOGGING_POSITION_LINK: return createBeforeReturnValueLoggingPositionLink();
			case LoggerlinkPackage.BEFORE_EXTERNAL_CALL_LOGGING_POSITION_LINK: return createBeforeExternalCallLoggingPositionLink();
			case LoggerlinkPackage.METHOD_CALL_LOGGING_POSITION_LINK: return createMethodCallLoggingPositionLink();
			case LoggerlinkPackage.AFTER_EXTERNAL_CALL_LOGGING_POSITION_LINK: return createAfterExternalCallLoggingPositionLink();
			case LoggerlinkPackage.BRANCH_LOGGING_POSITION_LINK: return createBranchLoggingPositionLink();
			case LoggerlinkPackage.LOOP_LOGGING_POSITION_LINK: return createLoopLoggingPositionLink();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BeforeReturnValueLoggingPositionLink createBeforeReturnValueLoggingPositionLink() {
		BeforeReturnValueLoggingPositionLinkImpl beforeReturnValueLoggingPositionLink = new BeforeReturnValueLoggingPositionLinkImpl();
		return beforeReturnValueLoggingPositionLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BeforeExternalCallLoggingPositionLink createBeforeExternalCallLoggingPositionLink() {
		BeforeExternalCallLoggingPositionLinkImpl beforeExternalCallLoggingPositionLink = new BeforeExternalCallLoggingPositionLinkImpl();
		return beforeExternalCallLoggingPositionLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MethodCallLoggingPositionLink createMethodCallLoggingPositionLink() {
		MethodCallLoggingPositionLinkImpl methodCallLoggingPositionLink = new MethodCallLoggingPositionLinkImpl();
		return methodCallLoggingPositionLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AfterExternalCallLoggingPositionLink createAfterExternalCallLoggingPositionLink() {
		AfterExternalCallLoggingPositionLinkImpl afterExternalCallLoggingPositionLink = new AfterExternalCallLoggingPositionLinkImpl();
		return afterExternalCallLoggingPositionLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BranchLoggingPositionLink createBranchLoggingPositionLink() {
		BranchLoggingPositionLinkImpl branchLoggingPositionLink = new BranchLoggingPositionLinkImpl();
		return branchLoggingPositionLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoopLoggingPositionLink createLoopLoggingPositionLink() {
		LoopLoggingPositionLinkImpl loopLoggingPositionLink = new LoopLoggingPositionLinkImpl();
		return loopLoggingPositionLink;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoggerlinkPackage getLoggerlinkPackage() {
		return (LoggerlinkPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static LoggerlinkPackage getPackage() {
		return LoggerlinkPackage.eINSTANCE;
	}

} //LoggerlinkFactoryImpl
