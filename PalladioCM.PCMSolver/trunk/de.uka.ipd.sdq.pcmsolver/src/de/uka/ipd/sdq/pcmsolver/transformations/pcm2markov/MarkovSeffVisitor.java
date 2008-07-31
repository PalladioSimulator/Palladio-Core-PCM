package de.uka.ipd.sdq.pcmsolver.transformations.pcm2markov;

import java.util.ArrayList;
import java.util.ListIterator;

import markov.MarkovChain;
import markov.MarkovFactory;
import markov.State;
import markov.StateType;
import markov.Transition;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;

import de.uka.ipd.pcmsolver.markovsolver.MarkovSolver;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.AbstractResourceDemandingAction;
import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.seff.LoopAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.StartAction;
import de.uka.ipd.sdq.pcm.seff.StopAction;
import de.uka.ipd.sdq.pcm.seff.util.SeffSwitch;
import de.uka.ipd.sdq.pcmsolver.transformations.ContextWrapper;
import de.uka.ipd.sdq.pcmsolver.visitors.EMFHelper;
import de.uka.ipd.sdq.probfunction.Sample;
import de.uka.ipd.sdq.probfunction.math.ISample;
import de.uka.ipd.sdq.probfunction.math.ManagedPMF;

/**
 * This class represents a visitor for an RDSEFF within a PCM instance. The
 * visitor is used in the transformation from PCM with solved dependencies into
 * a Markov Chain Model for reliability prediction.
 * 
 * @author brosch
 */
public class MarkovSeffVisitor extends SeffSwitch {

	/**
	 * A logger to give detailed information about the PCM instance traversal.
	 */
	private static Logger logger = Logger.getLogger(MarkovSeffVisitor.class
			.getName());

	/**
	 * The ContextWrapper provides easy access to the decorations of the solved
	 * PCM instance.
	 */
	private ContextWrapper contextWrapper;

	/**
	 * The Markov Factory is used to create the Elements of the Markov Chain
	 * Model resulting from the transformation.
	 */
	private MarkovFactory markovFactory = MarkovFactory.eINSTANCE;

	/**
	 * The Markov Solver is used here to already solve the Markov Chain.
	 */
	private MarkovSolver solver = new MarkovSolver();

