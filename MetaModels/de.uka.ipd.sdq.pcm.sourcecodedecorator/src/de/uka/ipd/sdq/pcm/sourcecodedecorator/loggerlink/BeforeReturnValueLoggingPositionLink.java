/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink;

import de.fzi.gast.functions.Function;

import de.uka.ipd.sdq.pcm.seff.SetVariableAction;

import de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.ParameterLink;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Before Return Value Logging Position Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.BeforeReturnValueLoggingPositionLink#getLinkedSetVariableAction <em>Linked Set Variable Action</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.BeforeReturnValueLoggingPositionLink#getProvidedFunctionOfSurroundingSeff <em>Provided Function Of Surrounding Seff</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.BeforeReturnValueLoggingPositionLink#getParameterLink <em>Parameter Link</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggerlinkPackage#getBeforeReturnValueLoggingPositionLink()
 * @model
 * @generated
 */
public interface BeforeReturnValueLoggingPositionLink extends OutputLoggingPositionLink {
	/**
	 * Returns the value of the '<em><b>Linked Set Variable Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Linked Set Variable Action</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Linked Set Variable Action</em>' reference.
	 * @see #setLinkedSetVariableAction(SetVariableAction)
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggerlinkPackage#getBeforeReturnValueLoggingPositionLink_LinkedSetVariableAction()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	SetVariableAction getLinkedSetVariableAction();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.BeforeReturnValueLoggingPositionLink#getLinkedSetVariableAction <em>Linked Set Variable Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Linked Set Variable Action</em>' reference.
	 * @see #getLinkedSetVariableAction()
	 * @generated
	 */
	void setLinkedSetVariableAction(SetVariableAction value);

	/**
	 * Returns the value of the '<em><b>Provided Function Of Surrounding Seff</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provided Function Of Surrounding Seff</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provided Function Of Surrounding Seff</em>' reference.
	 * @see #setProvidedFunctionOfSurroundingSeff(Function)
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggerlinkPackage#getBeforeReturnValueLoggingPositionLink_ProvidedFunctionOfSurroundingSeff()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Function getProvidedFunctionOfSurroundingSeff();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.BeforeReturnValueLoggingPositionLink#getProvidedFunctionOfSurroundingSeff <em>Provided Function Of Surrounding Seff</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Provided Function Of Surrounding Seff</em>' reference.
	 * @see #getProvidedFunctionOfSurroundingSeff()
	 * @generated
	 */
	void setProvidedFunctionOfSurroundingSeff(Function value);

	/**
	 * Returns the value of the '<em><b>Parameter Link</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.ParameterLink}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter Link</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameter Link</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggerlinkPackage#getBeforeReturnValueLoggingPositionLink_ParameterLink()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ParameterLink> getParameterLink();

} // BeforeReturnValueLoggingPositionLink
