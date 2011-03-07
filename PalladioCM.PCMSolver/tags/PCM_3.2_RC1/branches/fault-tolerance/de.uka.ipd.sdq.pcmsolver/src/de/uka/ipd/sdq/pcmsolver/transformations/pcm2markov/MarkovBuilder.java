package de.uka.ipd.sdq.pcmsolver.transformations.pcm2markov;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.markov.Label;
import de.uka.ipd.sdq.markov.MarkovChain;
import de.uka.ipd.sdq.markov.MarkovFactory;
import de.uka.ipd.sdq.markov.State;
import de.uka.ipd.sdq.markov.StateType;
import de.uka.ipd.sdq.markov.Transition;
import de.uka.ipd.sdq.pcm.repository.EnvironmentFailureType;
import de.uka.ipd.sdq.pcm.repository.FailureType;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.FailureOccurrenceDescription;
import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import de.uka.ipd.sdq.probfunction.Sample;
import de.uka.ipd.sdq.probfunction.math.ManagedPMF;
import de.uka.ipd.sdq.probfunction.math.exception.ProbabilityFunctionException;

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

	public final static String failureTypeLabelKey="applicationFailureType";
	public final static String resourceFailureLabelTypeKey="environmentFailureType";
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

		// Create the Start and Success  States:
		State startState = addState(markovChain, StateType.START);
		State successSate = addState(markovChain, StateType.SUCCESS);
		connectStates(markovChain, startState, successSate, 1.0);

		// Return the result:
		return markovChain;
	}

	private State addState(MarkovChain chain, StateType type){
		return addState(chain, type, type.toString());
	}
	
	private State addState(MarkovChain chain, StateType type, String stateName){
		State state = markovFactory.createState();
		state.setType(type);
		state.setName(chain.getName()+ " - " + stateName);	
		
		chain.getStates().add(state);
		
		return state;
	}
	private void connectStates(MarkovChain chain, State from, State to, double probability){
		Transition transition = markovFactory.createTransition();
		transition.setFromState(from);
		transition.setToState(to);
		transition.setName(from.getName() + " -> " + to.getName());
		transition.setProbability(probability);
		chain.getTransitions().add(transition);
	}
	
	private State addStateForFailureOccurrence(MarkovChain chain, String name, FailureOccurrenceDescription occurrence) {
		State failureState = markovFactory.createState();
		failureState.setType(StateType.FAILURE);
		failureState.setName(name + " - " + StateType.FAILURE.toString() + " - " + occurrence.getFailuretype().getEntityName());
		
		Label failureLabel=markovFactory.createLabel();
		if(occurrence.getFailuretype() instanceof EnvironmentFailureType)
			failureLabel.setKey(resourceFailureLabelTypeKey);
		else 
			failureLabel.setKey(failureTypeLabelKey);
		
		failureLabel.setValue(occurrence.getFailuretype().getEntityName());
		failureState.getLabels().add(failureLabel);
		
		chain.getStates().add(failureState);
		
		return failureState;
	}
	

	
	/**
	 * Creates a Markov Chain that represents an execution of a
	 * ScenarioBehaviour.
	 * 
	 * @param name
	 *            the name of the new Markov Chain
	 * @param actions
	 *            the actions of the ScenarioBehaviour
	 * @param statesOut
	 *            the list of states created within the method that corresponds
	 *            to the given list of actions
	 * @return the resulting Markov Chain
	 */
	public MarkovChain initScenarioBehaviourMarkovChain(final String name,
			final ArrayList<AbstractUserAction> actions,
			final ArrayList<State> statesOut) {

		// Collect the action names:
		ArrayList<String> actionNames = new ArrayList<String>();
		for (int i = 0; i < actions.size(); i++) {
			actionNames.add(actions.get(i).getEntityName());
		}

		// Build the Markov Chain:
		return initBehaviourMarkovChain(name, actionNames, statesOut);
	}

	/**
	 * Creates a Markov Chain that represents an execution of a
	 * ResourceDemandingBehaviour.
	 * 
	 * @param name
	 *            the name of the new Markov Chain
	 * @param actions
	 *            the actions of the ResourceDemandingBehaviour
	 * @param statesOut
	 *            the list of states created within the method that corresponds
	 *            to the given list of actions
	 * @return the resulting Markov Chain
	 */
	public MarkovChain initResourceDemandingBehaviourMarkovChain(
			final String name, final ArrayList<AbstractAction> actions,
			final ArrayList<State> statesOut) {

		// Collect the action names:
		ArrayList<String> actionNames = new ArrayList<String>();
		for (int i = 0; i < actions.size(); i++) {
			actionNames.add(actions.get(i).getEntityName());
		}

		// Build the Markov Chain:
		return initBehaviourMarkovChain(name, actionNames, statesOut);
	}

	/**
	 * Creates a Markov Chain that represents an execution of a PCM behavior.
	 * For each action within the given chain of actions, a State within the
	 * resulting Markov Chain is created. Together with the Markov Chain, a list
	 * of States is returned that corresponds to the given action list.
	 * 
	 * @param name
	 *            the name of the new Markov Chain
	 * @param actionNames
	 *            the names of the actions of the Behaviour
	 * @param statesOut
	 *            the list of states created within the method that corresponds
	 *            to the given list of actions
	 * @return the resulting Markov Chain
	 */
	public MarkovChain initBehaviourMarkovChain(final String name,
			final ArrayList<String> actionNames,
			final ArrayList<State> statesOut) {

		// Create the Markov Chain Entity:
		MarkovChain markovChain = markovFactory.createMarkovChain();
		markovChain.setName(name);

		// Create the Start and Success States:
		State startState = addState(markovChain, StateType.START);
		State successState = addState(markovChain, StateType.SUCCESS);
		
		// Mark the State that will later lead directly to the Success State:
		State stateToSuccess = startState;

		// Go through the chain of actions:
		for (int i = 0; i < actionNames.size(); i++) {

			// Create a Markov State for this Action:
			State state = addState(markovChain, StateType.DEFAULT, actionNames.get(i));
			statesOut.add(state);

			connectStates(markovChain, stateToSuccess, state, 1.0);

			// Update the State leading to Success:
			stateToSuccess = state;
		}

		// Create the Transition leading to the Success State:
		connectStates(markovChain, stateToSuccess, successState, 1.0);

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
			final List<FailureOccurrenceDescription> failureOccurrences) {

		// Create the Markov Chain Entity:
		MarkovChain markovChain = markovFactory.createMarkovChain();
		markovChain.setName(name);

		// Create the Start and Success States:
		State startState = addState(markovChain, StateType.START);
		State successState = addState(markovChain, StateType.SUCCESS);

		double successProbability=1;
		// Create the Transition from Start State to Failure State:
		for(FailureOccurrenceDescription occurrence : failureOccurrences) {
			State failureState = addStateForFailureOccurrence(markovChain, name, occurrence);
			connectStates(markovChain, startState, failureState, occurrence.getFailureProbability());

			successProbability -= occurrence.getFailureProbability();
		}
		
		if(successProbability<0)
			throw new MarkovException("Total failure probability of InternalAction " + name + " is greater than 1.0.");
		
		// Create the Transition from Start State to Success State:
		connectStates(markovChain, startState, successState, successProbability);

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
	 * @throws ProbabilityFunctionException if the pmf samples are not integers
	 */
	public MarkovChain initLoopMarkovChain(final String name,
			final ManagedPMF pmf) {

		// Create the Markov Chain Entity:
		MarkovChain markovChain = markovFactory.createMarkovChain();
		markovChain.setName(name);

		// Create the Start and Success States:
		State startState = addState(markovChain, StateType.START);
		State successState = addState(markovChain, StateType.SUCCESS);

		// Go through the samples of the probability mass function:
		for (int i = 0; i < pmf.getModelPmf().getSamples().size(); i++) {
			Sample sample = pmf.getModelPmf().getSamples().get(i);
			if (!(sample.getValue() instanceof Integer)) {
				throw new MarkovException("Invalid Sample value "+sample.getValue().toString()+" in "+pmf.getModelPmf().toString());
			}
			
			int sampleValue = (Integer) sample.getValue();

			// Mark the State that will lead to the Success State:
			State stateToSuccess = startState;
			double transitionProbability = sample.getProbability();

			// Go through the iterations of this sample:
			for (int j = 0; j < sampleValue; j++) {

				// Create a new State:
				State stateSample = addState(markovChain, StateType.DEFAULT, "execution " + (j + 1)	+ " of " + sampleValue);
				connectStates(markovChain, stateToSuccess, stateSample, transitionProbability);

				// Update State and probability:
				stateToSuccess = stateSample;
				transitionProbability = 1;
			}

			connectStates(markovChain, stateToSuccess, successState, transitionProbability);
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

		// Create the Start and Success States:
		State startState = addState(markovChain, StateType.START);
		State successState = addState(markovChain, StateType.SUCCESS);

		// Go through the given branch probabilities:
		for (int i = 0; i < branchProbabilities.size(); i++) {

			// Create a new State:
			State stateBranch = addState(markovChain, StateType.DEFAULT, "branch " + (i + 1));
			
			// Create a transition from the Start State to the new one:
			connectStates(markovChain, startState, stateBranch, branchProbabilities.get(i));
			
			// Create a transition from new state to the success state
			connectStates(markovChain, stateBranch, successState, 1.0);
		}

		// Return the result:
		return markovChain;
	}

	/**
	 * Incorporates one Markov Chain into another. The specific Markov Chain is
	 * inserted into the aggregate Markov Chain replacing the given aggregate
	 * Markov State.
	 * 
	 * @param parentChain
	 *            the Markov Chain which will incorporate the other chain
	 * @param specificMarkovChain
	 *            the Markov Chain which will be incorporated into the other
	 *            chain
	 * @param aggregateState
	 *            the Markov State in the aggregate Markov Chain which will be
	 *            replaced by the specific Markov Chain
	 * @param optimize
	 *            indicates if Markov Chain reduction shall be performed during
	 *            the transformation
	 */
	public void incorporateMarkovChain(final MarkovChain parentChain,
			final MarkovChain specificMarkovChain, final State aggregateState,
			final boolean optimize) {

		// Assure that the replaceable Markov State is contained in the
		// aggregate Markov Chain:
		if (!parentChain.getStates().contains(aggregateState)) {
			throw new MarkovException("State '"+aggregateState+"' is not contained in the markov chain '"+parentChain.getName()+"'.");
		}

		// Assure that the replaceable Markov State is not a Start, Success or
		// Failure State:
		if (!aggregateState.getType().equals(StateType.DEFAULT)) {
			throw new MarkovException("Only default states can be incorporated. '"+aggregateState.getName()+"' is of type '"+aggregateState.getType()+"'.");
		}

		// Create a copy of the specific Markov Chain to prevent reuse of any
		// States or Transitions of the specific Markov Chain within the
		// aggregate Markov Chain (this could lead to problems when one specific
		// Markov Chain is incorporated several times into the same aggregate
		// Markov Chain):
		MarkovChain copiedSpecificMarkovChain = copyMarkovChain(specificMarkovChain);

		// Find the Start, Success and Failure States of the aggregate Markov
		// Chain:
		List<State> stateAggregateFailures = getFailureStates(parentChain);

		// Find the Start, Success and Failure States of the specific Markov
		// Chain:
		State stateSpecificStart = getStartState(copiedSpecificMarkovChain);
		State stateSpecificSuccess = getSuccessState(copiedSpecificMarkovChain);
		List<State> stateSpecificFailures = getFailureStates(copiedSpecificMarkovChain);


		// Take over the specific Markov Chain into the aggregate Markov Chain:
		parentChain.getStates().addAll(copiedSpecificMarkovChain.getStates());
		parentChain.getTransitions().addAll(copiedSpecificMarkovChain.getTransitions());

		//all transitions to the replaceable state are delegated to the inner start state
		delegateIncommingTransitions(parentChain, aggregateState, stateSpecificStart);
		stateSpecificStart.setType(StateType.DEFAULT);
		
		//absorb failure states. for already existing failure type states delegate transitions 
		//from inner duplicates.
		List<State> duplicateFailureStates=new ArrayList<State>();
		for(State failureState : stateSpecificFailures) {
			//check if this is a duplicate
			State existingFailureState=findMatchingFailureState(stateAggregateFailures, failureState);
			if(existingFailureState!=null) { //duplicate found
				//delegate from duplicate to existing state
				connectStates(parentChain, failureState, existingFailureState, 1.0);
				//remove duplicate
				failureState.setType(StateType.DEFAULT);
				duplicateFailureStates.add(failureState);
			}
		}
		
		//
		delegateOutgoingTransitions(parentChain, aggregateState, stateSpecificSuccess);
		stateSpecificSuccess.setType(StateType.DEFAULT);

		//remove the 
		parentChain.getStates().remove(aggregateState);

		// Optimize the aggregate MarkovChain:
		if (optimize) {
			reduceState(parentChain, stateSpecificStart);
			reduceState(parentChain, stateSpecificSuccess);
			for(State failureState : duplicateFailureStates)
				reduceState(parentChain, failureState);
		}
	}
	
	/**
	 * Incorporates one Markov Chain into another. The specific Markov Chain is
	 * inserted into the aggregate Markov Chain replacing the failure state.
	 * 
	 * @param aggregateChain
	 *            the Markov Chain which will incorporate the other chain
	 * @param handlingChain
	 *            the Markov Chain which will be incorporated into the other
	 *            chain
	 * @param optimize
	 *            indicates if Markov Chain reduction shall be performed during
	 *            the transformation
	 */
	public void appendFailureHandlingChain(final MarkovChain aggregateChain, 
			final MarkovChain handlingChain, final List<String> handledFailures,
			final boolean optimize) {
		
		List<State> failureStates=getFailureStates(aggregateChain);
		
		for(State failureState : failureStates) {
			String failureTypeLabelValue = getFailureTypeLabelValue(failureState);
			if(failureTypeLabelValue==null)
				throw new MarkovException("Failure state has no label."); //TODO: Maybe we should use a default failure type
			
			if(handledFailures.contains(failureTypeLabelValue)) {
				appendFailureHandlingChain(aggregateChain, handlingChain, failureState, optimize);
			}
		}
	}

	private void appendFailureHandlingChain(final MarkovChain aggregateChain, 
			final MarkovChain handlingChain, State failureState,
			final boolean optimize) {

		this.validateChain(aggregateChain);
		this.validateChain(handlingChain);
		
		// Create a copy of the specific Markov Chain to prevent reuse of any
		// States or Transitions of the specific Markov Chain within the
		// aggregate Markov Chain (this could lead to problems when one specific
		// Markov Chain is incorporated several times into the same aggregate
		// Markov Chain):
		MarkovChain handlingChainCopy = copyMarkovChain(handlingChain);
		
		//find the relevant states
		State stateAggregateSuccess = getSuccessState(aggregateChain);
		List<State> stateAggregateFailures = getFailureStates(aggregateChain);

		State stateHandlingStart = getStartState(handlingChainCopy);
		State stateHandlingSuccess = getSuccessState(handlingChainCopy);
		List<State> stateHandlingFailures = getFailureStates(handlingChainCopy);
		
		// Take over the specific Markov Chain into the aggregate Markov Chain:
		aggregateChain.getStates().addAll(handlingChainCopy.getStates());
		aggregateChain.getTransitions().addAll(handlingChainCopy.getTransitions());
		
		delegateIncommingTransitions(aggregateChain, failureState, stateHandlingStart);
		stateHandlingStart.setType(StateType.DEFAULT);
		aggregateChain.getStates().remove(failureState);
		stateAggregateFailures.remove(failureState);
		
		connectStates(aggregateChain, stateHandlingSuccess, stateAggregateSuccess, 1.0);
		stateHandlingSuccess.setType(StateType.DEFAULT);
		
		//absorb failure states. for already existing failure type states delegate transitions 
		//from inner duplicates.
		List<State> duplicateFailureStates=new ArrayList<State>();
		for(State innerFailureState : stateHandlingFailures) {
			//check if this is a duplicate
			State existingFailureState=findMatchingFailureState(stateAggregateFailures, innerFailureState);
			if(existingFailureState!=null) { //duplicate found
				//delegate from duplicate to existing state
				connectStates(aggregateChain, innerFailureState, existingFailureState, 1.0);
				//remove duplicate
				innerFailureState.setType(StateType.DEFAULT);
				duplicateFailureStates.add(innerFailureState);
			}
		}
		
		// Optimize the aggregate MarkovChain:
		if (optimize) {
			reduceState(aggregateChain, stateHandlingStart);
			reduceState(aggregateChain, stateHandlingSuccess);
			for(State duplicateState: duplicateFailureStates)
				reduceState(aggregateChain, duplicateState);
		}
	}
	
	/**
	 * Creates a copy of a Markov Chain. All States and Transitions of the
	 * original Markov Chain are copied into the new one.
	 * 
	 * @param originalMarkovChain
	 *            the original Markov Chain
	 * @return the new Markov Chain
	 */
	public MarkovChain copyMarkovChain(final MarkovChain originalMarkovChain) {

		// Create a new Markov Chain instance:
		MarkovChain newMarkovChain = markovFactory.createMarkovChain();
		newMarkovChain.setName(originalMarkovChain.getName());

		// Copy all States from the original Markov Chain into the new one:
		for (int i = 0; i < originalMarkovChain.getStates().size(); i++) {

			State originalState=originalMarkovChain.getStates().get(i);
			// Create a new Markov State:
			State newState = markovFactory.createState();
			newState.setName(originalState.getName());
			newState.setType(originalState.getType());

			for(Label originalLabel : originalState.getLabels()) {
				Label newLabel=markovFactory.createLabel();
				newLabel.setKey(originalLabel.getKey());
				newLabel.setValue(originalLabel.getValue());
				newState.getLabels().add(newLabel);
			}
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
	 * Finds the fist success state within a given Markov Chain 
	 * 
	 * @param markovChain
	 *            the Markov Chain
	 * @param stateType
	 *            the StateType
	 * @return the Success State
	 */
	public State getSuccessState(final MarkovChain markovChain) {

		// Go through all states of the Markov Chain:
		for (int i = 0; i < markovChain.getStates().size(); i++) {
			if (markovChain.getStates().get(i).getType().equals(StateType.SUCCESS)) {
				return markovChain.getStates().get(i);
			}
		}

		throw new MarkovException("Markov Chain has no success state.");
	}
	
	private State getStartState(final MarkovChain markovChain) {

		// Go through all states of the Markov Chain:
		for (int i = 0; i < markovChain.getStates().size(); i++) {
			if (markovChain.getStates().get(i).getType().equals(StateType.START)) {
				return markovChain.getStates().get(i);
			}
		}

		throw new MarkovException("Markov Chain has no start state.");
	}
	
	public List<State> getFailureStates(final MarkovChain markovChain) {

		List<State> failureStates=new ArrayList<State>();
		// Go through all states of the Markov Chain:
		for (int i = 0; i < markovChain.getStates().size(); i++) {
			if (markovChain.getStates().get(i).getType().equals(StateType.FAILURE)) {
				failureStates.add(markovChain.getStates().get(i));
			}
		}

		return failureStates;
	}
	
	public String getFailureTypeLabelValue(State state) {
		for(Label label:state.getLabels()) {
			if(label.getKey().equals(failureTypeLabelKey) || label.getKey().equals(resourceFailureLabelTypeKey)) {
				return label.getValue();
			}
		}
		
		return null;
	}
	
	private State findMatchingFailureState(final List<State> states, State failureState) {
		
		String failureTypeLabelValue=getFailureTypeLabelValue(failureState);
		
		return findFailureState(states, failureTypeLabelValue);
	}

	private State findFailureState(final List<State> states, String failureTypeLabelValue) {
		for(State state : states) {
			if(!state.getType().equals(StateType.FAILURE))
				continue;
			
			for(Label label : state.getLabels()) { //TODO: this is linear search inside an outer loop! improve performance
				if((label.getKey().equals(failureTypeLabelKey) || label.getKey().equals(resourceFailureLabelTypeKey)) && label.getValue().equals(failureTypeLabelValue))
					return state;
			}
		}
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

	private void delegateIncommingTransitions(MarkovChain chain, State originalState, State newState) {
		ArrayList<Transition> transitions = findTransitionsToState(
				chain, originalState);
		
		for(Transition transition : transitions) {
			transition.setToState(newState);
		}
	}
	
	private void delegateOutgoingTransitions(MarkovChain chain, State originalState, State newState) {
		ArrayList<Transition> transitions = findTransitionsFromState(
				chain, originalState);
		
		for(Transition transition : transitions) {
			transition.setFromState(newState);
		}
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
			throw new MarkovException("Cannot reduce Markov State. The Markov Chain does not contain that state.");
		}

		// Assure that the State which will be reduced is not the Start, Success
		// or Failure State:
		if (!stateToReduce.getType().equals(StateType.DEFAULT)) {
			throw new MarkovException("Cannot reduce Markov State. Only intermediate states can be reduced.");
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
	
	public void validateChain(MarkovChain chain){

		for(Transition t : chain.getTransitions()) {
			if(t.getFromState()==null || t.getToState()==null)
				throw new MarkovException("Invalid transiton in Markov Chain.");
		}
		
		boolean hasStart=false;
		boolean hasSuccess=false;
		boolean hasFailure=false;
		for(State s : chain.getStates()){
			if(s.getType()==StateType.START) {
				if(hasStart)
					throw new MarkovException("Multiple start states in Markov Chain.");
				else 
					hasStart=true;
			}
			else if(s.getType()==StateType.SUCCESS) {
				if(hasSuccess)
					throw new MarkovException("Multiple success states in Markov Chain.");
				else 
					hasSuccess=true;
			}
		}
		
		if(!hasStart)
			throw new MarkovException("No start state in Markov Chain.");
		
		if(!hasSuccess)
			throw new MarkovException("No success state in Markov Chain.");
		
		//TODO: Check for transitions leading to dead ends
		//TODO: Check for cycles
	}
	

	
}
