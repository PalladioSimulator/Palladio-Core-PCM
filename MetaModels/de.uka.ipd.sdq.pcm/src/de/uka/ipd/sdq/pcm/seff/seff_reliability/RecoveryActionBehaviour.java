/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.seff_reliability;

import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Recovery Action Behaviour</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * <p>
 *     Recovery block alternative haviours represent alternatives of recovery blocks. They are resource demanding behaviours,
 *     thus any behaviour can be defined as an alternative.
 * </p>
 * <p>
 *     The alternatives of a recovery block form a chain. They are failure handling entities, i.e.&nbsp;they can handle
 *     failures that occur in previous alternatives. If one alternative fails, the next alternative is executed that can
 *     handle the failure type.
 * </p>
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryActionBehaviour#getNextAlternative__RecoveryActionBehaviour <em>Next Alternative Recovery Action Behaviour</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryActionBehaviour#getRecoveryAction__RecoveryActionBehaviour <em>Recovery Action Recovery Action Behaviour</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.seff.seff_reliability.Seff_reliabilityPackage#getRecoveryActionBehaviour()
 * @model
 * @generated
 */
public interface RecoveryActionBehaviour extends FailureHandlingEntity, ResourceDemandingBehaviour {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Next Alternative Recovery Action Behaviour</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Next Alternative Recovery Action Behaviour</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Next Alternative Recovery Action Behaviour</em>' reference.
	 * @see #setNextAlternative__RecoveryActionBehaviour(RecoveryActionBehaviour)
	 * @see de.uka.ipd.sdq.pcm.seff.seff_reliability.Seff_reliabilityPackage#getRecoveryActionBehaviour_NextAlternative__RecoveryActionBehaviour()
	 * @model ordered="false"
	 * @generated
	 */
	RecoveryActionBehaviour getNextAlternative__RecoveryActionBehaviour();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryActionBehaviour#getNextAlternative__RecoveryActionBehaviour <em>Next Alternative Recovery Action Behaviour</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Next Alternative Recovery Action Behaviour</em>' reference.
	 * @see #getNextAlternative__RecoveryActionBehaviour()
	 * @generated
	 */
	void setNextAlternative__RecoveryActionBehaviour(RecoveryActionBehaviour value);

	/**
	 * Returns the value of the '<em><b>Recovery Action Recovery Action Behaviour</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryAction#getRecoveryActionBehaviours__RecoveryAction <em>Recovery Action Behaviours Recovery Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Recovery Action Recovery Action Behaviour</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Recovery Action Recovery Action Behaviour</em>' container reference.
	 * @see #setRecoveryAction__RecoveryActionBehaviour(RecoveryAction)
	 * @see de.uka.ipd.sdq.pcm.seff.seff_reliability.Seff_reliabilityPackage#getRecoveryActionBehaviour_RecoveryAction__RecoveryActionBehaviour()
	 * @see de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryAction#getRecoveryActionBehaviours__RecoveryAction
	 * @model opposite="recoveryActionBehaviours__RecoveryAction" required="true" transient="false" ordered="false"
	 * @generated
	 */
	RecoveryAction getRecoveryAction__RecoveryActionBehaviour();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryActionBehaviour#getRecoveryAction__RecoveryActionBehaviour <em>Recovery Action Recovery Action Behaviour</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Recovery Action Recovery Action Behaviour</em>' container reference.
	 * @see #getRecoveryAction__RecoveryActionBehaviour()
	 * @generated
	 */
	void setRecoveryAction__RecoveryActionBehaviour(RecoveryAction value);

} // RecoveryActionBehaviour
