package edu.kit.ipd.sdq.eventsim.interpreter.seff.strategies;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.pcm.core.PCMRandomVariable;
import de.uka.ipd.sdq.pcm.repository.PassiveResource;
import de.uka.ipd.sdq.pcm.seff.AcquireAction;
import de.uka.ipd.sdq.pcm.seff.seff_performance.ParametricResourceDemand;
import edu.kit.ipd.sdq.eventsim.entities.Request;
import edu.kit.ipd.sdq.eventsim.entities.SimPassiveResource;
import edu.kit.ipd.sdq.eventsim.events.ResumeSeffTraversalEvent;
import edu.kit.ipd.sdq.eventsim.exceptions.unchecked.EventSimException;
import edu.kit.ipd.sdq.eventsim.interpreter.seff.IRequestTraversalInstruction;
import edu.kit.ipd.sdq.eventsim.interpreter.seff.ISeffTraversalStrategy;
import edu.kit.ipd.sdq.eventsim.interpreter.seff.instructions.RequestTraversalInstructionFactory;
import edu.kit.ipd.sdq.eventsim.interpreter.state.RequestState;
import edu.kit.ipd.sdq.eventsim.util.PCMEntityHelper;

/**
 * This traversal strategy is responsible for {@link AcquireAction}s.
 * 
 * @author Philipp Merkle
 * 
 */
public class AcquireActionTraversalStrategy implements ISeffTraversalStrategy<AcquireAction> {

    private static Logger logger = Logger.getLogger(AcquireActionTraversalStrategy.class);

    private static boolean displayedExperimentalFeatureWarning = false;

    /**
     * {@inheritDoc}
     */
    @Override
    public IRequestTraversalInstruction traverse(final AcquireAction action, final Request request,
            final RequestState state) {
        // per default this actions acquires a single passive resource instance
        int instancesToBeAcquired = 1;

        if (!action.getResourceDemand_Action().isEmpty()) {
            // BEGIN EXPERIMENTAL -------------------------------------------------------------------------------------
            if (!displayedExperimentalFeatureWarning) {
                logger.warn("It appears you are using a parametric resource demand to specify the number of passive "
                        + "resource instances to be acquired. Notice that this feature is experimental due to conceptual "
                        + "issues. For details see https://sdqbuild.ipd.kit.edu/jira/browse/PALLADIOINC-6.");
                // prevent repeated warnings
                displayedExperimentalFeatureWarning = true;
            }

            // assume that the number of instances to be acquired is specified within the first demand
            if (action.getResourceDemand_Action().size() > 1) {
                logger.warn("Found multiple parametric resource demands for " + PCMEntityHelper.toString(action) + ". "
                        + "Will interpret the first resource demand as the number of resource instances to be "
                        + "acquired and ignore the rest.");
            }

            instancesToBeAcquired = evaluateResourceDemand(action.getResourceDemand_Action().get(0), state);
            // END EXPERIMENTAL ---------------------------------------------------------------------------------------
        }

        final PassiveResource passiveResouce = action.getPassiveresource_AcquireAction();

        final SimPassiveResource res = state.getComponent().getPassiveResource(passiveResouce);
        final boolean acquired = res.acquire(request.getSimulatedProcess(), instancesToBeAcquired, false,
                action.getTimeoutValue());

        if (acquired) {
            return RequestTraversalInstructionFactory.traverseNextAction(action.getSuccessor_AbstractAction());
        } else {
            request.passivate(new ResumeSeffTraversalEvent(request.getModel(), state));

            // here, it is assumed that the passive resource grants access to waiting processes as soon as the requested
            // capacity becomes available. Thus, we do not need to acquire the passive resource again as this will be
            // done within the release method. Accordingly the traversal resumes with the successor of this action.
            return RequestTraversalInstructionFactory.interruptTraversal(action.getSuccessor_AbstractAction());
        }
    }

    private int evaluateResourceDemand(final ParametricResourceDemand demand, final RequestState state) {
        PCMRandomVariable demandSpecification = demand.getSpecification_ParametericResourceDemand();
        try {
            return Integer
                    .parseInt(state.getStoExContext().evaluate(demandSpecification.getSpecification()).toString());
        } catch (NumberFormatException e) {
            throw new EventSimException(
                    "Evaluating parametric resource demand did not yield an Integer as required. Resource "
                            + "demand specification was \"" + demandSpecification.getSpecification() + "\".");
        }
    }

}
