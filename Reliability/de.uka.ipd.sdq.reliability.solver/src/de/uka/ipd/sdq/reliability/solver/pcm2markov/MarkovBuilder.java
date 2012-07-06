package de.uka.ipd.sdq.reliability.solver.pcm2markov;

import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.markov.Label;
import de.uka.ipd.sdq.markov.MarkovChain;
import de.uka.ipd.sdq.markov.MarkovFactory;
import de.uka.ipd.sdq.markov.State;
import de.uka.ipd.sdq.markov.StateType;
import de.uka.ipd.sdq.markov.Transition;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.ForkedBehaviour;
import de.uka.ipd.sdq.probfunction.Sample;
import de.uka.ipd.sdq.probfunction.math.ManagedPMF;

/**
 * This class provides methods for building Markov Chains.
 * 
 * @author brosch
 * 
 */
public class MarkovBuilder {

    /**
     * Key to identify a Markov label as holding a failure type id.
     */
    private static final String FAILURETYPEID = "FailureTypeId";

    /**
     * Key to identify a Markov label as holding a failure type name.
     */
    private static final String FAILURETYPENAME = "FailureTypeName";

    /**
     * The Markov Factory is used to create the Elements of the Markov Chain Model resulting from
     * the transformation.
     */
    private MarkovFactory markovFactory = MarkovFactory.eINSTANCE;

    /**
     * Indicates if the resulting Makov model shall be augmented with tracing information for
     * diagnostic purposes.
     */
    private boolean recordTraces;

    /**
     * The constructor.
     * 
     * @param recordTraces
     *            controls if traces shall be recorded during transformation
     */
    public MarkovBuilder(final boolean recordTraces) {
        this.recordTraces = recordTraces;
    }

    /**
     * Adds a state of a given type and with a given name to a Markov chain.
     * 
     * @param chain
     *            the Markov chain
     * @param type
     *            the type of state to add
     * @param stateName
     *            the name for the state to add
     * @param prefixes
     *            the prefixes to add to the state name
     * @return the new state
     */
    private State addState(final MarkovChain chain, final StateType type, final String stateName,
            final List<String> prefixes) {
        State state = markovFactory.createState();
        state.setType(type);
        state.setName(getStateName(stateName, prefixes));
        state.getTraces().addAll(getStateTraces(stateName, prefixes));
        chain.getStates().add(state);
        return state;
    }

    /**
     * Adds a failure state to a given Markov chain.
     * 
     * @param chain
     *            the Markov chain
     * @param prefixes
     *            the prefixes of the state name
     * @param description
     *            the description of the failure type
     * @return the new failure state
     */
    private State addStateForFailureDescription(final MarkovChain chain, final List<String> prefixes,
            final FailureDescription description) {

        // Create the new failure state and add it to the chain:
        State failureState = addState(chain, StateType.FAILURE, StateType.FAILURE.toString() + "("
                + description.getFailureType().getName() + ")", prefixes);

        // Add a label to the state for the failure id:
        Label failureIdLabel = markovFactory.createLabel();
        failureIdLabel.setKey(FAILURETYPEID);
        failureIdLabel.setValue(description.getFailureType().getId());
        failureState.getLabels().add(failureIdLabel);

        // Add a label to the state for the failure name:
        Label failureNameLabel = markovFactory.createLabel();
        failureNameLabel.setKey(FAILURETYPENAME);
        failureNameLabel.setValue(description.getFailureType().getName());
        failureState.getLabels().add(failureNameLabel);

        // Return the new Failure state:
        return failureState;
    }

    /**
     * Incorporates one Markov chain into another to replace a failure state with a new behavior.
     * 
     * @param aggregateChain
     *            the outer Markov chain
     * @param handlingChain
     *            the inner Markov chain to replace the failure state
     * @param failureState
     *            the failure state to replace
     * @param optimize
     *            indicates if Markov Chain reduction shall be performed during the transformation
     */
    private void appendFailureHandlingChain(final MarkovChain aggregateChain, final MarkovChain handlingChain,
            final State failureState, final boolean optimize) {

        // First validate both chains:
        this.validateChain(aggregateChain);
        this.validateChain(handlingChain);

        // Create a copy of the specific Markov Chain to prevent reuse of any
        // States or Transitions of the specific Markov Chain within the
        // aggregate Markov Chain (this could lead to problems when one specific
        // Markov Chain is incorporated several times into the same aggregate
        // Markov Chain):
        MarkovChain handlingChainCopy = copyMarkovChain(handlingChain);

        // Find the relevant states:
        State aggregateChainSuccessState = getSuccessState(aggregateChain);
        List<State> aggregateChainFailureStates = getFailureStates(aggregateChain);

        State handlingChainStartState = getStartState(handlingChainCopy);
        State handlingChainSuccessState = getSuccessState(handlingChainCopy);

        // Take over the specific Markov Chain into the aggregate Markov Chain:
        aggregateChain.getStates().addAll(handlingChainCopy.getStates());
        aggregateChain.getTransitions().addAll(handlingChainCopy.getTransitions());

        delegateIncommingTransitions(aggregateChain, failureState, handlingChainStartState);
        handlingChainStartState.setType(StateType.DEFAULT);
        aggregateChain.getStates().remove(failureState);
        aggregateChainFailureStates.remove(failureState);

        connectStates(aggregateChain, handlingChainSuccessState, aggregateChainSuccessState, 1.0);
        handlingChainSuccessState.setType(StateType.DEFAULT);

        // Optimize the aggregate MarkovChain:
        if (optimize) {
            reduceState(aggregateChain, handlingChainStartState);
            reduceState(aggregateChain, handlingChainSuccessState);
        }
    }

