/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Branch Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * The BranchAction splits the RDSEFF control flow with an XOR-semantic, meaning that the control flow continues on exactly one of its attached AbstractBranchTransitions. The RDSEFF supports two different kinds of branch transitions, GuardedBranchTransitions, and  ProbabilisticBranchTransitions. RDSEFFs do not allow to use both kinds of transitions on a single BranchAction. Analysis or simulation tools must select exactly one transition based on the included guard or probability, before continuing at a BranchAction.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.BranchAction#getBranches_Branch <em>Branches Branch</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getBranchAction()
 * @model
 * @generated
 */
public interface BranchAction extends AbstractInternalControlFlowAction {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2008 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Branches Branch</b></em>' containment reference list.
	 * The list contents are of type {@link de.uka.ipd.sdq.pcm.seff.AbstractBranchTransition}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Branches Branch</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Branches Branch</em>' containment reference list.
	 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getBranchAction_Branches_Branch()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<AbstractBranchTransition> getBranches_Branch();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * self.branches_Branch->forAll(bt|bt.oclIsTypeOf(ProbabilisticBranchTransition)) or self.branches_Branch->forAll(bt|bt.oclIsTypeOf(GuardedBranchTransition))
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean EitherGuardedBranchesOrProbabilisiticBranchTransitions(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * <!-- begin-model-doc -->
	 * if self.branches_Branch->forAll(oclIsTypeOf(ProbabilisticBranchTransition)) then self.branches_Branch->select(pbt|pbt.oclIsTypeOf(ProbabilisticBranchTransition))->collect(pbt|pbt.oclAsType(ProbabilisticBranchTransition).branchProbability)->sum() > 0.999 and self.branches_Branch->select(pbt|pbt.oclIsTypeOf(ProbabilisticBranchTransition))->collect(pbt|pbt.oclAsType(ProbabilisticBranchTransition).branchProbability)->sum() < 1.001 else true endif
	 * @param diagnostics The chain of diagnostics to which problems are to be appended.
	 * @param context The cache of context-specific information.
	 * <!-- end-model-doc -->
	 * @model
	 * @generated
	 */
	boolean AllProbabilisticBranchProbabilitiesMustSumUpTo1(DiagnosticChain diagnostics, Map<Object, Object> context);

} // BranchAction
