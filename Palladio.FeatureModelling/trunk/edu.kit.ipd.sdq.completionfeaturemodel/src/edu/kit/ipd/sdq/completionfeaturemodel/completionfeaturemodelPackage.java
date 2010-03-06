/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.kit.ipd.sdq.completionfeaturemodel;

import de.uka.ipd.sdq.featuremodel.featuremodelPackage;

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
 * @see edu.kit.ipd.sdq.completionfeaturemodel.completionfeaturemodelFactory
 * @model kind="package"
 * @generated
 */
public interface completionfeaturemodelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "completionfeaturemodel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://sdq.ipd.kit.edu/CompletionFeatureModel/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "completionfeaturemodel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	completionfeaturemodelPackage eINSTANCE = edu.kit.ipd.sdq.completionfeaturemodel.impl.completionfeaturemodelPackageImpl.init();

	/**
	 * The meta object id for the '{@link edu.kit.ipd.sdq.completionfeaturemodel.impl.CompletionFeatureImpl <em>Completion Feature</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.ipd.sdq.completionfeaturemodel.impl.CompletionFeatureImpl
	 * @see edu.kit.ipd.sdq.completionfeaturemodel.impl.completionfeaturemodelPackageImpl#getCompletionFeature()
	 * @generated
	 */
	int COMPLETION_FEATURE = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION_FEATURE__ID = featuremodelPackage.FEATURE__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION_FEATURE__NAME = featuremodelPackage.FEATURE__NAME;

	/**
	 * The feature id for the '<em><b>Attributes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION_FEATURE__ATTRIBUTES = featuremodelPackage.FEATURE__ATTRIBUTES;

	/**
	 * The feature id for the '<em><b>Childrelation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION_FEATURE__CHILDRELATION = featuremodelPackage.FEATURE__CHILDRELATION;

	/**
	 * The feature id for the '<em><b>Simple Mandatory</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION_FEATURE__SIMPLE_MANDATORY = featuremodelPackage.FEATURE__SIMPLE_MANDATORY;

	/**
	 * The feature id for the '<em><b>Simple Optional</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION_FEATURE__SIMPLE_OPTIONAL = featuremodelPackage.FEATURE__SIMPLE_OPTIONAL;

	/**
	 * The feature id for the '<em><b>Copy Exception</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION_FEATURE__COPY_EXCEPTION = featuremodelPackage.FEATURE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Disambiguation Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION_FEATURE__DISAMBIGUATION_RULE = featuremodelPackage.FEATURE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Transformation Fragment</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION_FEATURE__TRANSFORMATION_FRAGMENT = featuremodelPackage.FEATURE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Feature State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION_FEATURE__FEATURE_STATE = featuremodelPackage.FEATURE_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Completion Feature</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION_FEATURE_FEATURE_COUNT = featuremodelPackage.FEATURE_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link edu.kit.ipd.sdq.completionfeaturemodel.impl.DisambiguationRuleImpl <em>Disambiguation Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.ipd.sdq.completionfeaturemodel.impl.DisambiguationRuleImpl
	 * @see edu.kit.ipd.sdq.completionfeaturemodel.impl.completionfeaturemodelPackageImpl#getDisambiguationRule()
	 * @generated
	 */
	int DISAMBIGUATION_RULE = 1;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISAMBIGUATION_RULE__FEATURE = 0;

	/**
	 * The feature id for the '<em><b>Disambiguation Condition</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISAMBIGUATION_RULE__DISAMBIGUATION_CONDITION = 1;

	/**
	 * The feature id for the '<em><b>Transformation Fragment</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISAMBIGUATION_RULE__TRANSFORMATION_FRAGMENT = 2;

	/**
	 * The number of structural features of the '<em>Disambiguation Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DISAMBIGUATION_RULE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link edu.kit.ipd.sdq.completionfeaturemodel.impl.CompletionFeatureDiagramImpl <em>Completion Feature Diagram</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.ipd.sdq.completionfeaturemodel.impl.CompletionFeatureDiagramImpl
	 * @see edu.kit.ipd.sdq.completionfeaturemodel.impl.completionfeaturemodelPackageImpl#getCompletionFeatureDiagram()
	 * @generated
	 */
	int COMPLETION_FEATURE_DIAGRAM = 2;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION_FEATURE_DIAGRAM__ID = featuremodelPackage.FEATURE_DIAGRAM__ID;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION_FEATURE_DIAGRAM__NAME = featuremodelPackage.FEATURE_DIAGRAM__NAME;

	/**
	 * The feature id for the '<em><b>Root Feature</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION_FEATURE_DIAGRAM__ROOT_FEATURE = featuremodelPackage.FEATURE_DIAGRAM__ROOT_FEATURE;

	/**
	 * The feature id for the '<em><b>Constraints</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION_FEATURE_DIAGRAM__CONSTRAINTS = featuremodelPackage.FEATURE_DIAGRAM__CONSTRAINTS;

	/**
	 * The feature id for the '<em><b>Annotatable Element</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION_FEATURE_DIAGRAM__ANNOTATABLE_ELEMENT = featuremodelPackage.FEATURE_DIAGRAM__ANNOTATABLE_ELEMENT;

	/**
	 * The feature id for the '<em><b>Referenced Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION_FEATURE_DIAGRAM__REFERENCED_TYPE = featuremodelPackage.FEATURE_DIAGRAM_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Completion Feature Diagram</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION_FEATURE_DIAGRAM_FEATURE_COUNT = featuremodelPackage.FEATURE_DIAGRAM_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link edu.kit.ipd.sdq.completionfeaturemodel.impl.CompletionSimpleImpl <em>Completion Simple</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.ipd.sdq.completionfeaturemodel.impl.CompletionSimpleImpl
	 * @see edu.kit.ipd.sdq.completionfeaturemodel.impl.completionfeaturemodelPackageImpl#getCompletionSimple()
	 * @generated
	 */
	int COMPLETION_SIMPLE = 3;

	/**
	 * The feature id for the '<em><b>Optional Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION_SIMPLE__OPTIONAL_CHILDREN = featuremodelPackage.SIMPLE__OPTIONAL_CHILDREN;

	/**
	 * The feature id for the '<em><b>Mandatory Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION_SIMPLE__MANDATORY_CHILDREN = featuremodelPackage.SIMPLE__MANDATORY_CHILDREN;

	/**
	 * The number of structural features of the '<em>Completion Simple</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION_SIMPLE_FEATURE_COUNT = featuremodelPackage.SIMPLE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.ipd.sdq.completionfeaturemodel.impl.CompletionFeatureGroupImpl <em>Completion Feature Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.ipd.sdq.completionfeaturemodel.impl.CompletionFeatureGroupImpl
	 * @see edu.kit.ipd.sdq.completionfeaturemodel.impl.completionfeaturemodelPackageImpl#getCompletionFeatureGroup()
	 * @generated
	 */
	int COMPLETION_FEATURE_GROUP = 4;

	/**
	 * The feature id for the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION_FEATURE_GROUP__MIN = featuremodelPackage.FEATURE_GROUP__MIN;

	/**
	 * The feature id for the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION_FEATURE_GROUP__MAX = featuremodelPackage.FEATURE_GROUP__MAX;

	/**
	 * The feature id for the '<em><b>Children</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION_FEATURE_GROUP__CHILDREN = featuremodelPackage.FEATURE_GROUP__CHILDREN;

	/**
	 * The number of structural features of the '<em>Completion Feature Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPLETION_FEATURE_GROUP_FEATURE_COUNT = featuremodelPackage.FEATURE_GROUP_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link edu.kit.ipd.sdq.completionfeaturemodel.FeatureState <em>Feature State</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see edu.kit.ipd.sdq.completionfeaturemodel.FeatureState
	 * @see edu.kit.ipd.sdq.completionfeaturemodel.impl.completionfeaturemodelPackageImpl#getFeatureState()
	 * @generated
	 */
	int FEATURE_STATE = 5;


	/**
	 * Returns the meta object for class '{@link edu.kit.ipd.sdq.completionfeaturemodel.CompletionFeature <em>Completion Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Completion Feature</em>'.
	 * @see edu.kit.ipd.sdq.completionfeaturemodel.CompletionFeature
	 * @generated
	 */
	EClass getCompletionFeature();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.kit.ipd.sdq.completionfeaturemodel.CompletionFeature#getCopyException <em>Copy Exception</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Copy Exception</em>'.
	 * @see edu.kit.ipd.sdq.completionfeaturemodel.CompletionFeature#getCopyException()
	 * @see #getCompletionFeature()
	 * @generated
	 */
	EReference getCompletionFeature_CopyException();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.kit.ipd.sdq.completionfeaturemodel.CompletionFeature#getDisambiguationRule <em>Disambiguation Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Disambiguation Rule</em>'.
	 * @see edu.kit.ipd.sdq.completionfeaturemodel.CompletionFeature#getDisambiguationRule()
	 * @see #getCompletionFeature()
	 * @generated
	 */
	EReference getCompletionFeature_DisambiguationRule();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.kit.ipd.sdq.completionfeaturemodel.CompletionFeature#getTransformationFragment <em>Transformation Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Transformation Fragment</em>'.
	 * @see edu.kit.ipd.sdq.completionfeaturemodel.CompletionFeature#getTransformationFragment()
	 * @see #getCompletionFeature()
	 * @generated
	 */
	EReference getCompletionFeature_TransformationFragment();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.ipd.sdq.completionfeaturemodel.CompletionFeature#getFeatureState <em>Feature State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Feature State</em>'.
	 * @see edu.kit.ipd.sdq.completionfeaturemodel.CompletionFeature#getFeatureState()
	 * @see #getCompletionFeature()
	 * @generated
	 */
	EAttribute getCompletionFeature_FeatureState();

	/**
	 * Returns the meta object for class '{@link edu.kit.ipd.sdq.completionfeaturemodel.DisambiguationRule <em>Disambiguation Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Disambiguation Rule</em>'.
	 * @see edu.kit.ipd.sdq.completionfeaturemodel.DisambiguationRule
	 * @generated
	 */
	EClass getDisambiguationRule();

	/**
	 * Returns the meta object for the reference '{@link edu.kit.ipd.sdq.completionfeaturemodel.DisambiguationRule#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Feature</em>'.
	 * @see edu.kit.ipd.sdq.completionfeaturemodel.DisambiguationRule#getFeature()
	 * @see #getDisambiguationRule()
	 * @generated
	 */
	EReference getDisambiguationRule_Feature();

	/**
	 * Returns the meta object for the containment reference list '{@link edu.kit.ipd.sdq.completionfeaturemodel.DisambiguationRule#getDisambiguationCondition <em>Disambiguation Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Disambiguation Condition</em>'.
	 * @see edu.kit.ipd.sdq.completionfeaturemodel.DisambiguationRule#getDisambiguationCondition()
	 * @see #getDisambiguationRule()
	 * @generated
	 */
	EReference getDisambiguationRule_DisambiguationCondition();

	/**
	 * Returns the meta object for the reference list '{@link edu.kit.ipd.sdq.completionfeaturemodel.DisambiguationRule#getTransformationFragment <em>Transformation Fragment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Transformation Fragment</em>'.
	 * @see edu.kit.ipd.sdq.completionfeaturemodel.DisambiguationRule#getTransformationFragment()
	 * @see #getDisambiguationRule()
	 * @generated
	 */
	EReference getDisambiguationRule_TransformationFragment();

	/**
	 * Returns the meta object for class '{@link edu.kit.ipd.sdq.completionfeaturemodel.CompletionFeatureDiagram <em>Completion Feature Diagram</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Completion Feature Diagram</em>'.
	 * @see edu.kit.ipd.sdq.completionfeaturemodel.CompletionFeatureDiagram
	 * @generated
	 */
	EClass getCompletionFeatureDiagram();

	/**
	 * Returns the meta object for the attribute '{@link edu.kit.ipd.sdq.completionfeaturemodel.CompletionFeatureDiagram#getReferencedType <em>Referenced Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Referenced Type</em>'.
	 * @see edu.kit.ipd.sdq.completionfeaturemodel.CompletionFeatureDiagram#getReferencedType()
	 * @see #getCompletionFeatureDiagram()
	 * @generated
	 */
	EAttribute getCompletionFeatureDiagram_ReferencedType();

	/**
	 * Returns the meta object for class '{@link edu.kit.ipd.sdq.completionfeaturemodel.CompletionSimple <em>Completion Simple</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Completion Simple</em>'.
	 * @see edu.kit.ipd.sdq.completionfeaturemodel.CompletionSimple
	 * @generated
	 */
	EClass getCompletionSimple();

	/**
	 * Returns the meta object for class '{@link edu.kit.ipd.sdq.completionfeaturemodel.CompletionFeatureGroup <em>Completion Feature Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Completion Feature Group</em>'.
	 * @see edu.kit.ipd.sdq.completionfeaturemodel.CompletionFeatureGroup
	 * @generated
	 */
	EClass getCompletionFeatureGroup();

	/**
	 * Returns the meta object for enum '{@link edu.kit.ipd.sdq.completionfeaturemodel.FeatureState <em>Feature State</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Feature State</em>'.
	 * @see edu.kit.ipd.sdq.completionfeaturemodel.FeatureState
	 * @generated
	 */
	EEnum getFeatureState();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	completionfeaturemodelFactory getcompletionfeaturemodelFactory();

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
		 * The meta object literal for the '{@link edu.kit.ipd.sdq.completionfeaturemodel.impl.CompletionFeatureImpl <em>Completion Feature</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.ipd.sdq.completionfeaturemodel.impl.CompletionFeatureImpl
		 * @see edu.kit.ipd.sdq.completionfeaturemodel.impl.completionfeaturemodelPackageImpl#getCompletionFeature()
		 * @generated
		 */
		EClass COMPLETION_FEATURE = eINSTANCE.getCompletionFeature();

		/**
		 * The meta object literal for the '<em><b>Copy Exception</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLETION_FEATURE__COPY_EXCEPTION = eINSTANCE.getCompletionFeature_CopyException();

		/**
		 * The meta object literal for the '<em><b>Disambiguation Rule</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLETION_FEATURE__DISAMBIGUATION_RULE = eINSTANCE.getCompletionFeature_DisambiguationRule();

		/**
		 * The meta object literal for the '<em><b>Transformation Fragment</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPLETION_FEATURE__TRANSFORMATION_FRAGMENT = eINSTANCE.getCompletionFeature_TransformationFragment();

		/**
		 * The meta object literal for the '<em><b>Feature State</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPLETION_FEATURE__FEATURE_STATE = eINSTANCE.getCompletionFeature_FeatureState();

		/**
		 * The meta object literal for the '{@link edu.kit.ipd.sdq.completionfeaturemodel.impl.DisambiguationRuleImpl <em>Disambiguation Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.ipd.sdq.completionfeaturemodel.impl.DisambiguationRuleImpl
		 * @see edu.kit.ipd.sdq.completionfeaturemodel.impl.completionfeaturemodelPackageImpl#getDisambiguationRule()
		 * @generated
		 */
		EClass DISAMBIGUATION_RULE = eINSTANCE.getDisambiguationRule();

		/**
		 * The meta object literal for the '<em><b>Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DISAMBIGUATION_RULE__FEATURE = eINSTANCE.getDisambiguationRule_Feature();

		/**
		 * The meta object literal for the '<em><b>Disambiguation Condition</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DISAMBIGUATION_RULE__DISAMBIGUATION_CONDITION = eINSTANCE.getDisambiguationRule_DisambiguationCondition();

		/**
		 * The meta object literal for the '<em><b>Transformation Fragment</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DISAMBIGUATION_RULE__TRANSFORMATION_FRAGMENT = eINSTANCE.getDisambiguationRule_TransformationFragment();

		/**
		 * The meta object literal for the '{@link edu.kit.ipd.sdq.completionfeaturemodel.impl.CompletionFeatureDiagramImpl <em>Completion Feature Diagram</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.ipd.sdq.completionfeaturemodel.impl.CompletionFeatureDiagramImpl
		 * @see edu.kit.ipd.sdq.completionfeaturemodel.impl.completionfeaturemodelPackageImpl#getCompletionFeatureDiagram()
		 * @generated
		 */
		EClass COMPLETION_FEATURE_DIAGRAM = eINSTANCE.getCompletionFeatureDiagram();

		/**
		 * The meta object literal for the '<em><b>Referenced Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPLETION_FEATURE_DIAGRAM__REFERENCED_TYPE = eINSTANCE.getCompletionFeatureDiagram_ReferencedType();

		/**
		 * The meta object literal for the '{@link edu.kit.ipd.sdq.completionfeaturemodel.impl.CompletionSimpleImpl <em>Completion Simple</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.ipd.sdq.completionfeaturemodel.impl.CompletionSimpleImpl
		 * @see edu.kit.ipd.sdq.completionfeaturemodel.impl.completionfeaturemodelPackageImpl#getCompletionSimple()
		 * @generated
		 */
		EClass COMPLETION_SIMPLE = eINSTANCE.getCompletionSimple();

		/**
		 * The meta object literal for the '{@link edu.kit.ipd.sdq.completionfeaturemodel.impl.CompletionFeatureGroupImpl <em>Completion Feature Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.ipd.sdq.completionfeaturemodel.impl.CompletionFeatureGroupImpl
		 * @see edu.kit.ipd.sdq.completionfeaturemodel.impl.completionfeaturemodelPackageImpl#getCompletionFeatureGroup()
		 * @generated
		 */
		EClass COMPLETION_FEATURE_GROUP = eINSTANCE.getCompletionFeatureGroup();

		/**
		 * The meta object literal for the '{@link edu.kit.ipd.sdq.completionfeaturemodel.FeatureState <em>Feature State</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see edu.kit.ipd.sdq.completionfeaturemodel.FeatureState
		 * @see edu.kit.ipd.sdq.completionfeaturemodel.impl.completionfeaturemodelPackageImpl#getFeatureState()
		 * @generated
		 */
		EEnum FEATURE_STATE = eINSTANCE.getFeatureState();

	}

} //completionfeaturemodelPackage
