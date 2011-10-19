/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.featuremodel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import de.uka.ipd.sdq.identifier.IdentifierPackage;

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
 * @see de.uka.ipd.sdq.featuremodel.featuremodelFactory
 * @model kind="package"
 * @generated
 */
public interface featuremodelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "featuremodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.uka.de/FeatureModel/2.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "featuremodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	featuremodelPackage eINSTANCE = de.uka.ipd.sdq.featuremodel.impl.featuremodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.featuremodel.impl.NamedElementImpl <em>Named Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.featuremodel.impl.NamedElementImpl
	 * @see de.uka.ipd.sdq.featuremodel.impl.featuremodelPackageImpl#getNamedElement()
	 * @generated
	 */
	int NAMED_ELEMENT = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__ID = IdentifierPackage.IDENTIFIER__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT__NAME = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Named Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NAMED_ELEMENT_FEATURE_COUNT = IdentifierPackage.IDENTIFIER_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.featuremodel.impl.FeatureImpl <em>Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.featuremodel.impl.FeatureImpl
	 * @see de.uka.ipd.sdq.featuremodel.impl.featuremodelPackageImpl#getFeature()
	 * @generated
	 */
	int FEATURE = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__ID = NAMED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__ATTRIBUTES = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Childrelation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__CHILDRELATION = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Simple Mandatory</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__SIMPLE_MANDATORY = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Simple Optional</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__SIMPLE_OPTIONAL = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Featuregroup</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE__FEATUREGROUP = NAMED_ELEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.featuremodel.impl.AttributeImpl <em>Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.featuremodel.impl.AttributeImpl
	 * @see de.uka.ipd.sdq.featuremodel.impl.featuremodelPackageImpl#getAttribute()
	 * @generated
	 */
	int ATTRIBUTE = 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.featuremodel.impl.ChildRelationImpl <em>Child Relation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.featuremodel.impl.ChildRelationImpl
	 * @see de.uka.ipd.sdq.featuremodel.impl.featuremodelPackageImpl#getChildRelation()
	 * @generated
	 */
	int CHILD_RELATION = 4;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.featuremodel.impl.FeatureGroupImpl <em>Feature Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.featuremodel.impl.FeatureGroupImpl
	 * @see de.uka.ipd.sdq.featuremodel.impl.featuremodelPackageImpl#getFeatureGroup()
	 * @generated
	 */
	int FEATURE_GROUP = 6;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.featuremodel.impl.FeatureDiagramImpl <em>Feature Diagram</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.featuremodel.impl.FeatureDiagramImpl
	 * @see de.uka.ipd.sdq.featuremodel.impl.featuremodelPackageImpl#getFeatureDiagram()
	 * @generated
	 */
	int FEATURE_DIAGRAM = 7;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.featuremodel.impl.ConstraintImpl <em>Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.featuremodel.impl.ConstraintImpl
	 * @see de.uka.ipd.sdq.featuremodel.impl.featuremodelPackageImpl#getConstraint()
	 * @generated
	 */
	int CONSTRAINT = 8;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.featuremodel.impl.RequiredConstraintImpl <em>Required Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.featuremodel.impl.RequiredConstraintImpl
	 * @see de.uka.ipd.sdq.featuremodel.impl.featuremodelPackageImpl#getRequiredConstraint()
	 * @generated
	 */
	int REQUIRED_CONSTRAINT = 9;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.featuremodel.impl.ProhibitsConstraintImpl <em>Prohibits Constraint</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.featuremodel.impl.ProhibitsConstraintImpl
	 * @see de.uka.ipd.sdq.featuremodel.impl.featuremodelPackageImpl#getProhibitsConstraint()
	 * @generated
	 */
	int PROHIBITS_CONSTRAINT = 10;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.featuremodel.impl.SimpleImpl <em>Simple</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.featuremodel.impl.SimpleImpl
	 * @see de.uka.ipd.sdq.featuremodel.impl.featuremodelPackageImpl#getSimple()
	 * @generated
	 */
	int SIMPLE = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__ID = NAMED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Range</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE__RANGE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ATTRIBUTE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.featuremodel.impl.IntegerAttributeImpl <em>Integer Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.featuremodel.impl.IntegerAttributeImpl
	 * @see de.uka.ipd.sdq.featuremodel.impl.featuremodelPackageImpl#getIntegerAttribute()
	 * @generated
	 */
	int INTEGER_ATTRIBUTE = 13;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.featuremodel.impl.DoubleAttributeImpl <em>Double Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.featuremodel.impl.DoubleAttributeImpl
	 * @see de.uka.ipd.sdq.featuremodel.impl.featuremodelPackageImpl#getDoubleAttribute()
	 * @generated
	 */
	int DOUBLE_ATTRIBUTE = 14;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.featuremodel.impl.IntervalRangeImpl <em>Interval Range</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.featuremodel.impl.IntervalRangeImpl
	 * @see de.uka.ipd.sdq.featuremodel.impl.featuremodelPackageImpl#getIntervalRange()
	 * @generated
	 */
	int INTERVAL_RANGE = 3;

	/**
	 * The feature id for the '<em><b>Lower Bound Included</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL_RANGE__LOWER_BOUND_INCLUDED = 0;

	/**
	 * The feature id for the '<em><b>Upper Bound Included</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL_RANGE__UPPER_BOUND_INCLUDED = 1;

	/**
	 * The number of structural features of the '<em>Interval Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTERVAL_RANGE_FEATURE_COUNT = 2;

	/**
	 * The number of structural features of the '<em>Child Relation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHILD_RELATION_FEATURE_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Optional Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE__OPTIONAL_CHILDREN = CHILD_RELATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Mandatory Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE__MANDATORY_CHILDREN = CHILD_RELATION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Simple</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIMPLE_FEATURE_COUNT = CHILD_RELATION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_GROUP__MIN = CHILD_RELATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_GROUP__MAX = CHILD_RELATION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_GROUP__CHILDREN = CHILD_RELATION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Feature Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_GROUP_FEATURE_COUNT = CHILD_RELATION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_DIAGRAM__ID = NAMED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_DIAGRAM__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Root Feature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_DIAGRAM__ROOT_FEATURE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_DIAGRAM__CONSTRAINTS = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Annotatable Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_DIAGRAM__ANNOTATABLE_ELEMENT = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Feature Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_DIAGRAM_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__ID = NAMED_ELEMENT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__NAME = NAMED_ELEMENT__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__SOURCE = NAMED_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__TARGET = NAMED_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT__DESCRIPTION = NAMED_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSTRAINT_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRED_CONSTRAINT__ID = CONSTRAINT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRED_CONSTRAINT__NAME = CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRED_CONSTRAINT__SOURCE = CONSTRAINT__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRED_CONSTRAINT__TARGET = CONSTRAINT__TARGET;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRED_CONSTRAINT__DESCRIPTION = CONSTRAINT__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Required Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUIRED_CONSTRAINT_FEATURE_COUNT = CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROHIBITS_CONSTRAINT__ID = CONSTRAINT__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROHIBITS_CONSTRAINT__NAME = CONSTRAINT__NAME;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROHIBITS_CONSTRAINT__SOURCE = CONSTRAINT__SOURCE;

	/**
	 * The feature id for the '<em><b>Target</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROHIBITS_CONSTRAINT__TARGET = CONSTRAINT__TARGET;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROHIBITS_CONSTRAINT__DESCRIPTION = CONSTRAINT__DESCRIPTION;

	/**
	 * The number of structural features of the '<em>Prohibits Constraint</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PROHIBITS_CONSTRAINT_FEATURE_COUNT = CONSTRAINT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.featuremodel.impl.IntegerIntervalRangeImpl <em>Integer Interval Range</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.featuremodel.impl.IntegerIntervalRangeImpl
	 * @see de.uka.ipd.sdq.featuremodel.impl.featuremodelPackageImpl#getIntegerIntervalRange()
	 * @generated
	 */
	int INTEGER_INTERVAL_RANGE = 11;

	/**
	 * The feature id for the '<em><b>Lower Bound Included</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_INTERVAL_RANGE__LOWER_BOUND_INCLUDED = INTERVAL_RANGE__LOWER_BOUND_INCLUDED;

	/**
	 * The feature id for the '<em><b>Upper Bound Included</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_INTERVAL_RANGE__UPPER_BOUND_INCLUDED = INTERVAL_RANGE__UPPER_BOUND_INCLUDED;

	/**
	 * The feature id for the '<em><b>To</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_INTERVAL_RANGE__TO = INTERVAL_RANGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>From</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_INTERVAL_RANGE__FROM = INTERVAL_RANGE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Integer Interval Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_INTERVAL_RANGE_FEATURE_COUNT = INTERVAL_RANGE_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.featuremodel.impl.ContinousIntervalRangeImpl <em>Continous Interval Range</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.featuremodel.impl.ContinousIntervalRangeImpl
	 * @see de.uka.ipd.sdq.featuremodel.impl.featuremodelPackageImpl#getContinousIntervalRange()
	 * @generated
	 */
	int CONTINOUS_INTERVAL_RANGE = 12;

	/**
	 * The feature id for the '<em><b>Lower Bound Included</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINOUS_INTERVAL_RANGE__LOWER_BOUND_INCLUDED = INTERVAL_RANGE__LOWER_BOUND_INCLUDED;

	/**
	 * The feature id for the '<em><b>Upper Bound Included</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINOUS_INTERVAL_RANGE__UPPER_BOUND_INCLUDED = INTERVAL_RANGE__UPPER_BOUND_INCLUDED;

	/**
	 * The feature id for the '<em><b>To</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINOUS_INTERVAL_RANGE__TO = INTERVAL_RANGE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>From</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINOUS_INTERVAL_RANGE__FROM = INTERVAL_RANGE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Continous Interval Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINOUS_INTERVAL_RANGE_FEATURE_COUNT = INTERVAL_RANGE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_ATTRIBUTE__ID = ATTRIBUTE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_ATTRIBUTE__NAME = ATTRIBUTE__NAME;

	/**
	 * The feature id for the '<em><b>Range</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_ATTRIBUTE__RANGE = ATTRIBUTE__RANGE;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_ATTRIBUTE__DEFAULT_VALUE = ATTRIBUTE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Integer Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INTEGER_ATTRIBUTE_FEATURE_COUNT = ATTRIBUTE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_ATTRIBUTE__ID = ATTRIBUTE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_ATTRIBUTE__NAME = ATTRIBUTE__NAME;

	/**
	 * The feature id for the '<em><b>Range</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_ATTRIBUTE__RANGE = ATTRIBUTE__RANGE;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_ATTRIBUTE__DEFAULT_VALUE = ATTRIBUTE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Double Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DOUBLE_ATTRIBUTE_FEATURE_COUNT = ATTRIBUTE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.featuremodel.impl.StringAttributeImpl <em>String Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.featuremodel.impl.StringAttributeImpl
	 * @see de.uka.ipd.sdq.featuremodel.impl.featuremodelPackageImpl#getStringAttribute()
	 * @generated
	 */
	int STRING_ATTRIBUTE = 15;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_ATTRIBUTE__ID = ATTRIBUTE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_ATTRIBUTE__NAME = ATTRIBUTE__NAME;

	/**
	 * The feature id for the '<em><b>Range</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_ATTRIBUTE__RANGE = ATTRIBUTE__RANGE;

	/**
	 * The feature id for the '<em><b>Default Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_ATTRIBUTE__DEFAULT_VALUE = ATTRIBUTE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>String Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRING_ATTRIBUTE_FEATURE_COUNT = ATTRIBUTE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.featuremodel.impl.ExternalObjectAttributeImpl <em>External Object Attribute</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.featuremodel.impl.ExternalObjectAttributeImpl
	 * @see de.uka.ipd.sdq.featuremodel.impl.featuremodelPackageImpl#getExternalObjectAttribute()
	 * @generated
	 */
	int EXTERNAL_OBJECT_ATTRIBUTE = 16;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_OBJECT_ATTRIBUTE__ID = ATTRIBUTE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_OBJECT_ATTRIBUTE__NAME = ATTRIBUTE__NAME;

	/**
	 * The feature id for the '<em><b>Range</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_OBJECT_ATTRIBUTE__RANGE = ATTRIBUTE__RANGE;

	/**
	 * The number of structural features of the '<em>External Object Attribute</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_OBJECT_ATTRIBUTE_FEATURE_COUNT = ATTRIBUTE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.uka.ipd.sdq.featuremodel.AttributeTypes <em>Attribute Types</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.uka.ipd.sdq.featuremodel.AttributeTypes
	 * @see de.uka.ipd.sdq.featuremodel.impl.featuremodelPackageImpl#getAttributeTypes()
	 * @generated
	 */
	int ATTRIBUTE_TYPES = 17;


	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.featuremodel.Feature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature</em>'.
	 * @see de.uka.ipd.sdq.featuremodel.Feature
	 * @generated
	 */
	EClass getFeature();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.featuremodel.Feature#getAttributes <em>Attributes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Attributes</em>'.
	 * @see de.uka.ipd.sdq.featuremodel.Feature#getAttributes()
	 * @see #getFeature()
	 * @generated
	 */
	EReference getFeature_Attributes();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.featuremodel.Feature#getChildrelation <em>Childrelation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Childrelation</em>'.
	 * @see de.uka.ipd.sdq.featuremodel.Feature#getChildrelation()
	 * @see #getFeature()
	 * @generated
	 */
	EReference getFeature_Childrelation();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.featuremodel.Feature#getSimpleMandatory <em>Simple Mandatory</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Simple Mandatory</em>'.
	 * @see de.uka.ipd.sdq.featuremodel.Feature#getSimpleMandatory()
	 * @see #getFeature()
	 * @generated
	 */
	EReference getFeature_SimpleMandatory();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.featuremodel.Feature#getSimpleOptional <em>Simple Optional</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Simple Optional</em>'.
	 * @see de.uka.ipd.sdq.featuremodel.Feature#getSimpleOptional()
	 * @see #getFeature()
	 * @generated
	 */
	EReference getFeature_SimpleOptional();

	/**
	 * Returns the meta object for the container reference '{@link de.uka.ipd.sdq.featuremodel.Feature#getFeaturegroup <em>Featuregroup</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Featuregroup</em>'.
	 * @see de.uka.ipd.sdq.featuremodel.Feature#getFeaturegroup()
	 * @see #getFeature()
	 * @generated
	 */
	EReference getFeature_Featuregroup();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.featuremodel.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Named Element</em>'.
	 * @see de.uka.ipd.sdq.featuremodel.NamedElement
	 * @generated
	 */
	EClass getNamedElement();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.featuremodel.NamedElement#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.uka.ipd.sdq.featuremodel.NamedElement#getName()
	 * @see #getNamedElement()
	 * @generated
	 */
	EAttribute getNamedElement_Name();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.featuremodel.Attribute <em>Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Attribute</em>'.
	 * @see de.uka.ipd.sdq.featuremodel.Attribute
	 * @generated
	 */
	EClass getAttribute();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.featuremodel.Attribute#getRange <em>Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Range</em>'.
	 * @see de.uka.ipd.sdq.featuremodel.Attribute#getRange()
	 * @see #getAttribute()
	 * @generated
	 */
	EReference getAttribute_Range();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.featuremodel.ChildRelation <em>Child Relation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Child Relation</em>'.
	 * @see de.uka.ipd.sdq.featuremodel.ChildRelation
	 * @generated
	 */
	EClass getChildRelation();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.featuremodel.IntegerAttribute <em>Integer Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Attribute</em>'.
	 * @see de.uka.ipd.sdq.featuremodel.IntegerAttribute
	 * @generated
	 */
	EClass getIntegerAttribute();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.featuremodel.IntegerAttribute#getDefaultValue <em>Default Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Value</em>'.
	 * @see de.uka.ipd.sdq.featuremodel.IntegerAttribute#getDefaultValue()
	 * @see #getIntegerAttribute()
	 * @generated
	 */
	EAttribute getIntegerAttribute_DefaultValue();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.featuremodel.DoubleAttribute <em>Double Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Double Attribute</em>'.
	 * @see de.uka.ipd.sdq.featuremodel.DoubleAttribute
	 * @generated
	 */
	EClass getDoubleAttribute();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.featuremodel.DoubleAttribute#getDefaultValue <em>Default Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Value</em>'.
	 * @see de.uka.ipd.sdq.featuremodel.DoubleAttribute#getDefaultValue()
	 * @see #getDoubleAttribute()
	 * @generated
	 */
	EAttribute getDoubleAttribute_DefaultValue();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.featuremodel.StringAttribute <em>String Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Attribute</em>'.
	 * @see de.uka.ipd.sdq.featuremodel.StringAttribute
	 * @generated
	 */
	EClass getStringAttribute();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.featuremodel.StringAttribute#getDefaultValue <em>Default Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Default Value</em>'.
	 * @see de.uka.ipd.sdq.featuremodel.StringAttribute#getDefaultValue()
	 * @see #getStringAttribute()
	 * @generated
	 */
	EAttribute getStringAttribute_DefaultValue();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.featuremodel.ExternalObjectAttribute <em>External Object Attribute</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>External Object Attribute</em>'.
	 * @see de.uka.ipd.sdq.featuremodel.ExternalObjectAttribute
	 * @generated
	 */
	EClass getExternalObjectAttribute();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.featuremodel.IntervalRange <em>Interval Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Interval Range</em>'.
	 * @see de.uka.ipd.sdq.featuremodel.IntervalRange
	 * @generated
	 */
	EClass getIntervalRange();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.featuremodel.IntervalRange#isLowerBoundIncluded <em>Lower Bound Included</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Lower Bound Included</em>'.
	 * @see de.uka.ipd.sdq.featuremodel.IntervalRange#isLowerBoundIncluded()
	 * @see #getIntervalRange()
	 * @generated
	 */
	EAttribute getIntervalRange_LowerBoundIncluded();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.featuremodel.IntervalRange#isUpperBoundIncluded <em>Upper Bound Included</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Upper Bound Included</em>'.
	 * @see de.uka.ipd.sdq.featuremodel.IntervalRange#isUpperBoundIncluded()
	 * @see #getIntervalRange()
	 * @generated
	 */
	EAttribute getIntervalRange_UpperBoundIncluded();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.featuremodel.IntegerIntervalRange <em>Integer Interval Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Integer Interval Range</em>'.
	 * @see de.uka.ipd.sdq.featuremodel.IntegerIntervalRange
	 * @generated
	 */
	EClass getIntegerIntervalRange();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.featuremodel.IntegerIntervalRange#getTo <em>To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>To</em>'.
	 * @see de.uka.ipd.sdq.featuremodel.IntegerIntervalRange#getTo()
	 * @see #getIntegerIntervalRange()
	 * @generated
	 */
	EAttribute getIntegerIntervalRange_To();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.featuremodel.IntegerIntervalRange#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>From</em>'.
	 * @see de.uka.ipd.sdq.featuremodel.IntegerIntervalRange#getFrom()
	 * @see #getIntegerIntervalRange()
	 * @generated
	 */
	EAttribute getIntegerIntervalRange_From();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.featuremodel.ContinousIntervalRange <em>Continous Interval Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Continous Interval Range</em>'.
	 * @see de.uka.ipd.sdq.featuremodel.ContinousIntervalRange
	 * @generated
	 */
	EClass getContinousIntervalRange();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.featuremodel.ContinousIntervalRange#getTo <em>To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>To</em>'.
	 * @see de.uka.ipd.sdq.featuremodel.ContinousIntervalRange#getTo()
	 * @see #getContinousIntervalRange()
	 * @generated
	 */
	EAttribute getContinousIntervalRange_To();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.featuremodel.ContinousIntervalRange#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>From</em>'.
	 * @see de.uka.ipd.sdq.featuremodel.ContinousIntervalRange#getFrom()
	 * @see #getContinousIntervalRange()
	 * @generated
	 */
	EAttribute getContinousIntervalRange_From();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.featuremodel.FeatureGroup <em>Feature Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Group</em>'.
	 * @see de.uka.ipd.sdq.featuremodel.FeatureGroup
	 * @generated
	 */
	EClass getFeatureGroup();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.featuremodel.FeatureGroup#getMin <em>Min</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min</em>'.
	 * @see de.uka.ipd.sdq.featuremodel.FeatureGroup#getMin()
	 * @see #getFeatureGroup()
	 * @generated
	 */
	EAttribute getFeatureGroup_Min();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.featuremodel.FeatureGroup#getMax <em>Max</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max</em>'.
	 * @see de.uka.ipd.sdq.featuremodel.FeatureGroup#getMax()
	 * @see #getFeatureGroup()
	 * @generated
	 */
	EAttribute getFeatureGroup_Max();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.featuremodel.FeatureGroup#getChildren <em>Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Children</em>'.
	 * @see de.uka.ipd.sdq.featuremodel.FeatureGroup#getChildren()
	 * @see #getFeatureGroup()
	 * @generated
	 */
	EReference getFeatureGroup_Children();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.featuremodel.FeatureDiagram <em>Feature Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Diagram</em>'.
	 * @see de.uka.ipd.sdq.featuremodel.FeatureDiagram
	 * @generated
	 */
	EClass getFeatureDiagram();

	/**
	 * Returns the meta object for the containment reference '{@link de.uka.ipd.sdq.featuremodel.FeatureDiagram#getRootFeature <em>Root Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Root Feature</em>'.
	 * @see de.uka.ipd.sdq.featuremodel.FeatureDiagram#getRootFeature()
	 * @see #getFeatureDiagram()
	 * @generated
	 */
	EReference getFeatureDiagram_RootFeature();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.featuremodel.FeatureDiagram#getConstraints <em>Constraints</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Constraints</em>'.
	 * @see de.uka.ipd.sdq.featuremodel.FeatureDiagram#getConstraints()
	 * @see #getFeatureDiagram()
	 * @generated
	 */
	EReference getFeatureDiagram_Constraints();

	/**
	 * Returns the meta object for the reference list '{@link de.uka.ipd.sdq.featuremodel.FeatureDiagram#getAnnotatableElement <em>Annotatable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Annotatable Element</em>'.
	 * @see de.uka.ipd.sdq.featuremodel.FeatureDiagram#getAnnotatableElement()
	 * @see #getFeatureDiagram()
	 * @generated
	 */
	EReference getFeatureDiagram_AnnotatableElement();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.featuremodel.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Constraint</em>'.
	 * @see de.uka.ipd.sdq.featuremodel.Constraint
	 * @generated
	 */
	EClass getConstraint();

	/**
	 * Returns the meta object for the reference '{@link de.uka.ipd.sdq.featuremodel.Constraint#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see de.uka.ipd.sdq.featuremodel.Constraint#getSource()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_Source();

	/**
	 * Returns the meta object for the reference list '{@link de.uka.ipd.sdq.featuremodel.Constraint#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Target</em>'.
	 * @see de.uka.ipd.sdq.featuremodel.Constraint#getTarget()
	 * @see #getConstraint()
	 * @generated
	 */
	EReference getConstraint_Target();

	/**
	 * Returns the meta object for the attribute '{@link de.uka.ipd.sdq.featuremodel.Constraint#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see de.uka.ipd.sdq.featuremodel.Constraint#getDescription()
	 * @see #getConstraint()
	 * @generated
	 */
	EAttribute getConstraint_Description();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.featuremodel.RequiredConstraint <em>Required Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Required Constraint</em>'.
	 * @see de.uka.ipd.sdq.featuremodel.RequiredConstraint
	 * @generated
	 */
	EClass getRequiredConstraint();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.featuremodel.ProhibitsConstraint <em>Prohibits Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Prohibits Constraint</em>'.
	 * @see de.uka.ipd.sdq.featuremodel.ProhibitsConstraint
	 * @generated
	 */
	EClass getProhibitsConstraint();

	/**
	 * Returns the meta object for class '{@link de.uka.ipd.sdq.featuremodel.Simple <em>Simple</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Simple</em>'.
	 * @see de.uka.ipd.sdq.featuremodel.Simple
	 * @generated
	 */
	EClass getSimple();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.featuremodel.Simple#getMandatoryChildren <em>Mandatory Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Mandatory Children</em>'.
	 * @see de.uka.ipd.sdq.featuremodel.Simple#getMandatoryChildren()
	 * @see #getSimple()
	 * @generated
	 */
	EReference getSimple_MandatoryChildren();

	/**
	 * Returns the meta object for the containment reference list '{@link de.uka.ipd.sdq.featuremodel.Simple#getOptionalChildren <em>Optional Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Optional Children</em>'.
	 * @see de.uka.ipd.sdq.featuremodel.Simple#getOptionalChildren()
	 * @see #getSimple()
	 * @generated
	 */
	EReference getSimple_OptionalChildren();

	/**
	 * Returns the meta object for enum '{@link de.uka.ipd.sdq.featuremodel.AttributeTypes <em>Attribute Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Attribute Types</em>'.
	 * @see de.uka.ipd.sdq.featuremodel.AttributeTypes
	 * @generated
	 */
	EEnum getAttributeTypes();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	featuremodelFactory getfeaturemodelFactory();

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
		 * The meta object literal for the '{@link de.uka.ipd.sdq.featuremodel.impl.FeatureImpl <em>Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.featuremodel.impl.FeatureImpl
		 * @see de.uka.ipd.sdq.featuremodel.impl.featuremodelPackageImpl#getFeature()
		 * @generated
		 */
		EClass FEATURE = eINSTANCE.getFeature();

		/**
		 * The meta object literal for the '<em><b>Attributes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE__ATTRIBUTES = eINSTANCE.getFeature_Attributes();

		/**
		 * The meta object literal for the '<em><b>Childrelation</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE__CHILDRELATION = eINSTANCE.getFeature_Childrelation();

		/**
		 * The meta object literal for the '<em><b>Simple Mandatory</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE__SIMPLE_MANDATORY = eINSTANCE.getFeature_SimpleMandatory();

		/**
		 * The meta object literal for the '<em><b>Simple Optional</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE__SIMPLE_OPTIONAL = eINSTANCE.getFeature_SimpleOptional();

		/**
		 * The meta object literal for the '<em><b>Featuregroup</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE__FEATUREGROUP = eINSTANCE.getFeature_Featuregroup();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.featuremodel.impl.NamedElementImpl <em>Named Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.featuremodel.impl.NamedElementImpl
		 * @see de.uka.ipd.sdq.featuremodel.impl.featuremodelPackageImpl#getNamedElement()
		 * @generated
		 */
		EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.featuremodel.impl.AttributeImpl <em>Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.featuremodel.impl.AttributeImpl
		 * @see de.uka.ipd.sdq.featuremodel.impl.featuremodelPackageImpl#getAttribute()
		 * @generated
		 */
		EClass ATTRIBUTE = eINSTANCE.getAttribute();

		/**
		 * The meta object literal for the '<em><b>Range</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ATTRIBUTE__RANGE = eINSTANCE.getAttribute_Range();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.featuremodel.impl.ChildRelationImpl <em>Child Relation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.featuremodel.impl.ChildRelationImpl
		 * @see de.uka.ipd.sdq.featuremodel.impl.featuremodelPackageImpl#getChildRelation()
		 * @generated
		 */
		EClass CHILD_RELATION = eINSTANCE.getChildRelation();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.featuremodel.impl.IntegerAttributeImpl <em>Integer Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.featuremodel.impl.IntegerAttributeImpl
		 * @see de.uka.ipd.sdq.featuremodel.impl.featuremodelPackageImpl#getIntegerAttribute()
		 * @generated
		 */
		EClass INTEGER_ATTRIBUTE = eINSTANCE.getIntegerAttribute();

		/**
		 * The meta object literal for the '<em><b>Default Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER_ATTRIBUTE__DEFAULT_VALUE = eINSTANCE.getIntegerAttribute_DefaultValue();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.featuremodel.impl.DoubleAttributeImpl <em>Double Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.featuremodel.impl.DoubleAttributeImpl
		 * @see de.uka.ipd.sdq.featuremodel.impl.featuremodelPackageImpl#getDoubleAttribute()
		 * @generated
		 */
		EClass DOUBLE_ATTRIBUTE = eINSTANCE.getDoubleAttribute();

		/**
		 * The meta object literal for the '<em><b>Default Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DOUBLE_ATTRIBUTE__DEFAULT_VALUE = eINSTANCE.getDoubleAttribute_DefaultValue();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.featuremodel.impl.StringAttributeImpl <em>String Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.featuremodel.impl.StringAttributeImpl
		 * @see de.uka.ipd.sdq.featuremodel.impl.featuremodelPackageImpl#getStringAttribute()
		 * @generated
		 */
		EClass STRING_ATTRIBUTE = eINSTANCE.getStringAttribute();

		/**
		 * The meta object literal for the '<em><b>Default Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRING_ATTRIBUTE__DEFAULT_VALUE = eINSTANCE.getStringAttribute_DefaultValue();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.featuremodel.impl.ExternalObjectAttributeImpl <em>External Object Attribute</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.featuremodel.impl.ExternalObjectAttributeImpl
		 * @see de.uka.ipd.sdq.featuremodel.impl.featuremodelPackageImpl#getExternalObjectAttribute()
		 * @generated
		 */
		EClass EXTERNAL_OBJECT_ATTRIBUTE = eINSTANCE.getExternalObjectAttribute();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.featuremodel.impl.IntervalRangeImpl <em>Interval Range</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.featuremodel.impl.IntervalRangeImpl
		 * @see de.uka.ipd.sdq.featuremodel.impl.featuremodelPackageImpl#getIntervalRange()
		 * @generated
		 */
		EClass INTERVAL_RANGE = eINSTANCE.getIntervalRange();

		/**
		 * The meta object literal for the '<em><b>Lower Bound Included</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERVAL_RANGE__LOWER_BOUND_INCLUDED = eINSTANCE.getIntervalRange_LowerBoundIncluded();

		/**
		 * The meta object literal for the '<em><b>Upper Bound Included</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTERVAL_RANGE__UPPER_BOUND_INCLUDED = eINSTANCE.getIntervalRange_UpperBoundIncluded();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.featuremodel.impl.IntegerIntervalRangeImpl <em>Integer Interval Range</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.featuremodel.impl.IntegerIntervalRangeImpl
		 * @see de.uka.ipd.sdq.featuremodel.impl.featuremodelPackageImpl#getIntegerIntervalRange()
		 * @generated
		 */
		EClass INTEGER_INTERVAL_RANGE = eINSTANCE.getIntegerIntervalRange();

		/**
		 * The meta object literal for the '<em><b>To</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER_INTERVAL_RANGE__TO = eINSTANCE.getIntegerIntervalRange_To();

		/**
		 * The meta object literal for the '<em><b>From</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INTEGER_INTERVAL_RANGE__FROM = eINSTANCE.getIntegerIntervalRange_From();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.featuremodel.impl.ContinousIntervalRangeImpl <em>Continous Interval Range</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.featuremodel.impl.ContinousIntervalRangeImpl
		 * @see de.uka.ipd.sdq.featuremodel.impl.featuremodelPackageImpl#getContinousIntervalRange()
		 * @generated
		 */
		EClass CONTINOUS_INTERVAL_RANGE = eINSTANCE.getContinousIntervalRange();

		/**
		 * The meta object literal for the '<em><b>To</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTINOUS_INTERVAL_RANGE__TO = eINSTANCE.getContinousIntervalRange_To();

		/**
		 * The meta object literal for the '<em><b>From</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONTINOUS_INTERVAL_RANGE__FROM = eINSTANCE.getContinousIntervalRange_From();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.featuremodel.impl.FeatureGroupImpl <em>Feature Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.featuremodel.impl.FeatureGroupImpl
		 * @see de.uka.ipd.sdq.featuremodel.impl.featuremodelPackageImpl#getFeatureGroup()
		 * @generated
		 */
		EClass FEATURE_GROUP = eINSTANCE.getFeatureGroup();

		/**
		 * The meta object literal for the '<em><b>Min</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_GROUP__MIN = eINSTANCE.getFeatureGroup_Min();

		/**
		 * The meta object literal for the '<em><b>Max</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_GROUP__MAX = eINSTANCE.getFeatureGroup_Max();

		/**
		 * The meta object literal for the '<em><b>Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_GROUP__CHILDREN = eINSTANCE.getFeatureGroup_Children();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.featuremodel.impl.FeatureDiagramImpl <em>Feature Diagram</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.featuremodel.impl.FeatureDiagramImpl
		 * @see de.uka.ipd.sdq.featuremodel.impl.featuremodelPackageImpl#getFeatureDiagram()
		 * @generated
		 */
		EClass FEATURE_DIAGRAM = eINSTANCE.getFeatureDiagram();

		/**
		 * The meta object literal for the '<em><b>Root Feature</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_DIAGRAM__ROOT_FEATURE = eINSTANCE.getFeatureDiagram_RootFeature();

		/**
		 * The meta object literal for the '<em><b>Constraints</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_DIAGRAM__CONSTRAINTS = eINSTANCE.getFeatureDiagram_Constraints();

		/**
		 * The meta object literal for the '<em><b>Annotatable Element</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_DIAGRAM__ANNOTATABLE_ELEMENT = eINSTANCE.getFeatureDiagram_AnnotatableElement();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.featuremodel.impl.ConstraintImpl <em>Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.featuremodel.impl.ConstraintImpl
		 * @see de.uka.ipd.sdq.featuremodel.impl.featuremodelPackageImpl#getConstraint()
		 * @generated
		 */
		EClass CONSTRAINT = eINSTANCE.getConstraint();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT__SOURCE = eINSTANCE.getConstraint_Source();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSTRAINT__TARGET = eINSTANCE.getConstraint_Target();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSTRAINT__DESCRIPTION = eINSTANCE.getConstraint_Description();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.featuremodel.impl.RequiredConstraintImpl <em>Required Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.featuremodel.impl.RequiredConstraintImpl
		 * @see de.uka.ipd.sdq.featuremodel.impl.featuremodelPackageImpl#getRequiredConstraint()
		 * @generated
		 */
		EClass REQUIRED_CONSTRAINT = eINSTANCE.getRequiredConstraint();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.featuremodel.impl.ProhibitsConstraintImpl <em>Prohibits Constraint</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.featuremodel.impl.ProhibitsConstraintImpl
		 * @see de.uka.ipd.sdq.featuremodel.impl.featuremodelPackageImpl#getProhibitsConstraint()
		 * @generated
		 */
		EClass PROHIBITS_CONSTRAINT = eINSTANCE.getProhibitsConstraint();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.featuremodel.impl.SimpleImpl <em>Simple</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.featuremodel.impl.SimpleImpl
		 * @see de.uka.ipd.sdq.featuremodel.impl.featuremodelPackageImpl#getSimple()
		 * @generated
		 */
		EClass SIMPLE = eINSTANCE.getSimple();

		/**
		 * The meta object literal for the '<em><b>Mandatory Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMPLE__MANDATORY_CHILDREN = eINSTANCE.getSimple_MandatoryChildren();

		/**
		 * The meta object literal for the '<em><b>Optional Children</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SIMPLE__OPTIONAL_CHILDREN = eINSTANCE.getSimple_OptionalChildren();

		/**
		 * The meta object literal for the '{@link de.uka.ipd.sdq.featuremodel.AttributeTypes <em>Attribute Types</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.uka.ipd.sdq.featuremodel.AttributeTypes
		 * @see de.uka.ipd.sdq.featuremodel.impl.featuremodelPackageImpl#getAttributeTypes()
		 * @generated
		 */
		EEnum ATTRIBUTE_TYPES = eINSTANCE.getAttributeTypes();

	}

} //featuremodelPackage
