package de.uka.ipd.sdq.pcmsolver.transformations.pcm2markov;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.markov.MarkovChain;
import de.uka.ipd.sdq.markov.State;
import de.uka.ipd.sdq.markov.StateType;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.AbstractBranchTransition;
import de.uka.ipd.sdq.pcm.seff.BranchAction;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.seff.LoopAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification;
import de.uka.ipd.sdq.pcm.seff.StartAction;
import de.uka.ipd.sdq.pcm.seff.StopAction;
import de.uka.ipd.sdq.pcm.seff.util.SeffSwitch;
import de.uka.ipd.sdq.pcmsolver.transformations.ContextWrapper;
import de.uka.ipd.sdq.pcmsolver.visitors.EMFHelper;
import de.uka.ipd.sdq.probfunction.math.ManagedPMF;

/**
 * This class represents a visitor for an RDSEFF within a PCM instance. The
 * visitor is used in the transformation from PCM with solved dependencies into
 * a Markov Chain Model for reliability prediction.
 * 
 * @author brosch
 */
public class MarkovSeffVisitor extends SeffSwitch<MarkovChain> {

	/**
	 * A logger to give detailed information about the PCM instance traversal.
	 */
	private static Logger logger = Logger.getLogger(MarkovSeffVisitor.class
			.getName());

	/**
	 * Temporary hack to include FailureProbabilities for SystemExternalCalls.
	 */
	public static ArrayList<String> sysExList = new ArrayList<String>();

	/**
	 * Temporary hack to include FailureProbabilities for SystemExternalCalls.
	 */
	public static ArrayList<String> failProbList = new ArrayList<String>();

	/**
	 * The ContextWrapper provides easy access to the decorations of the solved
	 * PCM instance.
	 */
	private ContextWrapper contextWrapper;

	/**
	 * The Markov Builder is used to create Markov Chain instances.
	 */
	private MarkovBuilder markovBuilder = new MarkovBuilder();

	/**
	 * The constructor.
	 * 
	 * @param wrapper
	 *            the ContextWrapper provides easy access to the decorations of
	 *            the solved PCM instance
	 */
	public MarkovSeffVisitor(final ContextWrapper wrapper) {
		contextWrapper = wrapper;
	}

	/**
	 * In the case of a ResourceDemandingBehaviour, the Chain of Actions is
	 * traversed to build an associated Markov Chain.
	 * 
	 * @param behaviour
	 *            the ResourceDemandingBehaviour
	 * @return the resulting Markov Chain
	 */
	@Override
	public MarkovChain caseResourceDemandingBehaviour(
			final ResourceDemandingBehaviour behaviour) {

		// Do the logging:
		logger.info("Visit ResourceDemandingBehaviour");

		// Go through the chain of actions that constitute this Behaviour. Each
		// action is expected to create its own specific Markov Chain:
		ArrayList<AbstractAction> actions = new ArrayList<AbstractAction>();
		ArrayList<MarkovChain> chains = new ArrayList<MarkovChain>();
		AbstractAction action = (StartAction) EMFHelper.getObjectByType(
				behaviour.getSteps_Behaviour(), StartAction.class);
		while (action != null) {
			MarkovChain specificMarkovChain = (MarkovChain) doSwitch(action);
			actions.add(action);
			chains.add(specificMarkovChain);
			action = action.getSuccessor_AbstractAction();
		}

		// Initialize a new aggregate Markov Chain that has one state for each
		// action of the action chain:
		ArrayList<State> states = new ArrayList<State>();
		MarkovChain aggregateMarkovChain = markovBuilder
				.initBehaviourMarkovChain("ResourceDemandingBehaviour",
						actions, states);

		// Incorporate the specific Chains into the aggregate Chain:
		for (int i = 0; i < actions.size(); i++) {
			markovBuilder.incorporateMarkovChain(aggregateMarkovChain, chains
					.get(i), states.get(i));
		}

		// Return the resulting Markov Chain:
		return aggregateMarkovChain;
	}

