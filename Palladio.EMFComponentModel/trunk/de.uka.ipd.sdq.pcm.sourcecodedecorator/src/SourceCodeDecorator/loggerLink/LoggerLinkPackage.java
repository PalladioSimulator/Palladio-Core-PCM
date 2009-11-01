/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package SourceCodeDecorator.loggerLink;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see SourceCodeDecorator.loggerLink.LoggerLinkFactory
 * @model kind="package"
 * @generated
 */
public interface LoggerLinkPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "loggerLink";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///SourceCodeDecorator/loggerLink.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "SourceCodeDecorator.loggerLink";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	LoggerLinkPackage eINSTANCE = SourceCodeDecorator.loggerLink.impl.LoggerLinkPackageImpl.init();

	/**
	 * The meta object id for the '{@link SourceCodeDecorator.loggerLink.impl.LoggingPositionIdImpl <em>Logging Position Id</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see SourceCodeDecorator.loggerLink.impl.LoggingPositionIdImpl
	 * @see SourceCodeDecorator.loggerLink.impl.LoggerLinkPackageImpl#getLoggingPositionId()
	 * @generated
	 */
	int LOGGING_POSITION_ID = 0;

	/**
	 * The feature id for the '<em><b>Logging Position Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGGING_POSITION_ID__LOGGING_POSITION_ID = 0;

	/**
	 * The feature id for the '<em><b>Service Effect Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGGING_POSITION_ID__SERVICE_EFFECT_SPECIFICATION = 1;

	/**
	 * The feature id for the '<em><b>Abstract Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGGING_POSITION_ID__ABSTRACT_ACTION = 2;

	/**
	 * The number of structural features of the '<em>Logging Position Id</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGGING_POSITION_ID_FEATURE_COUNT = 3;


	/**
	 * Returns the meta object for class '{@link SourceCodeDecorator.loggerLink.LoggingPositionId <em>Logging Position Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Logging Position Id</em>'.
	 * @see SourceCodeDecorator.loggerLink.LoggingPositionId
	 * @generated
	 */
	EClass getLoggingPositionId();

	/**
	 * Returns the meta object for the attribute '{@link SourceCodeDecorator.loggerLink.LoggingPositionId#getLoggingPositionId <em>Logging Position Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Logging Position Id</em>'.
	 * @see SourceCodeDecorator.loggerLink.LoggingPositionId#getLoggingPositionId()
	 * @see #getLoggingPositionId()
	 * @generated
	 */
	EAttribute getLoggingPositionId_LoggingPositionId();

	/**
	 * Returns the meta object for the reference '{@link SourceCodeDecorator.loggerLink.LoggingPositionId#getServiceEffectSpecification <em>Service Effect Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Service Effect Specification</em>'.
	 * @see SourceCodeDecorator.loggerLink.LoggingPositionId#getServiceEffectSpecification()
	 * @see #getLoggingPositionId()
	 * @generated
	 */
	EReference getLoggingPositionId_ServiceEffectSpecification();

	/**
	 * Returns the meta object for the reference '{@link SourceCodeDecorator.loggerLink.LoggingPositionId#getAbstractAction <em>Abstract Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Abstract Action</em>'.
	 * @see SourceCodeDecorator.loggerLink.LoggingPositionId#getAbstractAction()
	 * @see #getLoggingPositionId()
	 * @generated
	 */
	EReference getLoggingPositionId_AbstractAction();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	LoggerLinkFactory getLoggerLinkFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link SourceCodeDecorator.loggerLink.impl.LoggingPositionIdImpl <em>Logging Position Id</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see SourceCodeDecorator.loggerLink.impl.LoggingPositionIdImpl
		 * @see SourceCodeDecorator.loggerLink.impl.LoggerLinkPackageImpl#getLoggingPositionId()
		 * @generated
		 */
		EClass LOGGING_POSITION_ID = eINSTANCE.getLoggingPositionId();

		/**
		 * The meta object literal for the '<em><b>Logging Position Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOGGING_POSITION_ID__LOGGING_POSITION_ID = eINSTANCE.getLoggingPositionId_LoggingPositionId();

		/**
		 * The meta object literal for the '<em><b>Service Effect Specification</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOGGING_POSITION_ID__SERVICE_EFFECT_SPECIFICATION = eINSTANCE.getLoggingPositionId_ServiceEffectSpecification();

		/**
		 * The meta object literal for the '<em><b>Abstract Action</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOGGING_POSITION_ID__ABSTRACT_ACTION = eINSTANCE.getLoggingPositionId_AbstractAction();

	}

} //LoggerLinkPackage
