/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Recovery Block Alternative Behaviour</b></em>'.
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
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.RecoveryBlockAlternativeBehaviour#getNextAlternative <em>Next Alternative</em>}</li>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.RecoveryBlockAlternativeBehaviour#getRecoveryBlockAction_RecoveryBlockAlternativeBehaviour <em>Recovery Block Action Recovery Block Alternative Behaviour</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getRecoveryBlockAlternativeBehaviour()
 * @model
 * @generated
 */
public interface RecoveryBlockAlternativeBehaviour extends FailureHandlingEntity, ResourceDemandingBehaviour {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Next Alternative</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Next Alternative</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Next Alternative</em>' reference.
	 * @see #setNextAlternative(RecoveryBlockAlternativeBehaviour)
	 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getRecoveryBlockAlternativeBehaviour_NextAlternative()
	 * @model ordered="false"
	 * @generated
	 */
	RecoveryBlockAlternativeBehaviour getNextAlternative();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.seff.RecoveryBlockAlternativeBehaviour#getNextAlternative <em>Next Alternative</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Next Alternative</em>' reference.
	 * @see #getNextAlternative()
	 * @generated
	 */
	void setNextAlternative(RecoveryBlockAlternativeBehaviour value);

	/**
	 * Returns the value of the '<em><b>Recovery Block Action Recovery Block Alternative Behaviour</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.seff.RecoveryBlockAction#getRecoveryBlockalternativeBehaviours <em>Recovery Blockalternative Behaviours</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Recovery Block Action Recovery Block Alternative Behaviour</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Recovery Block Action Recovery Block Alternative Behaviour</em>' container reference.
	 * @see #setRecoveryBlockAction_RecoveryBlockAlternativeBehaviour(RecoveryBlockAction)
	 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getRecoveryBlockAlternativeBehaviour_RecoveryBlockAction_RecoveryBlockAlternativeBehaviour()
	 * @see de.uka.ipd.sdq.pcm.seff.RecoveryBlockAction#getRecoveryBlockalternativeBehaviours
	 * @model opposite="recoveryBlockalternativeBehaviours" required="true" transient="false" ordered="false"
	 * @generated
	 */
	RecoveryBlockAction getRecoveryBlockAction_RecoveryBlockAlternativeBehaviour();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.seff.RecoveryBlockAlternativeBehaviour#getRecoveryBlockAction_RecoveryBlockAlternativeBehaviour <em>Recovery Block Action Recovery Block Alternative Behaviour</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Recovery Block Action Recovery Block Alternative Behaviour</em>' container reference.
	 * @see #getRecoveryBlockAction_RecoveryBlockAlternativeBehaviour()
	 * @generated
	 */
	void setRecoveryBlockAction_RecoveryBlockAlternativeBehaviour(RecoveryBlockAction value);

} // RecoveryBlockAlternativeBehaviour
