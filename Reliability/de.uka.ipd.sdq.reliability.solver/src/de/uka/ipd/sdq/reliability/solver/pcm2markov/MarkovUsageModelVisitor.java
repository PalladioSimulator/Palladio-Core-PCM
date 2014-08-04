package de.uka.ipd.sdq.reliability.solver.pcm2markov;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.markov.MarkovChain;
import de.uka.ipd.sdq.markov.State;
import de.uka.ipd.sdq.markov.StateType;
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
import de.uka.ipd.sdq.pcmsolver.transformations.ContextWrapper;
import de.uka.ipd.sdq.pcmsolver.visitors.EMFQueryHelper;
import de.uka.ipd.sdq.probfunction.math.ManagedPMF;
import de.uka.ipd.sdq.reliability.core.MarkovEvaluationType;

/**
 * This class represents a visitor for a UsageModel within a PCM instance. The visitor is used in
 * the transformation from PCM with solved dependencies into a Markov Chain Model for reliability
 * prediction.
 * 
 * @author brosch
 * 
 */
public class MarkovUsageModelVisitor extends UsagemodelSwitch<MarkovChain> {

    /**
     * A logger to give detailed information about the PCM instance traversal.
     */
    private static final Logger LOGGER = Logger.getLogger(MarkovUsageModelVisitor.class.getName());

    /**
     * The ContextWrapper provides easy access to the decorations of the solved PCM instance.
     */
    private ContextWrapper contextWrapper = null;

    /**
     * The degree of distinction between failure types.
     */
    private final MarkovEvaluationType evaluationType;

    /**
     * The Markov Builder is used to create Markov Chain instances.
     */
    private final MarkovBuilder markovBuilder;

    /**
     * Indicates if the Markov Chain reduction is performed during the transformation. If so, then
     * the chain as a whole never exists, because during construction, it is already reduced again.
     */
    private final boolean optimize;

    /**
     * The prefix list enables unique naming of all Markov states, which in turn allows to search
     * for differences between two chains.
     */
    private final List<String> prefixes;

    /**
     * Indicates if the resulting Makov model shall be augmented with tracing information for
     * diagnostic purposes.
     */
    private final boolean recordTraces;

    /**
     * Indicates if resource states are handled according to the simpler "always ask" strategy,
     * which may yield less accurate results, but avoids iterating over all possible state
     * combinations.
     */
    private final boolean simplifiedStateHandling;

    /**
     * The solved PCM instance that serves as an input for the transformation.
     */
    private final MarkovTransformationSource transformationState;

    /**
     * The constructor.
     * 
     * @param transformationState
     *            the Markov transformation state
     * @param evaluationType
     *            the degree of differentiation between failure types
     * @param simplifiedStateHandling
     *            controls the handling of physical resource states
     * @param optimize
     *            controls if Markov Chain reduction shall be performed during transformation
     * @param recordTraces
     *            controls if traces shall be recorded during transformation
     */
    public MarkovUsageModelVisitor(final MarkovTransformationSource transformationState,
            final MarkovEvaluationType evaluationType, final boolean simplifiedStateHandling, final boolean optimize,
            final boolean recordTraces) {
        this.evaluationType = evaluationType;
        this.transformationState = transformationState;
        this.simplifiedStateHandling = simplifiedStateHandling;
        this.optimize = optimize;
        this.recordTraces = recordTraces;
        this.prefixes = new ArrayList<String>();
        this.markovBuilder = new MarkovBuilder(recordTraces);
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

        // Logging & naming:
        String name = branch.getEntityName() + "[" + branch.getId() + "]";
        prefixes.add(name);
        LOGGER.debug("Visit Branch: " + name);

        // Determine the branch probabilities and the inner Markov chains
        // associated with the branch behaviors:
        ArrayList<MarkovChain> specificMarkovChains = new ArrayList<MarkovChain>();
        ArrayList<Double> branchProbabilities = new ArrayList<Double>();
        EList<BranchTransition> transitions = branch.getBranchTransitions_Branch();
        for (int i = 0; i < transitions.size(); i++) {
            if (transitions.get(i).getBranchProbability() <= 0.0) {
                continue;
            }
            branchProbabilities.add(transitions.get(i).getBranchProbability());
            specificMarkovChains.add(doSwitch(transitions.get(i).getBranchedBehaviour_BranchTransition()));
        }

        // Initialize the aggregate Markov chain representing the branch:
        MarkovChain aggregateMarkovChain = markovBuilder.initBranchMarkovChain(prefixes, branchProbabilities);

        // Incorporate the specific Markov chains into the aggregate one:
        ArrayList<State> statesToReplace = new ArrayList<State>();
        for (int i = 0; i < aggregateMarkovChain.getStates().size(); i++) {
            if (aggregateMarkovChain.getStates().get(i).getType().equals(StateType.DEFAULT)) {
                statesToReplace.add(aggregateMarkovChain.getStates().get(i));
            }
        }
        for (int i = 0; i < statesToReplace.size(); i++) {
            markovBuilder.incorporateMarkovChain(aggregateMarkovChain, specificMarkovChains.get(i),
                    statesToReplace.get(i), optimize, false);
        }

        // Naming:
        prefixes.remove(prefixes.size() - 1);

        // Return the result:
        return aggregateMarkovChain;
    }

