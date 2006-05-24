/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package AnnotationPackage.impl;

import AnnotationPackage.Annotation;
import AnnotationPackage.AnnotationPackageFactory;
import AnnotationPackage.AnnotationPackagePackage;
import AnnotationPackage.AnnotationType;

import AnnotationPackage.DefaultAnnotationDataTypes.DefaultAnnotationDataTypesPackage;

import AnnotationPackage.DefaultAnnotationDataTypes.impl.DefaultAnnotationDataTypesPackageImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AnnotationPackagePackageImpl extends EPackageImpl implements AnnotationPackagePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass annotationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum annotationTypeEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see AnnotationPackage.AnnotationPackagePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private AnnotationPackagePackageImpl() {
		super(eNS_URI, AnnotationPackageFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this
	 * model, and for any others upon which it depends.  Simple
	 * dependencies are satisfied by calling this method on all
	 * dependent packages before doing anything else.  This method drives
	 * initialization for interdependent packages directly, in parallel
	 * with this package, itself.
	 * <p>Of this package and its interdependencies, all packages which
	 * have not yet been registered by their URI values are first created
	 * and registered.  The packages are then initialized in two steps:
	 * meta-model objects for all of the packages are created before any
	 * are initialized, since one package's meta-model objects may refer to
	 * those of another.
	 * <p>Invocation of this method will not affect any packages that have
	 * already been initialized.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static AnnotationPackagePackage init() {
		if (isInited) return (AnnotationPackagePackage)EPackage.Registry.INSTANCE.getEPackage(AnnotationPackagePackage.eNS_URI);

		// Obtain or create and register package
		AnnotationPackagePackageImpl theAnnotationPackagePackage = (AnnotationPackagePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof AnnotationPackagePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new AnnotationPackagePackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		DefaultAnnotationDataTypesPackageImpl theDefaultAnnotationDataTypesPackage = (DefaultAnnotationDataTypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(DefaultAnnotationDataTypesPackage.eNS_URI) instanceof DefaultAnnotationDataTypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(DefaultAnnotationDataTypesPackage.eNS_URI) : DefaultAnnotationDataTypesPackage.eINSTANCE);

		// Create package meta-data objects
		theAnnotationPackagePackage.createPackageContents();
		theDefaultAnnotationDataTypesPackage.createPackageContents();

		// Initialize created meta-data
		theAnnotationPackagePackage.initializePackageContents();
		theDefaultAnnotationDataTypesPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theAnnotationPackagePackage.freeze();

		return theAnnotationPackagePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAnnotation() {
		return annotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnnotation_AnnotationTypeID() {
		return (EAttribute)annotationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAnnotation_IsCalculated() {
		return (EAttribute)annotationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAnnotationType() {
		return annotationTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnnotationPackageFactory getAnnotationPackageFactory() {
		return (AnnotationPackageFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		annotationEClass = createEClass(ANNOTATION);
		createEAttribute(annotationEClass, ANNOTATION__ANNOTATION_TYPE_ID);
		createEAttribute(annotationEClass, ANNOTATION__IS_CALCULATED);

		// Create enums
		annotationTypeEEnum = createEEnum(ANNOTATION_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		DefaultAnnotationDataTypesPackage theDefaultAnnotationDataTypesPackage = (DefaultAnnotationDataTypesPackage)EPackage.Registry.INSTANCE.getEPackage(DefaultAnnotationDataTypesPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theDefaultAnnotationDataTypesPackage);

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(annotationEClass, Annotation.class, "Annotation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAnnotation_AnnotationTypeID(), this.getAnnotationType(), "annotationTypeID", null, 1, 1, Annotation.class, !IS_TRANSIENT, !IS_VOLATILE, !IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAnnotation_IsCalculated(), ecorePackage.getEBoolean(), "isCalculated", null, 1, 1, Annotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(annotationTypeEEnum, AnnotationType.class, "AnnotationType");
		addEEnumLiteral(annotationTypeEEnum, AnnotationType.DESCRIPTION_LITERAL);

		// Create resource
		createResource(eNS_URI);
	}

} //AnnotationPackagePackageImpl
