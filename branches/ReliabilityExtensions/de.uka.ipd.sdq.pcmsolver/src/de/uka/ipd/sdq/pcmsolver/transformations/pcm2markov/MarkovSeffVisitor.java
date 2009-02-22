package de.uka.ipd.sdq.pcmsolver.transformations.pcm2markov;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.markov.MarkovChain;
import de.uka.ipd.sdq.markov.State;
import de.uka.ipd.sdq.markov.StateType;
import de.uka.ipd.sdq.pcm.resourceenvironment.CommunicationLinkResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.AbstractBranchTransition;
import de.uka.ipd.sdq.pcm.seff.AcquireAction;
import de.uka.ipd.sdq.pcm.seff.BranchAction;
import de.uka.ipd.sdq.pcm.seff.CollectionIteratorAction;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.seff.LoopAction;
import de.uka.ipd.sdq.pcm.seff.ParametricResourceDemand;
import de.uka.ipd.sdq.pcm.seff.ReleaseAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification;
import de.uka.ipd.sdq.pcm.seff.SetVariableAction;
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
	 * The list of processing resources and their current states.
	 */
	private List<ProcessingResourceDescriptor> resourceDescriptors;

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
	 * @param descriptors
	 *            the list of resource descriptors
	 */
	public MarkovSeffVisitor(final ContextWrapper wrapper,
			final List<ProcessingResourceDescriptor> descriptors) {
		contextWrapper = wrapper;
		resourceDescriptors = descriptors;
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
		logger.debug("Visit ResourceDemandingBehaviour");

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
				.initResourceDemandingBehaviourMarkovChain(
						"ResourceDemandingBehaviour", actions, states);

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
		logger.debug("Visit ResourceDemandingSEFF ["
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
				.initResourceDemandingBehaviourMarkovChain(seff
						.getDescribedService__SEFF().getServiceName(), actions,
						states);

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
		logger.debug("Visit StartAction [" + startAction.getEntityName() + "]");

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
		logger.debug("Visit InternalAction [" + internalAction.getEntityName()
				+ "]");

		// Initialize the internal action's failure probability, assuming that
		// all processing resources used by the internal action are currently
		// OK:
		String failureProbability = internalAction.getFailureProbability();

		// Check if any of the processing resources used by this internal action
		// is currently broken down:
		for (ParametricResourceDemand demand : internalAction
				.getResourceDemand_Action()) {

			// Special case: ignore resource demands of type
			// "SystemExternalResource", as they have been internally introduced
			// by the dependency solver:
			if (demand.getRequiredResource_ParametricResourceDemand()
					.getEntityName().equals("SystemExternalResource")) {
				continue;
			}

			// Get the descriptor that corresponds to the demand:
			ProcessingResourceDescriptor descriptor = getDescriptor(demand);
			if (descriptor == null) {
				logger.error("Missing resource description for "
						+ demand.getRequiredResource_ParametricResourceDemand()
								.getEntityName()
						+ " resource demand. Assume resource state = OK.");
				continue;
			}

			// Get the state of the resource:
			ProcessingResourceState state = descriptor.getCurrentState();
			if (state == null) {
				logger.error("Resource state no set for "
						+ demand.getRequiredResource_ParametricResourceDemand()
								.getEntityName()
						+ " resource demand. Assume resource state = OK.");
				continue;
			}

			// If the resource is broken down, the internal action fails with
			// 100% probability:
			if (state.equals(ProcessingResourceState.NA)) {
				failureProbability = "1.0";
				break;
			}
		}

		// Build the corresponding Markov Chain:
		return markovBuilder.initInternalMarkovChain(internalAction
				.getEntityName(), failureProbability);
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
		logger.debug("Visit LoopAction [" + loopAction.getEntityName() + "]");

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
	 * A collection iterator action is handled the same way as an ordinary loop.
	 * 
	 * @param collectionIteratorAction
	 *            the CollectionIteratoraction
	 * @return the resulting Markov Chain
	 */
	@Override
	public MarkovChain caseCollectionIteratorAction(
			final CollectionIteratorAction collectionIteratorAction) {

		// Do the logging:
		logger.debug("Visit CollectionIteratorAction ["
				+ collectionIteratorAction.getEntityName() + "]");

		// Determine the inner Markov Chain associated with the loop behaviour:
		MarkovChain specificMarkovChain = (MarkovChain) doSwitch(collectionIteratorAction
				.getBodyBehaviour_Loop());

		// Get the solved loop probability mass function:
		ManagedPMF pmf = contextWrapper
				.getLoopIterations(collectionIteratorAction);

		// Initialize the aggregate Markov Chain representing the loop:
		MarkovChain aggregateMarkovChain = markovBuilder.initLoopMarkovChain(
				collectionIteratorAction.getEntityName(), pmf);

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
			logger.debug("Visit SystemExternalCallAction ["
					+ externalCallAction.getEntityName() + "]");

			// Get the FailureProbability of the SystemExternalCall (this is, by
			// now, a hack):
			// String failureProbabilityExpression = failProbList.get(sysExList
			// .indexOf(externalCallAction.getId()));

			// A SystemExternalCall is treated like an InternalAction - it has
			// just one fixed failureProbability:
			// return markovBuilder.initInternalMarkovChain(externalCallAction
			// .getEntityName(), failureProbabilityExpression);

			// At the moment, no failure probabilities for system-external calls
			// are supported:
			return markovBuilder.initNewMarkovChain(externalCallAction
					.getEntityName());

		} else {

			// Do the logging:
			logger.debug("Visit ExternalCallAction ["
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
			MarkovChain innerMarkovChain = new MarkovSeffVisitor(
					newContextWrapper, resourceDescriptors).doSwitch(seff);

			// Check if the external call crosses the border of one resource
			// container and uses a communication link:
			CommunicationLinkResourceSpecification commLink = contextWrapper
					.getConcreteLinkingResource(externalCallAction);

			// If a communication link is used, consider the possibility that
			// the call fails:
			if (commLink != null) {

				// The call can be modeled as a behavior with two steps: the
				// sending of the message, and the remote execution. Both steps
				// can fail.
				ArrayList<State> states = new ArrayList<State>();
				ArrayList<String> names = new ArrayList<String>();
				names.add("Messaging");
				names.add("Execution");
				MarkovChain aggregateMarkovChain = markovBuilder
						.initBehaviourMarkovChain(externalCallAction
								.getEntityName(), names, states);

				// The first Step can be modeled like an Internal Action which
				// either fails or succeeds:
				MarkovChain messagingMarkovChain = markovBuilder
						.initInternalMarkovChain("Messaging",
								((Double) commLink.getFailureProbability())
										.toString());

				// The second step is the already computed inner Markov Chain.
				// Incorporate both steps into the aggregate chain:
				markovBuilder.incorporateMarkovChain(aggregateMarkovChain,
						messagingMarkovChain, states.get(0));
				markovBuilder.incorporateMarkovChain(aggregateMarkovChain,
						innerMarkovChain, states.get(1));

				// Return the result:
				return aggregateMarkovChain;

			} else {

				// If no communication link is used, then the Markov Chain just
				// has to reflect the inner SEFF behavior:
				return innerMarkovChain;
			}
		}
	}

	/**
	 * An Acquire Action returns a trivial Markov Chain.
	 * 
	 * @param acquireAction
	 *            the acquire action
	 * @return the resulting Markov Chain.
	 * @see de.uka.ipd.sdq.pcm.seff.util.SeffSwitch#caseAcquireAction(de.uka.ipd.sdq.pcm.seff.AcquireAction)
	 */
	@Override
	public MarkovChain caseAcquireAction(final AcquireAction acquireAction) {

		// Do the logging:
		logger.debug("Visit AcquireAction [" + acquireAction.getEntityName()
				+ "]");

		return markovBuilder.initNewMarkovChain(acquireAction.getEntityName());
	}

	/**
	 * A Release Action returns a trivial Markov Chain.
	 * 
	 * @param releaseAction
	 *            the release action
	 * @return the resulting Markov Chain.
	 * @see de.uka.ipd.sdq.pcm.seff.util.SeffSwitch#caseAcquireAction(de.uka.ipd.sdq.pcm.seff.AcquireAction)
	 */
	@Override
	public MarkovChain caseReleaseAction(final ReleaseAction releaseAction) {

		// Do the logging:
		logger.debug("Visit ReleaseAction [" + releaseAction.getEntityName()
				+ "]");

		return markovBuilder.initNewMarkovChain(releaseAction.getEntityName());
	}

	/**
	 * A SetVariableAction returns a trivial Markov Chain.
	 * 
	 * @param setVariableAction
	 *            the SetVariableAction
	 * @return the resulting Markov Chain
	 * @see de.uka.ipd.sdq.pcm.seff.util.SeffSwitch#caseSetVariableAction(de.uka.ipd.sdq.pcm.seff.SetVariableAction)
	 */
	@Override
	public MarkovChain caseSetVariableAction(
			final SetVariableAction setVariableAction) {

		// Do the logging:
		logger.debug("Visit SetVariableAction ["
				+ setVariableAction.getEntityName() + "]");

		return markovBuilder.initNewMarkovChain(setVariableAction
				.getEntityName());
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
		logger.debug("Visit StopAction [" + stopAction.getEntityName() + "]");

		return markovBuilder.initNewMarkovChain(stopAction.getEntityName());
	}

	/**
	 * Retrieves a resource descriptor corresponding to the given resource
	 * demand.
	 * 
	 * @param demand
	 *            the resource demand
	 * @return the descriptor
	 */
	private ProcessingResourceDescriptor getDescriptor(
			final ParametricResourceDemand demand) {

		// Map the resource demand to a concrete resource:
		ProcessingResourceSpecification resource = contextWrapper
				.getConcreteProcessingResource(demand);
		if (resource == null) {
			return null;
		}

		// Get the IDs of the resource type and resource container:
		String resourceTypeId = resource
				.getActiveResourceType_ActiveResourceSpecification().getId();
		String containerId = contextWrapper.getAllCtx()
				.getResourceContainer_AllocationContext().getId();

		// Search for the right descriptor:
		for (ProcessingResourceDescriptor descriptor : resourceDescriptors) {

			// Compare the IDs to those of the descriptor:
			if ((descriptor.getProcessingResourceTypeId()
					.equals(resourceTypeId))
					&& (descriptor.getResourceContainerId().equals(containerId))) {
				return descriptor;
			}
		}

		// No descriptor found:
		return null;
	}
}
