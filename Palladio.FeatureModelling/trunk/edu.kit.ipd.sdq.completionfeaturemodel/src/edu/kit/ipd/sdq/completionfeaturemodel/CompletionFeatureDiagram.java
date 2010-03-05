/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.kit.ipd.sdq.completionfeaturemodel;

import de.uka.ipd.sdq.featuremodel.FeatureDiagram;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Completion Feature Diagram</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * decorator class of FeatureDiagram
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link edu.kit.ipd.sdq.completionfeaturemodel.CompletionFeatureDiagram#getAnnotatableType <em>Annotatable Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.kit.ipd.sdq.completionfeaturemodel.completionfeaturemodelPackage#getCompletionFeatureDiagram()
 * @model
 * @generated
 */
public interface CompletionFeatureDiagram extends FeatureDiagram {

	/**
	 * Returns the value of the '<em><b>Annotatable Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annotatable Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotatable Type</em>' attribute.
	 * @see #setAnnotatableType(String)
	 * @see edu.kit.ipd.sdq.completionfeaturemodel.completionfeaturemodelPackage#getCompletionFeatureDiagram_AnnotatableType()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	String getAnnotatableType();

	/**
	 * Sets the value of the '{@link edu.kit.ipd.sdq.completionfeaturemodel.CompletionFeatureDiagram#getAnnotatableType <em>Annotatable Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Annotatable Type</em>' attribute.
	 * @see #getAnnotatableType()
	 * @generated
	 */
	void setAnnotatableType(String value);
} // CompletionFeatureDiagram
