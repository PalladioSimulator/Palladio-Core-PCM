
/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff;

import de.uka.ipd.sdq.pcm.core.entity.Entity;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.AbstractAction#getPredecessor_AbstractAction <em>Predecessor Abstract Action</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.AbstractAction#getSuccessor_AbstractAction <em>Successor Abstract Action</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getAbstractAction()
 * @model abstract="true"
 * @generated
 */
public interface AbstractAction extends Entity {
	/**
	 * Returns the value of the '<em><b>Predecessor Abstract Action</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.seff.AbstractAction#getSuccessor_AbstractAction <em>Successor Abstract Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Predecessor Abstract Action</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Predecessor Abstract Action</em>' reference.
	 * @see #setPredecessor_AbstractAction(AbstractAction)
	 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getAbstractAction_Predecessor_AbstractAction()
	 * @see de.uka.ipd.sdq.pcm.seff.AbstractAction#getSuccessor_AbstractAction
	 * @model opposite="successor_AbstractAction" ordered="false"
	 * @generated
	 */
	AbstractAction getPredecessor_AbstractAction();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.seff.AbstractAction#getPredecessor_AbstractAction <em>Predecessor Abstract Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Predecessor Abstract Action</em>' reference.
	 * @see #getPredecessor_AbstractAction()
	 * @generated
	 */
	void setPredecessor_AbstractAction(AbstractAction value);

	/**
	 * Returns the value of the '<em><b>Successor Abstract Action</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.seff.AbstractAction#getPredecessor_AbstractAction <em>Predecessor Abstract Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Successor Abstract Action</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Successor Abstract Action</em>' reference.
	 * @see #setSuccessor_AbstractAction(AbstractAction)
	 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getAbstractAction_Successor_AbstractAction()
	 * @see de.uka.ipd.sdq.pcm.seff.AbstractAction#getPredecessor_AbstractAction
	 * @model opposite="predecessor_AbstractAction" ordered="false"
	 * @generated
	 */
	AbstractAction getSuccessor_AbstractAction();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.seff.AbstractAction#getSuccessor_AbstractAction <em>Successor Abstract Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Successor Abstract Action</em>' reference.
	 * @see #getSuccessor_AbstractAction()
	 * @generated
	 */
	void setSuccessor_AbstractAction(AbstractAction value);

} // AbstractAction