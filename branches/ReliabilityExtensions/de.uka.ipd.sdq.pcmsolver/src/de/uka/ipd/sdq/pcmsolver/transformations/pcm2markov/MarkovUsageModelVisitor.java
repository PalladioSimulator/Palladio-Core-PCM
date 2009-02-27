package de.uka.ipd.sdq.pcmsolver.transformations.pcm2markov;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.edit.command.OverrideableCommand;

import de.uka.ipd.sdq.markov.MarkovChain;
import de.uka.ipd.sdq.markov.State;
import de.uka.ipd.sdq.markov.StateType;
import de.uka.ipd.sdq.pcm.core.composition.ProvidedDelegationConnector;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.repository.ProvidedRole;
import de.uka.ipd.sdq.pcm.repository.ProvidesComponentType;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.seff.AbstractBranchTransition;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification;
import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import de.uka.ipd.sdq.pcm.usagemodel.Branch;
import de.uka.ipd.sdq.pcm.usagemodel.BranchTransition;
import de.uka.ipd.sdq.pcm.usagemodel.Delay;
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;
import de.uka.ipd.sdq.pcm.usagemodel.Loop;
import de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour;
import de.uka.ipd.sdq.pcm.usagemodel.Start;
import de.uka.ipd.sdq.pcm.usagemodel.Stop;
import de.uka.ipd.sdq.pcm.usagemodel.util.UsagemodelSwitch;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;
import de.uka.ipd.sdq.pcmsolver.transformations.ContextWrapper;
import de.uka.ipd.sdq.pcmsolver.visitors.EMFHelper;
import de.uka.ipd.sdq.probfunction.math.ManagedPMF;

/**
 * This class represents a visitor for a UsageModel within a PCM instance. The
 * visitor is used in the transformation from PCM with solved dependencies into
 * a Markov Chain Model for reliability prediction.
 * 
 * @author brosch
 * 
 */
public class MarkovUsageModelVisitor extends UsagemodelSwitch<MarkovChain> {

	/**
	 * A logger to give detailed information about the PCM instance traversal.
	 */
	private static Logger logger = Logger
			.getLogger(MarkovUsageModelVisitor.class.getName());

	/**
	 * Indicates if the Markov Chain reduction is performed during the
	 * transformation. If so, then the chain as a whole never exists, because
	 * during construction, it is already reduced again.
	 */
	private boolean optimize;

	/**
	 * The solved PCM instance that serves as an input for the transformation.
	 */
	private PCMInstance model;

	/**
	 * The list of processing resources and their current states.
	 */
	private List<ProcessingResourceDescriptor> resourceDescriptors;

	/**
	 * The Markov Builder is used to create Markov Chain instances.
	 */
	private MarkovBuilder markovBuilder = new MarkovBuilder();

	/**
	 * The ContextWrapper provides easy access to the decorations of the solved
	 * PCM instance.
	 */
	private ContextWrapper contextWrapper = null;

	/**
	 * The constructor.
	 * 
	 * @param model
	 *            the PCM Instance (with solved dependencies)
	 * @param descriptors
	 *            the list of resource descriptors
	 * @param optimize
	 *            controls if Markov Chain reduction is performed during
	 *            transformation
	 */
	public MarkovUsageModelVisitor(final PCMInstance model,
			List<ProcessingResourceDescriptor> descriptors,
			final boolean optimize) {
		this.model = model;
		this.resourceDescriptors = descriptors;
		this.optimize = optimize;
	}

	/**
	 * The constructor with default setting optimize = false.
	 * 
	 * @param model
	 *            the PCM Instance (with solved dependencies)
	 * @param descriptors
	 *            the list of resource descriptors
	 */
	public MarkovUsageModelVisitor(final PCMInstance model,
			List<ProcessingResourceDescriptor> descriptors) {
		this(model, descriptors, true);
	}

	/**
	 * Returns a Markov Chain that corresponds to the first SystemLevelEntryCall
	 * within this ScenarioBehaviour.
	 * 
	 * @param scenarioBehaviour
	 *            the scenario behaviour
	 * @return the resulting Markov Chain
	 */
	@Override
	public MarkovChain caseScenarioBehaviour(
			final ScenarioBehaviour scenarioBehaviour) {

		// Do the logging:
		logger.debug("Visit ScenarioBehaviour ["
				+ scenarioBehaviour.getEntityName() + "]");

		// Go through the chain of actions that constitute this behavior. Each
		// action is expected to create its own specific Markov Chain:
		ArrayList<AbstractUserAction> actions = new ArrayList<AbstractUserAction>();
		ArrayList<MarkovChain> chains = new ArrayList<MarkovChain>();
		AbstractUserAction action = (Start) EMFHelper.getObjectByType(
				scenarioBehaviour.getActions_ScenarioBehaviour(), Start.class);
		while (action != null) {
			MarkovChain specificMarkovChain = (MarkovChain) doSwitch(action);
			actions.add(action);
			chains.add(specificMarkovChain);
			action = action.getSuccessor();
		}

		// Initialize a new aggregate Markov Chain that has one state for each
		// action of the action chain:
		ArrayList<State> states = new ArrayList<State>();
		MarkovChain aggregateMarkovChain = markovBuilder
				.initScenarioBehaviourMarkovChain("ScenarioBehaviour", actions,
						states);

		// Incorporate the specific Chains into the aggregate Chain:
		for (int i = 0; i < actions.size(); i++) {
			markovBuilder.incorporateMarkovChain(aggregateMarkovChain, chains
					.get(i), states.get(i), optimize);
		}

		// Return the resulting Markov Chain:
		return aggregateMarkovChain;
	}

