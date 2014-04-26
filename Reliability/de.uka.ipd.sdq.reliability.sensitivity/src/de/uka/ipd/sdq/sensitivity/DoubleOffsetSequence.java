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
 * A representation of the model object '<em><b>Double Offset Sequence</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Specifies a sequence of values, to define a variation of a sensitivity parameter of type DOUBLE. The given values are used
 * as offsets to adjust the original model value.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensitivity.DoubleOffsetSequence#getOffsetValues <em>Offset Values</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.sensitivity.DoubleOffsetSequence#getDoubleOffsetType__DoubleOffsetSequence <em>Double Offset Type Double Offset Sequence</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.sensitivity.SensitivityPackage#getDoubleOffsetSequence()
 * @model
 * @generated
 */
public interface DoubleOffsetSequence extends DoubleParameterVariation {
	/**
     * Returns the value of the '<em><b>Offset Values</b></em>' attribute list.
     * The list contents are of type {@link java.lang.Double}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Offset Values</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Offset Values</em>' attribute list.
     * @see de.uka.ipd.sdq.sensitivity.SensitivityPackage#getDoubleOffsetSequence_OffsetValues()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
	EList<Double> getOffsetValues();

	/**
     * Returns the value of the '<em><b>Double Offset Type Double Offset Sequence</b></em>' attribute.
     * The literals are from the enumeration {@link de.uka.ipd.sdq.sensitivity.DoubleOffsetType}.
     * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Double Offset Type Double Offset Sequence</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
     * @return the value of the '<em>Double Offset Type Double Offset Sequence</em>' attribute.
     * @see de.uka.ipd.sdq.sensitivity.DoubleOffsetType
     * @see #setDoubleOffsetType__DoubleOffsetSequence(DoubleOffsetType)
     * @see de.uka.ipd.sdq.sensitivity.SensitivityPackage#getDoubleOffsetSequence_DoubleOffsetType__DoubleOffsetSequence()
     * @model required="true" ordered="false"
     * @generated
     */
	DoubleOffsetType getDoubleOffsetType__DoubleOffsetSequence();

	/**
     * Sets the value of the '{@link de.uka.ipd.sdq.sensitivity.DoubleOffsetSequence#getDoubleOffsetType__DoubleOffsetSequence <em>Double Offset Type Double Offset Sequence</em>}' attribute.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * @param value the new value of the '<em>Double Offset Type Double Offset Sequence</em>' attribute.
     * @see de.uka.ipd.sdq.sensitivity.DoubleOffsetType
     * @see #getDoubleOffsetType__DoubleOffsetSequence()
     * @generated
     */
	void setDoubleOffsetType__DoubleOffsetSequence(DoubleOffsetType value);

} // DoubleOffsetSequence
