package de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators;

import java.util.List;

import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEIndividual;

/**
 * 
 * @author martens, beyer
 *
 */
public interface ITactic {
	/**
	 * Matches the individual against the conditions of the
	 * heuristic.
	 * @param i The individual that should be matched
	 * @return True if heuristic is applicable, false otherwise
	 */
	public boolean doesMatchPrecondition(DSEIndividual i);
	
	/**
	 * Generates improved individuals based on heuristic and given
	 * individual.
	 * @param i The individual that should be improved
	 * @param resultsCache 
	 * @return Collection of improved individuals
	 */
	public List<TacticsResultCandidate> getHeuristicCandidates(DSEIndividual i, UtilisationResultCacheAndHelper resultsCache); 
	
	/**
	 * Returns the number of generated candidates of this instance
	 * @return Number of generated candidates
	 */
	public int getNumberOfGeneratedCandidates();
	
	/**
	 * Weight of heuristic determines the probability of its
	 * candidates being selected
	 * @return
	 */
	public double getHeuristicWeight();
}
