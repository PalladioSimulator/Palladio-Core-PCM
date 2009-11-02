/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink;

import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Before External Call Logging Position Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.BeforeExternalCallLoggingPositionLink#getLinkedExternalCallAction <em>Linked External Call Action</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggerlinkPackage#getBeforeExternalCallLoggingPositionLink()
 * @model
 * @generated
 */
public interface BeforeExternalCallLoggingPositionLink extends OutputLoggingPositionLink {
	/**
	 * Returns the value of the '<em><b>Linked External Call Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Linked External Call Action</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Linked External Call Action</em>' reference.
	 * @see #setLinkedExternalCallAction(ExternalCallAction)
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggerlinkPackage#getBeforeExternalCallLoggingPositionLink_LinkedExternalCallAction()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ExternalCallAction getLinkedExternalCallAction();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.BeforeExternalCallLoggingPositionLink#getLinkedExternalCallAction <em>Linked External Call Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Linked External Call Action</em>' reference.
	 * @see #getLinkedExternalCallAction()
	 * @generated
	 */
	void setLinkedExternalCallAction(ExternalCallAction value);

} // BeforeExternalCallLoggingPositionLink
