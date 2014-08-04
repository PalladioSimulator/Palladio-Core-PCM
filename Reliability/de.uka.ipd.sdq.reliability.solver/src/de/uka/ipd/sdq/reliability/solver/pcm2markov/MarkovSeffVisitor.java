package de.uka.ipd.sdq.reliability.solver.pcm2markov;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.markov.MarkovChain;
import de.uka.ipd.sdq.markov.State;
import de.uka.ipd.sdq.markov.StateType;
import de.uka.ipd.sdq.pcm.reliability.ExternalFailureOccurrenceDescription;
import de.uka.ipd.sdq.pcm.reliability.FailureType;
import de.uka.ipd.sdq.pcm.reliability.HardwareInducedFailureType;
import de.uka.ipd.sdq.pcm.reliability.InternalFailureOccurrenceDescription;
import de.uka.ipd.sdq.pcm.reliability.NetworkInducedFailureType;
import de.uka.ipd.sdq.pcm.reliability.SoftwareInducedFailureType;
import de.uka.ipd.sdq.pcm.repository.Role;
import de.uka.ipd.sdq.pcm.repository.Signature;
import de.uka.ipd.sdq.pcm.resourceenvironment.CommunicationLinkResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ProcessingResourceSpecification;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.AbstractBranchTransition;
import de.uka.ipd.sdq.pcm.seff.AbstractInternalControlFlowAction;
import de.uka.ipd.sdq.pcm.seff.AcquireAction;
import de.uka.ipd.sdq.pcm.seff.BranchAction;
import de.uka.ipd.sdq.pcm.seff.CollectionIteratorAction;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.pcm.seff.ForkAction;
import de.uka.ipd.sdq.pcm.seff.ForkedBehaviour;
import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.seff.LoopAction;
import de.uka.ipd.sdq.pcm.seff.ReleaseAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
import de.uka.ipd.sdq.pcm.seff.ServiceEffectSpecification;
import de.uka.ipd.sdq.pcm.seff.SetVariableAction;
import de.uka.ipd.sdq.pcm.seff.StartAction;
import de.uka.ipd.sdq.pcm.seff.StopAction;
import de.uka.ipd.sdq.pcm.seff.SynchronisationPoint;
import de.uka.ipd.sdq.pcm.seff.seff_performance.ParametricResourceDemand;
import de.uka.ipd.sdq.pcm.seff.seff_reliability.FailureHandlingEntity;
import de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryAction;
import de.uka.ipd.sdq.pcm.seff.seff_reliability.RecoveryActionBehaviour;
import de.uka.ipd.sdq.pcm.seff.util.SeffSwitch;
import de.uka.ipd.sdq.pcmsolver.transformations.ContextWrapper;
import de.uka.ipd.sdq.pcmsolver.visitors.EMFQueryHelper;
import de.uka.ipd.sdq.probfunction.math.ManagedPMF;
import de.uka.ipd.sdq.reliability.core.MarkovEvaluationType;
import de.uka.ipd.sdq.reliability.core.MarkovHardwareInducedFailureType;
import de.uka.ipd.sdq.reliability.core.MarkovNetworkInducedFailureType;
import de.uka.ipd.sdq.reliability.core.MarkovSoftwareInducedFailureType;

/**
 * This class represents a visitor for an RDSEFF within a PCM instance. The visitor is used in the
 * transformation from PCM with solved dependencies into a Markov Chain Model for reliability
 * prediction.
 * 
 * @author brosch
 */
public class MarkovSeffVisitor extends SeffSwitch<MarkovChain> {

    /**
     * A logger to give detailed information about the PCM instance traversal.
     */
    private static final Logger LOGGER = Logger.getLogger(MarkovSeffVisitor.class.getName());

    /**
     * The ContextWrapper provides easy access to the decorations of the solved PCM instance.
     */
    private ContextWrapper contextWrapper;

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
     * A provider of information about the PCM instance and the corresponding resource descriptors.
     */
    private final MarkovTransformationSource transformationState;

    /**
     * The constructor.
     * 
     * @param transformationState
     *            the Markov transformation state
     * @param wrapper
     *            the ContextWrapper provides easy access to the decorations of the solved PCM
     *            instance
     * @param prefixes
     *            the list of prefixes for state names
     * @param evaluationType
     *            the degree of differentiation between failure types
     * @param simplifiedStateHandling
     *            controls the handling of physical resource states
     * @param optimize
     *            controls if Markov Chain reduction is performed during transformation
     * @param recordTraces
     *            controls if traces shall be recorded during transformation
     */
    public MarkovSeffVisitor(final MarkovTransformationSource transformationState, final ContextWrapper wrapper,
            final List<String> prefixes, final MarkovEvaluationType evaluationType,
            final boolean simplifiedStateHandling, final boolean optimize, final boolean recordTraces) {
        this.transformationState = transformationState;
        this.contextWrapper = wrapper;
        this.prefixes = prefixes;
        this.evaluationType = evaluationType;
        this.optimize = optimize;
        this.recordTraces = recordTraces;
        this.simplifiedStateHandling = simplifiedStateHandling;
        this.markovBuilder = new MarkovBuilder(recordTraces);
    }

    /**
     * Adds a new failure description to a list of existing descriptions.
     * 
     * @param failureDescriptions
     *            the list of descriptions
     * @param newFailureDescription
     *            the failure description to add
     */
    private void addFailureDescription(List<FailureDescription> failureDescriptions,
            FailureDescription newFailureDescription) {
        FailureDescription existingFailureDescription = null;
        Iterator<FailureDescription> iterator = failureDescriptions.iterator();
        while (iterator.hasNext()) {
            FailureDescription comparator = iterator.next();
            if (newFailureDescription.getFailureType().equals(comparator.getFailureType())) {
                existingFailureDescription = comparator;
                break;
            }
        }
        if (existingFailureDescription == null) {
            failureDescriptions.add(newFailureDescription);
        } else {
            existingFailureDescription.setFailureProbability(existingFailureDescription.getFailureProbability()
                    + newFailureDescription.getFailureProbability());
        }
    }

