/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package AnnotationPackage.DefaultAnnotationDataTypes.impl;

import AnnotationPackage.DefaultAnnotationDataTypes.*;

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
public class DefaultAnnotationDataTypesFactoryImpl extends EFactoryImpl implements DefaultAnnotationDataTypesFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DefaultAnnotationDataTypesFactory init() {
		try {
			DefaultAnnotationDataTypesFactory theDefaultAnnotationDataTypesFactory = (DefaultAnnotationDataTypesFactory)EPackage.Registry.INSTANCE.getEFactory("http:///AnnotationPackage/DefaultAnnotationDataTypes.ecore"); 
			if (theDefaultAnnotationDataTypesFactory != null) {
				return theDefaultAnnotationDataTypesFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DefaultAnnotationDataTypesFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefaultAnnotationDataTypesFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case DefaultAnnotationDataTypesPackage.BOOLEAN_ANNOTATION: return createBooleanAnnotation();
			case DefaultAnnotationDataTypesPackage.DOUBLE_ANNOTATION: return createDoubleAnnotation();
			case DefaultAnnotationDataTypesPackage.INTEGER_ANNOTATION: return createIntegerAnnotation();
			case DefaultAnnotationDataTypesPackage.LONG_ANNOTATION: return createLongAnnotation();
			case DefaultAnnotationDataTypesPackage.SHORT_ANNOTATION: return createShortAnnotation();
			case DefaultAnnotationDataTypesPackage.STRING_ANNOTATION: return createStringAnnotation();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanAnnotation createBooleanAnnotation() {
		BooleanAnnotationImpl booleanAnnotation = new BooleanAnnotationImpl();
		return booleanAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DoubleAnnotation createDoubleAnnotation() {
		DoubleAnnotationImpl doubleAnnotation = new DoubleAnnotationImpl();
		return doubleAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegerAnnotation createIntegerAnnotation() {
		IntegerAnnotationImpl integerAnnotation = new IntegerAnnotationImpl();
		return integerAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LongAnnotation createLongAnnotation() {
		LongAnnotationImpl longAnnotation = new LongAnnotationImpl();
		return longAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ShortAnnotation createShortAnnotation() {
		ShortAnnotationImpl shortAnnotation = new ShortAnnotationImpl();
		return shortAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StringAnnotation createStringAnnotation() {
		StringAnnotationImpl stringAnnotation = new StringAnnotationImpl();
		return stringAnnotation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefaultAnnotationDataTypesPackage getDefaultAnnotationDataTypesPackage() {
		return (DefaultAnnotationDataTypesPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static DefaultAnnotationDataTypesPackage getPackage() {
		return DefaultAnnotationDataTypesPackage.eINSTANCE;
	}

} //DefaultAnnotationDataTypesFactoryImpl