	/**
	 * Returns a Markov Chain that corresponds to this start action.
	 * 
	 * @param start
	 *            the start action
	 * @return the resulting Markov Chain
	 */
	@Override
	public MarkovChain caseStart(final Start start) {

		// Do the logging:
		logger.debug("Visit Start [" + start.getEntityName() + "]");

		return markovBuilder.initNewMarkovChain(start.getEntityName());
	}

	/**
	 * 
	 * Returns a Markov Chain that corresponds to this EntryLevelSystemCall.
	 * 
	 * @param entryLevelSystemCall
	 *            the call
	 * @return the resulting Markov Chain
	 */
	@Override
	public MarkovChain caseEntryLevelSystemCall(
			final EntryLevelSystemCall entryLevelSystemCall) {

		// Do the logging:
		logger.debug("Visit EntryLevelSystemCall ["
				+ entryLevelSystemCall.getEntityName() + "]");

		// Create a new context wrapper for this entry level system call:
		if (contextWrapper == null) {
			contextWrapper = new ContextWrapper(entryLevelSystemCall, model);
		} else {
			contextWrapper = contextWrapper
					.getContextWrapperFor(entryLevelSystemCall);
		}

		// We need to get from the entryLevelSystemCall to the RDSEFF that
		// fulfills the call:
		ServiceEffectSpecification seff = contextWrapper
				.getNextSEFF(entryLevelSystemCall);
		if (seff == null) {
			return null;
		} else {
			MarkovSeffVisitor seffVisitor = new MarkovSeffVisitor(
					contextWrapper, resourceDescriptors, optimize);
			return seffVisitor.doSwitch((ResourceDemandingSEFF) seff);
		}
	}

	/**
	 * Returns a Markov Chain corresponding to this Loop.
	 * 
	 * @param loop
	 *            the loop action
	 * @return the resulting Markov Chain
	 * @see de.uka.ipd.sdq.pcm.usagemodel.util.UsagemodelSwitch#caseLoop(de.uka.ipd.sdq.pcm.usagemodel.Loop)
	 */
	@Override
	public MarkovChain caseLoop(final Loop loop) {

		// Do the logging:
		logger.debug("Visit Loop [" + loop.getEntityName() + "]");

		// Determine the inner Markov Chain associated with the loop behavior:
		MarkovChain specificMarkovChain = (MarkovChain) doSwitch(loop
				.getBodyBehaviour_Loop());

		// Get the solved loop probability mass function:
		String specification = loop.getLoopIteration_Loop().getSpecification();
		ManagedPMF pmf;
		try {
			pmf = ManagedPMF.createFromString(specification);
		} catch (Exception e) {
			logger.error("Could not create a ManagedPMF from string \""
					+ specification + "\"");
			return null;
		}

		// Initialize the aggregate Markov Chain representing the loop:
		MarkovChain aggregateMarkovChain = markovBuilder.initLoopMarkovChain(
				loop.getEntityName(), pmf);

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
					specificMarkovChain, statesToReplace.get(i), optimize);
		}

		// Return the result:
		return aggregateMarkovChain;
	}

	/**
	 * Returns a Markov Chain corresponding to this Branch.
	 * 
	 * @param branch
	 *            the branch action
	 * @return the resulting Markov Chain
	 * @see de.uka.ipd.sdq.pcm.usagemodel.util.UsagemodelSwitch#caseBranch(de.uka.ipd.sdq.pcm.usagemodel.Branch)
	 */
	@Override
	public MarkovChain caseBranch(Branch branch) {

		// Do the logging:
		logger.debug("Visit Branch [" + branch.getEntityName() + "]");

		// Determine the inner Markov Chains associated with the branch
		// behaviors:
		EList<BranchTransition> transitions = branch
				.getBranchTransitions_Branch();
		ArrayList<MarkovChain> specificMarkovChains = new ArrayList<MarkovChain>();
		ArrayList<Double> branchProbabilities = new ArrayList<Double>();
		for (int i = 0; i < transitions.size(); i++) {
			branchProbabilities.add(transitions.get(i).getBranchProbability());
			specificMarkovChains.add((MarkovChain) doSwitch(transitions.get(i)
					.getBranchedBehaviour_BranchTransition()));
		}

		// Initialize the aggregate Markov Chain representing the loop:
		MarkovChain aggregateMarkovChain = markovBuilder.initBranchMarkovChain(
				branch.getEntityName(), branchProbabilities);

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
					specificMarkovChains.get(i), statesToReplace.get(i),
					optimize);
		}

		// Return the result:
		return aggregateMarkovChain;
	}

	/**
	 * Returns a Markov Chain correponding to this Delay.
	 * 
	 * @param delay
	 *            the delay action
	 * @return the resulting Markov Chain
	 * @see de.uka.ipd.sdq.pcm.usagemodel.util.UsagemodelSwitch#caseDelay(de.uka.ipd.sdq.pcm.usagemodel.Delay)
	 */
	@Override
	public MarkovChain caseDelay(Delay delay) {

		// Do the logging:
		logger.debug("Visit Delay [" + delay.getEntityName() + "]");

		return markovBuilder.initNewMarkovChain(delay.getEntityName());
	}

	/**
	 * Returns a Markov Chain that corresponds to this stop action.
	 * 
	 * @param start
	 *            the starting point
	 * @return the resulting Markov Chain
	 */
	@Override
	public MarkovChain caseStop(final Stop stop) {

		// Do the logging:
		logger.debug("Visit Stop [" + stop.getEntityName() + "]");

		return markovBuilder.initNewMarkovChain(stop.getEntityName());
	}
}