    /**
     * Returns a Markov Chain correponding to this Delay.
     * 
     * @param delay
     *            the delay action
     * @return the resulting Markov Chain
     */
    @Override
    public MarkovChain caseDelay(final Delay delay) {

        // Do the logging:
        String name = delay.getEntityName() + "[" + delay.getId() + "]";
        prefixes.add(name);
        LOGGER.debug("Visit Delay: " + name);

        // Create a Markov chain for the Delay action:
        MarkovChain resultChain = markovBuilder.initBasicMarkovChain(prefixes);

        // Naming:
        prefixes.remove(prefixes.size() - 1);

        // Return the result:
        return resultChain;
    }

    /**
     * 
     * Returns a Markov Chain that corresponds to this EntryLevelSystemCall.
     * 
     * @param call
     *            the call
     * @return the resulting Markov Chain
     */
    @Override
    public MarkovChain caseEntryLevelSystemCall(final EntryLevelSystemCall call) {

        // Logging & naming:
        String name = call.getEntityName() + "[" + call.getId() + "]";
        prefixes.add(name);
        LOGGER.debug("Visit EntryLevelSystemCall: " + name);

        // Get List of ContextWrappers, one for each called component instance
        List<ContextWrapper> contextWrapperList;
        // Create a new context wrapper for this entry level system call:
        if (contextWrapper == null) {
            contextWrapperList = ContextWrapper.getContextWrapperFor(call, transformationState.getModel());
        } else {
            contextWrapperList = contextWrapper.getContextWrapperFor(call);
        }

        // FIXME: The Reliability solver does not support replication yet
        if (contextWrapperList.size() > 1) {
            LOGGER.error("The Reliability solver only supports one AllocationContext per AssemblyContext. Picking one of the called Allocation contexts for call "
                    + call.getEntityName() + " " + call.getId() + " ignoring the others. Results will be inaccurate.");
        } else if (contextWrapperList.size() == 0) {
            throw new RuntimeException("Internal Error: Could not create a Context Wrapper for call "
                    + call.getEntityName() + " " + call.getId());
        }
        contextWrapper = contextWrapperList.get(0);

        // We need to get from the entryLevelSystemCall to the RDSEFF that
        // fulfills the call:
        ServiceEffectSpecification seff = contextWrapper.getNextSEFF(call);
        MarkovChain resultChain = null;
        if (seff != null) {
            MarkovSeffVisitor seffVisitor = new MarkovSeffVisitor(transformationState, contextWrapper, prefixes,
                    evaluationType, simplifiedStateHandling, optimize, recordTraces);
            resultChain = seffVisitor.doSwitch(seff);
        }

        // Naming:
        prefixes.remove(prefixes.size() - 1);

        // Return the result:
        return resultChain;
    }

