/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.parameter;

import de.uka.ipd.sdq.pcm.core.stochastics.StochasticsPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
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
 * @see de.uka.ipd.sdq.pcm.parameter.ParameterFactory
 * @model kind="package"
 * @generated
 */
public interface ParameterPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "parameter";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/PalladioComponentModel/Parameter/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "pcm.parameter";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ParameterPackage eINSTANCE = de.uka.ipd.sdq.pcm.parameter.impl.ParameterPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.parameter.impl.PrimitiveParameterCharacterisationImpl <em>Primitive Parameter Characterisation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.parameter.impl.PrimitiveParameterCharacterisationImpl
	 * @see de.uka.ipd.sdq.pcm.parameter.impl.ParameterPackageImpl#getPrimitiveParameterCharacterisation()
	 * @generated
	 */
	int PRIMITIVE_PARAMETER_CHARACTERISATION = 0;

	/**
	 * The feature id for the '<em><b>Specification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_PARAMETER_CHARACTERISATION__SPECIFICATION = StochasticsPackage.RANDOM_VARIABLE__SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Specification Random Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_PARAMETER_CHARACTERISATION__SPECIFICATION_RANDOM_VARIABLE = StochasticsPackage.RANDOM_VARIABLE__SPECIFICATION_RANDOM_VARIABLE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_PARAMETER_CHARACTERISATION__TYPE = StochasticsPackage.RANDOM_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Primitive Parameter Characterisation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_PARAMETER_CHARACTERISATION_FEATURE_COUNT = StochasticsPackage.RANDOM_VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.parameter.impl.ParameterUsageImpl <em>Usage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.parameter.impl.ParameterUsageImpl
	 * @see de.uka.ipd.sdq.pcm.parameter.impl.ParameterPackageImpl#getParameterUsage()
	 * @generated
	 */
	int PARAMETER_USAGE = 1;

	/**
	 * The feature id for the '<em><b>Parameter Parameter Usage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_USAGE__PARAMETER_PARAMETER_USAGE = 0;

	/**
	 * The feature id for the '<em><b>Parameter Characterisation Parameter Usage</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_USAGE__PARAMETER_CHARACTERISATION_PARAMETER_USAGE = 1;

	/**
	 * The number of structural features of the '<em>Usage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_USAGE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.parameter.impl.CompositeParameterUsageImpl <em>Composite Parameter Usage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.parameter.impl.CompositeParameterUsageImpl
	 * @see de.uka.ipd.sdq.pcm.parameter.impl.ParameterPackageImpl#getCompositeParameterUsage()
	 * @generated
	 */
	int COMPOSITE_PARAMETER_USAGE = 2;

	/**
	 * The feature id for the '<em><b>Parameter Parameter Usage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_PARAMETER_USAGE__PARAMETER_PARAMETER_USAGE = PARAMETER_USAGE__PARAMETER_PARAMETER_USAGE;

	/**
	 * The feature id for the '<em><b>Parameter Characterisation Parameter Usage</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_PARAMETER_USAGE__PARAMETER_CHARACTERISATION_PARAMETER_USAGE = PARAMETER_USAGE__PARAMETER_CHARACTERISATION_PARAMETER_USAGE;

	/**
	 * The feature id for the '<em><b>Inner Parameters Parameter Usage</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_PARAMETER_USAGE__INNER_PARAMETERS_PARAMETER_USAGE = PARAMETER_USAGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Composite Parameter Usage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOSITE_PARAMETER_USAGE_FEATURE_COUNT = PARAMETER_USAGE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.parameter.impl.CollectionParameterUsageImpl <em>Collection Parameter Usage</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.parameter.impl.CollectionParameterUsageImpl
	 * @see de.uka.ipd.sdq.pcm.parameter.impl.ParameterPackageImpl#getCollectionParameterUsage()
	 * @generated
	 */
	int COLLECTION_PARAMETER_USAGE = 3;

	/**
	 * The feature id for the '<em><b>Parameter Parameter Usage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_PARAMETER_USAGE__PARAMETER_PARAMETER_USAGE = PARAMETER_USAGE__PARAMETER_PARAMETER_USAGE;

	/**
	 * The feature id for the '<em><b>Parameter Characterisation Parameter Usage</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_PARAMETER_USAGE__PARAMETER_CHARACTERISATION_PARAMETER_USAGE = PARAMETER_USAGE__PARAMETER_CHARACTERISATION_PARAMETER_USAGE;

	/**
	 * The feature id for the '<em><b>Inner Element Parameter Usage</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_PARAMETER_USAGE__INNER_ELEMENT_PARAMETER_USAGE = PARAMETER_USAGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Parameter Characterisation Collection Parameter Usage</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_PARAMETER_USAGE__PARAMETER_CHARACTERISATION_COLLECTION_PARAMETER_USAGE = PARAMETER_USAGE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Collection Parameter Usage</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_PARAMETER_USAGE_FEATURE_COUNT = PARAMETER_USAGE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.parameter.impl.CollectionParameterCharacterisationImpl <em>Collection Parameter Characterisation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.parameter.impl.CollectionParameterCharacterisationImpl
	 * @see de.uka.ipd.sdq.pcm.parameter.impl.ParameterPackageImpl#getCollectionParameterCharacterisation()
	 * @generated
	 */
	int COLLECTION_PARAMETER_CHARACTERISATION = 4;

	/**
	 * The feature id for the '<em><b>Specification</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_PARAMETER_CHARACTERISATION__SPECIFICATION = StochasticsPackage.RANDOM_VARIABLE__SPECIFICATION;

	/**
	 * The feature id for the '<em><b>Specification Random Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_PARAMETER_CHARACTERISATION__SPECIFICATION_RANDOM_VARIABLE = StochasticsPackage.RANDOM_VARIABLE__SPECIFICATION_RANDOM_VARIABLE;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_PARAMETER_CHARACTERISATION__TYPE = StochasticsPackage.RANDOM_VARIABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Collection Parameter Characterisation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTION_PARAMETER_CHARACTERISATION_FEATURE_COUNT = StochasticsPackage.RANDOM_VARIABLE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.parameter.CollectionParameterCharacterisationType <em>Collection Parameter Characterisation Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.parameter.CollectionParameterCharacterisationType
	 * @see de.uka.ipd.sdq.pcm.parameter.impl.ParameterPackageImpl#getCollectionParameterCharacterisationType()
	 * @generated
	 */
	int COLLECTION_PARAMETER_CHARACTERISATION_TYPE = 5;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.pcm.parameter.PrimitiveParameterCharacterisationType <em>Primitive Parameter Characterisation Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.pcm.parameter.PrimitiveParameterCharacterisationType
	 * @see de.uka.ipd.sdq.pcm.parameter.impl.ParameterPackageImpl#getPrimitiveParameterCharacterisationType()
	 * @generated
	 */
	int PRIMITIVE_PARAMETER_CHARACTERISATION_TYPE = 6;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.parameter.PrimitiveParameterCharacterisation <em>Primitive Parameter Characterisation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Parameter Characterisation</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.PrimitiveParameterCharacterisation
	 * @generated
	 */
	EClass getPrimitiveParameterCharacterisation();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.parameter.PrimitiveParameterCharacterisation#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.PrimitiveParameterCharacterisation#getType()
	 * @see #getPrimitiveParameterCharacterisation()
	 * @generated
	 */
	EAttribute getPrimitiveParameterCharacterisation_Type();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.parameter.ParameterUsage <em>Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Usage</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterUsage
	 * @generated
	 */
	EClass getParameterUsage();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.pcm.parameter.ParameterUsage#getParameter_ParameterUsage <em>Parameter Parameter Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Parameter Parameter Usage</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterUsage#getParameter_ParameterUsage()
	 * @see #getParameterUsage()
	 * @generated
	 */
	EReference getParameterUsage_Parameter_ParameterUsage();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.parameter.ParameterUsage#getParameterCharacterisation_ParameterUsage <em>Parameter Characterisation Parameter Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter Characterisation Parameter Usage</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterUsage#getParameterCharacterisation_ParameterUsage()
	 * @see #getParameterUsage()
	 * @generated
	 */
	EReference getParameterUsage_ParameterCharacterisation_ParameterUsage();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.parameter.CompositeParameterUsage <em>Composite Parameter Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Composite Parameter Usage</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.CompositeParameterUsage
	 * @generated
	 */
	EClass getCompositeParameterUsage();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.parameter.CompositeParameterUsage#getInnerParameters_ParameterUsage <em>Inner Parameters Parameter Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Inner Parameters Parameter Usage</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.CompositeParameterUsage#getInnerParameters_ParameterUsage()
	 * @see #getCompositeParameterUsage()
	 * @generated
	 */
	EReference getCompositeParameterUsage_InnerParameters_ParameterUsage();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.parameter.CollectionParameterUsage <em>Collection Parameter Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Parameter Usage</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.CollectionParameterUsage
	 * @generated
	 */
	EClass getCollectionParameterUsage();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.pcm.parameter.CollectionParameterUsage#getInnerElement_ParameterUsage <em>Inner Element Parameter Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Inner Element Parameter Usage</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.CollectionParameterUsage#getInnerElement_ParameterUsage()
	 * @see #getCollectionParameterUsage()
	 * @generated
	 */
	EReference getCollectionParameterUsage_InnerElement_ParameterUsage();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.pcm.parameter.CollectionParameterUsage#getParameterCharacterisation_CollectionParameterUsage <em>Parameter Characterisation Collection Parameter Usage</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameter Characterisation Collection Parameter Usage</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.CollectionParameterUsage#getParameterCharacterisation_CollectionParameterUsage()
	 * @see #getCollectionParameterUsage()
	 * @generated
	 */
	EReference getCollectionParameterUsage_ParameterCharacterisation_CollectionParameterUsage();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.pcm.parameter.CollectionParameterCharacterisation <em>Collection Parameter Characterisation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collection Parameter Characterisation</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.CollectionParameterCharacterisation
	 * @generated
	 */
	EClass getCollectionParameterCharacterisation();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.pcm.parameter.CollectionParameterCharacterisation#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.CollectionParameterCharacterisation#getType()
	 * @see #getCollectionParameterCharacterisation()
	 * @generated
	 */
	EAttribute getCollectionParameterCharacterisation_Type();

	/**
	 * Returns the meta object for enum '{@link de.uka.ipd.sdq.pcm.parameter.CollectionParameterCharacterisationType <em>Collection Parameter Characterisation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Collection Parameter Characterisation Type</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.CollectionParameterCharacterisationType
	 * @generated
	 */
	EEnum getCollectionParameterCharacterisationType();

	/**
	 * Returns the meta object for enum '{@link de.uka.ipd.sdq.pcm.parameter.PrimitiveParameterCharacterisationType <em>Primitive Parameter Characterisation Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Primitive Parameter Characterisation Type</em>'.
	 * @see de.uka.ipd.sdq.pcm.parameter.PrimitiveParameterCharacterisationType
	 * @generated
	 */
	EEnum getPrimitiveParameterCharacterisationType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ParameterFactory getParameterFactory();

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
	interface Literals  {
		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.parameter.impl.PrimitiveParameterCharacterisationImpl <em>Primitive Parameter Characterisation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.parameter.impl.PrimitiveParameterCharacterisationImpl
		 * @see de.uka.ipd.sdq.pcm.parameter.impl.ParameterPackageImpl#getPrimitiveParameterCharacterisation()
		 * @generated
		 */
		EClass PRIMITIVE_PARAMETER_CHARACTERISATION = eINSTANCE.getPrimitiveParameterCharacterisation();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PRIMITIVE_PARAMETER_CHARACTERISATION__TYPE = eINSTANCE.getPrimitiveParameterCharacterisation_Type();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.parameter.impl.ParameterUsageImpl <em>Usage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.parameter.impl.ParameterUsageImpl
		 * @see de.uka.ipd.sdq.pcm.parameter.impl.ParameterPackageImpl#getParameterUsage()
		 * @generated
		 */
		EClass PARAMETER_USAGE = eINSTANCE.getParameterUsage();

		/**
		 * The meta object literal for the '<em><b>Parameter Parameter Usage</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER_USAGE__PARAMETER_PARAMETER_USAGE = eINSTANCE.getParameterUsage_Parameter_ParameterUsage();

		/**
		 * The meta object literal for the '<em><b>Parameter Characterisation Parameter Usage</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARAMETER_USAGE__PARAMETER_CHARACTERISATION_PARAMETER_USAGE = eINSTANCE.getParameterUsage_ParameterCharacterisation_ParameterUsage();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.parameter.impl.CompositeParameterUsageImpl <em>Composite Parameter Usage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.parameter.impl.CompositeParameterUsageImpl
		 * @see de.uka.ipd.sdq.pcm.parameter.impl.ParameterPackageImpl#getCompositeParameterUsage()
		 * @generated
		 */
		EClass COMPOSITE_PARAMETER_USAGE = eINSTANCE.getCompositeParameterUsage();

		/**
		 * The meta object literal for the '<em><b>Inner Parameters Parameter Usage</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOSITE_PARAMETER_USAGE__INNER_PARAMETERS_PARAMETER_USAGE = eINSTANCE.getCompositeParameterUsage_InnerParameters_ParameterUsage();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.parameter.impl.CollectionParameterUsageImpl <em>Collection Parameter Usage</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.parameter.impl.CollectionParameterUsageImpl
		 * @see de.uka.ipd.sdq.pcm.parameter.impl.ParameterPackageImpl#getCollectionParameterUsage()
		 * @generated
		 */
		EClass COLLECTION_PARAMETER_USAGE = eINSTANCE.getCollectionParameterUsage();

		/**
		 * The meta object literal for the '<em><b>Inner Element Parameter Usage</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_PARAMETER_USAGE__INNER_ELEMENT_PARAMETER_USAGE = eINSTANCE.getCollectionParameterUsage_InnerElement_ParameterUsage();

		/**
		 * The meta object literal for the '<em><b>Parameter Characterisation Collection Parameter Usage</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTION_PARAMETER_USAGE__PARAMETER_CHARACTERISATION_COLLECTION_PARAMETER_USAGE = eINSTANCE.getCollectionParameterUsage_ParameterCharacterisation_CollectionParameterUsage();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.parameter.impl.CollectionParameterCharacterisationImpl <em>Collection Parameter Characterisation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.parameter.impl.CollectionParameterCharacterisationImpl
		 * @see de.uka.ipd.sdq.pcm.parameter.impl.ParameterPackageImpl#getCollectionParameterCharacterisation()
		 * @generated
		 */
		EClass COLLECTION_PARAMETER_CHARACTERISATION = eINSTANCE.getCollectionParameterCharacterisation();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COLLECTION_PARAMETER_CHARACTERISATION__TYPE = eINSTANCE.getCollectionParameterCharacterisation_Type();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.parameter.CollectionParameterCharacterisationType <em>Collection Parameter Characterisation Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.parameter.CollectionParameterCharacterisationType
		 * @see de.uka.ipd.sdq.pcm.parameter.impl.ParameterPackageImpl#getCollectionParameterCharacterisationType()
		 * @generated
		 */
		EEnum COLLECTION_PARAMETER_CHARACTERISATION_TYPE = eINSTANCE.getCollectionParameterCharacterisationType();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.pcm.parameter.PrimitiveParameterCharacterisationType <em>Primitive Parameter Characterisation Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.pcm.parameter.PrimitiveParameterCharacterisationType
		 * @see de.uka.ipd.sdq.pcm.parameter.impl.ParameterPackageImpl#getPrimitiveParameterCharacterisationType()
		 * @generated
		 */
		EEnum PRIMITIVE_PARAMETER_CHARACTERISATION_TYPE = eINSTANCE.getPrimitiveParameterCharacterisationType();

	}

} //ParameterPackage
