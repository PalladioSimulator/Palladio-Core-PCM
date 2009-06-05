package de.uka.ipd.sdq.pcmsolver.markovsolver;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.markov.MarkovChain;
import de.uka.ipd.sdq.markov.State;
import de.uka.ipd.sdq.markov.StateType;
import de.uka.ipd.sdq.pcmsolver.transformations.pcm2markov.MarkovSeffVisitor;

/**
 * This class solves Markov Chains in the sense that it calculates the
 * probability of getting from the Start State to the Success State (but not
 * into the Failure State).
 * 
 * @author brosch
 * 
 */
public class MarkovSolver {

	/**
	 * A logger to give detailed information about the PCM instance traversal.
	 */
	private static Logger logger = Logger.getLogger(MarkovSolver.class
			.getName());

	/**
	 * Calculates the probability for the given Markov Chain to reach the
	 * Success State starting from the Start State.
	 * 
	 * @param markovChain
	 *            the given Markov Chain
	 * @return the probability of reaching the Success State
	 */
	public double solve(MarkovChain markovChain) {

		// Do the logging:
		logger.debug("Solving Markov Chain [" + markovChain.getName() + "]");

		// Get the indices of the Start and Success States:
		int index_start = findIndex(markovChain, StateType.START);
		int index_success = findIndex(markovChain, StateType.SUCCESS);
		if ((index_start < 0) || (index_success < 0)) {
			return 0.0;
		}

		// Calculate the transition matrix:
		double[][] transitionMatrix = new double[markovChain.getStates().size()][markovChain
				.getStates().size()];

		// Take over transition probabilities into the transition matrix:
		for (int i = 0; i < markovChain.getTransitions().size(); i++) {
			int index_from = markovChain.getStates().indexOf(
					markovChain.getTransitions().get(i).getFromState());
			int index_to = markovChain.getStates().indexOf(
					markovChain.getTransitions().get(i).getToState());
			transitionMatrix[index_from][index_to] = markovChain
					.getTransitions().get(i).getProbability();
		}

		// Calculate (Identity Matrix - Transition Matrix):
		for (int i = 0; i < transitionMatrix.length; i++) {
			for (int j = 0; j < transitionMatrix[i].length; j++) {
				transitionMatrix[i][j] = ((i == j)? 1 : 0) - transitionMatrix[i][j];
			}
		}
		
		// Calculate the inverse matrix:
		double[][] resultMatrix = Inverse.invert(transitionMatrix);

		// Return the result:
		return resultMatrix[index_start][index_success];
	}

	/**
	 * Finds the index of the fist State within a given Markov Chain that has
	 * the given StateType.
	 * 
	 * @param markovChain
	 *            the Markov Chain
	 * @param stateType
	 *            the StateType
	 * @return the Success State
	 */
	private int findIndex(MarkovChain markovChain, StateType stateType) {

		// Go through all states of the Markov Chain:
		for (int i = 0; i < markovChain.getStates().size(); i++) {
			if (markovChain.getStates().get(i).getType().equals(stateType)) {
				return i;
			}
		}

		// Nothing found?
		logger.error("Markov Chain has no state of type "
				+ stateType.toString());
		return -1;
	}
}