	/**
	 * All Actions in the ResourceDemandingSEFF are traversed to build an
	 * associated Markov Chain.
	 * 
	 * @param seff
	 *            the ResourceDemandingSEFF
	 * @return the resulting Markov Chain
	 */
	@Override
	public MarkovChain caseResourceDemandingSEFF(
			final ResourceDemandingSEFF seff) {

		// Do the logging:
		logger.info("Visit ResourceDemandingSEFF ["
				+ seff.getDescribedService__SEFF().getServiceName() + "]");

		// Go through the chain of actions that constitute this RDSEFF. Each
		// action is expected to create its own specific Markov Chain:
		ArrayList<AbstractAction> actions = new ArrayList<AbstractAction>();
		ArrayList<MarkovChain> chains = new ArrayList<MarkovChain>();
		AbstractAction action = (StartAction) EMFHelper.getObjectByType(seff
				.getSteps_Behaviour(), StartAction.class);
		while (action != null) {
			MarkovChain specificMarkovChain = (MarkovChain) doSwitch(action);
			actions.add(action);
			chains.add(specificMarkovChain);
			action = action.getSuccessor_AbstractAction();
		}

		// Initialize a new aggregate Markov Chain that has one state for each
		// action of the action chain:
		ArrayList<State> states = new ArrayList<State>();
		MarkovChain aggregateMarkovChain = markovBuilder
				.initBehaviourMarkovChain(seff.getDescribedService__SEFF()
						.getServiceName(), actions, states);

		// Incorporate the specific Chains into the aggregate Chain:
		for (int i = 0; i < actions.size(); i++) {
			markovBuilder.incorporateMarkovChain(aggregateMarkovChain, chains
					.get(i), states.get(i));
		}

		// Return the resulting Markov Chain:
		return aggregateMarkovChain;
	}

	/**
	 * A StartAction returns a trivial Markov Chain.
	 * 
	 * @param startAction
	 *            the StartAction
	 * @return the resulting trivial Markov Chain
	 */
	@Override
	public MarkovChain caseStartAction(final StartAction startAction) {

		// Do the logging:
		logger.info("Visit StartAction [" + startAction.getEntityName() + "]");

		return markovBuilder.initNewMarkovChain(startAction.getEntityName());
	}

	/**
	 * An InternalAction returns a Markov Chain with two Transitions. The first
	 * transition represents Success and the second one Failure of the
	 * InternalAction.
	 * 
	 * @param internalAction
	 *            the InternalAction
	 * @return the resulting Markov Chain
	 */
	@Override
	public MarkovChain caseInternalAction(final InternalAction internalAction) {

		// Do the logging:
		logger.info("Visit InternalAction [" + internalAction.getEntityName()
				+ "]");

		return markovBuilder.initInternalMarkovChain(internalAction
				.getEntityName(), ((Double)internalAction.getFailureProbability()).toString());
	}

	/**
	 * For a LoopAction, first the Markov Chain of the body behaviour is built.
	 * The result is then inserted into a new Markov Chain that has one State
	 * for each of the possible iteration counts of the loop.
	 * 
	 * @param loopAction
	 *            the LoopAction
	 * @return the resulting Markov Chain
	 */
	@Override
	public MarkovChain caseLoopAction(final LoopAction loopAction) {

		// Do the logging:
		logger.info("Visit LoopAction [" + loopAction.getEntityName() + "]");

		// Determine the inner Markov Chain associated with the loop behaviour:
		MarkovChain specificMarkovChain = (MarkovChain) doSwitch(loopAction
				.getBodyBehaviour_Loop());

		// Get the solved loop probability mass function:
		ManagedPMF pmf = contextWrapper.getLoopIterations(loopAction);

		// Initialize the aggregate Markov Chain representing the loop:
		MarkovChain aggregateMarkovChain = markovBuilder.initLoopMarkovChain(
				loopAction.getEntityName(), pmf);

		// Incorporate the specific MarkovChain into the aggregate one:
		ArrayList<State> statesToReplace = new ArrayList<State>();
		for (int i = 0; i < aggregateMarkovChain.getStates().size(); i++) {
			if (aggregateMarkovChain.getStates().get(i).getType().equals(
					StateType.DEFAULT)) {
				statesToReplace.add(aggregateMarkovChain.getStates().get(i));
			}
		}
		for (int i = 0; i < statesToReplace.size(); i++) {
			markovBuilder.incorporateMarkovChain(aggregateMarkovChain,
					specificMarkovChain, statesToReplace.get(i));
		}

		// Return the result:
		return aggregateMarkovChain;
	}

