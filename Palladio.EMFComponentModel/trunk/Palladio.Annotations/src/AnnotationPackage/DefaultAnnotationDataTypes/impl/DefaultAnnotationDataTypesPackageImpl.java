/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package AnnotationPackage.DefaultAnnotationDataTypes.impl;

import AnnotationPackage.AnnotationPackagePackage;

import AnnotationPackage.DefaultAnnotationDataTypes.BooleanAnnotation;
import AnnotationPackage.DefaultAnnotationDataTypes.DefaultAnnotationDataTypesFactory;
import AnnotationPackage.DefaultAnnotationDataTypes.DefaultAnnotationDataTypesPackage;
import AnnotationPackage.DefaultAnnotationDataTypes.DoubleAnnotation;
import AnnotationPackage.DefaultAnnotationDataTypes.IntegerAnnotation;
import AnnotationPackage.DefaultAnnotationDataTypes.LongAnnotation;
import AnnotationPackage.DefaultAnnotationDataTypes.ShortAnnotation;
import AnnotationPackage.DefaultAnnotationDataTypes.StringAnnotation;

import AnnotationPackage.impl.AnnotationPackagePackageImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DefaultAnnotationDataTypesPackageImpl extends EPackageImpl implements DefaultAnnotationDataTypesPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanAnnotationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass doubleAnnotationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass integerAnnotationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass longAnnotationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass shortAnnotationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringAnnotationEClass = null;

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
	 * @see AnnotationPackage.DefaultAnnotationDataTypes.DefaultAnnotationDataTypesPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DefaultAnnotationDataTypesPackageImpl() {
		super(eNS_URI, DefaultAnnotationDataTypesFactory.eINSTANCE);
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
	public static DefaultAnnotationDataTypesPackage init() {
		if (isInited) return (DefaultAnnotationDataTypesPackage)EPackage.Registry.INSTANCE.getEPackage(DefaultAnnotationDataTypesPackage.eNS_URI);

		// Obtain or create and register package
		DefaultAnnotationDataTypesPackageImpl theDefaultAnnotationDataTypesPackage = (DefaultAnnotationDataTypesPackageImpl)(EPackage.Registry.INSTANCE.getEPackage(eNS_URI) instanceof DefaultAnnotationDataTypesPackageImpl ? EPackage.Registry.INSTANCE.getEPackage(eNS_URI) : new DefaultAnnotationDataTypesPackageImpl());

		isInited = true;

		// Obtain or create and register interdependencies
		AnnotationPackagePackageImpl theAnnotationPackagePackage = (AnnotationPackagePackageImpl)(EPackage.Registry.INSTANCE.getEPackage(AnnotationPackagePackage.eNS_URI) instanceof AnnotationPackagePackageImpl ? EPackage.Registry.INSTANCE.getEPackage(AnnotationPackagePackage.eNS_URI) : AnnotationPackagePackage.eINSTANCE);

		// Create package meta-data objects
		theDefaultAnnotationDataTypesPackage.createPackageContents();
		theAnnotationPackagePackage.createPackageContents();

		// Initialize created meta-data
		theDefaultAnnotationDataTypesPackage.initializePackageContents();
		theAnnotationPackagePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDefaultAnnotationDataTypesPackage.freeze();

		return theDefaultAnnotationDataTypesPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBooleanAnnotation() {
		return booleanAnnotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBooleanAnnotation_DataField() {
		return (EAttribute)booleanAnnotationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDoubleAnnotation() {
		return doubleAnnotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDoubleAnnotation_DataField() {
		return (EAttribute)doubleAnnotationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntegerAnnotation() {
		return integerAnnotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIntegerAnnotation_DataField() {
		return (EAttribute)integerAnnotationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLongAnnotation() {
		return longAnnotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLongAnnotation_DataField() {
		return (EAttribute)longAnnotationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getShortAnnotation() {
		return shortAnnotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getShortAnnotation_DataField() {
		return (EAttribute)shortAnnotationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringAnnotation() {
		return stringAnnotationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getStringAnnotation_DataField() {
		return (EAttribute)stringAnnotationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefaultAnnotationDataTypesFactory getDefaultAnnotationDataTypesFactory() {
		return (DefaultAnnotationDataTypesFactory)getEFactoryInstance();
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
		booleanAnnotationEClass = createEClass(BOOLEAN_ANNOTATION);
		createEAttribute(booleanAnnotationEClass, BOOLEAN_ANNOTATION__DATA_FIELD);

		doubleAnnotationEClass = createEClass(DOUBLE_ANNOTATION);
		createEAttribute(doubleAnnotationEClass, DOUBLE_ANNOTATION__DATA_FIELD);

		integerAnnotationEClass = createEClass(INTEGER_ANNOTATION);
		createEAttribute(integerAnnotationEClass, INTEGER_ANNOTATION__DATA_FIELD);

		longAnnotationEClass = createEClass(LONG_ANNOTATION);
		createEAttribute(longAnnotationEClass, LONG_ANNOTATION__DATA_FIELD);

		shortAnnotationEClass = createEClass(SHORT_ANNOTATION);
		createEAttribute(shortAnnotationEClass, SHORT_ANNOTATION__DATA_FIELD);

		stringAnnotationEClass = createEClass(STRING_ANNOTATION);
		createEAttribute(stringAnnotationEClass, STRING_ANNOTATION__DATA_FIELD);
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
		AnnotationPackagePackage theAnnotationPackagePackage = (AnnotationPackagePackage)EPackage.Registry.INSTANCE.getEPackage(AnnotationPackagePackage.eNS_URI);

		// Add supertypes to classes
		booleanAnnotationEClass.getESuperTypes().add(theAnnotationPackagePackage.getAnnotation());
		doubleAnnotationEClass.getESuperTypes().add(theAnnotationPackagePackage.getAnnotation());
		integerAnnotationEClass.getESuperTypes().add(theAnnotationPackagePackage.getAnnotation());
		longAnnotationEClass.getESuperTypes().add(theAnnotationPackagePackage.getAnnotation());
		shortAnnotationEClass.getESuperTypes().add(theAnnotationPackagePackage.getAnnotation());
		stringAnnotationEClass.getESuperTypes().add(theAnnotationPackagePackage.getAnnotation());

		// Initialize classes and features; add operations and parameters
		initEClass(booleanAnnotationEClass, BooleanAnnotation.class, "BooleanAnnotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBooleanAnnotation_DataField(), ecorePackage.getEBoolean(), "dataField", null, 1, 1, BooleanAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(doubleAnnotationEClass, DoubleAnnotation.class, "DoubleAnnotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDoubleAnnotation_DataField(), ecorePackage.getEDouble(), "dataField", null, 1, 1, DoubleAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(integerAnnotationEClass, IntegerAnnotation.class, "IntegerAnnotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIntegerAnnotation_DataField(), ecorePackage.getEInt(), "dataField", null, 1, 1, IntegerAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(longAnnotationEClass, LongAnnotation.class, "LongAnnotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLongAnnotation_DataField(), ecorePackage.getELong(), "dataField", null, 1, 1, LongAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(shortAnnotationEClass, ShortAnnotation.class, "ShortAnnotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getShortAnnotation_DataField(), ecorePackage.getEShort(), "dataField", null, 1, 1, ShortAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(stringAnnotationEClass, StringAnnotation.class, "StringAnnotation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getStringAnnotation_DataField(), ecorePackage.getEString(), "dataField", "", 1, 1, StringAnnotation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
	}

} //DefaultAnnotationDataTypesPackageImpl
