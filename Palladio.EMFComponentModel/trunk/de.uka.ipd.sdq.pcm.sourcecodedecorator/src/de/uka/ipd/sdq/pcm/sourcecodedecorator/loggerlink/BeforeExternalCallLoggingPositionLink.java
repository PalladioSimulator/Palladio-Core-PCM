/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink;

import de.uka.ipd.sdq.pcm.seff.AbstractAction;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Before External Call Logging Position Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.BeforeExternalCallLoggingPositionLink#getAbstractAction <em>Abstract Action</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggerlinkPackage#getBeforeExternalCallLoggingPositionLink()
 * @model
 * @generated
 */
public interface BeforeExternalCallLoggingPositionLink extends OutputLoggingPositionLink {
	/**
	 * Returns the value of the '<em><b>Abstract Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abstract Action</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Abstract Action</em>' reference.
	 * @see #setAbstractAction(AbstractAction)
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggerlinkPackage#getBeforeExternalCallLoggingPositionLink_AbstractAction()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	AbstractAction getAbstractAction();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.BeforeExternalCallLoggingPositionLink#getAbstractAction <em>Abstract Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Abstract Action</em>' reference.
	 * @see #getAbstractAction()
	 * @generated
	 */
	void setAbstractAction(AbstractAction value);

} // BeforeExternalCallLoggingPositionLink
