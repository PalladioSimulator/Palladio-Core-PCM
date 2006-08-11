
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff;

import de.uka.ipd.sdq.pcm.parameter.PrimitiveParameterCharacterisationType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primitive Parametric Parameter Usage</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.PrimitiveParametricParameterUsage#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getPrimitiveParametricParameterUsage()
 * @model
 * @generated
 */
public interface PrimitiveParametricParameterUsage extends ParametricParameterUsage {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link de.uka.ipd.sdq.pcm.parameter.PrimitiveParameterCharacterisationType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see de.uka.ipd.sdq.pcm.parameter.PrimitiveParameterCharacterisationType
	 * @see #setType(PrimitiveParameterCharacterisationType)
	 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getPrimitiveParametricParameterUsage_Type()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	PrimitiveParameterCharacterisationType getType();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.seff.PrimitiveParametricParameterUsage#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see de.uka.ipd.sdq.pcm.parameter.PrimitiveParameterCharacterisationType
	 * @see #getType()
	 * @generated
	 */
	void setType(PrimitiveParameterCharacterisationType value);

} // PrimitiveParametricParameterUsage