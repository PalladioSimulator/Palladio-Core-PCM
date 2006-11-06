
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.parameter;

import de.uka.ipd.sdq.pcm.repository.Parameter;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Usage</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.ParameterUsage#getParameter_ParameterUsage <em>Parameter Parameter Usage</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.ParameterUsage#getParameterCharacterisation_ParameterUsage <em>Parameter Characterisation Parameter Usage</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getParameterUsage()
 * @model
 * @generated
 */
public interface ParameterUsage extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "(c) by SDQ, IPD, U Karlsruhe (TH), 2006";

	/**
	 * Returns the value of the '<em><b>Parameter Parameter Usage</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Parameter Usage</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Parameter Usage</em>' reference.
	 * @see #setParameter_ParameterUsage(Parameter)
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getParameterUsage_Parameter_ParameterUsage()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Parameter getParameter_ParameterUsage();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.parameter.ParameterUsage#getParameter_ParameterUsage <em>Parameter Parameter Usage</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter Parameter Usage</em>' reference.
	 * @see #getParameter_ParameterUsage()
	 * @generated
	 */
	void setParameter_ParameterUsage(Parameter value);

	/**
	 * Returns the value of the '<em><b>Parameter Characterisation Parameter Usage</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.parameter.PrimitiveParameterCharacterisation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Characterisation Parameter Usage</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Characterisation Parameter Usage</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getParameterUsage_ParameterCharacterisation_ParameterUsage()
	 * @model type="de.uka.ipd.sdq.pcm.parameter.PrimitiveParameterCharacterisation" containment="true" ordered="false"
	 * @generated
	 */
	EList getParameterCharacterisation_ParameterUsage();

} // ParameterUsage