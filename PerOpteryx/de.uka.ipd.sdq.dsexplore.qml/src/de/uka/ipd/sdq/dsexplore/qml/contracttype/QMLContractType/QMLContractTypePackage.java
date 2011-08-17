/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType;

import de.uka.ipd.sdq.dsexplore.qml.declarations.QMLDeclarations.QMLDeclarationsPackage;

import de.uka.ipd.sdq.identifier.IdentifierPackage;

import de.uka.ipd.sdq.pcm.core.entity.EntityPackage;

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
 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.QMLContractTypeFactory
 * @model kind="package"
 * @generated
 */
public interface QMLContractTypePackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "QMLContractType";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http:///QMLContractType.ecore";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "QMLContractType";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	QMLContractTypePackage eINSTANCE = de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.QMLContractTypePackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.DimensionTypeImpl <em>Dimension Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.DimensionTypeImpl
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.QMLContractTypePackageImpl#getDimensionType()
	 * @generated
	 */
	int DIMENSION_TYPE = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION_TYPE__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The feature id for the '<em><b>Relation Semantics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION_TYPE__RELATION_SEMANTICS = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Dimension Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION_TYPE_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.DimensionTypeSetImpl <em>Dimension Type Set</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.DimensionTypeSetImpl
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.QMLContractTypePackageImpl#getDimensionTypeSet()
	 * @generated
	 */
	int DIMENSION_TYPE_SET = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION_TYPE_SET__ID = DIMENSION_TYPE__ID;

	/**
	 * The feature id for the '<em><b>Relation Semantics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION_TYPE_SET__RELATION_SEMANTICS = DIMENSION_TYPE__RELATION_SEMANTICS;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION_TYPE_SET__ELEMENTS = DIMENSION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Order</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION_TYPE_SET__ORDER = DIMENSION_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Dimension Type Set</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION_TYPE_SET_FEATURE_COUNT = DIMENSION_TYPE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.RelationSemanticsImpl <em>Relation Semantics</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.RelationSemanticsImpl
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.QMLContractTypePackageImpl#getRelationSemantics()
	 * @generated
	 */
	int RELATION_SEMANTICS = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_SEMANTICS__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The feature id for the '<em><b>Rel Sem</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_SEMANTICS__REL_SEM = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Relation Semantics</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATION_SEMANTICS_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.ElementImpl <em>Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.ElementImpl
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.QMLContractTypePackageImpl#getElement()
	 * @generated
	 */
	int ELEMENT = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__ID = EntityPackage.ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT__ENTITY_NAME = EntityPackage.ENTITY__ENTITY_NAME;

	/**
	 * The number of structural features of the '<em>Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_FEATURE_COUNT = EntityPackage.ENTITY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.OrderImpl <em>Order</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.OrderImpl
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.QMLContractTypePackageImpl#getOrder()
	 * @generated
	 */
	int ORDER = 4;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The feature id for the '<em><b>Bigger Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER__BIGGER_ELEMENT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Smaller Element</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER__SMALLER_ELEMENT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Order</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.DimensionTypeEnumImpl <em>Dimension Type Enum</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.DimensionTypeEnumImpl
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.QMLContractTypePackageImpl#getDimensionTypeEnum()
	 * @generated
	 */
	int DIMENSION_TYPE_ENUM = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION_TYPE_ENUM__ID = DIMENSION_TYPE__ID;

	/**
	 * The feature id for the '<em><b>Relation Semantics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION_TYPE_ENUM__RELATION_SEMANTICS = DIMENSION_TYPE__RELATION_SEMANTICS;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION_TYPE_ENUM__ELEMENTS = DIMENSION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Order</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION_TYPE_ENUM__ORDER = DIMENSION_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Dimension Type Enum</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION_TYPE_ENUM_FEATURE_COUNT = DIMENSION_TYPE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.UnitImpl <em>Unit</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.UnitImpl
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.QMLContractTypePackageImpl#getUnit()
	 * @generated
	 */
	int UNIT = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT__ID = EntityPackage.ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT__ENTITY_NAME = EntityPackage.ENTITY__ENTITY_NAME;

	/**
	 * The number of structural features of the '<em>Unit</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_FEATURE_COUNT = EntityPackage.ENTITY_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.DimensionTypeNumericImpl <em>Dimension Type Numeric</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.DimensionTypeNumericImpl
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.QMLContractTypePackageImpl#getDimensionTypeNumeric()
	 * @generated
	 */
	int DIMENSION_TYPE_NUMERIC = 7;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION_TYPE_NUMERIC__ID = DIMENSION_TYPE__ID;

	/**
	 * The feature id for the '<em><b>Relation Semantics</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION_TYPE_NUMERIC__RELATION_SEMANTICS = DIMENSION_TYPE__RELATION_SEMANTICS;

	/**
	 * The feature id for the '<em><b>Range</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION_TYPE_NUMERIC__RANGE = DIMENSION_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Domain</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION_TYPE_NUMERIC__DOMAIN = DIMENSION_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Dimension Type Numeric</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION_TYPE_NUMERIC_FEATURE_COUNT = DIMENSION_TYPE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.NumericRangeImpl <em>Numeric Range</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.NumericRangeImpl
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.QMLContractTypePackageImpl#getNumericRange()
	 * @generated
	 */
	int NUMERIC_RANGE = 8;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_RANGE__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The feature id for the '<em><b>Lower Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_RANGE__LOWER_LIMIT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Upper Limit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_RANGE__UPPER_LIMIT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Numeric Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NUMERIC_RANGE_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.QMLContractTypeImpl <em>QML Contract Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.QMLContractTypeImpl
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.QMLContractTypePackageImpl#getQMLContractType()
	 * @generated
	 */
	int QML_CONTRACT_TYPE = 9;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QML_CONTRACT_TYPE__ID = QMLDeclarationsPackage.QML_DECLARATION__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QML_CONTRACT_TYPE__ENTITY_NAME = QMLDeclarationsPackage.QML_DECLARATION__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Dimensions</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QML_CONTRACT_TYPE__DIMENSIONS = QMLDeclarationsPackage.QML_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>QML Contract Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QML_CONTRACT_TYPE_FEATURE_COUNT = QMLDeclarationsPackage.QML_DECLARATION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.UnitRepositoryImpl <em>Unit Repository</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.UnitRepositoryImpl
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.QMLContractTypePackageImpl#getUnitRepository()
	 * @generated
	 */
	int UNIT_REPOSITORY = 10;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_REPOSITORY__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The feature id for the '<em><b>Units</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_REPOSITORY__UNITS = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Unit Repository</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_REPOSITORY_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.DimensionTypeRepositoryImpl <em>Dimension Type Repository</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.DimensionTypeRepositoryImpl
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.QMLContractTypePackageImpl#getDimensionTypeRepository()
	 * @generated
	 */
	int DIMENSION_TYPE_REPOSITORY = 11;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION_TYPE_REPOSITORY__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The feature id for the '<em><b>Dimension Types</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION_TYPE_REPOSITORY__DIMENSION_TYPES = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Dimension Type Repository</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION_TYPE_REPOSITORY_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.DimensionImpl <em>Dimension</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.DimensionImpl
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.QMLContractTypePackageImpl#getDimension()
	 * @generated
	 */
	int DIMENSION = 12;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION__ID = EntityPackage.ENTITY__ID;

	/**
	 * The feature id for the '<em><b>Entity Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION__ENTITY_NAME = EntityPackage.ENTITY__ENTITY_NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION__TYPE = EntityPackage.ENTITY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION__UNIT = EntityPackage.ENTITY_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Dimension</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIMENSION_FEATURE_COUNT = EntityPackage.ENTITY_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.EnumRelationSemantics <em>Enum Relation Semantics</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.EnumRelationSemantics
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.QMLContractTypePackageImpl#getEnumRelationSemantics()
	 * @generated
	 */
	int ENUM_RELATION_SEMANTICS = 13;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.EnumNumericDomain <em>Enum Numeric Domain</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.EnumNumericDomain
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.QMLContractTypePackageImpl#getEnumNumericDomain()
	 * @generated
	 */
	int ENUM_NUMERIC_DOMAIN = 14;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.DimensionTypeSet <em>Dimension Type Set</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dimension Type Set</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.DimensionTypeSet
	 * @generated
	 */
	EClass getDimensionTypeSet();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.DimensionTypeSet#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.DimensionTypeSet#getElements()
	 * @see #getDimensionTypeSet()
	 * @generated
	 */
	EReference getDimensionTypeSet_Elements();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.DimensionTypeSet#getOrder <em>Order</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Order</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.DimensionTypeSet#getOrder()
	 * @see #getDimensionTypeSet()
	 * @generated
	 */
	EReference getDimensionTypeSet_Order();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.DimensionType <em>Dimension Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dimension Type</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.DimensionType
	 * @generated
	 */
	EClass getDimensionType();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.DimensionType#getRelationSemantics <em>Relation Semantics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Relation Semantics</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.DimensionType#getRelationSemantics()
	 * @see #getDimensionType()
	 * @generated
	 */
	EReference getDimensionType_RelationSemantics();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.RelationSemantics <em>Relation Semantics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relation Semantics</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.RelationSemantics
	 * @generated
	 */
	EClass getRelationSemantics();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.RelationSemantics#getRelSem <em>Rel Sem</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Rel Sem</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.RelationSemantics#getRelSem()
	 * @see #getRelationSemantics()
	 * @generated
	 */
	EAttribute getRelationSemantics_RelSem();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.Element <em>Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.Element
	 * @generated
	 */
	EClass getElement();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.Order <em>Order</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Order</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.Order
	 * @generated
	 */
	EClass getOrder();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.Order#getBiggerElement <em>Bigger Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Bigger Element</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.Order#getBiggerElement()
	 * @see #getOrder()
	 * @generated
	 */
	EReference getOrder_BiggerElement();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.Order#getSmallerElement <em>Smaller Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Smaller Element</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.Order#getSmallerElement()
	 * @see #getOrder()
	 * @generated
	 */
	EReference getOrder_SmallerElement();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.DimensionTypeEnum <em>Dimension Type Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dimension Type Enum</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.DimensionTypeEnum
	 * @generated
	 */
	EClass getDimensionTypeEnum();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.DimensionTypeEnum#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.DimensionTypeEnum#getElements()
	 * @see #getDimensionTypeEnum()
	 * @generated
	 */
	EReference getDimensionTypeEnum_Elements();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.DimensionTypeEnum#getOrder <em>Order</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Order</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.DimensionTypeEnum#getOrder()
	 * @see #getDimensionTypeEnum()
	 * @generated
	 */
	EReference getDimensionTypeEnum_Order();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.Unit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unit</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.Unit
	 * @generated
	 */
	EClass getUnit();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.DimensionTypeNumeric <em>Dimension Type Numeric</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dimension Type Numeric</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.DimensionTypeNumeric
	 * @generated
	 */
	EClass getDimensionTypeNumeric();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.DimensionTypeNumeric#getRange <em>Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Range</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.DimensionTypeNumeric#getRange()
	 * @see #getDimensionTypeNumeric()
	 * @generated
	 */
	EReference getDimensionTypeNumeric_Range();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.DimensionTypeNumeric#getDomain <em>Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Domain</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.DimensionTypeNumeric#getDomain()
	 * @see #getDimensionTypeNumeric()
	 * @generated
	 */
	EAttribute getDimensionTypeNumeric_Domain();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.NumericRange <em>Numeric Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Numeric Range</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.NumericRange
	 * @generated
	 */
	EClass getNumericRange();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.NumericRange#getLowerLimit <em>Lower Limit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lower Limit</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.NumericRange#getLowerLimit()
	 * @see #getNumericRange()
	 * @generated
	 */
	EAttribute getNumericRange_LowerLimit();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.NumericRange#getUpperLimit <em>Upper Limit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Upper Limit</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.NumericRange#getUpperLimit()
	 * @see #getNumericRange()
	 * @generated
	 */
	EAttribute getNumericRange_UpperLimit();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.QMLContractType <em>QML Contract Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>QML Contract Type</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.QMLContractType
	 * @generated
	 */
	EClass getQMLContractType();

	/**
	 * Returns the meta object for the reference list '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.QMLContractType#getDimensions <em>Dimensions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Dimensions</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.QMLContractType#getDimensions()
	 * @see #getQMLContractType()
	 * @generated
	 */
	EReference getQMLContractType_Dimensions();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.UnitRepository <em>Unit Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unit Repository</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.UnitRepository
	 * @generated
	 */
	EClass getUnitRepository();

	/**
	 * Returns the meta object for the reference list '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.UnitRepository#getUnits <em>Units</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Units</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.UnitRepository#getUnits()
	 * @see #getUnitRepository()
	 * @generated
	 */
	EReference getUnitRepository_Units();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.DimensionTypeRepository <em>Dimension Type Repository</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dimension Type Repository</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.DimensionTypeRepository
	 * @generated
	 */
	EClass getDimensionTypeRepository();

	/**
	 * Returns the meta object for the reference list '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.DimensionTypeRepository#getDimensionTypes <em>Dimension Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Dimension Types</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.DimensionTypeRepository#getDimensionTypes()
	 * @see #getDimensionTypeRepository()
	 * @generated
	 */
	EReference getDimensionTypeRepository_DimensionTypes();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.Dimension <em>Dimension</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Dimension</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.Dimension
	 * @generated
	 */
	EClass getDimension();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.Dimension#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.Dimension#getType()
	 * @see #getDimension()
	 * @generated
	 */
	EReference getDimension_Type();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.Dimension#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.Dimension#getUnit()
	 * @see #getDimension()
	 * @generated
	 */
	EReference getDimension_Unit();

	/**
	 * Returns the meta object for enum '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.EnumRelationSemantics <em>Enum Relation Semantics</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Enum Relation Semantics</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.EnumRelationSemantics
	 * @generated
	 */
	EEnum getEnumRelationSemantics();

	/**
	 * Returns the meta object for enum '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.EnumNumericDomain <em>Enum Numeric Domain</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Enum Numeric Domain</em>'.
	 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.EnumNumericDomain
	 * @generated
	 */
	EEnum getEnumNumericDomain();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	QMLContractTypeFactory getQMLContractTypeFactory();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.DimensionTypeSetImpl <em>Dimension Type Set</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.DimensionTypeSetImpl
		 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.QMLContractTypePackageImpl#getDimensionTypeSet()
		 * @generated
		 */
		EClass DIMENSION_TYPE_SET = eINSTANCE.getDimensionTypeSet();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIMENSION_TYPE_SET__ELEMENTS = eINSTANCE.getDimensionTypeSet_Elements();

		/**
		 * The meta object literal for the '<em><b>Order</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIMENSION_TYPE_SET__ORDER = eINSTANCE.getDimensionTypeSet_Order();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.DimensionTypeImpl <em>Dimension Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.DimensionTypeImpl
		 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.QMLContractTypePackageImpl#getDimensionType()
		 * @generated
		 */
		EClass DIMENSION_TYPE = eINSTANCE.getDimensionType();

		/**
		 * The meta object literal for the '<em><b>Relation Semantics</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIMENSION_TYPE__RELATION_SEMANTICS = eINSTANCE.getDimensionType_RelationSemantics();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.RelationSemanticsImpl <em>Relation Semantics</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.RelationSemanticsImpl
		 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.QMLContractTypePackageImpl#getRelationSemantics()
		 * @generated
		 */
		EClass RELATION_SEMANTICS = eINSTANCE.getRelationSemantics();

		/**
		 * The meta object literal for the '<em><b>Rel Sem</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELATION_SEMANTICS__REL_SEM = eINSTANCE.getRelationSemantics_RelSem();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.ElementImpl <em>Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.ElementImpl
		 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.QMLContractTypePackageImpl#getElement()
		 * @generated
		 */
		EClass ELEMENT = eINSTANCE.getElement();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.OrderImpl <em>Order</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.OrderImpl
		 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.QMLContractTypePackageImpl#getOrder()
		 * @generated
		 */
		EClass ORDER = eINSTANCE.getOrder();

		/**
		 * The meta object literal for the '<em><b>Bigger Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ORDER__BIGGER_ELEMENT = eINSTANCE.getOrder_BiggerElement();

		/**
		 * The meta object literal for the '<em><b>Smaller Element</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ORDER__SMALLER_ELEMENT = eINSTANCE.getOrder_SmallerElement();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.DimensionTypeEnumImpl <em>Dimension Type Enum</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.DimensionTypeEnumImpl
		 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.QMLContractTypePackageImpl#getDimensionTypeEnum()
		 * @generated
		 */
		EClass DIMENSION_TYPE_ENUM = eINSTANCE.getDimensionTypeEnum();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIMENSION_TYPE_ENUM__ELEMENTS = eINSTANCE.getDimensionTypeEnum_Elements();

		/**
		 * The meta object literal for the '<em><b>Order</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIMENSION_TYPE_ENUM__ORDER = eINSTANCE.getDimensionTypeEnum_Order();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.UnitImpl <em>Unit</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.UnitImpl
		 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.QMLContractTypePackageImpl#getUnit()
		 * @generated
		 */
		EClass UNIT = eINSTANCE.getUnit();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.DimensionTypeNumericImpl <em>Dimension Type Numeric</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.DimensionTypeNumericImpl
		 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.QMLContractTypePackageImpl#getDimensionTypeNumeric()
		 * @generated
		 */
		EClass DIMENSION_TYPE_NUMERIC = eINSTANCE.getDimensionTypeNumeric();

		/**
		 * The meta object literal for the '<em><b>Range</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIMENSION_TYPE_NUMERIC__RANGE = eINSTANCE.getDimensionTypeNumeric_Range();

		/**
		 * The meta object literal for the '<em><b>Domain</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIMENSION_TYPE_NUMERIC__DOMAIN = eINSTANCE.getDimensionTypeNumeric_Domain();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.NumericRangeImpl <em>Numeric Range</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.NumericRangeImpl
		 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.QMLContractTypePackageImpl#getNumericRange()
		 * @generated
		 */
		EClass NUMERIC_RANGE = eINSTANCE.getNumericRange();

		/**
		 * The meta object literal for the '<em><b>Lower Limit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUMERIC_RANGE__LOWER_LIMIT = eINSTANCE.getNumericRange_LowerLimit();

		/**
		 * The meta object literal for the '<em><b>Upper Limit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NUMERIC_RANGE__UPPER_LIMIT = eINSTANCE.getNumericRange_UpperLimit();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.QMLContractTypeImpl <em>QML Contract Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.QMLContractTypeImpl
		 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.QMLContractTypePackageImpl#getQMLContractType()
		 * @generated
		 */
		EClass QML_CONTRACT_TYPE = eINSTANCE.getQMLContractType();

		/**
		 * The meta object literal for the '<em><b>Dimensions</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference QML_CONTRACT_TYPE__DIMENSIONS = eINSTANCE.getQMLContractType_Dimensions();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.UnitRepositoryImpl <em>Unit Repository</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.UnitRepositoryImpl
		 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.QMLContractTypePackageImpl#getUnitRepository()
		 * @generated
		 */
		EClass UNIT_REPOSITORY = eINSTANCE.getUnitRepository();

		/**
		 * The meta object literal for the '<em><b>Units</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNIT_REPOSITORY__UNITS = eINSTANCE.getUnitRepository_Units();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.DimensionTypeRepositoryImpl <em>Dimension Type Repository</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.DimensionTypeRepositoryImpl
		 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.QMLContractTypePackageImpl#getDimensionTypeRepository()
		 * @generated
		 */
		EClass DIMENSION_TYPE_REPOSITORY = eINSTANCE.getDimensionTypeRepository();

		/**
		 * The meta object literal for the '<em><b>Dimension Types</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIMENSION_TYPE_REPOSITORY__DIMENSION_TYPES = eINSTANCE.getDimensionTypeRepository_DimensionTypes();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.DimensionImpl <em>Dimension</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.DimensionImpl
		 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.QMLContractTypePackageImpl#getDimension()
		 * @generated
		 */
		EClass DIMENSION = eINSTANCE.getDimension();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIMENSION__TYPE = eINSTANCE.getDimension_Type();

		/**
		 * The meta object literal for the '<em><b>Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIMENSION__UNIT = eINSTANCE.getDimension_Unit();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.EnumRelationSemantics <em>Enum Relation Semantics</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.EnumRelationSemantics
		 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.QMLContractTypePackageImpl#getEnumRelationSemantics()
		 * @generated
		 */
		EEnum ENUM_RELATION_SEMANTICS = eINSTANCE.getEnumRelationSemantics();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.EnumNumericDomain <em>Enum Numeric Domain</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.EnumNumericDomain
		 * @see de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.impl.QMLContractTypePackageImpl#getEnumNumericDomain()
		 * @generated
		 */
		EEnum ENUM_NUMERIC_DOMAIN = eINSTANCE.getEnumNumericDomain();

	}

} //QMLContractTypePackage
