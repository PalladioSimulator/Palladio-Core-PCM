
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.parameter;

import de.uka.ipd.sdq.stoex.AbstractNamedReference;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Usage</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.VariableUsage#getVariableCharacterisation_VariableUsage <em>Variable Characterisation Variable Usage</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.parameter.VariableUsage#getNamedReference_VariableUsage <em>Named Reference Variable Usage</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getVariableUsage()
 * @model
 * @generated
 */
public interface VariableUsage extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Variable Characterisation Variable Usage</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable Characterisation Variable Usage</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Characterisation Variable Usage</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getVariableUsage_VariableCharacterisation_VariableUsage()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<VariableCharacterisation> getVariableCharacterisation_VariableUsage();

	/**
	 * Returns the value of the '<em><b>Named Reference Variable Usage</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Named Reference Variable Usage</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Named Reference Variable Usage</em>' containment reference.
	 * @see #setNamedReference_VariableUsage(AbstractNamedReference)
	 * @see de.uka.ipd.sdq.pcm.parameter.ParameterPackage#getVariableUsage_NamedReference_VariableUsage()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	AbstractNamedReference getNamedReference_VariableUsage();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.parameter.VariableUsage#getNamedReference_VariableUsage <em>Named Reference Variable Usage</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Named Reference Variable Usage</em>' containment reference.
	 * @see #getNamedReference_VariableUsage()
	 * @generated
	 */
	void setNamedReference_VariableUsage(AbstractNamedReference value);

} // VariableUsage
