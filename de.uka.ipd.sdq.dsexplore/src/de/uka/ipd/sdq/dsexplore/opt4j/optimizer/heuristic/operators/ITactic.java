package de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators;

import java.util.List;

import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEIndividual;
import de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.EvaluationAspect;
import de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.Dimension;

/**
 * 
 * @author martens, beyer
 *
 */
public interface ITactic {

	/**
	 * Checks if a certain aspect of a dimension is improved, if the
	 * heuristic is applied. The specification is necessary, if the 
	 * heuristics are applied based on their bound violations.
	 * @param dimension The dimension to check
	 * @param aspect The evaluation aspect of the dimension to check
	 * @return {@code true}, if the {@code EvaluationAspect} of the {@code dimension}, i.e. quality attribute,
	 * of a individual improves after applying the heuristic<br>{@code false}, otherwise
	 */
	public boolean improves(Dimension dimension, EvaluationAspect aspect);
	
	/**
	 * Checks if a certain aspect of a dimension is <em>not</em> improved, if the
	 * heuristic is applied. The specification is necessary, if the 
	 * heuristics are applied based on their bound violations.
	 * 
	 * @param dimension The dimension to check
	 * @param aspect The evaluation aspect of the dimension to check
	 * @return {@code true}, if the {@code EvaluationAspect} of the {@code dimension}, i.e. quality attribute,
	 * of a individual <em>does not</em> improve after applying the heuristic<br>{@code false}, otherwise
	 * @see #improves(Dimension, EvaluationAspect)
	 */
	public boolean doesNotImprove(Dimension dimension, EvaluationAspect aspect);
	
	/**
	 * Generates improved individuals based on heuristic and given
	 * individual.
	 * Candidates must only use model objects from the design decision model, 
	 * they must not refer to model elements from the PCM model (as these may not be 
	 * identical Java objects even if they represent the same EMF object).   
	 * 
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