    /**
     * Incorporates one Markov Chain into another. The specific Markov Chain is inserted into the
     * aggregate Markov Chain replacing the failure state.
     * 
     * @param aggregateChain
     *            the Markov Chain which will incorporate the other chain
     * @param aggregateFailureStates
     *            the failure states of the aggregate chain that shall be considered
     * @param handlingChain
     *            the Markov Chain which will be incorporated into the other chain
     * @param handledFailureTypeIds
     *            the list of handled failure types
     * @param removeDuplicateFailureStates
     *            indicates if duplicateFailureStates shall be removed at the end of the procedure
     * @param optimize
     *            indicates if Markov Chain reduction shall be performed during the transformation
     */
    private void appendFailureHandlingMarkovChain(final MarkovChain aggregateChain,
            final List<State> aggregateFailureStates, final MarkovChain handlingChain,
            final List<String> handledFailureTypeIds, final boolean optimize) {
        for (State failureState : aggregateFailureStates) {
            String failureTypeLabelValue = getFailureTypeId(failureState);
            if (isFailureTypeHandled(handledFailureTypeIds, failureTypeLabelValue)) {
                appendFailureHandlingChain(aggregateChain, handlingChain, failureState, optimize);
            }
        }
    }

    /**
     * Incorporates one Markov Chain into another. The specific Markov Chain is inserted into the
     * aggregate Markov Chain replacing the failure state.
     * 
     * @param aggregateChain
     *            the Markov Chain which will incorporate the other chain
     * @param handlingChain
     *            the Markov Chain which will be incorporated into the other chain
     * @param handledFailureTypeIds
     *            the list of handled failure types
     * @param optimize
     *            indicates if Markov Chain reduction shall be performed during the transformation
     */
    public void appendFailureHandlingMarkovChain(final MarkovChain aggregateChain, final MarkovChain handlingChain,
            final List<String> handledFailureTypeIds, final boolean optimize) {
        appendFailureHandlingMarkovChain(aggregateChain, getFailureStates(aggregateChain), handlingChain,
                handledFailureTypeIds, optimize);
        removeDuplicateFailureStates(aggregateChain, optimize);
    }

    /**
     * Incorporates multiple Markov Chains into one aggregate chain. The specific Markov Chains are
     * inserted into the aggregate Markov Chain replacing the failure states.
     * 
     * @param aggregateChain
     *            the Markov Chain which will incorporate the other chains
     * @param handlingChains
     *            the Markov Chains which will be incorporated into the other chain
     * @param handledFailureTypeIdLists
     *            the list of handled failure types per chain
     * @param optimize
     *            indicates if Markov Chain reduction shall be performed during the transformation
     */
    public void appendFailureHandlingMarkovChains(final MarkovChain aggregateChain,
            final List<MarkovChain> handlingChains, final List<List<String>> handledFailureTypeIdLists,
            final boolean optimize) {
        List<State> aggregateFailureStates = getFailureStates(aggregateChain);
        for (int i = 0; i < handlingChains.size(); i++) {
            aggregateFailureStates = findStates(aggregateFailureStates, StateType.FAILURE);
            appendFailureHandlingMarkovChain(aggregateChain, aggregateFailureStates, handlingChains.get(i),
                    handledFailureTypeIdLists.get(i), optimize);
        }
        removeDuplicateFailureStates(aggregateChain, optimize);
    }

    /**
     * Adds a new transition to a given Markov chain.
     * 
     * @param chain
     *            the Markov chain
     * @param from
     *            the source state
     * @param to
     *            the target state
     * @param probability
     *            the probability to annotate the new transition
     */
    private void connectStates(final MarkovChain chain, final State from, final State to, final double probability) {
        Transition transition = markovFactory.createTransition();
        transition.setFromState(from);
        transition.setToState(to);
        transition.setProbability(probability);
        nameTransition(transition);
        chain.getTransitions().add(transition);
    }

