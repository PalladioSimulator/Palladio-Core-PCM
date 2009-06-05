/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.featuremodel;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Simple</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.Simple#getMandatoryChildren <em>Mandatory Children</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.featuremodel.Simple#getOptionalChildren <em>Optional Children</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.featuremodel.featuremodelPackage#getSimple()
 * @model
 * @generated
 */
public interface Simple extends ChildRelation {
	/**
	 * Returns the value of the '<em><b>Mandatory Children</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.featuremodel.Feature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mandatory Children</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mandatory Children</em>' containment reference list.
	 * @see de.uka.ipd.sdq.featuremodel.featuremodelPackage#getSimple_MandatoryChildren()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Feature> getMandatoryChildren();

	/**
	 * Returns the value of the '<em><b>Optional Children</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.featuremodel.Feature}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Optional Children</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Optional Children</em>' containment reference list.
	 * @see de.uka.ipd.sdq.featuremodel.featuremodelPackage#getSimple_OptionalChildren()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Feature> getOptionalChildren();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.optionalChildren->size()+self.mandatoryChildren->size()>=1
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean atLeastOneChild(DiagnosticChain diagnostics, Map<Object, Object> context);

} // Simple
