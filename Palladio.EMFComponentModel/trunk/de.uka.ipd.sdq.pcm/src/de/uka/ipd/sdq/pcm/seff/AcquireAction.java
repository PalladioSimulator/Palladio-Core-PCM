/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff;

import de.uka.ipd.sdq.pcm.repository.PassiveResource;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Acquire Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * In an RDSEFF, component developers can specify an AcquireAction, which references a passive resource types. Once analysis tools execute this action, they decrease the amount of items available from the referenced passive resource type by one, if at least one item is available. If none item is available, because other, concurrently executed requests have acquired all of them, analysis tools enqueue the current request (first-come
 * first-serve scheduling policy) and block it’s further execution.
 * Acquisition and release of passive resources happen instantaneously and do not consume any time except for waiting delays before actual acquisition. Resource locking may introduce deadlocks when simulating the model, however, for performance analysis with the PCM it is assumed that no deadlocks occur. Otherwise, the model first needs to be fixed accordingly before carrying out the performance prediction.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.AcquireAction#getPassiveresource_AcquireAction <em>Passiveresource Acquire Action</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getAcquireAction()
 * @model
 * @generated
 */
public interface AcquireAction extends AbstractInternalControlFlowAction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Passiveresource Acquire Action</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Passiveresource Acquire Action</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Passiveresource Acquire Action</em>' reference.
	 * @see #setPassiveresource_AcquireAction(PassiveResource)
	 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getAcquireAction_Passiveresource_AcquireAction()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	PassiveResource getPassiveresource_AcquireAction();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.seff.AcquireAction#getPassiveresource_AcquireAction <em>Passiveresource Acquire Action</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Passiveresource Acquire Action</em>' reference.
	 * @see #getPassiveresource_AcquireAction()
	 * @generated
	 */
	void setPassiveresource_AcquireAction(PassiveResource value);

} // AcquireAction