    /**
     * Adds the given Transition to the given Markov Chain. If the given Markov Chain already has a
     * Transition between the same source and target States, the already existing Transition is
     * merged with the new one by summing up the probabilities of the two Transitions.
     * 
     * @param markovChain
     *            the Markov Chain
     * @param transitionToContribute
     *            the Transition
     */
    private void contributeTransition(final MarkovChain markovChain, final Transition transitionToContribute) {

        // Go through the Transitions of the Markov Chain to find an already
        // existing Transition that corresponds to the new one:
        Transition transitionCorresponding = null;
        for (int i = 0; i < markovChain.getTransitions().size(); i++) {
            if ((markovChain.getTransitions().get(i).getFromState() == transitionToContribute.getFromState())
                    && (markovChain.getTransitions().get(i).getToState() == transitionToContribute.getToState())) {
                transitionCorresponding = markovChain.getTransitions().get(i);
                break;
            }
        }

        // Does a corresponding Transition already exist?
        if (transitionCorresponding != null) {

            // Add the probability of the new Transition to that of the already
            // existing one:
            transitionCorresponding.setProbability(transitionCorresponding.getProbability()
                    + transitionToContribute.getProbability());
        } else {

            // Simply add the new Transition to the Markov Chain:
            markovChain.getTransitions().add(transitionToContribute);
        }
    }

    /**
     * Creates a copy of a Markov Chain. All States and Transitions of the original Markov Chain are
     * copied into the new one.
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

            State originalState = originalMarkovChain.getStates().get(i);
            // Create a new Markov State:
            State newState = markovFactory.createState();
            newState.setName(originalState.getName());
            newState.setType(originalState.getType());

            for (Label originalLabel : originalState.getLabels()) {
                Label newLabel = markovFactory.createLabel();
                newLabel.setKey(originalLabel.getKey());
                newLabel.setValue(originalLabel.getValue());
                newState.getLabels().add(newLabel);
            }

            // Add Traces information:
            newState.getTraces().addAll(originalState.getTraces());

            // Add the new State to the new Markov Chain:
            newMarkovChain.getStates().add(newState);
        }

        // Copy all Transitions from the originial Markov Chain into the new
        // one:
        for (int i = 0; i < originalMarkovChain.getTransitions().size(); i++) {

            // Create a new Transition:
            Transition newTransition = markovFactory.createTransition();
            newTransition.setName(originalMarkovChain.getTransitions().get(i).getName());
            newTransition.setProbability(originalMarkovChain.getTransitions().get(i).getProbability());

            // Determine the source and target States of the new Transition:
            State fromState = newMarkovChain.getStates()
                    .get(originalMarkovChain.getStates().indexOf(
                            originalMarkovChain.getTransitions().get(i).getFromState()));
            State toState = newMarkovChain.getStates().get(
                    originalMarkovChain.getStates().indexOf(originalMarkovChain.getTransitions().get(i).getToState()));
            newTransition.setFromState(fromState);
            newTransition.setToState(toState);

            // Add the new Transition to the new Markov Chain:
            newMarkovChain.getTransitions().add(newTransition);
        }

        // Return the resulting Markov Chain:
        return newMarkovChain;
    }

    /**
     * Delegates incoming transitions from an original state to a new state.
     * 
     * @param chain
     *            the Markov chain
     * @param originalState
     *            the original state
     * @param newState
     *            the new state
     */
    private void delegateIncommingTransitions(final MarkovChain chain, final State originalState, final State newState) {
        ArrayList<Transition> transitions = findTransitionsToState(chain, originalState);
        for (Transition transition : transitions) {
            transition.setToState(newState);
        }
    }

    /**
     * Delegates outgoing transitions from an original state to a new state.
     * 
     * @param chain
     *            the Markov chain
     * @param originalState
     *            the original state
     * @param newState
     *            the new state
     */
    private void delegateOutgoingTransitions(final MarkovChain chain, final State originalState, final State newState) {
        ArrayList<Transition> transitions = findTransitionsFromState(chain, originalState);
        for (Transition transition : transitions) {
            transition.setFromState(newState);
        }
    }

    /**
     * Deletes all Transitions from the given Markov Model which are part of the given transitions
     * list.
     * 
     * @param markovChain
     *            the Markov Chain
     * @param transitionsToDelete
     *            the transition list
     */
    private void deleteTransitions(final MarkovChain markovChain, final ArrayList<Transition> transitionsToDelete) {

        // Go through all transitions of the given list:
        for (int i = 0; i < transitionsToDelete.size(); i++) {

            // Remove this transition from the Markov Chain:
            markovChain.getTransitions().remove(transitionsToDelete.get(i));
        }
    }

    /**
     * Finds a failure state out of a given list of states.
     * 
     * @param states
     *            the list of states
     * @param failureTypeLabelValue
     *            the type of failure state to find
     * @return the failure state; NULL if no corresponding failure state could be found
     */
    private State findFailureState(final List<State> states, final String failureTypeLabelValue) {
        for (State state : states) {
            if (!state.getType().equals(StateType.FAILURE)) {
                continue;
            }
            for (Label label : state.getLabels()) {
                // TODO: this is linear search inside an outer loop! improve
                // performance
                if ((label.getKey().equals(FAILURETYPEID)) && (label.getValue().equals(failureTypeLabelValue))) {
                    return state;
                }
            }
        }
        return null;
    }

