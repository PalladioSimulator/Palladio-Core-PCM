package de.uka.ipd.sdq.pcmsolver.transformations.pcm2markov;

import java.util.ArrayList;
import java.util.ListIterator;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.probfunction.Sample;
import de.uka.ipd.sdq.probfunction.math.ManagedPMF;
import markov.MarkovChain;
import markov.MarkovFactory;
import markov.State;
import markov.StateType;
import markov.Transition;

/**
 * This class provides methods for building Markov Chains.
 * 
 * @author brosch
 * 
 */
public class MarkovBuilder {

	/**
	 * A logger to give detailed information about the PCM instance traversal.
	 */
	private static Logger logger = Logger.getLogger(MarkovBuilder.class
			.getName());

	/**
	 * The Markov Factory is used to create the Elements of the Markov Chain
	 * Model resulting from the transformation.
	 */
	private MarkovFactory markovFactory = MarkovFactory.eINSTANCE;

	/**
	 * Initializes a new Markov Chain. The new Markov Chain has only three
	 * states: a start state, a success state and a failure state. A single
	 * transition goes from start to success with probability 1.
	 * 
	 * @param name
	 *            the name of the new Markov Chain
	 * @return the new Markov Chain
	 */
	public MarkovChain initNewMarkovChain(final String name) {

		// Create the Markov Chain Entity:
		MarkovChain markovChain = markovFactory.createMarkovChain();
		markovChain.setName(name);

		// Create the three States:
		State stateStart = markovFactory.createState();
		stateStart.setType(StateType.START);
		stateStart.setName(name + " - " + stateStart.getType().toString());
		State stateSuccess = markovFactory.createState();
		stateSuccess.setType(StateType.SUCCESS);
		stateSuccess.setName(name + " - " + stateSuccess.getType().toString());
		State stateFailure = markovFactory.createState();
		stateFailure.setType(StateType.FAILURE);
		stateFailure.setName(name + " - " + stateFailure.getType().toString());

		// Add the States to the Markov Chain:
		markovChain.getStates().add(stateStart);
		markovChain.getStates().add(stateSuccess);
		markovChain.getStates().add(stateFailure);

		// Create the Transition:
		Transition transitionStartSuccess = markovFactory.createTransition();
		transitionStartSuccess.setFromState(stateStart);
		transitionStartSuccess.setToState(stateSuccess);
		transitionStartSuccess.setName(stateStart.getName() + " - "
				+ StateType.SUCCESS.toString());
		transitionStartSuccess.setProbability(1.0);

		// Add the Transition to the Markov Chain:
		markovChain.getTransitions().add(transitionStartSuccess);

		// Return the result:
		return markovChain;
	}

	/**
	 * Creates a Markov Chain that represents an execution of a
	 * ResourceDemandingBehaviour. For each action within the given chain of
	 * actions, a State within the resulting Markov Chain is created. Together
	 * with the Markov Chain, a list of States is returned that corresponds to
	 * the given action list.
	 * 
	 * @param name
	 *            the name of the new Markov Chain
	 * @param actions
	 *            the chain of actions of the ResourceDemandingBehaviour
	 * @param statesOut
	 *            the list of states created within the method that corresponds
	 *            to the given list of actions
	 * @return the resulting Markov Chain
	 */
	public MarkovChain initBehaviourMarkovChain(final String name,
			final ArrayList<AbstractAction> actions,
			final ArrayList<State> statesOut) {

		// Create the Markov Chain Entity:
		MarkovChain markovChain = markovFactory.createMarkovChain();
		markovChain.setName(name);

		// Create the Start, Success and Failure States:
		State stateStart = markovFactory.createState();
		stateStart.setType(StateType.START);
		stateStart.setName(name + " - " + stateStart.getType().toString());
		State stateSuccess = markovFactory.createState();
		stateSuccess.setType(StateType.SUCCESS);
		stateSuccess.setName(name + " - " + stateSuccess.getType().toString());
		State stateFailure = markovFactory.createState();
		stateFailure.setType(StateType.FAILURE);
		stateFailure.setName(name + " - " + stateFailure.getType().toString());

		// Add the Start, Success and Failure States to the Markov Chain:
		markovChain.getStates().add(stateStart);
		markovChain.getStates().add(stateSuccess);
		markovChain.getStates().add(stateFailure);

		// Mark the State that will later lead directly to the Success State:
		State stateToSuccess = stateStart;

		// Go through the chain of actions:
		for (int i = 0; i < actions.size(); i++) {

			// Create a Markov State for this Action:
			State state = markovFactory.createState();
			state.setName(name + " - " + actions.get(i).getEntityName());
			markovChain.getStates().add(state);
			statesOut.add(state);

			// Create a Transition leading to the new State:
			Transition transition = markovFactory.createTransition();
			transition.setFromState(stateToSuccess);
			transition.setToState(state);
			transition.setName(stateToSuccess.getName() + " - "
					+ StateType.SUCCESS.toString());
			transition.setProbability(1.0);
			markovChain.getTransitions().add(transition);

			// Update the State leading to Success:
			stateToSuccess = state;
		}

		// Create the Transition leading to the Success State:
		Transition transitionSuccess = markovFactory.createTransition();
		transitionSuccess.setFromState(stateToSuccess);
		transitionSuccess.setToState(stateSuccess);
		transitionSuccess.setName(stateToSuccess.getName() + " - "
				+ StateType.SUCCESS.toString());
		transitionSuccess.setProbability(1.0);
		markovChain.getTransitions().add(transitionSuccess);

		// Return the result:
		return markovChain;
	}

