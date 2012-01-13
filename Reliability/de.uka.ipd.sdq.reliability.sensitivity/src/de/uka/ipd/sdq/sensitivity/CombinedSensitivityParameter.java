/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensitivity;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Combined Sensitivity Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * A&nbsp;combined&nbsp;sensitivity&nbsp;parameter&nbsp;consists&nbsp;of&nbsp;a&nbsp;set&nbsp;of&nbsp;child parameters. The
 * child parameters define individual variations that are&nbsp;aggregated into an overall variation. The type
 * of&nbsp;variation is determined through the isCombinatory attribute.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensitivity.CombinedSensitivityParameter#isCombinatory <em>Is Combinatory</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensitivity.CombinedSensitivityParameter#getChildParameters__CombinedSensitivityParameter <em>Child Parameters Combined Sensitivity Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.sensitivity.SensitivityPackage#getCombinedSensitivityParameter()
 * @model
 * @generated
 */
public interface CombinedSensitivityParameter extends SensitivityParameter {
	/**
	 * Returns the value of the '<em><b>Is Combinatory</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * <p>
	 *     This attribute determines how the child parameters are aggregated into a combined parameter. For example, let S1 and S2
	 *     be two child parameters, with S1 defining a sequence of changing model values {p1, p2} and S2 defining another sequence
	 *     {q1, q2, q3}. The two&nbsp;child parameters&nbsp;are combined as follows:
	 * </p>
	 * <p>
	 *     If isCombinatory == true, the product of both sequences is used: {(p1q1), (p1q2), (p1q3), (p2q1), (p2q2), (p2q3)}
	 * </p>
	 * <p>
	 *     If isCombinatory == false, both sequences proceed in parallel. The shorter sequence&nbsp;keeps&nbsp;its last value
	 *     until the longer sequence is finished: {(p1q1), (p2q2), (p2q3)}
	 * </p>
	 * <!-- end-model-doc -->
	 * @return the value of the '<em>Is Combinatory</em>' attribute.
	 * @see #setIsCombinatory(boolean)
	 * @see de.uka.ipd.sdq.sensitivity.SensitivityPackage#getCombinedSensitivityParameter_IsCombinatory()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	boolean isCombinatory();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.sensitivity.CombinedSensitivityParameter#isCombinatory <em>Is Combinatory</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Combinatory</em>' attribute.
	 * @see #isCombinatory()
	 * @generated
	 */
	void setIsCombinatory(boolean value);

	/**
	 * Returns the value of the '<em><b>Child Parameters Combined Sensitivity Parameter</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.sensitivity.SensitivityParameter}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.sensitivity.SensitivityParameter#getParentParameter__SensitivityParameter <em>Parent Parameter Sensitivity Parameter</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Child Parameters Combined Sensitivity Parameter</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Child Parameters Combined Sensitivity Parameter</em>' containment reference list.
	 * @see de.uka.ipd.sdq.sensitivity.SensitivityPackage#getCombinedSensitivityParameter_ChildParameters__CombinedSensitivityParameter()
	 * @see de.uka.ipd.sdq.sensitivity.SensitivityParameter#getParentParameter__SensitivityParameter
	 * @model opposite="parentParameter__SensitivityParameter" containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<SensitivityParameter> getChildParameters__CombinedSensitivityParameter();

} // CombinedSensitivityParameter