    /**
     * Finds the failure states out of a given list of states.
     * 
     * @param states
     *            the list of states
     * @param failureTypeLabelValue
     *            the type of failure state to find
     * @return the failure states; NULL if no corresponding failure state could be found
     */
    private List<State> findFailureStates(final List<State> states, final String failureTypeLabelValue) {
        List<State> resultList = new ArrayList<State>();
        for (State state : states) {
            if (!state.getType().equals(StateType.FAILURE)) {
                continue;
            }
            for (Label label : state.getLabels()) {
                // TODO: this is linear search inside an outer loop! improve
                // performance
                if ((label.getKey().equals(FAILURETYPEID)) && (label.getValue().equals(failureTypeLabelValue))) {
                    resultList.add(state);
                }
            }
        }
        return resultList;
    }

    /**
     * Finds a failure state out of a given list of states.
     * 
     * @param states
     *            the list of states
     * @param failureState
     *            the failure state to match
     * @return the failure state; NULL if no corresponding failure state could be found
     */
    private State findMatchingFailureState(final List<State> states, final State failureState) {
        String failureTypeLabelValue = getFailureTypeId(failureState);
        return findFailureState(states, failureTypeLabelValue);
    }

    /**
     * Finds the failure states out of a given list of states.
     * 
     * @param states
     *            the list of states
     * @param failureState
     *            the failure state to match
     * @return the failure states
     */
    private List<State> findMatchingFailureStates(final List<State> states, final State failureState) {
        String failureTypeLabelValue = getFailureTypeId(failureState);
        return findFailureStates(states, failureTypeLabelValue);
    }

    /**
     * Retrieves all Markov states of a given type from a given state list.
     * 
     * @param states
     *            the list of states to search through
     * @param type
     *            the requested state type
     * @return the sub list if states of the requested type
     */
    private List<State> findStates(final List<State> states, final StateType type) {
        List<State> resultList = new ArrayList<State>();
        for (State state : states) {
            if (state.getType().equals(type)) {
                resultList.add(state);
            }
        }
        return resultList;
    }

