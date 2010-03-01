/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.kit.ipd.sdq.completionfeaturemodel;

import QVTRelation.Relation;

import de.uka.ipd.sdq.featuremodel.Feature;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Completion Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>
 *     decorator class of Feature
 * </p>
 * <p>
 *     Feature is extended by a QVT-Relation, a disambiguation rule which handles possible combinations of the Features of one
 *     FeatureGroup, and a copy exception.
 * </p>
 * <p>
 *     The attribute FeatureState indicates, whether a CompletionFeature is a mandatory or a optional child of a Simple.
 * </p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.completionfeaturemodel.CompletionFeature#getCopyException <em>Copy Exception</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.completionfeaturemodel.CompletionFeature#getDisambiguationRule <em>Disambiguation Rule</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.completionfeaturemodel.CompletionFeature#getTransformationFragment <em>Transformation Fragment</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.completionfeaturemodel.CompletionFeature#getFeatureState <em>Feature State</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.kit.ipd.sdq.completionfeaturemodel.completionfeaturemodelPackage#getCompletionFeature()
 * @model
 * @generated
 */
public interface CompletionFeature extends Feature {
	/**
	 * Returns the value of the '<em><b>Copy Exception</b></em>' containment reference list.
	 * The list contents are of type {@link copyException.Exception}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Copy Exception</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Copy Exception</em>' containment reference list.
	 * @see edu.kit.ipd.sdq.completionfeaturemodel.completionfeaturemodelPackage#getCompletionFeature_CopyException()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<copyException.Exception> getCopyException();

	/**
	 * Returns the value of the '<em><b>Disambiguation Rule</b></em>' containment reference list.
	 * The list contents are of type {@link edu.kit.ipd.sdq.completionfeaturemodel.DisambiguationRule}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Disambiguation Rule</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Disambiguation Rule</em>' containment reference list.
	 * @see edu.kit.ipd.sdq.completionfeaturemodel.completionfeaturemodelPackage#getCompletionFeature_DisambiguationRule()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<DisambiguationRule> getDisambiguationRule();

	/**
	 * Returns the value of the '<em><b>Transformation Fragment</b></em>' containment reference list.
	 * The list contents are of type {@link QVTRelation.Relation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transformation Fragment</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transformation Fragment</em>' containment reference list.
	 * @see edu.kit.ipd.sdq.completionfeaturemodel.completionfeaturemodelPackage#getCompletionFeature_TransformationFragment()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Relation> getTransformationFragment();

	/**
	 * Returns the value of the '<em><b>Feature State</b></em>' attribute.
	 * The default value is <code>"NOT_SET"</code>.
	 * The literals are from the enumeration {@link edu.kit.ipd.sdq.completionfeaturemodel.FeatureState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature State</em>' attribute.
	 * @see edu.kit.ipd.sdq.completionfeaturemodel.FeatureState
	 * @see edu.kit.ipd.sdq.completionfeaturemodel.completionfeaturemodelPackage#getCompletionFeature_FeatureState()
	 * @model default="NOT_SET" required="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	FeatureState getFeatureState();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * if (simpleMandatory->size() = 1 and simpleMandatory.mandatoryChildren->size() > 0 and simpleMandatory.mandatoryChildren->includes(self)) then FeatureState::MANDATORY
	 *  else (
	 *  if (simpleOptional->size() = 1 and simpleOptional.optionalChildren->size() > 0 and simpleOptional.optionalChildren->includes(self)) then FeatureState::OPTIONAL
	 *  else FeatureState::NOT_SET
	 *  endif
	 *  ) endif
	 * <!-- end-model-doc -->
	 * @model required="true" ordered="false"
	 *        annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='if (simpleMandatory->size() = 1 and simpleMandatory.mandatoryChildren->size() > 0 and simpleMandatory.mandatoryChildren->includes(self)) then FeatureState::MANDATORY\r\n else (\r\n if (simpleOptional->size() = 1 and simpleOptional.optionalChildren->size() > 0 and simpleOptional.optionalChildren->includes(self)) then FeatureState::OPTIONAL\r\n else FeatureState::NOT_SET\r\n endif\r\n ) endif'"
	 * @generated
	 */
	FeatureState showFeatureState();

} // CompletionFeature