	/**
	 * Creates a simple Markov Chain that represents an execution of an
	 * InternalAction. The InternalAction either succeeds or fails.
	 * 
	 * @param name
	 *            the name of the InternalAction
	 * @param failureProbabilityExpression
	 *            a string that represents a failure probability of the
	 *            InternalAction
	 * @return the resulting Markov Chain
	 */
	public MarkovChain initInternalMarkovChain(final String name,
			final String failureProbabilityExpression) {

		// We expect the failure probability to be a double between 0 and 1:
		double successProbability;
		try {
			successProbability = 1 - Double
					.parseDouble(failureProbabilityExpression);
		} catch (NumberFormatException e) {
			logger
					.error("Unexpected format of failure probability specification: "
							+ failureProbabilityExpression);
			successProbability = 1;
		}
		if ((successProbability < 0) || (successProbability > 1)) {
			logger.error("Invalid value of failure probability specification: "
					+ failureProbabilityExpression);
			successProbability = 1;
		}

		// Create the Markov Chain Entity:
		MarkovChain markovChain = markovFactory.createMarkovChain();
		markovChain.setName(name);

		// Create the Start, Success and Failure States:
		State stateStart = markovFactory.createState();
		stateStart.setType(StateType.START);
		stateStart.setName(name + " - " + stateStart.getType().toString());
		State stateSuccess = markovFactory.createState();
		stateSuccess.setType(StateType.SUCCESS);
		stateSuccess.setName(name + " - " + stateSuccess.getType().toString());
		State stateFailure = markovFactory.createState();
		stateFailure.setType(StateType.FAILURE);
		stateFailure.setName(name + " - " + stateFailure.getType().toString());

		// Add the States to the Markov Chain:
		markovChain.getStates().add(stateStart);
		markovChain.getStates().add(stateSuccess);
		markovChain.getStates().add(stateFailure);

		// Create the Transition from Start State to Success State:
		Transition transitionStartSuccess = markovFactory.createTransition();
		transitionStartSuccess.setFromState(stateStart);
		transitionStartSuccess.setToState(stateSuccess);
		transitionStartSuccess.setName(stateStart.getName() + " - "
				+ StateType.SUCCESS.toString());
		transitionStartSuccess.setProbability(successProbability);
		markovChain.getTransitions().add(transitionStartSuccess);

		// Create the Transition from Start State to Failure State:
		Transition transitionStartFailure = markovFactory.createTransition();
		transitionStartFailure.setFromState(stateStart);
		transitionStartFailure.setToState(stateFailure);
		transitionStartFailure.setName(stateStart.getName() + " - "
				+ StateType.FAILURE.toString());
		transitionStartFailure.setProbability(1 - successProbability);
		markovChain.getTransitions().add(transitionStartFailure);

		// Return the result:
		return markovChain;
	}

