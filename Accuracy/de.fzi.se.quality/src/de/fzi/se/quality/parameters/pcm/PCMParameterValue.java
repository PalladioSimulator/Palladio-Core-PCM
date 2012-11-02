/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.parameters.pcm;

import de.fzi.se.quality.parameters.ParameterValue;

import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fzi.se.quality.parameters.pcm.PCMParameterValue#getVariableCharacterisation <em>Variable Characterisation</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.quality.parameters.pcm.PCMPackage#getPCMParameterValue()
 * @model
 * @generated
 */
public interface PCMParameterValue extends ParameterValue {
	/**
	 * Returns the value of the '<em><b>Variable Characterisation</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable Characterisation</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Characterisation</em>' containment reference list.
	 * @see de.fzi.se.quality.parameters.pcm.PCMPackage#getPCMParameterValue_VariableCharacterisation()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<VariableCharacterisation> getVariableCharacterisation();

} // PCMParameterValue
