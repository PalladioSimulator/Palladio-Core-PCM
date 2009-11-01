/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink;

import de.uka.ipd.sdq.identifier.Identifier;

import de.uka.ipd.sdq.pcm.seff.AbstractAction;

import de.uka.ipd.sdq.pcm.sourcecodedecorator.sourcecodedecorator.ControlFlowLevelSourceCodeLink;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Action Control Flow Link</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.ActionControlFlowLink#getControlflowlevelsourcecodelink <em>Controlflowlevelsourcecodelink</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.ActionControlFlowLink#getAbstractaction <em>Abstractaction</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.PCMLinkPackage#getActionControlFlowLink()
 * @model
 * @generated
 */
public interface ActionControlFlowLink extends Identifier {
	/**
	 * Returns the value of the '<em><b>Controlflowlevelsourcecodelink</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Controlflowlevelsourcecodelink</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Controlflowlevelsourcecodelink</em>' reference.
	 * @see #setControlflowlevelsourcecodelink(ControlFlowLevelSourceCodeLink)
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.PCMLinkPackage#getActionControlFlowLink_Controlflowlevelsourcecodelink()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	ControlFlowLevelSourceCodeLink getControlflowlevelsourcecodelink();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.ActionControlFlowLink#getControlflowlevelsourcecodelink <em>Controlflowlevelsourcecodelink</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Controlflowlevelsourcecodelink</em>' reference.
	 * @see #getControlflowlevelsourcecodelink()
	 * @generated
	 */
	void setControlflowlevelsourcecodelink(ControlFlowLevelSourceCodeLink value);

	/**
	 * Returns the value of the '<em><b>Abstractaction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abstractaction</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Abstractaction</em>' reference.
	 * @see #setAbstractaction(AbstractAction)
	 * @see de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.PCMLinkPackage#getActionControlFlowLink_Abstractaction()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	AbstractAction getAbstractaction();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.sourcecodedecorator.PCMLink.ActionControlFlowLink#getAbstractaction <em>Abstractaction</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Abstractaction</em>' reference.
	 * @see #getAbstractaction()
	 * @generated
	 */
	void setAbstractaction(AbstractAction value);

} // ActionControlFlowLink
