package de.uka.ipd.sdq.pcmsolver.transformations.pcm2markov;

import markov.MarkovChain;

import org.apache.log4j.Logger;

import de.uka.ipd.pcmsolver.markovsolver.MarkovSolver;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.seff.LoopAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingSEFF;
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
	 * The ContextWrapper provides easy access to the decorations of the solved
	 * PCM instance.
	 */
	private ContextWrapper contextWrapper;

	/**
	 * The Markov Builder is used to create Markov Chain instances.
	 */
	private MarkovBuilder markovBuilder = new MarkovBuilder();

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
	public MarkovSeffVisitor(final ContextWrapper wrapper) {
		contextWrapper = wrapper;
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
		logger.info("Visit ResourceDemandingBehaviour");

		// Initialize a new Markov Chain that will represent this Behaviour:
		MarkovChain aggregateMarkovChain = markovBuilder
				.initNewMarkovChain("behaviour");

		// Go through the chain of actions that constitute this RDSEFF. Each
		// action is expected to create its own specific Markov Chain. Each
		// specific chain will then be incorporated into the aggregate RDSEFF
		// Markov Chain:
		AbstractAction action = (StartAction) EMFHelper.getObjectByType(
				behaviour.getSteps_Behaviour(), StartAction.class);
		while (action != null) {
			MarkovChain specificMarkovChain = (MarkovChain) doSwitch(action);
			markovBuilder.incorporateMarkovChain(aggregateMarkovChain,
					specificMarkovChain);
			action = action.getSuccessor_AbstractAction();
		}

		// Return the resulting Markov Chain:
		return aggregateMarkovChain;
	}

	/**
	 * All Actions in the ResourceDemandingSEFF are traversed to build an
	 * associated Markov Chain.
	 * 
	 * @param seff
	 *            the ReaourceDemandingSEFF
	 * @return the resulting Markov Chain
	 */
	@Override
	public MarkovChain caseResourceDemandingSEFF(
			final ResourceDemandingSEFF seff) {

		// Do the logging:
		logger.info("Visit ResourceDemandingSEFF ["
				+ seff.getDescribedService__SEFF().getServiceName() + "]");

		// Initialize a new Markov Chain that will represent this RDSEFF:
		MarkovChain aggregateMarkovChain = markovBuilder
				.initNewMarkovChain(seff.getDescribedService__SEFF()
						.getServiceName());

		// Go through the chain of actions that constitute this RDSEFF. Each
		// action is expected to create its own specific Markov Chain. Each
		// specific chain will then be incorporated into the aggregate RDSEFF
		// Markov Chain:
		AbstractAction action = (StartAction) EMFHelper.getObjectByType(seff
				.getSteps_Behaviour(), StartAction.class);
		while (action != null) {
			MarkovChain specificMarkovChain = (MarkovChain) doSwitch(action);
			markovBuilder.incorporateMarkovChain(aggregateMarkovChain,
					specificMarkovChain);
			action = action.getSuccessor_AbstractAction();
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
		logger.info("Visit StartAction [" + startAction.getEntityName() + "]");

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
		logger.info("Visit InternalAction [" + internalAction.getEntityName()
				+ "]");

		return markovBuilder.initInternalMarkovChain(internalAction
				.getEntityName(), internalAction.getFailureProbability());
	}

	/**
	 * For a LoopAction, first the Markov Chain of the body behaviour is built
	 * and solved. The result is then inserted into a new Markov Chain that has
	 * one State for each of the possible iteration count of the loop.
	 * 
	 * @param loopAction
	 *            the LoopAction
	 * @return the resulting Markov Chain
	 */
	@Override
	public MarkovChain caseLoopAction(final LoopAction loopAction) {

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
		return markovBuilder.initLoopMarkovChain(loopAction.getEntityName(),
				pmf, resultInnerMarkovChain);
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
		logger.info("Visit StopAction [" + stopAction.getEntityName() + "]");

		return markovBuilder.initNewMarkovChain(stopAction.getEntityName());
	}
}
