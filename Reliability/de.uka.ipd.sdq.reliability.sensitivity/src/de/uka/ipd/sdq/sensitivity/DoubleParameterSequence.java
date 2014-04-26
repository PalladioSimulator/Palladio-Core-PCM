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
 * A representation of the model object '<em><b>Double Parameter Sequence</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Specifies&nbsp;a sequence of values, to define&nbsp;a variation&nbsp;of&nbsp;a&nbsp;sensitivity parameter of type DOUBLE.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.sensitivity.DoubleParameterSequence#getDoubleValues <em>Double Values</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.sensitivity.SensitivityPackage#getDoubleParameterSequence()
 * @model
 * @generated
 */
public interface DoubleParameterSequence extends DoubleParameterVariation {
	/**
     * Returns the value of the '<em><b>Double Values</b></em>' attribute list.
     * The list contents are of type {@link java.lang.Double}.
     * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
     * <!-- begin-model-doc -->
     * The&nbsp;list&nbsp;of&nbsp;DOUBLE&nbsp;values.
     * <!-- end-model-doc -->
     * @return the value of the '<em>Double Values</em>' attribute list.
     * @see de.uka.ipd.sdq.sensitivity.SensitivityPackage#getDoubleParameterSequence_DoubleValues()
     * @model unique="false" required="true"
     * @generated
     */
	EList<Double> getDoubleValues();

} // DoubleParameterSequence