	/**
	 * Creates a Markov Chain for a loop with solved probability mass function
	 * and solved inner Markov Chain. Note: This method is deprecated and
	 * replaced by an overloaded version which does not need the inner Markov
	 * Chain to be already solved.
	 * 
	 * @param name
	 *            the name of the loop
	 * @param pmf
	 *            the probability mass function of the loop
	 * @param innerResult
	 *            the result of the solved inner Markov Chain
	 * @return the resulting Markov Chain
	 */
	@Deprecated
	public MarkovChain initLoopMarkovChain(final String name,
			final ManagedPMF pmf, final double innerResult) {

		// Create the Markov Chain Entity:
		MarkovChain markovChain = markovFactory.createMarkovChain();
		markovChain.setName(name);

		// Create the Start, Success and Failure States:
		State stateStart = markovFactory.createState();
		stateStart.setType(StateType.START);
		stateStart.setName(name + " - " + stateStart.getType().toString());
		State stateSuccess = markovFactory.createState();
		stateSuccess.setType(StateType.SUCCESS);
		stateSuccess.setName(name + " - " + stateSuccess.getType().toString());
		State stateFailure = markovFactory.createState();
		stateFailure.setType(StateType.FAILURE);
		stateFailure.setName(name + " - " + stateFailure.getType().toString());

		// Add the States to the Markov Chain:
		markovChain.getStates().add(stateStart);
		markovChain.getStates().add(stateSuccess);
		markovChain.getStates().add(stateFailure);

		// Go through the samples of the probability mass function:
		for (int i = 0; i < pmf.getModelPmf().getSamples().size(); i++) {
			Sample sample = pmf.getModelPmf().getSamples().get(i);
			if (sample.getValue() instanceof Integer) {
				int sampleValue = (Integer) sample.getValue();

				// We create a new State for this sample:
				State stateSample = markovFactory.createState();
				stateSample.setName(name + " - " + sampleValue
						+ " times executing");
				markovChain.getStates().add(stateSample);

				// Create a transition from the Start State to the Sample State:
				Transition transitionSample = markovFactory.createTransition();
				transitionSample.setFromState(stateStart);
				transitionSample.setToState(stateSample);
				transitionSample.setProbability(sample.getProbability());
				transitionSample.setName(name + " - executing");
				markovChain.getTransitions().add(transitionSample);

				// Create a transition from Sample State to Success State:
				Transition transitionSuccess = markovFactory.createTransition();
				transitionSuccess.setFromState(stateSample);
				transitionSuccess.setToState(stateSuccess);
				transitionSuccess.setProbability(Math.pow(innerResult,
						sampleValue));
				transitionSuccess.setName(stateSample.getName() + " - "
						+ StateType.SUCCESS.toString());
				markovChain.getTransitions().add(transitionSuccess);

				// Create a transition from Sample State to Failure State:
				Transition transitionFailure = markovFactory.createTransition();
				transitionFailure.setFromState(stateSample);
				transitionFailure.setToState(stateFailure);
				transitionFailure.setProbability(1 - transitionSuccess
						.getProbability());
				transitionFailure.setName(stateSample.getName() + " - "
						+ StateType.FAILURE.toString());
				markovChain.getTransitions().add(transitionFailure);

			} else {
				logger.error("Unexpected Sample Type: "
						+ sample.getValue().getClass().toString());
				continue;
			}
		}

		// Return the result:
		return markovChain;
	}

	/**
	 * Creates a Markov Chain for a loop with solved probability mass function.
	 * 
	 * @param name
	 *            the name of the loop
	 * @param pmf
	 *            the probability mass function of the loop
	 * @return the resulting Markov Chain
	 */
	public MarkovChain initLoopMarkovChain(final String name,
			final ManagedPMF pmf) {

		// Create the Markov Chain Entity:
		MarkovChain markovChain = markovFactory.createMarkovChain();
		markovChain.setName(name);

		// Create the Start, Success and Failure States:
		State stateStart = markovFactory.createState();
		stateStart.setType(StateType.START);
		stateStart.setName(name + " - " + stateStart.getType().toString());
		State stateSuccess = markovFactory.createState();
		stateSuccess.setType(StateType.SUCCESS);
		stateSuccess.setName(name + " - " + stateSuccess.getType().toString());
		State stateFailure = markovFactory.createState();
		stateFailure.setType(StateType.FAILURE);
		stateFailure.setName(name + " - " + stateFailure.getType().toString());

		// Add the States to the Markov Chain:
		markovChain.getStates().add(stateStart);
		markovChain.getStates().add(stateSuccess);
		markovChain.getStates().add(stateFailure);

		// Go through the samples of the probability mass function:
		for (int i = 0; i < pmf.getModelPmf().getSamples().size(); i++) {
			Sample sample = pmf.getModelPmf().getSamples().get(i);
			if (sample.getValue() instanceof Integer) {
				int sampleValue = (Integer) sample.getValue();

				// Mark the State that will lead to the Success State:
				State stateToSuccess = stateStart;
				double transitionProbability = sample.getProbability();

				// Go through the iterations of this sample:
				for (int j = 0; j < sampleValue; j++) {

					// Create a new State:
					State stateSample = markovFactory.createState();
					stateSample.setName(name + " - execution " + (j + 1)
							+ " of " + sampleValue);
					markovChain.getStates().add(stateSample);

					// Create a transition from the previous State to the new
					// one:
					Transition transitionSample = markovFactory
							.createTransition();
					transitionSample.setFromState(stateToSuccess);
					transitionSample.setToState(stateSample);
					transitionSample.setProbability(transitionProbability);
					transitionSample.setName(stateToSuccess.getName() + " - "
							+ StateType.SUCCESS.getName());
					markovChain.getTransitions().add(transitionSample);

					// Update State and probability:
					stateToSuccess = stateSample;
					transitionProbability = 1;
				}

				// Create a transition leading to the Success State:
				Transition transitionSuccess = markovFactory.createTransition();
				transitionSuccess.setFromState(stateToSuccess);
				transitionSuccess.setToState(stateSuccess);
				transitionSuccess.setName(stateToSuccess.getName() + " - "
						+ StateType.SUCCESS.getName());
				transitionSuccess.setProbability(transitionProbability);
				markovChain.getTransitions().add(transitionSuccess);

			} else {
				logger.error("Unexpected Sample Type: "
						+ sample.getValue().getClass().toString());
				continue;
			}
		}

		// Return the result:
		return markovChain;
	}

