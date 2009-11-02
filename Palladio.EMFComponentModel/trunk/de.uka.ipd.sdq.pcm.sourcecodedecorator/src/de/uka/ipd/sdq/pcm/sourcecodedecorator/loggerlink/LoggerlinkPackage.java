/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink;

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
 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggerlinkFactory
 * @model kind="package"
 * @generated
 */
public interface LoggerlinkPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "loggerlink";

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
	LoggerlinkPackage eINSTANCE = de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.LoggerlinkPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.LoggingPositionIdLinkImpl <em>Logging Position Id Link</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.LoggingPositionIdLinkImpl
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.LoggerlinkPackageImpl#getLoggingPositionIdLink()
	 * @generated
	 */
	int LOGGING_POSITION_ID_LINK = 0;

	/**
	 * The feature id for the '<em><b>Logging Position Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGGING_POSITION_ID_LINK__LOGGING_POSITION_ID = 0;

	/**
	 * The feature id for the '<em><b>Is Input Position</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGGING_POSITION_ID_LINK__IS_INPUT_POSITION = 1;

	/**
	 * The feature id for the '<em><b>Service Effect Specification</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGGING_POSITION_ID_LINK__SERVICE_EFFECT_SPECIFICATION = 2;

	/**
	 * The feature id for the '<em><b>Abstract Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGGING_POSITION_ID_LINK__ABSTRACT_ACTION = 3;

	/**
	 * The number of structural features of the '<em>Logging Position Id Link</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGGING_POSITION_ID_LINK_FEATURE_COUNT = 4;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggingPositionIdLink <em>Logging Position Id Link</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Logging Position Id Link</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggingPositionIdLink
	 * @generated
	 */
	EClass getLoggingPositionIdLink();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggingPositionIdLink#getLoggingPositionId <em>Logging Position Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Logging Position Id</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggingPositionIdLink#getLoggingPositionId()
	 * @see #getLoggingPositionIdLink()
	 * @generated
	 */
	EAttribute getLoggingPositionIdLink_LoggingPositionId();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggingPositionIdLink#isIsInputPosition <em>Is Input Position</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Input Position</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggingPositionIdLink#isIsInputPosition()
	 * @see #getLoggingPositionIdLink()
	 * @generated
	 */
	EAttribute getLoggingPositionIdLink_IsInputPosition();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggingPositionIdLink#getServiceEffectSpecification <em>Service Effect Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Service Effect Specification</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggingPositionIdLink#getServiceEffectSpecification()
	 * @see #getLoggingPositionIdLink()
	 * @generated
	 */
	EReference getLoggingPositionIdLink_ServiceEffectSpecification();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggingPositionIdLink#getAbstractAction <em>Abstract Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Abstract Action</em>'.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggingPositionIdLink#getAbstractAction()
	 * @see #getLoggingPositionIdLink()
	 * @generated
	 */
	EReference getLoggingPositionIdLink_AbstractAction();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	LoggerlinkFactory getLoggerlinkFactory();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.LoggingPositionIdLinkImpl <em>Logging Position Id Link</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.LoggingPositionIdLinkImpl
		 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.impl.LoggerlinkPackageImpl#getLoggingPositionIdLink()
		 * @generated
		 */
		EClass LOGGING_POSITION_ID_LINK = eINSTANCE.getLoggingPositionIdLink();

		/**
		 * The meta object literal for the '<em><b>Logging Position Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOGGING_POSITION_ID_LINK__LOGGING_POSITION_ID = eINSTANCE.getLoggingPositionIdLink_LoggingPositionId();

		/**
		 * The meta object literal for the '<em><b>Is Input Position</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOGGING_POSITION_ID_LINK__IS_INPUT_POSITION = eINSTANCE.getLoggingPositionIdLink_IsInputPosition();

		/**
		 * The meta object literal for the '<em><b>Service Effect Specification</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOGGING_POSITION_ID_LINK__SERVICE_EFFECT_SPECIFICATION = eINSTANCE.getLoggingPositionIdLink_ServiceEffectSpecification();

		/**
		 * The meta object literal for the '<em><b>Abstract Action</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOGGING_POSITION_ID_LINK__ABSTRACT_ACTION = eINSTANCE.getLoggingPositionIdLink_AbstractAction();

	}

} //LoggerlinkPackage
