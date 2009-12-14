/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.featuremodel;

import org.eclipse.emf.common.util.EList;

import QVTRelation.Relation;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.Feature#getFeatureState <em>Feature State</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.Feature#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.Feature#getChildrelation <em>Childrelation</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.Feature#getDisambiguation <em>Disambiguation</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.Feature#getTransformationFragment <em>Transformation Fragment</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.Feature#getCopyException <em>Copy Exception</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.Feature#getSimpleMandatory <em>Simple Mandatory</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.Feature#getSimpleOptional <em>Simple Optional</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.featuremodel.featuremodelPackage#getFeature()
 * @model
 * @generated
 */
public interface Feature extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Feature State</b></em>' attribute.
	 * The default value is <code>"NOT_SET"</code>.
	 * The literals are from the enumeration {@link de.uka.ipd.sdq.featuremodel.FeatureState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature State</em>' attribute.
	 * @see de.uka.ipd.sdq.featuremodel.FeatureState
	 * @see #setFeatureState(FeatureState)
	 * @see de.uka.ipd.sdq.featuremodel.featuremodelPackage#getFeature_FeatureState()
	 * @model default="NOT_SET" required="true" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	FeatureState getFeatureState();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.featuremodel.Feature#getFeatureState <em>Feature State</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature State</em>' attribute.
	 * @see de.uka.ipd.sdq.featuremodel.FeatureState
	 * @see #getFeatureState()
	 * @generated
	 */
	void setFeatureState(FeatureState value);

	/**
	 * Returns the value of the '<em><b>Attributes</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.featuremodel.Attribute}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Attributes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attributes</em>' containment reference list.
	 * @see de.uka.ipd.sdq.featuremodel.featuremodelPackage#getFeature_Attributes()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Attribute> getAttributes();

	/**
	 * Returns the value of the '<em><b>Childrelation</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Childrelation</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Childrelation</em>' containment reference.
	 * @see #setChildrelation(ChildRelation)
	 * @see de.uka.ipd.sdq.featuremodel.featuremodelPackage#getFeature_Childrelation()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	ChildRelation getChildrelation();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.featuremodel.Feature#getChildrelation <em>Childrelation</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Childrelation</em>' containment reference.
	 * @see #getChildrelation()
	 * @generated
	 */
	void setChildrelation(ChildRelation value);

	/**
	 * Returns the value of the '<em><b>Disambiguation</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.featuremodel.DisambiguationRule}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Disambiguation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Disambiguation</em>' containment reference list.
	 * @see de.uka.ipd.sdq.featuremodel.featuremodelPackage#getFeature_Disambiguation()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<DisambiguationRule> getDisambiguation();

	/**
	 * Returns the value of the '<em><b>Transformation Fragment</b></em>' containment reference list.
	 * The list contents are of type {@link QVTRelation.Relation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transformation Fragment</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transformation Fragment</em>' containment reference list.
	 * @see de.uka.ipd.sdq.featuremodel.featuremodelPackage#getFeature_TransformationFragment()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Relation> getTransformationFragment();

	/**
	 * Returns the value of the '<em><b>Copy Exception</b></em>' containment reference list.
	 * The list contents are of type {@link copyException.Exception}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Copy Exception</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Copy Exception</em>' containment reference list.
	 * @see de.uka.ipd.sdq.featuremodel.featuremodelPackage#getFeature_CopyException()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<copyException.Exception> getCopyException();

	/**
	 * Returns the value of the '<em><b>Simple Mandatory</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.featuremodel.Simple#getMandatoryChildren <em>Mandatory Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simple Mandatory</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simple Mandatory</em>' container reference.
	 * @see #setSimpleMandatory(Simple)
	 * @see de.uka.ipd.sdq.featuremodel.featuremodelPackage#getFeature_SimpleMandatory()
	 * @see de.uka.ipd.sdq.featuremodel.Simple#getMandatoryChildren
	 * @model opposite="mandatoryChildren" transient="false" ordered="false"
	 * @generated
	 */
	Simple getSimpleMandatory();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.featuremodel.Feature#getSimpleMandatory <em>Simple Mandatory</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simple Mandatory</em>' container reference.
	 * @see #getSimpleMandatory()
	 * @generated
	 */
	void setSimpleMandatory(Simple value);

	/**
	 * Returns the value of the '<em><b>Simple Optional</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.featuremodel.Simple#getOptionalChildren <em>Optional Children</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simple Optional</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simple Optional</em>' container reference.
	 * @see #setSimpleOptional(Simple)
	 * @see de.uka.ipd.sdq.featuremodel.featuremodelPackage#getFeature_SimpleOptional()
	 * @see de.uka.ipd.sdq.featuremodel.Simple#getOptionalChildren
	 * @model opposite="optionalChildren" transient="false" ordered="false"
	 * @generated
	 */
	Simple getSimpleOptional();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.featuremodel.Feature#getSimpleOptional <em>Simple Optional</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Simple Optional</em>' container reference.
	 * @see #getSimpleOptional()
	 * @generated
	 */
	void setSimpleOptional(Simple value);

} // Feature