	/**
	 * Creates a Markov Chain for a branch with solved branch probabilities.
	 * 
	 * @param name
	 *            the name of the branch
	 * @param branchProbabilities
	 *            the branch probabilities
	 * @return the resulting Markov Chain
	 */
	public MarkovChain initBranchMarkovChain(final String name,
			final ArrayList<Double> branchProbabilities) {

		// Create the Markov Chain Entity:
		MarkovChain markovChain = markovFactory.createMarkovChain();
		markovChain.setName(name);

		// Create the Start, Success and Failure States:
		State stateStart = markovFactory.createState();
		stateStart.setType(StateType.START);
		stateStart.setName(name + " - " + stateStart.getType().toString());
		State stateSuccess = markovFactory.createState();
		stateSuccess.setType(StateType.SUCCESS);
		stateSuccess.setName(name + " - " + stateSuccess.getType().toString());
		State stateFailure = markovFactory.createState();
		stateFailure.setType(StateType.FAILURE);
		stateFailure.setName(name + " - " + stateFailure.getType().toString());

		// Add the States to the Markov Chain:
		markovChain.getStates().add(stateStart);
		markovChain.getStates().add(stateSuccess);
		markovChain.getStates().add(stateFailure);

		// Go through the given branch probabilities:
		for (int i = 0; i < branchProbabilities.size(); i++) {

			// Create a new State:
			State stateBranch = markovFactory.createState();
			stateBranch.setName(name + " - branch " + (i + 1));
			markovChain.getStates().add(stateBranch);

			// Create a transition from the Start State to the new
			// one:
			Transition transitionBranch = markovFactory.createTransition();
			transitionBranch.setFromState(stateStart);
			transitionBranch.setToState(stateBranch);
			transitionBranch.setProbability(branchProbabilities.get(i));
			transitionBranch.setName(stateStart.getName() + " - "
					+ StateType.SUCCESS.getName());
			markovChain.getTransitions().add(transitionBranch);

			// Create a transition from the Start State to the new
			// one:
			Transition transitionSuccess = markovFactory.createTransition();
			transitionSuccess.setFromState(stateBranch);
			transitionSuccess.setToState(stateSuccess);
			transitionSuccess.setProbability(1);
			transitionSuccess.setName(stateBranch.getName() + " - "
					+ StateType.SUCCESS.getName());
			markovChain.getTransitions().add(transitionSuccess);
		}

		// Return the result:
		return markovChain;
	}

