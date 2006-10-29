
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff;

import de.uka.ipd.sdq.pcm.core.stochastics.RandomVariable;

import de.uka.ipd.sdq.pcm.repository.Parameter;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parametric Parameter Usage</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.ParametricParameterUsage#getCharacterisedParameter_ParametricParameterUsage <em>Characterised Parameter Parametric Parameter Usage</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getParametricParameterUsage()
 * @model abstract="true"
 * @generated
 */
public interface ParametricParameterUsage extends RandomVariable {
	/**
	 * Returns the value of the '<em><b>Characterised Parameter Parametric Parameter Usage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Characterised Parameter Parametric Parameter Usage</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Characterised Parameter Parametric Parameter Usage</em>' reference.
	 * @see #setCharacterisedParameter_ParametricParameterUsage(Parameter)
	 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getParametricParameterUsage_CharacterisedParameter_ParametricParameterUsage()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Parameter getCharacterisedParameter_ParametricParameterUsage();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.seff.ParametricParameterUsage#getCharacterisedParameter_ParametricParameterUsage <em>Characterised Parameter Parametric Parameter Usage</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Characterised Parameter Parametric Parameter Usage</em>' reference.
	 * @see #getCharacterisedParameter_ParametricParameterUsage()
	 * @generated
	 */
	void setCharacterisedParameter_ParametricParameterUsage(Parameter value);

} // ParametricParameterUsage