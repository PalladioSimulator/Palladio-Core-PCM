/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fork Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.ForkAction#getAsynchronousForkedBehaviours_ForkAction <em>Asynchronous Forked Behaviours Fork Action</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.ForkAction#getSynchronisingBehaviours_ForkAction <em>Synchronising Behaviours Fork Action</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getForkAction()
 * @model
 * @generated
 */
public interface ForkAction extends AbstractInternalControlFlowAction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Asynchronous Forked Behaviours Fork Action</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.seff.ForkedBehaviour}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Asynchronous Forked Behaviours Fork Action</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Asynchronous Forked Behaviours Fork Action</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getForkAction_AsynchronousForkedBehaviours_ForkAction()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ForkedBehaviour> getAsynchronousForkedBehaviours_ForkAction();

	/**
	 * Returns the value of the '<em><b>Synchronising Behaviours Fork Action</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Synchronising Behaviours Fork Action</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Synchronising Behaviours Fork Action</em>' containment reference.
	 * @see #setSynchronisingBehaviours_ForkAction(SynchronisationPoint)
	 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getForkAction_SynchronisingBehaviours_ForkAction()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	SynchronisationPoint getSynchronisingBehaviours_ForkAction();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.seff.ForkAction#getSynchronisingBehaviours_ForkAction <em>Synchronising Behaviours Fork Action</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Synchronising Behaviours Fork Action</em>' containment reference.
	 * @see #getSynchronisingBehaviours_ForkAction()
	 * @generated
	 */
	void setSynchronisingBehaviours_ForkAction(SynchronisationPoint value);

} // ForkAction
