package de.uka.ipd.sdq.pcmsolver.transformations.pcm2markov;

import java.util.ArrayList;
import java.util.ListIterator;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;

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
	 * and solved inner Markov Chain.
	 * 
	 * @param name
	 *            the name of the loop
	 * @param pmf
	 *            the probability mass function of the loop
	 * @param innerResult
	 *            the result of the solved inner Markov Chain
	 * @return the resulting Markov Chain
	 */
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
	 * Incorporates one Markov Chain into another. The specific Markov Chain is
	 * inserted into the aggregate Markov Chain directly before the Success
	 * state of the aggregate Markov Chain.
	 * 
	 * @param aggregateMarkovChain
	 *            the Markov Chain which will incorporate the other chain
	 * @param specificMarkovChain
	 *            the Markov Chain that will be incorporated into the other
	 *            chain
	 */
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
			if (transitionSpecific.getFromState().equals(stateSpecificStart)) {

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
			if (markovChain.getTransitions().get(i).getToState().equals(
					targetState)) {
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
			if ((markovChain.getTransitions().get(i).getFromState()
					.equals(transitionToContribute.getFromState()))
					&& (markovChain.getTransitions().get(i).getToState()
							.equals(transitionToContribute.getToState()))) {
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
}