	/**
	 * For a BranchAction, first the Markov Chain of each of the transition
	 * behaviours is built. The results are then inserted into a new Markov
	 * Chain that has one State for each of the possible branches.
	 * 
	 * @param branchAction
	 *            the BranchAction
	 * @return the resulting Markov Chain
	 */
	@Override
	public MarkovChain caseBranchAction(final BranchAction branchAction) {

		// Do the logging:
		logger
				.info("Visit BranchAction [" + branchAction.getEntityName()
						+ "]");

		// Determine the inner Markov Chains associated with the branch
		// behaviours:
		EList<AbstractBranchTransition> transitions = branchAction
				.getBranches_Branch();
		ArrayList<MarkovChain> specificMarkovChains = new ArrayList<MarkovChain>();
		ArrayList<Double> branchProbabilities = new ArrayList<Double>();
		for (int i = 0; i < transitions.size(); i++) {
			branchProbabilities.add(contextWrapper
					.getBranchProbability(transitions.get(i)));
			specificMarkovChains.add((MarkovChain) doSwitch(transitions.get(i)
					.getBranchBehaviour_BranchTransition()));
		}

		// Initialize the aggregate Markov Chain representing the loop:
		MarkovChain aggregateMarkovChain = markovBuilder.initBranchMarkovChain(
				branchAction.getEntityName(), branchProbabilities);

		// Incorporate the specific MarkovChain into the aggregate one:
		ArrayList<State> statesToReplace = new ArrayList<State>();
		for (int i = 0; i < aggregateMarkovChain.getStates().size(); i++) {
			if (aggregateMarkovChain.getStates().get(i).getType().equals(
					StateType.DEFAULT)) {
				statesToReplace.add(aggregateMarkovChain.getStates().get(i));
			}
		}
		for (int i = 0; i < statesToReplace.size(); i++) {
			markovBuilder.incorporateMarkovChain(aggregateMarkovChain,
					specificMarkovChains.get(i), statesToReplace.get(i));
		}

		// Return the result:
		return aggregateMarkovChain;
	}

	/**
	 * An ExternalCallAction returns the Markov Chain of the executing
	 * behaviour, or a trivial Markov Chain if it is a SystemExternalCall.
	 * 
	 * @param externalCallAction
	 *            the ExternalCallAction
	 * @return the resulting Markov Chain.
	 */
	@Override
	public MarkovChain caseExternalCallAction(
			final ExternalCallAction externalCallAction) {

		// Get a reference to the executing SEFF:
		ServiceEffectSpecification seff = contextWrapper
				.getNextSEFF(externalCallAction);

		// Distinguish the type of the ExternalCall:
		if (seff == null) {

			// Do the logging:
			logger.info("Visit SystemExternalCallAction ["
					+ externalCallAction.getEntityName() + "]");

			// Get the FailureProbability of the SystemExternalCall (this is, by
			// now, a hack):
			String failureProbabilityExpression = failProbList.get(sysExList
					.indexOf(externalCallAction.getId()));

			// A SystemExternalCall is treated like an InternalAction - it has
			// just one fixed failureProbability:
			return markovBuilder.initInternalMarkovChain(externalCallAction
					.getEntityName(), failureProbabilityExpression);

		} else {

			// Do the logging:
			logger.info("Visit ExternalCallAction ["
					+ externalCallAction.getEntityName() + "]");

			// For the new SEFF, we need a new ContextWrapper. As during the
			// creation of the new ContextWrapper, the old one is altered (which
			// is certainly bad programming style!), we need to save a copy of
			// the old one and restore it after generating the new one:
			ContextWrapper originalContextWrapper = (ContextWrapper) contextWrapper
					.clone();
			ContextWrapper newContextWrapper = contextWrapper
					.getContextWrapperFor(externalCallAction);
			contextWrapper = originalContextWrapper;

			// Return the Markov Chain of the executing SEFF:
			return new MarkovSeffVisitor(newContextWrapper).doSwitch(seff);
		}
	}

	/**
	 * A StopAction returns a trivial Markov Chain.
	 * 
	 * @param stopAction
	 *            the StopAction
	 * @return the resulting trivial Markov Chain
	 */
	@Override
	public MarkovChain caseStopAction(final StopAction stopAction) {

		// Do the logging:
		logger.info("Visit StopAction [" + stopAction.getEntityName() + "]");

		return markovBuilder.initNewMarkovChain(stopAction.getEntityName());
	}
}
