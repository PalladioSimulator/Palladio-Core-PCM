/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink;

import de.fzi.gast.functions.Function;

import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;

import de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.ParameterLink;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>After External Call Logging Position Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.AfterExternalCallLoggingPositionLink#getLinkedExternalCallAction <em>Linked External Call Action</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.AfterExternalCallLoggingPositionLink#getCalledFunction <em>Called Function</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.AfterExternalCallLoggingPositionLink#getParameterLink <em>Parameter Link</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggerlinkPackage#getAfterExternalCallLoggingPositionLink()
 * @model
 * @generated
 */
public interface AfterExternalCallLoggingPositionLink extends InputLoggingPositionLink {
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
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggerlinkPackage#getAfterExternalCallLoggingPositionLink_LinkedExternalCallAction()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ExternalCallAction getLinkedExternalCallAction();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.AfterExternalCallLoggingPositionLink#getLinkedExternalCallAction <em>Linked External Call Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Linked External Call Action</em>' reference.
	 * @see #getLinkedExternalCallAction()
	 * @generated
	 */
	void setLinkedExternalCallAction(ExternalCallAction value);

	/**
	 * Returns the value of the '<em><b>Called Function</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Called Function</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Called Function</em>' reference.
	 * @see #setCalledFunction(Function)
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggerlinkPackage#getAfterExternalCallLoggingPositionLink_CalledFunction()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Function getCalledFunction();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.AfterExternalCallLoggingPositionLink#getCalledFunction <em>Called Function</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Called Function</em>' reference.
	 * @see #getCalledFunction()
	 * @generated
	 */
	void setCalledFunction(Function value);

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
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggerlinkPackage#getAfterExternalCallLoggingPositionLink_ParameterLink()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ParameterLink> getParameterLink();

} // AfterExternalCallLoggingPositionLink