	/**
	 * Incorporates one Markov Chain into another. The specific Markov Chain is
	 * inserted into the aggregate Markov Chain directly before the Success
	 * state of the aggregate Markov Chain. Note: This method is deprecated and
	 * replaced by an overloaded one. Before any further use of this method, it
	 * should be rewritten so that no States or Transitions of the specific
	 * Markov Chain are reused within the aggregate Markov Chain (this could
	 * lead to problems when one specific Markov Chain is incorporated several
	 * times into the same aggregate Markov Chain).
	 * 
	 * @param aggregateMarkovChain
	 *            the Markov Chain which will incorporate the other chain
	 * @param specificMarkovChain
	 *            the Markov Chain that will be incorporated into the other
	 *            chain
	 */
	@Deprecated
	public void incorporateMarkovChain(final MarkovChain aggregateMarkovChain,
			final MarkovChain specificMarkovChain) {

		// Find the Start, Success and Failure States of the aggregate Markov
		// Chain:
		State stateAggregateStart = findState(aggregateMarkovChain,
				StateType.START);
		State stateAggregateSuccess = findState(aggregateMarkovChain,
				StateType.SUCCESS);
		State stateAggregateFailure = findState(aggregateMarkovChain,
				StateType.FAILURE);
		if ((stateAggregateStart == null) || (stateAggregateSuccess == null)
				|| (stateAggregateFailure == null)) {
			return;
		}

		// Find the Start, Success and Failure States of the specific Markov
		// Chain:
		State stateSpecificStart = findState(specificMarkovChain,
				StateType.START);
		State stateSpecificSuccess = findState(specificMarkovChain,
				StateType.SUCCESS);
		State stateSpecificFailure = findState(specificMarkovChain,
				StateType.FAILURE);
		if ((stateSpecificStart == null) || (stateSpecificSuccess == null)
				|| (stateSpecificFailure == null)) {
			return;
		}

		// Find and delete all transitions in the aggregate Markov Chain that
		// lead to the Success state:
		ArrayList<Transition> transitionsAggregateToSuccess = findTransitionsToState(
				aggregateMarkovChain, stateAggregateSuccess);
		deleteTransitions(aggregateMarkovChain, transitionsAggregateToSuccess);

		// Add the states of the specific Markov Chain to the aggregate Markov
		// Chain:
		addStates(aggregateMarkovChain, specificMarkovChain.getStates(),
				StateType.DEFAULT);

		// Build new transitions in the aggregate Markov Chain from the
		// transitions in the specific Markov Chain:
		ListIterator<Transition> iterator = specificMarkovChain
				.getTransitions().listIterator();
		while (iterator.hasNext()) {
			Transition transitionSpecific = iterator.next();

			// The process to build a Transition for the aggregate Markov Chain
			// depends on the characteristics of the Transition of the specific
			// Markov Chain:
			if (transitionSpecific.getFromState() == stateSpecificStart) {

				// As the specific transition originates in the Start state of
				// the specific Markov Chain, one aggregate Transition for each
				// former Transition to the Success State in the aggregate
				// Markov Chain has to be created:
				for (int i = 0; i < transitionsAggregateToSuccess.size(); i++) {

					// Create the new aggregate Transition:
					Transition transitionAggregate = markovFactory
							.createTransition();

					// Set the Source State of the aggregate Transition:
					transitionAggregate
							.setFromState(transitionsAggregateToSuccess.get(i)
									.getFromState());

					// Set the probability of the aggregate Transition:
					transitionAggregate
							.setProbability(transitionsAggregateToSuccess
									.get(i).getProbability()
									* transitionSpecific.getProbability());

					// Set the Target State and Name of the aggregate
					// Transition:
					switch (transitionSpecific.getToState().getType()
							.getValue()) {
					case StateType.SUCCESS_VALUE:
						transitionAggregate.setToState(stateAggregateSuccess);
						transitionAggregate.setName(transitionAggregate
								.getFromState().getName()
								+ " - " + StateType.SUCCESS.toString());
						break;
					case StateType.FAILURE_VALUE:
						transitionAggregate.setToState(stateAggregateFailure);
						transitionAggregate.setName(transitionAggregate
								.getFromState().getName()
								+ " - " + StateType.FAILURE.toString());
						break;
					default:
						transitionAggregate.setToState(transitionSpecific
								.getToState());
						transitionAggregate.setName(transitionAggregate
								.getFromState().getName()
								+ " - " + StateType.SUCCESS.toString());
						break;
					}

					// Add the new Transition to the aggregate Markov Chain:
					contributeTransition(aggregateMarkovChain,
							transitionAggregate);
				}
			} else {

				// As the specific transition does not originate in the Start
				// state of the specific Markov Model, exactly one aggregate
				// Transition will be created:
				Transition transitionAggregate = markovFactory
						.createTransition();

				// Take over Source State and Probability from specific
				// Transition:
				transitionAggregate.setFromState(transitionSpecific
						.getFromState());
				transitionAggregate.setProbability(transitionSpecific
						.getProbability());

				// Set Target State and Name of the aggregate Transition:
				switch (transitionSpecific.getToState().getType().getValue()) {
				case StateType.SUCCESS_VALUE:
					transitionAggregate.setToState(stateAggregateSuccess);
					transitionAggregate.setName(transitionAggregate
							.getFromState().getName()
							+ " - " + StateType.SUCCESS.toString());
					break;
				case StateType.FAILURE_VALUE:
					transitionAggregate.setToState(stateAggregateFailure);
					transitionAggregate.setName(transitionAggregate
							.getFromState().getName()
							+ " - " + StateType.FAILURE.toString());
					break;
				default:
					transitionAggregate.setToState(transitionSpecific
							.getToState());
					transitionAggregate.setName(transitionAggregate
							.getFromState().getName()
							+ " - " + StateType.SUCCESS.toString());
					break;
				}

				// Add the new Transition to the aggregate Markov Chain:
				contributeTransition(aggregateMarkovChain, transitionAggregate);
			}
		}
	}

