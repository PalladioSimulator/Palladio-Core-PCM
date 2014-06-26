/**
 */
package de.uka.ipd.sdq.experimentautomation.variation;

import de.uka.ipd.sdq.identifier.IdentifierPackage;

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
 * @see de.uka.ipd.sdq.experimentautomation.variation.VariationFactory
 * @model kind="package"
 * @generated
 */
public interface VariationPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "variation";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/ExperimentAutomation/Variation/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ExperimentAutomation.Variation";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	VariationPackage eINSTANCE = de.uka.ipd.sdq.experimentautomation.variation.impl.VariationPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.experimentautomation.variation.impl.VariationTypeImpl <em>Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.experimentautomation.variation.impl.VariationTypeImpl
	 * @see de.uka.ipd.sdq.experimentautomation.variation.impl.VariationPackageImpl#getVariationType()
	 * @generated
	 */
	int VARIATION_TYPE = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIATION_TYPE__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIATION_TYPE__NAME = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Strategy Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIATION_TYPE__STRATEGY_CLASS = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Varied Entity Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIATION_TYPE__VARIED_ENTITY_INTERFACE = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIATION_TYPE_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.experimentautomation.variation.impl.ValueVariationImpl <em>Value Variation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.experimentautomation.variation.impl.ValueVariationImpl
	 * @see de.uka.ipd.sdq.experimentautomation.variation.impl.VariationPackageImpl#getValueVariation()
	 * @generated
	 */
	int VALUE_VARIATION = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_VARIATION__ID = VARIATION_TYPE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_VARIATION__NAME = VARIATION_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Strategy Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_VARIATION__STRATEGY_CLASS = VARIATION_TYPE__STRATEGY_CLASS;

	/**
	 * The feature id for the '<em><b>Varied Entity Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_VARIATION__VARIED_ENTITY_INTERFACE = VARIATION_TYPE__VARIED_ENTITY_INTERFACE;

	/**
	 * The number of structural features of the '<em>Value Variation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VALUE_VARIATION_FEATURE_COUNT = VARIATION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.experimentautomation.variation.impl.StructuralVariationImpl <em>Structural Variation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.experimentautomation.variation.impl.StructuralVariationImpl
	 * @see de.uka.ipd.sdq.experimentautomation.variation.impl.VariationPackageImpl#getStructuralVariation()
	 * @generated
	 */
	int STRUCTURAL_VARIATION = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_VARIATION__ID = VARIATION_TYPE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_VARIATION__NAME = VARIATION_TYPE__NAME;

	/**
	 * The feature id for the '<em><b>Strategy Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_VARIATION__STRATEGY_CLASS = VARIATION_TYPE__STRATEGY_CLASS;

	/**
	 * The feature id for the '<em><b>Varied Entity Interface</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_VARIATION__VARIED_ENTITY_INTERFACE = VARIATION_TYPE__VARIED_ENTITY_INTERFACE;

	/**
	 * The number of structural features of the '<em>Structural Variation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCTURAL_VARIATION_FEATURE_COUNT = VARIATION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.experimentautomation.variation.impl.VariationRepositoryImpl <em>Repository</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.experimentautomation.variation.impl.VariationRepositoryImpl
	 * @see de.uka.ipd.sdq.experimentautomation.variation.impl.VariationPackageImpl#getVariationRepository()
	 * @generated
	 */
	int VARIATION_REPOSITORY = 3;

	/**
	 * The feature id for the '<em><b>Variation</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIATION_REPOSITORY__VARIATION = 0;

	/**
	 * The number of structural features of the '<em>Repository</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIATION_REPOSITORY_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.experimentautomation.variation.VariationType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.variation.VariationType
	 * @generated
	 */
	EClass getVariationType();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.experimentautomation.variation.VariationType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.variation.VariationType#getName()
	 * @see #getVariationType()
	 * @generated
	 */
	EAttribute getVariationType_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.experimentautomation.variation.VariationType#getStrategyClass <em>Strategy Class</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Strategy Class</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.variation.VariationType#getStrategyClass()
	 * @see #getVariationType()
	 * @generated
	 */
	EAttribute getVariationType_StrategyClass();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.experimentautomation.variation.VariationType#getVariedEntityInterface <em>Varied Entity Interface</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Varied Entity Interface</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.variation.VariationType#getVariedEntityInterface()
	 * @see #getVariationType()
	 * @generated
	 */
	EAttribute getVariationType_VariedEntityInterface();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.experimentautomation.variation.ValueVariation <em>Value Variation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Value Variation</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.variation.ValueVariation
	 * @generated
	 */
	EClass getValueVariation();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.experimentautomation.variation.StructuralVariation <em>Structural Variation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Structural Variation</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.variation.StructuralVariation
	 * @generated
	 */
	EClass getStructuralVariation();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.experimentautomation.variation.VariationRepository <em>Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Repository</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.variation.VariationRepository
	 * @generated
	 */
	EClass getVariationRepository();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.experimentautomation.variation.VariationRepository#getVariation <em>Variation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variation</em>'.
	 * @see de.uka.ipd.sdq.experimentautomation.variation.VariationRepository#getVariation()
	 * @see #getVariationRepository()
	 * @generated
	 */
	EReference getVariationRepository_Variation();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	VariationFactory getVariationFactory();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.experimentautomation.variation.impl.VariationTypeImpl <em>Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.experimentautomation.variation.impl.VariationTypeImpl
		 * @see de.uka.ipd.sdq.experimentautomation.variation.impl.VariationPackageImpl#getVariationType()
		 * @generated
		 */
		EClass VARIATION_TYPE = eINSTANCE.getVariationType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIATION_TYPE__NAME = eINSTANCE.getVariationType_Name();

		/**
		 * The meta object literal for the '<em><b>Strategy Class</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIATION_TYPE__STRATEGY_CLASS = eINSTANCE.getVariationType_StrategyClass();

		/**
		 * The meta object literal for the '<em><b>Varied Entity Interface</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIATION_TYPE__VARIED_ENTITY_INTERFACE = eINSTANCE.getVariationType_VariedEntityInterface();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.experimentautomation.variation.impl.ValueVariationImpl <em>Value Variation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.experimentautomation.variation.impl.ValueVariationImpl
		 * @see de.uka.ipd.sdq.experimentautomation.variation.impl.VariationPackageImpl#getValueVariation()
		 * @generated
		 */
		EClass VALUE_VARIATION = eINSTANCE.getValueVariation();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.experimentautomation.variation.impl.StructuralVariationImpl <em>Structural Variation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.experimentautomation.variation.impl.StructuralVariationImpl
		 * @see de.uka.ipd.sdq.experimentautomation.variation.impl.VariationPackageImpl#getStructuralVariation()
		 * @generated
		 */
		EClass STRUCTURAL_VARIATION = eINSTANCE.getStructuralVariation();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.experimentautomation.variation.impl.VariationRepositoryImpl <em>Repository</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.experimentautomation.variation.impl.VariationRepositoryImpl
		 * @see de.uka.ipd.sdq.experimentautomation.variation.impl.VariationPackageImpl#getVariationRepository()
		 * @generated
		 */
		EClass VARIATION_REPOSITORY = eINSTANCE.getVariationRepository();

		/**
		 * The meta object literal for the '<em><b>Variation</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIATION_REPOSITORY__VARIATION = eINSTANCE.getVariationRepository_Variation();

	}

} //VariationPackage
