/**
 * Copyright 2007 by SDQ, IPD, University of Karlsruhe, Germany
 *
 * $Id$
 */
package de.uka.ipd.sdq.pcm.seff;

import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Guarded Branch Transition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <!-- begin-model-doc -->
 * Guarded Branch Transition Provides a link between a BranchAction and a nested ResourceDemandingBehaviour, which includes the actions executed inside the branch. It uses a guard, i.e. a boolean expression specified by a RandomVariable, to determine whether the transition is chosen. If the guard evaluates to true, the branch is chosen, otherwise if the guard evaluates to false another branch transition must be chosen.
 * The guard may contain references to the service’s input parameters or component parameters. A component developer can specify complex boolean expressions by using the AND, OR, and NOT operations provided by the StoEx framework. As the domain expert may have characterised the parameters used in a guard with probability distributions, it might happen that a guard does not evaluate to true or false with a probability of 1.0. For example, the specification can express that a guard evaluates to true with a probability of 0.3, and to false with a probability of 0.7. In any case, the probabilities of the individual guards attached to all GuardedBranchTransitions contained in a BranchAction must sum up to 1.0.
 * There is no predefined order in evaluating the guards attached to a BranchAction. This differs from programming languages such as C or Java, where the conditions on if/then/else statements are evaluated in the order of their appearance in the code. Such programming languages allow overlapping branching conditions (for example, if (X<10) //... else if (X<20) // ...), which are not allowed for the guards in GuardedBranchTransitions, because the missing order specification would lead to ambiguous boolean expressions and enable more than one guard to become true. If X would have the value 5, both conditions would evaluate to true if they would be used directly as guards in GuardedBranchTransitions. The correct specification of the guards in this case would be X.VALUE   10 and X.VALUE ¥ 10 AND X.VALUE   20. Guards might lead to stochastic dependencies when evaluating variable characterisations inside a branched behaviour. For example, if the guard X.VALUE   10 had formerly evaluated to true, and the RDSEFF uses X.VALUE inside the branched behaviour, the sample space of the random variable specifying the characterisation must be restricted, as the event that X takes a values greater than 10 cannot occur anymore. Therefore its probability is zero. Any variable characterisation always needs to be evaluated under the condition that all guards in the usage scenario’s path to it have evaluated to true.
 * <!-- end-model-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link de.uka.ipd.sdq.pcm.seff.GuardedBranchTransition#getBranchCondition_GuardedBranchTransition <em>Branch Condition Guarded Branch Transition</em>}</li>
 * </ul>
 * </p>
 *
 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getGuardedBranchTransition()
 * @model
 * @generated
 */
public interface GuardedBranchTransition extends AbstractBranchTransition {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2005-2009 by SDQ, IPD, University of Karlsruhe, Germany";

	/**
	 * Returns the value of the '<em><b>Branch Condition Guarded Branch Transition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Branch Condition Guarded Branch Transition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Branch Condition Guarded Branch Transition</em>' containment reference.
	 * @see #setBranchCondition_GuardedBranchTransition(PCMRandomVariable)
	 * @see de.uka.ipd.sdq.pcm.seff.SeffPackage#getGuardedBranchTransition_BranchCondition_GuardedBranchTransition()
	 * @model containment="true" required="true" ordered="false"
	 * @generated
	 */
	PCMRandomVariable getBranchCondition_GuardedBranchTransition();

	/**
	 * Sets the value of the '{@link de.uka.ipd.sdq.pcm.seff.GuardedBranchTransition#getBranchCondition_GuardedBranchTransition <em>Branch Condition Guarded Branch Transition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Branch Condition Guarded Branch Transition</em>' containment reference.
	 * @see #getBranchCondition_GuardedBranchTransition()
	 * @generated
	 */
	void setBranchCondition_GuardedBranchTransition(PCMRandomVariable value);

} // GuardedBranchTransition
