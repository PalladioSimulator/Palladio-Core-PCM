/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink;

import de.fzi.gast.statements.Statement;

import de.uka.ipd.sdq.pcm.seff.GuardedBranchTransition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Branch Logging Position Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.BranchLoggingPositionLink#getLinkedGuardedBranchTransition <em>Linked Guarded Branch Transition</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.BranchLoggingPositionLink#getBranchStatement <em>Branch Statement</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggerlinkPackage#getBranchLoggingPositionLink()
 * @model
 * @generated
 */
public interface BranchLoggingPositionLink extends OutputLoggingPositionLink {
	/**
	 * Returns the value of the '<em><b>Linked Guarded Branch Transition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Linked Guarded Branch Transition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Linked Guarded Branch Transition</em>' reference.
	 * @see #setLinkedGuardedBranchTransition(GuardedBranchTransition)
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggerlinkPackage#getBranchLoggingPositionLink_LinkedGuardedBranchTransition()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	GuardedBranchTransition getLinkedGuardedBranchTransition();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.BranchLoggingPositionLink#getLinkedGuardedBranchTransition <em>Linked Guarded Branch Transition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Linked Guarded Branch Transition</em>' reference.
	 * @see #getLinkedGuardedBranchTransition()
	 * @generated
	 */
	void setLinkedGuardedBranchTransition(GuardedBranchTransition value);

	/**
	 * Returns the value of the '<em><b>Branch Statement</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Branch Statement</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Branch Statement</em>' reference.
	 * @see #setBranchStatement(Statement)
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.LoggerlinkPackage#getBranchLoggingPositionLink_BranchStatement()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	Statement getBranchStatement();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.loggerlink.BranchLoggingPositionLink#getBranchStatement <em>Branch Statement</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Branch Statement</em>' reference.
	 * @see #getBranchStatement()
	 * @generated
	 */
	void setBranchStatement(Statement value);

} // BranchLoggingPositionLink
