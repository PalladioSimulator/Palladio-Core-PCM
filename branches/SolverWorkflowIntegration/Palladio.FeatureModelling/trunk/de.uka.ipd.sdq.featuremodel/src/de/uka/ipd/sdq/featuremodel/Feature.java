/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.featuremodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Feature</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.Feature#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.Feature#getChildrelation <em>Childrelation</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.featuremodel.featuremodelPackage#getFeature()
 * @model
 * @generated
 */
public interface Feature extends NamedElement {
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

} // Feature
