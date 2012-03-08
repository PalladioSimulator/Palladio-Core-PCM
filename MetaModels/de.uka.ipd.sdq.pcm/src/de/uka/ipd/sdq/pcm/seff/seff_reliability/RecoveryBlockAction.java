/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff.seff_reliability;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.pcm.seff.AbstractInternalControlFlowAction;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Recovery Block Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Recover block actions are a generic failure handling technique. A recovery block consists of a a primary algorithm and one
 * or more alternatives that can be used in case of failure. If the primary algorithm fails, the next alternative is chosen.
 * Here the alternatives also support failure types. Alternatives may specify which kind of failures they can handle.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryBlockAction#getRecoveryBlockAlternativeBehaviours_RecoveryBlockAction <em>Recovery Block Alternative Behaviours Recovery Block Action</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.seff.seff_reliability.Seff_reliabilityPackage#getRecoveryBlockAction()
 * @model
 * @generated
 */
public interface RecoveryBlockAction extends AbstractInternalControlFlowAction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Recovery Block Alternative Behaviours Recovery Block Action</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryBlockAlternativeBehaviour}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryBlockAlternativeBehaviour#getRecoveryBlockAction_RecoveryBlockAlternativeBehaviour <em>Recovery Block Action Recovery Block Alternative Behaviour</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Recovery Block Alternative Behaviours Recovery Block Action</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Recovery Block Alternative Behaviours Recovery Block Action</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.seff.seff_reliability.Seff_reliabilityPackage#getRecoveryBlockAction_RecoveryBlockAlternativeBehaviours_RecoveryBlockAction()
	 * @see de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryBlockAlternativeBehaviour#getRecoveryBlockAction_RecoveryBlockAlternativeBehaviour
	 * @model opposite="recoveryBlockAction_RecoveryBlockAlternativeBehaviour" containment="true" lower="2" ordered="false"
	 * @generated
	 */
	EList<RecoveryBlockAlternativeBehaviour> getRecoveryBlockAlternativeBehaviours_RecoveryBlockAction();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.recoveryBlockAlternativeBehaviours_RecoveryBlockAction->isUnique(s: RecoveryBlockAlternativeBehaviour | s.nextAlternative_RecoveryBlockAlternativeBehaviour) and
	 * self.recoveryBlockAlternativeBehaviours_RecoveryBlockAction->forAll(x:RecoveryBlockAlternativeBehaviour| x <> x.nextAlternative_RecoveryBlockAlternativeBehaviour)
	 * 
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='self.recoveryBlockAlternativeBehaviours_RecoveryBlockAction->isUnique(s: RecoveryBlockAlternativeBehaviour | s.nextAlternative_RecoveryBlockAlternativeBehaviour) and\r\nself.recoveryBlockAlternativeBehaviours_RecoveryBlockAction->forAll(x:RecoveryBlockAlternativeBehaviour| x <> x.nextAlternative_RecoveryBlockAlternativeBehaviour)\r\n'"
	 * @generated
	 */
	boolean Alternativesformachain(DiagnosticChain diagnostics, Map<Object, Object> context);

} // RecoveryBlockAction