	/**
	 * The constructor.
	 * 
	 * @param wrapper
	 *            the ContextWrapper provides easy access to the decorations of
	 *            the solved PCM instance
	 */
	public MarkovSeffVisitor(ContextWrapper wrapper) {
		contextWrapper = wrapper;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.pcm.seff.util.SeffSwitch#caseResourceDemandingBehaviour(de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour)
	 */
	@Override
	public MarkovChain caseResourceDemandingBehaviour(
			ResourceDemandingBehaviour behaviour) {

		// Do the logging:
		logger.info("Visit ResourceDemandingBehaviour");

		// Initialize a new Markov Chain that will represent this Behaviour:
		MarkovChain aggregateMarkovChain = initNewMarkovChain("behaviour");

		// Go through the chain of actions that constitute this RDSEFF. Each
		// action is expected to create its own specific Markov Chain. Each
		// specific chain will then be incorporated into the aggregate RDSEFF
		// Markov Chain:
		AbstractAction action = (StartAction) EMFHelper.getObjectByType(
				behaviour.getSteps_Behaviour(), StartAction.class);
		while (action != null) {
			MarkovChain specificMarkovChain = (MarkovChain) doSwitch(action);
			incorporateMarkovChain(aggregateMarkovChain, specificMarkovChain);
			action = action.getSuccessor_AbstractAction();
		}

		// Return the resulting Markov Chain:
		return aggregateMarkovChain;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.pcm.seff.util.SeffSwitch#caseResourceDemandingSEFF(de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF)
	 */
	@Override
	public MarkovChain caseResourceDemandingSEFF(ResourceDemandingSEFF seff) {

		// Do the logging:
		logger.info("Visit ResourceDemandingSEFF ["
				+ seff.getDescribedService__SEFF().getServiceName() + "]");

		// Initialize a new Markov Chain that will represent this RDSEFF:
		MarkovChain aggregateMarkovChain = initNewMarkovChain(seff
				.getDescribedService__SEFF().getServiceName());

		// Go through the chain of actions that constitute this RDSEFF. Each
		// action is expected to create its own specific Markov Chain. Each
		// specific chain will then be incorporated into the aggregate RDSEFF
		// Markov Chain:
		AbstractAction action = (StartAction) EMFHelper.getObjectByType(seff
				.getSteps_Behaviour(), StartAction.class);
		while (action != null) {
			MarkovChain specificMarkovChain = (MarkovChain) doSwitch(action);
			incorporateMarkovChain(aggregateMarkovChain, specificMarkovChain);
			action = action.getSuccessor_AbstractAction();
		}

		// Return the resulting Markov Chain:
		return aggregateMarkovChain;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.pcm.seff.util.SeffSwitch#caseStartAction(de.uka.ipd.sdq.pcm.seff.StartAction)
	 */
	@Override
	public MarkovChain caseStartAction(StartAction startAction) {

		// Do the logging:
		logger.info("Visit StartAction [" + startAction.getEntityName() + "]");

		return initNewMarkovChain(startAction.getEntityName());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.pcm.seff.util.SeffSwitch#caseInternalAction(de.uka.ipd.sdq.pcm.seff.InternalAction)
	 */
	@Override
	public MarkovChain caseInternalAction(InternalAction internalAction) {

		// Do the logging:
		logger.info("Visit InternalAction [" + internalAction.getEntityName()
				+ "]");

		return initInternalMarkovChain(internalAction.getEntityName(),
				internalAction.getFailureProbability());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.pcm.seff.util.SeffSwitch#caseLoopAction(de.uka.ipd.sdq.pcm.seff.LoopAction)
	 */
	@Override
	public MarkovChain caseLoopAction(LoopAction loopAction) {

		// Do the logging:
		logger.info("Visit LoopAction [" + loopAction.getEntityName() + "]");

		// To avoid an outsized state space of the overall Markov Chain, we
		// resolve the inner Markov Chain that corresponds to the loop
		// independently and use the result as an input for the overall Markov
		// Chain:
		MarkovChain innerMarkovChain = (MarkovChain) doSwitch(loopAction
				.getBodyBehaviour_Loop());
		double resultInnerMarkovChain = solver.solve(innerMarkovChain);

		// Get the solved loop probability mass function:
		ManagedPMF pmf = contextWrapper.getLoopIterations(loopAction);

		// Build a Markov Chain that represents this loop:
		return initLoopMarkovChain(loopAction.getEntityName(), pmf,
				resultInnerMarkovChain);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see de.uka.ipd.sdq.pcm.seff.util.SeffSwitch#caseStopAction(de.uka.ipd.sdq.pcm.seff.StopAction)
	 */
	@Override
	public MarkovChain caseStopAction(StopAction stopAction) {

		// Do the logging:
		logger.info("Visit StopAction [" + stopAction.getEntityName() + "]");

		return initNewMarkovChain(stopAction.getEntityName());
	}

	/**
	 * Initializes a new Markov Chain. The new Markov Chain has only three
	 * states: a start state, a success state and a failure state. A single
	 * transition goes from start to success with probability 1.
	 * 
	 * @param name
	 *            the name of the new Markov Chain
	 * @return the new Markov Chain
	 */
	private MarkovChain initNewMarkovChain(String name) {

		// Create the Markov Chain Entity:
		MarkovChain markovChain = markovFactory.createMarkovChain();
		markovChain.setName(name);

		// Create the three States:
		State state_start = markovFactory.createState();
		state_start.setType(StateType.START);
		state_start.setName(name + " - " + state_start.getType().toString());
		State state_success = markovFactory.createState();
		state_success.setType(StateType.SUCCESS);
		state_success
				.setName(name + " - " + state_success.getType().toString());
		State state_failure = markovFactory.createState();
		state_failure.setType(StateType.FAILURE);
		state_failure
				.setName(name + " - " + state_failure.getType().toString());

		// Add the States to the Markov Chain:
		markovChain.getStates().add(state_start);
		markovChain.getStates().add(state_success);
		markovChain.getStates().add(state_failure);

		// Create the Transition:
		Transition transition_start_success = markovFactory.createTransition();
		transition_start_success.setFromState(state_start);
		transition_start_success.setToState(state_success);
		transition_start_success.setName(state_start.getName() + " - "
				+ StateType.SUCCESS.toString());
		transition_start_success.setProbability(1.0);

		// Add the Transition to the Markov Chain:
		markovChain.getTransitions().add(transition_start_success);

		// Return the result:
		return markovChain;
	}

	/**
	 * Creates a simple Markov Chain that represents an execution of an
	 * InternalAction. The InternalAction either succeeds or fails.
	 * 
	 * @param name
	 *            the name of the InternalAction
	 * @param failureProbability
	 *            a string that represents a failure probability of the
	 *            InternalAction
	 * @return the resulting Markov Chain
	 */
	private MarkovChain initInternalMarkovChain(String name,
			String failureProbability) {

		// We expect the failure probability to be a double between 0 and 1:
		double successProbability;
		try {
			successProbability = 1 - Double.parseDouble(failureProbability);
		} catch (NumberFormatException e) {
			logger
					.error("Unexpected format of failure probability specification: "
							+ failureProbability);
			successProbability = 1;
		}
		if ((successProbability < 0) || (successProbability > 1)) {
			logger.error("Invalid value of failure probability specification: "
					+ failureProbability);
			successProbability = 1;
		}

		// Create the Markov Chain Entity:
		MarkovChain markovChain = markovFactory.createMarkovChain();
		markovChain.setName(name);

		// Create the Start, Success and Failure States:
		State state_start = markovFactory.createState();
		state_start.setType(StateType.START);
		state_start.setName(name + " - " + state_start.getType().toString());
		State state_success = markovFactory.createState();
		state_success.setType(StateType.SUCCESS);
		state_success
				.setName(name + " - " + state_success.getType().toString());
		State state_failure = markovFactory.createState();
		state_failure.setType(StateType.FAILURE);
		state_failure
				.setName(name + " - " + state_failure.getType().toString());

		// Add the States to the Markov Chain:
		markovChain.getStates().add(state_start);
		markovChain.getStates().add(state_success);
		markovChain.getStates().add(state_failure);

		// Create the Transition from Start State to Success State:
		Transition transition_start_success = markovFactory.createTransition();
		transition_start_success.setFromState(state_start);
		transition_start_success.setToState(state_success);
		transition_start_success.setName(state_start.getName() + " - "
				+ StateType.SUCCESS.toString());
		transition_start_success.setProbability(successProbability);
		markovChain.getTransitions().add(transition_start_success);

		// Create the Transition from Start State to Failure State:
		Transition transition_start_failure = markovFactory.createTransition();
		transition_start_failure.setFromState(state_start);
		transition_start_failure.setToState(state_failure);
		transition_start_failure.setName(state_start.getName() + " - "
				+ StateType.FAILURE.toString());
		transition_start_failure.setProbability(1 - successProbability);
		markovChain.getTransitions().add(transition_start_failure);
		
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
	private MarkovChain initLoopMarkovChain(String name, ManagedPMF pmf,
			double innerResult) {

		// Create the Markov Chain Entity:
		MarkovChain markovChain = markovFactory.createMarkovChain();
		markovChain.setName(name);

		// Create the Start, Success and Failure States:
		State state_start = markovFactory.createState();
		state_start.setType(StateType.START);
		state_start.setName(name + " - " + state_start.getType().toString());
		State state_success = markovFactory.createState();
		state_success.setType(StateType.SUCCESS);
		state_success
				.setName(name + " - " + state_success.getType().toString());
		State state_failure = markovFactory.createState();
		state_failure.setType(StateType.FAILURE);
		state_failure
				.setName(name + " - " + state_failure.getType().toString());

		// Add the States to the Markov Chain:
		markovChain.getStates().add(state_start);
		markovChain.getStates().add(state_success);
		markovChain.getStates().add(state_failure);

		// Go through the samples of the probability mass function:
		for (int i = 0; i < pmf.getModelPmf().getSamples().size(); i++) {
			Sample sample = pmf.getModelPmf().getSamples().get(i);
			if (sample.getValue() instanceof Integer) {
				int sample_value = (Integer) sample.getValue();

				// We create a new State for this sample:
				State state_sample = markovFactory.createState();
				state_sample.setName(name + " - " + sample_value
						+ " times executing");
				markovChain.getStates().add(state_sample);

				// Create a transition from the Start State to the Sample State:
				Transition transition_sample = markovFactory.createTransition();
				transition_sample.setFromState(state_start);
				transition_sample.setToState(state_sample);
				transition_sample.setProbability(sample.getProbability());
				transition_sample.setName(name + " - executing");
				markovChain.getTransitions().add(transition_sample);

				// Create a transition from Sample State to Success State:
				Transition transition_success = markovFactory
						.createTransition();
				transition_success.setFromState(state_sample);
				transition_success.setToState(state_success);
				transition_success.setProbability(Math.pow(innerResult,
						sample_value));
				transition_success.setName(state_sample.getName() + " - "
						+ StateType.SUCCESS.toString());
				markovChain.getTransitions().add(transition_success);

				// Create a transition from Sample State to Failure State:
				Transition transition_failure = markovFactory
						.createTransition();
				transition_failure.setFromState(state_sample);
				transition_failure.setToState(state_failure);
				transition_failure.setProbability(1 - transition_success
						.getProbability());
				transition_failure.setName(state_sample.getName() + " - "
						+ StateType.FAILURE.toString());
				markovChain.getTransitions().add(transition_failure);

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
	private void incorporateMarkovChain(MarkovChain aggregateMarkovChain,
			MarkovChain specificMarkovChain) {

		// Find the Start, Success and Failure States of the aggregate Markov
		// Chain:
		State state_aggregate_start = findState(aggregateMarkovChain,
				StateType.START);
		State state_aggregate_success = findState(aggregateMarkovChain,
				StateType.SUCCESS);
		State state_aggregate_failure = findState(aggregateMarkovChain,
				StateType.FAILURE);
		if ((state_aggregate_start == null)
				|| (state_aggregate_success == null)
				|| (state_aggregate_failure == null)) {
			return;
		}

		// Find the Start, Success and Failure States of the specific Markov
		// Chain:
		State state_specific_start = findState(specificMarkovChain,
				StateType.START);
		State state_specific_success = findState(specificMarkovChain,
				StateType.SUCCESS);
		State state_specific_failure = findState(specificMarkovChain,
				StateType.FAILURE);
		if ((state_specific_start == null) || (state_specific_success == null)
				|| (state_specific_failure == null)) {
			return;
		}

		// Find and delete all transitions in the aggregate Markov Chain that
		// lead to the Success state:
		ArrayList<Transition> transitions_aggregate_toSuccess = findTransitionsToState(
				aggregateMarkovChain, state_aggregate_success);
		deleteTransitions(aggregateMarkovChain, transitions_aggregate_toSuccess);

		// Add the states of the specific Markov Chain to the aggregate Markov
		// Chain:
		addStates(aggregateMarkovChain, specificMarkovChain.getStates(),
				StateType.DEFAULT);

		// Build new transitions in the aggregate Markov Chain from the
		// transitions in the specific Markov Chain:
		ListIterator<Transition> iterator = specificMarkovChain
				.getTransitions().listIterator();
		while (iterator.hasNext()) {
			Transition transition_specific = iterator.next();

			// The process to build a Transition for the aggregate Markov Chain
			// depends on the characteristics of the Transition of the specific
			// Markov Chain:
			if (transition_specific.getFromState().equals(state_specific_start)) {

				// As the specific transition originates in the Start state of
				// the specific Markov Chain, one aggregate Transition for each
				// former Transition to the Success State in the aggregate
				// Markov Chain has to be created:
				for (int i = 0; i < transitions_aggregate_toSuccess.size(); i++) {

					// Create the new aggregate Transition:
					Transition transition_aggregate = markovFactory
							.createTransition();

					// Set the Source State of the aggregate Transition:
					transition_aggregate
							.setFromState(transitions_aggregate_toSuccess
									.get(i).getFromState());

					// Set the probability of the aggregate Transition:
					transition_aggregate
							.setProbability(transitions_aggregate_toSuccess
									.get(i).getProbability()
									* transition_specific.getProbability());

					// Set the Target State and Name of the aggregate
					// Transition:
					switch (transition_specific.getToState().getType()
							.getValue()) {
					case StateType.SUCCESS_VALUE:
						transition_aggregate
								.setToState(state_aggregate_success);
						transition_aggregate.setName(transition_aggregate
								.getFromState().getName()
								+ " - " + StateType.SUCCESS.toString());
						break;
					case StateType.FAILURE_VALUE:
						transition_aggregate
								.setToState(state_aggregate_failure);
						transition_aggregate.setName(transition_aggregate
								.getFromState().getName()
								+ " - " + StateType.FAILURE.toString());
						break;
					default:
						transition_aggregate.setToState(transition_specific
								.getToState());
						transition_aggregate.setName(transition_aggregate
								.getFromState().getName()
								+ " - " + StateType.SUCCESS.toString());
						break;
					}

					// Add the new Transition to the aggregate Markov Chain:
					aggregateMarkovChain.getTransitions().add(
							transition_aggregate);
				}
			} else {

				// As the specific transition does not originate in the Start
				// state of the specific Markov Model, exactly one aggregate
				// Transition will be created:
				Transition transition_aggregate = markovFactory
						.createTransition();

				// Take over Source State and Probability from specific
				// Transition:
				transition_aggregate.setFromState(transition_specific
						.getFromState());
				transition_aggregate.setProbability(transition_specific
						.getProbability());

				// Set Target State and Name of the aggregate Transition:
				switch (transition_specific.getToState().getType().getValue()) {
				case StateType.SUCCESS_VALUE:
					transition_aggregate.setToState(state_aggregate_success);
					transition_aggregate.setName(transition_aggregate
							.getFromState().getName()
							+ " - " + StateType.SUCCESS.toString());
					break;
				case StateType.FAILURE_VALUE:
					transition_aggregate.setToState(state_aggregate_failure);
					transition_aggregate.setName(transition_aggregate
							.getFromState().getName()
							+ " - " + StateType.FAILURE.toString());
					break;
				default:
					transition_aggregate.setToState(transition_specific
							.getToState());
					transition_aggregate.setName(transition_aggregate
							.getFromState().getName()
							+ " - " + StateType.SUCCESS.toString());
					break;
				}

				// Add the new Transition to the aggregate Markov Chain:
				aggregateMarkovChain.getTransitions().add(transition_aggregate);
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
	private State findState(MarkovChain markovChain, StateType stateType) {

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
			MarkovChain markovChain, State targetState) {

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
	private void deleteTransitions(MarkovChain markovChain,
			ArrayList<Transition> transitionsToDelete) {

		// Go through all transitions of the given list:
		for (int i = 0; i < transitionsToDelete.size(); i++) {

			// Remove this transition from the Markov Chain:
			markovChain.getTransitions().remove(transitionsToDelete.get(i));
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
	private void addStates(MarkovChain markovChain, EList<State> statesToAdd,
			StateType stateType) {

		// Go through all states of the given state list:
		for (int i = 0; i < statesToAdd.size(); i++) {
			if (statesToAdd.get(i).getType().equals(stateType)) {
				markovChain.getStates().add(statesToAdd.get(i));
			}
		}
	}
}