    /**
     * Returns a Markov Chain corresponding to this Loop.
     * 
     * @param loop
     *            the loop action
     * @return the resulting Markov Chain
     */
    @Override
    public MarkovChain caseLoop(final Loop loop) {

        // Logging & naming:
        String name = loop.getEntityName() + "[" + loop.getId() + "]";
        prefixes.add(name);
        LOGGER.debug("Visit Loop: " + name);

        // Get the solved loop probability mass function:
        String specification = loop.getLoopIteration_Loop().getSpecification();
        ManagedPMF pmf;
        try {
            pmf = ManagedPMF.createFromString(specification);
        } catch (Exception e) {
            LOGGER.error("Could not create a ManagedPMF from string \"" + specification + "\"");
            return null;
        }

        // Determine the inner Markov Chain associated with the loop behavior:
        ArrayList<String> prefixesCopy = new ArrayList<String>();
        prefixesCopy.addAll(prefixes);
        prefixes.clear();
        MarkovChain specificMarkovChain = doSwitch(loop.getBodyBehaviour_Loop());
        prefixes.addAll(prefixesCopy);

        // Initialize the aggregate Markov Chain representing the loop:
        MarkovChain aggregateMarkovChain = markovBuilder.initLoopMarkovChain(prefixes, pmf);

        // Incorporate the specific MarkovChain into the aggregate one:
        ArrayList<State> statesToReplace = new ArrayList<State>();
        for (int i = 0; i < aggregateMarkovChain.getStates().size(); i++) {
            if (aggregateMarkovChain.getStates().get(i).getType().equals(StateType.DEFAULT)) {
                statesToReplace.add(aggregateMarkovChain.getStates().get(i));
            }
        }
        for (int i = 0; i < statesToReplace.size(); i++) {
            markovBuilder.incorporateMarkovChain(aggregateMarkovChain, specificMarkovChain, statesToReplace.get(i),
                    optimize, true);
        }

        // Naming:
        prefixes.remove(prefixes.size() - 1);

        // Return the result:
        return aggregateMarkovChain;
    }

    /**
     * Returns a Markov Chain that corresponds to the first SystemLevelEntryCall within this
     * ScenarioBehaviour.
     * 
     * @param scenarioBehaviour
     *            the scenario behaviour
     * @return the resulting Markov Chain
     */
    @Override
    public MarkovChain caseScenarioBehaviour(final ScenarioBehaviour scenarioBehaviour) {

        // Logging & naming:
        String name = scenarioBehaviour.getEntityName() + "[" + scenarioBehaviour.getId() + "]";
        prefixes.add(name);
        LOGGER.debug("Visit Scenario Behaviour: " + name);

        // Go through the chain of actions that constitute this behavior. Each
        // action is expected to create its own specific Markov Chain:
        ArrayList<AbstractUserAction> actions = new ArrayList<AbstractUserAction>();
        ArrayList<String> actionNames = new ArrayList<String>();
        ArrayList<MarkovChain> chains = new ArrayList<MarkovChain>();
        AbstractUserAction action = (Start) EMFQueryHelper.getObjectByType(
                scenarioBehaviour.getActions_ScenarioBehaviour(), Start.class);
        while (action != null) {
            actions.add(action);
            actionNames.add(action.getEntityName() + "[" + action.getId() + "]");
            MarkovChain specificMarkovChain = doSwitch(action);
            chains.add(specificMarkovChain);
            action = action.getSuccessor();
        }

        // Initialize a new aggregate Markov Chain that has one state for each
        // action of the action chain:
        ArrayList<State> states = new ArrayList<State>();
        MarkovChain aggregateMarkovChain = markovBuilder.initSequentialMarkovChain(prefixes, actionNames, states);

        // Incorporate the specific Chains into the aggregate Chain:
        for (int i = 0; i < actions.size(); i++) {
            markovBuilder.incorporateMarkovChain(aggregateMarkovChain, chains.get(i), states.get(i), optimize, false);
        }

        // Naming:
        prefixes.remove(prefixes.size() - 1);

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
        String name = start.getEntityName() + "[" + start.getId() + "]";
        prefixes.add(name);
        LOGGER.debug("Visit Start: " + name);

        // Create a Markov Chain for the Start action:
        MarkovChain resultChain = markovBuilder.initBasicMarkovChain(prefixes);

        // Naming:
        prefixes.remove(prefixes.size() - 1);

        // Return the result:
        return resultChain;
    }

    /**
     * Returns a Markov Chain that corresponds to this stop action.
     * 
     * @param stop
     *            the stop action
     * @return the resulting Markov Chain
     */
    @Override
    public MarkovChain caseStop(final Stop stop) {

        // Logging & Naming:
        String name = stop.getEntityName() + "[" + stop.getId() + "]";
        LOGGER.debug("Visit Stop: " + name);
        prefixes.add(name);

        // Create a Markov chain for the Stop action:
        MarkovChain resultChain = markovBuilder.initBasicMarkovChain(prefixes);

        // Naming:
        prefixes.remove(prefixes.size() - 1);

        // Return the result:
        return resultChain;
    }
}
