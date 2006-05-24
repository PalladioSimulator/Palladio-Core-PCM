/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package AnnotationPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

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
 * @see AnnotationPackage.AnnotationPackageFactory
 * @model kind="package"
 * @generated
 */
public interface AnnotationPackagePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "AnnotationPackage";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/AnnotationPackage";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "AnnotationPackage";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AnnotationPackagePackage eINSTANCE = AnnotationPackage.impl.AnnotationPackagePackageImpl.init();

	/**
	 * The meta object id for the '{@link AnnotationPackage.impl.AnnotationImpl <em>Annotation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see AnnotationPackage.impl.AnnotationImpl
	 * @see AnnotationPackage.impl.AnnotationPackagePackageImpl#getAnnotation()
	 * @generated
	 */
	int ANNOTATION = 0;

	/**
	 * The feature id for the '<em><b>Annotation Type ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__ANNOTATION_TYPE_ID = 0;

	/**
	 * The feature id for the '<em><b>Is Calculated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION__IS_CALCULATED = 1;

	/**
	 * The number of structural features of the '<em>Annotation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANNOTATION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link AnnotationPackage.AnnotationType <em>Annotation Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see AnnotationPackage.AnnotationType
	 * @see AnnotationPackage.impl.AnnotationPackagePackageImpl#getAnnotationType()
	 * @generated
	 */
	int ANNOTATION_TYPE = 1;


	/**
	 * Returns the meta object for class '{@link AnnotationPackage.Annotation <em>Annotation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Annotation</em>'.
	 * @see AnnotationPackage.Annotation
	 * @generated
	 */
	EClass getAnnotation();

	/**
	 * Returns the meta object for the attribute '{@link AnnotationPackage.Annotation#getAnnotationTypeID <em>Annotation Type ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Annotation Type ID</em>'.
	 * @see AnnotationPackage.Annotation#getAnnotationTypeID()
	 * @see #getAnnotation()
	 * @generated
	 */
	EAttribute getAnnotation_AnnotationTypeID();

	/**
	 * Returns the meta object for the attribute '{@link AnnotationPackage.Annotation#isIsCalculated <em>Is Calculated</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Calculated</em>'.
	 * @see AnnotationPackage.Annotation#isIsCalculated()
	 * @see #getAnnotation()
	 * @generated
	 */
	EAttribute getAnnotation_IsCalculated();

	/**
	 * Returns the meta object for enum '{@link AnnotationPackage.AnnotationType <em>Annotation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Annotation Type</em>'.
	 * @see AnnotationPackage.AnnotationType
	 * @generated
	 */
	EEnum getAnnotationType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AnnotationPackageFactory getAnnotationPackageFactory();

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
		 * The meta object literal for the '{@link AnnotationPackage.impl.AnnotationImpl <em>Annotation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see AnnotationPackage.impl.AnnotationImpl
		 * @see AnnotationPackage.impl.AnnotationPackagePackageImpl#getAnnotation()
		 * @generated
		 */
		EClass ANNOTATION = eINSTANCE.getAnnotation();

		/**
		 * The meta object literal for the '<em><b>Annotation Type ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANNOTATION__ANNOTATION_TYPE_ID = eINSTANCE.getAnnotation_AnnotationTypeID();

		/**
		 * The meta object literal for the '<em><b>Is Calculated</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANNOTATION__IS_CALCULATED = eINSTANCE.getAnnotation_IsCalculated();

		/**
		 * The meta object literal for the '{@link AnnotationPackage.AnnotationType <em>Annotation Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see AnnotationPackage.AnnotationType
		 * @see AnnotationPackage.impl.AnnotationPackagePackageImpl#getAnnotationType()
		 * @generated
		 */
		EEnum ANNOTATION_TYPE = eINSTANCE.getAnnotationType();

	}

} //AnnotationPackagePackage