    /**
     * Handles RecoveryActions.
     * 
     * This is a workaround using the case for AbstractInternalControlFlowActions, because
     * RecoveryActions are not directly contained in the SEFF package, and thus there is no case for
     * them.
     * 
     * First, for each RecoveryActionBehaviour a specific Markov chain is built. Then, specific
     * chains are appended to each other according to the specification of handled failure types.
     * 
     * @param controlFlowAction
     *            the control flow action
     * @return the resulting Markov Chain.
     */
    @Override
    public MarkovChain caseAbstractInternalControlFlowAction(final AbstractInternalControlFlowAction controlFlowAction) {

        // Only consider RecoveryBlockActions:
        if (!(controlFlowAction instanceof RecoveryAction)) {
            return null;
        }
        RecoveryAction action = (RecoveryAction) controlFlowAction;

        // Logging & naming:
        String name = action.getEntityName() + "[" + action.getId() + "]";
        prefixes.add(name);
        LOGGER.debug("Visit RecoveryAction: " + name);

        // Retrieve the list of RecoveryBlockBehaviours:
        List<RecoveryActionBehaviour> behaviours = action.getRecoveryActionBehaviours__RecoveryAction();
        if (behaviours.size() == 0) {
            throw new MarkovException("RecoveryAction '" + action.getEntityName()
                    + "' does not specify any behaviours.");
        }

        // Create the resulting Markov chain:
        MarkovChain resultChain = processRecoveryActionBehaviour(action, action.getPrimaryBehaviour__RecoveryAction());

        // Naming:
        prefixes.remove(prefixes.size() - 1);

        // Return the result:
        return resultChain;
    }

    /**
     * An Acquire Action returns a trivial Markov Chain.
     * 
     * @param acquireAction
     *            the acquire action
     * @return the resulting Markov Chain.
     */
    @Override
    public MarkovChain caseAcquireAction(final AcquireAction acquireAction) {

        // Logging & naming:
        String name = acquireAction.getEntityName() + "[" + acquireAction.getId() + "]";
        prefixes.add(name);
        LOGGER.debug("Visit AcquireAction: " + name);

        // Create a Markov chain for the Acquire action:
        MarkovChain resultChain = markovBuilder.initBasicMarkovChain(prefixes);

        // Naming:
        prefixes.remove(prefixes.size() - 1);

        // Return the result:
        return resultChain;
    }

