/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink;

import de.fzi.gast.statements.Statement;

import de.uka.ipd.sdq.identifier.Identifier;

import de.uka.ipd.sdq.pcm.seff.InternalAction;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Internal Action Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.InternalActionLink#getLinkedInternalAction <em>Linked Internal Action</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.InternalActionLink#getInternalActionStatements <em>Internal Action Statements</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.GastPcmLinkPackage#getInternalActionLink()
 * @model
 * @generated
 */
public interface InternalActionLink extends Identifier {
	/**
	 * Returns the value of the '<em><b>Linked Internal Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Linked Internal Action</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Linked Internal Action</em>' reference.
	 * @see #setLinkedInternalAction(InternalAction)
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.GastPcmLinkPackage#getInternalActionLink_LinkedInternalAction()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	InternalAction getLinkedInternalAction();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.InternalActionLink#getLinkedInternalAction <em>Linked Internal Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Linked Internal Action</em>' reference.
	 * @see #getLinkedInternalAction()
	 * @generated
	 */
	void setLinkedInternalAction(InternalAction value);

	/**
	 * Returns the value of the '<em><b>Internal Action Statements</b></em>' reference list.
	 * The list contents are of type {@link de.fzi.gast.statements.Statement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Internal Action Statements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Internal Action Statements</em>' reference list.
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.GastPcmLink.GastPcmLinkPackage#getInternalActionLink_InternalActionStatements()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	EList<Statement> getInternalActionStatements();

} // InternalActionLink
