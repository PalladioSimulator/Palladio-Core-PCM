/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink;

import de.uka.ipd.sdq.pcm.seff.SetVariableAction;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Before Return Value Logging Position Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.BeforeReturnValueLoggingPositionLink#getLinkedSetVariableAction <em>Linked Set Variable Action</em>}</li>
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

} // BeforeReturnValueLoggingPositionLink