    /**
     * For a BranchAction, first the Markov Chain of each of the transition behaviours is built. The
     * results are then inserted into a new Markov Chain that has one State for each of the possible
     * branches.
     * 
     * @param branchAction
     *            the BranchAction
     * @return the resulting Markov Chain
     */
    @Override
    public MarkovChain caseBranchAction(final BranchAction branchAction) {

        // Logging & naming:
        String name = branchAction.getEntityName() + "[" + branchAction.getId() + "]";
        prefixes.add(name);
        LOGGER.debug("Visit BranchAction: " + name);

        // Determine the inner Markov Chains associated with the branch
        // behaviors:
        EList<AbstractBranchTransition> transitions = branchAction.getBranches_Branch();
        ArrayList<MarkovChain> specificMarkovChains = new ArrayList<MarkovChain>();
        ArrayList<Double> branchProbabilities = new ArrayList<Double>();
        double branchProbabilitySum = 0.0;
        for (int i = 0; i < transitions.size(); i++) {
            Double branchProbability = contextWrapper.getBranchProbability(transitions.get(i));
            branchProbabilitySum += branchProbability;
            if (branchProbability > 1.0) {
                throw new MarkovException("Error in solved parametric dependencies detected: " + "BranchAction \""
                        + branchAction.getEntityName() + "\" has probability " + branchProbability
                        + ", which is greater than 1.0");
            }
            if (branchProbabilitySum > 1.0) {
                throw new MarkovException("Error in solved parametric dependencies detected: "
                        + "Branch probabilities of BranchAction \"" + branchAction.getEntityName()
                        + "\" sum up to more than 1.0");
            }
            branchProbabilities.add(branchProbability);

            // Handle only branches with positive branch probabilities; other
            // branches don't influence the reliability. Furthermore, branches
            // with zero probability could not be handled anyway, because the
            // dependency solver omits them and leaves their parametric
            // dependencies unsolved (see also Bug 615).
            if (branchProbability > 0.0) {
                prefixes.add(transitions.get(i).getEntityName() + "[" + transitions.get(i).getId() + "]");
                specificMarkovChains.add(doSwitch(transitions.get(i).getBranchBehaviour_BranchTransition()));
                prefixes.remove(prefixes.size() - 1);
            }
        }

        // Initialize the aggregate Markov Chain representing the loop:
        MarkovChain aggregateMarkovChain = markovBuilder.initBranchMarkovChain(prefixes, branchProbabilities);

        // Incorporate the specific MarkovChain into the aggregate one:
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
     * A collection iterator action is handled the same way as an ordinary loop.
     * 
     * @param collectionIteratorAction
     *            the CollectionIteratoraction
     * @return the resulting Markov Chain
     */
    @Override
    public MarkovChain caseCollectionIteratorAction(final CollectionIteratorAction collectionIteratorAction) {

        // Logging & naming:
        String name = collectionIteratorAction.getEntityName() + "[" + collectionIteratorAction.getId() + "]";
        prefixes.add(name);
        LOGGER.debug("Visit CollectionIteratorAction: " + name);

        // Determine the inner Markov Chain associated with the loop behaviour:
        ArrayList<String> prefixesCopy = new ArrayList<String>();
        prefixesCopy.addAll(prefixes);
        prefixes.clear();
        MarkovChain specificMarkovChain = doSwitch(collectionIteratorAction.getBodyBehaviour_Loop());
        prefixes.addAll(prefixesCopy);

        // Get the solved loop probability mass function:
        ManagedPMF pmf = contextWrapper.getLoopIterations(collectionIteratorAction);

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
     * Evaluates the availability of a resource container. Returns a corresponding Markov chain.
     * 
     * @param descriptors
     *            the list of required resources and their states
     * @return the resulting Markov chain
     */
    private MarkovChain caseContainerAvailability(final ResourceContainer container) {

        // Check for the requested type of analysis:
        MarkovChain resultChain = null;
        if (simplifiedStateHandling) {
            // Simplified state handling; iterate over all resource states like
            // a branch:
            resultChain = caseContainerAvailabilityForIteratedResourceStates(container);
        } else {
            // Full state handling; container availability is evaluated
            // only once (for the current resource state):
            resultChain = caseContainerAvailabilityForResourceState(container);
        }

        // Return the result:
        return resultChain;
    }

    /**
     * Evaluates the availability of a resource container through iteration over the possible states
     * of its required resources. Returns a corresponding Markov chain.
     * 
     * @param container
     *            the resource container
     * @return the resulting Markov chain
     */
    private MarkovChain caseContainerAvailabilityForIteratedResourceStates(final ResourceContainer container) {

        // Create the result chain:
        MarkovChain resultChain;

        // Retrieve descriptors for the resources required by the container:
        List<ProcessingResourceDescriptor> descriptors = getResourceDescriptors(container, true);

        // Create the state probabilities and specific state chains:
        ArrayList<Double> stateProbabilities = new ArrayList<Double>();
        ArrayList<MarkovChain> stateChains = new ArrayList<MarkovChain>();
        ArrayList<String> prefixesCopy = new ArrayList<String>();
        prefixesCopy.addAll(prefixes);
        prefixes.clear();
        for (long i = 0; i < Math.pow(2, descriptors.size()); i++) {
            setResourceState(descriptors, i);
            stateProbabilities.add(getResourceStateProbability(descriptors));
            stateChains.add(caseContainerAvailabilityForResourceState(container));
        }
        prefixes.addAll(prefixesCopy);

        // Initialize the aggregate Markov chain representing the branch:
        resultChain = markovBuilder.initBranchMarkovChain(prefixes, stateProbabilities);

        // Incorporate the specific Markov chains into the aggregate one:
        ArrayList<State> statesToReplace = new ArrayList<State>();
        for (int i = 0; i < resultChain.getStates().size(); i++) {
            if (resultChain.getStates().get(i).getType().equals(StateType.DEFAULT)) {
                statesToReplace.add(resultChain.getStates().get(i));
            }
        }
        for (int i = 0; i < statesToReplace.size(); i++) {
            markovBuilder.incorporateMarkovChain(resultChain, stateChains.get(i), statesToReplace.get(i), optimize,
                    true);
        }

        // Return the result:
        return resultChain;
    }

    /**
     * Evaluates the availability of a resource container. Returns a corresponding Markov chain.
     * 
     * @param descriptors
     *            the list of required resources and their states
     * @return the resulting Markov chain
     */
    private MarkovChain caseContainerAvailabilityForResourceState(final ResourceContainer container) {

        // Retrieve the resource failure descriptions:
        List<ProcessingResourceDescriptor> descriptors = getResourceDescriptors(container, true);
        List<FailureDescription> failureDescriptions = getFailureDescriptionsForResourceState(descriptors);

        MarkovChain resultChain = null;
        if (failureDescriptions.isEmpty()) {
            // All resource available:
            resultChain = markovBuilder.initBasicMarkovChain(prefixes);
        } else {
            // If there are unavailable resources, build a Markov chain
            // that reflects each unavailable resource:
            resultChain = markovBuilder.initResourceFailureMarkovChain(prefixes, failureDescriptions);
        }

        // Return the result:
        return resultChain;
    }

    /**
     * Handles an ExternalCallAction. Generates a Markov Chain of the executing behavior. The Markov
     * Chain is generated by {@link MarkovSeffVisitor.createExternalCallActionChain}. If an retry
     * count is set in the internal action, the chain is repeatedly appended to the main chains
     * failure state.
     * 
     * @param externalCallAction
     *            the ExternalCallAction
     * @return the resulting Markov Chain.
     */
    @Override
    public MarkovChain caseExternalCallAction(final ExternalCallAction externalCallAction) {

        // Logging & naming:
        String name = externalCallAction.getEntityName() + "[" + externalCallAction.getId() + "]";
        prefixes.add(name);
        LOGGER.debug("Visit ExternalCallAction: " + name);

        // Get a reference to the executing SEFF:
        ServiceEffectSpecification seff = contextWrapper.getNextSEFF(externalCallAction);

        // Build a specific Markov Chain depending on the type of call:
        MarkovChain resultChain = null;
        if (seff == null) {

            // A system external call might fail according to
            // FailureOccurrenceDescriptions given as
            // SpecifiedReliabilityAnnotations to the system:
            resultChain = caseExternalCallActionOutsideSystem(externalCallAction);

        } else {

            // If the call is not system external, build a Markov chain that
            // reflects the service-providing behaviour of the call:
            resultChain = caseExternalCallActionInsideSystem(externalCallAction);
        }

        // If a retry policy has been specified for this external call,
        // and if the differentiation of failure types is fine-grained enough,
        // then reflect the failure handling behaviour accordingly:
        if ((evaluationType != MarkovEvaluationType.SINGLE) && (evaluationType != MarkovEvaluationType.CLASSES)) {
            int retryCount = externalCallAction.getRetryCount();
            if (retryCount < 0) {
                LOGGER.warn("Retry count of ExternalCallAction \"" + externalCallAction.getEntityName()
                        + "\" is negative. Assuming 0.");
                retryCount = 0;
            }
            List<String> failureTypeIds = getFailureTypeIds(externalCallAction);
            MarkovChain handlingChain = markovBuilder.copyMarkovChain(resultChain);
            for (int i = 0; i < retryCount; ++i) {
                markovBuilder.appendFailureHandlingMarkovChain(resultChain, handlingChain, failureTypeIds, optimize);
            }
        }

        // Naming:
        prefixes.remove(prefixes.size() - 1);

        // Return the result:
        return resultChain;
    }

    /**
     * Evaluates an external call action that does not leave the system boundaries. Returns a
     * corresponding Markov chain.
     * 
     * @param call
     *            the ExternalCallAction
     * @return the resulting Markov Chain.
     */
    private MarkovChain caseExternalCallActionInsideSystem(final ExternalCallAction call) {

        // Get a reference to the executing SEFF:
        ServiceEffectSpecification seff = contextWrapper.getNextSEFF(call);

        // For the new SEFF, we need a new ContextWrapper. As during the
        // creation of the new ContextWrapper, the old one is altered (which
        // is certainly bad programming style!), we need to save a copy of
        // the old one and restore it after generating the new one:
        ContextWrapper originalContextWrapper = (ContextWrapper) contextWrapper.clone();
        List<ContextWrapper> contextWrapperList = contextWrapper.getContextWrapperFor(call);

        // FIXME: The Reliability solver does not support replication yet
        if (contextWrapperList.size() > 1) {
            LOGGER.error("The Reliability solver only supports one AllocationContext per AssemblyContext. Picking one of the called Allocation contexts for call "
                    + call.getEntityName() + " " + call.getId() + " ignoring the others. Results will be inaccurate.");
        } else if (contextWrapperList.size() == 0) {
            throw new RuntimeException("Internal Error: Could not create a Context Wrapper for call "
                    + call.getEntityName() + " " + call.getId());
        }
        ContextWrapper newContextWrapper = contextWrapperList.get(0);
        contextWrapper = originalContextWrapper;

        // Build the Markov chain of the executing SEFF:
        MarkovChain resultChain = null;
        MarkovChain innerMarkovChain = new MarkovSeffVisitor(this.transformationState, newContextWrapper, prefixes,
                evaluationType, simplifiedStateHandling, optimize, recordTraces).doSwitch(seff);

        // Check if the external call crosses the border of one resource
        // container and uses a communication link (if the specification
        // of the communication link is omitted in the model, we treat
        // the link as being perfect, i.e. never failing):
        CommunicationLinkResourceSpecification commLink = contextWrapper.getConcreteLinkingResource(call,
                newContextWrapper.getAllCtx());

        // If a communication link is specified and used by the call,
        // consider the possibility that the call fails:
        if (commLink != null) {

            // The call can be modeled as a behavior with three steps: the
            // sending of the message, the remote execution, and the message
            // return. All of these steps contribute a potential for failure:
            ArrayList<State> states = new ArrayList<State>();
            ArrayList<String> names = new ArrayList<String>();
            names.add("MessageTransfer(1)");
            names.add("ServiceExecution");
            names.add("MessageTransfer(2)");
            MarkovChain aggregateMarkovChain = markovBuilder.initSequentialMarkovChain(prefixes, names, states);

            // The first and last steps can be modeled like an Internal
            // Action which either fails or succeeds:
            prefixes.add(names.get(0));
            MarkovChain messagingMarkovChain = caseMessageTransfer(commLink);
            prefixes.remove(prefixes.size() - 1);
            prefixes.add(names.get(2));
            MarkovChain returnMarkovChain = caseMessageTransfer(commLink);
            prefixes.remove(prefixes.size() - 1);

            // The second step is the already computed inner Markov Chain.
            // Incorporate all steps into the aggregate chain:
            markovBuilder.incorporateMarkovChain(aggregateMarkovChain, messagingMarkovChain, states.get(0), optimize,
                    false);
            markovBuilder
                    .incorporateMarkovChain(aggregateMarkovChain, innerMarkovChain, states.get(1), optimize, false);
            markovBuilder.incorporateMarkovChain(aggregateMarkovChain, returnMarkovChain, states.get(2), optimize,
                    false);

            // Return the result:
            resultChain = aggregateMarkovChain;

        } else {

            // If the call is local, or if the specification of the
            // communication link has been omitted, then the Markov
            // Chain just has to reflect the inner SEFF behavior:
            resultChain = innerMarkovChain;
        }

        // Return the result:
        return resultChain;
    }

    /**
     * Evaluates an external call action that leaves the system boundaries. Returns a corresponding
     * Markov chain.
     * 
     * @param externalCallAction
     * @return the resulting Markov chain
     */
    private MarkovChain caseExternalCallActionOutsideSystem(final ExternalCallAction externalCallAction) {

        // Create the result chain:
        MarkovChain resultChain;

        // Get the raw failure occurrence descriptions of the system-external
        // call:
        List<ExternalFailureOccurrenceDescription> rawFailureDescriptions = contextWrapper
                .getFailureOccurrenceDescriptionsForSystemExternalCall(externalCallAction);

        // Retrieve the failure descriptions list:
        List<FailureDescription> resultFailureDescriptions = new ArrayList<FailureDescription>();
        for (ExternalFailureOccurrenceDescription description : rawFailureDescriptions) {
            Role role = description.getSpecifiedReliabilityAnnotation__ExternalFailureOccurrenceDescription()
                    .getRole_SpecifiedQoSAnnotation();
            Signature signature = description.getSpecifiedReliabilityAnnotation__ExternalFailureOccurrenceDescription()
                    .getSignature_SpecifiedQoSAnnation();
            FailureType failureType = description.getFailureType__ExternalFailureOccurrenceDescription();
            FailureDescription newFailureDescription = null;
            if (failureType instanceof SoftwareInducedFailureType) {
                newFailureDescription = new FailureDescription(
                        MarkovSoftwareInducedFailureType.createExternalFailureType(evaluationType, failureType.getId(),
                                signature.getId(), role.getId()), description.getFailureProbability());
            } else if (failureType instanceof HardwareInducedFailureType) {
                newFailureDescription = new FailureDescription(
                        MarkovHardwareInducedFailureType.createExternalFailureType(evaluationType,
                                ((HardwareInducedFailureType) failureType)
                                        .getProcessingResourceType__HardwareInducedFailureType().getId(), signature
                                        .getId(), role.getId()), description.getFailureProbability());
            } else if (failureType instanceof NetworkInducedFailureType) {
                newFailureDescription = new FailureDescription(
                        MarkovNetworkInducedFailureType.createExternalFailureType(evaluationType,
                                ((NetworkInducedFailureType) failureType)
                                        .getCommunicationLinkResourceType__NetworkInducedFailureType().getId(),
                                signature.getId(), role.getId()), description.getFailureProbability());
            }
            addFailureDescription(resultFailureDescriptions, newFailureDescription);
        }

        // Check if failure descriptions exist for the system-external call:
        if (resultFailureDescriptions.size() > 0) {
            // Create a chain that reflects the existing failure descriptions:
            resultChain = markovBuilder.initBasicMarkovChainWithFailures(prefixes, resultFailureDescriptions);
        } else {
            // Create a basic chain:
            resultChain = markovBuilder.initBasicMarkovChain(prefixes);
        }

        // Return the result:
        return resultChain;
    }

    /**
     * Handles fork actions.
     * 
     * All forked behaviours are handled sequentially.
     */
    @Override
    public MarkovChain caseForkAction(ForkAction forkAction) {

        // Logging & naming:
        String name = forkAction.getEntityName() + "[" + forkAction.getId() + "]";
        prefixes.add(name);
        LOGGER.debug("Visit ForkAction: " + name);

        // Go through the list of forked behaviours that are contained in the
        // fork action. Each behaviour creates its own specific Markov Chain:
        ArrayList<MarkovChain> chains = new ArrayList<MarkovChain>();
        ArrayList<ForkedBehaviour> behaviours = new ArrayList<ForkedBehaviour>();
        for (int i = 0; i < forkAction.getAsynchronousForkedBehaviours_ForkAction().size(); i++) {
            chains.add(doSwitch(forkAction.getAsynchronousForkedBehaviours_ForkAction().get(i)));
            behaviours.add(forkAction.getAsynchronousForkedBehaviours_ForkAction().get(i));
        }
        SynchronisationPoint synch = forkAction.getSynchronisingBehaviours_ForkAction();
        if (synch != null) {
            for (int i = 0; i < synch.getSynchronousForkedBehaviours_SynchronisationPoint().size(); i++) {
                chains.add(doSwitch(synch.getSynchronousForkedBehaviours_SynchronisationPoint().get(i)));
                behaviours.add(synch.getSynchronousForkedBehaviours_SynchronisationPoint().get(i));
            }
        }

        // Initialize a new aggregate Markov Chain that has one state for each
        // behaviour of the fork action:
        ArrayList<State> states = new ArrayList<State>();
        MarkovChain aggregateMarkovChain = markovBuilder.initForkMarkovChain(prefixes, behaviours, states);

        // Incorporate the specific Chains into the aggregate Chain:
        for (int i = 0; i < behaviours.size(); i++) {
            markovBuilder.incorporateMarkovChain(aggregateMarkovChain, chains.get(i), states.get(i), optimize, false);
        }

        // Naming:
        prefixes.remove(prefixes.size() - 1);

        // Return the result:
        return aggregateMarkovChain;
    }

    /**
     * An InternalAction is an actual possible point of failure, either because a software failure
     * might happen, or because a required physical resource may be currently unavailable.
     * 
     * A Markov chain is returned that reflects all possible outcomes and their probabilities.
     * 
     * @param internalAction
     *            the InternalAction
     * @return the resulting Markov Chain
     */
    @Override
    public MarkovChain caseInternalAction(final InternalAction internalAction) {

        // Logging & naming:
        String name = internalAction.getEntityName() + "[" + internalAction.getId() + "]";
        prefixes.add(name);
        LOGGER.debug("Visit InternalAction: " + name);

        // Check for the requested type of analysis:
        MarkovChain resultChain = null;
        if (simplifiedStateHandling) {
            // Simplified state handling; iterate over all resource states like
            // a branch:
            resultChain = caseInternalActionForIteratedResourceStates(internalAction);
        } else {
            // Full state handling; internal action is evaluated
            // only once (for the current resource state):
            resultChain = caseInternalActionForResourceState(internalAction);
        }

        // Naming:
        prefixes.remove(prefixes.size() - 1);

        // Return the result:
        return resultChain;
    }

    /**
     * Evaluates an internal action through iteration over the possible states of its required
     * resources. Returns a corresponding Markov chain.
     * 
     * @param internalAction
     *            the internal action
     * @return the resulting Markov chain
     */
    private MarkovChain caseInternalActionForIteratedResourceStates(final InternalAction internalAction) {

        // Create the result chain:
        MarkovChain resultChain;

        // Retrieve descriptors for the resources required by this internal
        // action:
        List<ProcessingResourceDescriptor> descriptors = getResourceDescriptors(internalAction);

        // Create the state probabilities and specific state chains:
        ArrayList<Double> stateProbabilities = new ArrayList<Double>();
        ArrayList<MarkovChain> stateChains = new ArrayList<MarkovChain>();
        ArrayList<String> prefixesCopy = new ArrayList<String>();
        prefixesCopy.addAll(prefixes);
        prefixes.clear();
        for (long i = 0; i < Math.pow(2, descriptors.size()); i++) {
            setResourceState(descriptors, i);
            stateProbabilities.add(getResourceStateProbability(descriptors));
            stateChains.add(caseInternalActionForResourceState(internalAction));
        }
        prefixes.addAll(prefixesCopy);

        // Initialize the aggregate Markov chain representing the branch:
        resultChain = markovBuilder.initBranchMarkovChain(prefixes, stateProbabilities);

        // Incorporate the specific Markov chains into the aggregate one:
        ArrayList<State> statesToReplace = new ArrayList<State>();
        for (int i = 0; i < resultChain.getStates().size(); i++) {
            if (resultChain.getStates().get(i).getType().equals(StateType.DEFAULT)) {
                statesToReplace.add(resultChain.getStates().get(i));
            }
        }
        for (int i = 0; i < statesToReplace.size(); i++) {
            markovBuilder.incorporateMarkovChain(resultChain, stateChains.get(i), statesToReplace.get(i), optimize,
                    true);
        }

        // Return the result:
        return resultChain;
    }

    /**
     * Evaluates an internal action for one specific resource state and returns the resulting Markov
     * chain.
     * 
     * @param internalAction
     *            the internal action
     * @return the resulting Markov chain
     */
    private MarkovChain caseInternalActionForResourceState(final InternalAction internalAction) {

        // Retrieve descriptors for the resources required by this internal
        // action:
        List<ProcessingResourceDescriptor> descriptors = getResourceDescriptors(internalAction);

        // Retrieve the resource failure descriptions:
        List<FailureDescription> failureDescriptions = getFailureDescriptionsForResourceState(descriptors);

        MarkovChain resultChain = null;
        if (failureDescriptions.isEmpty()) {

            // If all required resources are available, build a Markov chain
            // that reflects the potential application failures:
            failureDescriptions = getInternalActionSoftwareFailureDescriptions(internalAction);

            // Build the Markov chain:
            resultChain = markovBuilder.initBasicMarkovChainWithFailures(prefixes, failureDescriptions);
        } else {

            // If there are unavailable resources, build a Markov chain
            // that reflects each unavailable resource:
            resultChain = markovBuilder.initResourceFailureMarkovChain(prefixes, failureDescriptions);
        }

        // Return the result:
        return resultChain;
    }

    /**
     * For a LoopAction, first the Markov Chain of the body behaviour is built. The result is then
     * inserted into a new Markov Chain that has one State for each of the possible iteration counts
     * of the loop.
     * 
     * @param loopAction
     *            the LoopAction
     * @return the resulting Markov Chain
     */
    @Override
    public MarkovChain caseLoopAction(final LoopAction loopAction) {

        // Logging & naming:
        String name = loopAction.getEntityName() + "[" + loopAction.getId() + "]";
        prefixes.add(name);
        LOGGER.debug("Visit LoopAction: " + name);

        // Determine the inner Markov Chain associated with the loop behaviour:
        ArrayList<String> prefixesCopy = new ArrayList<String>();
        prefixesCopy.addAll(prefixes);
        prefixes.clear();
        MarkovChain specificMarkovChain = doSwitch(loopAction.getBodyBehaviour_Loop());
        prefixes.addAll(prefixesCopy);

        // Get the solved loop probability mass function:
        ManagedPMF pmf = contextWrapper.getLoopIterations(loopAction);

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
     * Evaluates a message transfer over a communication link. Returns a corresponding Markov chain.
     * 
     * @param commLink
     *            the communication link
     * @return the resulting Markov chain
     */
    private MarkovChain caseMessageTransfer(CommunicationLinkResourceSpecification commLink) {
        List<FailureDescription> commFailureDescriptions = getFailureDescriptionsForCommunicationLink(commLink);
        MarkovChain messagingMarkovChain = markovBuilder.initBasicMarkovChainWithFailures(prefixes,
                commFailureDescriptions);
        return messagingMarkovChain;
    }

    /**
     * A Release Action returns a trivial Markov Chain.
     * 
     * @param releaseAction
     *            the release action
     * @return the resulting Markov Chain.
     */
    @Override
    public MarkovChain caseReleaseAction(final ReleaseAction releaseAction) {

        // Logging & naming:
        String name = releaseAction.getEntityName() + "[" + releaseAction.getId() + "]";
        prefixes.add(name);
        LOGGER.debug("Visit ReleaseAction: " + name);

        // Create a Markov chain for the Release action:
        MarkovChain resultChain = markovBuilder.initBasicMarkovChain(prefixes);

        // Naming:
        prefixes.remove(prefixes.size() - 1);

        // Return the result:
        return resultChain;
    }

    /**
     * Evaluates a resource demanding behaviour by considering all actions in the behaviour. Returns
     * a corresponding Markov chain.
     * 
     * @param behaviour
     *            the ResourceDemandingBehaviour
     * @return the resulting Markov Chain
     */
    @Override
    public MarkovChain caseResourceDemandingBehaviour(final ResourceDemandingBehaviour behaviour) {

        // Logging & naming:
        LOGGER.debug("Visit ResourceDemandingBehaviour");

        // Go through the chain of actions that constitute this Behaviour. Each
        // action is expected to create its own specific Markov Chain:
        ArrayList<AbstractAction> actions = new ArrayList<AbstractAction>();
        ArrayList<MarkovChain> chains = new ArrayList<MarkovChain>();
        AbstractAction action = (StartAction) EMFQueryHelper.getObjectByType(behaviour.getSteps_Behaviour(),
                StartAction.class);
        while (action != null) {
            MarkovChain specificMarkovChain = doSwitch(action);
            actions.add(action);
            chains.add(specificMarkovChain);
            action = action.getSuccessor_AbstractAction();
        }

        // Initialize a new aggregate Markov Chain that has one state for each
        // action of the action chain:
        ArrayList<State> states = new ArrayList<State>();
        MarkovChain aggregateMarkovChain = markovBuilder.initBehaviourMarkovChainByAction(prefixes, actions, states);

        // Incorporate the specific Chains into the aggregate Chain:
        for (int i = 0; i < actions.size(); i++) {
            markovBuilder.incorporateMarkovChain(aggregateMarkovChain, chains.get(i), states.get(i), optimize, false);
        }

        // Return the resulting Markov Chain:
        return aggregateMarkovChain;
    }

    /**
     * Evaluates a resource demanding SEFF. In addition to the behavioural evaluation, also the
     * availability of the executing resource container is checked. Returns a corresponding Markov
     * chain.
     * 
     * @param seff
     *            the ResourceDemandingSEFF
     * @return the resulting Markov Chain
     */
    @Override
    public MarkovChain caseResourceDemandingSEFF(final ResourceDemandingSEFF seff) {

        // Logging & naming:
        LOGGER.debug("Visit ResourceDemandingSEFF: [" + seff.getId() + "]");

        // Consider both the execution of the SEFF itself and the possibility
        // that the executing resource container is unavailable:
        ArrayList<State> states = new ArrayList<State>();
        ArrayList<String> names = new ArrayList<String>();
        names.add("ContainerAvailability");
        names.add("ServiceExecution");
        MarkovChain aggregateMarkovChain = markovBuilder.initSequentialMarkovChain(prefixes, names, states);

        // Model both aspects with an own specific Markov chain:
        prefixes.add(names.get(0));
        ResourceContainer container = contextWrapper.getAllCtx().getResourceContainer_AllocationContext();
        MarkovChain containerAvailabilityMarkovChain = caseContainerAvailability(container);
        prefixes.remove(prefixes.size() - 1);
        prefixes.add(names.get(1));
        MarkovChain innerMarkovChain = caseResourceDemandingBehaviour(seff);
        prefixes.remove(prefixes.size() - 1);

        // Incorporate all steps into the aggregate chain:
        markovBuilder.incorporateMarkovChain(aggregateMarkovChain, containerAvailabilityMarkovChain, states.get(0),
                optimize, false);
        markovBuilder.incorporateMarkovChain(aggregateMarkovChain, innerMarkovChain, states.get(1), optimize, false);

        // Return the result:
        return aggregateMarkovChain;
    }

    /**
     * A SetVariableAction returns a trivial Markov Chain.
     * 
     * @param setVariableAction
     *            the SetVariableAction
     * @return the resulting Markov Chain
     */
    @Override
    public MarkovChain caseSetVariableAction(final SetVariableAction setVariableAction) {

        // Logging & naming:
        String name = setVariableAction.getEntityName() + "[" + setVariableAction.getId() + "]";
        prefixes.add(name);
        LOGGER.debug("Visit SetVariableAction: " + name);

        // Build the Markov chain for the SetVariable action:
        MarkovChain resultChain = markovBuilder.initBasicMarkovChain(prefixes);

        // Naming:
        prefixes.remove(prefixes.size() - 1);

        // Return the result:
        return resultChain;
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

        // Logging & naming:
        String name = startAction.getEntityName() + "[" + startAction.getId() + "]";
        prefixes.add(name);
        LOGGER.debug("Visit StartAction: " + name);

        // Build the Markov chain for the Start action:
        MarkovChain resultChain = markovBuilder.initBasicMarkovChain(prefixes);

        // Naming:
        prefixes.remove(prefixes.size() - 1);

        // Return the result:
        return resultChain;
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

        // Logging & naming:
        String name = stopAction.getEntityName() + "[" + stopAction.getId() + "]";
        prefixes.add(name);
        LOGGER.debug("Visit StopAction: " + name);

        // Build the Markov chain for the Stop action:
        MarkovChain resultChain = markovBuilder.initBasicMarkovChain(prefixes);

        // Naming:
        prefixes.remove(prefixes.size() - 1);

        // Return the result:
        return resultChain;
    }

    /**
     * Retrieves a list of failureDescriptions for a communication link.
     * 
     * @param commLink
     *            the communication link
     * @return the list of failure descriptions
     */
    private List<FailureDescription> getFailureDescriptionsForCommunicationLink(
            CommunicationLinkResourceSpecification commLink) {
        List<FailureDescription> commFailureDescriptions = new ArrayList<FailureDescription>();
        commFailureDescriptions.add(new FailureDescription(MarkovNetworkInducedFailureType.createInternalFailureType(
                evaluationType, commLink.getLinkingResource_CommunicationLinkResourceSpecification(),
                commLink.getCommunicationLinkResourceType_CommunicationLinkResourceSpecification()), commLink
                .getFailureProbability()));
        return commFailureDescriptions;
    }

    /**
     * Retrieves a list of failure descriptions for resource unavailability failures under a given
     * resource state.
     * 
     * @param descriptors
     *            the list of resources and their states
     * @return the list of failure descriptions
     */
    private List<FailureDescription> getFailureDescriptionsForResourceState(
            final List<ProcessingResourceDescriptor> descriptors) {

        // List all possible unavailability failures:
        List<FailureDescription> failureDescriptions = new ArrayList<FailureDescription>();
        FailureDescription newFailureDescription = null;

        // Check if any of the resources is unavailable:
        for (ProcessingResourceDescriptor descriptor : descriptors) {

            // Get the current state of the resource:
            MarkovResourceState state = descriptor.getCurrentState();
            if (state == null) {
                LOGGER.error("Resource state no set for " + descriptor.getType().getName()
                        + " resource demand. Assume resource state = OK.");
                continue;
            }

            // If the resource is unavailable, create a corresponding
            // failure description:
            if (state.equals(MarkovResourceState.NA)) {
                newFailureDescription = new FailureDescription(
                        MarkovHardwareInducedFailureType.createInternalFailureType(evaluationType,
                                descriptor.getResourceContainerId(), descriptor.getType().getId()), 1.0);
                addFailureDescription(failureDescriptions, newFailureDescription);
            }
        }

        // Return the result:
        return failureDescriptions;
    }

    /**
     * Returns the ids of the failure types that a given failure handling entity can handle.
     * 
     * @param entity
     *            the failure handling entity
     * @return the list of failure type names
     */
    private List<String> getFailureTypeIds(final FailureHandlingEntity entity) {
        List<String> failureTypes = new ArrayList<String>();
        for (FailureType failureType : entity.getFailureTypes_FailureHandlingEntity()) {
            if (failureType instanceof SoftwareInducedFailureType) {
                failureTypes.add(failureType.getId());
            } else if (failureType instanceof HardwareInducedFailureType) {
                failureTypes.add(((HardwareInducedFailureType) failureType)
                        .getProcessingResourceType__HardwareInducedFailureType().getId());
            } else if (failureType instanceof NetworkInducedFailureType) {
                failureTypes.add(((NetworkInducedFailureType) failureType)
                        .getCommunicationLinkResourceType__NetworkInducedFailureType().getId());
            } else {
                throw new MarkovException("Unsupported failure type " + failureType.getClass().getName());
            }
        }

        return failureTypes;
    }

    /**
     * Retrieves a list of software failure descriptions for a given internal action.
     * 
     * @param internalAction
     *            the internal action
     * @return the list of software failure descriptions
     */
    private List<FailureDescription> getInternalActionSoftwareFailureDescriptions(final InternalAction internalAction) {

        // List all possible software failures:
        List<FailureDescription> failureDescriptions = new ArrayList<FailureDescription>();
        FailureDescription newFailureDescription = null;

        // Go through all failure occurrence descriptions of the internal
        // action:
        for (InternalFailureOccurrenceDescription description : internalAction
                .getInternalFailureOccurrenceDescriptions__InternalAction()) {
            newFailureDescription = new FailureDescription(MarkovSoftwareInducedFailureType.createInternalFailureType(
                    evaluationType, description.getSoftwareInducedFailureType__InternalFailureOccurrenceDescription()
                            .getId(), internalAction.getId()), description.getFailureProbability());
            addFailureDescription(failureDescriptions, newFailureDescription);
        }

        // Return the result:
        return failureDescriptions;
    }

    /**
     * Retrieves the list of required physical resources of a given internal action.
     * 
     * @param internalAction
     *            the internal action
     * @return the resulting list of resources
     */
    private List<ProcessingResourceDescriptor> getResourceDescriptors(final InternalAction internalAction) {

        // Create the resource list:
        ArrayList<ProcessingResourceDescriptor> resultList = new ArrayList<ProcessingResourceDescriptor>();

        // Go through the list of resource demands:
        for (ParametricResourceDemand demand : internalAction.getResourceDemand_Action()) {

            // Special case: ignore resource demands of type
            // "SystemExternalResource", as they have been internally introduced
            // by the dependency solver:
            if (demand.getRequiredResource_ParametricResourceDemand().getEntityName().equals("SystemExternalResource")) {
                continue;
            }

            // Get the descriptor that corresponds to the demand:
            ProcessingResourceDescriptor descriptor = transformationState.getDescriptor(demand, contextWrapper);
            if (descriptor == null) {
                LOGGER.error("Missing resource description for "
                        + demand.getRequiredResource_ParametricResourceDemand().getEntityName()
                        + " resource demand. Assume resource state = OK.");
                continue;
            }

            // Add the descriptor to the list:
            resultList.add(descriptor);
        }

        // Return the result:
        return resultList;
    }

    /**
     * Retrieves the list of physical resources contained within the given resource container.
     * 
     * @param resourceContainer
     *            the resource container
     * @param searchForRequiredResources
     *            if set to TRUE, only the resources required by this container will be returned
     * @return the resulting list of resources
     */
    private List<ProcessingResourceDescriptor> getResourceDescriptors(final ResourceContainer resourceContainer,
            final boolean searchForRequiredResources) {

        // Create the resource list:
        ArrayList<ProcessingResourceDescriptor> resultList = new ArrayList<ProcessingResourceDescriptor>();

        // Go through the list of specified resources:
        for (ProcessingResourceSpecification resource : resourceContainer
                .getActiveResourceSpecifications_ResourceContainer()) {

            // Check if this is a required resource:
            if (searchForRequiredResources && !resource.isRequiredByContainer()) {
                continue;
            }

            // Get the descriptor that corresponds to the specified resource:
            ProcessingResourceDescriptor descriptor = transformationState.getDescriptor(resource);
            if (descriptor == null) {
                LOGGER.error("Missing resource description for resource "
                        + resource.getActiveResourceType_ActiveResourceSpecification().getEntityName()
                        + " in container " + resourceContainer.getEntityName() + ". Assume resource state = OK.");
                continue;
            }

            // Add the descriptor to the list:
            resultList.add(descriptor);
        }

        // Return the result:
        return resultList;
    }

    /**
     * Retrieves the probability of a certain resource state.
     * 
     * @param descriptors
     *            the list of resources
     * @return the state probability
     */
    private double getResourceStateProbability(List<ProcessingResourceDescriptor> descriptors) {
        // All single resource states are independent; hence, the
        // overall state probability is the product over all single
        // state probabilities:
        double stateProbability = 1.0;
        for (ProcessingResourceDescriptor descriptor : descriptors) {
            stateProbability *= descriptor.getStateProbability(descriptor.getCurrentState());
        }
        return stateProbability;
    }

    /**
     * Returns a Markov chain that reflects a recovery action behaviour including its failure
     * handling alternatives.
     * 
     * @param action
     *            the surrounding recovery block action
     * @param behaviour
     *            the behaviour to evaluate
     * @return the resulting Markov chain
     */
    private MarkovChain processRecoveryActionBehaviour(RecoveryAction action, RecoveryActionBehaviour behaviour) {

        // Step 1: evaluate the behaviour itself:
        prefixes.add("Alternative(" + action.getRecoveryActionBehaviours__RecoveryAction().indexOf(behaviour) + ")");
        MarkovChain resultChain = caseResourceDemandingBehaviour(behaviour);
        prefixes.remove(prefixes.size() - 1);

        // Step 2: consider any existing failure handling alternatives if
        // the differentiation of failure types is fine-grained enough:
        if ((evaluationType != MarkovEvaluationType.SINGLE) && (evaluationType != MarkovEvaluationType.CLASSES)
                && (behaviour.getFailureHandlingAlternatives__RecoveryActionBehaviour().size() > 0)) {

            // Determine the chains and handled failure types of the
            // alternatives:
            List<MarkovChain> failureHandlingChains = new ArrayList<MarkovChain>();
            List<List<String>> failureTypeLists = new ArrayList<List<String>>();
            for (RecoveryActionBehaviour handlingAlternative : behaviour
                    .getFailureHandlingAlternatives__RecoveryActionBehaviour()) {
                failureTypeLists.add(getFailureTypeIds(handlingAlternative));
                failureHandlingChains.add(processRecoveryActionBehaviour(action, handlingAlternative));
            }

            // Append the handling alternatives to the current chain:
            markovBuilder.appendFailureHandlingMarkovChains(resultChain, failureHandlingChains, failureTypeLists,
                    optimize);
        }

        // Step 3: return the result:
        return resultChain;
    }

    /**
     * Sets a resource state according to the bit pattern of an numeric value.
     * 
     * @param descriptors
     *            the list of resources
     * @param number
     *            the numeric value
     */
    private void setResourceState(final List<ProcessingResourceDescriptor> descriptors, final long number) {

        // Iterate over all resources:
        for (int i = 0; i < descriptors.size(); i++) {
            MarkovResourceState state = (((number >> i) % 2) == 0) ? MarkovResourceState.OK : MarkovResourceState.NA;
            descriptors.get(i).setCurrentState(state);
        }
    }

}