	/**
	 * Incorporates one Markov Chain into another. The specific Markov Chain is
	 * inserted into the aggregate Markov Chain replacing the given aggregate
	 * Markov State.
	 * 
	 * @param aggregateMarkovChain
	 *            the Markov Chain which will incorporate the other chain
	 * @param specificMarkovChain
	 *            the Markov Chain which will be incorporated into the other
	 *            chain
	 * @param aggregateState
	 *            the Markov State in the aggregate Markov Chain which will be
	 *            replaced by the specific Markov Chain
	 */
	public void incorporateMarkovChain(final MarkovChain aggregateMarkovChain,
			final MarkovChain specificMarkovChain, final State aggregateState) {

		// Assure that the replaceable Markov State is contained in the
		// aggregate Markov Chain:
		if (!aggregateMarkovChain.getStates().contains(aggregateState)) {
			return;
		}

		// Assure that the replaceable Markov State is not a Start, Success or
		// Failure State:
		if (!aggregateState.getType().equals(StateType.DEFAULT)) {
			return;
		}

		// Create a copy of the specific Markov Chain to prevent reuse of any
		// States or Transitions of the specific Markov Chain within the
		// aggregate Markov Chain (this could lead to problems when one specific
		// Markov Chain is incorporated several times into the same aggregate
		// Markov Chain):
		MarkovChain copiedSpecificMarkovChain = copyMarkovChain(specificMarkovChain);

		// Find the Start, Success and Failure States of the aggregate Markov
		// Chain:
		State stateAggregateStart = findState(aggregateMarkovChain,
				StateType.START);
		State stateAggregateSuccess = findState(aggregateMarkovChain,
				StateType.SUCCESS);
		State stateAggregateFailure = findState(aggregateMarkovChain,
				StateType.FAILURE);
		if ((stateAggregateStart == null) || (stateAggregateSuccess == null)
				|| (stateAggregateFailure == null)) {
			return;
		}

		// Find the Start, Success and Failure States of the specific Markov
		// Chain:
		State stateSpecificStart = findState(copiedSpecificMarkovChain,
				StateType.START);
		State stateSpecificSuccess = findState(copiedSpecificMarkovChain,
				StateType.SUCCESS);
		State stateSpecificFailure = findState(copiedSpecificMarkovChain,
				StateType.FAILURE);
		if ((stateSpecificStart == null) || (stateSpecificSuccess == null)
				|| (stateSpecificFailure == null)) {
			return;
		}

		// Find all transitions in the aggregate Markov Chain that lead to the
		// replaceable Markov State:
		ArrayList<Transition> transitionsAggregateToReplaceState = findTransitionsToState(
				aggregateMarkovChain, aggregateState);

		// Find all transitions in the aggregate Markov Chain that start from
		// the replaceable Markov State:
		ArrayList<Transition> transitionsAggregateFromReplaceState = findTransitionsFromState(
				aggregateMarkovChain, aggregateState);

		// Take over the specific Markov Chain into the aggregate Markov Chain:
		aggregateMarkovChain.getStates().addAll(
				copiedSpecificMarkovChain.getStates());
		aggregateMarkovChain.getTransitions().addAll(
				copiedSpecificMarkovChain.getTransitions());

		// Within the aggregate Markov Chain, the states of the specific Markov
		// Chain are all of type Default:
		stateSpecificStart.setType(StateType.DEFAULT);
		stateSpecificSuccess.setType(StateType.DEFAULT);
		stateSpecificFailure.setType(StateType.DEFAULT);

		// Delete the replaceable Markov State from the aggregate Markov Chain
		// and adjust all Transitions starting from or leading to this State:
		aggregateMarkovChain.getStates().remove(aggregateState);
		for (int i = 0; i < transitionsAggregateToReplaceState.size(); i++) {
			transitionsAggregateToReplaceState.get(i).setToState(
					stateSpecificStart);
		}
		for (int i = 0; i < transitionsAggregateFromReplaceState.size(); i++) {
			transitionsAggregateFromReplaceState.get(i).setFromState(
					stateSpecificSuccess);
		}

		// Build a transition from specific Failure to aggregate Failure:
		Transition transitionFailure = markovFactory.createTransition();
		transitionFailure.setFromState(stateSpecificFailure);
		transitionFailure.setToState(stateAggregateFailure);
		transitionFailure.setName(stateSpecificFailure + " - "
				+ StateType.FAILURE.getName());
		transitionFailure.setProbability(1);
		aggregateMarkovChain.getTransitions().add(transitionFailure);

		// Optimize the aggregate MarkovChain:
		reduceState(aggregateMarkovChain, stateSpecificStart);
		reduceState(aggregateMarkovChain, stateSpecificSuccess);
		reduceState(aggregateMarkovChain, stateSpecificFailure);
	}

