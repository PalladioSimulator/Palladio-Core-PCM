/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.kit.ipd.sdq.completionfeaturemodel;

import EssentialOCL.OperationCallExp;

import QVTRelation.Relation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Disambiguation Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.completionfeaturemodel.DisambiguationRule#getFeature <em>Feature</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.completionfeaturemodel.DisambiguationRule#getDisambiguationCondition <em>Disambiguation Condition</em>}</li>
 *   <li>{@link edu.kit.ipd.sdq.completionfeaturemodel.DisambiguationRule#getTransformationFragment <em>Transformation Fragment</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.kit.ipd.sdq.completionfeaturemodel.completionfeaturemodelPackage#getDisambiguationRule()
 * @model
 * @generated
 */
public interface DisambiguationRule extends EObject {
	/**
	 * Returns the value of the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature</em>' reference.
	 * @see #setFeature(CompletionFeature)
	 * @see edu.kit.ipd.sdq.completionfeaturemodel.completionfeaturemodelPackage#getDisambiguationRule_Feature()
	 * @model ordered="false"
	 * @generated
	 */
	CompletionFeature getFeature();

	/**
	 * Sets the value of the '{@link edu.kit.ipd.sdq.completionfeaturemodel.DisambiguationRule#getFeature <em>Feature</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature</em>' reference.
	 * @see #getFeature()
	 * @generated
	 */
	void setFeature(CompletionFeature value);

	/**
	 * Returns the value of the '<em><b>Disambiguation Condition</b></em>' containment reference list.
	 * The list contents are of type {@link EssentialOCL.OperationCallExp}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Disambiguation Condition</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Disambiguation Condition</em>' containment reference list.
	 * @see edu.kit.ipd.sdq.completionfeaturemodel.completionfeaturemodelPackage#getDisambiguationRule_DisambiguationCondition()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<OperationCallExp> getDisambiguationCondition();

	/**
	 * Returns the value of the '<em><b>Transformation Fragment</b></em>' reference list.
	 * The list contents are of type {@link QVTRelation.Relation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transformation Fragment</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transformation Fragment</em>' reference list.
	 * @see edu.kit.ipd.sdq.completionfeaturemodel.completionfeaturemodelPackage#getDisambiguationRule_TransformationFragment()
	 * @model ordered="false"
	 * @generated
	 */
	EList<Relation> getTransformationFragment();

} // DisambiguationRule
