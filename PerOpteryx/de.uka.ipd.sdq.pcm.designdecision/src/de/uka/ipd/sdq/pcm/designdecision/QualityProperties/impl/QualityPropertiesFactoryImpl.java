/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.designdecision.QualityProperties.impl;

import de.uka.ipd.sdq.pcm.designdecision.QualityProperties.*;

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
public class QualityPropertiesFactoryImpl extends EFactoryImpl implements QualityPropertiesFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static QualityPropertiesFactory init() {
		try {
			QualityPropertiesFactory theQualityPropertiesFactory = (QualityPropertiesFactory)EPackage.Registry.INSTANCE.getEFactory("http:///DesignDecision/QualityProperties.ecore"); 
			if (theQualityPropertiesFactory != null) {
				return theQualityPropertiesFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new QualityPropertiesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualityPropertiesFactoryImpl() {
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
			case QualityPropertiesPackage.CONFIDENCE_INTERVAL: return createConfidenceInterval();
			case QualityPropertiesPackage.ELEMENT_QUALITY_PROPERTY: return createElementQualityProperty();
			case QualityPropertiesPackage.INTEGER_QUALITY_PROPERTY: return createIntegerQualityProperty();
			case QualityPropertiesPackage.DOUBLE_QUALITY_PROPERTY: return createDoubleQualityProperty();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfidenceInterval createConfidenceInterval() {
		ConfidenceIntervalImpl confidenceInterval = new ConfidenceIntervalImpl();
		return confidenceInterval;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementQualityProperty createElementQualityProperty() {
		ElementQualityPropertyImpl elementQualityProperty = new ElementQualityPropertyImpl();
		return elementQualityProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerQualityProperty createIntegerQualityProperty() {
		IntegerQualityPropertyImpl integerQualityProperty = new IntegerQualityPropertyImpl();
		return integerQualityProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoubleQualityProperty createDoubleQualityProperty() {
		DoubleQualityPropertyImpl doubleQualityProperty = new DoubleQualityPropertyImpl();
		return doubleQualityProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualityPropertiesPackage getQualityPropertiesPackage() {
		return (QualityPropertiesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static QualityPropertiesPackage getPackage() {
		return QualityPropertiesPackage.eINSTANCE;
	}

} //QualityPropertiesFactoryImpl
