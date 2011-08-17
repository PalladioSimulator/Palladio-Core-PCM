/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink;

import de.fzi.gast.variables.FormalParameter;

import de.uka.ipd.sdq.identifier.Identifier;

import de.uka.ipd.sdq.pcm.repository.Parameter;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameter Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.ParameterLink#getLinkedParameter <em>Linked Parameter</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.ParameterLink#getParameter <em>Parameter</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.GastPcmLinkPackage#getParameterLink()
 * @model
 * @generated
 */
public interface ParameterLink extends Identifier {
	/**
	 * Returns the value of the '<em><b>Linked Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Linked Parameter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Linked Parameter</em>' reference.
	 * @see #setLinkedParameter(Parameter)
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.GastPcmLinkPackage#getParameterLink_LinkedParameter()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Parameter getLinkedParameter();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.ParameterLink#getLinkedParameter <em>Linked Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Linked Parameter</em>' reference.
	 * @see #getLinkedParameter()
	 * @generated
	 */
	void setLinkedParameter(Parameter value);

	/**
	 * Returns the value of the '<em><b>Parameter</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter</em>' reference.
	 * @see #setParameter(FormalParameter)
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.GastPcmLinkPackage#getParameterLink_Parameter()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	FormalParameter getParameter();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.ParameterLink#getParameter <em>Parameter</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parameter</em>' reference.
	 * @see #getParameter()
	 * @generated
	 */
	void setParameter(FormalParameter value);

} // ParameterLink