    /**
     * Creates a list of all Transitions in a Markov Chain that start from a given source state.
     * 
     * @param markovChain
     *            the Markov Chain
     * @param sourceState
     *            the source state
     * @return the list of transitions
     */
    private ArrayList<Transition> findTransitionsFromState(final MarkovChain markovChain, final State sourceState) {

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
     * Creates a list of all Transitions in a Markov Chain that lead to a given target state.
     * 
     * @param markovChain
     *            the Markov Chain
     * @param targetState
     *            the target state
     * @return the list of transitions
     */
    private ArrayList<Transition> findTransitionsToState(final MarkovChain markovChain, final State targetState) {

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
     * Gets all failure states out of a given Markov chain.
     * 
     * @param markovChain
     *            the Markov chain
     * @return the list of failure states
     */
    public List<State> getFailureStates(final MarkovChain markovChain) {

        // Initialize the resulting list:
        List<State> failureStates = new ArrayList<State>();

        // Go through all states of the Markov Chain:
        for (int i = 0; i < markovChain.getStates().size(); i++) {
            if (markovChain.getStates().get(i).getType().equals(StateType.FAILURE)) {
                failureStates.add(markovChain.getStates().get(i));
            }
        }

        // Return the result:
        return failureStates;
    }

    /**
     * Gets the failure type annotation of a Markov failure state.
     * 
     * @param state
     *            the state to examine
     * @return the failure type annotation of the state
     */
    public String getFailureTypeId(final State state) {
        for (Label label : state.getLabels()) {
            if (label.getKey().equals(FAILURETYPEID)) {
                return label.getValue();
            }
        }
        return null;
    }

    /**
     * Gets the failure type annotation of a Markov failure state.
     * 
     * @param state
     *            the state to examine
     * @return the failure type annotation of the state
     */
    public String getFailureTypeName(final State state) {
        for (Label label : state.getLabels()) {
            if (label.getKey().equals(FAILURETYPENAME)) {
                return label.getValue();
            }
        }
        return null;
    }

    /**
     * Retrieves a name from a given list of prefixes.
     * 
     * @param prefixes
     *            the list of prefixes
     * @return the resulting name
     */
    private String getName(final List<String> prefixes) {
        String result = "";
        for (int i = 0; i < prefixes.size(); i++) {
            result += prefixes.get(i);
            if (i < prefixes.size() - 1) {
                result += "::";
            }
        }
        return result;
    }

    /**
     * Gets the start state out of a given Markov chain.
     * 
     * @param markovChain
     *            the Markov chain
     * @return the start state
     */
    public State getStartState(final MarkovChain markovChain) {

        // Go through all states of the Markov Chain:
        for (int i = 0; i < markovChain.getStates().size(); i++) {
            if (markovChain.getStates().get(i).getType().equals(StateType.START)) {
                return markovChain.getStates().get(i);
            }
        }

        // No start state found:
        throw new MarkovException("Markov Chain has no start state.");
    }

    /**
     * Determines the composed name of a Markov state.
     * 
     * @param stateName
     *            the state name
     * @param prefixes
     *            the prefixes of the state name
     * @return the composed name
     */
    private String getStateName(final String stateName, final List<String> prefixes) {
        if (prefixes.isEmpty()) {
            return stateName;
        } else {
            return prefixes.get(prefixes.size() - 1) + "::" + stateName;
        }
    }

    /**
     * Determines the traces of a Markov state.
     * 
     * @param stateName
     *            the state name
     * @param prefixes
     *            the prefixes of the state name
     * @return the trace list of the state
     */
    private List<String> getStateTraces(final String stateName, final List<String> prefixes) {
        ArrayList<String> resultList = new ArrayList<String>();
        if (recordTraces) {
            resultList.addAll(prefixes);
            resultList.add(stateName);
        }
        return resultList;
    }

    /**
     * Gets the success state out of a given Markov chain.
     * 
     * @param markovChain
     *            the Markov Chain
     * @return the Success State
     */
    public State getSuccessState(final MarkovChain markovChain) {

        // Go through all states of the Markov Chain:
        for (int i = 0; i < markovChain.getStates().size(); i++) {
            if (markovChain.getStates().get(i).getType().equals(StateType.SUCCESS)) {
                return markovChain.getStates().get(i);
            }
        }

        // No success state found:
        throw new MarkovException("Markov Chain has no success state.");
    }

    /**
     * Incorporates one Markov Chain into another. The specific Markov Chain is inserted into the
     * aggregate Markov Chain replacing the given aggregate Markov State.
     * 
     * @param parentChain
     *            the Markov Chain which will incorporate the other chain
     * @param specificMarkovChain
     *            the Markov Chain which will be incorporated into the other chain
     * @param aggregateState
     *            the Markov State in the aggregate Markov Chain which will be replaced by the
     *            specific Markov Chain
     * @param optimize
     *            indicates if Markov Chain reduction shall be performed during the transformation
     * @param appendPrefixes
     *            indicates if prefixes of specific chain shall be appended to prefixes of
     *            aggregateChain
     */
    public void incorporateMarkovChain(final MarkovChain parentChain, final MarkovChain specificMarkovChain,
            final State aggregateState, final boolean optimize, final boolean appendPrefixes) {

        // Assure that the replaceable Markov State is contained in the
        // aggregate Markov Chain:
        if (!parentChain.getStates().contains(aggregateState)) {
            throw new MarkovException("State '" + aggregateState + "' is not contained in the markov chain '"
                    + parentChain.getName() + "'.");
        }

        // Assure that the replaceable Markov State is not a Start, Success or
        // Failure State:
        if (!aggregateState.getType().equals(StateType.DEFAULT)) {
            throw new MarkovException("Only default states can be incorporated. '" + aggregateState.getName()
                    + "' is of type '" + aggregateState.getType() + "'.");
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

        // Augment specific Makov traces with the aggregate state trace:
        if (recordTraces && appendPrefixes) {
            for (State specificState : copiedSpecificMarkovChain.getStates()) {
                specificState.getTraces().addAll(0, aggregateState.getTraces());
                specificState.setName(getStateName(specificState.getTraces().get(specificState.getTraces().size() - 1),
                        specificState.getTraces().subList(0, specificState.getTraces().size() - 1)));
            }
        }

        // Take over the specific Markov Chain into the aggregate Markov Chain:
        parentChain.getStates().addAll(copiedSpecificMarkovChain.getStates());
        parentChain.getTransitions().addAll(copiedSpecificMarkovChain.getTransitions());

        // all transitions to the replaceable state are delegated to the inner
        // start state
        delegateIncommingTransitions(parentChain, aggregateState, stateSpecificStart);
        stateSpecificStart.setType(StateType.DEFAULT);

        // absorb failure states. for already existing failure type states
        // delegate transitions
        // from inner duplicates.
        List<State> duplicateFailureStates = new ArrayList<State>();
        for (State failureState : stateSpecificFailures) {
            // check if this is a duplicate
            State existingFailureState = findMatchingFailureState(stateAggregateFailures, failureState);
            if (existingFailureState != null) { // duplicate found
                // delegate from duplicate to existing state
                connectStates(parentChain, failureState, existingFailureState, 1.0);
                // remove duplicate
                failureState.setType(StateType.DEFAULT);
                duplicateFailureStates.add(failureState);
            }
        }

        //
        delegateOutgoingTransitions(parentChain, aggregateState, stateSpecificSuccess);
        stateSpecificSuccess.setType(StateType.DEFAULT);

        // remove the
        parentChain.getStates().remove(aggregateState);

        // Optimize the aggregate MarkovChain:
        if (optimize) {
            reduceState(parentChain, stateSpecificStart);
            reduceState(parentChain, stateSpecificSuccess);
            for (State failureState : duplicateFailureStates) {
                reduceState(parentChain, failureState);
            }
        }
    }

    /**
     * Retrieves the index of a given State within a given Markov Chain.
     * 
     * @param markovChain
     *            the Markov Chain
     * @param state
     *            the state to find
     * @return the required index
     */
    public int indexOf(final MarkovChain markovChain, final State state) {

        // Go through all states of the Markov Chain:
        for (int i = 0; i < markovChain.getStates().size(); i++) {
            if (markovChain.getStates().get(i) == state) {
                return i;
            }
        }

        // Nothing found?
        throw new MarkovException("State not found in Markov chain.");
    }

    /**
     * Initializes a new Markov Chain. The new Markov Chain has only three states: a start state, a
     * success state and a failure state. A single transition goes from start to success with
     * probability 1.
     * 
     * @param prefixes
     *            the prefixes of the chain name
     * @return the new Markov Chain
     */
    public MarkovChain initBasicMarkovChain(final List<String> prefixes) {

        // Create the Markov Chain Entity:
        MarkovChain markovChain = markovFactory.createMarkovChain();
        markovChain.setName(getName(prefixes));

        // Create the Start and Success States:
        State startState = addState(markovChain, StateType.START, StateType.START.toString(), prefixes);
        State successSate = addState(markovChain, StateType.SUCCESS, StateType.SUCCESS.toString(), prefixes);
        connectStates(markovChain, startState, successSate, 1.0);

        // Return the result:
        return markovChain;
    }

    /**
     * Creates a basic Markov chain with a start, success and multiple failure nodes for a given
     * list of failure descriptions. Such a chain can be used to represent an internal action with
     * its application failure probabilities, or the sending of a message over a communication link.
     * All failure probabilities must sum up to at most 1.0.
     * 
     * @param prefixes
     *            the prefixes of the chain name
     * @param failureDescriptions
     *            a list of failure descriptions
     * @return the resulting Markov Chain
     */
    public MarkovChain initBasicMarkovChainWithFailures(final List<String> prefixes,
            final List<FailureDescription> failureDescriptions) {

        // Create the Markov Chain Entity:
        MarkovChain markovChain = markovFactory.createMarkovChain();
        markovChain.setName(getName(prefixes));

        // Create the Start and Success States:
        State startState = addState(markovChain, StateType.START, StateType.START.toString(), prefixes);
        State successState = addState(markovChain, StateType.SUCCESS, StateType.SUCCESS.toString(), prefixes);

        // Start with the assumption of total reliability:
        double successProbability = 1.0;

        // Create failure states and connecting transitions:
        for (FailureDescription description : failureDescriptions) {
            State failureState = addStateForFailureDescription(markovChain, prefixes, description);
            connectStates(markovChain, startState, failureState, description.getFailureProbability());
            successProbability -= description.getFailureProbability();
        }

        // Assure that the reliability has not decreased below zero:
        if (successProbability < 0) {
            throw new MarkovException("Total failure probability of basic Chain \"" + getName(prefixes)
                    + "\" is greater than 1.0.");
        }

        // Create the Transition from Start State to Success State:
        connectStates(markovChain, startState, successState, successProbability);

        // Return the result:
        return markovChain;
    }

    /**
     * Creates a Markov Chain that represents an execution of a ScenarioBehaviour or
     * ResourceDemandingBehaviour.
     * 
     * @param prefixes
     *            the prefixes of the Markov Chain name
     * @param actions
     *            the actions of the Behaviour
     * @param statesOut
     *            the list of states created within the method that corresponds to the given list of
     *            actions
     * @return the resulting Markov Chain
     */
    public MarkovChain initBehaviourMarkovChainByAction(final List<String> prefixes,
            final List<AbstractAction> actions, final List<State> statesOut) {

        // Collect the action names:
        ArrayList<String> actionNames = new ArrayList<String>();
        for (int i = 0; i < actions.size(); i++) {
            actionNames.add(actions.get(i).getEntityName() + "[" + actions.get(i).getId() + "]");
        }

        // Build the Markov Chain:
        return initSequentialMarkovChain(prefixes, actionNames, statesOut);
    }

    /**
     * Creates a Markov Chain for a branch with solved branch probabilities.
     * 
     * @param prefixes
     *            the prefixes of the branch name
     * @param branchProbabilities
     *            the branch probabilities
     * @return the resulting Markov Chain
     */
    public MarkovChain initBranchMarkovChain(final List<String> prefixes, final ArrayList<Double> branchProbabilities) {

        // Create the Markov Chain Entity:
        MarkovChain markovChain = markovFactory.createMarkovChain();
        markovChain.setName(getName(prefixes));

        // Create the Start and Success States:
        State startState = addState(markovChain, StateType.START, StateType.START.toString(), prefixes);
        State successState = addState(markovChain, StateType.SUCCESS, StateType.SUCCESS.toString(), prefixes);

        // Go through the given branch probabilities:
        for (int i = 0; i < branchProbabilities.size(); i++) {

            // Check for a positive branch probability:
            if (branchProbabilities.get(i) <= 0.0) {
                continue;
            }

            // Create a new State:
            State stateBranch = addState(markovChain, StateType.DEFAULT, "Alternative(" + (i + 1) + ")", prefixes);

            // Create a transition from the Start State to the new one:
            connectStates(markovChain, startState, stateBranch, branchProbabilities.get(i));

            // Create a transition from new state to the success state
            connectStates(markovChain, stateBranch, successState, 1.0);
        }

        // Return the result:
        return markovChain;
    }

    /**
     * Creates a Markov Chain for a fork action with a list of forked behaviours.
     * 
     * @param prefixes
     *            the prefixes of the fork name
     * @param behaviours
     *            the list of forked behaviours
     * @param statesOut
     *            the list of states created within the method
     * @return the resulting Markov chain
     */
    public MarkovChain initForkMarkovChain(List<String> prefixes, ArrayList<ForkedBehaviour> behaviours,
            ArrayList<State> statesOut) {

        // Collect the action names:
        ArrayList<String> behaviourNames = new ArrayList<String>();
        for (int i = 0; i < behaviours.size(); i++) {
            behaviourNames.add("ForkBehaviour(" + (i + 1) + ")");
        }

        // Build the Markov Chain:
        return initSequentialMarkovChain(prefixes, behaviourNames, statesOut);
    }

    /**
     * Creates a Markov Chain for a loop with solved probability mass function.
     * 
     * @param prefixes
     *            the prefixes of the loop name
     * @param pmf
     *            the probability mass function of the loop
     * @return the resulting Markov Chain
     */
    public MarkovChain initLoopMarkovChain(final List<String> prefixes, final ManagedPMF pmf) {

        // Create the Markov Chain Entity:
        MarkovChain markovChain = markovFactory.createMarkovChain();
        markovChain.setName(getName(prefixes));

        // Create the Start and Success States:
        State startState = addState(markovChain, StateType.START, StateType.START.toString(), prefixes);
        State successState = addState(markovChain, StateType.SUCCESS, StateType.SUCCESS.toString(), prefixes);

        // Go through the samples of the probability mass function:
        for (int i = 0; i < pmf.getModelPmf().getSamples().size(); i++) {
            Sample sample = pmf.getModelPmf().getSamples().get(i);
            if (!(sample.getValue() instanceof Integer)) {
                throw new MarkovException("Invalid Sample value " + sample.getValue().toString() + " in "
                        + pmf.getModelPmf().toString());
            }

            int sampleValue = (Integer) sample.getValue();

            // Mark the State that will lead to the Success State:
            State stateToSuccess = startState;
            double transitionProbability = sample.getProbability();

            // Go through the iterations of this sample:
            for (int j = 0; j < sampleValue; j++) {

                // Create a new State:
                State stateSample = addState(markovChain, StateType.DEFAULT, "Alternative(" + (i + 1) + ")-Iteration("
                        + (j + 1) + ")", prefixes);
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
     * Creates a Markov chain for an internal action failing with probability 1.0 because of
     * unavailable hardware resources. The failure probability is divided between all unavailable
     * resources.
     * 
     * @param prefixes
     *            the prefixes of the chain name
     * @param failureDescriptions
     *            a list of failure descriptions for hardware resources
     * @return the resulting Markov Chain
     */
    public MarkovChain initResourceFailureMarkovChain(final List<String> prefixes,
            final List<FailureDescription> failureDescriptions) {

        // Create the Markov Chain Entity:
        MarkovChain markovChain = markovFactory.createMarkovChain();
        markovChain.setName(getName(prefixes));

        // Create the Start states:
        State startState = addState(markovChain, StateType.START, StateType.START.toString(), prefixes);
        addState(markovChain, StateType.SUCCESS, StateType.SUCCESS.toString(), prefixes);

        // Determine the failure probability for all unavailable resources:
        double failureProbability = 1.0 / failureDescriptions.size();

        // Create failure states and connecting transitions:
        for (FailureDescription description : failureDescriptions) {
            State failureState = addStateForFailureDescription(markovChain, prefixes, description);
            connectStates(markovChain, startState, failureState, failureProbability);
        }

        // Return the result:
        return markovChain;
    }

    /**
     * Creates a Markov Chain that represents a sequential execution path.
     * 
     * @param prefixes
     *            the prefixes of the Markov Chain name
     * @param stateNames
     *            the names of the states to create
     * @param statesOut
     *            the list of states created within the method that corresponds to the given list of
     *            state names
     * @return the resulting Markov Chain
     */
    public MarkovChain initSequentialMarkovChain(final List<String> prefixes, final List<String> stateNames,
            final List<State> statesOut) {

        // Create the Markov Chain Entity:
        MarkovChain markovChain = markovFactory.createMarkovChain();
        markovChain.setName(getName(prefixes));

        // Create the Start and Success States:
        State startState = addState(markovChain, StateType.START, StateType.START.toString(), prefixes);
        State successState = addState(markovChain, StateType.SUCCESS, StateType.SUCCESS.toString(), prefixes);

        // Mark the State that will later lead directly to the Success State:
        State stateToSuccess = startState;

        // Go through the chain of state names:
        for (int i = 0; i < stateNames.size(); i++) {

            // Create a Markov State for this Action:
            State state = addState(markovChain, StateType.DEFAULT, stateNames.get(i), prefixes);
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
     * Checks if a failure-on-demand occurrence is contained in a given list of handled failure
     * types.
     * 
     * @param handledFailureTypeIds
     *            the list of handled failure types
     * @param occurredFailureTypeId
     *            the occurred failure type
     * @return true if the occurred failure type is included in the list of handled types
     */
    private boolean isFailureTypeHandled(final List<String> handledFailureTypeIds, final String occurredFailureTypeId) {
        for (String handledId : handledFailureTypeIds) {
            if (occurredFailureTypeId.contains(handledId)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Names a Transition.
     * 
     * @param transition
     *            the transition to name
     */
    private void nameTransition(final Transition transition) {
        transition.setName(transition.getFromState().getName() + " --> " + transition.getToState().getName());
    }

    /**
     * Reduces the given Markov State in the given Markov Chain. The State is deleted and all
     * transitions leading to or starting from the State are re-calculated so that the failure and
     * success probabilities of the overall Markov Chain are preserved.
     * 
     * @param markovChain
     *            the Markov Chain
     * @param stateToReduce
     *            the state which will be reduced
     */
    private void reduceState(final MarkovChain markovChain, final State stateToReduce) {

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
        ArrayList<Transition> transitionsToReduceState = findTransitionsToState(markovChain, stateToReduce);
        deleteTransitions(markovChain, transitionsToReduceState);

        // Find and delete all transitions in the Markov Chain that start from
        // the reduceable State:
        ArrayList<Transition> transitionsFromReduceState = findTransitionsFromState(markovChain, stateToReduce);
        deleteTransitions(markovChain, transitionsFromReduceState);

        // Delete the reduceable State:
        markovChain.getStates().remove(stateToReduce);

        // Build new transitions to replace the deleted ones:
        for (int i = 0; i < transitionsToReduceState.size(); i++) {
            for (int j = 0; j < transitionsFromReduceState.size(); j++) {

                // Create a new transition:
                Transition transition = markovFactory.createTransition();

                // Set the source and target States:
                transition.setFromState(transitionsToReduceState.get(i).getFromState());
                transition.setToState(transitionsFromReduceState.get(j).getToState());

                // Calculate the transition probability:
                transition.setProbability(transitionsToReduceState.get(i).getProbability()
                        * transitionsFromReduceState.get(j).getProbability());

                // Set the name of the transition:
                nameTransition(transition);

                // Add the new Transition to the Markov Chain:
                contributeTransition(markovChain, transition);
            }
        }
    }

    /**
     * Removes duplicate failure states from the given Markov chain.
     * 
     * @param aggregateChain
     *            the chain to reduce
     * @param optimize
     *            indicates if Markov Chain reduction shall be performed during the transformation
     */
    private void removeDuplicateFailureStates(final MarkovChain markovChain, final boolean optimize) {

        // Iterate over the failure states of the chain:
        List<State> failureStates = getFailureStates(markovChain);
        List<State> duplicateFailureStates = new ArrayList<State>();
        for (State failureState : failureStates) {
            if (duplicateFailureStates.contains(failureState)) {
                continue;
            }
            List<State> matchingFailureStates = findMatchingFailureStates(failureStates, failureState);
            matchingFailureStates.remove(failureState);
            for (State matchingState : matchingFailureStates) {
                connectStates(markovChain, matchingState, failureState, 1.0);
                matchingState.setType(StateType.DEFAULT);
                duplicateFailureStates.add(matchingState);
            }
        }

        // Optimize the aggregate MarkovChain:
        if (optimize) {
            for (State duplicateState : duplicateFailureStates) {
                reduceState(markovChain, duplicateState);
            }
        }
    }

    /**
     * Checks if a Markov chain is valid. The chain is judged to be valid if each transition has a
     * source state and a target state, and if exactly one start and success state exist. If a chain
     * is not valid, a Markov exception is thrown.
     * 
     * @param chain
     *            the Markov chain to check
     */
    private void validateChain(final MarkovChain chain) {

        // Check if each transition has a source and a target node:
        for (Transition t : chain.getTransitions()) {
            if ((t.getFromState() == null) || (t.getToState() == null)) {
                throw new MarkovException("Invalid transiton in Markov Chain.");
            }
        }

        // Check if exactly one start and one success state are present:
        boolean hasStart = false;
        boolean hasSuccess = false;
        for (State s : chain.getStates()) {
            if (s.getType() == StateType.START) {
                if (hasStart) {
                    throw new MarkovException("Multiple start states in Markov Chain.");
                } else {
                    hasStart = true;
                }
            } else if (s.getType() == StateType.SUCCESS) {
                if (hasSuccess) {
                    throw new MarkovException("Multiple success states in Markov Chain.");
                } else {
                    hasSuccess = true;
                }
            }
        }

        if (!hasStart) {
            throw new MarkovException("No start state in Markov Chain.");
        }

        if (!hasSuccess) {
            throw new MarkovException("No success state in Markov Chain.");
        }

        // TODO: Check for transitions leading to dead ends
        // TODO: Check for cycles
    }
}
