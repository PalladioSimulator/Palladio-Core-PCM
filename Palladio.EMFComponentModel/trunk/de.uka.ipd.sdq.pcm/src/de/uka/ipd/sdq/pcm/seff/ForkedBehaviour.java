/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Forked Behaviour</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.ForkedBehaviour#getNumberOfReplicas_ForkedBehaviour <em>Number Of Replicas Forked Behaviour</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getForkedBehaviour()
 * @model
 * @generated
 */
public interface ForkedBehaviour extends ResourceDemandingBehaviour {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Number Of Replicas Forked Behaviour</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Of Replicas Forked Behaviour</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Of Replicas Forked Behaviour</em>' containment reference.
	 * @see #setNumberOfReplicas_ForkedBehaviour(NumberOfReplicas)
	 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getForkedBehaviour_NumberOfReplicas_ForkedBehaviour()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	NumberOfReplicas getNumberOfReplicas_ForkedBehaviour();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.seff.ForkedBehaviour#getNumberOfReplicas_ForkedBehaviour <em>Number Of Replicas Forked Behaviour</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Of Replicas Forked Behaviour</em>' containment reference.
	 * @see #getNumberOfReplicas_ForkedBehaviour()
	 * @generated
	 */
	void setNumberOfReplicas_ForkedBehaviour(NumberOfReplicas value);

} // ForkedBehaviour
