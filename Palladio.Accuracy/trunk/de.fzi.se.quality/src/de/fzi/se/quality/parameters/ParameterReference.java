/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.fzi.se.quality.parameters;

import de.fzi.se.quality.qualityannotation.CallParameterDeviation;

import de.uka.ipd.sdq.identifier.Identifier;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.fzi.se.quality.parameters.ParameterReference#getParameterInstance <em>Parameter Instance</em>}</li>
 *   <li>{@link de.fzi.se.quality.parameters.ParameterReference#getCallParameterDeviation <em>Call Parameter Deviation</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.fzi.se.quality.parameters.ParametersPackage#getParameterReference()
 * @model abstract="true"
 * @generated
 */
public interface ParameterReference extends Identifier {
	/**
	 * Returns the value of the '<em><b>Parameter Instance</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fzi.se.quality.parameters.ParameterInstance#getParameterReference <em>Parameter Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Instance</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Instance</em>' container reference.
	 * @see #setParameterInstance(ParameterInstance)
	 * @see de.fzi.se.quality.parameters.ParametersPackage#getParameterReference_ParameterInstance()
	 * @see de.fzi.se.quality.parameters.ParameterInstance#getParameterReference
	 * @model opposite="parameterReference" transient="false" ordered="false"
	 * @generated
	 */
	ParameterInstance getParameterInstance();

	/**
	 * Sets the value of the '{@link de.fzi.se.quality.parameters.ParameterReference#getParameterInstance <em>Parameter Instance</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter Instance</em>' container reference.
	 * @see #getParameterInstance()
	 * @generated
	 */
	void setParameterInstance(ParameterInstance value);

	/**
	 * Returns the value of the '<em><b>Call Parameter Deviation</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.fzi.se.quality.qualityannotation.CallParameterDeviation#getParameterReference <em>Parameter Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Call Parameter Deviation</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Call Parameter Deviation</em>' container reference.
	 * @see #setCallParameterDeviation(CallParameterDeviation)
	 * @see de.fzi.se.quality.parameters.ParametersPackage#getParameterReference_CallParameterDeviation()
	 * @see de.fzi.se.quality.qualityannotation.CallParameterDeviation#getParameterReference
	 * @model opposite="parameterReference" transient="false" ordered="false"
	 * @generated
	 */
	CallParameterDeviation getCallParameterDeviation();

	/**
	 * Sets the value of the '{@link de.fzi.se.quality.parameters.ParameterReference#getCallParameterDeviation <em>Call Parameter Deviation</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Call Parameter Deviation</em>' container reference.
	 * @see #getCallParameterDeviation()
	 * @generated
	 */
	void setCallParameterDeviation(CallParameterDeviation value);

} // ParameterReference
