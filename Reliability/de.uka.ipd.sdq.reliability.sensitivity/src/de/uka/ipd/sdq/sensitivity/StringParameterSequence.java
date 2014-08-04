/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.sensitivity;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>String Parameter Sequence</b></em>'. <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>
 * Specifies&nbsp;a variation&nbsp;of&nbsp;a&nbsp;sensitivity parameter of type STRING (e.g. for
 * stochastic expressions). The specification is given as a sequence of strings.
 * </p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 * <li>{@link de.uka.ipd.sdq.sensitivity.StringParameterSequence#getStringValues <em>String Values
 * </em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.sensitivity.SensitivityPackage#getStringParameterSequence()
 * @model
 * @generated
 */
public interface StringParameterSequence extends SensitivityParameterVariation {
    /**
     * Returns the value of the '<em><b>String Values</b></em>' attribute list. The list contents
     * are of type {@link java.lang.String}. <!-- begin-user-doc --> <!-- end-user-doc --> <!--
     * begin-model-doc --> The&nbsp;list&nbsp;of&nbsp;STRING&nbsp;values. <!-- end-model-doc -->
     * 
     * @return the value of the '<em>String Values</em>' attribute list.
     * @see de.uka.ipd.sdq.sensitivity.SensitivityPackage#getStringParameterSequence_StringValues()
     * @model unique="false" required="true" ordered="false"
     * @generated
     */
    EList<String> getStringValues();

} // StringParameterSequence