	/**
	 * Creates a copy of a Markov Chain. All States and Transitions of the
	 * original Markov Chain are copied into the new one.
	 * 
	 * @param originalMarkovChain
	 *            the original Markov Chain
	 * @return the new Markov Chain
	 */
	private MarkovChain copyMarkovChain(final MarkovChain originalMarkovChain) {

		// Create a new Markov Chain instance:
		MarkovChain newMarkovChain = markovFactory.createMarkovChain();
		newMarkovChain.setName(originalMarkovChain.getName());

		// Copy all States from the original Markov Chain into the new one:
		for (int i = 0; i < originalMarkovChain.getStates().size(); i++) {

			// Create a new Markov State:
			State newState = markovFactory.createState();
			newState.setName(originalMarkovChain.getStates().get(i).getName());
			newState.setType(originalMarkovChain.getStates().get(i).getType());

			// Add the new State to the new Markov Chain:
			newMarkovChain.getStates().add(newState);
		}

		// Copy all Transitions from the originial Markov Chain into the new
		// one:
		for (int i = 0; i < originalMarkovChain.getTransitions().size(); i++) {

			// Create a new Transition:
			Transition newTransition = markovFactory.createTransition();
			newTransition.setName(originalMarkovChain.getTransitions().get(i)
					.getName());
			newTransition.setProbability(originalMarkovChain.getTransitions()
					.get(i).getProbability());

			// Determine the source and target States of the new Transition:
			State fromState = newMarkovChain.getStates().get(
					originalMarkovChain.getStates().indexOf(
							originalMarkovChain.getTransitions().get(i)
									.getFromState()));
			State toState = newMarkovChain.getStates().get(
					originalMarkovChain.getStates().indexOf(
							originalMarkovChain.getTransitions().get(i)
									.getToState()));
			newTransition.setFromState(fromState);
			newTransition.setToState(toState);

			// Add the new Transition to the new Markov Chain:
			newMarkovChain.getTransitions().add(newTransition);
		}

		// Return the resulting Markov Chain:
		return newMarkovChain;
	}

	/**
	 * Finds the fist State within a given Markov Chain that has the given
	 * StateType.
	 * 
	 * @param markovChain
	 *            the Markov Chain
	 * @param stateType
	 *            the StateType
	 * @return the Success State
	 */
	private State findState(final MarkovChain markovChain,
			final StateType stateType) {

		// Go through all states of the Markov Chain:
		for (int i = 0; i < markovChain.getStates().size(); i++) {
			if (markovChain.getStates().get(i).getType().equals(stateType)) {
				return markovChain.getStates().get(i);
			}
		}

		// Nothing found?
		logger.error("Markov Chain has no state of type "
				+ stateType.toString());
		return null;
	}

	/**
	 * Creates a list of all Transitions in a Markov Chain that lead to a given
	 * target state.
	 * 
	 * @param markovChain
	 *            the Markov Chain
	 * @param targetState
	 *            the target state
	 * @return the list of transitions
	 */
	private ArrayList<Transition> findTransitionsToState(
			final MarkovChain markovChain, final State targetState) {

		// Initialize the resulting List:
		ArrayList<Transition> resultList = new ArrayList<Transition>();

		// Go through all transitions of the Markov Chain:
		for (int i = 0; i < markovChain.getTransitions().size(); i++) {
			if (markovChain.getTransitions().get(i).getToState() == targetState) {
				resultList.add(markovChain.getTransitions().get(i));
			}
		}

		// Return the result:
		return resultList;
	}

	/**
	 * Creates a list of all Transitions in a Markov Chain that start from a
	 * given source state.
	 * 
	 * @param markovChain
	 *            the Markov Chain
	 * @param sourceState
	 *            the source state
	 * @return the list of transitions
	 */
	private ArrayList<Transition> findTransitionsFromState(
			final MarkovChain markovChain, final State sourceState) {

		// Initialize the resulting List:
		ArrayList<Transition> resultList = new ArrayList<Transition>();

		// Go through all transitions of the Markov Chain:
		for (int i = 0; i < markovChain.getTransitions().size(); i++) {
			if (markovChain.getTransitions().get(i).getFromState() == sourceState) {
				resultList.add(markovChain.getTransitions().get(i));
			}
		}

		// Return the result:
		return resultList;
	}

	/**
	 * Deletes all Transitions from the given Markov Model which are part of the
	 * given transitions list.
	 * 
	 * @param markovChain
	 *            the Markov Chain
	 * @param transitionsToDelete
	 *            the transition list
	 */
	private void deleteTransitions(final MarkovChain markovChain,
			final ArrayList<Transition> transitionsToDelete) {

		// Go through all transitions of the given list:
		for (int i = 0; i < transitionsToDelete.size(); i++) {

			// Remove this transition from the Markov Chain:
			markovChain.getTransitions().remove(transitionsToDelete.get(i));
		}
	}

