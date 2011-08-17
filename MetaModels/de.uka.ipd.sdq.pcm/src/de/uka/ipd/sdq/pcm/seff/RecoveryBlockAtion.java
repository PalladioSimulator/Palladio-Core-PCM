/**
 * Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Recovery Block Ation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.RecoveryBlockAtion#getRecoveryblockalternativebehaviour <em>Recoveryblockalternativebehaviour</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getRecoveryBlockAtion()
 * @model
 * @generated
 */
public interface RecoveryBlockAtion extends AbstractInternalControlFlowAction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Recoveryblockalternativebehaviour</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.seff.RecoveryBlockAlternativeBehaviour}.
	 * It is bidirectional and its opposite is '{@link de.uka.ipd.sdq.pcm.seff.RecoveryBlockAlternativeBehaviour#getRecoveryblockation <em>Recoveryblockation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Recoveryblockalternativebehaviour</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Recoveryblockalternativebehaviour</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getRecoveryBlockAtion_Recoveryblockalternativebehaviour()
	 * @see de.uka.ipd.sdq.pcm.seff.RecoveryBlockAlternativeBehaviour#getRecoveryblockation
	 * @model opposite="recoveryblockation" containment="true" lower="2" ordered="false"
	 * @generated
	 */
	EList<RecoveryBlockAlternativeBehaviour> getRecoveryblockalternativebehaviour();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.alternativeBehaviours->select(  x | x.successor= null)->size() = 1
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model annotation="http://www.eclipse.org/uml2/1.1.0/GenModel body='self.alternativeBehaviours->select(  x | x.successor= null)->size() = 1'"
	 * @generated
	 */
	boolean OneChainOfAlternatives(DiagnosticChain diagnostics, Map<Object, Object> context);

} // RecoveryBlockAtion
