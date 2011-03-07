package de.uka.ipd.sdq.pcmsolver.transformations.pcm2markov;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.markov.MarkovChain;
import de.uka.ipd.sdq.markov.State;
import de.uka.ipd.sdq.markov.StateType;

public class TransformationResults {

	/**
	 * A logger to give detailed information about the PCM instance traversal.
	 */
	private static Logger logger = Logger.getLogger(TransformationResults.class
			.getName());

	private double successProbability = 0;
	private Map<String, Double> failureTypeProbabilities = new HashMap<String, Double>();
	private MarkovBuilder markovBuilder = new MarkovBuilder();

	public void addFinalStateProbability(State state, double probability) {
		if (state.getType().equals(StateType.DEFAULT)
				|| state.getType().equals(StateType.START)) {
			throw new MarkovException(
					"Only final states probabilities allowed in the transformation result.");
		}
		if (probability < 0 || probability > 1) {
			throw new MarkovException(
					"Illegal probability. The value must be in [0,1].");
		}

		if (state.getType().equals(StateType.SUCCESS)) {
			successProbability += probability;
		} else if (state.getType().equals(StateType.FAILURE)) {
			String failureType = markovBuilder.getFailureTypeLabelValue(state);

			Double failureTypeProbability = getFinalStateProbability(state);

			failureTypeProbability += probability;

			failureTypeProbabilities.put(failureType, failureTypeProbability);
		}
	}

	private double getFailureStateProbability(State state) {
		String failureType = markovBuilder.getFailureTypeLabelValue(state);
		if (failureType == null) {
			throw new MarkovException(
					"Failure state has no failure type label.");
		}

		Double failureTypeProbability = failureTypeProbabilities
				.get(failureType);
		if (failureTypeProbability == null)
			failureTypeProbability = 0.0;

		return failureTypeProbability;
	}

	public double getFinalStateProbability(State state) {
		if (state.getType().equals(StateType.DEFAULT)
				|| state.getType().equals(StateType.START)) {
			throw new MarkovException(
					"Only final states probabilities allowed in the transformation result.");
		}

		if (state.getType().equals(StateType.SUCCESS)) {
			return successProbability;
		} else {
			return getFailureStateProbability(state);
		}
	}

	public double getSuccessProbability() {
		return successProbability;
	}
	public Double getFailureTypeProbability(String failureType) {
		return failureTypeProbabilities.get(failureType); 
	}
	public Collection<String> getAllFailureTypes() {
		return failureTypeProbabilities.keySet();
	}
	public void addSubChainResults(MarkovChain chain, double[][] probabilities, double subchainProb) {
		// Get the indices of the Start and Success States:
		int index_start = findIndex(chain, StateType.START);
		if (index_start < 0) {
			throw new MarkovException("Start state not found in markov chain.");
		}
		
		int index_success = findIndex(chain, StateType.SUCCESS);
		if(index_success<0) {
			throw new MarkovException("Success state not found in markov chain.");
		}
		
		addFinalStateProbability(chain.getStates().get(index_success), subchainProb * probabilities[index_start][index_success]);
		
		for(int i=0; i<chain.getStates().size(); ++i) {
			State state=chain.getStates().get(i);
			
			if(!state.getType().equals(StateType.FAILURE)) continue;
			addFinalStateProbability(state, subchainProb*probabilities[index_start][i]);
		}
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
	public int findIndex(MarkovChain markovChain, StateType stateType) {

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