	/**
	 * Adds the given Transition to the given Markov Chain. If the given Markov
	 * Chain already has a Transition between the same source and target States,
	 * the already existing Transition is merged with the new one by summing up
	 * the probabilities of the two Transitions.
	 * 
	 * @param markovChain
	 *            the Markov Chain
	 * @param transitionToContribute
	 *            the Transition
	 */
	private void contributeTransition(final MarkovChain markovChain,
			final Transition transitionToContribute) {

		// Go through the Transitions of the Markov Chain to find an already
		// existing Transition that corresponds to the new one:
		Transition transitionCorresponding = null;
		for (int i = 0; i < markovChain.getTransitions().size(); i++) {
			if ((markovChain.getTransitions().get(i).getFromState() == transitionToContribute
					.getFromState())
					&& (markovChain.getTransitions().get(i).getToState() == transitionToContribute
							.getToState())) {
				transitionCorresponding = markovChain.getTransitions().get(i);
				break;
			}
		}

		// Does a corresponding Transition already exist?
		if (transitionCorresponding != null) {

			// Add the probability of the new Transition to that of the already
			// existing one:
			transitionCorresponding.setProbability(transitionCorresponding
					.getProbability()
					+ transitionToContribute.getProbability());
		} else {

			// Simply add the new Transition to the Markov Chain:
			markovChain.getTransitions().add(transitionToContribute);
		}
	}

	/**
	 * Adds the given List of States to the given Markov Chain. Only those
	 * states are added whose StateTypes correspond to the given StateType.
	 * 
	 * @param markovChain
	 *            the Markov Chain
	 * @param statesToAdd
	 *            the list of states to add
	 * @param stateType
	 *            the StateType
	 */
	private void addStates(final MarkovChain markovChain,
			final EList<State> statesToAdd, final StateType stateType) {

		// Go through all states of the given state list:
		for (int i = 0; i < statesToAdd.size(); i++) {
			if (statesToAdd.get(i).getType().equals(stateType)) {
				markovChain.getStates().add(statesToAdd.get(i));
			}
		}
	}

	/**
	 * Reduces the given Markov State in the given Markov Chain. The State is
	 * deleted and all transitions leading to or starting from the State are
	 * re-calculated so that the failure and success probabilities of the
	 * overall Markov Chain are preserved.
	 * 
	 * @param markovChain
	 *            the Markov Chain
	 * @param stateToReduce
	 *            the state which will be reduced
	 */
	private void reduceState(final MarkovChain markovChain,
			final State stateToReduce) {

		// Assure that the State which will be reduced is contained in the given
		// Markov Chain:
		if (!markovChain.getStates().contains(stateToReduce)) {
			return;
		}

		// Assure that the State which will be reduced is not the Start, Success
		// or Failure State:
		if (!stateToReduce.getType().equals(StateType.DEFAULT)) {
			return;
		}

		// Find and delete all transitions in the Markov Chain that lead to the
		// reduceable State:
		ArrayList<Transition> transitionsToReduceState = findTransitionsToState(
				markovChain, stateToReduce);
		deleteTransitions(markovChain, transitionsToReduceState);

		// Find and delete all transitions in the Markov Chain that start from
		// the reduceable State:
		ArrayList<Transition> transitionsFromReduceState = findTransitionsFromState(
				markovChain, stateToReduce);
		deleteTransitions(markovChain, transitionsFromReduceState);

		// Delete the reduceable State:
		markovChain.getStates().remove(stateToReduce);

		// Build new transitions to replace the deleted ones:
		for (int i = 0; i < transitionsToReduceState.size(); i++) {
			for (int j = 0; j < transitionsFromReduceState.size(); j++) {

				// Create a new transition:
				Transition transition = markovFactory.createTransition();

				// Set the source and target States:
				transition.setFromState(transitionsToReduceState.get(i)
						.getFromState());
				transition.setToState(transitionsFromReduceState.get(j)
						.getToState());

				// Calculate the transition probability:
				transition.setProbability(transitionsToReduceState.get(i)
						.getProbability()
						* transitionsFromReduceState.get(j).getProbability());

				// Set the name of the transition:
				switch (transition.getToState().getType().getValue()) {
				case StateType.FAILURE_VALUE:
					transition.setName(transition.getFromState().getName()
							+ " - " + StateType.FAILURE.toString());
					break;
				default:
					transition.setName(transition.getFromState().getName()
							+ " - " + StateType.SUCCESS.toString());
					break;
				}

				// Add the new Transition to the Markov Chain:
				contributeTransition(markovChain, transition);
			}
		}
	}
}
