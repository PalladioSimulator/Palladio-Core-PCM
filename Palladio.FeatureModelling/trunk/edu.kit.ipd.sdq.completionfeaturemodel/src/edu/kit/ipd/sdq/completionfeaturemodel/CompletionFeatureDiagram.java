/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package edu.kit.ipd.sdq.completionfeaturemodel;

import de.uka.ipd.sdq.featuremodel.FeatureDiagram;
import org.eclipse.emf.ecore.EClass;

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
 *   <li>{@link edu.kit.ipd.sdq.completionfeaturemodel.CompletionFeatureDiagram#getAnnotatableElementType <em>Annotatable Element Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see edu.kit.ipd.sdq.completionfeaturemodel.completionfeaturemodelPackage#getCompletionFeatureDiagram()
 * @model
 * @generated
 */
public interface CompletionFeatureDiagram extends FeatureDiagram {

	/**
	 * Returns the value of the '<em><b>Annotatable Element Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annotatable Element Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotatable Element Type</em>' reference.
	 * @see #setAnnotatableElementType(EClass)
	 * @see edu.kit.ipd.sdq.completionfeaturemodel.completionfeaturemodelPackage#getCompletionFeatureDiagram_AnnotatableElementType()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EClass getAnnotatableElementType();

	/**
	 * Sets the value of the '{@link edu.kit.ipd.sdq.completionfeaturemodel.CompletionFeatureDiagram#getAnnotatableElementType <em>Annotatable Element Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Annotatable Element Type</em>' reference.
	 * @see #getAnnotatableElementType()
	 * @generated
	 */
	void setAnnotatableElementType(EClass value);
} // CompletionFeatureDiagram
